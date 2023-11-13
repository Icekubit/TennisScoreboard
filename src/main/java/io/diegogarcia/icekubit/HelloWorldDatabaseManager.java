package io.diegogarcia.icekubit;

import io.diegogarcia.icekubit.models.HelloWorldEntity;
import io.diegogarcia.icekubit.models.Match;
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
                .addAnnotatedClass(Match.class)
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");
        Match matchEntity = new Match();
        matchEntity.setPlayer1(player1);
        matchEntity.setPlayer2(player2);
        matchEntity.setWinner(player1);
        session.save(player1);
        session.save(player2);
        session.save(matchEntity);


        Match matchEntity1 = session.get(Match.class, 1);
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