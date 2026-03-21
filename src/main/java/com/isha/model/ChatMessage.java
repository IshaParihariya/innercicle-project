package com.isha.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class ChatMessage
{
    @Id
    @Column(name = "chat_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "sender_name")
    private String sender;
    @Column(name = "receiver_name")
    private String receiver;
    private String message;
    // Timestamp = date + time (exact moment) from java.sql.Timestamp
    @Column(name = "sent_time")
    private Timestamp time;

    // zero param constructor
    public ChatMessage()
    {
        System.out.println("zero param construstor of ChatMessage Model");
    }

    // getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    // to String method
    @Override
    public String toString() {
        return "ChatMessage{" +
                "id=" + id +
                ", sender='" + sender + '\'' +
                ", receiver='" + receiver + '\'' +
                ", message='" + message + '\'' +
                ", time=" + time +
                '}';
    }
}
