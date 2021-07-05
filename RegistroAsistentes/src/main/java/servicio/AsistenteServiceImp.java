package servicio;

import DAO.AsistentesDAO;
import Model.Asistente;
import java.util.List;
import javax.inject.Inject;

public class AsistenteServiceImp implements AsistenteService{

    @Inject
    private AsistentesDAO asistenteDAO;
    
    @Override
    public List<Asistente> listaAsistentes() {
        return asistenteDAO.getAll();
    }

    @Override
    public Asistente encontrarAsistentePorId(Asistente asistente) {
        return asistenteDAO.findAsistenteById(asistente);
    }

    @Override
    public void registrarAsistente(Asistente asistente) {
        asistenteDAO.insertAsistente(asistente);
    }

    @Override
    public void modificarAsistente(Asistente asistente) {
        asistenteDAO.updateAsistente(asistente);
    }

    @Override
    public void eliminarAsistente(Asistente asistente) {
        asistenteDAO.deleteAsistente(asistente);
    }
    
}
