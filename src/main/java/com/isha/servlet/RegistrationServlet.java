package com.isha.servlet;

import com.isha.model.UserRegistration;
import com.isha.service.UserRegistrationService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet
{
    // for the data to get in the database
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    {
        // get data from form
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String bio = request.getParameter("bio");

        // create object
        /*
        filling object with data
  Now object contains:
  example :
  UserRegistration {
  name = Isha
  email = isha@gmail.com
  password = 1234
}
         */
        UserRegistration user = new UserRegistration();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setBio(bio);

        // call service
        UserRegistrationService service = new UserRegistrationService();
        service.registerUserService(user);

        // response
        try
        {
            response.getWriter().println("Registration Successful");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
