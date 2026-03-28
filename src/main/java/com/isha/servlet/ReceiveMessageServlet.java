package com.isha.servlet;

import com.isha.dao.UserLoginDao;
import com.isha.model.ChatMessage;
import com.isha.model.UserRegistration;
import com.isha.service.ReceiveMessageService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/getMessages")
public class ReceiveMessageServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // get logged-in user
        UserRegistration user = (UserRegistration) request.getSession().getAttribute("user");

        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        // sender = EMAIL (because DB stores email)
        String sender = user.getEmail();

        // receiver = EMAIL from URL
        String receiver = request.getParameter("receiver");

        // convert receiver email → name
        UserLoginDao userDao = new UserLoginDao();
        UserRegistration receiverUser = userDao.getUserByEmail(receiver);

        String receiverName = "Unknown";
        if (receiverUser != null) {
            receiverName = receiverUser.getName();
        }

        // fetch messages using NAMES (IMPORTANT FIX)
        ReceiveMessageService service = new ReceiveMessageService();
        List<ChatMessage> messages = service.fetchMessages(sender, receiver);

        // set attributes for JSP
        request.setAttribute("sender", sender);
        request.setAttribute("receiver", receiver); // keep email for form
        request.setAttribute("receiverName", receiverName); // for display
        request.setAttribute("messages", messages);

        // forward to JSP
        request.getRequestDispatcher("chatmessage.jsp").forward(request, response);
    }
}