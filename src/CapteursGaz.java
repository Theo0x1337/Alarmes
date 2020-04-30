import java.time.LocalDateTime;
import java.util.Date;
import java.util.EventListener;
import java.util.GregorianCalendar;

public class CapteursGaz extends Capteurs {
	
	
	public CapteursGaz(String local) {
		super(local);
	}
	

	public AlarmeGaz alerteGaz(LocalDateTime localDateTime, int importance, String type) {
		AlarmeGaz gaz = new AlarmeGaz(this.getId(),localDateTime,this.getLocalisation(),importance,type);
		
		
		for(AlerteGazListener e : this.getAlarmesGaz()) {
			e.receptionGaz(gaz);
		}
		
		
		return gaz;
	}


	public AlerteGazListener[] getAlarmesGaz() {
        return this.events.getListeners(AlerteGazListener.class);
    }
	
	
	public void addAlerteGazListener(AlerteGazListener e) {
		this.events.add(AlerteGazListener.class, e);
	}
	
	
	public void removeAlerteGazListener(AlerteGazListener e) {
        this.events.remove(AlerteGazListener.class, e);
    }
	
}
