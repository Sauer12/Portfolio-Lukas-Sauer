package sk.tsystems.lzm.service;

import org.springframework.transaction.annotation.Transactional;
import sk.tsystems.lzm.entity.RegionVaccinations;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Transactional
public class RegionVaccinationsServiceJPA implements RegionVaccinationsService{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addRegionVaccinations(RegionVaccinations regionVaccinations) {
        entityManager.persist(regionVaccinations);
    }

    @Override
    public List<RegionVaccinations> getRegionVaccinations() {
        final String STATEMENT = "select rg from RegionVaccinations rg";
        return entityManager
                .createQuery(STATEMENT)
                .getResultList();
    }

    @Override
    public void reset() {
        final String STATEMENT_RESET = "delete from region_vaccinations";
        entityManager.createNativeQuery(STATEMENT_RESET).executeUpdate();
    }
}
