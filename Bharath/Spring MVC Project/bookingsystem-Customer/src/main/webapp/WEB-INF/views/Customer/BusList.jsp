<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Bus Search Results</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>Bus Search Results</h2>
   <table border="1">
        <thead>
            <tr>
            
                <th>Bus Name</th>
                <th>Bus Type</th>
                <th>Capacity</th>
                <th>Fare</th>
                <th>Date of Bus</th>
                <th>Departure Time</th>
                <th>Arrival Time</th>
                <th>Source</th>
                <th>Destination</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${buses}" var="bus">
                <tr>
                    <td>${bus.busName}</td>
                    <td>${bus.busType}</td>
                    <td>${bus.busCapacity}</td>
                    <td>${bus.busFare}</td>
                    <td>${bus.dateOfBus}</td>
                    <td>${bus.departureTime}</td>
                    <td>${bus.arrivalTime}</td>
                    <td>${bus.route.source}</td>
                    <td>${bus.route.destination}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>
