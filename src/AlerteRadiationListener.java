import java.util.Date;
import java.util.EventListener;

public interface AlerteRadiationListener extends EventListener {
	public void receptionRadiation(AlarmeRadiation e);
	
}
