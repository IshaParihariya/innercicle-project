package com.isha.dao;

import com.isha.model.UserRegistration;
import com.isha.service.UserRegistrationService;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class UserRegistrationDao
{
    // saving the user registration data in the database
    public void registerUserDao(UserRegistration user)
    {
        SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=null;
        boolean flag=false;

        // try and catch block for the transaction and data saving
        try
        {
            transaction= session.beginTransaction();
            session.persist(user);
            flag=true;
        }
        catch(HibernateException e)
        {
            if(transaction!=null) // no risk
            {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        catch(Exception e)
        {
            if(transaction!=null)
            {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        // finally block
        finally
        {
            if(flag==true)
            {
                transaction.commit();// sav permanently
            }
            else
            {
                transaction.rollback(); // no changes roll back
            }

            session.close();
            sessionFactory.close();
        }
    }
}
