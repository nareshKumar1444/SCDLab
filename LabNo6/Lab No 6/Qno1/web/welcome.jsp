<!DOCTYPE html>
<html>
<head>
    <title>Welcome Page</title>
</head>
<body>
    <h1>Welcome,<%= request.getCookies()[0].getValue() %>!</h1>
<center> <form action="LogoutServlet" method="post">
        <input type="submit" value="Logout">
    </form>
</center>
</body>
</html>