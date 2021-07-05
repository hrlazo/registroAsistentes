
package servicio;

import Model.Asistente;
import java.util.List;

public interface AsistenteService {
   public List<Asistente> listaAsistentes();
   public Asistente encontrarAsistentePorId(Asistente asistente);
   public void registrarAsistente(Asistente asistente);
   public void modificarAsistente(Asistente asistente);
   public void eliminarAsistente(Asistente asistente);
}
