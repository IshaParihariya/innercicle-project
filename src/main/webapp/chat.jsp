<%--
  Created by IntelliJ IDEA.
  User: ishh1
  Date: 3/21/2026
  Time: 10:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>InnerCircle Chat</title>

    <!-- Linking external CSS -->
    <link rel="stylesheet" href="css/chat.css">
</head>

<body>

<div class="chat-container">

    <!-- Header -->
    <div class="chat-header">
        InnerCircle Chat 💬
    </div>

    <!-- Chat Messages -->
    <div id="chatBox" class="chat-box">
        <!-- Messages will be loaded here -->
    </div>

    <!-- Input Area -->
    <div class="chat-input">
        <input type="text" id="msg" placeholder="Type a message..." />
        <button onclick="sendMessage()">Send</button>
    </div>

</div>

</body>
</html>