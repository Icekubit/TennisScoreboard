package io.diegogarcia.icekubit.listeners;

import io.diegogarcia.icekubit.dao.MatchesDao;
import io.diegogarcia.icekubit.dao.PlayerDao;
import io.diegogarcia.icekubit.models.Match;
import io.diegogarcia.icekubit.models.Player;
import io.diegogarcia.icekubit.utils.HibernateUtil;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import org.hibernate.SessionFactory;

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

        Match match1 = new Match(player1, player10, player10);
        Match match2 = new Match(player2, player8, player8);
        Match match3 = new Match(player6, player5, player6);
        Match match4 = new Match(player1, player2, player1);
        Match match5 = new Match(player7, player4, player4);
        Match match6 = new Match(player2, player8, player2);
        Match match7 = new Match(player6, player3, player3);
        Match match8 = new Match(player2, player4, player4);
        Match match9 = new Match(player7, player8, player7);
        Match match10 = new Match(player6, player3, player3);
        Match match11 = new Match(player9, player10, player9);
        Match match12 = new Match(player1, player9, player1);
        Match match13 = new Match(player10, player1, player10);
        Match match14 = new Match(player4, player8, player8);
        Match match15 = new Match(player1, player2, player2);
        Match match16 = new Match(player6, player4, player4);
        Match match17 = new Match(player7, player3, player7);
        Match match18 = new Match(player3, player2, player2);
        Match match19 = new Match(player6, player8, player6);
        Match match20 = new Match(player7, player4, player4);
        Match match21 = new Match(player3, player5, player5);
        Match match22 = new Match(player2, player6, player2);
        Match match23 = new Match(player1, player2, player2);
        Match match24 = new Match(player9, player1, player9);
        Match match25 = new Match(player1, player2, player2);
        Match match26 = new Match(player6, player5, player5);
        Match match27 = new Match(player4, player2, player4);
        Match match28 = new Match(player1, player2, player2);
        Match match29 = new Match(player3, player7, player7);
        Match match30 = new Match(player1, player6, player6);
        Match match31 = new Match(player4, player8, player8);
        Match match32 = new Match(player7, player9, player9);

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