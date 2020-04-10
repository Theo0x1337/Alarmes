import java.util.EventListener;
import java.util.GregorianCalendar;

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
		if(type != "") {
			int importance = (int)(Math.random() * 2+1);
			this.generateAlarmeGaz(this.getLocalisation(), importance, this.type);
		}
	}
	
	
	private AlarmeGaz generateAlarmeGaz(String local,int importance,String type) {
		return new AlarmeGaz(new GregorianCalendar().getTime(),local,importance,type);
	}
	
}
