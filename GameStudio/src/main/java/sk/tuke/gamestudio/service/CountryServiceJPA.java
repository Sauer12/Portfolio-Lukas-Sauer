package sk.tuke.gamestudio.service;

import sk.tuke.gamestudio.entity.Country;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class CountryServiceJPA implements CountryService{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Country> getCountries() {
        final String STATEMENT_COUNTRIES = "select ctry from Country ctry order by ctry.country";
        return entityManager
                .createQuery(STATEMENT_COUNTRIES)
                .getResultList();
    }

    @Override
    public void addCountry(Country country) {
        entityManager.persist(country);
    }
}

