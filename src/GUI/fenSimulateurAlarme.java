package GUI;
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

import Alarmes.AlarmeGaz;
import Alarmes.AlarmeIncendie;
import Alarmes.AlarmeRadiation;
import capteurs.CapteursGaz;
import capteurs.CapteursIncendie;
import capteurs.CapteursRadiation;
import moniteur.Moniteur;



/**
 * Classe fenSimulateurAlarme permettant la generation de maniere graphique des differents types d'alarme
 * 
 * @author Theo Bernardin / Enzo Masson
 * @version 1.0
 */


public class fenSimulateurAlarme extends JFrame implements ActionListener {
	
	  /**
	   * container : JPanel contenant les composant de cette classe
	   */
	  private JPanel container = new JPanel();
	  /**
	   * left : Box 
	   */
	  private Box left = Box.createVerticalBox();
      /**
       * labelBat : JLabel signifiant le type de champs qui se trouve a cote de celui ci
       */
	  private JLabel labelBat = new JLabel("Batiment :");
	  /**
	   * comboBat : JTextField permettant a l'utilisateur de saisir le batiment ou il veut simuler l'alarme
	   */
	  private JTextField comboBat = new JTextField("",10);
	  /**
	   * labetType : JLabel signifiant le type de champs qui se trouve a cote de celui ci
	   */
	  private JLabel labelType = new JLabel("Type d'alarme :") ;
	  /**
	   * comboType : JComboBox permettant a l'utilisateur de choisir le type d'alarme
	   */
	  private JComboBox comboType = new JComboBox();
	  /**
	   * labelNiveau : JLabel signifiant le type de champs qui se trouve a cote de celui ci
	   */
	  private JLabel labelNiveau = new JLabel("Niveau d'importance :") ;
	  /**
	   * comboNiveau : JComboBox permettant a l'utilisateur de choisir le niveau d'importance de l'alarme
	   */
	  private JComboBox comboNiveau = new JComboBox();
	  
	 /**
	  * spe : JPanel contenant les types d'attributs speciaux pour les alarmes gaz et radiation
	  */
	  private JPanel spe = new JPanel();
	  /**
	   * labelSpe : JLabel signifiant le type de champs qui se trouve a cote de celui ci
	   */
	  private JLabel labelSpe = new JLabel(" ");
	  /**
	   * speField : JTextField permettant de renseignant l'attribut specifique au type gaz et radiation
	   */
	  private JTextField speField = new JTextField("",10);
	  
	  /**
	   * bouton : JButton permettant de creer l'alarme
	   */
	  private JButton bouton = new JButton("Valider");
	  
	  /**
	   * batiment : JPanel contenant les composants pour le batiment
	   */
	  JPanel batiment = new JPanel();
	  /**
	   * type : JPanel contenant les composants pour le type
	   */
	  JPanel type = new JPanel();
	  /**
	   * niveau : JPanel contenant les composants pour le niveau
	   */
	  JPanel niveau = new JPanel();
	  /**
	   * panBout : JPanel contenant les composants pour le bouton
	   */
	  JPanel panBout = new JPanel();
	  
	  /**
	   * monitors : Monitoring l'interface graphique de gestion des alarmes pour pouvoir communiquer entre les deux fenetres
	   */
	  private Monitoring monitors;
	  
	  
	  
	  /** Creer l'interface graphique de simulation des alarmes
	   * 
	   */
	  public fenSimulateurAlarme() {
		 
		//fenetre
	    this.setTitle("Simulateur alarme");
	    this.setSize(400, 200);
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

	  
	  /** Redefinition de la methode actionPerformed pour gerer le changement de selection dans la liste ou le clique sur le bouton valider
	   * 
	   */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().toString() == "comboBoxChanged") {
	    	String getBat = comboBat.getText();
	    	String getType = (String)comboType.getSelectedItem();
	    	Integer getNiveau = (Integer)comboNiveau.getSelectedIndex();
	        if(getType.equals("Gaz")) {
	        	//Si on sélectionne un évenement Gaz on ajoute au formulaire une entré de texte pour renseigner le type de gaz
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
	        	//Si on sélectionne un évenement Radiation on ajoute au formulaire une entré de texte pour renseigner le niveau de radiation compris entre 0-100
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
	        	//Si c'est un Gaz
	        	CapteursGaz cg = new CapteursGaz(comboBat.getText());
	            Moniteur ecologie = new Moniteur("B");	
	            cg.addAlerteGazListener(ecologie);
	            
	            //Creation de l'alarme de type Gaz
	            AlarmeGaz ag = cg.alerteGaz(java.time.LocalDateTime.now(), Integer.parseInt(comboNiveau.getSelectedItem().toString()),speField.getText().toString());
	            //ajout au moniteur de l'alerte
	            this.monitors.addAlarmeSign(ag.toString());
	            this.monitors.addAlarmeEtiquette(ag.getInfos());
	            
	        }else if(getType.equals("Radiation")) {
	        	//Si c'est une radiation 
	        	
	        	CapteursRadiation rad = new CapteursRadiation(comboBat.getText());
	            Moniteur ecologie = new Moniteur("B");	
	            rad.addAlerteRadiationListener(ecologie);
	            if (!speField.getText().matches("[0-9]+")){ 
	            	//si le champ niveau de radiation contient autre chose que des chiffres
	            	
	            	//message erreur
	            	JOptionPane.showMessageDialog(this,
	            		  	"Le niveau de radiation doit Ãªtre un nombre !",
	            		    "Erreur sur la valeur",
	            		    JOptionPane.ERROR_MESSAGE);
	            
	            
	            }else if(Integer.parseInt(speField.getText().toString()) >= 0 && Integer.parseInt(speField.getText().toString()) <= 100) {
	            	//si la valeur du champ niveau de radiation est compris entre 0 et 100
	            	
	            	//Creation de l'alarme de type radiation 
	            	AlarmeRadiation ar = rad.alerteRad(java.time.LocalDateTime.now(), Integer.parseInt(comboNiveau.getSelectedItem().toString()), Integer.parseInt(speField.getText().toString()));
	            	
	            	//ajout au moniteur de l'alerte
	            	this.monitors.addAlarmeSign(ar.toString());
		            this.monitors.addAlarmeEtiquette(ar.getInfos());
	            }else { 
	            	
	            	//message erreur
	            	JOptionPane.showMessageDialog(this,
	            		  	"Les radiations doivent Ãªtre comprises entre 0 et 100 !",
	            		    "Erreur sur la valeur",
	            		    JOptionPane.ERROR_MESSAGE);
	            }
	        }else {
	        	CapteursIncendie feu = new CapteursIncendie(comboBat.getText());
	            Moniteur ecologie = new Moniteur("A");	
	            feu.addAlerteIncendieListener(ecologie);
	            
	            //Creation de l'alarme de type incendie
	            AlarmeIncendie ai = feu.alerteIncendie(java.time.LocalDateTime.now(), Integer.parseInt(comboNiveau.getSelectedItem().toString()));
	            
	            //ajout au moniteur de l'alerte
	            this.monitors.addAlarmeSign(ai.toString());
	            this.monitors.addAlarmeEtiquette(ai.getInfos());
	        }
		}
	}
	  
	
	/** Ajoute un objet Monitoring  
	 * 
	 * @param mon : Monitoring, l'interface graphique de gestion d'alarme
	 */
	public void addMonitor(Monitoring mon) {
		this.monitors = mon;
	}
	
}
