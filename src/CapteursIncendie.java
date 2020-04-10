import java.util.EventListener;
import java.util.GregorianCalendar;

public class CapteursIncendie extends Capteurs {
	
	private boolean fumee;
	private int intensite;
	
	public CapteursIncendie(int id,String local,EventListener e) {
		super(id,local,e);
		this.fumee = false;
		this.intensite = 0;
	}
	

	public boolean isFumee() {
		return fumee;
	}

	public void setFumee(boolean fumee) {
		this.fumee = fumee;
		if(fumee == true) {
			int importance = (int)(Math.random() * 2+1);
			this.generateAlarmeIncendie(this.getLocalisation(), importance);
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
