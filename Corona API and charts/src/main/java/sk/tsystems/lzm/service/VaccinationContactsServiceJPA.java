package sk.tsystems.lzm.service;

import org.springframework.transaction.annotation.Transactional;
import sk.tsystems.lzm.entity.VaccinationContacts;
import sk.tsystems.lzm.entity.Vaccinations;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Transactional
public class VaccinationContactsServiceJPA implements VaccinationContactsService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addVaccinationsContacts(VaccinationContacts vaccinationContacts) {
        entityManager.persist(vaccinationContacts);
    }

    @Override
    public List<VaccinationContacts> getVaccinationsContacts() {
        final String STATEMENT = "select vc from VaccinationContacts vc";
        return entityManager
                .createQuery(STATEMENT)
                .getResultList();
    }

    @Override
    public void reset() {
        final String STATEMENT_RESET = "DELETE FROM VaccinationContacts";
        entityManager.createNativeQuery(STATEMENT_RESET).executeUpdate();
    }
}
