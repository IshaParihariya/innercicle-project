package com.isha.dao;

import com.isha.model.ChatMessage;
import com.isha.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SendMessageDao
{
    public void sendMessageDao(ChatMessage sendMessage)
    {
        Session session = HibernateUtil.getChatSessionFactory().openSession();

        Transaction transaction=null;
        boolean flag=false;

        // try and catch blocks
        try
        {
           transaction=session.beginTransaction();
           session.persist(sendMessage);
            flag=true;
        }
        catch(HibernateException e)
        {
            if(transaction!=null)
            {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        catch (Exception e)
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
                transaction.commit();
            }
            else
            {
                transaction.rollback();
            }
            session.close();
            //sessionFactory.close();
        }
    }
}
