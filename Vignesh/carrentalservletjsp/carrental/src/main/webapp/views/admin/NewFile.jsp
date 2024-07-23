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
                    <!-- <input type="text" class="form-control" placeholder="Search by car name">
                    <button class="btn btn-primary">Search</button> -->
                </div>
            </div>
            <div class="col-3">
                <!-- <button class="btn btn-secondary" type="button" id="dropdownMenuButton">
                    Add Car
                </button> -->
            </div>
            <div class="col-md-3">
                <div class="dropdown">
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-bs-toggle="dropdown" aria-expanded="false">
                        Car Type
                    </button>
                    <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                        <li><a class="dropdown-item filter-option" href="#" data-car-type="SUV">SUV</a></li>
                        <li><a class="dropdown-item filter-option" href="#" data-car-type="Sedan">Sedan</a></li>
                        <li><a class="dropdown-item filter-option" href="#" data-car-type="Luxury">Luxury</a></li>
                    </ul>
                </div>
            </div>
        </div>

        <!-- The modal and table HTML goes here -->
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="../../javascript/adminCarManagement.js"></script>
    <script>
        $(document).ready(function () {
            // Filter button click handler
            $('.filter-option').click(function (e) {
                e.preventDefault();
                var carType = $(this).data('car-type');
                filterCars(carType);
            });

            // Filter function
            function filterCars(carType) {
                $('table.stylish-table tbody tr').each(function () {
                    var type = $(this).find('td:eq(7)').text(); // Assuming the 8th column is the Car Type
                    if (type === carType || carType === 'All') {
                        $(this).show();
                    } else {
                        $(this).hide();
                    }
                });
            }
        });
    </script>
</body>
</html>
