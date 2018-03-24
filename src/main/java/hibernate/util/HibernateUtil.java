package hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory =
            new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session openSession() {
        return getSessionFactory().openSession();
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}