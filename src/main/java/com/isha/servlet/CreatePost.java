package com.isha.servlet;

import com.isha.service.CreatePostService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet
public class CreatePost extends HttpServlet
{
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    {
        String post=request.getParameter("post");

        CreatePostService createPostService=new CreatePostService();
    }
}
