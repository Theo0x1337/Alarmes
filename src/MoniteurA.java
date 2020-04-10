import java.util.ArrayList;

public class MoniteurA {
	
	static String type = "A";
	ArrayList<AlarmeGaz> listeAlarmeGaz = new ArrayList<AlarmeGaz>();
	ArrayList<AlarmeIncendie> listeAlarmeIncendie = new ArrayList<AlarmeIncendie>();
	
	public MoniteurA(ArrayList<AlarmeGaz> listeAlarmeGaz, ArrayList<AlarmeIncendie> listeAlarmeIncendie) {
		super();
		this.listeAlarmeGaz = listeAlarmeGaz;
		this.listeAlarmeIncendie = listeAlarmeIncendie;
	}

	public MoniteurA() {
		super();
	}

	public ArrayList<AlarmeGaz> getListeAlarmeGaz() {
		return listeAlarmeGaz;
	}

	public void setListeAlarmeGaz(ArrayList<AlarmeGaz> listeAlarmeGaz) {
		this.listeAlarmeGaz = listeAlarmeGaz;
	}

	public ArrayList<AlarmeIncendie> getListeAlarmeIncendie() {
		return listeAlarmeIncendie;
	}

	public void setListeAlarmeIncendie(ArrayList<AlarmeIncendie> listeAlarmeIncendie) {
		this.listeAlarmeIncendie = listeAlarmeIncendie;
	}

	public static String getType() {
		return type;
	}
	
}
