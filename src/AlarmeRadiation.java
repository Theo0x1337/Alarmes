import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;


public class AlarmeRadiation {
	
	private Date date;
	private String localisation; 
	private int importance;
	private int niveau;
	
	public AlarmeRadiation(Date date, String localisation, int importance, int niveau) {
		super();
		if(importance>3 || importance<1 || niveau>100 || niveau<1) {
			System.out.println("Erreur de saisie !");
		}
		else {
			this.date = date;
			this.localisation = localisation;
			this.importance = importance;
			this.niveau = niveau;
		}
	}

	public Date getDate() {
		return date;
	}

	public String getLocalisation() {
		return localisation;
	}

	public int getImportance() {
		return importance;
	}

	public int getNiveau() {
		return niveau;
	}
	
	
	public String toString() {
		return "le "+this.date+" localisée : "+this.localisation+" d\'importance "+this.importance + " de niveau : "+this.niveau;
	}
	
}
