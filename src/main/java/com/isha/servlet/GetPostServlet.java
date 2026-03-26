package com.isha.servlet;

import com.isha.model.Post;
import com.isha.service.GetPostService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.w3c.dom.stylesheets.LinkStyle;

import java.io.IOException;
import java.util.List;

@WebServlet("/getPost")
public class GetPostServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        // service object
        GetPostService getPostService=new GetPostService();
        List<Post> posts= getPostService.getPost();

        // send to frontend (JSP)
        req.setAttribute("posts", posts);

        // forward
        req.getRequestDispatcher("feed.jsp").forward(req, resp);
    }
}
