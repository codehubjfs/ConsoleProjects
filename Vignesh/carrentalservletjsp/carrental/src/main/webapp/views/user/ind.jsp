<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Available Cars</title>
</head>
<body>
    <h1>Available Cars</h1>
    
    <h2>Sedan Cars</h2>
    <table border="1">
        <thead>
            <tr>
                <th>Image</th>
                <th>Name</th>
                <th>Rental Rate</th>
                <th>Seat Count</th>
                <th>Fuel Type</th>
                <th>Bags</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="car" items="${sedanCars}">
                <tr>
                    <td><img src="${car.carImageUrl}" alt="${car.carName}" style="width: 100px; height: auto;"></td>
                    <td>${car.carName}</td>
                    <td>${car.rentalRate}</td>
                    <td>${car.seatCount}</td>
                    <td>${car.fuelType}</td>
                    <td>${car.bags}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <h2>SUV Cars</h2>
    <table border="1">
        <thead>
            <tr>
                <th>Image</th>
                <th>Name</th>
                <th>Rental Rate</th>
                <th>Seat Count</th>
                <th>Fuel Type</th>
                <th>Bags</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="car" items="${suvCars}">
                <tr>
                    <td><img src="${car.carImageUrl}" alt="${car.carName}" style="width: 100px; height: auto;"></td>
                    <td>${car.carName}</td>
                    <td>${car.rentalRate}</td>
                    <td>${car.seatCount}</td>
                    <td>${car.fuelType}</td>
                    <td>${car.bags}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <h2>Luxury Cars</h2>
    <table border="1">
        <thead>
            <tr>
                <th>Image</th>
                <th>Name</th>
                <th>Rental Rate</th>
                <th>Seat Count</th>
                <th>Fuel Type</th>
                <th>Bags</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="car" items="${luxuryCars}">
                <tr>
                    <td><img src="${car.carImageUrl}" alt="${car.carName}" style="width: 100px; height: auto;"></td>
                    <td>${car.carName}</td>
                    <td>${car.rentalRate}</td>
                    <td>${car.seatCount}</td>
                    <td>${car.fuelType}</td>
                    <td>${car.bags}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
</body>
</html>
