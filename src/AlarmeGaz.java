import java.util.Date;
import java.util.GregorianCalendar;

public class AlarmeGaz {

	private Date date;
	private String localisation; 
	private int importance;
	private String type;
	
	public AlarmeGaz(Date date, String localisation, int importance, String type) {
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

	public String getType() {
		return type;
	}
	
	


}
