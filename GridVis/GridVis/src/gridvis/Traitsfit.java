package gridvis;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.gicentre.utils.colour.ColourTable;

public class Traitsfit extends JPanel{
	private int t1;
	private int t2;
	private int tmin;
	private int tmax;
	private float maxfit;
	private float minfit;
	private ArrayList<Integer> Liste_echange;
	private ArrayList<Float> Liste_fitness;
	public static final float[] COLOR_FIT_MIN = new float[]{1f, 0f	, 0f, .5f};
	public static final float[] COLOR_FIT_MAX 	 = new float[]{1f,1f ,0.8f, .5f};
	
	
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g){
		
		float[] color;
		final ColourTable cTable = new ColourTable();
		cTable.addContinuousColourRule(0/1, (int)(COLOR_FIT_MIN[0]* 255), (int)(COLOR_FIT_MIN[1]* 255), (int)(COLOR_FIT_MIN[2]* 255));
		cTable.addContinuousColourRule(1/1, (int)(COLOR_FIT_MAX[0]* 255), (int)(COLOR_FIT_MAX[1]* 255), (int)(COLOR_FIT_MAX[2]* 255));
	    
		g.clearRect(0, 0, 500, 500);
		
		g.setColor(Color.black);
		g.drawLine(50, 50, 350, 50);
		
		AffineTransform fontAT = new AffineTransform();

	    Font theFont = g.getFont();

	    // Derive a new font using a rotatation transform
	    fontAT.rotate(90 * java.lang.Math.PI/180);
	    Font theDerivedFont = theFont.deriveFont(fontAT);

	    
	    g.setFont(theDerivedFont);

	    
	    g.drawString(String.valueOf(tmin) , (int)50, (int)70);
	    g.drawString(String.valueOf(tmax) , (int)350, (int)70);
	    // put the original font back
	    
	    g.drawLine((int)
				(((float)(t1-tmin)/(float)(tmax-tmin))*300+50),
				30,
				(int)
				(((float)(t1-tmin)/(float)(tmax-tmin))*300+50),
				70);
	    g.drawLine((int)
				(((float)(t2-tmin)/(float)(tmax-tmin))*300+50),
				30,
				(int)
				(((float)(t2-tmin)/(float)(tmax-tmin))*300+50),
				70);
	    
	    
	    for(int k=0;k<Liste_echange.size();k++)
	    {   
	    	if(Liste_echange.get(k)<=t2 && Liste_echange.get(k)>=t1)
	    	{  if(maxfit!=minfit)
	    		{
	    		float nt= (maxfit-Liste_fitness.get(k))/(maxfit-minfit);
	    		
	    		color = new float[]{.5f,.5f,.5f,1f};
	    		color = _getColor(cTable, nt);
	    	
	    		
	    			g.setColor(new Color(color[0],color[1],color[2]));
	    					
	    			
	    	
	    		
	    		
	    		g.drawLine((int)
	    				(((float)(Liste_echange.get(k)-tmin)/(float)(tmax-tmin))*300+50),
	    				50 - (int)(30*(1-nt))-10,
	    				(int)
	    				(((float)(Liste_echange.get(k)-tmin)/(float)(tmax-tmin))*300+50),
	    				50 + (int)(30*(1-nt))+10);
	    		}
	    	}
	    }
	    g.setFont(theFont);
	
	}

	void set_params(int v1, int v2,int v3, int v4, ArrayList<Integer> l,
			ArrayList<Float> lf,float maxf,float minf)
	{	
		t1=v1;
		t2=v2;
		tmin=v3;
		tmax=v4;
		Liste_echange=l;
		Liste_fitness=lf;
		maxfit=maxf;
		minfit=minf;
	}
	
	
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
}