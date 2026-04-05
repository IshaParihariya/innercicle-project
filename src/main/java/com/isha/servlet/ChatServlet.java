package com.isha.servlet;

import com.isha.model.UserRegistration;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/chat")
public class ChatServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get receiver email from URL parameter
        String receiver = request.getParameter("receiver");

        // Get currently logged-in user from session
        UserRegistration user = (UserRegistration) request.getSession().getAttribute("user");

        if (user == null) {
            System.out.println("ERROR: User is null in session!");
            response.sendRedirect("login.jsp");
            return;
        }

        if (receiver == null || receiver.trim().isEmpty()) {
            System.out.println("ERROR: Receiver parameter is missing!");
            response.sendRedirect("chatusers.jsp");
            return;
        }

        // REDIRECT to getMessages servlet - it will handle everything properly
        // This ensures messages are loaded correctly
        response.sendRedirect("getMessages?receiver=" + receiver);
    }
}