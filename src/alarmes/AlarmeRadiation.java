package alarmes;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Classe AlarmeRadiation heritant de Alarme et gerant les alarmes de type radiation
 * 
 * @author Theo Bernardin / Enzo Masson
 * @version 1.0
 */

public class AlarmeRadiation extends Alarme {

	
	/**
	 * niveau : entier representant le niveau de radiation detecte par le capteur
	 */
	private int niveau;
	
	
	/** Creer un objet AlarmeRadiation a partir des elements en parametre
	 * 
	 * @param idCapteur : entier id du capteur ayant emit l'alerte
	 * @param localDateTime : localDateTime a laquelle l'alarme est declenchee
	 * @param localisation : String ou l'alarme est localisee
	 * @param importance : entier representant le niveau d'importance de l'alarme
	 * @param niveau : entier representant le niveau de radiation detecte
	 */
	public AlarmeRadiation(int idCapteur,LocalDateTime date, String localisation, int importance, int niveau) {
		super(idCapteur,date,localisation,importance);
		this.niveau = niveau;
	}

	
	/** Renvoi le niveau de radiation detecte par le capteur
	 * 
	 * @return un entier, le niveau de radiation detecte
	 */
	public int getNiveau() {
		return niveau;
	}
	
	/**
	 * @see voir la methode getInfos dans la classe mere
	 */
	@Override
	public String getInfos() {
		// TODO Auto-generated method stub
		return "idAlarme : "+this.idAlarme+" \nassocié au capteur : "+this.idCapteur+" \nà la date "+ this.date + " \nlocalisée "+this.localisation +", \nle niveau de radiations detecté est de "+this.niveau +" \net est jugé d'importance "+this.importance;
	}
	
	/**
	 * @see voir la methode toString dans la classe mere
	 */
	public String toString() {
		return "Alarme radiation id : "+this.idAlarme;
	}
	
	
}
