package com.isha.servlet;

import com.isha.model.UserRegistration;
import com.isha.service.UserLoginService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            // Call service to validate user
            UserLoginService userLoginService = new UserLoginService();
            UserRegistration user = userLoginService.loginUser(email, password);

            // CHECK if user exists
            if (user != null) {

                // Store full user object in session
                HttpSession session = request.getSession();
                session.setAttribute("user", user);

                // Forward to user account page
                RequestDispatcher rd = request.getRequestDispatcher("/useracc.jsp");
                rd.forward(request, response);

            } else {
                // Invalid login
                response.setContentType("text/plain");
                response.getWriter().println("Invalid email or password");
            }

        } catch (Exception e) {
            response.setContentType("text/plain");
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}