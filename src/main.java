
public class main {

	public static void main(String[] args) {
	
	MoniteurA pompier = new MoniteurA();
	MoniteurB service_environnement = new MoniteurB();
	
	CapteursGaz capteurGaz = new CapteursGaz(1,"fesse",pompier,service_environnement);
	CapteursIncendie capteurIncendie = new CapteursIncendie(1,"cul",pompier);
	CapteursRadiation capteurRadiation = new CapteursRadiation(1,"chatte",10,service_environnement);
	
	
	capteurRadiation.setNiveau(50);
		
		
	}

}
