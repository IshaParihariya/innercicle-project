<%--
  Created by IntelliJ IDEA.
  User: ishh1
  Date: 3/19/2026
  Time: 6:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.isha.model.UserRegistration"%>

<%--setAttribute → SEND
getAttribute → RECEIVE
--%>

<%--type casting--%>
<%UserRegistration user = (UserRegistration) request.getSession().getAttribute("user");
    if(user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>



<html>
<head>
<title>User Dashboard</title>
<link rel="stylesheet" href="css/useracc.css">
</head>
<body>

<div class="container">

<!-- Profile Section -->
<div class="profile">
    <div class="profile-pic">
        <img src="getProfilePic"/>
    </div>

    <h2>Welcome, <%= user.getName() %> 💖</h2>

    <p><b>Bio:</b> <%= user.getBio() %></p>
</div>

<!-- Actions -->
    <div class="actions">

        <a href="createpost.jsp">
            <button>Create Post ➕</button>
        </a>

        <a href="feed.jsp">
            <button>View Feed 👀</button>
        </a>

        <a href="chatusers.jsp">
            <button>Chat 💬</button>
        </a>

    </div>
</div>

</div>

</body>
</html>
