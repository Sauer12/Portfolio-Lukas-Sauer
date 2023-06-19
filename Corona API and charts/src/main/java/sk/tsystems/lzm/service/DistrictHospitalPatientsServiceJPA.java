package sk.tsystems.lzm.service;

import sk.tsystems.lzm.entity.DistrictHospitalPatients;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class DistrictHospitalPatientsServiceJPA implements DistrictHospitalPatientsService{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addDistrictHospitalPatients(DistrictHospitalPatients districtHospitalPatients) {
        entityManager.persist(districtHospitalPatients);
    }

    @Override
    public List<DistrictHospitalPatients> getAllDistrictHospitalPatients() {
        final String STATEMENT_GET_ALL = "select al from DistrictHospitalPatients al";
        return entityManager
                .createQuery(STATEMENT_GET_ALL)
                .getResultList();
    }

    @Override
    public void reset() {
        final String STATEMENT_RESET = "DELETE FROM districtHospitalPatients";
        entityManager.createNamedQuery(STATEMENT_RESET).executeUpdate();
    }
}
