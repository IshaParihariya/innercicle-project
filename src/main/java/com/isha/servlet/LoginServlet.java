package com.isha.servlet;

import com.isha.model.UserRegistration;
import com.isha.service.UserLoginService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet
{/*
“Login uses POST because it sends sensitive data securely
in the request body instead of exposing it in the URL.”
*/
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    {
        try
        {
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            // if user exists like email and password same then will lpass the object or else not
            UserLoginService userLoginService = new UserLoginService();
            UserRegistration user = userLoginService.loginUser(email, password);

            // response
            //It tells the browser:
            //“Hey, I’m sending plain text, don’t treat it like HTML."
            response.setContentType("text/plain");
            response.getWriter().println("user logged in");

        }
        catch (Exception e)
        {
            try {
                response.setContentType("text/plain");
                response.getWriter().println("Error: " + e.getMessage());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }
}
