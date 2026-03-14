<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>Register Page</title>
</head>
<body>

<h2>User Registration</h2>

<form action="RegisterServlet" method="post">
    
    Name:<br>
    <input type="text" name="name" required><br><br>

    Email:<br>
    <input type="email" name="email" required><br><br>

    Password:<br>
    <input type="password" name="password" required><br><br>

    Gender:<br>
    <input type="radio" name="gender" value="Male"> Male
    <input type="radio" name="gender" value="Female"> Female
    <br><br>

    Phone:<br>
    <input type="text" name="phone"><br><br>

    <input type="submit" value="Register">

</form>

</body>
</html>