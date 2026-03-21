package com.isha.servlet;

import com.isha.dao.ChatUserDao;
import com.isha.model.UserRegistration;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

// for the fetching of the users from the db

    @WebServlet("/chatusers")
    public class ChatUserServlet extends HttpServlet {

        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            ChatUserDao dao = new ChatUserDao();
            List<UserRegistration> users = dao.getAllUsers();

            request.setAttribute("users", users);

            RequestDispatcher rd = request.getRequestDispatcher("chatusers.jsp");
            rd.forward(request, response);
        }
    }
