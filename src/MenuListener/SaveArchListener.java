package MenuListener;
import java.awt.event.ActionEvent;
import org.json.JSONException;
import org.json.JSONObject;

import GUI.Monitoring;

import java.io.FileWriter;
import java.io.IOException;


/**
 * Classe SaveArchListener heritant de MenutItemListener et permettant de sauvegarder les alarmes qui sont archivees
 * @author Theo Bernardin / Enzo Masson
 * @version 1.0
 */

public class SaveArchListener extends MenuItemListener {

	
	/** Creer un listener GererListener
	 * 
	 * @param jfm : Monitoring : l'interface graphique de gestion des alarmes
	 */
	public SaveArchListener(Monitoring jfm) {
		super(jfm);
	}

	
	/** Redefinition de actionPerformed pour enregistrer les alarmes qui sont archivees dans un fichier
	 * 
	 */
	public void actionPerformed(ActionEvent e) {
		if (this.jfm.getListeArchives().size() > 0) {
		    JSONObject obj = new JSONObject();
		    String[] infos;
		    FileWriter file = null;
		    String nameFich = "";
		    if(this.jfm.getTitle() == "Monitoring POMPIERS") {
		    	nameFich = "archivesPompiers.json";
		    }else {
		    	nameFich = "archivesEco.json";
		    }
            try {
            	file = new FileWriter(nameFich);
            	file.write("[\n");
    			for (int i = 0;i<this.jfm.getListeArchivesInfo().size();i++) {
    				infos = this.jfm.getListeArchivesInfo().get(i).split("\n");
    				System.out.println(infos.length);
    			
    					if (infos.length == 6) {
    							obj.put("idAlarme", infos[0]);
    							obj.put("idCapteur", infos[1]);
    							obj.put("date", infos[2]);
    							obj.put("localisation", infos[3]);
    							obj.put("importance", infos[5]);
    							obj.put("type",infos[4]);
    							file.write(obj.toString());
    							if (i != this.jfm.getListeArchivesInfo().size()-1) {
    								file.write(',');
    							}

    					}else {
    							obj.put("idAlarme", infos[0]);
    							obj.put("idCapteur", infos[1]);
    							obj.put("date", infos[2]);
    							obj.put("localisation", infos[3]);
    							obj.put("importance", infos[4]);
    							file.write(obj.toString());
    							if (i != this.jfm.getListeArchivesInfo().size()-1) {
    								file.write(',');
    							}
    				}
            }
 
	
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
	        try {
	        	file.write(']');
				file.flush();
		        file.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    }
	}
	}
	
}
