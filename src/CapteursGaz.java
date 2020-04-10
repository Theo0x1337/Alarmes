import java.util.EventListener;
import java.util.GregorianCalendar;

public class CapteursGaz extends Capteurs {
	
	private String type;
	private MoniteurA moniteurA;
	private MoniteurB moniteurB;

	
	
	public CapteursGaz(int id,String localisation,MoniteurA moniA, MoniteurB moniB) {
		super(id,localisation);
		this.type = "";
		this.moniteurA = moniA;
		this.moniteurB = moniB;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
		if(type != "") {
			int importance = (int)(Math.random() * 2+1);
			this.moniteurA.addAlarmeGaz(this.generateAlarmeGaz(this.getLocalisation(), importance, this.type));
		}
	}
	
	
	private AlarmeGaz generateAlarmeGaz(String local,int importance,String type) {
		return new AlarmeGaz(new GregorianCalendar().getTime(),local,importance,type);
	}
	
	
	public void fireAlarmeRad() {
		this.moniteurB.alerteRadiation(this.moniteurB.getListeAlarmeRadiation().size());
	}
	
	
	public void fireAlarmeIncendie() {
		this.moniteurA.alerteIncendie(this.moniteurA.getListeAlarmeIncendie().size());
	}
	
}
