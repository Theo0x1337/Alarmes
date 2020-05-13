package AlarmesListener;
import java.util.Date;
import java.util.EventListener;

import Alarmes.AlarmeRadiation;

public interface AlerteRadiationListener extends EventListener {
	public void receptionRadiation(AlarmeRadiation e);
	
}
