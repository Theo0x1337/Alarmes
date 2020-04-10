import java.util.ArrayList;
import java.util.Date;


public class AlarmeRadiation implements AlerteRadiationListener{
	
	static private String seuil;

	public static String getSeuil() {
		return seuil;
	}

	public static void setSeuil(String seuil) {
		AlarmeRadiation.seuil = seuil;
	}
	
	public AlarmeRadiation() {
		super();
	}


	@Override
	public String receptionRadiation(Date dateApparition, String localisation, int niveau, int importance) {
		// TODO Auto-generated method stub
		return localisation+" ("+dateApparition+") : "+niveau + " " +importance+"/3";
	}
	
}
