<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Form</title>
</head>
<body>
    <h2>User Registration Form</h2>
    <form action="register" method="post">
        First Name: <input type="text" name="firstName" required><br>
        Last Name: <input type="text" name="lastName" required><br>
        Email: <input type="email" name="email" required><br>
        Gender: 
        <select name="gender" required>
            <option value="Male">Male</option>
            <option value="Female">Female</option>
        </select><br>
        Phone Number: <input type="text" name="phoneNumber" ><br>
        Password: <input type="password" name="password" ><br>
        Account Status: <input type="text" name="accountStatus" ><br>
        License ID: <input type="text" name="licenseId" ><br>
        Username: <input type="text" name="username" ><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
