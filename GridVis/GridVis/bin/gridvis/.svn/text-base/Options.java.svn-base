package gridvis;

import java.awt.Color;
import java.awt.Component;
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

public class Options extends JFrame{
	// La fenêtre qui englobe les options
	private DataProbleme dp;
	private GUI gui;
	private int tinst;
	private int coul;
	private int fitness;
	
	private static final long serialVersionUID = 1L;

	public Options(DataProbleme dap,GUI g)
	{	
		dp=dap;
		gui=g;
		tinst = 0;
		coul = 0;
		
		this.setTitle("Visualization of the Grid");
	    this.setLocationRelativeTo(null);
	    this.setSize(1100, 750);
	    this.setLayout(new GridBagLayout());
	    this.setBackground(Color.pink);
	    
	    GridBagConstraints gbc = new GridBagConstraints();
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    
	    gbc.gridheight = 1;
	    gbc.gridwidth = 1;
	    
	    //Premier Boutton reordering lexical
	    JButton l= new JButton("Lexical");
	    this.add(l,gbc);
	    
	    
	    gbc.gridy = 1;
	    //
	    JButton t= new JButton("Temporal Start");
	    this.add(t,gbc);
	    
	    gbc.gridy = 2;
	    JButton t2= new JButton("Temporal End");
	    this.add(t2,gbc);
	    
	    gbc.gridy = 3;
	    JButton r= new JButton("Reordering");
	    this.add(r,gbc);
	    
	    gbc.gridy = 4;
	    JButton z= new JButton("Zoom?");
	    this.add(z,gbc);
	    
	    gbc.gridy = 5;
	    JButton ti= new JButton("Global View?");
	    this.add(ti,gbc);
	    
	    gbc.gridy = 6;
	    JButton c= new JButton("Color Time?");
	    this.add(c,gbc);
	    
	    gbc.gridy = 7;
	    JButton f= new JButton("Color Fitness?");
	    this.add(f,gbc);
	    
	    gbc.gridy =9;
	    JButton h= new JButton("Help");
	    h.setBackground(Color.blue);
	    h.setForeground(Color.red);
	    this.add(h,gbc);
	    
	    gbc.gridx = 1;
	    gbc.gridy = 0;
	    gbc.gridwidth = 20;
	    gbc.gridheight = 10;
	    gbc.ipadx = 800;
	   
	    gbc.ipady = 600;
	  
	    final Container pan=gui.getContentPane();
	    this.add(pan,gbc);
	    
	    
	    
	    l.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	ArrayList<String> tmp=new ArrayList<String>();
	        	tmp=dp.get_workers();
	        	dp.lextri(tmp);
	        	dp.set_workers(tmp);
	        	try {
					dp.remplir_Probleme2();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        	int tmi=gui.get_t1();
	    		int tma=gui.get_t2();
	        	gui.change_connec(dp.get_connections(tmi,tma));
	        	gui.change_moyConnec(dp.get_moyConnections(tmi, tma,dp.get_connections(tmi,tma),new ArrayList<Integer>(),tmi));
	        	if(dp.fitness==1){
		        	
		        	gui.change_moyfConnec(dp.get_moyfConnections(tmi, tma,dp.get_connections(tmi,tma),new ArrayList<Float>()));
		        	}
	        	pan.repaint();
	            } 
	        });
	    
	    r.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		ArrayList<String> tmp=new ArrayList<String>();
	        	tmp=dp.get_workers();
	        	algoGen ag=new algoGen(dp.get_matrice_distance(gui.get_t1(),gui.get_t2()), 
	        			500, dp.getnbWorker() , 200,(float)0.4,(float)0.4);
	        	
	        	
	        	tmp=dp.reorder(tmp,ag.get_best());
	        	
	        	dp.set_workers(tmp);
	        	try {
					dp.remplir_Probleme2();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        	int tmi=gui.get_t1();
	    		int tma=gui.get_t2();
	        	gui.change_connec(dp.get_connections(tmi,tma));
	        	gui.change_moyConnec(dp.get_moyConnections(tmi, tma,dp.get_connections(tmi,tma),new ArrayList<Integer>(),tmi));
	        	if(dp.fitness==1){
		        	
		        	gui.change_moyfConnec(dp.get_moyfConnections(tmi, tma,dp.get_connections(tmi,tma),new ArrayList<Float>()));
		        	}
	        	pan.repaint();
	    	}
	    });
	    
	    ti.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	int m;
	        	float mf;
	        	float minf;
	        	if (tinst == 0)
	        	{
	        		m=dp.get_max_nb_echange(gui.get_t1(), gui.get_t2());
	        		if(dp.fitness==1){
	        		mf=dp.get_max_fit(gui.get_t1(), gui.get_t2());
	        		minf=dp.get_min_fit(gui.get_t1(), gui.get_t2());
	        		gui.change_maxf(mf,minf);}
	        	}
	        	else 
	        		{
	        		m=dp.get_max_nb_echange();
	        		if(dp.fitness==1){
	        		mf=dp.get_max_fit();
	        		minf=dp.get_min_fit();
	        		gui.change_maxf(mf,minf);				}	
	        		}	
	        	
	        	tinst=(tinst+1)%2;
	        	gui.set_tinst(tinst);
	        	gui.change_max(m);
	        	
	        	
	        	
	        	int tmi=gui.get_t1();
	    		int tma=gui.get_t2();
	    		gui.change_text();
	        	gui.change_connec(dp.get_connections(tmi,tma));
	        	gui.change_moyConnec(dp.get_moyConnections(tmi, tma,dp.get_connections(tmi,tma),new ArrayList<Integer>(),tmi));
	        	if(dp.fitness==1){
		        	gui.change_moyfConnec(dp.get_moyfConnections(tmi, tma,dp.get_connections(tmi,tma),new ArrayList<Float>()));
	        		}
	        	pan.repaint();
	            } 
	        });
	    
	    c.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	coul=(coul+1)%2;
	        	fitness=0;
	        	gui.set_coul(coul);
	        	gui.set_fitnessactive(fitness);
	        	gui.repaint();
	        	pan.repaint();
	            } 
	        });
	    
	    f.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	fitness=(fitness+1)%2;
	        	coul=0;
	        	gui.set_coul(coul);
	        	gui.set_fitnessactive(fitness);
	        	gui.repaint();
	        	pan.repaint();
	            } 
	        });
	    
	    
	    
	    t.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	ArrayList<String> tmp=new ArrayList<String>();
	        	tmp=dp.get_workers();
	        	dp.timetri(tmp);
	        	dp.set_workers(tmp);
	        	try {
					dp.remplir_Probleme2();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        	int tmi=gui.get_t1();
	    		int tma=gui.get_t2();
	        	gui.change_connec(dp.get_connections(tmi,tma));
	        	gui.change_moyConnec(dp.get_moyConnections(tmi, tma,dp.get_connections(tmi,tma),new ArrayList<Integer>(),tmi));
	        	if(dp.fitness==1){
		        	
		        	gui.change_moyfConnec(dp.get_moyfConnections(tmi, tma,dp.get_connections(tmi,tma),new ArrayList<Float>()));
		        	}
	        	pan.repaint();
	        	}
	        });
	    
	    t2.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	ArrayList<String> tmp=new ArrayList<String>();
	        	tmp=dp.get_workers();
	        	dp.timetri2(tmp);
	        	dp.set_workers(tmp);
	        	try {
					dp.remplir_Probleme2();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        	int tmi=gui.get_t1();
	    		int tma=gui.get_t2();
	        	gui.change_connec(dp.get_connections(tmi,tma));
	        	gui.change_moyConnec(dp.get_moyConnections(tmi, tma,dp.get_connections(tmi,tma),new ArrayList<Integer>(),tmi));
	        	if(dp.fitness==1){
	        	
	        	gui.change_moyfConnec(dp.get_moyfConnections(tmi, tma,dp.get_connections(tmi,tma),new ArrayList<Float>()));
	        	}
	        	pan.repaint();
	        	}
	        });
	    
	    
	    z.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	    
	        	    String ligne = JOptionPane.showInputDialog(null, "Select the workers by their line number :", "Zoom", JOptionPane.QUESTION_MESSAGE);
	        	    if(ligne == null) return; 
	        	    String[] tabChaine = ligne.split(",");
	        	    ArrayList<String> tmp=new ArrayList<String>();
	        	    for(int k=0;k<tabChaine.length;k++)
	        	    	{   
	        	    		if((tabChaine[k]).compareTo("to")==0){
	        	    			if(k<(tabChaine.length-1)){
	        	    			for(int l=Integer.parseInt(tabChaine[k-1])+1;l < Integer.parseInt(tabChaine[k+1]);l++)
	        	    				{
	        	    				if(l >= dp.get_workers().size()) return;
	        	    				tmp.add((dp.get_workers()).get(l));
	        	    				}
	        	    			}
	        	    		}
	        	    		else
	        	    		{	if((tabChaine[k]).compareTo("to")==0) return;
	        	    			if(Integer.parseInt(tabChaine[k]) >= dp.get_workers().size()) return;
	        	    			tmp.add((dp.get_workers()).get(Integer.parseInt(tabChaine[k])));
	        	    		}
	        	    	}
	        	    DataProbleme newdp= new DataProbleme(dp.getFile());
	        	    newdp.setNbWorker(tmp.size());
	        	    newdp.set_workers(tmp);
	        	    try {
						newdp.remplir_Probleme2();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	        		int tmi=newdp.get_timemin();
	        		int tma=newdp.get_timemax();
	        		
	        			GUI fen= new GUI(newdp.getnbWorker(),newdp.get_connections(tmi,tma),newdp.get_moyConnections(tmi, tma,dp.get_connections(tmi,tma),new ArrayList<Integer>(),tmi),newdp.get_moyfConnections(tmi, tma,dp.get_connections(tmi,tma),new ArrayList<Float>()),newdp.get_max_nb_echange(),tmi,
		        				tma, newdp);
	        		Options op=new Options(newdp,fen);
	        		
	        	}
	        });
	    
	    h.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	help aide = new help();
	        	//explications aide =new explications();
	        	aide.setVisible(true);
	        }
	    });
	    
	    this.setVisible(true);
	}
		
}
