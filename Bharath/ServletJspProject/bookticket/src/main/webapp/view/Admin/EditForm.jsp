<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Route</title>
    <style>
        /* Add your CSS styles here */
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            padding: 20px;
        }
        
        h1 {
            color: #163c83;
        }
        
        form {
            margin-top: 20px;
            background-color: #ffffff;
            padding: 20px;
            border: 1px solid #dddddd;
            border-radius: 5px;
        }
        
        label {
            display: block;
            margin-bottom: 10px;
            font-weight: bold;
        }
        
        input[type=text], input[type=number] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        
        button[type=submit] {
            background-color: #163c83;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        
        button[type=submit]:hover {
            background-color: #0c2e6e;
        }
    </style>
</head>
<body>
    <h1>Edit Route</h1>
    <c:forEach items="${routes}" var="route" varstatus="loop">
    <form action="${pageContext.request.contextPath}/EditRoutesController" method="post">
        <input type="hidden" name="id" value="${route.id}">
        <label for="source">Source:</label>
        <input type="text" id="source" name="source" value="${route.source}" required>
        
        <label for="destination">Destination:</label>
        <input type="text" id="destination" name="destination" value="${route.destination}" required>
        
        <label for="distance">Distance:</label>
        <input type="number" id="distance" name="distance" value="${route.distance}" required>
        
        <label for="duration">Duration:</label>
        <input type="number" id="duration" name="duration" value="${route.duration}" required>
        
        <button type="submit">Save</button>
    </form>
     </c:forEach>
</body>
</html>
