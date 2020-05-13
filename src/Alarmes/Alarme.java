package Alarmes;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.EventListener;

public abstract class Alarme implements EventListener {
	protected static int idAlarme;
	protected int idCapteur;
	protected LocalDateTime date;
	protected String localisation;
	protected int importance;
	
	
	
	
	public Alarme(int idCapteur,LocalDateTime localDateTime, String localisation,int importance) {
		idAlarme++;
		this.idCapteur = idCapteur;
		this.date = localDateTime;
		this.localisation = localisation;
		this.importance = importance;
	}


	public abstract String getInfos();
	
	
	public abstract String toString();

	public int getIdAlarme() {
		return idAlarme;
	}




	public void setIdAlarme(int idAlarme) {
		this.idAlarme = idAlarme;
	}




	public int getIdCapteur() {
		return idCapteur;
	}




	public void setIdCapteur(int idCapteur) {
		this.idCapteur = idCapteur;
	}




	public LocalDateTime getDate() {
		return date;
	}




	public void setDate(LocalDateTime date) {
		this.date = date;
	}




	public String getLocalisation() {
		return localisation;
	}




	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}




	public int getImportance() {
		return importance;
	}




	public void setImportance(int importance) {
		this.importance = importance;
	}
	
	
	
	
	
	
}
