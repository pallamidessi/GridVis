package gridvis;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Traits extends JPanel{
	private int t1;
	private int t2;
	private int tmin;
	private int tmax;
	private ArrayList<Integer> Liste_echange;
	
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g){
		
		g.setColor(Color.black);
		g.drawLine(50, 50, 350, 50);
		
		AffineTransform fontAT = new AffineTransform();

	    Font theFont = g.getFont();

	    // Derive a new font using a rotatation transform
	    fontAT.rotate(90 * java.lang.Math.PI/180);
	    Font theDerivedFont = theFont.deriveFont(fontAT);
	    g.clearRect(0, 0, 500, 500);
	    
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
	    
	    System.out.println("t1: " + t1  +" t2: "+ t2 +" size: "+Liste_echange.size() );
	    for(int k=0;k<Liste_echange.size();k++)
	    {   
	    	if(Liste_echange.get(k)<=t2 && Liste_echange.get(k)>=t1)
	    	{  
	    		g.drawLine((int)
	    				(((float)(Liste_echange.get(k)-tmin)/(float)(tmax-tmin))*300+50),
	    				40,
	    				(int)
	    				(((float)(Liste_echange.get(k)-tmin)/(float)(tmax-tmin))*300+50),
	    				60);
	    		//g.drawString(String.valueOf((int)
	    				//(((float)(Liste_echange.get(k)-tmin)/(float)(tmax-tmin))*300+50)) ,
	    				//(int)
	    				//(((float)(Liste_echange.get(k)-tmin)/(float)(tmax-tmin))*300+50),
	    				//(int)70);
	    	}
	    }
	    g.setFont(theFont);
	
	}

	void set_params(int v1, int v2,int v3, int v4, ArrayList<Integer> l)
	{
		t1=v1;
		t2=v2;
		tmin=v3;
		tmax=v4;
		Liste_echange=l;
	}
}
