package sk.tsystems.lzm.service;

import org.springframework.transaction.annotation.Transactional;
import sk.tsystems.lzm.entity.RegionHospitalPatients;

import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import java.util.List;
@Transactional
public class RegionHospitalPatientsServiceJPA implements RegionHospitalPatientsService{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addRegionHospitalPatients(RegionHospitalPatients regionHospitalPatients) {
        entityManager.persist(regionHospitalPatients);
    }

//    Vrati vsetkych Region hospital patients
    @Override
    public List<RegionHospitalPatients> getRegionHospitalPatients() {
        final String STATEMENT = "select rhp from RegionHospitalPatients rhp";
        return entityManager
                .createQuery(STATEMENT)
                .getResultList();
    }

    @Override
    public void reset() {
        final String STATEMENT_RESET = "DELETE FROM RegionHospitalPatients";
        entityManager.createNativeQuery(STATEMENT_RESET).executeUpdate();
    }
}
