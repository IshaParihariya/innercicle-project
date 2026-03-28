package com.isha.servlet;

import com.isha.model.UserRegistration;
import com.isha.service.UserRegistrationService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;

@WebServlet("/register")
// It is a Servlet annotation used to enable handling of multipart/form-data requests,
// especially for file uploads. It allows access to uploaded files via request.getPart().
// without this my getParameter for name was showing NULL hence error so do NOT FORGET TO ADD IT WHEN ITS ABOUT FILE UPLOADS
@MultipartConfig
public class RegistrationServlet extends HttpServlet
{
    // for the data to get in the database
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException
    {
        // get data from form
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String bio = request.getParameter("bio");
        // get profile picture
        Part filePart=request.getPart("profilePicture");

        byte[] imageBytes=null;
        if(filePart!=null && filePart.getSize()>0)
        {
            imageBytes=filePart.getInputStream().readAllBytes();
        }
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

        // set profile picture
        user.setProfilePicture(imageBytes);

        // call service
        try {
            UserRegistrationService service = new UserRegistrationService();
            service.registerUserService(user);

            RequestDispatcher rd = request.getRequestDispatcher("/userregistered.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();

            request.setAttribute("error", e.getMessage());
            RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
            rd.forward(request, response);
        }
    }
}
