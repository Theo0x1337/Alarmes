package alarmes;
import java.time.LocalDateTime;
import java.util.Date;


/**
 * Classe AlarmeGaz heritant de Alarme et gerant les alarmes de type gaz
 * 
 * @author Theo Bernardin / Enzo Masson
 * @version 1.0
 */


public class AlarmeGaz extends Alarme {

	/**
	 * type : une chaine de caracteres represantant le type de gaz
	 */
	private String type;
	
	
	
	/** Creer un objet AlarmeGaz a partir des elements en parametre
	 * 
	 * @param idCapteur : entier id du capteur ayant emit l'alerte
	 * @param localDateTime : localDateTime a laquelle l'alarme est declenchee
	 * @param localisation : String ou l'alarme est localisee
	 * @param importance : entier representant le niveau d'importance de l'alarme
	 * @param type : String le type de gaz detecte
	 */
	public AlarmeGaz(int idCapteur,LocalDateTime localDateTime, String localisation, int importance, String type) {
		super(idCapteur,localDateTime,localisation,importance);
		this.type = type;
	}

	
	/** Renvoi le type de gaz detecte
	 * 
	 * @return une String representant le type de gaz pour laquelle l'alarme s'est declenchee
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * @see voir la methode getInfos dans la classe mere
	 */
	@Override
	public String getInfos() {
		// TODO Auto-generated method stub
		return "idAlarme : "+this.idAlarme+" \nassocié au capteur : "+this.idCapteur+" \nà la date "+ this.date + " \nlocalisée "+this.localisation +", \nle gaz detecté est "+this.type +" \net est jugé d'importance "+this.importance;
	}
	
	
	/**
	 * @see voir la methode toString dans la classe mere
	 */
	public String toString() {
		return "Alarme gaz id : "+this.idAlarme;
	}
	

}
