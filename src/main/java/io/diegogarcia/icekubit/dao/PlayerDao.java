package io.diegogarcia.icekubit.dao;

import io.diegogarcia.icekubit.models.Player;
import io.diegogarcia.icekubit.utils.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

// TODO метод getPlayerByNameOrCreate - полное говно, как будто ты уебан с курсов, переделать

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

    public List<Player> findAll() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM Player";
        Query query = session.createQuery(hql);
        List<Player> players = query.getResultList();

        transaction.commit();

        session.close();

        return players;
    }


    public Player getPlayerByNameOrCreate(String nameOfPlayer) {
        Player player = null;

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


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

        session.close();

        return player;
    }

    public Player getPlayerById(int playerId) {
        Player player = null;

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        String hql = "FROM Player p WHERE p.id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", playerId);
        player = (Player) query.getResultList().get(0);





        transaction.commit();

        session.close();

        return player;
    }
}
