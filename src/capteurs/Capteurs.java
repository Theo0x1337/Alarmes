package capteurs;
import javax.swing.event.EventListenerList;


/**
 * Classe Capteurs servant de classe mere aux differents type de capteurs possibles
 * 
 * @author Theo Bernardin / Enzo Masson
 * @version 1.0
 */


public abstract class Capteurs {
	/**
	 * id : entier correspondant a l'id du capteur
	 */
	protected int id;
	/**
	 * localisation : String representant la localisation du capteur
	 */
	protected String localisation;
	/**
	 * events : EventListenerList represenant la liste des evenements (alarmes) generee par le capteur
	 */
	protected final EventListenerList events = new EventListenerList();
	
	
	/** Creer un capteur à une localisation definie en parametre
	 * 
	 * @param local : String localisation du capteur
	 */
	public Capteurs(String local) {
		this.id++;
		this.localisation = local;
	}
	
	
	/** Methode qui renvoi la liste des alarmes generee par le capteur
	 * 
	 * @return une EventListenerList contenant la liste des alarmes declenchees par le capteur
	 */
	public EventListenerList getEvents() {
		return events;
	}

	/** Methode qui renvoi l'id du capteur
	 * 
	 * @return un entier representant l'id du capteur
	 */
	public int getId() {
		return id;
	}

	/** Methode permettant de set l'id du capteur
	 * 
	 * @param id : entier representant l'id du capteur
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	
	/** Methode qui renvoi la localisation du capteur
	 * 
	 * @return String localisation du capteur
	 */
	public String getLocalisation() {
		return localisation;
	}

	
	/** Methode permettant de set la localisation du capteur
	 * 
	 * @param localisation : String qui represente la localisation du capteur
	 */
	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}
	
	
	
}
