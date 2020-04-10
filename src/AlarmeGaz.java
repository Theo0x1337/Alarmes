import java.util.Date;

public class AlarmeGaz implements AlerteGazListener{

	static private String seuil;

	public static String getSeuil() {
		return seuil;
	}

	public static void setSeuil(String seuil) {
		AlarmeGaz.seuil = seuil;
	}

	@Override
	public void receptionGaz(Date dateApparition, String localisation, int type, int importance) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
