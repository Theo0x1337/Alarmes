package alarmesListener;
import java.util.EventListener;

import alarmes.AlarmeGaz;


/**
 * Interface AlerteGazListener heritant de EventListener pour ecouter les alarme de type gaz
 * 
 * @author Theo Bernardin / Enzo Masson
 * @version 1.0
 */

public interface AlerteGazListener extends EventListener  {
	
	/** Action declenchee à la reception d'un objet AlarmeGaz
	 * 
	 * @param e : AlarmeGaz reprensantant une alarme de type gaz declenchee par un capteur
	 */
	public void receptionGaz(AlarmeGaz e);
}
