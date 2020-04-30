
import java.time.LocalDateTime;
import java.util.Date;

public class AlarmeIncendie extends Alarme {
	
	
	public AlarmeIncendie(int idCapteur,LocalDateTime date, String localisation, int importance) {
		super(idCapteur,date,localisation,importance);
	}


	@Override
	public String getInfos() {
		// TODO Auto-generated method stub
		return "idAlarme : "+this.idAlarme+" associé au capteur : "+this.idCapteur+" à la date "+ this.date + " localisée "+this.localisation + " et d'importance "+this.importance;
	}

}
