<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="image/x-icon" href="image/bus.png" width="40px">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet" href="Style.css">
<script src="../script.js"></script>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<title>Travel-About us</title>
<style>
body {
	font-family: Arial, sans-serif;
	margin-left: 4px;
	text-align: justify;
	margin-right: 4px;
}

.sdm {
	position: relative;
	font-size: 5rem;
	text-transform: uppercase;
	letter-spacing: 5px;
	line-height: 50px;
	cursor: pointer;
}

.text {
	color: transparent;
	-webkit-text-stroke: 1px rgb(255, 255, 255, 0.6);
	transition: 0.1s ease;
	transition-delay: 0.25s;
}

.hover-text {
	position: absolute;
	inset: 0;
	width: 0%;
	color: var(--clr);
	overflow: hidden;
	border-right: 6px solid var(--clr);
	transition: 0.5% ease-in-out;
}

img {
	filter: contrast(110%);
}

#ids {
	background-color: rgb(241, 240, 247);
	margin-bottom: 10px;
	position: sticky;
	top: 0px;
	z-index: 1;
}

.navbar-brand span {
	display: inline-block;
}

.cs4 {
	text-decoration: none;
}

.fse {
	font-size: 17px;
	font-weight: 450;
	color: rgba(43, 80, 182, 0.938) !important;
}

#mas {
	font-size: 15px !important;
	margin-left: 0px;
	font-weight: 500 !important;
}

.space {
	margin-left: 100px;
}

a:hover {
	color: rgb(241, 6, 190) !important;
}

.navbar-nav .nav-link.active {
	background: #243346;
	color: white !important;
	height: auto;
}

@media ( max-width : 768px) {
	.space {
		margin-left: 0;
	}
	.navbar-brand span {
		font-size: 14px;
	}
	h5 {
		font-size: 25px !important;
	}
	h6 {
		font-size: 20px !important;
		margin-left: 0;
		margin-right: 0;
	}
	p, ol li {
		font-size: 16px;
	}
}

.footlast {
	background-color: rgb(241, 240, 247);
}

h5 {
	font-weight: bold;
	color: #263f62;
	font-size: 30px !important;
	text-align: left;
	line-height: 30px;
	margin-left: 20px;
}

h6 {
	font-weight: bold;
	color: #263f62;
	font-size: 25px !important;
	text-align: center;
	margin-left: 10px;
	margin-right: 10px;
}

p {
	color: #5d6a79;
	text-indent: 50px;
	line-height: 35px;
	font-size: 17px;
	margin-left: 10px;
	margin-right: 10px;
}

ol li {
	color: #5d6a79;
	line-height: 40px;
	font-size: auto;
}

.marks h6 {
	text-align: left;
}

#navlin {
	font-weight: 600;
	padding-left: 10px;
}

#navlin a {
	text-decoration: none !important;
	font-weight: 700;
}

.bgcolor {
	background-color: rgb(241, 240, 247);
	color: white;
}

.design {
	color: #3d3b39 !important;
	font-weight: 600;
}

#aboutfot {
	text-align: justify;
	font-weight: 400;
	padding-left: 70px;
}

.gets {
	font-weight: 500;
	font-size: 18px;
}

.crs {
	color: rgba(32, 32, 33, 0.938) !important;
	font-weight: 700;
}

.text-dark {
	color: #000; 
	text-decoration: none; 
}

.text-dark:focus, .text-dark:active {
	color: blue; 
	text-decoration: underline; 
}


.text-dark:hover {
	color: blue; 
	text-decoration: underline; 
}
</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light sticky-header" id="ids">
    <div class="container-fluid">
        <img src="${pageContext.request.contextPath}/Images/Joylogo.png" alt="logo" width="60px" height="50px">
        <a class="navbar-brand pt-1 p-3 d-flex align-items-center fs-4" href="#">
            <span class="text-primary fontsw fw-bold pt-2">Joy<span class="text-success ms-2">R</span>ider</span>
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto mb-auto mb-lg-0 fs-5 space">
                <li class="nav-item fcolor"><a class="nav-link fse ms-5" aria-current="page" href="home">Home</a></li>
                <li class="nav-item fcolor"><a class="nav-link active fse ms-5" aria-current="page" href="about">About us</a></li>
                <li class="nav-item fcolor"><a class="nav-link fse ms-5" aria-current="page" href="book">Booking</a></li>
                <li class="nav-item fcolor"><a class="nav-link fse ms-5" aria-current="page" href="contact">Contact us</a></li>
                <%@ page import="com.bus.model.CustomersNew" %>
                	<%
				    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); 
				    response.setHeader("Pragma", "no-cache"); 
				    response.setDateHeader("Expires", 0); 
				%>
                <%
                    CustomersNew customers = (CustomersNew) session.getAttribute("customersNew");
                    if (customers != null) {
                %>
                <li class="nav-item fcolor"><a class="nav-link fse ms-5" href="cancel">Cancel Booking</a></li>
                <li class="nav-item fcolor"><a class="nav-link fse ms-5" href="view">View Booking</a></li>
                <li class="nav-item fcolor"><a class="nav-link fse ms-5" href="logout">Logout</a></li>
                <li class="nav-item fcolor"><span class="nav-link fse ms-5"><%= customers.getFirstName() %> <%= customers.getLastName() %></span></li>
                <% } else { %>
                <li class="nav-item fcolor"><a class="nav-link fse ms-5" aria-current="page" href="login">Login/Register</a></li>
                <% } %>
            </ul>
        </div>
    </div>
