package capteurs;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.EventListener;
import java.util.GregorianCalendar;

import Alarmes.AlarmeRadiation;
import AlarmesListener.AlerteRadiationListener;


/**
 * Classe CapteursRadiation representant un objet Capteurs gerant les alarmes de type radiation
 * 
 * @author Theo Bernardin / Enzo Masson
 * @version 1.0
 */

public class CapteursRadiation extends Capteurs {

	
	/** Creer un objet CapteursRadiation a la localisation indiquee
	 * 
	 * @param local : String representant la localisation du capteur
	 */
	public CapteursRadiation(String local) {
		super(local);
	}
	
	
	/** Methode generant une AlarmeRadiation lorsqu'un CapteursRadiation detecte une anomalie et l'ajoutant dans la liste des Alarmes du capteur
	 * 
	 * @param localDateTime : LocalDateTime a laquelle le capteur genere l'alarme
	 * @param importance : entier representant le niveau d'importance de l'alarme
	 * @param niveau : entier le niveau de radiation detecte par le capteur
	 * @return une AlarmeRadiation representant l'alarme generee par le capteur
	 */
	public AlarmeRadiation alerteRad(LocalDateTime date, int importance, int niveau) {
		AlarmeRadiation rad = new AlarmeRadiation(this.getId(),date,this.getLocalisation(),importance,niveau);
		
		
		for(AlerteRadiationListener e : this.getAlarmesRad()) {
			e.receptionRadiation(rad);
		}
		
		
		return rad;
	}
	

	/** Renvoi la liste des alertes (evenement declenché par les alarmes) generees par le capteur de type radiation
	 * 
	 * @return Toutes les alertes de type radiation generees et qui se trouvent dans la liste des alarmes
	 */
	public AlerteRadiationListener[] getAlarmesRad() {
        return this.events.getListeners(AlerteRadiationListener.class);
    }
	
	
	/** Ajoute une AlerteRadiation dans la liste des alertes generees par les Alarmes
	 * 
	 * @param e : AlertRadiationListener l'evenement declenche a la creation d'une alarme de type radiation
	 */
	public void addAlerteRadiationListener(AlerteRadiationListener e) {
		this.events.add(AlerteRadiationListener.class, e);
	}
	
	
	
	/** Supprime une AlerteRadiation dans la liste des alertes generees par les Alarmes
	 * 
	 * @param e : AlertRadiationListener l'evenement declenche a la creation d'une alarme de type radiation
	 */
	public void removeAlerteIncendieListener(AlerteRadiationListener e) {
        this.events.remove(AlerteRadiationListener.class, e);
    }
	
	
}
