package dao;

import exceptions.DatabaseException;
import models.Match;
import utils.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
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
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(matchEntity);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DatabaseException(e);
        }
    }


    public List<Match> getMatchesForOnePage(int pageNumber, int pageSize) {
        List<Match> matches = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Match";
            Query query = session.createQuery(hql);
            query.setFirstResult((pageNumber - 1) * pageSize);
            query.setMaxResults(pageSize);
            matches = query.getResultList();
        } catch (HibernateException e) {
            throw new DatabaseException(e);
        }
        return matches;
    }

    public Long getAllMatchesCount() {
        Long count = 0L;
        try (Session session = sessionFactory.openSession()) {

            String hql = "SELECT COUNT(*) FROM Match";
            Query query = session.createQuery(hql, Integer.class);
            count = (Long) query.getSingleResult();
        } catch (HibernateException e) {
            throw new DatabaseException(e);
        }
        return count;
    }

    public Long getMatchesCountForPlayer(String searchName) {
        Long count = 0L;
        try (Session session = sessionFactory.openSession()) {

            String hql = "SELECT COUNT(DISTINCT m.id) FROM Match m "
                    + "JOIN m.player1 p1 "
                    + "JOIN m.player2 p2 "
                    + "WHERE LOWER(p1.name) LIKE LOWER(:name) "
                    + "OR LOWER(p2.name) LIKE LOWER(:name)";
            Query query = session.createQuery(hql, Integer.class);
            query.setParameter("name", "%" + searchName + "%");
            count = (Long) query.getSingleResult();
        } catch (HibernateException e) {
            throw new DatabaseException(e);
        }
        return count;
    }

    public List<Match> getMatchesForOnePageWithNameFilter(int pageNumber, int pageSize, String searchName) {
        List<Match> matches = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            String hql = "SELECT DISTINCT m FROM Match m "
                    + "JOIN m.player1 "
                    + "JOIN m.player2 "
                    + "WHERE LOWER(m.player1.name) LIKE LOWER(:name) "
                    + "OR LOWER(m.player2.name) LIKE LOWER(:name)";
            Query query = session.createQuery(hql);
            query.setParameter("name", "%" + searchName + "%");
            query.setFirstResult((pageNumber - 1) * pageSize);
            query.setMaxResults(pageSize);
            matches = query.getResultList();
        } catch (HibernateException e) {
            throw new DatabaseException(e);
        }

        return matches;
    }


}
