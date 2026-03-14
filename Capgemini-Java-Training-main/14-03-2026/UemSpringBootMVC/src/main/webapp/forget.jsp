<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Forgot Password</title>
</head>
<body>

<h2>Forgot Password</h2>

<form action="ForgetServlet" method="post">

    Enter Email:<br>
    <input type="email" name="email" required><br><br>

    New Password:<br>
    <input type="password" name="newPassword" required><br><br>

    <input type="submit" value="Reset Password">

</form>

<a href="login.jsp">Back to Login</a>

</body>
</html>