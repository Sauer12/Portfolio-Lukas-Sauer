package sk.tsystems.lzm.service;

import sk.tsystems.lzm.entity.DistrictAgTests;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class DistrictAgTestsServiceJPA implements DistrictAgTestsService{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addDistrictAgTests(DistrictAgTests districtAgTests) {
        entityManager.persist(districtAgTests);
    }

    @Override
    public List<DistrictAgTests> getDistrictAgTestsAll() {
        final String STATEMENT_GET_DISTRICT_AGTESTS_ALL = "select d from DistrictAgTests d";

        return entityManager.createQuery(STATEMENT_GET_DISTRICT_AGTESTS_ALL)
                .getResultList();
    }

    @Override
    public void reset() {
        entityManager.createNativeQuery("delete from DistrictAgTestService").executeUpdate();

    }
}
