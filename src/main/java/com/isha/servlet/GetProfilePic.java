package com.isha.servlet;

import com.isha.model.UserRegistration;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// url in useracc.jsp
// <img src="getProfilePic" width="100" height="100"/>
@WebServlet("/getProfilePic")
public class GetProfilePic extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserRegistration user =
                (UserRegistration) request.getSession().getAttribute("user");

        byte[] image = user.getProfilePicture();

        if (image != null) {
            response.setContentType("image/*");
            response.getOutputStream().write(image);
        }
    }
}