<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.isha.model.UserRegistration" %>
<%@ page import="java.util.Base64" %>
<%
    UserRegistration user = (UserRegistration) session.getAttribute("user");

    if(user == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    String base64Image = null;
    if(user.getProfilePicture() != null && user.getProfilePicture().length > 0) {
        base64Image = Base64.getEncoder().encodeToString(user.getProfilePicture());
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Dashboard - InnerCircle</title>
    <link rel="stylesheet" href="css/useracc.css">
</head>
<body>

<div class="dashboard-container">

    <!-- Profile Section -->
    <div class="profile-section">

        <!-- Profile Picture -->
        <div class="profile-pic">
            <% if(base64Image != null) { %>
            <img src="data:image/jpeg;base64,<%= base64Image %>" alt="Profile">
            <% } else { %>
            <div class="avatar-placeholder">
                <%= user.getName().substring(0, 1).toUpperCase() %>
            </div>
            <% } %>
        </div>

        <!-- User Info -->
        <div class="user-info">
            <h2 class="user-name">Welcome, <%= user.getName() %> 💜</h2>

            <!-- Bio Section - FIXED -->
            <div class="bio-section">
                <span class="bio-label">Bio:</span>
                <p class="bio-text">
                    <%= user.getBio() != null && !user.getBio().trim().isEmpty()
                            ? user.getBio()
                            : "Hey there! I'm using InnerCircle 👋" %>
                </p>
            </div>
        </div>
    </div>

    <!-- Action Buttons -->
    <div class="action-buttons">
        <a href="createpost.jsp" class="btn btn-primary">
            Create Post ✨
        </a>
        <a href="getPost" class="btn btn-secondary">
            View Feed 📰
        </a>
        <a href="chatusers" class="btn btn-chat">
            Chat 💬
        </a>
    </div>

</div>

</body>
</html>
