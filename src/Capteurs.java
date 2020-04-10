
public abstract class Capteurs {
	private int id;
	private String localisation;
	
	public Capteurs(int id, String local) {
		this.id = id;
		this.localisation = local;
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
