<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Car Rent Dashboard</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script defer type="text/javascript" src="${ pageContext.request.contextPath}/javascript/adminIndex.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <!-- Include Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${ pageContext.request.contextPath}/css/adminIndex.css">
    <style>
        body {
            background-image: linear-gradient(to right,#e3e2e2 ,white);
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
        }
        .sidebar a {
            color: white;
            display: block;
            margin: 10px 0;
            text-decoration: none;
        }
        .sidebar a:hover {
            background-color: #e3af21;
            color: black;
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
            background-color: #bcb5b5;
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
            width: calc(100% - 20px);
            margin: 5px 0;
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
        .btn {
            background-color: rgb(103, 110, 151);
        }
        .btn:hover {
            background-color: #0056b3;
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
        .card {
            background-image: linear-gradient(to right, rgb(251, 187, 10) , rgb(252, 218, 125));
        }
        .name {
            padding-left: 910px;
        }
        .sidebar img {
            border-radius: 10px;
        }
        .error-message {
            color: red;
            font-size: 12px;
        }
        

        
.sidebar a.active {
    background-color: #444;
    border-radius: 5px;
    padding: 10px;
}



@media (max-width: 1000px) {
            .sidebar {
                width: 100%;
                height: auto;
                position: relative;
            }
            .content {
                margin-left: 0;
            }
            .header {
                flex-direction: column;
            }
            .name {
                padding-left: 0;
            }
        }
        
    </style>
</head>
<body>
    <div class="sidebar">
        <img src="${ pageContext.request.contextPath}/assert/images/logo2.png" alt="Logo"> 
        <span style="text-align: center; padding: 10px;">
            <span style="color: orange;">GO</span> TRIP
        </span> 
        <a id="dashboardLink" href="${pageContext.request.contextPath}/admin-dashboard">Dashboard</a>
        <a href="${pageContext.request.contextPath}/admincars">Cars</a>
        <a href="${pageContext.request.contextPath}/bookingmanagement">Bookings</a>
        <a href="${pageContext.request.contextPath}/customermanagement">Customer</a>
        
    </div>
    <div class="content">
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
              <li class="breadcrumb-item"><a href="main.html">Dashboard</a></li>
            </ol>
          </nav>
        <div class="header row">
            <div col-4></div>
            <div class="name col mx-0">
                <h6 style="color: black;"></h6>
            </div>
            <div class="profile col mx-0">
                <a class="d-block" data-bs-toggle="collapse" href="#profileMenu" role="button" aria-expanded="false" aria-controls="profileMenu">
                    <img class="rounded-pill align-self-center" src="${ pageContext.request.contextPath}/assert/images/profile.jpg" height="50" width="60" alt="">
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
                            <a href="${pageContext.request.contextPath}/LogoutServlet" class="dropdown-item">Logout</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
            <h2 style="color: black;">Today Statistics</h2>
        </div>
        <div class="row mt-4 row1">
            <div class="col-md-3 col-sm-6">
                <div class="card">
                    <h5>Income Today</h5>
                    <p>$9460</p>
                </div>
            </div>
            <div class="col-md-3 col-sm-6">
                <div class="card">
                    <h5>Total Users</h5>
                    <p>${totalUsers}</p>
                </div>
            </div>
            <div class="col-md-3 col-sm-6">
                <div class="card">
                    <h5>Total Car</h5>
                    <p>${totalCars} </p>
                </div>
            </div>
            <div class="col-md-3 col-sm-6">
                <div class="card">
                    <h5>Total Rented</h5>
                    <p>${totalRented}</p>
                </div>
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-md-4">
                <div class="card">
                   <h5 class="card-title">Car Availability</h5>
                        <form id="availabilityForm" action="${pageContext.request.contextPath}/checkCarAvailability" method="post">
                            <div class="form-group">
                                <input type="text" id="carNumber" name="vehicleNo" class="form-control" placeholder="Car Number" required>
                            </div>
                            <div class="form-group">
                                <input type="date" id="date" name="date" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <input type="time" id="time" name="time" class="form-control" required>
                            </div>
                            <button type="submit" class="btn btn-primary" id="checkBtn">Check</button>
                        </form>
                </div>
            </div>
           
            <div class="col-md-8 bar1">
                <div class="card">
                    <h5>Earning Summary</h5>
                    <img src="${pageContext.request.contextPath}/assert/images/Gemini_Chart_Image_td4owxtd4owxtd4o.png" alt="Earning Summary" class="img-fluid" style="height:237px !important">
                </div>
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-md-6">
                <div class="card">
                    <h5>Booked vs Cancelled</h5>
                    <div class="progress mt-5">
                        <div class="progress-bar bg-blue" role="progressbar" style="width: 54%" aria-valuenow="54" aria-valuemin="0" aria-valuemax="100"></div>
                    </div>
                    <p>Total Booked</p>
                    <div class="progress mt-5">
                        <div class="progress-bar bg-blue" role="progressbar" style="width: 20%" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"></div>
                    </div>
                    <p>Total Cancelled</p>
                    <div class="progress mt-5">
                        <div class="progress-bar bg-blue" role="progressbar" style="width: 26%" aria-valuenow="26" aria-valuemin="0" aria-valuemax="100"></div>
                    </div>
                    <p>Total Pending</p>
                </div>
            </div>
            <div class="col-md-6 chart2" >
                <div class="card">
                    <h5>Income Analysis</h5>
                    <img src="${pageContext.request.contextPath}/assert/images/Gemini_Chart_Image_v7bpunv7bpunv7bp (1).png" alt="Income Analysis" class="img-fluid" style="height:260px !important;">
                </div>
            </div>
        </div>
    </div>
     <div class="modal fade" id="availabilityModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel" style="color:black">Car Availability</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body" style="color:black">
                <% 
                    Boolean isAvailable = (Boolean) request.getAttribute("isAvailable");
                    if (isAvailable != null) {
                        if (isAvailable) {
                            out.println("The car is available.");
                        } else {
                            out.println("The car is not available.");
                        }
                    }
                %>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
</div>
    <script src="${ pageContext.request.contextPath}/javascript/adminIndex.js">
        
    </script>
    <script type="text/javascript">
   
    // Get the current page URL
    const currentPage = window.location.href;
    if (currentPage.includes('index.jsp')) {
        document.getElementById('dashboardLink').classList.add('active');
    } else if (currentPage.includes('index.jsp')) {
        document.getElementById('carsLink').classList.add('active');
    }
    // Add similar conditions for other pages

         <% if (request.getAttribute("isAvailable") != null) { %>
            $(document).ready(function() {
                $('#availabilityModal').modal('show');
            });
        <% } %>
          

            document.getElementById('carNumber').addEventListener('input', function() {
                const carNumberInput = this.value;
                const carNumberError = document.getElementById('carNumberError');
                if (!/^\d{0,4}$/.test(carNumberInput)){
                    carNumberError.textContent = 'Car number must be a 4-digit number';
                    this.value = carNumberInput.slice(0, 4).replace(/\D/g, '');
                } else {
                    carNumberError.textContent = '';
                }
            });

            document.getElementById('date').addEventListener('input', function() {
                const selectedDate = new Date(this.value);
                const currentDate = new Date();
                const dateError = document.getElementById('dateError');
                if (selectedDate < currentDate.setHours(0, 0, 0, 0)) {
                    dateError.textContent = 'Date must be today or in the future';
                    this.value = '';
                } else {
                    dateError.textContent = '';
                }
            });

            document.getElementById('time').addEventListener('input', function() {
                const selectedTime = new Date(document.getElementById('date').value + 'T' + this.value);
                const currentTime = new Date();
                const timeError = document.getElementById('timeError');
                if (selectedTime < currentTime) {
                    timeError.textContent = 'Time must be now or in the future';
                    this.value = '';
                } else {
                    timeError.textContent = '';
                }
            });

            document.getElementById('checkBtn').addEventListener('click', function() {
                const carNumber = document.getElementById('carNumber').value;
                const date = document.getElementById('date').value;
                const time = document.getElementById('time').value;

                if (carNumber.length !== 4 || !/^\d{4}$/.test(carNumber)) {
                    document.getElementById('carNumberError').textContent = 'Car number must be a 4-digit number';
                    return;
                } else {
                    document.getElementById('carNumberError').textContent = '';
                }

                if (!date) {
                    document.getElementById('dateError').textContent = 'Please select a valid date';
                    return;
                } else {
                    document.getElementById('dateError').textContent = '';
                }

                if (!time) {
                    document.getElementById('timeError').textContent = 'Please select a valid time';
                    return;
                } else {
                    document.getElementById('timeError').textContent = '';
                }

                alert('Car availability checked successfully');
            });
    </script>
</body>
</html>
