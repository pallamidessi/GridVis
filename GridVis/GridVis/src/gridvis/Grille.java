package gridvis;

import java.awt.Graphics;


import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;


import org.gicentre.utils.colour.ColourTable;


import java.awt.Color;

import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;

import java.util.ArrayList;
import java.util.List;
 
public class Grille extends JPanel {
	
	private List<Integer> nb;
	private List<Integer> moy;
	private List<Float> moyfit;
	private List<Float> ordifit;
	private List<String> workers;
	private int max;
	private int maxtime;
	private int nbOrdi;
	private int coul;
	private int fitnessactive;
	private DataProbleme dp;
	private int t1;
	private int t2;
	private int fst;
	private int tmin;
	private int tmax;
	public float maxfit;
	public float minfit;
	private Envoie env;
	public static final float[] COLOR_TIME_START = new float[]{100f/255f,100f/255f	, 1f, .5f};
	public static final float[] COLOR_TIME_END 	 = new float[]{1f,.5f ,.05f, .5f};
	public static final float[] COLOR_FIT_MIN = new float[]{1f, 0f	, 0f, .5f};
	public static final float[] COLOR_FIT_MAX 	 = new float[]{1f,1f ,0.8f, .5f};

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g){
		
	final float tailleCase=((float)500)/((float)nbOrdi);
    final Graphics2D g2d = (Graphics2D)g;
    
     
	GradientPaint gl = new GradientPaint(0, 10, Color.black, 0, 100, Color.white, true);               
    g2d.setPaint(gl);
    g2d.fillRect(0, 0, 20, 100);
    GradientPaint gl2 = new GradientPaint(0, 110, Color.orange, 0, 200, Color.blue, true);               
    g2d.setPaint(gl2);
    g2d.fillRect(0, 110, 20, 100);
    GradientPaint gl3 = new GradientPaint(0, 220, Color.red, 0, 310, Color.yellow, true);               
    g2d.setPaint(gl3);
    g2d.fillRect(0, 220, 20, 100);
    this.setVisible(true);
    g2d.setColor(new Color(0,0,0));
    g2d.drawString("Max", 25 , 10);
    g2d.setColor(new Color(0,0,0));
    g2d.drawString("Min", 25 , 100);
    g2d.setColor(new Color(0,0,0));
    g2d.drawString("tMax", 25 , 120);
    g2d.setColor(new Color(0,0,0));
    g2d.drawString("tMin", 25 ,200);
    g2d.setColor(new Color(0,0,0));
    g2d.drawString("fMax", 25 , 230);
    g2d.setColor(new Color(0,0,0));
    g2d.drawString("fMin", 25 ,310);
    
    g2d.setColor(new Color(255,255,255));
    g2d.fillRect(60,10,500,500);
    g2d.setColor(new Color(0,0,0));
    g2d.drawRect(58, 8, 502, 502);
    
    float[] color;
	
    
	float frac;
	float fracfit;
	
	final ColourTable cTable = new ColourTable();
	cTable.addContinuousColourRule(0/1, (int)(COLOR_TIME_START[0]* 255), (int)(COLOR_TIME_START[1]* 255), (int)(COLOR_TIME_START[2]* 255));
	cTable.addContinuousColourRule(1/1, (int)(COLOR_TIME_END[0]* 255), (int)(COLOR_TIME_END[1]* 255), (int)(COLOR_TIME_END[2]* 255));
    
	final ColourTable cTablef = new ColourTable();
	cTablef.addContinuousColourRule(0/1, (int)(COLOR_FIT_MIN[0]* 255), (int)(COLOR_FIT_MIN[1]* 255), (int)(COLOR_FIT_MIN[2]* 255));
	cTablef.addContinuousColourRule(1/1, (int)(COLOR_FIT_MAX[0]* 255), (int)(COLOR_FIT_MAX[1]* 255), (int)(COLOR_FIT_MAX[2]* 255));
    
	
	g2d.setColor(new Color(0,0,0));
	if(tailleCase < 10)
	g2d.setFont(new Font("Helvetica", Font.PLAIN, (int)tailleCase));
	else g2d.setFont(new Font("Helvetica", Font.PLAIN, 10));
	g2d.drawString("Sending Machines",70+nbOrdi*tailleCase,8);
	if(fitnessactive==1 && dp.fitness==1)
	{	
	   g2d.drawString("Fitness Max : " + maxfit, 10 , 100+nbOrdi*tailleCase );
	   g2d.drawString("Fitness Min : " + minfit, 10 , 120+nbOrdi*tailleCase );
	}
	
	AffineTransform fontAT = new AffineTransform();

    Font theFont = g2d.getFont();
    // Derive a new font using a rotatation transform
    fontAT.rotate( java.lang.Math.PI/6);
    Font theDerivedFont = theFont.deriveFont(fontAT);
    g2d.setFont(theDerivedFont);
    
	g2d.drawString("Receiving Machines",50,30+nbOrdi*tailleCase);
	
	
	
    for(int i=0;i<nbOrdi;i++)
    { for(int j=0;j<nbOrdi;j++)
    	{
    	
    	
    	
    		color = new float[]{.5f,.5f,.5f,1f};
    		
    	
    	
    	
    	
    	if(max != 0)
    	{
    	float nc= (float)(nb.get(i*(nbOrdi)+j).intValue())/(float)(max);
    	if(coul==0&&(fitnessactive==0||dp.fitness==0))
    	g2d.setColor(new Color(255-(int)(nc*255),255-(int)(nc*255),255-(int)(nc*255)));
    	if(coul==1)
    		{   
    			frac = (float)(moy.get(i*(nbOrdi)+j)) / (float)(maxtime);
    			color = _getColor(cTable, frac);	
    			g2d.setColor(new Color(color[0]*(1-nc),color[1]*(1-nc),color[2]*(1-nc)));
    				if(nc==0) g2d.setColor(Color.white);	
    		}
    	if(fitnessactive==1 && dp.fitness==1)
    		{	
    		   
    			fracfit = (maxfit- moyfit.get(i*(nbOrdi)+j)) /(maxfit-minfit);
    			color = _getColor(cTablef, fracfit);
    			g2d.setColor(new Color(color[0]*(1-nc),color[1]*(1-nc),color[2]*(1-nc)));
    			if(nc==0) g2d.setColor(Color.white);
    		}
    	}
    	
    	
    	g2d.fillRect(60+(int)(j*tailleCase),10+(int)(i*tailleCase),(int)tailleCase,(int)tailleCase);
    	}
    	g2d.setColor(new Color(0,0,0));
    	if(tailleCase < 15)
    	g2d.setFont(new Font("Helvetica", Font.PLAIN, (int)tailleCase));
    	else g2d.setFont(new Font("Helvetica", Font.PLAIN, 15));
    	g2d.drawString(workers.get(i),70+nbOrdi*tailleCase,5+(i+1)*tailleCase);
    	
    	
    	fontAT = new AffineTransform();

	    theFont = g2d.getFont();
	    // Derive a new font using a rotatation transform
	    fontAT.rotate(java.lang.Math.PI/6);
	    theDerivedFont = theFont.deriveFont(fontAT);
	    g2d.setFont(theDerivedFont);
	    
    	g2d.drawString(workers.get(i),50+(i+1)*tailleCase,30+nbOrdi*tailleCase);
    	
    	if(fitnessactive==1 && dp.fitness==1)
		{	
    		ordifit=dp.get_ordifit(t1,t2);
		    for(int m=0;m<nbOrdi;m++)
		    {	
		    	fracfit = (maxfit- ordifit.get(m)) /(maxfit-minfit);
		    	System.out.println(maxfit + " " + minfit + " " + ordifit.get(m));
		    	color = _getColor(cTablef, fracfit);
		    	g2d.setColor(new Color(color[0],color[1],color[2]));
		    	if (ordifit.get(m)==0) g2d.setColor(Color.white);
		    	g2d.fillOval(60+(int)(m*tailleCase),10+(int)(m*tailleCase),(int)tailleCase,(int)tailleCase);
		    }
		}
    }
   try
   {
	   env.setVisible(false);
	    // instructions pouvant déclencher des exceptions
	    // dérivant de std::exception
	}
	catch ( Exception e )
	{
	    
	}	
   
   //env.setVisible(true);
   
   env= new Envoie(0,1,t1,t2,tmin,tmax,new ArrayList<Integer>(),new ArrayList<Float>(),dp.fitness);
    
   this.addMouseListener( new MouseListener() {
	   
		@Override
		public void mouseClicked(MouseEvent arg0) {
				if(arg0.getX()<60+tailleCase*nbOrdi && arg0.getX()>60 
					&& arg0.getY()<10+tailleCase*nbOrdi && arg0.getY()>10)
					{
						int i = (int)((arg0.getX()-60)/tailleCase);
						int j = (int)((arg0.getY()-10)/tailleCase);
						ArrayList<Integer> Liste_echange= new ArrayList<Integer>();
						Liste_echange=dp.get_echange(j,i);
						
							
							
						
					
						try
						   {
							if (dp.fitness==0)
							{
							env.set_params(j,i,t1,t2,tmin,tmax,Liste_echange);
							env.setVisible(true);
						    }
							
							else
							{
								ArrayList<Float> Liste_fitness=new ArrayList<Float>();
								Liste_fitness=dp.get_fitness(j,i);
								env.set_params(j, i, t1, t2, tmin, tmax, Liste_echange, Liste_fitness,
										maxfit,minfit);
										
								
								env.setVisible(true);
							}
							   
							}
							catch ( Exception e )
							{
							    
							}

						
					}
				else {if(arg0.getX()>60+tailleCase*nbOrdi && arg0.getX()< 100+tailleCase*nbOrdi 
						&& arg0.getY()<10+tailleCase*nbOrdi && arg0.getY()>10)
						{
							int j = (int)((arg0.getY()-10)/tailleCase);
							ArrayList<Integer> Liste_echange= new ArrayList<Integer>();
							for(int i=0;i<nbOrdi;i++)
							{
							Liste_echange.addAll(dp.get_echange(j,i));
							}
								
							try
							   {
								if (dp.fitness==0)
								{
								env.set_params(j,-1,t1,t2,tmin,tmax,Liste_echange);
								env.setVisible(true);
							    }
								
								else
								{
									ArrayList<Float> Liste_fitness=new ArrayList<Float>();
									for(int i=0;i<nbOrdi;i++)
									{
									Liste_fitness.addAll(dp.get_fitness(j,i));
									}
									env.set_params(j, -1, t1, t2, tmin, tmax, Liste_echange, Liste_fitness,
											maxfit,minfit);
									env.getContentPane().repaint();
									env.setVisible(true);
								}
								   
								}
								catch ( Exception e )
								{
								    
								}

							
							}
				
				
				else{
							if(arg0.getX()<60+tailleCase*nbOrdi && arg0.getX()> 60 
									&& arg0.getY()>10+tailleCase*nbOrdi && arg0.getY()<50 + tailleCase*nbOrdi)
								{
									int i = (int)((arg0.getX()-60)/tailleCase);
									ArrayList<Integer> Liste_echange= new ArrayList<Integer>();
									for(int j=0;j<nbOrdi;j++)
									{
										Liste_echange.addAll(dp.get_echange(j,i));
									}
								
									try
									{
										if (dp.fitness==0)
										{
											env.set_params(-1,i,t1,t2,tmin,tmax,Liste_echange);
											env.setVisible(true);
										}
								
										else
										{
											ArrayList<Float> Liste_fitness=new ArrayList<Float>();
											for(int j=0;j<nbOrdi;j++)
											{
												Liste_fitness.addAll(dp.get_fitness(j,i));
											}
											env.set_params(-1, i, t1, t2, tmin, tmax, Liste_echange, Liste_fitness,
													maxfit,minfit);
											env.getContentPane().repaint();
											env.setVisible(true);
										}
								   
									}
										catch ( Exception e )
										{
								    
										}	

							
								}
						}
				}

			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
   }
		   ); 
                                     
	}	
		
	

	public void set_env(Envoie e){env = e;}
	
public void setCoul(int b)
{
	coul = b;
}

public void set_dp(DataProbleme datap, int tmi,int tma)
{
	t1=tmi;
	t2=tma;
	tmin=tmi;
	tmax=tma;		
	dp=datap;
}

public void set_t1(int tmi)
{
t1=tmi;	
}

public void set_t2(int tma)
{
t2=tma;	
}

public void setParams(int n, List<Integer> ln,List<Integer> lm,List<Float> lmf ,int m, int mt,List<String> wk)
{   workers =wk;
	nb=ln;
	moy=lm;
	moyfit=lmf;
	nbOrdi=n;
	max=m;
	maxtime=mt;
}
public Envoie get_env(){return env;}
public void traits_visible(){env.setVisible(true);}

protected float[] _getColor(ColourTable ct, float r)
{
	int colo = ct.findColour(r);
	int B_MASK = 255;
	int G_MASK = 255<<8; //65280 
	int R_MASK = 255<<16; //16711680
			
	float[] color = new float[]{0f, 0f, 0f,1f};
	color[0] = ((colo & R_MASK)>>16) / 255f;
	color[1] = ((colo & G_MASK)>>8) / 255f;
	color[2] = (colo & B_MASK) / 255f;			

	return color;			
}

public void set_minimaxfit(float mifit,float mafit)
{
	minfit=mifit;
	maxfit=mafit;
}


public void setFitnessactive(int fitness) {
	fitnessactive=fitness;
	
}


}