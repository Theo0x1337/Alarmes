import java.util.Date;


public class AlarmeIncendie implements AlerteIncendieListener{

	@Override
	public String receptionIncendie(Date dateApparition, String localisation, int importance) {
		// TODO Auto-generated method stub
		return localisation+" ("+dateApparition+") : "+importance+"/3";
	}
	
	
}
