package sk.tsystems.lzm.service;

import org.springframework.transaction.annotation.Transactional;
import sk.tsystems.lzm.entity.RegionAgTests;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Transactional
public class RegionAgTestsServiceJPA implements RegionAgTestsService{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addRegionAgTests(RegionAgTests regionAgTests) {
        entityManager.persist(regionAgTests);
    }

    @Override
    public List<RegionAgTests> getRegionAgTestsAll() {
        final String STATEMENT_GET_REGION_AGTESTS_ALL = "select r from RegionAgTests r";

        return entityManager.createQuery(STATEMENT_GET_REGION_AGTESTS_ALL)
                .getResultList();
    }

    @Override
    public void reset() {
        entityManager.createNativeQuery("delete from region_ag_tests").executeUpdate();

    }
}
