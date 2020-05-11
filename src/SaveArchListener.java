import java.awt.event.ActionEvent;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.FileWriter;
import java.io.IOException;

public class SaveArchListener extends MenuItemListener {

	public SaveArchListener(Monitoring jfm) {
		super(jfm);
	}

	
	
	public void actionPerformed(ActionEvent e) {
		if (this.jfm.listeArchives.size() > 0) {
		    JSONObject obj = new JSONObject();
		    String[] infos;
		    FileWriter file = null;
            try {
            	file = new FileWriter("archives.json");
            	file.write("[\n");
    			for (int i = 0;i<this.jfm.listeArchivesInfo.size();i++) {
    				infos = this.jfm.listeArchivesInfo.get(i).split("\n");
    				System.out.println(infos.length);
    			
    					if (infos.length == 6) {
    							obj.put("idAlarme", this.jfm.listeArchives.get(0));
    							obj.put("idCpateur", infos[1]);
    							obj.put("date", infos[2]);
    							obj.put("localisation", infos[3]);
    							obj.put("importance", infos[5]);
    							obj.put("type",infos[4]);
    							file.write(obj.toString());
    							if (i != this.jfm.listeArchivesInfo.size()-1) {
    								file.write(',');
    							}

    					}else {
    							obj.put("idAlarme", this.jfm.listeArchives.get(0));
    							obj.put("idCpateur", infos[1]);
    							obj.put("date", infos[2]);
    							obj.put("localisation", infos[3]);
    							obj.put("importance", infos[4]);
    							file.write(obj.toString());
    							if (i != this.jfm.listeArchivesInfo.size()-1) {
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
