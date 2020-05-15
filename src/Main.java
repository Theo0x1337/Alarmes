import capteurs.CapteursGaz;
import capteurs.CapteursIncendie;
import gui.Monitoring;
import gui.MonitoringEcologie;
import gui.MonitoringPompiers;
import gui.fenSimulateurAlarme;
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
    MonitoringPompiers monPomp = new MonitoringPompiers("Monitoring POMPIERS");
    MonitoringEcologie monEco = new MonitoringEcologie("Monitoring ECOLOGIE");
    monPomp.addMoniteur(pompier);
    monEco.addMoniteur(ecologie);
    
    //Ajout du moniteur � la fenetre principale
    fen.addMonitor(monPomp);
    fen.addMonitorEco(monEco);
    
	}	
}
