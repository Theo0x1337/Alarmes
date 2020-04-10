import java.util.GregorianCalendar;

public class AlarmeRadiation {
	
	private GregorianCalendar date;
	private String localisation; 
	private int importance;
	private int niveau;
	
	public AlarmeRadiation(GregorianCalendar date, String localisation, int importance, int niveau) {
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

	public GregorianCalendar getDate() {
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
	
	
	
	
}
