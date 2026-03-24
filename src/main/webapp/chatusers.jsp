<%--
  Created by IntelliJ IDEA.
  User: ishh1
  Date: 3/21/2026
  Time: 11:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="com.isha.model.UserRegistration" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<UserRegistration> users = (List<UserRegistration>) request.getAttribute("users");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Select User</title>
    <link rel="stylesheet" href="css/chatusers.css">
</head>
<body>

<div class="container">

    <div class="header">
        InnerCircle 💬
    </div>

    <div class="user-list">

        <% if(users != null) {
            for(UserRegistration u : users) { %>

        <div class="user-card">
            <!-- send EMAIL in URL -->
            <a href="chat?receiver=<%= u.getEmail() %>">
                <!-- Still show NAME to user -->
                <%= u.getName() %>
            </a>
        </div>

        <% } } %>

    </div>

</div>

</body>
</html>