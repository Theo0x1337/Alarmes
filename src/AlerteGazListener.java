import java.util.Date;
import java.util.EventListener;

public interface AlerteGazListener extends EventListener  {
	public void receptionGaz(AlarmeGaz e);
}
