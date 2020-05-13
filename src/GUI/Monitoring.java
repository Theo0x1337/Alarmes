package GUI;
import fonctio.Moniteur;
import fonctio.Moniteur;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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

import MenuListener.*;

public class Monitoring extends JFrame implements ListSelectionListener, ActionListener {
	JPanel listeAlarme = new JPanel();
	JPanel detailsAlarme = new JPanel(new GridBagLayout());
	JPanel jpn = new JPanel();
	JPanel jps = new JPanel();
	JScrollPane scrollPane;
	JList liste;
	JList jlisteArch;
	JTextArea jt;
	JTextArea etiquette = new JTextArea("Pas d'informations affichées",5,20);
    ArrayList<String> choix = new ArrayList<String>();
    //revoir ici mettre seulement choix avec les objets et appeler toString dessus et getInfos pour etiquettes
    ArrayList<String> etiquettes = new ArrayList<String>();
    ArrayList<Moniteur> listeMoni = new ArrayList<Moniteur>();
    ArrayList<String> listeArchives = new ArrayList<String>();
    ArrayList<String> listeArchivesInfo = new ArrayList<String>();
    
  public Monitoring() {
	 
	  
	 JMenuBar mb = new JMenuBar();
	 
	 JMenu file = new JMenu("File");
	 JMenuItem saveArch = new JMenuItem("Sauvegarder les archives");
	 SaveArchListener save = new SaveArchListener(this);
	 saveArch.addActionListener(save);
	 file.add(saveArch);
	 mb.add(file);
	 
	 
	 JMenu gerer = new JMenu("Gerer");
	 JMenuItem gererAlarme = new JMenuItem("Gerer les alarmes");
	 gererAlarme.addActionListener(new GererListener(this));
	 gerer.add(gererAlarme);
	 mb.add(gerer);
	
	 
	 JMenu archives = new JMenu("Archives");
	 JMenuItem accesArchive = new JMenuItem("Acceder aux archives");
	 
	 ArchiveListener al = new ArchiveListener(this);
	 
	 accesArchive.addActionListener(al); 		 
	 
	 JMenuItem chargerArchive = new JMenuItem("Charger des archives");
	 ChargerArchives charger = new ChargerArchives(this);
	 chargerArchive.addActionListener(charger);
	 archives.add(accesArchive);
	 archives.add(chargerArchive);
	 
	 mb.add(archives);
	 
	 this.setJMenuBar(mb);
	
    this.liste = new JList(choix.toArray());
	this.scrollPane = new JScrollPane(this.liste);
    detailsAlarme.add(etiquette);
    this.etiquette.setEditable(false);

    
    JButton but = new JButton("Archiver");
    but.addActionListener(this);
    GridBagConstraints c = new GridBagConstraints();
    
    c.gridx = 0;
    c.gridy = 1;
    c.anchor=GridBagConstraints.CENTER;//left align components after this point
    

    this.detailsAlarme.add(but,c);
    this.listeAlarme.add(this.scrollPane);

    
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
	  this.listeAlarme.remove(this.scrollPane);
	  this.liste = new JList(choix.toArray());
	  this.remove(this.listeAlarme);
	  this.liste.addListSelectionListener(this);
	  this.scrollPane = new JScrollPane(this.liste);
	  this.listeAlarme.add(scrollPane, BorderLayout.WEST);
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
		this.listeArchives.add(this.choix.get(archiveIndex));
		this.listeArchivesInfo .add(this.etiquettes.get(archiveIndex));
		this.choix.remove(archiveIndex);
		this.etiquettes.remove(archiveIndex);
		this.scrollPane.remove(this.liste);
		this.listeAlarme.remove(this.scrollPane);
		this.liste = new JList(choix.toArray());
		this.remove(this.listeAlarme);
		this.liste.addListSelectionListener(this);
		this.scrollPane = new JScrollPane(this.liste);
		this.listeAlarme.add(this.scrollPane, BorderLayout.WEST);
		this.add(this.listeAlarme,BorderLayout.WEST);
		
		
		this.etiquette.setText("Pas d'informations affichées");
		this.detailsAlarme.updateUI();
		
		
		this.listeAlarme.updateUI();
	}
}


	public void clearAll() {
		this.jpn.removeAll();
		this.jps.removeAll();
		this.detailsAlarme.removeAll();
		this.listeAlarme.removeAll();
	}

	public JPanel getListeAlarme() {
		return listeAlarme;
	}

	public void setListeAlarme(JPanel listeAlarme) {
		this.listeAlarme = listeAlarme;
	}

	public JPanel getDetailsAlarme() {
		return detailsAlarme;
	}

	public void setDetailsAlarme(JPanel detailsAlarme) {
		this.detailsAlarme = detailsAlarme;
	}

	public JPanel getJpn() {
		return jpn;
	}

	public void setJpn(JPanel jpn) {
		this.jpn = jpn;
	}

	public JPanel getJps() {
		return jps;
	}

	public void setJps(JPanel jps) {
		this.jps = jps;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public JList getListe() {
		return liste;
	}

	public void setListe(JList liste) {
		this.liste = liste;
	}

	public JList getJlisteArch() {
		return jlisteArch;
	}

	public void setJlisteArch(JList jlisteArch) {
		this.jlisteArch = jlisteArch;
	}

	public JTextArea getJt() {
		return jt;
	}

	public void setJt(JTextArea jt) {
		this.jt = jt;
	}

	public JTextArea getEtiquette() {
		return etiquette;
	}

	public void setEtiquette(JTextArea etiquette) {
		this.etiquette = etiquette;
	}

	public ArrayList<String> getEtiquettes() {
		return etiquettes;
	}

	public void setEtiquettes(ArrayList<String> etiquettes) {
		this.etiquettes = etiquettes;
	}

	public ArrayList<Moniteur> getListeMoni() {
		return listeMoni;
	}

	public void setListeMoni(ArrayList<Moniteur> listeMoni) {
		this.listeMoni = listeMoni;
	}

	public ArrayList<String> getListeArchives() {
		return listeArchives;
	}

	public void setListeArchives(ArrayList<String> listeArchives) {
		this.listeArchives = listeArchives;
	}

	public ArrayList<String> getListeArchivesInfo() {
		return listeArchivesInfo;
	}

	public void setListeArchivesInfo(ArrayList<String> listeArchivesInfo) {
		this.listeArchivesInfo = listeArchivesInfo;
	}

	public void setChoix(ArrayList<String> choix) {
		this.choix = choix;
	}
	
	
	

  
} 