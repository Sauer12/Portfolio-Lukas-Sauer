package sk.tsystems.lzm.service;

import sk.tsystems.lzm.entity.RegionHospitalBeds;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class RegionHospitalBedsServiceJPA implements RegionHospitalBedsService{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addRegionHospitalBeds(RegionHospitalBeds regionHospitalBeds) {
        entityManager.persist(regionHospitalBeds);
    }

    @Override
    public List<RegionHospitalBeds> getAllRegionHospitalBeds() {
        final String STATEMENT_GET_ALL = "select al from RegionHospitalBeds al";
        return entityManager
                .createQuery(STATEMENT_GET_ALL)
                .getResultList();
    }

    @Override
    public void reset() {
        final String STATEMENT_RESET = "DELETE FROM region_hospital_beds";
        entityManager.createNativeQuery(STATEMENT_RESET).executeUpdate();
    }
}
