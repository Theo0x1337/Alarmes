package menuListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import gui.Monitoring;


/**
 * Classe ArchiveListener heritant de MenutItemListener et permettant de gerer les clics sur le bouton acceder aux archives 
 * @author Theo Bernardin / Enzo Masson
 * @version 1.0
 */


public class ArchiveListener extends MenuItemListener implements ListSelectionListener {
		
	/** Creer un listener ArchiveListener
	 * 
	 * @param jfm : Monitoring : l'interface graphique de gestion des alarmes
	 */
	public ArchiveListener(Monitoring jfm) {
		super(jfm);
	}
	
	/** Redefinition de actionPerformed pour afficher la page de gestion des alarmes archivees
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.jfm.clearAll();
		this.jfm.remove(this.jfm.getListeAlarme());
		this.jfm.remove(this.jfm.getDetailsAlarme());
		this.jfm.getJpn().setPreferredSize(new Dimension(500,100));
		
		this.jfm.setJlisteArch(new JList(this.jfm.getListeArchives().toArray()));
		this.jfm.getJlisteArch().addListSelectionListener(this);
		this.jfm.setScrollPane(new JScrollPane(this.jfm.getJlisteArch()));
		this.jfm.getScrollPane().setPreferredSize(new Dimension(200,100));
		this.jfm.getJpn().add(this.jfm.getScrollPane());
		
		this.jfm.getJps().setPreferredSize(new Dimension(500,200));
		
		if(this.jfm.getListeArchives().size() == 0) {
			this.jfm.setJt(new JTextArea("Pas d'informations affichées",5,20));
		}else{
			this.jfm.setJt(new JTextArea("Cliquez sur une archive dans la liste pour voir ses infos",5,20));
		}
		
		this.jfm.getJt().setEditable(false);
		this.jfm.getJps().add(this.jfm.getJt(),BorderLayout.SOUTH);
		
		this.jfm.add(this.jfm.getJpn(),BorderLayout.NORTH);
		this.jfm.add(this.jfm.getJps(),BorderLayout.SOUTH);
		
		this.jfm.pack();
		this.jfm.repaint();
		
	}

	/** Redefinition de la methode valueChanged pour afficher les informations des alarmes archivees lorsqu'une d'entre elle est selectionnee
	 * 
	 */
	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		this.jfm.getJt().setText(this.jfm.getListeArchivesInfo().get(this.jfm.getJlisteArch().getSelectedIndex()));
		this.jfm.getJps().updateUI();
	}

}
