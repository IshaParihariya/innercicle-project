package com.isha.dao;

import com.isha.model.Post;
import com.isha.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CreatePostDao
{
    public void postDao(String post)
    {
        Session session = HibernateUtil.getPostSessionFactory().openSession();
        Transaction transaction=null;
        boolean flag=false;

        // try and catch block for the transaction and data saving
        try
        {
            transaction= session.beginTransaction();
            Post p=new Post();
            p.setPost(post);
            session.persist(p);
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
                transaction.commit();// save permanently
            }
            else
            {
                transaction.rollback(); // no changes roll back
            }

            session.close();
           // sessionFactory.close();
        }
    }
    }
