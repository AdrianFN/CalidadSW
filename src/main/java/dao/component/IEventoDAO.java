
package dao.component;

import dao.to.EventoTO;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public interface IEventoDAO {
    public abstract boolean crearEvento(EventoTO evento);
    public abstract ArrayList<EventoTO> listarEvento();
    public abstract ArrayList<EventoTO> historialEvento();
//   public abstract EventoTO seleccionarEvento(String idEvento);
    public abstract boolean terminarEvento(EventoTO idEvento);
}
