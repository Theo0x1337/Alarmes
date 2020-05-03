import java.time.LocalDateTime;
import java.util.Date;

public class AlarmeGaz extends Alarme {


	private String type;
	
	public AlarmeGaz(int idCapteur,LocalDateTime localDateTime, String localisation, int importance, String type) {
		super(idCapteur,localDateTime,localisation,importance);
		this.type = type;
	}

	public String getType() {
		return type;
	}
	

	@Override
	public String getInfos() {
		// TODO Auto-generated method stub
		return "idAlarme : "+this.idAlarme+" \nassocié au capteur : "+this.idCapteur+" \nà la date "+ this.date + " \nlocalisée "+this.localisation +", \nle gaz detecté est "+this.type +" \net est jugé d'importance "+this.importance;
	}
	
	public String toString() {
		return "Alarme gaz id : "+this.idAlarme;
	}
	

}
