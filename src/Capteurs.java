import java.util.EventListener;

public abstract class Capteurs {
	private int id;
	private String localisation;
	private EventListener ecoute;
	
	public Capteurs(int id, String local,EventListener e) {
		this.id = id;
		this.localisation = local;
		this.ecoute = e;
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
	
	
	public void add(EventListener e) {
		this.ecoute = e;
	}
	
}
