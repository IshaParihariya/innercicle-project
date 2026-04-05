<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.isha.model.UserRegistration" %>
<%@ page import="java.util.Base64" %>
<%
    // Get logged-in user to exclude them from the list
    UserRegistration currentUser = (UserRegistration) session.getAttribute("user");

    // Safety check
    if(currentUser == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    List<UserRegistration> users = (List<UserRegistration>) request.getAttribute("users");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chat Users - InnerCircle</title>

    <!-- Google Font -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=DM+Sans:wght@400;500;600;700&display=swap" rel="stylesheet">

    <!-- CSS -->
    <link rel="stylesheet" href="css/chatusers.css">
</head>
<body>

<div class="container">
    <!-- HEADER -->
    <div class="header">
        💬 InnerCircle Chat
    </div>

    <!-- USER LIST -->
    <div class="user-list">
        <%
            if(users != null && !users.isEmpty()) {
                boolean hasUsersToShow = false;

                for(UserRegistration user : users) {
                    // Don't show the current logged-in user
                    if(!user.getEmail().equals(currentUser.getEmail())) {
                        hasUsersToShow = true;
        %>

        <div class="user-card">
            <!-- CRITICAL: Pass EMAIL as receiver parameter -->
            <a href="chat?receiver=<%= user.getEmail() %>">

                <!-- AVATAR -->
                <div class="user-avatar">
                    <%
                        if(user.getProfilePicture() != null && user.getProfilePicture().length > 0) {
                            String base64Image = Base64.getEncoder().encodeToString(user.getProfilePicture());
                    %>
                    <img src="data:image/jpeg;base64,<%= base64Image %>" alt="<%= user.getName() %>">
                    <%
                    } else {
                        // Show first letter of name as placeholder
                        String firstLetter = user.getName().substring(0, 1).toUpperCase();
                    %>
                    <div class="avatar-placeholder">
                        <%= firstLetter %>
                    </div>
                    <%
                        }
                    %>
                </div>

                <!-- USER INFO -->
                <div class="user-info">
                    <div class="user-name"><%= user.getName() %></div>
                    <div class="user-bio">
                        <%= user.getBio() != null && !user.getBio().trim().isEmpty()
                                ? user.getBio()
                                : "Hey there! I'm using InnerCircle 👋" %>
                    </div>
                </div>

            </a>
        </div>

        <%
                }
            }

            // If no users to show (only current user exists)
            if(!hasUsersToShow) {
        %>
        <div class="no-users">
            <p>No other users available to chat with.</p>
            <p style="margin-top: 10px; font-size: 14px;">Invite friends to join InnerCircle! 🚀</p>
        </div>
        <%
            }
        } else {
        %>
        <div class="no-users">
            <p>No users found.</p>
            <p style="margin-top: 10px; font-size: 14px;">Be the first to invite someone! 🎉</p>
        </div>
        <%
            }
        %>
    </div>
</div>

</body>
</html>