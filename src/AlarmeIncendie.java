import java.util.GregorianCalendar;

public class AlarmeIncendie {
	
	private GregorianCalendar date;
	private String localisation; 
	private int importance;
	private String niveau;
	
	public AlarmeIncendie(GregorianCalendar date, String localisation, int importance, int niveau) {
		super();
		if(importance>3 || importance<1 || niveau>100 || niveau<1) {
			System.out.println("Erreur de saisie !");
		}
		else {
			this.date = date;
			this.localisation = localisation;
			this.importance = importance;
		}
	}

	public GregorianCalendar getDate() {
		return date;
	}

	public String getLocalisation() {
		return localisation;
	}

	public int getImportance() {
		return importance;
	}

	public String getNiveau() {
		return niveau;
	}
	
}
