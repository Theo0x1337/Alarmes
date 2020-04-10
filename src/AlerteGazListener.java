import java.util.Date;

public interface AlerteGazListener {
	public void receptionGaz(Date dateApparition, String localisation,int type,int importance);
}
