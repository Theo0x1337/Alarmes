
public class main {

	public static void main(String[] args) {
	
	MoniteurA pompier = new MoniteurA();
	MoniteurB service_environnement = new MoniteurB();
	
	CapteursGaz capteurGaz = new CapteursGaz(1,"BatA",pompier,service_environnement);
	CapteursIncendie capteurIncendie = new CapteursIncendie(1,"BatA",pompier);
	CapteursRadiation capteurRadiation = new CapteursRadiation(1,"BatC",10,service_environnement);
	
	
	capteurRadiation.setNiveau(50);
		
	
	capteurIncendie.setFumee(true);
	
	
	capteurGaz.setType("gaz moutarde");
		
	}

}
