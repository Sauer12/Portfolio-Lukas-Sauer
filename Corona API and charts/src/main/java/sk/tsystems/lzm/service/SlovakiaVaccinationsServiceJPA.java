package sk.tsystems.lzm.service;

import org.springframework.transaction.annotation.Transactional;
import sk.tsystems.lzm.entity.SlovakiaVaccinations;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Transactional
public class SlovakiaVaccinationsServiceJPA implements SlovakiaVaccinationsService{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addSlovakiaVaccinations(SlovakiaVaccinations slovakiaVaccinations) {
        entityManager.persist(slovakiaVaccinations);
    }

    @Override
    public List<SlovakiaVaccinations> getSlovakiaVaccinations() {
        final String STATEMENT = "select sv from SlovakiaVaccinations sv";
        return entityManager
                .createQuery(STATEMENT)
                .getResultList();
    }

    @Override
    public String getLastId() {
        final String STATEMENT_GET_LAST_ID = "select sv.id from SlovakiaVaccinations sv order by sv.id desc";


        var ident = entityManager
                .createQuery(STATEMENT_GET_LAST_ID)
                .setFirstResult(0)
                .setMaxResults(1)
                .getSingleResult();

        if(ident == null){
            return "0";
        } else {
            return ident.toString();
        }
    }

    @Override
    public void reset() {
        final String STATEMENT_RESET = "delete from slovakia_vaccinations";
        entityManager.createNativeQuery(STATEMENT_RESET).executeUpdate();
    }
}
