import java.util.Date;
import java.util.EventListener;

public interface AlerteRadiationListener extends EventListener {
	public String receptionRadiation(Date dateApparition, String localisation,int niveau,int importance);
	
}
