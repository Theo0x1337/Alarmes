import java.time.LocalDateTime;
import java.util.Date;


public class AlarmeRadiation extends Alarme {

	private int niveau;
	
	public AlarmeRadiation(int idCapteur,LocalDateTime date, String localisation, int importance, int niveau) {
		super(idCapteur,date,localisation,importance);
		this.niveau = niveau;
	}

	public int getNiveau() {
		return niveau;
	}
	

	@Override
	public String getInfos() {
		// TODO Auto-generated method stub
		return "idAlarme : "+this.idAlarme+" \nassocié au capteur : "+this.idCapteur+" \nà la date "+ this.date + " \nlocalisée "+this.localisation +", \nle niveau de radiations detecté est de "+this.niveau +" \net est jugé d'importance "+this.importance;
	}
	
	
	public String toString() {
		return "Alarme radiation id : "+this.idAlarme;
	}
	
	
}
