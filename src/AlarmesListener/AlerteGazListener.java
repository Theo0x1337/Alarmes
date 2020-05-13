package AlarmesListener;
import java.util.Date;
import java.util.EventListener;

import Alarmes.AlarmeGaz;

public interface AlerteGazListener extends EventListener  {
	public void receptionGaz(AlarmeGaz e);
}
