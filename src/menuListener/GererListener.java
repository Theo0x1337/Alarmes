package menuListener;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import gui.Monitoring;


/**
 * Classe GererListener heritant de MenutItemListener et permettant d'afficher la page de gestion des alarmes
 * @author Theo Bernardin / Enzo Masson
 * @version 1.0
 */

public class GererListener extends MenuItemListener{
	
	
	/** Creer un listener GererListener
	 * 
	 * @param jfm : Monitoring : l'interface graphique de gestion des alarmes
	 */
	public GererListener(Monitoring jfm) {
		super(jfm);
	}
	
	
	
	/** Redefinition de actionPerformed pour afficher la page de gestion des alarmes
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.jfm.clearAll();
		this.jfm.remove(this.jfm.getJpn());
		this.jfm.getJps().remove(this.jfm.getJt());
		this.jfm.remove(this.jfm.getJps());
		
		
		this.jfm.getListeAlarme().setPreferredSize(new Dimension(200,300));
		this.jfm.getDetailsAlarme().setPreferredSize(new Dimension(300,300));
		
		this.jfm.setListe(new JList(this.jfm.getChoix().toArray()));
		this.jfm.getListe().addListSelectionListener(this.jfm);
		this.jfm.setScrollPane(new JScrollPane(this.jfm.getListe()));
		this.jfm.getDetailsAlarme().add(this.jfm.getEtiquette());
	    this.jfm.getEtiquette().setEditable(false);

	    
	    JButton but = new JButton("Archiver");
	    but.addActionListener(this.jfm);
	    GridBagConstraints c = new GridBagConstraints();
	    
	    c.gridx = 0;
	    c.gridy = 1;
	    c.anchor=GridBagConstraints.CENTER;//left align components after this point
	    

	    this.jfm.getDetailsAlarme().add(but,c);
	    this.jfm.getListeAlarme().add(this.jfm.getScrollPane());

	    
	    jfm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   
	    
	    this.jfm.add(this.jfm.getListeAlarme(),BorderLayout.WEST);
	    this.jfm.add(this.jfm.getDetailsAlarme(),BorderLayout.CENTER);
	    
	    this.jfm.pack();	    
	    this.jfm.repaint();
	}

}
