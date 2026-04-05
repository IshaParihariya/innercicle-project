package com.isha.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();
    private static final SessionFactory postSessionFactory = buildPostSessionFactory();
    private static final SessionFactory chatSessionFactory = buildChatSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration config = new Configuration().configure("hibernate.cfg.xml");

            //  inject env variables
            config.setProperty("hibernate.connection.url", EnvLoader.get("DB_URL"));
            config.setProperty("hibernate.connection.username", EnvLoader.get("DB_USERNAME"));
            config.setProperty("hibernate.connection.password", EnvLoader.get("DB_PASSWORD"));

            return config.buildSessionFactory();

        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    private static SessionFactory buildPostSessionFactory() {
        try {
            Configuration config = new Configuration().configure("hibernatepost.cfg.xml");

            config.setProperty("hibernate.connection.url", EnvLoader.get("DB_URL"));
            config.setProperty("hibernate.connection.username", EnvLoader.get("DB_USERNAME"));
            config.setProperty("hibernate.connection.password", EnvLoader.get("DB_PASSWORD"));

            return config.buildSessionFactory();

        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    private static SessionFactory buildChatSessionFactory() {
        try {
            Configuration config = new Configuration().configure("hibernatechat.cfg.xml");

            config.setProperty("hibernate.connection.url", EnvLoader.get("DB_URL"));
            config.setProperty("hibernate.connection.username", EnvLoader.get("DB_USERNAME"));
            config.setProperty("hibernate.connection.password", EnvLoader.get("DB_PASSWORD"));

            return config.buildSessionFactory();

        } catch (Throwable ex) {
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