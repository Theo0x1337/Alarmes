import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class fenSimulateurAlarme extends JFrame implements ItemListener {
	  private JPanel container = new JPanel();
	  private Box left = Box.createVerticalBox();
      
	  private JLabel labelBat = new JLabel("Batiment :");
	  private JComboBox comboBat = new JComboBox();
	  
	  private JLabel labelType = new JLabel("Type d'alarme :") ;
	  private JComboBox comboType = new JComboBox();
	  
	  private JLabel labelNiveau = new JLabel("Niveau d'importance :") ;
	  private JComboBox comboNiveau = new JComboBox();
	  
	 
	  private JPanel spe = new JPanel();
	  private JLabel labelSpe;
	  
	  private JButton bouton = new JButton("Valider");
	  
	  
	  
	  public fenSimulateurAlarme() {
		//fenetre
	    this.setTitle("Simulateur alarme");
	    this.setSize(800, 500);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);

	    //batiment
	    comboBat.setPreferredSize(new Dimension(100, 20));
	    String[] tabBat = {"Option 1", "Option 2", "Option 3", "Option 4"}; //TODO : recuperer liste batiments
	    comboBat = new JComboBox(tabBat);
	    JPanel batiment = new JPanel();
	    batiment.add(labelBat);
	    batiment.add(comboBat);
	    
	    //type alarme
	    comboType.setPreferredSize(new Dimension(100, 20));
	    String[] tabType = {"Incendie", "Gaz", "Radiation"};
	    comboType = new JComboBox(tabType);
	    JPanel type = new JPanel();
	    type.add(labelType);
	    type.add(comboType);
	    setAction();
	    
	    //Niveau importance
	    comboNiveau.setPreferredSize(new Dimension(100, 20));
	    String[] tabNiveau = {"1", "2", "3"};
	    comboNiveau = new JComboBox(tabNiveau);
	    JPanel niveau = new JPanel();
	    niveau.add(labelNiveau);
	    niveau.add(comboNiveau);
	    
	    //bouton valider
	    JPanel panBout = new JPanel();
	    panBout.add(bouton);
	    
	    //affichage
	    left.add(batiment);
	    left.add(type);
	    left.add(niveau);

	    left.add(panBout);
	    container.add(left, BorderLayout.CENTER);
	    this.setContentPane(container);
	    this.setVisible(true);        
	    
	  }   

	  private void setAction()
	    {
		  comboType.addItemListener(this);
	    }
	 
	  public void itemStateChanged(ItemEvent ie)
	    {
	        String getItem = (String)comboType.getSelectedItem();
	        
	        if(getItem.equals("Gaz"))
	            System.out.println("cest un gaz");
	        else if(getItem.equals("Radiation")) {
	        	System.out.println("cest un radiasion");
	        	labelSpe.setText("Niveau de radiation :");
	        	spe.add(labelSpe);
	        	left.add(spe);
	        }
	        else if(getItem.equals("Incendie"))
	            System.out.println("il fé cho");
	        
	    }
	  
}
