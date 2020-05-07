import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Monitoring extends JFrame implements ListSelectionListener, ActionListener {
	JPanel listeAlarme = new JPanel();
	JPanel detailsAlarme = new JPanel(new GridBagLayout());
	JList liste;
	JTextArea etiquette = new JTextArea("Pas d'informations affichées",5,20);
    ArrayList<String> choix = new ArrayList<String>();
    //revoir ici mettre seulement choix avec les objets et appeler toString dessus et getInfos pour etiquettes
    ArrayList<String> etiquettes = new ArrayList<String>();
    ArrayList<Moniteur> listeMoni = new ArrayList<Moniteur>();
    
  public Monitoring() {
   
	
    this.liste = new JList(choix.toArray());
    detailsAlarme.add(etiquette);
    this.etiquette.setEditable(false);

    
    JButton but = new JButton("Archiver");
    but.addActionListener(this);
    GridBagConstraints c = new GridBagConstraints();
    
    c.gridx = 0;
    c.gridy = 1;
    c.anchor=GridBagConstraints.CENTER;//left align components after this point
    

    detailsAlarme.add(but,c);
    listeAlarme.add(liste);

    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
    
    this.add(listeAlarme,BorderLayout.WEST);
    this.add(detailsAlarme,BorderLayout.CENTER);

    
    pack();
    int frameWidth = 500;
    int frameHeight = 300;
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

@Override
public void actionPerformed(ActionEvent e) {
	int archiveIndex = this.liste.getSelectedIndex();
	if (archiveIndex != -1) {
		this.choix.remove(archiveIndex);
		this.etiquettes.remove(archiveIndex);
		this.listeAlarme.remove(this.liste);
		this.liste = new JList(choix.toArray());
		this.remove(this.listeAlarme);
		this.liste.addListSelectionListener(this);
		this.listeAlarme.add(this.liste, BorderLayout.WEST);
		this.add(this.listeAlarme,BorderLayout.WEST);
		
		
		this.etiquette.setText("Pas d'informations affichées");
		this.detailsAlarme.updateUI();
		
		
		this.listeAlarme.updateUI();
	}
}
  
} 