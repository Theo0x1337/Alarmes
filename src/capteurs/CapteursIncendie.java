package capteurs;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.EventListener;

import alarmes.AlarmeIncendie;
import alarmesListener.AlerteIncendieListener;


/**
 * Classe CapteursIncendie representant un objet Capteurs gerant les alarmes de type incendie
 * 
 * @author Theo Bernardin / Enzo Masson
 * @version 1.0
 */

public class CapteursIncendie extends Capteurs {
	
	/** Creer un objet CapteursIncendie a la localisation indiquee
	 * 
	 * @param local : String representant la localisation du capteur
	 */
	public CapteursIncendie(String local) {
		super(local);
	}
	
	
	
	/** Methode generant une AlarmeIncendie lorsqu'un CapteursIncendie detecte une anomalie et l'ajoutant dans la liste des Alarmes du capteur
	 * 
	 * @param localDateTime : LocalDateTime a laquelle le capteur genere l'alarme
	 * @param importance : entier representant le niveau d'importance de l'alarme
	 * @return une AlerteIncendie representant l'alarme generee par le capteur
	 */
	public AlarmeIncendie alerteIncendie(LocalDateTime date, int importance) {
		AlarmeIncendie incend = new AlarmeIncendie(this.getId(),date,this.getLocalisation(),importance);
		
		
		for(AlerteIncendieListener e : this.getAlarmesIncendie()) {
			e.receptionIncendie(incend);
		}
		
		
		return incend;
	}

	
	/** Renvoi la liste des alertes (evenement declenché par les alarmes) generees par le capteur de type incendie
	 * 
	 * @return Toutes les alertes de type incendie generees et qui se trouvent dans la liste des alarmes
	 */
	public AlerteIncendieListener[] getAlarmesIncendie() {
        return this.events.getListeners(AlerteIncendieListener.class);
    }
	
	
	/** Ajoute une AlerteIncendie dans la liste des alertes generees par les Alarmes
	 * 
	 * @param e : AlertIncendieListener l'evenement declenche a la creation d'une alarme de type incendie
	 */
	public void addAlerteIncendieListener(AlerteIncendieListener e) {
		this.events.add(AlerteIncendieListener.class, e);
	}
	
	
	/** Supprime une AlerteIncendie dans la liste des alertes generees par les Alarmes
	 * 
	 * @param e : AlertIncendieListener l'evenement declenche a la creation d'une alarme de type incendie
	 */
	public void removeAlerteIncendieListener(AlerteIncendieListener e) {
        this.events.remove(AlerteIncendieListener.class, e);
    }
	
}
