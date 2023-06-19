package sk.tsystems.lzm.service;

import org.springframework.transaction.annotation.Transactional;
import sk.tsystems.lzm.entity.HospitalStaff;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Transactional
public class HospitalStaffServiceJPA implements HospitalStaffService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addHospitalStaff(HospitalStaff hospitalStaff) {
        entityManager.persist(hospitalStaff);
    }

    @Override
    public List<HospitalStaff> getHospitalStaff() {
        final String STATEMENT = "select hs from HospitalStaff hs";
        return entityManager
                .createQuery(STATEMENT)
                .getResultList();
    }

    @Override
    public void reset() {
        final String STATEMENT_RESET = "delete from HospitalStaff";
        entityManager.createNativeQuery(STATEMENT_RESET).executeUpdate();
    }
}
