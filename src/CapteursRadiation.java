import java.util.EventListener;

public class CapteursRadiation extends Capteurs {

	private int niveau;
	private int seuil;
	
	public CapteursRadiation(int id,String localisation, EventListener e,int seuil) {
		super(id,localisation,e);
		this.niveau = 0;
		this.seuil = seuil;
	}

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		if(0 <= niveau && niveau <= 100) {
			this.niveau = niveau;
		}
		if(niveau > seuil) {
			this.generateAlarmeRadiation();
		}
	}

	private AlarmeRadiation generateAlarmeRadiation() {
		return new AlarmeRadiation();
	}
	
	
	
	
}
