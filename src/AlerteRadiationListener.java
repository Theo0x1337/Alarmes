import java.util.Date;

public interface AlerteRadiationListener {
	public void receptionRadiation(Date dateApparition, String localisation,int niveau,int importance);
	
}
