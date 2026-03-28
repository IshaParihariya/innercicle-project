<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.isha.model.ChatMessage" %>
<%@ page import="com.isha.model.UserRegistration" %>

<%
    // Get logged-in user object from session
    UserRegistration user = (UserRegistration) session.getAttribute("user");

    // Safety check
    String sender = null;
    if(user != null){
        sender = user.getEmail();   //
    }

    String receiver = (String) request.getAttribute("receiver");
    List<ChatMessage> messages = (List<ChatMessage>) request.getAttribute("messages");
%>

<!DOCTYPE html>
<html>
<head>
    <title>InnerCircle Chat</title>
    <link rel="stylesheet" href="css/chatmessage.css">
</head>

<body>

<div class="chat-container">

    <!-- Header -->
    <div class="chat-header">
        Chat with <%= request.getAttribute("receiverName") %> 💬
    </div>

    <!-- Chat Messages -->
    <div class="chat-box">

        <% if(messages != null && sender != null){
            for(ChatMessage msg : messages){

                if(sender != null && sender.equals(msg.getSender())){
        %>
        <div class="message sent">
            <div><%= msg.getMessage() %></div>
            <span class="time"><%= msg.getTime() %></span>
        </div>
        <%
        } else {
        %>
        <div class="message received">
            <div><%= msg.getMessage() %></div>
            <span class="time"><%= msg.getTime() %></span>
        </div>
        <%
                    }
                }
            } %>

    </div>

    <!-- Send Message Form -->
    <form action="chatmessage" method="post" class="chat-input">

        <!-- NO sender field -->
        <input type="hidden" name="receiver" value="<%= receiver %>">

        <input type="text" name="message" placeholder="Type a message..." required />

        <button type="submit">Send</button>

    </form>

</div>

<!-- Auto scroll -->
<script>
    window.onload = function() {
        let chatBox = document.querySelector(".chat-box");
        chatBox.scrollTop = chatBox.scrollHeight;
    }
</script>

</body>
</html>