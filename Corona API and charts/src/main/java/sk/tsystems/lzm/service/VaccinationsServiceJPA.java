package sk.tsystems.lzm.service;

import org.springframework.transaction.annotation.Transactional;
import sk.tsystems.lzm.entity.Hospital;
import sk.tsystems.lzm.entity.Vaccinations;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Transactional
public class VaccinationsServiceJPA implements VaccinationsService{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addVaccinations(Vaccinations vaccinations) {
        entityManager.persist(vaccinations);
    }

    @Override
    public List<Vaccinations> getVaccinations() {
        final String STATEMENT = "select v from Vaccinations v";
        return entityManager
                .createQuery(STATEMENT)
                .getResultList();
    }

    @Override
    public Vaccinations getVaccination(int id) {
        Vaccinations vaccinations;
        vaccinations = (Vaccinations) entityManager.createQuery("select v from Vaccinations v where v.id =: id")
                .setParameter("id", id).getSingleResult();
        return vaccinations;
    }

    @Override
    public void reset() {
        final String STATEMENT_RESET = "DELETE FROM Vaccinations";
        entityManager.createNativeQuery(STATEMENT_RESET).executeUpdate();
    }
}
