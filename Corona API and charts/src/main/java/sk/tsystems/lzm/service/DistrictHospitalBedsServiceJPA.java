package sk.tsystems.lzm.service;

import sk.tsystems.lzm.entity.DistrictHospitalBeds;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class DistrictHospitalBedsServiceJPA implements DistrictHospitalBedsService{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addDistrictHospitalBeds(DistrictHospitalBeds districtHospitalBeds) {
        entityManager.persist(districtHospitalBeds);
    }

    @Override
    public List<DistrictHospitalBeds> getAllDistrictHospitalBeds() {
        final String STATEMENT_GET_ALL = "select al from DistrictHospitalBeds al";
        return entityManager
                .createQuery(STATEMENT_GET_ALL)
                .getResultList();
    }

    @Override
    public void reset() {
        final String STATEMENT_RESET = "DELETE FROM districtHospitalBeds";
        entityManager.createNamedQuery(STATEMENT_RESET).executeUpdate();
    }
}
