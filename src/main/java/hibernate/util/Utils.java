package hibernate.util;

import hibernate.entities.Album;
import hibernate.entities.Composition;
import hibernate.entities.Executor;
import org.hibernate.Session;

import java.util.List;

public class Utils {

    public static void insertIntoTables() {
        Executor lumen = new Executor("Lumen");
        Executor metallica = new Executor("Metallica");
        Executor slipknot = new Executor("Slipknot");
        Executor bi2 = new Executor("Би 2");
        Executor rammstein = new Executor("Rammstein");

        Album lumenAlbum = new Album("Lumen album", "rock", lumen);
        Album metallicaAlbum = new Album("Metallica album", "metall", metallica);
        Album slipknotAlbum = new Album("Slipknot album", "metall", slipknot);
        Album bi2Album = new Album("Неизданное", "рок", bi2);
        Album rammsteinAlbum = new Album("Rammstein album", "rock", rammstein);

        Composition seconds = new Composition("Seconds", 500, lumenAlbum);
        Composition sidAndNancy = new Composition("Sid & Nancy", 600, lumenAlbum);
        Composition waitAndBleed = new Composition("Wait & Bleed", 400, slipknotAlbum);
        Composition nothingElseMatters = new Composition("Nothing else matters", 550, metallicaAlbum);
        Composition durochka = new Composition("Дурочка", 450, bi2Album);
        Composition zajigat = new Composition("Зажигать", 330, bi2Album);
        Composition rammsteinComp = new Composition("Rammstein", 800, rammsteinAlbum);
        Composition sonne = new Composition("Sonne", 335, rammsteinAlbum);

        Session session = HibernateUtil.openSession();
        session.beginTransaction();

        session.save(lumen);
        session.save(metallica);
        session.save(slipknot);
        session.save(bi2);
        session.save(rammstein);

        session.save(lumenAlbum);
        session.save(metallicaAlbum);
        session.save(slipknotAlbum);
        session.save(bi2Album);
        session.save(rammsteinAlbum);

        session.save(seconds);
        session.save(sidAndNancy);
        session.save(waitAndBleed);
        session.save(nothingElseMatters);
        session.save(durochka);
        session.save(zajigat);
        session.save(rammsteinComp);
        session.save(sonne);

        session.getTransaction().commit();
    }

    public static void showExecutors() {
        List<Executor> executors;

        Session session = HibernateUtil.openSession();
        session.beginTransaction();
        executors = (List<Executor>) session.createQuery("select e from Executor e").list();
        session.getTransaction().commit();
        session.close();

        System.out.println(String.format("%-15s%-15s", "ID", "Name"));
        if (executors != null) {
            for (Executor e : executors) {
                System.out.println(String.format("%-15s%-15s", e.getId(), e.getName()));
            }
        }
    }
}
