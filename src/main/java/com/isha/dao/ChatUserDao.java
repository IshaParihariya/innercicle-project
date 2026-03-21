package com.isha.dao;

import com.isha.model.UserRegistration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class ChatUserDao {

       SessionFactory sessionFactory = new Configuration()
                .configure("hibernatepost.cfg.xml")
                .buildSessionFactory();


    public List<UserRegistration> getAllUsers() {

        Session session = sessionFactory.openSession();
        List<UserRegistration> users = null;

        try {
            String hql = "FROM UserRegistration";
            Query<UserRegistration> query = session.createQuery(hql, UserRegistration.class);

            users = query.list();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            session.close();
            sessionFactory.close();
        }

        return users;
    }
}