package sk.tsystems.lzm.service;

import org.springframework.transaction.annotation.Transactional;
import sk.tsystems.lzm.entity.Hospital;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
public class HospitalServiceJPA implements HospitalService{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addHospital(Hospital hospital) {
        entityManager.persist(hospital);
    }

    @Override
    public Hospital getHospital(int id) {
        Hospital hospital;
        hospital = (Hospital) entityManager.createQuery("select h from Hospital h where h.id =: id")
                .setParameter("id", id).getSingleResult();
        return hospital;
    }


    @Override
    public List<Hospital> getHospitals() {
        final String STATEMENT_GET_HOSPITALS = "select h from Hospital h";

        return entityManager.createQuery(STATEMENT_GET_HOSPITALS)
                .getResultList();
    }

    @Override
    public void reset() {
        entityManager.createNativeQuery("delete from Hospital").executeUpdate();

    }
}

/*@Transactional
public class HospitalServiceJPA implements HospitalService{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addHospital(Hospital hospital) {
        entityManager.persist(hospital);
    }

    @Override
    public List<Hospital> getHospitals() {
        final String STATEMENT_GET_HOSPITALS = "select h from Hospital h";

        return entityManager.createQuery(STATEMENT_GET_HOSPITALS)
                .getResultList();
    }

    @Override
    public Hospital getHospital(int id) {
        Hospital hospital;
        hospital = (Hospital) entityManager.createQuery("select h from Hospital h where h.id =: id")
                .setParameter("id", id).getSingleResult();
        return hospital;
    }

    @Override
    public void reset() {
        entityManager.createNativeQuery("delete from Hospital").executeUpdate();

    }
}*/
