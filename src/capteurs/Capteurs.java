import javax.swing.event.EventListenerList;


public abstract class Capteurs {
	protected int id;
	protected String localisation;
	protected final EventListenerList events = new EventListenerList();
	
	
	
	public Capteurs(String local) {
		this.id++;
		this.localisation = local;
	}
	
	
	public EventListenerList getEvents() {
		return events;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocalisation() {
		return localisation;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}
	
	
	
}
