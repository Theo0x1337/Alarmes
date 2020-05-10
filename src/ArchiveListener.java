import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ArchiveListener extends MenuItemListener implements ListSelectionListener {
		
	
	public ArchiveListener(Monitoring jfm) {
		super(jfm);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.jfm.clearAll();
		this.jfm.remove(this.jfm.listeAlarme);
		this.jfm.remove(this.jfm.detailsAlarme);
		this.jfm.jpn.setPreferredSize(new Dimension(500,100));
		
		this.jfm.jlisteArch = new JList(this.jfm.listeArchives.toArray());
		this.jfm.jlisteArch.addListSelectionListener(this);
		this.jfm.jpn.add(this.jfm.jlisteArch);
		
		this.jfm.jps.setPreferredSize(new Dimension(500,200));
		
		if(this.jfm.listeArchives.size() == 0) {
			this.jfm.jt = new JTextArea("Pas d'informations affichées",5,20);
		}else{
			this.jfm.jt = new JTextArea("Cliquez sur une archive dans la liste pour voir ses infos",5,20);
		}
		
		this.jfm.jps.add(this.jfm.jt);
		
		this.jfm.add(this.jfm.jpn,BorderLayout.NORTH);
		this.jfm.add(this.jfm.jps,BorderLayout.SOUTH);
		
		this.jfm.pack();
		this.jfm.repaint();
		
	}


	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		this.jfm.jt.setText(this.jfm.listeArchivesInfo.get(this.jfm.jlisteArch.getSelectedIndex()));
		this.jfm.jps.updateUI();
	}

}
