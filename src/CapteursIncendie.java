import java.util.EventListener;

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
	}

	public int getIntensite() {
		return intensite;
	}

	public void setIntensite(int intensite) {
		this.intensite = intensite;
	}
	
	
}
