package com.isha.service;

import com.isha.dao.ReceieveMessageDao;
import com.isha.model.ChatMessage;

import java.util.List;

public class ReceiveMessageService {

    public List<ChatMessage> fetchMessages(String sender, String receiver) {

        ReceieveMessageDao dao = new ReceieveMessageDao();

        return dao.getMessages(sender, receiver);
    }
}