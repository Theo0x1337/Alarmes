package capteurs;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.EventListener;
import java.util.GregorianCalendar;

import Alarmes.AlarmeGaz;
import AlarmesListener.AlerteGazListener;


/**
 * Classe CapteursGaz representant un objet Capteurs gerant les alarmes de type gaz
 * 
 * @author Theo Bernardin / Enzo Masson
 * @version 1.0
 */


public class CapteursGaz extends Capteurs {
	
	/** Creer un objet CapteursGaz a la localisation indiquee
	 * 
	 * @param local : String representant la localisation du capteur
	 */
	public CapteursGaz(String local) {
		super(local);
	}
	
	
	
	/** Methode generant une AlarmeGaz lorsqu'un CapteursGaz detecte une anomalie et l'ajoutant dans la liste des Alarmes du capteur
	 * 
	 * @param localDateTime : LocalDateTime a laquelle le capteur genere l'alarme
	 * @param importance : entier representant le niveau d'importance de l'alarme
	 * @param type : String le type de gaz detecte par le capteur
	 * @return une AlarmeGaz representant l'alarme generee par le capteur
	 */
	public AlarmeGaz alerteGaz(LocalDateTime localDateTime, int importance, String type) {
		AlarmeGaz gaz = new AlarmeGaz(this.getId(),localDateTime,this.getLocalisation(),importance,type);
		
		
		for(AlerteGazListener e : this.getAlarmesGaz()) {
			e.receptionGaz(gaz);
		}
		
		
		return gaz;
	}

	
	/** Renvoi la liste des alertes (evenement declenché par les alarmes) generees par le capteur de type gaz
	 * 
	 * @return Toutes les alertes de type gaz generees et qui se trouvent dans la liste des alarmes
	 */
	public AlerteGazListener[] getAlarmesGaz() {
        return this.events.getListeners(AlerteGazListener.class);
    }
	
	/** Ajoute une AlerteGaz dans la liste des alertes generees par les Alarmes
	 * 
	 * @param e : AlertGazListener l'evenement declenche a la creation d'une alarme de type gaz
	 */
	public void addAlerteGazListener(AlerteGazListener e) {
		this.events.add(AlerteGazListener.class, e);
	}
	
	/** Supprime une AlerteGaz dans la liste des alertes generees par les Alarmes
	 * 
	 * @param e: AlertGazListener l'evenement declenche a la creation d'une alarme de type gaz
	 */
	public void removeAlerteGazListener(AlerteGazListener e) {
        this.events.remove(AlerteGazListener.class, e);
    }
	
}
