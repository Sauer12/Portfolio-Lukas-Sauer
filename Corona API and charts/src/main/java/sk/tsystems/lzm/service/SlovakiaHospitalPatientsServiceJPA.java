package sk.tsystems.lzm.service;

import org.springframework.transaction.annotation.Transactional;
import sk.tsystems.lzm.entity.SlovakiaHospitalPatients;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Transactional
public class SlovakiaHospitalPatientsServiceJPA implements SlovakiaHospitalPatientsService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addSlovakiaHospitalPatients(SlovakiaHospitalPatients slovakiaHospitalPatients) {
        entityManager.persist(slovakiaHospitalPatients);
    }

    @Override
    public List<SlovakiaHospitalPatientsService> getSlovakiaHospitalPatients() {
        final String STATEMENT = "select shp from SlovakiaHospitalPatients shp";
        return entityManager
                .createQuery(STATEMENT)
                .getResultList();
    }

    @Override
    public void reset() {
        final String STATEMENT_RESET = "DELETE FROM SlovakiaHospitalPatients";
        entityManager.createNativeQuery(STATEMENT_RESET).executeUpdate();
    }
}
