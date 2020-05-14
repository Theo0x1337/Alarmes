import GUI.Monitoring;
import GUI.fenSimulateurAlarme;
import capteurs.CapteursGaz;
import capteurs.CapteursIncendie;
import moniteur.Moniteur;


/**
 * Classe Main permettant de lancer l'application
 * 
 * @author Theo Bernardin / Enzo Masson
 * @version 1.0
 */

public class Main {

	public static void main(String[] args) {
	
	CapteursGaz g = new CapteursGaz("Batiment A");
	CapteursIncendie i = new CapteursIncendie("Batiment B");
	
	
	Moniteur pompier  = new Moniteur("A");
    Moniteur ecologie = new Moniteur("B");	
    
    i.addAlerteIncendieListener(pompier);
    g.addAlerteGazListener(ecologie);
    
    g.alerteGaz(java.time.LocalDateTime.now(), 2, "Moutarde");
    i.alerteIncendie(java.time.LocalDateTime.now(), 3);
    
    
    fenSimulateurAlarme fen = new fenSimulateurAlarme();
    
    
    Monitoring mon = new Monitoring();
    mon.addMoniteur(pompier);
    mon.addMoniteur(ecologie);
    
    fen.addMonitor(mon);
    
   
    
	}
	
	
}
