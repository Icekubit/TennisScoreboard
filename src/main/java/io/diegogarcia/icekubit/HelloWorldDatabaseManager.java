package io.diegogarcia.icekubit;

import io.diegogarcia.icekubit.models.HelloWorldEntity;
import io.diegogarcia.icekubit.models.Match;
import io.diegogarcia.icekubit.models.Player;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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
        Match match = new Match();
        match.setPlayer1(player1);
        match.setPlayer2(player2);
        match.setWinner(player1);
        session.save(player1);
        session.save(player2);
        session.save(match);


        Match match1 = session.get(Match.class, 1);
        System.out.println(match1);

        transaction.commit();

        session.close();

        sessionFactory.close();
    }

}