</nav>

	<main>

		<img src="${pageContext.request.contextPath}/Images/tourist.jpg" alt="aboutimage" height="300px"
			width="100%">
		<h5>
			<br>About Us
		</h5>
		<h6>
			<br>Joy Rider-Tamil Nadu Best Rated Bus Booking Platform
		</h6>
		<br>
		<p>Joy Rider is the small scale integrated online bus ticketing
			portal today.It brings together private bus transport operators
			across India under a single window,thus facilitating users to plan
			their bus travel across cities with ease. Joy Rider is pioneer in
			providing end-to-end software and other value-added solutions such as
			online ticketing systems,fleet management solution,vehicle tracking
			system.and logictics management backed by a 24x7 customer support
			center.The success of joy rider is reflected in its rapid growth and
			commercial contracts with major travel industry players.</p>
		<p>Joy Rider is a specially designed in web that brings high
			automation and personalized user experience to simplify the ticket
			booking and purchasing process for customers.for booking ticket
			through online.we power many leading online travel agencies around
			the state.Joy Rider is one of the small scale technology provides
			travel wholesaler in statewise.Joy Rider provides innovative things
			to earn more from travel bookings. Bus Operators can partner with us
			by choosing one of the bus we offer. We are developing essential
			technologies that support travel agencies, tour operator and other
			travel agencies operator.our team is committed to providing seamless
			service to all our customers.Embeded our online Bus Ticket Booking
			System into our website and enable customer to book ticket various
			routes of source and destination.</p>
		<div class="marks">
			<h6>Key Highlights</h6>
		</div>
		<ol>
			<li>First company in coimbatore to implement Online Bus Booking
				System for Road Transport Undertakings( for KSRTC).</li>
			<li>And there are 1000+ seats and revenues in excess of Rs
				30000+ since 2024.</li>
			<li>Integrating of Bus for offering complete management across
				Tamil Nadu.</li>
			<li>Book Joy Rider bus ticket online and get instant 100 off on
				bus fare. Apply code "JRJOY" to get lowest price on joyrider.com.</li>
		</ol>
		<div class="marks">
			<h6>Who we are?</h6>
		</div>
		<p>We are veterans in the software industry,we aim to always
			deliver the highest level of service and technology solutions to help
			our online travel agency customers succedd in their business</p>
		<div class="marks">
			<h6>What we believe?</h6>
		</div>
		<p>Joy rider provides competitive advantage through its customer
			focused advanced technology solution that optimize travel agent's
			needs.Travel makes technology accessibe and affotdable to the larges
			number of travel agencies around the globe, by delivering
			innovative,popular travel booling systems that are eay to use.</p>
	</main>
	<br>
	<div class="container-fluid px-0">
		<footer class="text-center text-lg-start text-black"
			style="background-color: rgb(241, 240, 247)">
			<section class="d-flex justify-content-between p-2"
				style="background-color: rgb(241, 240, 247)">
				<div class="ms-5 crs fw-5">
					<span class="gets">Get connected with us on social networks:</span>
				</div>
				<div>
					<a href="#" class="cs4 me-4"> <img
						src="${pageContext.request.contextPath}/Images/facebook.png" alt="facebook" width="25px">
					</a> <a href="#" class="cs4 me-4"> <img
						src="${pageContext.request.contextPath}/Images/youtube.png" alt="youtube" width="25px">
					</a> <a href="#" class="cs4 me-4"> <img
						src="${pageContext.request.contextPath}/Images/google.png" alt="google" width="25px">
					</a> <a href="#" class="cs4 me-4"> <img
						src="${pageContext.request.contextPath}/Images/insta.png" alt="instagram" width="25px">
					</a>
				</div>

			</section>
			<section class="">
				<div class="container text-center text-md-start mt-4">
					<div class="row mt-3">
						<div class="col-md-3 col-lg-3 col-xl-3  mx-auto mb-md-0 mb-3">
							<h6 class="text-uppercase fw-bold text-center mb-4 fs-6">Joy
								Rider</h6>
						
							<p class="design" id="aboutfot">A brief introduction to Joy
								Rider, highlighting our mission to provide reliable and
								convenient bus ticket booking services.</p>
						</div>
						<div class="col-md-3 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-3">
							<h6 class="text-uppercase fw-bold mb-3 fs-6">Info</h6>

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

							<h6 class="text-uppercase fw-bold mb-4 fs-6">Useful links</h6>
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
						<div class="col-md-2 col-lg-2 col-xl-3 mb-md-0 mb-3">
							<h6 class="text-uppercase fw-bold mb-4 fs-6">Contact</h6>
							<!-- <hr class="mb-2 mt-0 d-inline-block mx-5" style="width: 60px; background-color: #7c4dff; height: 2px" /> -->
							<p class="fw-normal" id="mas">
								<i class="fas fa-home mr-2"></i> Coimbatore, TamilNadu
							</p>
							<p class="fw-normal" id="mas">
								<i class="fas fa-envelope mr-2 "></i>&nbsp;&nbsp;riderinfo@gmail.com
							</p>
							<p class="fw-normal" id="mas">
								<i class="fas fa-phone mr-2"></i> + 91 89988 78899
							</p>
							<p class="fw-normal" id="mas">
								<i class="fas fa-print mr-2"></i> + 01 234 567 89
							</p>
						</div>
					</div>
				</div>
			</section>
			<div class="text-center p-2 fw-bold"
				style="background-color: rgb(241, 240, 247)">
				JoyRider&copy; 2024 Copyright: <a class="text-dark"
					href="http://127.0.0.1:5500/customer/index.html#">Joyrider.com</a>
			</div>
		</footer>
	</div>

</body>
</html>