package com.isha.dao;

import com.isha.model.UserRegistration;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class UserLoginDao
{


    //Why returning UserRegistration?
    // database returns rows we need to convert them into java objects
    // also returning object gives the full data
    public UserRegistration getUserByEmail(String email)
    {
        UserRegistration user=null;
        /*
        Note :
        SessionFactory is heavy and expensive (memory + CPU , basically resources and time) to create,
        so we create it once and reuse it throughout the application.
        BUT HERE WE ARE LEARNING AND I DONT HAVE MUCH IDEA YET SO WE DOING LIKE THIS**
         */
        SessionFactory sessionFactory= new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session=sessionFactory.openSession();


        // try and catch block
        try
        {
            /*
            :email = placeholder ( something will fill later )
             setParameter("email",email) = fills that placeholder
             */
            String hql = "FROM UserRegistration WHERE email = :email";
            Query<UserRegistration> query=session.createQuery(hql,UserRegistration.class);
            query.setParameter("email",email);
            //uniqueResult() = “give me ONE object or null”
            user = query.uniqueResult();

        }
        catch(HibernateException e)
        {
            e.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        // finally block
        finally
        {
            session.close();
            sessionFactory.close();
        }
return user;// returning user object
    }
}

