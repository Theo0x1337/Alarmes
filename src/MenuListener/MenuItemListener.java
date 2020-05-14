package MenuListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import GUI.Monitoring;


/**
 * Classe MenuItemListener classe mere pour les listeners gerant les boutons du menu
 * @author Theo Bernardin / Enzo Masson
 * @version 1.0
 */

public class MenuItemListener implements ActionListener {
	
	/**
	 * jfm : Monitoring, l'interface graphique de gestion des alarmes
	 */
	protected Monitoring jfm;
	
	
	/** Creer un objet MenuItemListener
	 *  
	 * @param jfm : Monitoring : l'interface graphique de gestion des alarmes
	 */
	public MenuItemListener(Monitoring jfm) {
		this.jfm = jfm;
	}
	
	/**
	 * Les classes heritant de MenuItemListener doivent implementer actionPerformed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
