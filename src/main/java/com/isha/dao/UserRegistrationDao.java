package com.isha.dao;
//update : Yes, my data is fully secure because RLS is enabled and no public policies are defined.
import com.isha.model.UserRegistration;
import com.isha.service.UserRegistrationService;
import com.isha.util.HibernateUtil;
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
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction=null;
        //boolean flag=false;

        // try and catch block for the transaction and data saving
        try
        {
            transaction= session.beginTransaction();
            session.persist(user);
            // were having problems so directly commited
            transaction.commit();
           // flag=true;
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

            session.close();
           // sessionFactory.close();
        }
    }
}
