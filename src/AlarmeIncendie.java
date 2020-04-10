import java.util.Date;


public class AlarmeIncendie implements AlerteIncendieListener{
	
	public AlarmeIncendie() {
		super();
	}

	
	@Override
	public String receptionIncendie(Date dateApparition, String localisation, int importance) {
		// TODO Auto-generated method stub
		return localisation+" ("+dateApparition+") : "+importance+"/3";
	}
	
	
}
