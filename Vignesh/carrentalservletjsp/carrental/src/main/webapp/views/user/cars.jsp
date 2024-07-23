<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Car Rental System</title>
    <style>
        /* Basic styling for clarity */
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 20px;
        }
        .car-container {
            display: flex;
            justify-content: space-around;
            flex-wrap: wrap;
            margin-top: 20px;
        }
        .car {
            background-color: #fff;
            border: 1px solid #ccc;
            border-radius: 5px;
            width: 300px;
            padding: 10px;
            margin: 10px;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
        }
        .car img {
            max-width: 100%;
            height: auto;
            border-radius: 5px;
        }
        .car-info {
            padding: 10px;
        }
        .car-info h3 {
            margin-top: 0;
        }
        .car-info p {
            margin: 5px 0;
        }
    </style>
</head>
<body>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <h2>Available Cars</h2>

    <!-- Display Sedan Cars -->
    <h3>Sedan Cars</h3>
    <div class="car-container">
        <c:forEach var="car" items="${sedanCars}">
            <div class="car">
                <img src="<c:out value='${car.car_image_url}' />" alt="Car Image">
                <div class="car-info">
                    <h3><c:out value="${car.car_name}" /></h3>
                    
                    <p><strong>Vehicle No:</strong><p> <c:out value="${car.vehicle_no}" /></p></p>
                    <p><strong>Rental Rate:</strong> <c:out value="${car.rental_rate}" /></p>
                    <p><strong>Available:</strong> <c:out value="${car.available}" /></p>
                    <p><strong>Seats:</strong> <c:out value="${car.seat_count}" /></p>
                    <p><strong>Fuel Type:</strong> <c:out value="${car.fuel_type}" /></p>
                    <p><strong>Bags:</strong> <c:out value="${car.bags}" /></p>
                </div>
            </div>
        </c:forEach>
    </div>

    <!-- Display SUV Cars -->
    <h3>SUV Cars</h3>
    <div class="car-container">
        <c:forEach var="car" items="${suvCars}">
            <div class="car">
                <img src="<c:out value='${car.car_image_url}' />" alt="Car Image">
                <div class="car-info">
                    <h3><c:out value="${car.car_name}" /></h3>
                    <p><strong>Vehicle No:</strong> <c:out value="${car.vehicle_no}" /></p>
                    <p><strong>Rental Rate:</strong> <c:out value="${car.rental_rate}" /></p>
                    <p><strong>Available:</strong> <c:out value="${car.available}" /></p>
                    <p><strong>Seats:</strong> <c:out value="${car.seat_count}" /></p>
                    <p><strong>Fuel Type:</strong> <c:out value="${car.fuel_type}" /></p>
                    <p><strong>Bags:</strong> <c:out value="${car.bags}" /></p>
                </div>
            </div>
        </c:forEach>
    </div>

    <!-- Display Luxury Cars -->
    <h3>Luxury Cars</h3>
    <div class="car-container">
        <c:forEach var="car" items="${luxuryCars}">
            <div class="car">
                <img src="<c:out value='${car.car_image_url}' />" alt="Car Image">
                <div class="car-info">
                    <h3><c:out value="${car.car_name}" /></h3>
                    <p><strong>Vehicle No:</strong> <c:out value="${car.vehicle_no}" /></p>
                    <p><strong>Rental Rate:</strong> <c:out value="${car.rental_rate}" /></p>
                    <p><strong>Available:</strong> <c:out value="${car.available}" /></p>
                    <p><strong>Seats:</strong> <c:out value="${car.seat_count}" /></p>
                    <p><strong>Fuel Type:</strong> <c:out value="${car.fuel_type}" /></p>
                    <p><strong>Bags:</strong> <c:out value="${car.bags}" /></p>
                </div>
            </div>
        </c:forEach>
    </div>

</body>
</html>
