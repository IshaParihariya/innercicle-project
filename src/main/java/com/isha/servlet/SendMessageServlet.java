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
        // ADD NULL CHECK - THIS IS THE FIX FOR YOUR ERROR
        UserRegistration user = (UserRegistration) request.getSession().getAttribute("user");

        if (user == null) {
            System.out.println("ERROR: User is null in session!");
            response.sendRedirect("login.jsp");
            return;
        }

        String sender = user.getEmail();
        String receiver = request.getParameter("receiver");
        String message = request.getParameter("message");
        Timestamp time = new Timestamp(System.currentTimeMillis());

        ChatMessage sendMessage = new ChatMessage();
        sendMessage.setSender(sender);
        sendMessage.setReceiver(receiver);
        sendMessage.setMessage(message);
        sendMessage.setTime(time);

        // object of the service
        SendMessageService chatService = new SendMessageService();
        chatService.sendMessageService(sendMessage);

        // SHOW updated chat
        response.sendRedirect("getMessages?receiver=" + receiver);
    }
}