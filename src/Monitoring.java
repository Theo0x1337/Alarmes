import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Monitoring extends JFrame implements ListSelectionListener {
	JPanel listeAlarme = new JPanel();
	JPanel detailsAlarme = new JPanel();
	JList liste;
	JLabel etiquette = new JLabel("        	");
    ArrayList<String> choix = new ArrayList<String>();
    ArrayList<Moniteur> listeMoni = new ArrayList<Moniteur>();
    
  public Monitoring() {
   
	
    this.liste = new JList(choix.toArray());

       
    detailsAlarme.add(etiquette);
    listeAlarme.add(liste);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
    
    this.add(listeAlarme,BorderLayout.WEST);
    this.add(detailsAlarme,BorderLayout.CENTER);

    
    pack();
    int frameWidth = 500;
    int frameHeight = 800;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    this.setBounds((int) screenSize.getWidth() - frameWidth, 0, frameWidth, frameHeight);
    setVisible(true);
  }

  public void valueChanged(ListSelectionEvent evt)  { 
	  JOptionPane.showMessageDialog(this,
			    "truc \nanother truc \nanother another truc",
			    "Alarme déclenchée",
			    JOptionPane.ERROR_MESSAGE);  }
  
  
  public void addMoniteur(Moniteur mon) {
	  this.listeMoni.add(mon);
  }
  
  public void addAlarmeSign(String signature) {
	  this.choix.add(signature);
	  this.listeAlarme.remove(this.liste);
	  this.liste = new JList(choix.toArray());
	  this.remove(this.listeAlarme);
	  this.liste.addListSelectionListener(this);
	  this.listeAlarme.add(this.liste, BorderLayout.WEST);
	  this.add(this.listeAlarme,BorderLayout.WEST);
	  this.listeAlarme.updateUI();
  }
  
  public ArrayList<String> getChoix(){
	  return this.choix;
  }
  
} 