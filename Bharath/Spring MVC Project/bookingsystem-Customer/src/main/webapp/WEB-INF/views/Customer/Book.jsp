<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Bus Search Form</title>
<link rel="icon" type="image/x-icon" href="Images/bus.png" width="40px">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" 
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
	<style>
			body {
				font-family: Arial, sans-serif;
				background-color: #f4f4f4;
			}
			
			#ids {
				background-color: rgb(241, 240, 247);
				margin-bottom: 10px;
				position: sticky;
				top: 0px;
				z-index: 1;
			}
			
			.navbar .navbar-brand span {
				font-size: 1.5rem;
			}
			
			.navbar .fcolor .nav-link {
				color: #4b6ab3 !important;
			}
			
			.fse {
				font-size: 17px;
				font-weight: 460;
				color: rgba(43, 80, 182, 0.938) !important;
			}
			
			.space {
				margin-left: 100px;
				/* word-spacing: 20px; */
			}
			
			.nav-link {
				color: inherit;
				text-decoration: none;
			}
			
			.nav-link:hover:not(.active) {
				color: rgb(241, 6, 190) !important;
			}
			
			.nav-link.active {
				color: #007bff;
			}
			
			.search-container {
				border-radius: 20px;
				box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
				padding: 20px;
				margin: 30px auto;
				max-width: 980px;
				height: 150px;
			}
			
			.search-box {
				display: flex;
				align-items: center;
				justify-content: space-between;
			}
			
			.input-group {
				display: flex;
				align-items: center;
				margin-right: 10px;
			}
			
			.input-group .icon {
				margin-right: 5px;
			}
			
			.input-group input {
				border: 1px solid #ddd;
				border-radius: 5px;
				padding: 10px;
				width: 150px;
			}
			
			.swap-icon {
				margin: 0 10px;
			}
			
			.date-picker input {
				border: 1px solid #ddd;
				border-radius: 5px;
				padding: 10px;
			}
			
			.navbar-nav .nav-link.active {
				background-color: rgba(32, 32, 33, 0.938) !important;
				/*#162fa1!important;--> */
				border-radius: 3px;
				color: white !important;
			}
			
			#searchButton {
				background-color: #4a4cde;
				color: white;
				font-weight: bold;
				padding: 10px 20px;
				border: none;
				border-radius: 5px;
				cursor: pointer;
				font-size: 16px;
				transition: background-color 0.3s ease;
			}
			
			#searchButton:hover {
				background-color: #162fa1; /* Darker blue on hover */
			}
			
			.search-button:hover {
				background-color: #37c02b !important;
			}
			
			.srch {
				padding-top: 80px;
				font-size: bold;
				padding-bottom: 60px;
				margin-left: 20px;
				width: 60%;
				margin-top: 5px;
			}
			
			.is-invalid {
				border-color: #dc3545;
			}
			
			.is-invalid+.invalid-feedback {
				display: block;
			}
			
			.example {
				/* background-color: #f0f0f0; */
				border: 1px solid rgb(123, 125, 126);
				padding: 20px;
				margin-top: 10px;
				margin-bottom: 20px;
				font-family: Georgia, 'Times New Roman', Times, serif;
				border-radius: 20px;
				font-size: 20px;
				line-height: 1.5;
				padding-right: 10px !important;
				display: inline-block;
				margin-left: 10px;
				text-align: justify;
			}
			
			.grid-container {
				display: grid;
				grid-template-columns: auto auto;
				background-color: #e0e8ee;
				padding: 1px;
				max-width: 100% !important;
				width: fit-content !important;
			}
			
			.grid-item {
				background-color: rgba(255, 255, 255, 0.8);
				border: 0px solid rgba(0, 0, 0, 0.8);
				padding: 20px;
				font-size: 31px;
				text-align: center;
			}
			
			.ins {
				text-align: left;
			}
			
			.ins h1 {
				padding-top: 30px;
				font-size: 20px;
			}
			
			.ins h2 {
				font-size: 20px;
			}
			
			.ins ol {
				margin-left: 0px;
				line-height: 35px;
			}
			
			.error {
				color: red;
				display: none;
			}
			
			.is-invalid {
				border-color: red;
			}
			
			.cs4 {
				text-decoration: none;
			}
			
			.gets {
				font-weight: 500;
				font-size: 18px;
			}
			
			.crs {
				color: rgba(32, 32, 33, 0.938) !important;
				font-weight: 700;
			}
			
			#aboutfot {
				text-align: justify;
				font-weight: 400;
				padding-left: 70px;
			}
			
			.design {
				color: #3d3b39 !important;
				font-weight: 600;
			}
			/*search*/
			.card {
				border: 1px solid #ccc;
				border-radius: 8px;
				box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
				padding: 20px;
				width: 80%;
				margin-left: 10%;
			}
			
			.form-group {
				margin-bottom: 20px;
			}
			
			#list-source {
				width: 150px !important;
			}
			
			.btn-primary {
				width: 100%;
			}
			
			.error-message {
				color: red;
				font-size: 14px;
				margin-top: 5px;
			}
			/* Flexbox layout for horizontal alignment */
			.form-row {
				display: flex;
				flex-wrap: wrap;
				justify-content: space-between;
			}
			
			.form-row .form-group {
				flex: 1 1 calc(33% - 10px); /* Adjust width as needed */
				margin-right: 10px;
			}
			
			.form-group.ml-auto {
				margin-left: auto;
			}
			
			.label-with-icon {
				display: flex;
				align-items: center;
			}
			
			.label-with-icon img {
				margin-right: 10px; /* Adjust as needed for spacing */
				width: 20px; /* Adjust image width as needed */
				height: 20px; /* Adjust image height as needed */
			}
			
			.text-dark {
				color: #000;
				text-decoration: none;
			}
			
			.text-dark:focus, .text-dark:active {
				color: blue !important;
				text-decoration: underline;
			}
			
			.text-dark:hover {
				color: blue !important;
				text-decoration: underline;
			}
