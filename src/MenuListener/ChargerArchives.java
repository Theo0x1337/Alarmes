package MenuListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.FileUtils;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import GUI.Monitoring;

public class ChargerArchives extends MenuItemListener{

	public ChargerArchives(Monitoring jfm) {
		super(jfm);
		// TODO Auto-generated constructor stub
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		
		try {
			File fr = new File("archives.json");
			String jsonString = FileUtils.readFileToString(fr, "utf-8"); ; //assign your JSON String here
			JSONArray obj = new JSONArray(jsonString);
			
			String infos = "";
			
			for (int i = 0; i < obj.length(); i++){
				
			    this.jfm.getListeArchives().add(obj.getJSONObject(i).get("idAlarme").toString());
			    if (obj.getJSONObject(i).has("type") == false) {
				    infos = obj.getJSONObject(i).get("idAlarme").toString() + "\n"+obj.getJSONObject(i).get("idCapteur").toString()+"\n"+obj.getJSONObject(i).get("date")+"\n"+ obj.getJSONObject(i).get("localisation").toString()+"\n"+obj.getJSONObject(i).get("importance").toString();
			    }else {
				    infos = obj.getJSONObject(i).get("idAlarme").toString() + "\n"+obj.getJSONObject(i).get("idCapteur").toString()+"\n"+obj.getJSONObject(i).get("date")+"\n" +obj.getJSONObject(i).get("localisation").toString()+"\n"+obj.getJSONObject(i).get("type")+"\n"+obj.getJSONObject(i).get("importance").toString();
			    }
			    
			    this.jfm.getListeArchivesInfo().add(infos);
			    
			}
			
			System.out.println(this.jfm.getListeArchives());
			System.out.println(this.jfm.getListeArchivesInfo());

			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			
		}
		
	}

}
