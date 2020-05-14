package AlarmesListener;
import java.util.EventListener;
import Alarmes.AlarmeIncendie;


/**
 * Interface AlerteIncendieListener heritant de EventListener pour ecouter les alarme de type incendie
 * 
 * @author Theo Bernardin / Enzo Masson
 * @version 1.0
 */

public interface AlerteIncendieListener extends EventListener  {
	
	
	/** Action declenchee a la reception d'une alarme de type incendie generee par un capteur
	 * 
	 * @param e : AlarmeIncendie representant l'alarme incendie declencee par un capteur
	 */
	public void receptionIncendie(AlarmeIncendie e);
}
