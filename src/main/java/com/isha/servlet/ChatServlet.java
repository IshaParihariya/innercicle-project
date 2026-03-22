package com.isha.servlet;

import com.isha.model.UserRegistration;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;


// after clicking on the user from chatusers we will get here to get in the chat
@WebServlet("/chat")
public class ChatServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String receiver = request.getParameter("receiver");

        // sender from session
        // This gets currently logged-in user
        UserRegistration user = (UserRegistration) request.getSession().getAttribute("user");

        String sender = null;
        if(user != null) {
            sender = user.getName();
        }
        // error was here as sender ==null so we got this done!!
        System.out.println("Sender from session: " + sender);


        // passing data to jsp
        request.setAttribute("receiver", receiver);
        request.setAttribute("sender", sender);

        RequestDispatcher rd = request.getRequestDispatcher("chatmessage.jsp");
        rd.forward(request, response);
    }
}