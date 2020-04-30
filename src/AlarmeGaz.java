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
		return "idAlarme : "+this.idAlarme+" associé au capteur : "+this.idCapteur+" à la date "+ this.date + " localisée "+this.localisation +", le gaz detecté est "+this.type +" et est jugé d'importance "+this.importance;
	}

}
