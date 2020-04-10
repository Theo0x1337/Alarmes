import java.util.Date;
import java.util.EventListener;

public interface AlerteIncendieListener extends EventListener  {
	public String receptionIncendie(Date dateApparition, String localisation,int importance);
}
