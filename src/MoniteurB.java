import java.util.ArrayList;

public class MoniteurB {
	
	static String type = "B";
	ArrayList<AlarmeGaz> listeAlarmeGaz = new ArrayList<AlarmeGaz>();
	ArrayList<AlarmeRadiation> listeAlarmeRadiation = new ArrayList<AlarmeRadiation>();
	
	public MoniteurB(ArrayList<AlarmeGaz> listeAlarmeGaz, ArrayList<AlarmeRadiation> listeAlarmeRadiation) {
		super();
		this.listeAlarmeGaz = listeAlarmeGaz;
		this.listeAlarmeRadiation = listeAlarmeRadiation;
	}

	public MoniteurB() {
		super();
	}

	public ArrayList<AlarmeGaz> getListeAlarmeGaz() {
		return listeAlarmeGaz;
	}

	public void setListeAlarmeGaz(ArrayList<AlarmeGaz> listeAlarmeGaz) {
		this.listeAlarmeGaz = listeAlarmeGaz;
	}

	public ArrayList<AlarmeRadiation> getListeAlarmeRadiation() {
		return listeAlarmeRadiation;
	}

	public void setListeAlarmeRadiation(ArrayList<AlarmeRadiation> listeAlarmeRadiation) {
		this.listeAlarmeRadiation = listeAlarmeRadiation;
	}

	public static String getType() {
		return type;
	}
	
	public void addAlarmeIncendie(AlarmeRadiation rad) {
		this.listeAlarmeRadiation.add(rad);
	}
	
	
	public void addAlarmeGaz(AlarmeGaz gaz) {
		this.listeAlarmeGaz.add(gaz);
	}
	
	
	
	
}
