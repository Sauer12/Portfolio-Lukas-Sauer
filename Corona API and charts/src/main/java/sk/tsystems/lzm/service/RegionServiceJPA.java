package sk.tsystems.lzm.service;

import sk.tsystems.lzm.entity.Region;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class RegionServiceJPA implements RegionService{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addRegion(Region region) {
        entityManager.persist(region);
    }

    @Override
    public List<Region> getRegions() {
        final String STATEMENT_GET_REGIONS = "select r from Region r";

        return entityManager.createQuery(STATEMENT_GET_REGIONS)
                .getResultList();
    }

    @Override
    public void reset() {
        entityManager.createNativeQuery("delete from Region").executeUpdate();

    }
}
