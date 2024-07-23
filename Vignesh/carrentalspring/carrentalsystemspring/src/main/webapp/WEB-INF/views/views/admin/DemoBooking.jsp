<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Booking List</title>
</head>
<body>
    <h1>Booking List</h1>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Start Date</th>
                <th>End Date</th>
                <th>Status</th>
                <th>Car ID</th>
                <th>User ID</th>
                <th>Rental Rate</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
         <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
            <c:forEach var="booking" items="${listBookings}">
                <tr>
                    <td>${booking.bookingId}</td>
                    <td>${booking.startDate}</td>
                    <td>${booking.endDate}</td>
                    <td>${booking.bookingStatus}</td>
                    <td>${booking.carId}</td>
                    <td>${booking.userId}</td>
                    <td>${booking.rentalRate}</td>
                    <td>
                        <a href="bookingServlet?action=edit&id=${booking.bookingId}">Edit</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="index.jsp">Back to Home</a>
</body>
</html>
