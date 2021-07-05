package DAO;

import java.util.List;
import Model.Asistente;

public interface AsistentesDAO {
    public List<Asistente> getAll();
    public Asistente findAsistenteById(Asistente asistente);
    public void insertAsistente(Asistente asistente);
    public void deleteAsistente(Asistente asistente);
    public void updateAsistente(Asistente asistente);
    
}
