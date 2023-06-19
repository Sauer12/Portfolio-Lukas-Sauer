package sk.tuke.gamestudio.service;

import sk.tuke.gamestudio.entity.Occupation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class OccupationServiceJPA implements OccupationService{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Occupation> getOccupations() {
        final String STATEMENT_OCCUPATIONS = "select oc from Occupation oc order by oc.occupation";
        return entityManager
                .createQuery(STATEMENT_OCCUPATIONS)
                .getResultList();
    }

    @Override
    public void addOccupation(Occupation occupation) {
        entityManager.persist(occupation);
    }
}

