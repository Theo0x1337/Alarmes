package alarmesListener;
import java.util.EventListener;

import alarmes.AlarmeRadiation;

/**
 * Interface AlerteRadiationListener heritant de EventListener pour ecouter les alarme de type radiation
 * 
 * @author Theo Bernardin / Enzo Masson
 * @version 1.0
 */


public interface AlerteRadiationListener extends EventListener {
	
	
	/** Action declenchee a la reception d'une alarme de type radiation emise par un capteur
	 * 
	 * @param e : AlarmeRadiation representant l'alarme de type radiation generee par un capteur
	 */
	public void receptionRadiation(AlarmeRadiation e);
	
}
