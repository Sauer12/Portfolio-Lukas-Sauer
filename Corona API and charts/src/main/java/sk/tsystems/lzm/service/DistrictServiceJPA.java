package sk.tsystems.lzm.service;

import org.springframework.transaction.annotation.Transactional;
import sk.tsystems.lzm.entity.District;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
public class DistrictServiceJPA implements DistrictService{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addDistrict(District district) {
        entityManager.persist(district);
    }

    @Override
    public List<District> getDistricts() {
        final String STATEMENT_GET_DISTRICTS = "select d from District d";

        return entityManager.createQuery(STATEMENT_GET_DISTRICTS)
                .getResultList();
    }

    @Override
    public void reset() {
        entityManager.createNativeQuery("delete from District").executeUpdate();
    }
}
