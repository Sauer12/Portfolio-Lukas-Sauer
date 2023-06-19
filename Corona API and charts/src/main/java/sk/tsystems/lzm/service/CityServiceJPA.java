package sk.tsystems.lzm.service;

import org.springframework.transaction.annotation.Transactional;
import sk.tsystems.lzm.entity.City;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
public class CityServiceJPA implements CityService{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void addCity(City city) {
        entityManager.persist(city);
    }

    @Override
    public List<City> getCities() {
        final String STATEMENT_GET_CITIES = "select c from City c";

        return entityManager.createQuery(STATEMENT_GET_CITIES)
                .getResultList();
    }

    @Override
    public void reset() {
        entityManager.createNativeQuery("delete from City").executeUpdate();

    }
}
