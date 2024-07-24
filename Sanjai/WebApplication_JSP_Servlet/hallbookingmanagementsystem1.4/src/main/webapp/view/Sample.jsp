<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.LinkedHashSet" %>
<%@ page import="com.hallbookingmanagement.dao.HallDAO" %>
<%@ page import="com.hallbookingmanagement.beans.Event" %>
<%@ page import="com.hallbookingmanagement.beans.Seats" %>
<%@ page import="com.hallbookingmanagement.beans.Amenity" %>
<%@ page import="com.hallbookingmanagement.beans.Hall" %>

<!DOCTYPE html>
<html>
<head>
    <title>Halls List</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
        }
        th {
            background-color: #f2f2f2;
            text-align: left;
        }
    </style>
</head>
<body>
    <h2>Halls List</h2>
    <%
        HallDAO hallDAO = new HallDAO();
        List<Hall> halls = hallDAO.getAll();
    %>
    <table>
        <thead>
            <tr>
                <th>Hall ID</th>
                <th>Hall Name</th>
                <th>Price</th>
                <th>AC</th>
                <th>Capacity</th>
                <th>Location</th>
                <th>Events</th>
                <th>Seating Arrangements</th>
                <th>Amenities</th>
            </tr>
        </thead>
        <tbody>
            <%
                for (Hall hall : halls) {
            %>
            <tr>
                <td><%= hall.getHallId() %></td>
                <td><%= hall.getHallName() %></td>
                <td><%= hall.getPrice() %></td>
                <td><%= hall.isAcHall() ? "Yes" : "No" %></td>
                <td><%= hall.getCapacity() %></td>
                <td><%= hall.getLocation() %></td>
                <td>
                    <ul>
                        <%
                            for (Event event : hall.getEvents()) {
                        %>
                        <li><%= event.getEventName() %></li>
                        <%
                            }
                        %>
                    </ul>
                </td>
                <td>
                    <ul>
                        <%
                            for (Seats seat : hall.getSeat()) {
                        %>
                        <li><%= seat.getArrangementType() %> (Capacity: <%= seat.getCapacity() %>)</li>
                        <%
                            }
                        %>
                    </ul>
                </td>
                <td>
                    <ul>
                        <%
                            for (Amenity amenity : hall.getAmenities()) {
                        %>
                        <li><%= amenity.getAmenityType() %></li>
                        <%
                            }
                        %>
                    </ul>
                </td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
</body>
</html>
