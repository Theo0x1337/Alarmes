import java.util.ArrayList;
import java.util.Date;


public class AlarmeRadiation implements AlerteRadiationListener{
	
	public static ArrayList<String> listeGaz = new ArrayList<String>();
	
	public static void main(String[] args) {
	    listeGaz.add("hydrog�ne");
	    listeGaz.add("h�lium");
	    listeGaz.add("CO2");
	    listeGaz.add("Autre");
	  }

	@Override
	public void receptionRadiation(Date dateApparition, String localisation, int niveau, int importance) {
		// TODO Auto-generated method stub
		
	}
	
}
