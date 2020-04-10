
public class CapteursGaz extends Capteurs {
	
	public String type;
	
	
	public CapteursGaz(int id,String localisation) {
		super(id,localisation);
		this.type = "";
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}
	
	
	
	
	
	
}
