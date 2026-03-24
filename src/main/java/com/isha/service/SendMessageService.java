package com.isha.service;

import com.isha.dao.SendMessageDao;
import com.isha.model.ChatMessage;
import com.isha.servlet.SendMessageServlet;

public class SendMessageService
{
    public void sendMessageService(ChatMessage sendMessage)
    {
        // for message
        if(sendMessage.getMessage()==null||sendMessage.getMessage().trim().isEmpty())
        {
            throw new IllegalArgumentException("enter a message");
        }
        // for sender
        if(sendMessage.getSender()==null||sendMessage.getSender().trim().isEmpty())
        {
            throw new RuntimeException("retry sending message");
        }
        // for receiver
        if(sendMessage.getReceiver()==null||sendMessage.getReceiver().trim().isEmpty())
        {
            throw new RuntimeException("retry sending message");
        }
        // for time
        if(sendMessage.getTime()==null)
        {
            throw new RuntimeException("retry");
        }

        // if no exception or problem then pass the chat data to the Dao it will communicate with the database
        SendMessageDao sendMessageDao=new SendMessageDao();
        sendMessageDao.sendMessageDao(sendMessage);
    }
}
