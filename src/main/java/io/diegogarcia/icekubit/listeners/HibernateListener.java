package io.diegogarcia.icekubit.listeners;

import io.diegogarcia.icekubit.dao.MatchesDao;
import io.diegogarcia.icekubit.dao.PlayerDao;
import io.diegogarcia.icekubit.models.Match;
import io.diegogarcia.icekubit.models.MatchEntity;
import io.diegogarcia.icekubit.models.Player;
import io.diegogarcia.icekubit.services.PlayerService;
import io.diegogarcia.icekubit.utils.HibernateUtil;
import jakarta.persistence.Query;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class HibernateListener implements ServletContextListener {

    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    @Override
    public void contextInitialized(ServletContextEvent sce) {

        Player player1 = new Player("Casper Ruud");
        Player player2 = new Player("Daniil Medvedev");
        Player player3 = new Player("Andrey Rublev");
        Player player4 = new Player("Novak Djokovic");
        Player player5 = new Player("Carlos Alcaraz");
        Player player6 = new Player("Jannik Sinner");
        Player player7 = new Player("Stefanos Tsitsipas");
        Player player8 = new Player("Holger Rune");
        Player player9 = new Player("Taylor Fritz");
        Player player10 = new Player("Tommy Paul");

        PlayerDao.getInstance().save(player1);
        PlayerDao.getInstance().save(player2);
        PlayerDao.getInstance().save(player3);
        PlayerDao.getInstance().save(player4);
        PlayerDao.getInstance().save(player5);
        PlayerDao.getInstance().save(player6);
        PlayerDao.getInstance().save(player7);
        PlayerDao.getInstance().save(player8);
        PlayerDao.getInstance().save(player9);
        PlayerDao.getInstance().save(player10);

        MatchEntity match1 = new MatchEntity(player1, player10, player10);
        MatchEntity match2 = new MatchEntity(player2, player8, player8);
        MatchEntity match3 = new MatchEntity(player6, player5, player6);
        MatchEntity match4 = new MatchEntity(player1, player2, player1);
        MatchEntity match5 = new MatchEntity(player7, player4, player4);
        MatchEntity match6 = new MatchEntity(player2, player8, player2);
        MatchEntity match7 = new MatchEntity(player6, player3, player3);
        MatchEntity match8 = new MatchEntity(player2, player4, player4);
        MatchEntity match9 = new MatchEntity(player7, player8, player7);
        MatchEntity match10 = new MatchEntity(player6, player3, player3);
        MatchEntity match11 = new MatchEntity(player9, player10, player9);
        MatchEntity match12 = new MatchEntity(player1, player9, player1);
        MatchEntity match13 = new MatchEntity(player10, player1, player10);
        MatchEntity match14 = new MatchEntity(player4, player8, player8);
        MatchEntity match15 = new MatchEntity(player1, player2, player2);
        MatchEntity match16 = new MatchEntity(player6, player4, player4);
        MatchEntity match17 = new MatchEntity(player7, player3, player7);
        MatchEntity match18 = new MatchEntity(player3, player2, player2);
        MatchEntity match19 = new MatchEntity(player6, player8, player6);
        MatchEntity match20 = new MatchEntity(player7, player4, player4);
        MatchEntity match21 = new MatchEntity(player3, player5, player5);
        MatchEntity match22 = new MatchEntity(player2, player6, player2);
        MatchEntity match23 = new MatchEntity(player1, player2, player2);
        MatchEntity match24 = new MatchEntity(player9, player1, player9);
        MatchEntity match25 = new MatchEntity(player1, player2, player2);
        MatchEntity match26 = new MatchEntity(player6, player5, player5);
        MatchEntity match27 = new MatchEntity(player4, player2, player4);
        MatchEntity match28 = new MatchEntity(player1, player2, player2);
        MatchEntity match29 = new MatchEntity(player3, player7, player7);
        MatchEntity match30 = new MatchEntity(player1, player6, player6);
        MatchEntity match31 = new MatchEntity(player4, player8, player8);
        MatchEntity match32 = new MatchEntity(player7, player9, player9);

        MatchesDao.getInstance().save(match1);
        MatchesDao.getInstance().save(match2);
        MatchesDao.getInstance().save(match3);
        MatchesDao.getInstance().save(match4);
        MatchesDao.getInstance().save(match5);
        MatchesDao.getInstance().save(match6);
        MatchesDao.getInstance().save(match7);
        MatchesDao.getInstance().save(match8);
        MatchesDao.getInstance().save(match9);
        MatchesDao.getInstance().save(match10);
        MatchesDao.getInstance().save(match11);
        MatchesDao.getInstance().save(match12);
        MatchesDao.getInstance().save(match13);
        MatchesDao.getInstance().save(match14);
        MatchesDao.getInstance().save(match15);
        MatchesDao.getInstance().save(match16);
        MatchesDao.getInstance().save(match17);
        MatchesDao.getInstance().save(match18);
        MatchesDao.getInstance().save(match19);
        MatchesDao.getInstance().save(match20);
        MatchesDao.getInstance().save(match21);
        MatchesDao.getInstance().save(match22);
        MatchesDao.getInstance().save(match23);
        MatchesDao.getInstance().save(match24);
        MatchesDao.getInstance().save(match25);
        MatchesDao.getInstance().save(match26);
        MatchesDao.getInstance().save(match27);
        MatchesDao.getInstance().save(match28);
        MatchesDao.getInstance().save(match29);
        MatchesDao.getInstance().save(match30);
        MatchesDao.getInstance().save(match31);
        MatchesDao.getInstance().save(match32);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        if (sessionFactory != null && !sessionFactory.isClosed()) {
            sessionFactory.close();
        }
    }
}