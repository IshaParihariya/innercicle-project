package com.isha.servlet;

import com.isha.model.ChatMessage;
import com.isha.model.UserRegistration;
import com.isha.service.SendMessageService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Timestamp;

@WebServlet("/chatmessage")
public class SendMessageServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        UserRegistration user = (UserRegistration) request.getSession().getAttribute("user");
        String sender = user.getEmail();
        String receiver =request.getParameter("receiver");
        String message =request.getParameter("message");
        Timestamp time = new Timestamp(System.currentTimeMillis());


        ChatMessage sendMessage=new ChatMessage();
        sendMessage.setSender(sender);
        sendMessage.setReceiver(receiver);
        sendMessage.setMessage(message);
        sendMessage.setTime(time);

        // object of the service
        SendMessageService chatService =new SendMessageService();
        chatService.sendMessageService(sendMessage);

        // Go to another URL after this work is done
        // reload page but go here
        /*
        chat?sender=Isha&receiver=Rahul
        Means:
        open /chat servlet
        send data:
        sender =Isha
        receiver= Rahul
         */
        // SHOW updated chat
        // get => data in URL and post => data in body
        // ? is called Query String Separator
       //  response.sendRedirect("getMessages?sender=" + sender + "&receiver=" + receiver);

        response.sendRedirect("getMessages?receiver=" + receiver);
    }

}
