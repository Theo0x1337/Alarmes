package alarmes;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Classe AlarmeIncendie heritant de Alarme et gerant les alarmes de type incendie
 * 
 * @author Theo Bernardin / Enzo Masson
 * @version 1.0
 */

public class AlarmeIncendie extends Alarme {
	
	
	/** Creer un objet AlarmeIncendie a partir des elements en parametre
	 * 
	 * @param idCapteur : entier id du capteur ayant emit l'alerte
	 * @param localDateTime : localDateTime a laquelle l'alarme est declenchee
	 * @param localisation : String ou l'alarme est localisee
	 * @param importance : entier representant le niveau d'importance de l'alarme
	 */
	public AlarmeIncendie(int idCapteur,LocalDateTime date, String localisation, int importance) {
		super(idCapteur,date,localisation,importance);
	}

	
	
	/**
	 * @see voir la methode getInfos dans la classe mere
	 */
	@Override
	public String getInfos() {
		// TODO Auto-generated method stub
		return "idAlarme : "+this.idAlarme+" \nassocié au capteur : "+this.idCapteur+" \nà la date "+ this.date + " \nlocalisée "+this.localisation + " \net d'importance "+this.importance;
	}

	
	/**
	 * @see voir la methode toString dans la classe mere
	 */
	public String toString() {
		return "Alarme incendie id : "+this.idAlarme;
	}
	
	
}
