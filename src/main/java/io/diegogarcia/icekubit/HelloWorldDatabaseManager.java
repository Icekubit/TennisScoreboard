package io.diegogarcia.icekubit;

import io.diegogarcia.icekubit.models.HelloWorldEntity;
import io.diegogarcia.icekubit.models.MatchEntity;
import io.diegogarcia.icekubit.models.Player;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HelloWorldDatabaseManager {
    private static SessionFactory sessionFactory;

    public static void main(String[] args) {

        sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(HelloWorldEntity.class)
                .addAnnotatedClass(Player.class)
                .addAnnotatedClass(MatchEntity.class)
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");
        MatchEntity matchEntity = new MatchEntity();
        matchEntity.setPlayer1(player1);
        matchEntity.setPlayer2(player2);
        matchEntity.setWinner(player1);
        session.save(player1);
        session.save(player2);
        session.save(matchEntity);


        MatchEntity matchEntity1 = session.get(MatchEntity.class, 1);
        System.out.println(matchEntity1);

        String hql = "FROM Player p WHERE p.name = :name";
        Query query = session.createQuery(hql);
        query.setParameter("name", "Player1");
        List<Player> results = query.getResultList();
        System.out.println("results = " + results);

        transaction.commit();

        session.close();

        sessionFactory.close();
    }

}