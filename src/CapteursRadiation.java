import java.util.EventListener;
import java.util.GregorianCalendar;

public class CapteursRadiation extends Capteurs {

	private int niveau;
	private int seuil;
	private MoniteurB moniteur;

	
	
	public CapteursRadiation(int id,String localisation,int seuil,MoniteurB moni) {
		super(id,localisation);
		this.niveau = 0;
		this.seuil = seuil;
		this.moniteur = moni;
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
			this.moniteur.addAlarmeRadiation(this.generateAlarmeRadiation(this.getLocalisation(),importance,this.niveau));
			this.fireAlarmeRad();
		}
	}

	private AlarmeRadiation generateAlarmeRadiation(String local,int importance,int niveau) {
		return new AlarmeRadiation(new GregorianCalendar().getTime(),local,importance,niveau);
	}
	
	
	public void fireAlarmeRad() {
		this.moniteur.alerteRadiation(this.moniteur.getListeAlarmeRadiation().size());
	}
	
	
}
