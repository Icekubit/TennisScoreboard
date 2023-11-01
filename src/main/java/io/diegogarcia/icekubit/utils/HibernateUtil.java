package io.diegogarcia.icekubit.utils;

import io.diegogarcia.icekubit.models.MatchEntity;
import io.diegogarcia.icekubit.models.Player;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    static {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Player.class)
                .addAnnotatedClass(MatchEntity.class)
                .buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}