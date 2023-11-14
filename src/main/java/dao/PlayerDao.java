package dao;

import exceptions.DatabaseException;
import models.Player;
import org.hibernate.HibernateException;
import utils.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class PlayerDao {
    private static PlayerDao instance;
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private PlayerDao() {
    }

    public static PlayerDao getInstance() {
        if (instance == null)
            instance = new PlayerDao();
        return instance;
    }


    public Player getPlayerByNameOrCreate(String nameOfPlayer) {
        Player player = null;
        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            String hql = "FROM Player p WHERE p.name = :name";
            Query query = session.createQuery(hql);
            query.setParameter("name", nameOfPlayer);
            List<Player> result = query.getResultList();
            if (!result.isEmpty()) {
                player = result.get(0);
            } else {
                session.persist(new Player(nameOfPlayer));
                player = (Player) query.getResultList().get(0);
            }
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            throw new DatabaseException(e);
        }
        return player;
    }


    public void save(Player player) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            session.persist(player);

            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            throw new DatabaseException(e);
        }
    }
}
