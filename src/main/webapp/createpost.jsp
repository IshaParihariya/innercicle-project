<%--
  Created by IntelliJ IDEA.
  User: ishh1
  Date: 3/19/2026
  Time: 7:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>create a post</title>
    <link rel="stylesheet" href="css/createpost.css">
</head>
<body>
<form action="post" method="post">

<%-- form is for sending the data --%>
<textarea name="post" placeholder="What's on your mind? 💭" required></textarea>

<button type="submit">Post 🎀</button>

</form>
</body>
</html>
