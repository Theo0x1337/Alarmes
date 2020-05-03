
import java.time.LocalDateTime;
import java.util.Date;

public class AlarmeIncendie extends Alarme {
	
	
	public AlarmeIncendie(int idCapteur,LocalDateTime date, String localisation, int importance) {
		super(idCapteur,date,localisation,importance);
	}


	@Override
	public String getInfos() {
		// TODO Auto-generated method stub
		return "idAlarme : "+this.idAlarme+" \nassocié au capteur : "+this.idCapteur+" \nà la date "+ this.date + " \nlocalisée "+this.localisation + " \net d'importance "+this.importance;
	}

	
	
	public String toString() {
		return "Alarme incendie id : "+this.idAlarme;
	}
	
	
}
