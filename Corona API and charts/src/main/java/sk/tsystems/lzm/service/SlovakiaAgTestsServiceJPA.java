package sk.tsystems.lzm.service;

import org.springframework.transaction.annotation.Transactional;
import sk.tsystems.lzm.entity.SlovakiaAgTests;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;


@Transactional
public class SlovakiaAgTestsServiceJPA implements SlovakiaAgTestsService{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addSlovakiaAgTests(SlovakiaAgTests slovakiaAgTests) {
        entityManager.persist(slovakiaAgTests);
    }

    @Override
    public List<SlovakiaAgTests> getSlovakiaAgTestsAll() {
        final String STATEMENT_GET_SLOVAKIA_AGTESTS_ALL = "select s from SlovakiaAgTests s";

        return entityManager.createQuery(STATEMENT_GET_SLOVAKIA_AGTESTS_ALL)
                .getResultList();
    }

    @Override
    public String getLastId() {
        final String STATEMENT_GET_LAST_ID = "select s.id from SlovakiaAgTests s order by s.id desc";


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
        entityManager.createNativeQuery("delete from slovakia_ag_tests").executeUpdate();

    }
}
