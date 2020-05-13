import java.util.Date;
import java.util.EventListener;

public interface AlerteIncendieListener extends EventListener  {
	public void receptionIncendie(AlarmeIncendie e);
}
