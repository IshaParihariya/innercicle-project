package com.isha.servlet;

import com.isha.model.ChatMessage;
import com.isha.model.UserRegistration;
import com.isha.service.ReceiveMessageService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/getMessages")
public class ReceiveMessageServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserRegistration user = (UserRegistration) request.getSession().getAttribute("user");
        String sender = user.getEmail();
        String receiver = request.getParameter("receiver");

        request.setAttribute("sender", sender);
        request.setAttribute("receiver", receiver);

        ReceiveMessageService service = new ReceiveMessageService();
        List<ChatMessage> messages = service.fetchMessages(sender, receiver);

        // this tell not html, JSON

        /*
        NOT USING JS cuz a lot of confusion and not sure about it--
        frontend (JavaScript) and backend (Servlet) need a common language to communicate
        that language = JSON
        JS don not understand java objects so JSON is used
         */


        request.setAttribute("messages", messages);
        request.setAttribute("sender", sender);
        request.setAttribute("receiver", receiver);

        try {// request forward to jsp
            request.getRequestDispatcher("chatmessage.jsp").forward(request, response);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}