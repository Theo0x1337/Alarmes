import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
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
	JTextArea etiquette = new JTextArea("Pas d'informations affichées",5,20);
    ArrayList<String> choix = new ArrayList<String>();
    ArrayList<String> etiquettes = new ArrayList<String>();
    ArrayList<Moniteur> listeMoni = new ArrayList<Moniteur>();
    
  public Monitoring() {
   
	
    this.liste = new JList(choix.toArray());

    this.etiquette.setEditable(false);
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
	  this.etiquette.setText(this.etiquettes.get(liste.getSelectedIndex()));
	  this.detailsAlarme.updateUI();
  }
  
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
	  JOptionPane.showMessageDialog(this,
	  	signature,
	    "Alarme déclenchée",
	    JOptionPane.ERROR_MESSAGE);  
  }
  
  public ArrayList<String> getChoix(){
	  return this.choix;
  }

public void addAlarmeEtiquette(String infos) {
	// TODO Auto-generated method stub
	this.etiquettes.add(infos);
	
}
  
} 