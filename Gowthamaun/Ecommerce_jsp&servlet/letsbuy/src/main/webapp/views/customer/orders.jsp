<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.letsbuy.beans.*,java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My Orders</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/customerstyles.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
     <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
</head>
<style>

body {
    background-color: #f8f9fa;
}

.card-header {
    font-weight: bold;
}

.card-body {
    padding: 1rem;
}

#ordersList .card {
    margin-bottom: 1rem;
}

.card-orders-img{
	padding:15px !important;
	max-height:150px !important;
	
}

.ordersa:hover .card-title{
	color:rgb(27, 99, 174) !important;
}

.order-status-text{
	color:rgb(244,119,32) !important;
	font-size:16px !important;
}



/* #main-navv {
    margin-bottom: 5rem; /* Adjust if necessary to prevent content overlap 
} */

</style>
<body>
    <!-- Navbar -->
    <div class="navbar navbar-expand-lg navbar-light bg-white shadow-sm fixed-top" id="main-navv">
        <div class="container-fluid">
            <a class="navbar-brand d-none d-md-block" href="#option-menu">
                <img src="${pageContext.request.contextPath}/images/logo.png" class="rounded" width="210" height="110" alt="">
            </a>
            <a class="navbar-brand d-md-none" href="#option-menu">
                <img src="${pageContext.request.contextPath}/images/logo.png" class="rounded" width="100" height="50" alt="">
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarContent" aria-controls="navbarContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarContent">
                <div class="d-flex ms-auto me-auto mt-2 mt-lg-0 search-bar-container">
                    <form class="w-100" role="search">
                        <div class="input-group">
                            <input type="search" placeholder="Search your product" class="form-control"/>
                            <button class="btn btn-serch" type="submit">
                                <i class="fa fa-search"></i>
                            </button>
                        </div>
                    </form>
                </div>
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item txt-nav invisible" id="login-pg">
                        <a class="nav-link" href="${pageContext.request.contextPath}/views/customer/login.jsp">
                            <i class="fa fa-user"></i> Login
                        </a>
                    </li>
                    
                    <li class="nav-item invisible" id="seller-pg">
                        <a class="nav-link" href="#">
                            <img src="images/Shop-1--Streamline-Ultimate.svg"  height="20" width="25" alt=""> Seller
                        </a>
                    </li>
                    
                    <li class="nav-item txt-nav">
                        <a class="nav-link" href="${pageContext.request.contextPath}/views/customer/cart.jsp">
                            <i class="fa fa-shopping-cart"></i> Cart
                        </a>
                    </li>
                    
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            <i class="fa fa-user"></i> ${sessionScope.user.getFirstName()}
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="#"><i class="fa fa-user"></i> Profile</a></li>
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/views/customer/orderpage.jsp"><i class="fa fa-list"></i> My Orders</a></li>
                            <li><a class="dropdown-item" href="#"><i class="fa fa-sign-out"></i> Logout</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </div>

    <!-- Main Content -->
    <div class="container-fluid" style="margin-top: 150px !important;">
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
                <li class="breadcrumb-item"><a href="#">My Account</a></li>
                <li class="breadcrumb-item active" aria-current="page">My Orders</li>
            </ol>
        </nav>
        <div class="row">
            <div class="col-md-3">
                <div class="card">
                    <div class="card-header">
                        Filters
                    </div>
                    <div class="card-body">
                        <form id="filterForm">
                            <div class="form-group">
                                <label for="orderStatus">ORDER STATUS</label>
                                <div id="orderStatus">
                                    <div class="form-check">
                                        <input type="checkbox" class="form-check-input" id="onTheWay">
                                        <label class="form-check-label" for="onTheWay">On the way</label>
                                    </div>
                                    <div class="form-check">
                                        <input type="checkbox" class="form-check-input" id="delivered">
                                        <label class="form-check-label" for="delivered">Delivered</label>
                                    </div>
                                    <div class="form-check">
                                        <input type="checkbox" class="form-check-input" id="cancelled">
                                        <label class="form-check-label" for="cancelled">Cancelled</label>
                                    </div>
                                    <!-- <div class="form-check">
                                        <input type="checkbox" class="form-check-input" id="returned">
                                        <label class="form-check-label" for="returned">Returned</label>
                                    </div> -->
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="orderTime">ORDER TIME</label>
                                <div id="orderTime">
                                    <div class="form-check">
                                        <input type="checkbox" class="form-check-input" id="last30days">
                                        <label class="form-check-label" for="last30days">Last 30 days</label>
                                    </div>
                                    <div class="form-check">
                                        <input type="checkbox" class="form-check-input" id="year2023">
                                        <label class="form-check-label" for="year2023">2023</label>
                                    </div>
                                    <div class="form-check">
                                        <input type="checkbox" class="form-check-input" id="year2022">
                                        <label class="form-check-label" for="year2022">2022</label>
                                    </div>
                                    <div class="form-check">
                                        <input type="checkbox" class="form-check-input" id="year2021">
                                        <label class="form-check-label" for="year2021">2021</label>
                                    </div>
                                    <div class="form-check">
                                        <input type="checkbox" class="form-check-input" id="year2020">
                                        <label class="form-check-label" for="year2020">2020</label>
                                    </div>
                                    <div class="form-check">
                                        <input type="checkbox" class="form-check-input" id="older">
                                        <label class="form-check-label" for="older">Older</label>
                                    </div>
                                </div>
                            </div>
                            <button type="submit" class="btn btn-primary btn-block">Apply Filters</button>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-md-9">
                <div class="d-flex justify-content-between mb-3">
                    <h4>My Orders</h4>
                    <form class="form-inline">
                        <input class="form-control mr-sm-2" type="search" placeholder="Search your orders here" aria-label="Search">
                        <button class="btn btn-outline-primary my-2 my-sm-0" type="submit">Search Orders</button>
                    </form>
                </div>
                <div id="ordersList">
                    <!-- Order Item 1 -->
                    <% 	Orders orders = (Orders) request.getAttribute("orders"); 
                    	List<Order> myOrders = orders.getOrders();
                        for(Order order:myOrders) {                			
                    %>
                    <a href="${pageContext.request.contextPath}/views/customer/mobilepage.jsp" class="ordersa">
                    	<div class="card">
                        <div class="row no-gutters">
                            <div class="col-md-1">
                                <img src="${pageContext.request.contextPath}/images/Mobiles/LargeMiImage/large-mi1.webp" class="card-orders-img" alt="...">
                            </div>
                            <div class="col-md-10">
                                <div class="card-body text-dark">
                                    <h5 class="card-title"><%= order.getProduct().getSubtitle() %></h5>
                                    <p class="card-text"><%= order.getProduct().getDescription().substring(0, order.getProduct().getDescription().indexOf(",")) %> </p>
                                    <p class="card-text"><strong>&#8377;<%= order.getAmount() %></strong></p>
                                    <p class="card-text">Quantity : <%= order.getProduct().getQuantity() %></p>
                                    <p class="card-text"><small class="text-muted order-status-text"><%=order.getOrderStatus() %> on <%= order.getOrderDate() %></small></p>
                                </div>
                            </div>
                        </div>
                    </div>
                    </a>
                    <% } %>
                    <!-- Order Item 2 -->
                    
                </div>
            </div>
        </div>
    </div>
    
    <footer class="footer mt-5 shadow bg-white">
        <div class="container">
          <div class="row">
            <div class="col-md-3 col-6">
              <h5>Company</h5>
              <ul class="list-unstyled">
                <li><a href="#">About Us</a></li>
                <li><a href="#">Careers</a></li>
                <li><a href="#">Press</a></li>
                <li><a href="#">Blog</a></li>
              </ul>
            </div>
            <div class="col-md-3 col-6">
              <h5>Support</h5>
              <ul class="list-unstyled">
                <li><a href="#">Help Center</a></li>
                <li><a href="#">Safety Information</a></li>
                <li><a href="#">Cancellation Options</a></li>
                <li><a href="#">Contact Us</a></li>
              </ul>
            </div>
            <div class="col-md-3 col-6">
              <h5>Services</h5>
              <ul class="list-unstyled">
                <li><a href="#">Account</a></li>
                <li><a href="#">Order Tracking</a></li>
                <li><a href="#">Wishlist</a></li>
                <li><a href="#">Customer Service</a></li>
              </ul>
            </div>
            <div class="col-md-3 col-6">
              <h5>Follow Us</h5>
              <div class="social-icons">
                <a href="#"><i class="bi bi-facebook"></i></a>
                <a href="#"><i class="bi bi-twitter"></i></a>
                <a href="#"><i class="bi bi-instagram"></i></a>
                <a href="#"><i class="bi bi-linkedin"></i></a>
              </div>
            </div>
          </div>
          <div class="row mt-4">
            <div class="col text-center">
              <p>&copy; 2024 MyEcommerce. All rights reserved.</p>
            </div>
          </div>
        </div>
      </footer>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
