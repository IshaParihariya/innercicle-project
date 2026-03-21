package com.isha.servlet;

import com.isha.model.Post;
import com.isha.service.CreatePostService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/post")
public class CreatePostServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException
    {
        Post p=new Post();
        String post=request.getParameter("post");
        p.setPost(post);

        try
        {
            // object of CreatePostService
            CreatePostService createPostService = new CreatePostService();
            createPostService.postService(post);

            // after saaving the post
            // IMP : bout sessions
           // i didnt have the user data like as I didnt store it in the session
            // so i lost it and when i am redirecting to useracc.jsp
            // it needs the user to get the name bio etc so
            // I stored the user in the session
            // check login servlet for this -> request.getSession().setAttribute("user", user);
            response.sendRedirect("useracc.jsp");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
