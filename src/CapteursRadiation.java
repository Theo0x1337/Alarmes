
public class CapteursRadiation extends Capteurs {

	private int niveau;
	
	public CapteursRadiation(int id,String localisation) {
		super(id,localisation);
		this.niveau = 0;
	}

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		if(0 <= niveau && niveau <= 100) {
			this.niveau = niveau;
		}
	}
	
	
	
	
}
