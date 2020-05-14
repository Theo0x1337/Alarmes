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
	
	//Capteurs
	CapteursGaz g = new CapteursGaz("Batiment A");
	CapteursIncendie i = new CapteursIncendie("Batiment B");
	
	//Moniteurs
	Moniteur pompier  = new Moniteur("A");
    Moniteur ecologie = new Moniteur("B");	
    
    //Faire ecouter les moniteurs sur les capteurs
    i.addAlerteIncendieListener(pompier);
    g.addAlerteGazListener(ecologie);
    
    //Creation de la fenetre de simulation d'alarme
    fenSimulateurAlarme fen = new fenSimulateurAlarme();
    
    //Creation de la fenetre de monitoring
    Monitoring mon = new Monitoring();
    mon.addMoniteur(pompier);
    mon.addMoniteur(ecologie);
    
    //Ajout du moniteur à la fenetre principale
    fen.addMonitor(mon);
    
	}	
}
