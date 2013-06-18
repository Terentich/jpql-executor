package org.github.terentich.jpqlexecutor;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main {
    private static EntityManager manager;

    public static void main(String[] args) {
        manager = createEntityManager(args[0]);

        try {
            double startTime = System.currentTimeMillis();
            List<?> objects = executeQuery(args[1]);
            double endTime = System.currentTimeMillis();

            for (Object object : objects) {
                System.out.println(object);
            }

            double duration = endTime - startTime;
            System.out.println("Duration: " + duration / 1000 + " (seconds)");
            System.out.println("Count:    " + objects.size());
        } catch (Exception e) {
            System.err.println("Unable to execute query: " + e);
            e.printStackTrace();
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }

    private static List<?> executeQuery(String sql) {
        Query query = manager.createQuery(sql);

        return query.getResultList();
    }

    private static EntityManager createEntityManager(String persistenceUnitName) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory(persistenceUnitName);

        return factory.createEntityManager();
    }
}