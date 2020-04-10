
import java.util.Date;
import java.util.GregorianCalendar;

public class AlarmeIncendie {
	
	private Date date;
	private String localisation; 
	private int importance;
	
	
	public AlarmeIncendie(Date date, String localisation, int importance) {
		super();
		if(importance>3 || importance<1) {
			System.out.println("Erreur de saisie !");
		}
		else {
			this.date = date;
			this.localisation = localisation;
			this.importance = importance;
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

}
