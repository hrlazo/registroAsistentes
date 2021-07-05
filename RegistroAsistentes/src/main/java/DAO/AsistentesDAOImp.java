package DAO;

import Model.Asistente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class AsistentesDAOImp implements AsistentesDAO{
    @PersistenceContext(unitName= "ASISTENTE-PU")
    EntityManager em;
    
    @Override
    public List<Asistente> getAll() {
        return em.createNamedQuery("Asistente.findAll").getResultList();
    }

    @Override
    public Asistente findAsistenteById(Asistente asistente) {
       return em.find(Asistente.class, asistente.getRut());
    }

    @Override
    public void insertAsistente(Asistente asistente) {
       em.persist(asistente);
    }

    @Override
    public void deleteAsistente(Asistente asistente) {
       em.remove(em.merge(asistente));
    }

    @Override
    public void updateAsistente(Asistente asistente) {
       em.merge(asistente);
    }
    
}
