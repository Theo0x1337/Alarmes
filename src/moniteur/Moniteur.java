package moniteur;
import Alarmes.AlarmeGaz;
import Alarmes.AlarmeIncendie;
import Alarmes.AlarmeRadiation;
import AlarmesListener.AlerteGazListener;
import AlarmesListener.AlerteIncendieListener;
import AlarmesListener.AlerteRadiationListener;

public class Moniteur implements AlerteIncendieListener, AlerteGazListener, AlerteRadiationListener {

  /**
   * Le type du moniteur. Permet de savoir quel type d'alarmes il peut gerer.
   *
   * @see Monitor#Monitor(String)
   * @see Monitor#getType()
   */
  private String type;

  /**
   * <b>CONSTRUCTEUR DE CLASSE Monitor</b>
   * <p>Capte les differentes alarmes et donne une reponse</p>
   * <p>
   * A la construction d'un objet Monitor, son type est dertermine
   * </p>
   *
   * @param _type : type du moniteur
   * @see Monitor#type
   */
  public Moniteur(String type) {
     this.type = type;
  }

  /**
   * Retourne le type du moniteur
   * @return type du moniteur en String
   */
  public String getType() {
    return this.type;
  }


	@Override
	public void receptionRadiation(AlarmeRadiation e) {
		System.out.println("Alarme RADIATION -> "+e.getInfos());	
	}
	
	@Override
	public void receptionGaz(AlarmeGaz e) {
		System.out.println("Alarme GAZ -> "+e.getInfos());	
	}
	
	@Override
	public void receptionIncendie(AlarmeIncendie e) {
		System.out.println("Alarme INCENDIE -> "+e.getInfos());
	}
}