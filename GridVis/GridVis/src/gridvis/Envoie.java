package gridvis;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Envoie extends JFrame{
	
	private int j;
	private int i;
	private int t1;
	private int t2;
	private int tmin;
	private int tmax;
	private ArrayList<Integer> Liste_echange;
	private Traits traits;
	private Traitsfit traitsfit;
	private float maxfit;
	private float minfit;
	public int fitness=0;
	private ArrayList<Float> Liste_fitness;
	
	
	public Envoie(int abs,int ord,int tv1,int tv2,int tv3,int tv4,ArrayList<Integer> l,ArrayList<Float> lf, int fit)
	{    
		i=abs;
		j=ord;
		t1=tv1;
		t2=tv2;
		tmin=tv3;
		tmax=tv4;
		fitness=fit;
		Liste_echange=l;
		Liste_fitness=lf;
		
		 this.setBackground( Color.blue);
		 this.setTitle("Envoie de la machine " +i+ " vers la machine " + j);
	     this.setSize(400, 300);
	     this.setLocationRelativeTo(null);
	     if(fitness==0){
		 Traits t=new Traits();
		 t.set_params(t1,t2,tmin,tmax,Liste_echange);
		 //t.repaint();
		 traits=t;
		 this.setContentPane(traits);
	     }
	     else
	     {   
	    	 
	    	 Traitsfit t=new Traitsfit();
			 t.set_params(t1,t2,tmin,tmax,Liste_echange,Liste_fitness,maxfit,minfit);
			 //t.repaint();
			 traitsfit=t;
			 this.setContentPane(traitsfit);
	     } 
		 
	}
	
	
	void set_params(int abs,int ord,int tv1,int tv2,int tv3,int tv4,ArrayList<Integer> l)
	{   
		
		i=abs;
		j=ord;
		
			if((i >= 0) &&(j >= 0))
				this.setTitle("Individuals sent from the machine " +i+ " to the machine " + j);
				if(i<0)
					this.setTitle("Individuals received by the machine " + j);
				if(j<0)
					this.setTitle("Individuals sent by the machine " + i);
		t1=tv1;
		t2=tv2;
		tmin=tv3;
		tmax=tv4;
		Liste_echange=l;
		traits.set_params(t1,t2,tmin,tmax,Liste_echange);
		traits.repaint();
	}
	
	void set_params(int abs,int ord,int tv1,int tv2,int tv3,int tv4,ArrayList<Integer> l
			,ArrayList<Float> lf,float maxf, float minf)
	{   
		fitness=1;
		i=abs;
		j=ord;
		if((i >= 0) &&(j >= 0))
			this.setTitle("Individuals sent from the machine " +i+ " to the machine " + j);
			if(i<0)
				this.setTitle("Individuals recieved by the machine " + j);
			if(j<0)
				this.setTitle("Individuals sent by the machine " + i);
		
		t1=tv1;
		t2=tv2;
		tmin=tv3;
		tmax=tv4;
		Liste_echange=l;
		Liste_fitness=lf;
		maxfit=maxf;
		minfit=minf;
		traitsfit.set_params(t1,t2,tmin,tmax,Liste_echange,Liste_fitness,maxfit,minfit);
		traitsfit.repaint();
	}

}
