<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="css/login.css">
</head>
<body>

<div class="container">
    <h2>InnerCircle 💖</h2>

    <form action="login" method="post">

        <input type="email" name="email" placeholder="Email" required />

        <input type="password" name="password" placeholder="Password" required />

        <button type="submit">Login</button>

    </form>

    <p class="register-link">
        New here? <a href="register.jsp">Create Account</a>
    </p>
</div>

</body>
</html>