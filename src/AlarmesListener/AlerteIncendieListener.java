package AlarmesListener;
import java.util.Date;
import java.util.EventListener;

import Alarmes.AlarmeIncendie;

public interface AlerteIncendieListener extends EventListener  {
	public void receptionIncendie(AlarmeIncendie e);
}
