package sk.tsystems.lzm.service;

import sk.tsystems.lzm.entity.HospitalPatients;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class HospitalPatientsServiceJPA implements HospitalPatientsService{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addHospitalPatients(HospitalPatients hospitalPatients) {
        entityManager.persist(hospitalPatients);
    }

    @Override
    public List<HospitalPatients> getAllHospitalPatients() {
        final String STATEMENT_GET_ALL = "select al from HospitalPatients al";
        return entityManager
                .createQuery(STATEMENT_GET_ALL)
                .getResultList();
    }

    @Override
    public void reset() {
        final String STATEMENT_RESET = "DELETE FROM hospitalPatients";
        entityManager.createNamedQuery(STATEMENT_RESET).executeUpdate();
    }
}
