
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class GererListener extends MenuItemListener{
	
	

	public GererListener(Monitoring jfm) {
		super(jfm);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.jfm.clearAll();
		this.jfm.remove(this.jfm.jpn);
		this.jfm.jps.remove(this.jfm.jt);
		this.jfm.remove(this.jfm.jps);
		
		
		this.jfm.listeAlarme.setPreferredSize(new Dimension(200,300));
		this.jfm.detailsAlarme.setPreferredSize(new Dimension(300,300));
		
		this.jfm.liste = new JList(this.jfm.choix.toArray());
		this.jfm.liste.addListSelectionListener(this.jfm);
		this.jfm.detailsAlarme.add(this.jfm.etiquette);
	    this.jfm.etiquette.setEditable(false);

	    
	    JButton but = new JButton("Archiver");
	    but.addActionListener(this.jfm);
	    GridBagConstraints c = new GridBagConstraints();
	    
	    c.gridx = 0;
	    c.gridy = 1;
	    c.anchor=GridBagConstraints.CENTER;//left align components after this point
	    

	    this.jfm.detailsAlarme.add(but,c);
	    this.jfm.listeAlarme.add(this.jfm.liste);

	    
	    jfm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   
	    
	    this.jfm.add(this.jfm.listeAlarme,BorderLayout.WEST);
	    this.jfm.add(this.jfm.detailsAlarme,BorderLayout.CENTER);
	    
	    this.jfm.pack();	    
	    this.jfm.repaint();
	}

}
