import java.util.ArrayList;
import java.util.Date;

public class AlarmeGaz implements AlerteGazListener{

	static private String seuil;

	public static String getSeuil() {
		return seuil;
	}

	public static void setSeuil(String seuil) {
		AlarmeGaz.seuil = seuil;
	}
	
	public static ArrayList<String> listeGaz = new ArrayList<String>();
	
	public static void main(String[] args) {
	    listeGaz.add("hydrogène");
	    listeGaz.add("hélium");
	    listeGaz.add("CO2");
	    listeGaz.add("Autre");
	  }
	
	@Override
	public String receptionGaz(Date dateApparition, String localisation, int type, int importance) {
		// TODO Auto-generated method stub
		return localisation+" ("+dateApparition+") : "+type + " " +importance+"/3";
	}
	
	
	
	
}
