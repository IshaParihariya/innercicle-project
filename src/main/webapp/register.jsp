<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="css/register.css">
</head>
<body>

<div class="container">
    <h2>InnerCircle 💖</h2>

    <form action="register" method="post" enctype="multipart/form-data">

        <input type="text" name="name" placeholder="Name" required />

        <input type="email" name="email" placeholder="Email" required />

        <input type="password" name="password" placeholder="Password" required />

        <input type="text" name="bio" placeholder="Bio" />

        <input type="file" name="profilePicture" />

        <button type="submit">Register</button>

    </form>

    <!-- 👇 ADDED THIS ONLY -->
    <p style="text-align:center; margin-top:15px;">
        Already have an account?
        <a href="login.jsp" style="color:#ff4d6d; font-weight:bold; text-decoration:none;">
            Login
        </a>
    </p>

</div>

</body>
</html>