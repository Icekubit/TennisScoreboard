package io.diegogarcia.icekubit.dao;

import io.diegogarcia.icekubit.models.Match;
import io.diegogarcia.icekubit.models.MatchEntity;
import io.diegogarcia.icekubit.models.Player;
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

    public void save(MatchEntity matchEntity) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(matchEntity);

        transaction.commit();

        session.close();
    }

    public List<MatchEntity> findAll() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM MatchEntity";
        Query query = session.createQuery(hql);
        List<MatchEntity> matches = query.getResultList();

        transaction.commit();

        session.close();

        return matches;
    }

    public List<MatchEntity> getMatchesForOnePage(int pageNumber, int pageSize) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM MatchEntity";
        Query query = session.createQuery(hql);
        query.setFirstResult((pageNumber - 1) * pageSize + 1);
        query.setMaxResults(pageSize);
        List<MatchEntity> matches = query.getResultList();

        transaction.commit();

        session.close();

        return matches;
    }

    public Long getMatchesCount() {
        Long count = 0L;
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            String hql = "SELECT COUNT(*) FROM MatchEntity";
            Query query = session.createQuery(hql, Integer.class);
            count = (Long) query.getSingleResult();
            transaction.commit();
        }
        return count;
    }
}
