import java.util.Date;

public interface AlerteIncendieListener {
	public void receptionIncendie(Date dateApparition, String localisation,int importance);
}
