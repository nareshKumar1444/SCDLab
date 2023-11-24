<%-- 
    Document   : login.jsp
    Created on : Oct 12, 2023, 10:27:02 PM
    Author     : Dell
--%>

<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
    <form action="LoginServlet" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" placeholder="Enter your username"><br><br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" placeholder="Enter your password"><br><br>
        <button class="Login">Login</button>
    </form>
</body>
</html>
