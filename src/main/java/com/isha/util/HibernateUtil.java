package com.isha.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();
    private static final SessionFactory postSessionFactory = buildPostSessionFactory();
    private static final SessionFactory chatSessionFactory = buildChatSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            System.out.println("\n>>> Building SessionFactory for hibernate.cfg.xml");
            Configuration config = new Configuration().configure("hibernate.cfg.xml");

            String dbUrl = EnvLoader.get("DB_URL");
            String dbUser = EnvLoader.get("DB_USERNAME");      // FIXED
            String dbPass = EnvLoader.get("DB_PASSWORD");

            if (dbUrl == null || dbUser == null || dbPass == null) {
                throw new RuntimeException("DB credentials missing! Check Render env vars or .env file");
            }

            config.setProperty("hibernate.connection.url", dbUrl);
            config.setProperty("hibernate.connection.username", dbUser);
            config.setProperty("hibernate.connection.password", dbPass);

            System.out.println("SessionFactory configured successfully\n");
            return config.buildSessionFactory();

        } catch (Throwable ex) {
            System.err.println(" FAILED to build SessionFactory:");
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }
    }

    private static SessionFactory buildPostSessionFactory() {
        try {
            System.out.println("\n>>> Building PostSessionFactory for hibernatepost.cfg.xml");
            Configuration config = new Configuration().configure("hibernatepost.cfg.xml");

            String dbUrl = EnvLoader.get("DB_URL");
            String dbUser = EnvLoader.get("DB_USERNAME");      //  FIXED
            String dbPass = EnvLoader.get("DB_PASSWORD");

            if (dbUrl == null || dbUser == null || dbPass == null) {
                throw new RuntimeException(" DB credentials missing for Post SessionFactory!");
            }

            config.setProperty("hibernate.connection.url", dbUrl);
            config.setProperty("hibernate.connection.username", dbUser);
            config.setProperty("hibernate.connection.password", dbPass);

            System.out.println(" PostSessionFactory configured successfully\n");
            return config.buildSessionFactory();

        } catch (Throwable ex) {
            System.err.println(" FAILED to build PostSessionFactory:");
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }
    }

    private static SessionFactory buildChatSessionFactory() {
        try {
            System.out.println("\n>>> Building ChatSessionFactory for hibernatechat.cfg.xml");
            Configuration config = new Configuration().configure("hibernatechat.cfg.xml");

            String dbUrl = EnvLoader.get("DB_URL");
            String dbUser = EnvLoader.get("DB_USERNAME");      //  FIXED
            String dbPass = EnvLoader.get("DB_PASSWORD");

            if (dbUrl == null || dbUser == null || dbPass == null) {
                throw new RuntimeException("DB credentials missing for Chat SessionFactory!");
            }

            config.setProperty("hibernate.connection.url", dbUrl);
            config.setProperty("hibernate.connection.username", dbUser);
            config.setProperty("hibernate.connection.password", dbPass);

            System.out.println("ChatSessionFactory configured successfully\n");
            return config.buildSessionFactory();

        } catch (Throwable ex) {
            System.err.println("FAILED to build ChatSessionFactory:");
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() { return sessionFactory; }
    public static SessionFactory getPostSessionFactory() { return postSessionFactory; }
    public static SessionFactory getChatSessionFactory() { return chatSessionFactory; }

    public static void shutdown() {
        getSessionFactory().close();
        getPostSessionFactory().close();
        getChatSessionFactory().close();
    }
}