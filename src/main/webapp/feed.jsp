<%--
  Created by IntelliJ IDEA.
  User: ishh1
  Date: 3/26/2026
  Time: 7:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.isha.model.Post" %>

<!DOCTYPE html>
<html>
<head>
  <title>Feed</title>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="css/feed.css">
</head>
<body class="feed-page">

<div class="feed-container">
  <h2>💬 Your Feed</h2>

  <%
    List<Post> posts = (List<Post>) request.getAttribute("posts");

    if(posts != null && !posts.isEmpty())
    {
      for(Post p : posts)
      {
  %>

  <div class="post-card">
    <p><%= p.getPost() %></p>
  </div>

  <%
    }
  }
  else
  {
  %>

  <p>No posts yet 😢</p>

  <%
    }
  %>

</div>

</body>
</html>