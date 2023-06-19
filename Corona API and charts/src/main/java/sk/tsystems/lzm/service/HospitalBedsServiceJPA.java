package sk.tsystems.lzm.service;

import sk.tsystems.lzm.entity.HospitalBeds;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class HospitalBedsServiceJPA implements HospitalBedsService{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addHospitalBeds(HospitalBeds hospitalBeds) {
        entityManager.persist(hospitalBeds);
    }

    @Override
    public List<HospitalBeds> getAllHospitalBeds() {
        final String STATEMENT_GET_ALL = "select al from HospitalBeds al";
        return entityManager
                .createQuery(STATEMENT_GET_ALL)
                .getResultList();
    }

    @Override
    public void reset() {
        final String STATEMENT_RESET = "DELETE FROM hospitalBeds";
        entityManager.createNamedQuery(STATEMENT_RESET).executeUpdate();
    }
}
