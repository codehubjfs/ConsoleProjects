<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Bus Search</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>Search Buses</h2>
    <a href="bus">buslist</a>
    <form action="busSearch">
        <div class="form-row">
            <div class="form-group col-md-4">
                <label for="source">Source:</label>
                <input type="text" class="form-control" id="source" name="source" placeholder="Enter source city" list="list-source">
                <datalist id="list-source">
                    <option value="chennai">Chennai</option>
                    <option value="salem">Salem</option>
                    <option value="coimbatore">Coimbatore</option>
                    <option value="bangalore">Bangalore</option>
                    <option value="erode">Erode</option>
                </datalist>
                <div id="sourceError" class="error-message"></div>
            </div>
            <div class="form-group col-md-4">
                <label for="destination">Destination:</label>
                <input type="text" class="form-control" id="destination" name="destination" placeholder="Enter destination city" list="list-destination">
                <datalist id="list-destination">
                    <option value="chennai">Chennai</option>
                    <option value="salem">Salem</option>
                    <option value="coimbatore">Coimbatore</option>
                    <option value="bangalore">Bangalore</option>
                </datalist>
                <div id="destinationError" class="error-message"></div>
            </div>
            <div class="form-group col-md-4">
                <label for="travelDate">Day of Travel:</label>
                <input type="date" class="form-control" id="travelDate" name="travelDate">
                <div id="travelDateError" class="error-message"></div>
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Search Buses</button>
    </form>
</div>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>
