package com.isha.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();
    private static final SessionFactory postSessionFactory = buildPostSessionFactory();
    private static final SessionFactory chatSessionFactory = buildChatSessionFactory(); // add

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    private static SessionFactory buildPostSessionFactory() {
        try {
            return new Configuration().configure("hibernatepost.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    //  add this
    private static SessionFactory buildChatSessionFactory() {
        try {
            return new Configuration().configure("hibernatechat.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() { return sessionFactory; }
    public static SessionFactory getPostSessionFactory() { return postSessionFactory; }
    public static SessionFactory getChatSessionFactory() { return chatSessionFactory; } //  add

    public static void shutdown() {
        getSessionFactory().close();
        getPostSessionFactory().close();
        getChatSessionFactory().close(); //  add
    }
}