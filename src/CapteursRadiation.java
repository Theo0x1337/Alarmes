import java.util.EventListener;
import java.util.GregorianCalendar;

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
			int importance = (int)(Math.random() * 2+1);
			this.generateAlarmeRadiation(this.getLocalisation(),importance,this.niveau);
		}
	}

	private AlarmeRadiation generateAlarmeRadiation(String local,int importance,int niveau) {
		return new AlarmeRadiation(new GregorianCalendar().getTime(),local,importance,niveau);
	}
	
	
	
	
}
