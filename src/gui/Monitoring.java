package gui;
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

import menuListener.*;
import moniteur.Moniteur;


/**
 * Classe Monitoring affichant graphiquement les actions possibles sur les alarmes
 * 
 * @author Theo Bernardin / Enzo Masson
 * @version 1.0
 */


public class Monitoring extends JFrame implements ListSelectionListener, ActionListener {
	/**
	 * listeAlarme : JPanel contenant le scrollPane et la liste des alarmes generees
	 */
	JPanel listeAlarme = new JPanel();
	/**
	 * detailsAlarme : JPanel contenant la textArea ou les informations des alarmes sont affichees
	 */
	JPanel detailsAlarme = new JPanel(new GridBagLayout());
	/**
	 * jpn : JPanel contenant la liste des alarmes archivees
	 */
	JPanel jpn = new JPanel();
	/**
	 * jps : JPanel contenant le textArea affichant les informations des alarmes archivees
	 */
	JPanel jps = new JPanel();
	/**
	 * scrollPane : JScrollPane contenant les listes des alarmes et permettant le scroll lorsque celles ci deviennent trop grandes
	 */
	JScrollPane scrollPane;
	/**
	 * liste : JList contenant les alarmes generees
	 */
	JList liste;
	/**
	 * jlisteArch : JList contenant les alarmes qui ont ete archive
	 */
	JList jlisteArch;
	/**
	 * jt : JTextArea affichant les informations des alarmes archivees
	 */
	JTextArea jt;
	/**
	 * etiquette : JTextArea affichant les informations des alarmes qui n'ont pas ete archive
	 */
	JTextArea etiquette = new JTextArea("Pas d'informations affichées",5,20);
	/**
	 * choix : ArrayList de String contenant les alarmes generees pour construire l'attribut liste
	 */
    ArrayList<String> choix = new ArrayList<String>();
    //revoir ici mettre seulement choix avec les objets et appeler toString dessus et getInfos pour etiquettes
    
    /**
     * etiquettes : ArrayList de String contenant les informations des alarmes generees
     */
    ArrayList<String> etiquettes = new ArrayList<String>();
    /**
     * listeMoni : ArrayList de Moniteur contenant les moniteurs branches sur l'interface graphique
     */
    ArrayList<Moniteur> listeMoni = new ArrayList<Moniteur>();
    /**
     * listeArchives : ArrayList de String contenant les Alarmes qui ont ete archive
     */
    ArrayList<String> listeArchives = new ArrayList<String>();
    /**
     * listeArchivesInfo : ArrayList de String contenant les informations des alarmes qui ont ete archive
     */
    ArrayList<String> listeArchivesInfo = new ArrayList<String>();
    
    
    
    
  /** Creer un objet Monitoring afin de pouvoir gerer les alarmes graphiquement
   *   
   */
  public Monitoring(String titre) {
	 
	 //Menu 
	 JMenuBar mb = new JMenuBar();
	 
	 //bouton file
	 JMenu file = new JMenu("File");
	 JMenuItem saveArch = new JMenuItem("Sauvegarder les archives");
	 SaveArchListener save = new SaveArchListener(this);
	 saveArch.addActionListener(save);
	 file.add(saveArch);
	 mb.add(file);
	 
	 //bouton gerer
	 JMenu gerer = new JMenu("Gerer");
	 JMenuItem gererAlarme = new JMenuItem("Gerer les alarmes");
	 gererAlarme.addActionListener(new GererListener(this));
	 gerer.add(gererAlarme);
	 mb.add(gerer);
	
	 //bouton archives contenant acceder et charger
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
	
	//ajout de etiquette au details
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
    
    //parametres de la frame 
    int frameWidth = 500;
    int frameHeight = 300;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    this.setBounds((int) screenSize.getWidth() - frameWidth, 0, frameWidth, frameHeight);
    this.setTitle(titre);
    setVisible(true);
  }

  
  /** Redefinition de l'event valueChanged pour mettre a jour l'attribut liste et donc mettre a jour graphiquement les informations de l'alarme affichees sur l'interface
   * @param evt : evenement ListSelectionEvent qui reprensente le changement de valeur selectionne dans la jlist choix
   */
  public void valueChanged(ListSelectionEvent evt)  { 
	  //changement d'�tiquette lorsqu'on selectionne une alarme
	  this.etiquette.setText(this.etiquettes.get(liste.getSelectedIndex()));
	  this.detailsAlarme.updateUI();
  }
  
  
  /** Attache un moniteur a l'interface graphique
   * 
   * @param mon : Moniteur etant l'objet a attache a l'interface
   */
  public void addMoniteur(Moniteur mon) {
	  this.listeMoni.add(mon);
  }
  
  
  /** Ajoute une alarme dans la liste des alarmes qui ont ete genere et met a jour l'interface
   * 
   * @param signature : String representant la signature de l'alarme qui est recu
   */
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
	  
	  //Message d'avertissement de nouvelle alarme
	  JOptionPane.showMessageDialog(this,
	  	signature,
	    "Alarme déclenchée",
	    JOptionPane.ERROR_MESSAGE);  
  }
  
  
  /** Renvoi la liste des alarmes qui doivent etre affichee sur l'interface
   * 
   * @return ArrayList de string qui represente les alarmes qui ont ete generee et sont dans la liste 
   */
  public ArrayList<String> getChoix(){
	  return this.choix;
  }

  
  /** Ajoute les informations d'une alarme dans la liste des informations des alarmes
   * 
   * @param infos : String qui represente les informations de l'alarme
   */
	public void addAlarmeEtiquette(String infos) {
		// TODO Auto-generated method stub
		this.etiquettes.add(infos);
		
	}

	
	/** Redefinition de actionPerformed pour gerer le clic sur le bouton archiver
	 * 
	 */
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

	/** Methode supprimant tous les composants de la fenetre graphique afin de mettre a jour entre la page gerer/archives
	 * 
	 */
	public void clearAll() {
		this.jpn.removeAll();
		this.jps.removeAll();
		this.detailsAlarme.removeAll();
		this.listeAlarme.removeAll();
	}

	
	
	/*
	 * ---------------- GETTERS ET SETTERS POUR UTILISER LES ATTRIBUTS DANS LES DIFFERENTS PACKAGES -----------------
	 */
	
	
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