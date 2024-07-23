<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Car Rent Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script defer type="text/javascript" src="../../javascript/adminIndex.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="../../css/adminCarManagement.css">
    <style>
     body {
            background-color:#19326669;
            color: white;
            font-family: Arial, sans-serif;
        }
        
        .sidebar {
            background-color: #333;
            height: 100vh;
            padding: 20px;
            position: fixed;
            width: 250px;
        }
        .sidebar img {
            width: 50px;
            height: 50px;
            margin-bottom: 20px;
            border-radius: 10px;
        }
        .sidebar a {
            color: white;
            display: block;
            margin: 10px 0;
            text-decoration: none;
        }
        .sidebar a:hover {
            background-color: #444;
            border-radius: 5px;
            padding: 10px;
        }
        .content {
            margin-left: 270px;
            padding: 20px;
        }
        .header {
            display: flex;
            justify-content: space-between;
            align-items: end;
            margin: 0;
            text-align: right;
        }
        .header .search-box {
            margin: 0;
            width: 450px;
        }
        .header .profile img {
            width: 50px;
            height: 50px;
            border-radius: 50%;
        }
        .card {
            background-color:rgb(214, 214, 214);
            border: none;
            border-radius: 10px;
            padding: 20px;
            margin-bottom: 20px;
        }
        .card h6, .card p {
            margin: 0;
        }
        .progress-bar {
            background-color: #444;
        }
        input[type="text"], input[type="date"], input[type="time"], .btn {
            background-color: #444;
            border: none;
            border-radius: 5px;
            color: white;
            padding: 10px;
            margin: 5px 0;
        }
        .btn {
            background-color: rgb(103, 110, 151);
        }
        .bar1 .card img {
            margin-left: 20px;
            border-radius: 10px;
            width: 95%;
        }
        .chart2 img {
            width: 80%;
            margin-left: 51px;
            text-align: center;
            border-radius: 10px;
        }
        .chart2 {
            text-align: center;
        }
        .sidebar a {
            margin-top: 35px;
        }
        .name {
            padding-left: 910px;
        }
        .nav-pills .nav-link {
            transition: background-color 0.5s ease;
        }
        .nav-pills .nav-link:hover {
            background-color: #edf0f2;
            color: black;
        }
        .full-height {
            height: 100vh;
        }
        .navbar-brand {
            display: flex;
            align-items: center;
        }
        .navbar-brand img {
            margin-right: 10px;
        }
        .features img {
            width: 20px;
            border-radius: 10px;
        }
        .dropdown {
            text-align: right;
        }
        .input-group .form-control {
            background-color: #CADCFC;
        }
        button.btn {
            background-color: #333;
            color: whitesmoke;
        }
        #profileMenu {
            position: absolute;
            right: 0;
            top: 60px;
            width: 200px;
            z-index: 1000;
            text-align: center;
            color: black;
        }
        .btn:hover{
            background-color: rgb(0, 110, 255);
        }
      
      
       table.stylish-table {
            width: 100%;
            border-collapse: collapse;
            margin: 25px 0;
            font-size: 18px;
            text-align: left;
        }
        
        table.stylish-table thead tr {
            background-color: grey;
            color: #ffffff;
            text-align: left;
        }
        
        table.stylish-table th,
        table.stylish-table td {
            padding: 12px 15px;
        }
         body{
         background-image: linear-gradient(to right,#e3e2e2 ,white)
        }
        th{
       background-color:orange;
        }
        td{
        color:black
        }
        h2{
        color:black;
        }
        

        
        
        
        
        
        
.sidebar a.active {
    background-color: #444;
    border-radius: 5px;
    padding: 10px;
}
    </style>
</head>
<body>
    <div class="sidebar">
        <img src="../../images/logo2.png" alt="Logo"> <span style="text-align: center; padding: 10px;">
        <span style="color: orange;">GO</span> TRIP </span> 
        <a id="dashboardLink" href="${pageContext.request.contextPath}/AdminDashboardServlet">Dashboard</a>
        <a href="${pageContext.request.contextPath}/AdminListCarServlet">Cars</a>
        <a href="${pageContext.request.contextPath}/BookingServlet">Bookings</a>
        <a href="${pageContext.request.contextPath}/UserControllerServlet">Customer</a>
       
        
    </div>
    <div class="content">
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
              <li class="breadcrumb-item"><a href="main.html">Dashboard</a></li>
             
              <li class="breadcrumb-item active" aria-current="page">Cars</li>
            </ol>
          </nav>
        <div class="header row">
            <div class="name col mx-0">
                <!-- <h6>Rose</h6> -->   
            </div>
            <div class="profile col">
                <a class="d-block" data-bs-toggle="collapse" href="#profileMenu" role="button" aria-expanded="false" aria-controls="profileMenu">
                    <img class="rounded-pill align-self-center" src="../../images/profile.jpg" height="50" width="60" alt="">
                </a>
                <div class="collapse mt-2" id="profileMenu">
                    <div class="card card-body">
                        <div class="row pt-2 pb-2 menuss">
                            <a href="#" class="dropdown-item">Profile</a>
                        </div>
                        <div class="row pt-2 pb-2 menuss">
                            <a href="#" class="dropdown-item">Settings</a>
                        </div>
                        <div class="row pt-2 pb-2 menuss">
                            <a href="loginadmin.html" class="dropdown-item">Logout</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-md-6">
                <div class="input-group">
                 <!--     <input type="text" class="form-control" placeholder="Search by car name">
                    <button class="btn btn-primary">Search</button>  -->
                </div>
            </div>
            <div class="col-3">
                <!-- <button class="btn btn-secondary" type="button" id="dropdownMenuButton">
                    Add Car
                </button> -->
            </div>
          <!--  --> <div class="col-md-3">
                <div class="dropdown">
                      <button class="btn btn-secondary dropdown-toggle"
                   type="button" id="dropdownMenuButton" data-bs-toggle="dropdown" aria-expanded="false">
                        Car Type
                    </button> 
                 <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
      <li><a class="dropdown-item" href="#" data-car-type="all">All Cars</a></li>
      <li><a class="dropdown-item" href="#" data-car-type="SUV">SUV</a></li>
      <li><a class="dropdown-item" href="#" data-car-type="sedan">Sedan</a></li>
      <li><a class="dropdown-item" href="#" data-car-type="luxury">Luxury</a></li>
    </ul>
                </div>
            </div>
        </div>
       

<div class="modal fade" style="color:black" id="carModal" tabindex="-1" role="dialog" aria-labelledby="carModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <form action="${pageContext.request.contextPath}/AdminInsertCarServlet" method="get">
                <div class="modal-header">
                    <h5 class="modal-title" id="carModalLabel">Add New Car</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <input type="hidden" name="action" id="action">
                    <input type="hidden" name="id" id="carId">
                    <div class="form-group">
                        <label for="carName">Car Name</label>
                        <input type="text" class="form-control" id="carName" name="carName" required>
                    </div>
                    <div class="form-group">
                        <label for="vehicleNo">Vehicle No</label>
                        <input type="text" class="form-control" id="vehicleNo" name="vehicleNo" required>
                    </div>
                    <div class="form-group">
                        <label for="available">Available</label>
                        <input type="text" class="form-control" id="available" name="available" required>
                    </div>
                    <div class="form-group">
                        <label for="rentalRate">Rental Rate</label>
                        <input type="number" class="form-control" id="rentalRate" name="rentalRate" required>
                    </div>
                    <div class="form-group">
                        <label for="seatCount">Seat Count</label>
                        <input type="number" class="form-control" id="seatCount" name="seatCount" required>
                    </div>
                    
                    <div class="form-group">
                     <label for="fuelType">Fuel Type</label>
                       <select class="form-control" id="fuelType" name="fuelType" required>
                         <option value="">Select Fuel Type</option>
                         <option value="petrol">Petrol</option>
                         <option value="diesel">Diesel</option>
                         <option value="electric">Electric</option>
                      </select>
                     <div class="invalid-feedback" id="fuelTypeError"></div>
                     </div>
                    <div class="form-group">
                    <label for="carType">Car Type</label>
                      <select class="form-control" id="carType" name="carType" required>
                       <option value="">Select Car Type</option>
                         <option value="SUV">SUV</option>
                          <option value="sedan">Sedan</option>
                          <option value="luxury">Luxury</option>
                          </select>
                        <div class="invalid-feedback" id="carTypeError"></div>
                      </div>
                    <div class="form-group">
                        <label for="bags">Bags</label>
                        <input type="number" class="form-control" id="bags" name="bags" required>
                    </div>
                    
                      <div class="form-group">
  <label for="carImageUrl">Car Image URL</label>
  <input type="text" class="form-control" id="carImageUrl" name="carImageUrl" required>
  <span id="carImageUrlError" style="color: red;"></span>
</div>
                    
                </div>
                <div class="modal-footer" >
                    <button type="button" class="btn btn-secondary" data-dismiss="modal" style="margin-right:50px;">Close</button>
                    <button type="submit" class="btn btn-primary" id="saveBtn">Save change</button>
                </div>
            </form>
        </div>
    </div>
</div>

    
<!-- Edit Car Modal -->
<!--  -->
<div class="modal fade" id="editCarModal" tabindex="-1" role="dialog" aria-labelledby="editCarModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <form id="editCarForm" action="${pageContext.request.contextPath}/AdminEditCarServlet" method="post">
                <div class="modal-header">
                    <h5 class="modal-title" id="editCarModalLabel">Edit Car</h5>
                    <button type="button" class="close" data-bs-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <input type="hidden" name="id" id="editCarId">
                    <!-- Form fields for editing an existing car -->
                    <div class="form-group">
                        <label for="editCarName">Car Name</label>
                        <input type="text" class="form-control" id="editCarName" name="carName" required>
                    </div>
                    <div class="form-group">
                        <label for="editVehicleNo">Vehicle No</label>
                        <input type="text" class="form-control" id="editVehicleNo" name="vehicleNo" required>
                    </div>
                    <div class="form-group">
                        <label for="editAvailable">Available</label>
                        <input type="text" class="form-control" id="editAvailable" name="available" required>
                    </div>
                    <div class="form-group">
                        <label for="editRentalRate">Rental Rate</label>
                        <input type="number" class="form-control" id="editRentalRate" name="rentalRate" required>
                    </div>
                    <div class="form-group">
                        <label for="editSeatCount">Seat Count</label>
                        <input type="number" class="form-control" id="editSeatCount" name="seatCount" required>
                    </div>
                    <div class="form-group">
                        <label for="editFuelType">Fuel Type</label>
                        <input type="text" class="form-control" id="editFuelType" name="fuelType" required>
                    </div>
                    <div class="form-group">
                        <label for="editCarType">Car Type</label>
                        <input type="text" class="form-control" id="editCarType" name="carType" required>
                    </div>
                    <div class="form-group">
                        <label for="editBags">Bags</label>
                        <input type="number" class="form-control" id="editBags" name="bags" required>
                    </div>
                    <div class="form-group">
                        <label for="editCarImageUrl">Car Image URL</label>
                        <input type="text" class="form-control" id="editCarImageUrl" name="carImageUrl" required>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Save changes</button>
                </div>
            </form>
        </div>
    </div>
</div> -->

  <h2 style="text-align:center">Car Management</h2>
    <button type="button" class="btn btn-primary mb-3" data-toggle="modal"
            data-target="#carModal" data-action="add">Add New Car</button>
    
    <table id="car-list" class="stylish-table" style="border-radius:10px">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Vehicle No</th>
            <th>Available</th>
            <th>Rental Rate</th>
            <th>Seat Count</th>
            <th>Fuel Type</th>
            <th>Car Type</th>
            <th>Bags</th>
            <th>Image URL</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
            
            <c:forEach var="car" items="${listCar}">
  <tr data-car-type="${car.car_type}">
                
                     <td>${car.car_id}</td>
                    <td>${car.car_name}</td>
                    <td>${car.vehicle_no}</td>
                    <td>${car.available}</td>
                    <td>${car.rental_rate}</td>
                    <td>${car.seat_count}</td>
                    <td>${car.fuel_type}</td>
                    <td>${car.car_type}</td>
                    <td>${car.bags}</td>
                    <td>${car.car_image_url}</td>
                    <td>
                <button type="button" class="btn btn-warning btn-sm edit-btn" data-toggle="modal" data-target="#editCarModal"
    data-id="${car.car_id}" data-name="${car.car_name}" data-vehicle="${car.vehicle_no}"
    data-available="${car.available}" data-rate="${car.rental_rate}" data-seat="${car.seat_count}"
    data-fuel="${car.fuel_type}" data-type="${car.car_type}" data-bags="${car.bags}" data-url="${car.car_image_url}">
    Edit
</button>

                        <a href="CarController?action=delete&id=${car.car_id}" class="btn btn-danger btn-sm"
                           onclick="return confirm('Are you sure you want to delete this car?')">Delete</a>
                    </td>
                 
                    
                </tr>
            </c:forEach>
        
        </tbody>
    </table>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script>
<!--  const dropdownItems = document.querySelectorAll('.dropdown-menu .dropdown-item');

  dropdownItems.forEach(item => {
    item.addEventListener('click', function(event) {
      event.preventDefault();
      const carType = this.getAttribute('data-car-type');
      filterCars(carType);
    });
  }); 

  function filterCars(carType) {
	  const rows = document.querySelectorAll('#car-list tbody tr');
	  
	  rows.forEach(row => {
	    const rowCarType = row.getAttribute('data-car-type');
	    if (carType === 'all' || rowCarType === carType) {
	      row.style.display = '';
	    } else {
	      row.style.display = 'none';
	    }
	  });
	} -->
  document.addEventListener('DOMContentLoaded', () => {
	    // Initialize the Edit Car Modal
	    const editCarModal = new bootstrap.Modal(document.getElementById('editCarModal'));

	    // Event listener for Edit buttons
	   
document.querySelectorAll('.edit-btn').forEach(button => {
  button.addEventListener('click', event => {
    const row = event.target.closest('tr');
    const carId = row.cells[0].textContent;
    const carName = row.cells[1].textContent;
    const vehicleNo = row.cells[2].textContent;
    const available = row.cells[3].textContent;
    const rentalRate = row.cells[4].textContent;
    const seatCount = row.cells[5].textContent;
    const fuelType = row.cells[6].textContent;
    const carType = row.cells[7].textContent;
    const bags = row.cells[8].textContent;
    const carImageUrl = row.cells[9].textContent;

    document.getElementById('editCarId').value = carId;
    document.getElementById('editCarName').value = carName;
    document.getElementById('editVehicleNo').value = vehicleNo;
    document.getElementById('editAvailable').value = available;
    document.getElementById('editRentalRate').value = rentalRate;
    document.getElementById('editSeatCount').value = seatCount;
    document.getElementById('editFuelType').value = fuelType;
    document.getElementById('editCarType').value = carType;
    document.getElementById('editBags').value = bags;
    document.getElementById('editCarImageUrl').value = carImageUrl;
  


	            // Set the form action URL for the edit operation
	            //document.getElementById('editCarForm').action = `${pageContext.request.contextPath}/AdminEditCarServlet`;

	            // Show the Edit Car Modal
	            //editCarModal.show();
	        });
	    });
<!--
	    
-->
const dropdownItems = document.querySelectorAll('.dropdown-menu .dropdown-item');
const carTableBody = document.getElementById('car-list').getElementsByTagName('tbody')[0];

dropdownItems.forEach(item => {
  item.addEventListener('click', function(event) {
    event.preventDefault();
    const carType = this.getAttribute('data-car-type');
    filterCars(carType);
  });
});

function filterCars(carType) {
  const rows = carTableBody.rows;
  for (let i = 0; i < rows.length; i++) {
    const row = rows[i];
    const rowCarType = row.getAttribute('data-car-type');
    if (carType === 'all' || rowCarType === carType) {
      row.style.display = '';
    } else {
      row.style.display = 'none';
    }
  }
}


const carImageUrlInput = document.getElementById('carImageUrl');
const carImageUrlError = document.getElementById('carImageUrlError');

carImageUrlInput.addEventListener('input', validateImageUrl);

function validateImageUrl() {
  const url = carImageUrlInput.value;
  if (!isValidUrl(url)) {
    carImageUrlError.innerText = 'Invalid image URL. Only .jpg and .png files are allowed';
  } else {
    carImageUrlError.innerText = '';
  }
}

function isValidUrl(url) {
  const validExtensions = ['.jpg', '.png'];
  const urlLowerCase = url.toLowerCase();
  return validExtensions.some(extension => urlLowerCase.endsWith(extension));
}
const rowCarType = row.cells[7].textContent;
function filterCars(carType) {
	  const rows = carTableBody.rows;
	  for (let i = 0; i < rows.length; i++) {
	    const row = rows[i];
	    const rowCarType = row.getAttribute('data-car-type');
	    if (carType === 'all' || rowCarType === carType) {
	      row.style.display = 'table-row';
	    } else {
	      row.style.display = 'none';
	    }
	  }
	}
 
</script>


    <script src="../../javascript/adminCarManagement.js">
    </script>
</body>
</html>
