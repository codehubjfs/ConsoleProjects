<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Route</title>
    <style>
        
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 20px;
        }

        .form-container {
            max-width: 600px;
            margin: 20px auto;
            background-color: #fff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .form-group {
            margin-bottom: 20px;
        }

        .form-group label {
            font-weight: bold;
            display: block;
            margin-bottom: 5px;
        }

        .form-group input[type="text"],
        .form-group input[type="number"],
        .form-group textarea {
            width: 100%;
            padding: 8px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        .form-group textarea {
            height: 100px;
            resize: vertical;
        }

        .btn-submit {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 12px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .btn-submit:hover {
            background-color: #45a049;
        }
    </style>
</head>

<body>
    <div class="form-container">
    <a href="${pageContext.request.contextPath}/ViewRoutesController">routview</a>
        <h2>Add New Route</h2>
        <form action="" method="POST">
            <div class="form-group">
                <label for="routeID">Route ID:</label>
                <input type="text" id="routeID" name="routeID" required>
            </div>
            <div class="form-group">
                <label for="source">Source:</label>
                <input type="text" id="source" name="source" required>
            </div>
            <div class="form-group">
                <label for="destination">Destination:</label>
                <input type="text" id="destination" name="destination" required>
            </div>
            <div class="form-group">
                <label for="distance">Distance:</label>
                <input type="number" id="distance" name="distance" required>
            </div>
            <div class="form-group">
                <label for="duration">Duration:</label>
                <input type="text" id="duration" name="duration" required>
            </div>
            <div class="form-group">
                <button type="submit" class="btn-submit">Submit</button>
            </div>
        </form>
    </div>
</body>

</html>