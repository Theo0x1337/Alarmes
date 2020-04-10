import java.util.EventListener;
import java.util.GregorianCalendar;

public class CapteursIncendie extends Capteurs {
	
	private boolean fumee;
	private int intensite;
	private MoniteurA moniteur;
	
	public CapteursIncendie(int id,String local,MoniteurA moni) {
		super(id,local);
		this.fumee = false;
		this.intensite = 0;
		this.moniteur = moni;
	}
	

	public boolean isFumee() {
		return fumee;
	}

	public void setFumee(boolean fumee) {
		this.fumee = fumee;
		if(fumee == true) {
			int importance = (int)(Math.random() * 2+1);
			this.moniteur.addAlarmeIncendie(this.generateAlarmeIncendie(this.getLocalisation(), importance));
		}
	}

	public int getIntensite() {
		return intensite;
	}

	public void setIntensite(int intensite) {
		this.intensite = intensite;
	}
	
	
	private AlarmeIncendie generateAlarmeIncendie(String local,int importance) {
		return new AlarmeIncendie(new GregorianCalendar().getTime(),local,importance);
	}
	
}
