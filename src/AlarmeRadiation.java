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
		return "idAlarme : "+this.idAlarme+" associé au capteur : "+this.idCapteur+" à la date "+ this.date + " localisée "+this.localisation +", le niveau de radiations detecté est de "+this.niveau +" et est jugé d'importance "+this.importance;
	}
	
}
