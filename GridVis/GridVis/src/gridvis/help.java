package gridvis;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class help extends JFrame {

	//private JLabel txt1;
	private JTextArea txt1;
	
	public help()
	{
		this.setTitle("Help for this Tool");
	    this.setLocationRelativeTo(null);
	    this.setSize(900, 650);
	    this.setLayout(new GridBagLayout());
	    this.setBackground(Color.pink);
	    //txt1 = new JLabel();
	    txt1 = new JTextArea();
	    
	    final GridBagConstraints gbc = new GridBagConstraints();
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    
	    gbc.gridheight = 1;
	    gbc.gridwidth = 1;
	    
	    JButton tool= new JButton("What is this tool for?");
	    this.add(tool,gbc);
	    
	    
	    gbc.gridy = 1;
	    JButton l= new JButton("What is the button \"Lexical\" for?");
	    this.add(l,gbc);
	    
	    
	    gbc.gridy = 2;
	    JButton t= new JButton("What is the button \"Temporal Start\" for?");
	    this.add(t,gbc);
	    
	    gbc.gridy = 3;
	    JButton t2= new JButton("What is the button \"Temporal End\" for?");
	    this.add(t2,gbc);
	    
	    gbc.gridy = 4;
	    JButton r= new JButton("What is the button \"Reordering\" for?");
	    this.add(r,gbc);
	    
	    gbc.gridy = 5;
	    JButton z= new JButton("What is the button\"Zoom?\" for?");
	    this.add(z,gbc);
	    
	   
	    gbc.gridy = 6;
	    JButton ti= new JButton("What is the button \"Global View?\" for?");
	    this.add(ti,gbc);
	    
	    gbc.gridy = 7;
	    JButton c= new JButton("What is the button \"Color Time?\" for?");
	    this.add(c,gbc);
	    
	    gbc.gridy = 8;
	    JButton f= new JButton("What is the button \"Color Fitness?\" for?");
	    this.add(f,gbc);
	    
	    
	    gbc.gridx = 1;
	    gbc.gridy = 0;
	    gbc.gridwidth = 3;
	    gbc.gridheight = 10;
	    //gbc.ipadx = 10;
	    txt1.setLineWrap(true);
        txt1.setWrapStyleWord(true);
        txt1.setSize(500, 100);
	    
	    this.add(txt1,gbc);
	   
	    
	    
        
	    tool.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        		
	        	
	        	txt1.setText("This tool was made to understand how the exchanges were made " +
	        			    "during the run of an Evolutionary Algorithm parallelized with an " +
	        			    "island model. On the left of the tool, several buttons, enable the " +
	        			    "user to use some options. The heatmap shows the amount of individuals " +
	        			    "that are sent from a machine to another one. The color of the square i,j " +
	        			    "represents the number of individuals sent from the machine i to the machine j " +
	        			    "between a minimum time (tMIN) and a maximum time (tMAX).  On the right, we can see " +
	        			    "the names of the machines which send individuals and below the heatmap we can see " +
	        			    "the names of the machines that receive the individuals. One slider on the right enable " +
	        			    "to change tMAX and one slider on the left enable to change tMIN. The slider below the heatmap " +
	        			    " enables to move both tMIN and tMAX at the same time. Above the heatmap, \"Time min of " +
	        			    " exchange\" is the time (ms) on which the first individual is sent whereas \"Time max of " +
	        			    "exchange\" is the time on which the last individual is sent. \"Number max of exchanges\" is " +
	        			    "the maximum number of individuals sent from one machine to another between the \"Time min of " +
	        			    "exchanges\"  and the \"Time max of exchanges\". It is the number that correspond to black" +
	        			    " on the heatmap."+
	        			    "If you encounter any problem with this tool please feel free to send an " +
	        			    "email at hgilbert@ensta.fr.");
	        	    	
		
	            }
	    
	});
	    
	    l.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	
	        	txt1.setText("The button \"Lexical\" does a lexical reordering of the heatmap.");
	        	
	            }
	    
	});
	    
	    t.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	txt1.setText("The button \"Temporal Start\" does a temporal reordering. The first machines are the first ones to start the algorithm.");
	            }
	    
	});
	    
	    t2.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	txt1.setText("The button \"Temporal End\" does a temporal reordering. The first machines are the first ones to finish the algorithm.");
	            }
	    
	});
	    
	    r.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	txt1.setText("The button \"Reordering\" does a reordering by Genetic Algorithm to find patterns." );
	            }
	    
	});
	    
	    z.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	txt1.setText("The button \"Zoom?\" enable to focus on some machines that you can select by their line number.");
	        	
	            }
	    
	});
	    
	    ti.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	txt1.setText("The button \"Global View?\" enables you to choose if you want to see someting global or dynamic. In other words, are the extrema that decide the colors of the heatmap global or do they evolve with tMIN and tMax?");
	            }
	    
	});
	    
	    c.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	txt1.setText("The button \"Color Time?\" will show you when the exchanges were made. The intensity of" +
	        			" the color still codes for the amount of individuals sent from a machine to another. " +
	        			" We used a gradation from blue to orange to know when the exchanges were made." +
	        			" For each square we calculate the mean of the times of the exchanges realized between tMIN and tMAX." +
	        			" If this  mean is « old »  then the square will be blue. On the contrary the newer the exchanges are the more orange it will be."
	        		);	}
	    
	});
	    
	    f.addActionListener(new ActionListener() { 
	        public void actionPerformed(ActionEvent e) {
	        	txt1.setText("The button \"Color Fitness?\" will show you the fitness of the individuals. The intensity of" +
	        			" the color still codes for the amount of individuals sent from a machine to another. " +
	           			" For each square we calculate the mean of the fitnesses of the exchanges realized between tMIN and tMAX." +
	        			" If this  mean is « hight »  then the square will be red. On the contrary the lower the exchanges are the more yellow it will be."+
	        			" We also added some information about each machine on the diagonal with a colored circle." +
	        			" The color of this circle gives you the fitness of the best individual of the machine.  ");
	            
	            }
	    
	});

}
}