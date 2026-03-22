package com.isha.servlet;

import com.isha.model.ChatMessage;
import com.isha.service.ReceiveMessageService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/getMessages")
public class ReceiveMessageServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String sender = request.getParameter("sender");
        String receiver = request.getParameter("receiver");

        ReceiveMessageService service = new ReceiveMessageService();
        List<ChatMessage> messages = service.fetchMessages(sender, receiver);

        // this tell not html, JSON

        /*
        frontend (JavaScript) and backend (Servlet) need a common language to communicate
        that language = JSON
        JS don not understand java objects so JSON is used
         */
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        out.print("[");
        for (int i = 0; i < messages.size(); i++) {
            ChatMessage m = messages.get(i);

            out.print("{");
            out.print("\"sender\":\"" + m.getSender() + "\",");
            out.print("\"message\":\"" + m.getMessage() + "\"");
            out.print("\"time\":\"" + m.getTime() + "\"");
            out.print("}");

            if (i < messages.size() - 1) {
                out.print(",");
            }
        }
        out.print("]");
    }
}