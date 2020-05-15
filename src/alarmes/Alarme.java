package alarmes;
import java.time.LocalDateTime;
import java.util.EventListener;


/**
 * Classe Alarme servant de squelette aux différents types d'alarmes possibles
 * 
 * @author Theo Bernardin / Enzo Masson
 * @version 1.0
 */


public abstract class Alarme implements EventListener {
	
	/*
	 * idAlarme : entier statique represantant l'id de l'alarme
	 */
	protected static int idAlarme;
	/*
	 * idCapteur : entier represantant l'id du capteur declanchant l'alarme
	 */
	protected int idCapteur;
	/*
	 * date : date a laquelle s'est declenchee l'alarme
	 */
	protected LocalDateTime date;
	/*
	 * localisation : string indiquant ou l'alarme s'est declenchee
	 */
	protected String localisation;
	/*
	 * importance : le niveau d'importance de l'alarme declenchee
	 */
	protected int importance;
	
	
	
	/** Creer une alarme avec les differents elements en parametres
	 * @param idCapteur : le capteur qui declenche l'alarme
	 * @param localDateTime : la date a laquelle l'alarme est cree
	 * @param localisation : la localisation de l'alarme
	 * @param importance : le niveau d'importance de l'alarme
	*/
	public Alarme(int idCapteur,LocalDateTime localDateTime, String localisation,int importance) {
		idAlarme++;
		this.idCapteur = idCapteur;
		this.date = localDateTime;
		this.localisation = localisation;
		this.importance = importance;
	}
	
	/** Methode renvoyant les informations de l'alarme
	 * 
	 */
	public abstract String getInfos();
	
	
	/** Methode renvoyant la structure de l'alarme
	 * 
	 */
	public abstract String toString();

	
	
	/** Renvoi l'id de l'alarme 
	 * 
	 * @return un entier qui est l'id de l'alarme  
	 */
	public int getIdAlarme() {
		return idAlarme;
	}



	/** Set l'id de l'alarme
	 * 
	 * @param idAlarme : un entier representant l'id de l'alarme
	 */
	public void setIdAlarme(int idAlarme) {
		this.idAlarme = idAlarme;
	}



	/** Renvoi l'id du capteur de l'alarme
	 * 
	 * @return un entier qui est l'id du capteur
	 */
	public int getIdCapteur() {
		return idCapteur;
	}



	/** Set l'id du capteur de l'alarme
	 * 
	 * @param idCapteur : un entier representant l'id du capteur de l'alarme
	 */
	public void setIdCapteur(int idCapteur) {
		this.idCapteur = idCapteur;
	}
	
}
