import java.util.EventListener;

public class CapteursGaz extends Capteurs {
	
	public String type;
	
	
	public CapteursGaz(int id,String localisation,EventListener e) {
		super(id,localisation,e);
		this.type = "";
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}
	
	
	
	
	
	
}
