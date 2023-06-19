package sk.tsystems.lzm.service;

import sk.tsystems.lzm.entity.SlovakiaHospitalBeds;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class SlovakiaHospitalBedsServiceJPA implements SlovakiaHospitalBedsService{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addSlovakiaHospitalBeds(SlovakiaHospitalBeds slovakiaHospitalBeds) {
        entityManager.persist(slovakiaHospitalBeds);
    }

    @Override
    public List<SlovakiaHospitalBeds> getAllSlovakiaHospitalBeds() {
        final String STATEMENT_GET_ALL = "select al from SlovakiaHospitalBeds al";
        return entityManager
                .createQuery(STATEMENT_GET_ALL)
                .getResultList();
    }

    @Override
    public Long getLastId() {
        final String STATEMENT_GET_LAST_ID = "select al.id from SlovakiaHospitalBeds al order by al.id desc";


        var ident = entityManager
                .createQuery(STATEMENT_GET_LAST_ID)
                .setFirstResult(0)
                .setMaxResults(1)
                .getSingleResult();

        if(ident == null){
            return  0L;
        } else {
            return (Long)ident;
        }
    }

    @Override
    public void reset() {
        entityManager.createNativeQuery("delete from slovakia_hospital_beds").executeUpdate();
    }
}
