package com.isha.dao;

import com.isha.model.ChatMessage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class ReceieveMessageDao {
    public List<ChatMessage> getMessages(String sender, String receiver)
    {
        SessionFactory sessionFactory=new Configuration().configure("hibernatechat.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();

        String hql = "FROM ChatMessage WHERE " +
                "(sender = :sender AND receiver = :receiver) OR " +
                "(sender = :receiver AND receiver = :sender) " +
                "ORDER BY time";
// here msgs as per the time so in order of time
        Query<ChatMessage> query = session.createQuery(hql, ChatMessage.class);
        query.setParameter("sender", sender);
        query.setParameter("receiver", receiver);

        List<ChatMessage> messages = query.getResultList();

        session.close();
        return messages;
    }
}
