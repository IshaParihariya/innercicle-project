<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="./css/register.css">
</head>
<body>

<div class="container">
    <h2>InnerCircle 💖</h2>

    <form action="register" method="post" enctype="multipart/form-data">

        <input type="text" name="name" placeholder="Name" autocomplete="name" required />

        <input type="email" name="email" placeholder="Email"  autocomplete="email"  required />

        <input type="password" name="password" placeholder="Password" autocomplete="new-password" required />

        <input type="text" name="bio" placeholder="Bio" autocomplete="off" />

        <input type="file" name="profilePicture" />

        <button type="submit">Register</button>

    </form>


    <p class="register-link">
        Already have an account?
        <a href="login.jsp">Login</a>
    </p>

</div>

</body>
</html>