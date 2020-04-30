import java.time.LocalDateTime;
import java.util.Date;
import java.util.EventListener;

public class CapteursIncendie extends Capteurs {
	
	
	public CapteursIncendie(String local) {
		super(local);
	}
	

	public AlarmeIncendie alerteIncendie(LocalDateTime date, int importance) {
		AlarmeIncendie incend = new AlarmeIncendie(this.getId(),date,this.getLocalisation(),importance);
		
		
		for(AlerteIncendieListener e : this.getAlarmesIncendie()) {
			e.receptionIncendie(incend);
		}
		
		
		return incend;
	}


	public AlerteIncendieListener[] getAlarmesIncendie() {
        return this.events.getListeners(AlerteIncendieListener.class);
    }
	
	
	public void addAlerteIncendieListener(AlerteIncendieListener e) {
		this.events.add(AlerteIncendieListener.class, e);
	}
	
	
	public void removeAlerteIncendieListener(AlerteIncendieListener e) {
        this.events.remove(AlerteIncendieListener.class, e);
    }
	
}
