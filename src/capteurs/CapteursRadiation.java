package capteurs;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.EventListener;
import java.util.GregorianCalendar;

import Alarmes.AlarmeRadiation;
import AlarmesListener.AlerteRadiationListener;

public class CapteursRadiation extends Capteurs {

	
	public CapteursRadiation(String local) {
		super(local);
	}
	

	public AlarmeRadiation alerteRad(LocalDateTime date, int importance, int niveau) {
		AlarmeRadiation rad = new AlarmeRadiation(this.getId(),date,this.getLocalisation(),importance,niveau);
		
		
		for(AlerteRadiationListener e : this.getAlarmesRad()) {
			e.receptionRadiation(rad);
		}
		
		
		return rad;
	}


	public AlerteRadiationListener[] getAlarmesRad() {
        return this.events.getListeners(AlerteRadiationListener.class);
    }
	
	
	public void addAlerteRadiationListener(AlerteRadiationListener e) {
		this.events.add(AlerteRadiationListener.class, e);
	}
	
	
	public void removeAlerteIncendieListener(AlerteRadiationListener e) {
        this.events.remove(AlerteRadiationListener.class, e);
    }
	
	
}
