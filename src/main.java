import java.awt.EventQueue;
import java.util.Date;

public class main {

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
    
    /*
    EventQueue.invokeLater(new Runnable(){
        @Override
        public void run(){
            new Monitoring().setVisible(true);
        }
    });
	}
	*/
	}
}
