package com.isha.dao;

import com.isha.model.Post;
import jakarta.servlet.ServletException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class GetPostDao
{
    public List<Post> getPost()
    {
        SessionFactory sessionFactory=new Configuration().configure("hibernatepost.cfg.xml").buildSessionFactory();
        Session session=sessionFactory.openSession();
        /*
        Fetching data doesn’t strictly require a transaction, but in Hibernate/Spring applications,
        transactions are recommended even for read operations to support lazy loading,
         ensure consistency, and maintain proper session management.
         */

        List<Post> posts=null;
        // try catch blocks
        try
        {
            // query
            // random posts
            // could have used Collections.shuffle() as well
            // switched to PostgreSQL
            posts = session.createQuery(
                    "FROM Post ORDER BY random()", Post.class
            ).list();

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
        return posts;
    }
}
