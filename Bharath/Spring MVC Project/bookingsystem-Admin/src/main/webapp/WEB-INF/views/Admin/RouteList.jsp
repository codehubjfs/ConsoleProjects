<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Route Management</title>
    <style>
        /* Add your CSS styles here */
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }
        
        h1 {
            color: #163c83;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        th {
            background-color: #f2f2f2;
            color: #163c83;
        }

        .action-column {
            white-space: nowrap;
        }

        .edit-link {
            text-decoration: none;
            padding: 5px 10px;
            background-color: #4CAF50;
            color: white;
            border-radius: 3px;
        }

        .edit-link:hover {
            background-color: #45a049;
        }

        form {
            margin-top: 20px;
        }

        label {
            display: block;
            margin-bottom: 8px;
        }

        input[type=text], input[type=password] {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            margin-top: 6px;
            margin-bottom: 16px;
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
    <h1>Route Management</h1>

    <table>
        <thead>
            <tr>
                <th>Index</th>
                <th>Source</th>
                <th>Destination</th>
                <th>Distance</th>
                <th>Duration</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="route" items="${routes}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${route.source}</td>
                    <td>${route.destination}</td>
                    <td>${route.distance}</td>
                    <td>${route.duration}</td>
                    
                    <td class="action-column">
                        <a href="view/Admin/EditForm.jsp?id=${route.index}" class="edit-link">Edit</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