</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light sticky-header"
		id="ids">
		<div class="container-fluid">
			<img src="${pageContext.request.contextPath}/Images/Joylogo.png"
				alt="logo" width="60px" height="50px"> <a
				class="navbar-brand pt-1 p-3 d-flex align-items-center fs-4"
				href="#"> <span class="text-primary fontsw fw-bold pt-2">Joy<span
					class="text-success ms-2">R</span>ider
			</span>
			</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ms-auto mb-auto mb-lg-0 fs-5 space">
					<li class="nav-item fcolor"><a class="nav-link fse ms-5"
						aria-current="page" href="home">Home</a></li>
					<li class="nav-item fcolor"><a class="nav-link fse ms-5"
						aria-current="page" href="about">About us</a></li>
					<li class="nav-item fcolor"><a
						class="nav-link active fse ms-5" aria-current="page" href="book">Booking</a></li>
					<li class="nav-item fcolor"><a class="nav-link fse ms-5"
						aria-current="page" href="contact">Contact us</a></li>
					<%@ page import="com.bus.model.CustomersNew"%>
					<%
				    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); 
				    response.setHeader("Pragma", "no-cache"); 
				    response.setDateHeader("Expires", 0); 
				%>
					<%
                    CustomersNew customers = (CustomersNew) session.getAttribute("customersNew");
                    if (customers != null) {
                %>
					<li class="nav-item fcolor"><a class="nav-link fse ms-5"
						href="cancel">Cancel Booking</a></li>
					<li class="nav-item fcolor"><a class="nav-link fse ms-5"
						href="view">View Booking</a></li>
					<li class="nav-item fcolor"><a class="nav-link fse ms-5"
						href="logout">Logout</a></li>
					<li class="nav-item fcolor"><span class="nav-link fse ms-5"><%= customers.getFirstName() %>
							<%= customers.getLastName() %></span></li>
					<% } else { %>
					<li class="nav-item fcolor"><a class="nav-link fse ms-5"
						aria-current="page" href="login">Login/Register</a></li>
					<% } %>
				</ul>
			</div>
		</div>
	</nav>

	<div class="seas">

		<div class="contains">
			<div class="container mt-4">
				<div class="card">
					<h2 class="card-header text-center">Bus Booking</h2>
					<div class="card-body">
						<form action="busSearch" onsubmit="return validateForm()">
							<div class="form-row">
								<div class="form-group">
									<label for="source" class="label-with-icon"> <img
										src="${pageContext.request.contextPath}/Images/image4.png"
										alt="Source Image"> Source:
									</label> <input type="text" class="form-control" id="source"
										name="source" placeholder="Enter source city"
										list="list-source">
									<div id="sourceError" class="error-message"></div>
									<datalist id="list-source">
										<option selected>chennai</option>
										<option>salem</option>
										<option>coimbatore</option>
										<option>bangalore</option>
										<option>erode</option>
									</datalist>
								</div>
								<div class="form-group">
									<label for="destination" class="label-with-icon"> <img
										src="${pageContext.request.contextPath}/Images/to.jpg"
										alt="Destination Image"> Destination:
									</label> <input type="text" class="form-control" id="destination"
										name="destination" placeholder="Enter destination city"
										list="list-destination">
									<div id="destinationError" class="error-message"></div>
									<datalist id="list-destination">
										<option>chennai</option>
										<option>salem</option>
										<option>coimbatore</option>
										<option>bangalore</option>
									</datalist>
								</div>
								<div class="form-group">
									<label for="dateoftravel" class="label-with-icon"> <img
										src="${pageContext.request.contextPath}/Images/cal.png"
										alt="Source Image"> Day of Travel:
									</label> <input type="date" class="form-control" id="travelDate"
										name="travelDate">
									<div id="travelDateError" class="error-message"></div>
								</div>
								<div class="form-group ml-auto">
									<button type="submit" class="btn btn-primary">Search
										Buses</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>

			<hr>
			<div class="container-fluid ins">
				<h1>Instruction for Booking ticket in online</h1>
				<h2>Search for Buses</h2>
				<ol type="1">
					<li>Finding the search from</li>
					<li><span class="gcolor">Source(From):</span>Enter the city or
						location you are starting your journey from.</li>
					<li><span class="gcolor">Destinations(To):</span>Enter the
						city or location you are traveling to.</li>
					<li><span class="gcolor">Date : </span>Select your travel date
						from the date picker.</li>
					<li>Click on the "SEARCH BUSES" button to proceed.</li>

				</ol>
			</div>

		</div>
		<br> <br>
	</div>
	</div>
	</div>
	<div class="container-fluid px-0">

		<footer class="text-center text-lg-start text-black"
			style="background-color: rgb(241, 240, 247)">

			<section class="d-flex justify-content-between p-2"
				style="background-color: rgb(241, 240, 247)">

				<div class="ms-5 crs fw-5">
					<span class="gets">Get connected with us on social networks:</span>
				</div>

				<div>
					<a href="" class="cs4 me-4"> <img
						src="${pageContext.request.contextPath}/Images/facebook.png"
						alt="" width="25px">
					</a> <a href="" class="cs4 me-4"> <img
						src="${pageContext.request.contextPath}/Images/youtube.png" alt=""
						width="25px">
					</a> <a href="" class="cs4 me-4"> <img
						src="${pageContext.request.contextPath}/Images/google.png" alt=""
						width="25px">
					</a> <a href="" class="cs4 me-4"> <img
						src="${pageContext.request.contextPath}/Images/insta.png" alt=""
						width="25px">
					</a>
				</div>

			</section>
			<section class="">
				<div class="container text-center text-md-start mt-4">
					<div class="row mt-3">
						<div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-3">
							<h6 class="text-uppercase fw-bold text-center mb-4">Joy
								Rider</h6>
							<!-- <hr class="mb-2 mt-0 d-inline-block mx-auto" style="width: 60px; background-color:#7c4dff; height: 2px" /> -->
							<p class="design" id="aboutfot">A brief introduction to Joy
								Rider, highlighting our mission to provide reliable and
								convenient bus ticket booking services.</p>
						</div>
						<div class="col-md-2 col-lg-2 col-xl-2 mx-5 mb-3">
							<h6 class="text-uppercase fw-bold mb-3">Info</h6>

							<p>
								<a href="#!" class="design text-decoration-none fw-normal">FAQ</a>
							</p>
							<p>
								<a href="#!" class="design text-decoration-none fw-normal">Blog</a>
							</p>
							<p>
								<a href="#!" class="design text-decoration-none fw-normal">Bus
									Operator registration</a>
							</p>
							<p>
								<a href="#!" class="design text-decoration-none fw-normal">Customer
									registration</a>
							</p>
						</div>

						<div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-3 ">

							<h6 class="text-uppercase fw-bold mb-4">Useful links</h6>
							<!-- <hr class="mb-2 mt-0 d-inline-block mx-5 " style="width: 60px; background-color: #7c4dff; height: 2px" /> -->
							<p>
								<a href="#!" class="design text-decoration-none fw-normal">Your
									Account</a>
							</p>
							<p>
								<a href="#!" class="design text-decoration-none fw-normal">Home</a>
							</p>
							<p>
								<a href="#!" class="design text-decoration-none fw-normal">About
									us</a>
							</p>
							<p>
								<a href="#!" class="design text-decoration-none fw-normal">Help</a>
							</p>
						</div>

						<div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-3">
							<h6 class="text-uppercase fw-bold mb-4">Contact</h6>
							<!-- <hr class="mb-2 mt-0 d-inline-block mx-5" style="width: 60px; background-color: #7c4dff; height: 2px" /> -->
							<p class="fw-normal">
								<i class="fas fa-home mr-2"></i> Coimbatore, TamilNadu
							</p>
							<p class="fw-normal">
								<i class="fas fa-envelope mr-2 "></i>&nbsp;&nbsp;riderinfo@gmail.com
							</p>
							<p class="fw-normal">
								<i class="fas fa-phone mr-2"></i> + 91 89988 78899
							</p>
							<p>
								<i class="fas fa-print mr-2"></i> + 01 234 567 89
							</p>
						</div>
					</div>
				</div>
			</section>
			<div class="text-center p-2 fw-bold"
				style="background-color: rgb(241, 240, 247)">
				© 2024 Copyright: <a class="text-dark"
					href="http://127.0.0.1:5500/customer/index.html#">Joyrider.com</a>
			</div>
		</footer>


	</div>
	</div>
	<script>
