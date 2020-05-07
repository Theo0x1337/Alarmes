import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.EventListener;

import javax.swing.*;

public class fenSimulateurAlarme extends JFrame implements ActionListener {
	  private JPanel container = new JPanel();
	  private Box left = Box.createVerticalBox();
      
	  private JLabel labelBat = new JLabel("Batiment :");
	  private JTextField comboBat = new JTextField("",10);
	  
	  private JLabel labelType = new JLabel("Type d'alarme :") ;
	  private JComboBox comboType = new JComboBox();
	  
	  private JLabel labelNiveau = new JLabel("Niveau d'importance :") ;
	  private JComboBox comboNiveau = new JComboBox();
	  
	 
	  private JPanel spe = new JPanel();
	  private JLabel labelSpe = new JLabel(" ");
	  private JTextField speField = new JTextField("",10);
	  
	  private JButton bouton = new JButton("Valider");
	  
	  JPanel batiment = new JPanel();
	  JPanel type = new JPanel();
	  JPanel niveau = new JPanel();
	  JPanel panBout = new JPanel();
	  
	  private Monitoring monitors;
	  
	  
	  public fenSimulateurAlarme() {
		 
		//fenetre
	    this.setTitle("Simulateur alarme");
	    this.setSize(800, 500);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);

	    //batiment

	    comboBat.setPreferredSize(new Dimension(100, 20));
	    
	    batiment.add(labelBat);
	    batiment.add(comboBat);
	    
	    //type alarme
	    comboType.setPreferredSize(new Dimension(100, 20));
	    String[] tabType = {"Incendie", "Gaz", "Radiation"};
	    comboType = new JComboBox(tabType);
	    type.add(labelType);
	    type.add(comboType);
	    
	    //Niveau importance
	    comboNiveau.setPreferredSize(new Dimension(100, 20));
	    String[] tabNiveau = {"1", "2", "3"};
	    comboNiveau = new JComboBox(tabNiveau);
	    niveau.add(labelNiveau);
	    niveau.add(comboNiveau);
	    
	    //bouton valider
	    panBout.add(bouton);
	    
	    
	    bouton.addActionListener(this);
	    comboType.addActionListener(this);
	    
	    
	  //affichage
	    left.add(batiment);
	    left.add(type);
	    left.add(niveau);

	    left.add(panBout);
	    container.add(left, BorderLayout.CENTER);
	    this.setContentPane(container);
	    this.setVisible(true);        
	    
	  }   

	  

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().toString() == "comboBoxChanged") {
	    	String getBat = comboBat.getText();
	    	String getType = (String)comboType.getSelectedItem();
	    	Integer getNiveau = (Integer)comboNiveau.getSelectedIndex();
	        if(getType.equals("Gaz")) {
	        	left.removeAll();
        		labelSpe.setText("Type de gaz :");
        		spe.add(labelSpe);
        		spe.add(speField);
        		left.add(batiment);
        		left.add(type);
        		left.add(niveau);
        		left.add(spe);
        		left.add(panBout);
        		
        		container.updateUI();
	        }else if(getType.equals("Radiation")) {
	        	left.removeAll();
	        	labelSpe.setText("Niveau de radiation :");
	        	spe.add(labelSpe);
	        	spe.add(speField);
	        	left.add(batiment);
	    	    left.add(type);
	    	    left.add(niveau);
	        	left.add(spe);
	    	    left.add(panBout);
	        	
	        	container.updateUI();
	        }else {
	        	left.removeAll();
	        	left.add(batiment);
	    	    left.add(type);
	    	    left.add(niveau);
	    	    left.add(panBout);
	        	
	        	container.updateUI();
	        }
		}else {
			String getType = (String)comboType.getSelectedItem();
	        if(getType.equals("Gaz")) {
	        	CapteursGaz cg = new CapteursGaz(comboBat.getText());
	            Moniteur ecologie = new Moniteur("B");	
	            cg.addAlerteGazListener(ecologie);
	            AlarmeGaz ag = cg.alerteGaz(java.time.LocalDateTime.now(), Integer.parseInt(comboNiveau.getSelectedItem().toString()),speField.getText().toString());
	            this.monitors.addAlarmeSign(ag.toString());
	            this.monitors.addAlarmeEtiquette(ag.getInfos());
	        }else if(getType.equals("Radiation")) {
	        	CapteursRadiation rad = new CapteursRadiation(comboBat.getText());
	            Moniteur ecologie = new Moniteur("B");	
	            rad.addAlerteRadiationListener(ecologie);
	            if (!speField.getText().matches("[0-9]+")){
	            	JOptionPane.showMessageDialog(this,
	            		  	"Le niveau de radiation doivent contenir un nombre !",
	            		    "Erreur sur la valeur",
	            		    JOptionPane.ERROR_MESSAGE);
	            
	            
	            }else if(Integer.parseInt(speField.getText().toString()) >= 0 && Integer.parseInt(speField.getText().toString()) <= 100) {
	            	AlarmeRadiation ar = rad.alerteRad(java.time.LocalDateTime.now(), Integer.parseInt(comboNiveau.getSelectedItem().toString()), Integer.parseInt(speField.getText().toString()));
		            this.monitors.addAlarmeSign(ar.toString());
		            this.monitors.addAlarmeEtiquette(ar.getInfos());
	            }else {
	            	JOptionPane.showMessageDialog(this,
	            		  	"Les radiations doivent être comprises entre 0 et 100 !",
	            		    "Erreur sur la valeur",
	            		    JOptionPane.ERROR_MESSAGE);
	            }
	        }else {
	        	CapteursIncendie feu = new CapteursIncendie(comboBat.getText());
	            Moniteur ecologie = new Moniteur("A");	
	            feu.addAlerteIncendieListener(ecologie);
	            AlarmeIncendie ai = feu.alerteIncendie(java.time.LocalDateTime.now(), Integer.parseInt(comboNiveau.getSelectedItem().toString()));
	            this.monitors.addAlarmeSign(ai.toString());
	            this.monitors.addAlarmeEtiquette(ai.getInfos());
	        }
		}
	}
	  
	
	public void addMonitor(Monitoring mon) {
		this.monitors = mon;
	}
	
}
