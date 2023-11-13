package io.diegogarcia.icekubit.dao;

import io.diegogarcia.icekubit.models.Match;
import io.diegogarcia.icekubit.utils.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class MatchesDao {
    private static MatchesDao instance;
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private MatchesDao() {}
    public static MatchesDao getInstance() {
        if (instance == null)
            instance = new MatchesDao();
        return instance;
    }

    public void save(Match matchEntity) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(matchEntity);

        transaction.commit();

        session.close();
    }

    public List<Match> findAll() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM Match";
        Query query = session.createQuery(hql);
        List<Match> matches = query.getResultList();

        transaction.commit();

        session.close();

        return matches;
    }

    public List<Match> getMatchesForOnePage(int pageNumber, int pageSize) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM Match";
        Query query = session.createQuery(hql);
        query.setFirstResult((pageNumber - 1) * pageSize);
        query.setMaxResults(pageSize);
        List<Match> matches = query.getResultList();

        transaction.commit();

        session.close();

        return matches;
    }

    public Long getAllMatchesCount() {
        Long count = 0L;
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            String hql = "SELECT COUNT(*) FROM Match";
            Query query = session.createQuery(hql, Integer.class);
            count = (Long) query.getSingleResult();
            transaction.commit();
        }
        return count;
    }

    public Long getMatchesCountForPlayer(String searchName) {
        Long count = 0L;
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            String hql = "SELECT COUNT(DISTINCT m.id) FROM Match m "
                    + "JOIN m.player1 p1 "
                    + "JOIN m.player2 p2 "
                    + "WHERE p1.name = :name "
                    + "OR p2.name = :name";
            Query query = session.createQuery(hql, Integer.class);
            query.setParameter("name", searchName);
            count = (Long) query.getSingleResult();
            transaction.commit();
        }
        return count;
    }

    public List<Match> getMatchesForOnePageWithNameFilter(int pageNumber, int pageSize, String searchName) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "SELECT DISTINCT m FROM Match m "
                + "JOIN m.player1 "
                + "JOIN m.player2 "
                + "WHERE m.player1.name = :name "
                + "OR m.player2.name = :name";
        Query query = session.createQuery(hql);
        query.setParameter("name", searchName);
        query.setFirstResult((pageNumber - 1) * pageSize);
        query.setMaxResults(pageSize);
        List<Match> matches = query.getResultList();

        transaction.commit();

        session.close();

        return matches;
    }


}