function validateForm() {
    var source = document.getElementById("source").value;
    var destination = document.getElementById("destination").value;
    var sourceError = document.getElementById("sourceError");
    var destinationError = document.getElementById("destinationError");
    var travelDate = document.getElementById("travelDate").value;
    var travelDateError = document.getElementById("travelDateError");
    var isValid = true;

    // Reset error messages
    sourceError.innerHTML = "";
    destinationError.innerHTML = "";
    travelDateError.innerHTML = "";
    if (source === "") {
        sourceError.innerHTML = "Source is required.";
        isValid = false;
    }

    if (destination === "") {
        destinationError.innerHTML = "Destination is required.";
        isValid = false;
    }

    if (travelDate === "") {
        travelDateError.innerHTML = "Travel Date is required.";
        isValid = false;
    }
    if (!/^[a-zA-Z]+$/.test(source)) {
        sourceError.innerHTML = "Source must contain only letters.";
        isValid = false;
    }

    if (!/^[a-zA-Z]+$/.test(destination)) {
        destinationError.innerHTML = "Destination must contain only letters.";
        isValid = false;
    }

    // Date validation
    var currentDate = new Date();
    var selectedDate = new Date(travelDate);

    if (selectedDate < currentDate) {
        travelDateError.innerHTML = "Travel Date must be today or a future date.";
        isValid = false;
    }

    return isValid;
}
</script>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>