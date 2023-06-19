package sk.tuke.gamestudio.service;

import sk.tuke.gamestudio.entity.Player;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
public class PlayerServiceJPA implements PlayerService{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Player getPlayerByUserName(String userName) {
        final String STATEMENT_PLAYER = "select pl from Player pl where pl.userName=:myUserName";

        Player player = null;

        try {
            player = (Player) entityManager
                    .createQuery(STATEMENT_PLAYER)
                    .setParameter("myUserName", userName)
                    .getSingleResult();
            return player;
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void addPlayer(Player player) {
        entityManager.persist(player);
    }
}
