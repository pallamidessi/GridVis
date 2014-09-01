package gridvis;
import gridvis.vis.DoubleRangeSlider;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

	public class GUI extends JFrame {
		
		private int nb;
		private ArrayList<Integer> connections_t1_t2;
		private ArrayList<Integer> moyennes_t1_t2;
		private ArrayList<Float> moyennesf_t1_t2;
		private int max;
		private int timemin;
		private int timemax;
		private Grille grille;
		private DataProbleme dp;
		private int t1;
		private int t2;
		private int t3;
		private int tinst;
		private int coul;
		private JTextField txt1;
	  /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	public GUI(int n,ArrayList<Integer> v,ArrayList<Integer> moy,ArrayList<Float> moyf,int m,int tmi,int tma,DataProbleme dap)
		{
		nb=n;
		connections_t1_t2 = v;
		moyennes_t1_t2 =moy;
		moyennesf_t1_t2 =moyf;
		max=m;
	    timemin=tmi;
		timemax=tma;
		t1=tmi;
		t2=tma;
		t3=tma-tmi;
		dp=dap;
		tinst=0;
		coul=0;
		
		
	    this.setTitle("Visualization of the Grid");
	    this.setSize(1100, 700);
	    this.setLocationRelativeTo(null);              
	    //Instanciation d'un objet JPanel
	   
	    //On pr�vient notre JFrame que notre JPanel sera son content pane
	    Grille gr=new Grille();
	    gr.set_dp(dp,tmi,tma);
	    
	    gr.setParams(nb,connections_t1_t2,moyennes_t1_t2,moyennesf_t1_t2,max,timemax-timemin,dp.get_workers());
	    grille=gr;
	    grille.setCoul(0);
	    grille.setFitnessactive(0);
	    if(dp.fitness==1) grille.set_minimaxfit(dp.get_min_fit(), dp.get_max_fit());
	    
	    grille.repaint();
	    
	    Container content = this.getContentPane();
	    content.setBackground(Color.pink);
	    final JSlider slider1 = new JSlider(JSlider.VERTICAL,timemin,timemax,timemin);
	    slider1.setBorder(BorderFactory.createTitledBorder("tMIN"));
	    
	    txt1 = new JTextField(4);
	    
	    content.add(slider1,BorderLayout.WEST);
	    
	    final JSlider slider2 = new JSlider(JSlider.VERTICAL,timemin,timemax,timemax);
	    slider2.setBorder(BorderFactory.createTitledBorder("tMAX"));
	    
	   
	    
	    
	    
	    
	    slider1.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent e) {
	        	
	        	t1=slider1.getValue();
	        	grille.set_t1(t1);
	        	if(tinst==1) max=dp.get_max_nb_echange(t1,t2);
	            connections_t1_t2=dp.get_connections(t1, t2);
	            moyennes_t1_t2 = dp.get_moyConnections(t1, t2,connections_t1_t2,moyennes_t1_t2,timemin);
	            if(dp.fitness==1)
	            {
	            
	    	    moyennesf_t1_t2 = dp.get_moyfConnections(t1,t2,connections_t1_t2,moyennesf_t1_t2);
	            }
	    	    	txt1.setText("Time min of exchange (ms) = "+String.valueOf(slider1.getValue())+
	            		"     Time max of exchange (ms) = " + String.valueOf(slider2.getValue())+ 
	            		"     Number max of exchanges (Global) = " + String.valueOf(max));
	            if(tinst==1){
	            	txt1.setText("Time min of exchange (ms) = "+String.valueOf(slider1.getValue())+
		            		"     Time max of exchange (ms) = " + String.valueOf(slider2.getValue())+ 
		            		"     Number max of exchanges (Dynamic) = " + String.valueOf(max));
		            grille.setParams(nb,connections_t1_t2,moyennes_t1_t2,moyennesf_t1_t2,dp.get_max_nb_echange(t1,t2),timemax-timemin,dp.get_workers());
		            change_maxf(dp.get_max_fit(t1,t2),dp.get_min_fit(t1,t2));	
	            }
		            else
		            {
		            	grille.setParams(nb,connections_t1_t2,moyennes_t1_t2,moyennesf_t1_t2,dp.get_max_nb_echange(),timemax-timemin,dp.get_workers());
		            }
	            
		           	grille.repaint();
	        	getContentPane().repaint();
	            
	            }
	        });
	    
	    slider2.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent e) {
	        	t2= slider2.getValue();
	        	grille.set_t2(t2);
	        	if(tinst==1) max=dp.get_max_nb_echange(t1,t2);
	            connections_t1_t2=dp.get_connections(t1,t2);
	            moyennes_t1_t2 = dp.get_moyConnections(t1, t2,connections_t1_t2,moyennes_t1_t2,timemin);
	            if(dp.fitness==1)
	            {
	            
	    	    moyennesf_t1_t2 = dp.get_moyfConnections(t1,t2,connections_t1_t2,moyennesf_t1_t2);
	            }
	           
	            txt1.setText("Time min of exchange (ms) = "+String.valueOf(slider1.getValue())+
	            		"     Time max of exchange (ms) = " + String.valueOf(slider2.getValue())+ 
	            		"     Number max of exchanges (Global) = " + String.valueOf(max));
	            if(tinst==1)
	            {
	            grille.setParams(nb,connections_t1_t2,moyennes_t1_t2,moyennesf_t1_t2,dp.get_max_nb_echange(t1,t2),timemax-timemin,dp.get_workers());
	            txt1.setText("Time min of exchange (ms) = "+String.valueOf(slider1.getValue())+
	            		"     Time max of exchange (ms) = " + String.valueOf(slider2.getValue())+ 
	            		"     Number max of exchanges (Dynamic) = " + String.valueOf(max));
	            change_maxf(dp.get_max_fit(t1,t2),dp.get_min_fit(t1,t2));
	            }
	            else
	            	grille.setParams(nb,connections_t1_t2,moyennes_t1_t2,moyennesf_t1_t2,dp.get_max_nb_echange(),timemax-timemin,dp.get_workers());
	            grille.repaint();
	            getContentPane().repaint();
	            }
	        });
	    
	    final JSlider slider3 = new JSlider(JSlider.HORIZONTAL,0,2*(timemax-timemin),timemax-timemin);
	    
	   
	    slider3.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent e) {
	        	int tmp;
	        	tmp=t3;
	        	t3= slider3.getValue();
	          
	          if(timemin<= (slider1.getValue()+t3-tmp) 
	        		  && (slider1.getValue()+t3-tmp) <= timemax)
	            slider1.setValue(slider1.getValue()+t3-tmp);
	          if(timemin<= (slider2.getValue()+t3-tmp) 
	        		  && (slider2.getValue()+t3-tmp) <= timemax)
	            slider2.setValue(slider2.getValue()+t3-tmp);
	        }
	        });
	    
	    if(tinst==1)
	    	max = dp.get_max_nb_echange(t1,t2);
	    else
	    	max = dp.get_max_nb_echange();
	    txt1.setText("Time min of exchange (ms) = "+String.valueOf(slider1.getValue())+
        		"     Time max of exchange (ms) = " + String.valueOf(slider2.getValue())+ 
        		"     Number max of exchanges (Global) = " + String.valueOf(max));
	    
	    grille.set_dp(dp,tmi,tma);
	    
	    
	    content.add(txt1,BorderLayout.NORTH);
	    content.add(slider3,BorderLayout.SOUTH);
	    content.add(slider2,BorderLayout.EAST);
	    content.add(grille, BorderLayout.CENTER);
	    	    
	  }      
	
	Grille get_grille(){return grille;}
	
	void change_text()
	{
		if(tinst==1)
	    	{max = dp.get_max_nb_echange(t1,t2);
		txt1.setText("Time min of exchange (ms) = "+ t1 +
        		"     Time max of exchange (ms) = " + t2 + 
        		"     Number max of exchanges (Dynamic) = " + String.valueOf(max));
	    	}
		else
		{
	    	max = dp.get_max_nb_echange();
		txt1.setText("Time min of exchange (ms) = "+t1 +
        		"     Time max of exchange (ms) = " + t2 + 
        		"     Number max of exchanges (Global) = " + String.valueOf(max));
		}
		
	}
	
	void repaintGrille()
		{
		 grille.repaint();
		 
		}
	
	void change_connec(ArrayList<Integer> vcon)
	{
		connections_t1_t2 = vcon;
		grille.setParams(nb,connections_t1_t2,moyennes_t1_t2,moyennesf_t1_t2, max,timemax-timemin,dp.get_workers());
		this.repaintGrille();
		this.repaint();
	}
	void change_moyConnec(ArrayList<Integer> vcon)
	{
		moyennes_t1_t2 = vcon;
		grille.setParams(nb,connections_t1_t2,moyennes_t1_t2,moyennesf_t1_t2, max,timemax-timemin,dp.get_workers());
		this.repaintGrille();
		this.repaint();
	}
	
	void change_moyfConnec(ArrayList<Float> vcon)
	{
		moyennesf_t1_t2 = vcon;
		grille.setParams(nb,connections_t1_t2,moyennes_t1_t2,moyennesf_t1_t2, max,timemax-timemin,dp.get_workers());
		this.repaintGrille();
		this.repaint();
	}
	
	int get_t1(){ return t1;}
	
	int get_t2(){ return t2;}
	 
	void change_max(int m)
	{max=m;}
	
	void set_tinst(int b)
	{tinst=b;}
	
	void set_coul(int b)
	{ grille.setCoul(b);}

	public void set_fitnessactive(int fitness) {
		grille.setFitnessactive(fitness);
		
	}

	public void change_maxf(float mf, float minf) {
		grille.maxfit=mf;
		grille.minfit=minf;
	}
	
	}

	

