package hibernate;

import hibernate.entities.Executor;
import hibernate.util.HibernateUtil;
import hibernate.util.Utils;
import org.hibernate.Session;

public class Main {

    public static void main(String[] args) {
        Utils.insertIntoTables();

        Executor splean = new Executor("Сплин");

        Session session = HibernateUtil.openSession();
        session.beginTransaction();
        session.save(splean);
        session.getTransaction().commit();
        session.close();

        System.out.println("______________________________________________");
        Utils.showExecutors();

        session = HibernateUtil.openSession();
        session.beginTransaction();
        splean = (Executor)session.get(Executor.class, splean.getId());
        splean.setName("Splean");
        session.getTransaction().commit();
        session.close();

        System.out.println("______________________________________________");
        Utils.showExecutors();

        session = HibernateUtil.openSession();
        session.beginTransaction();
        splean = (Executor)session.get(Executor.class, splean.getId());
        session.delete(splean);
        session.getTransaction().commit();
        session.close();

        System.out.println("______________________________________________");
        Utils.showExecutors();

        HibernateUtil.shutdown();
    }
}
