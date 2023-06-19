package sk.tsystems.lzm.service;

import sk.tsystems.lzm.entity.Vaccinations;
import sk.tsystems.lzm.entity.Vaccine;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class VaccineServiceJPA implements VaccineService{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addVaccine(Vaccine vaccine) {
        entityManager.persist(vaccine);
    }

    @Override
    public List<Vaccine> getAllVaccine() {
        final String STATEMENT_GET_ALL = "select al from Vaccine al";
        return entityManager
                .createQuery(STATEMENT_GET_ALL)
                .getResultList();
    }

    @Override
    public Vaccine getVaccine(int id) {
        Vaccine vaccine;
        vaccine = (Vaccine) entityManager.createQuery("select v from Vaccine v where v.id =:id")
                .setParameter("id", id).getSingleResult();
        return vaccine;
    }

    @Override
    public void reset() {
        final String STATEMENT_RESET = "DELETE FROM vaccine";
        entityManager.createNamedQuery(STATEMENT_RESET).executeUpdate();
    }
}
