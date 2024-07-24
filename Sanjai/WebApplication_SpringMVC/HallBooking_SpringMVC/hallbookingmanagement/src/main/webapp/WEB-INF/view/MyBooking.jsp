<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored = "false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My Booking</title>
     <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" type="image/x-icon" href="<%= request.getContextPath() %>/assert/image/LogoFavIcon.jpg">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/assert/css/CustomerHeaderFooter.css"/>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-multiselect/0.9.15/css/bootstrap-multiselect.css"
    rel="stylesheet">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <style>
        .container {
            margin-top: 100px !important;
        }
        .card {
            margin-top: 20px !important;
        
            margin: 20px 0;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        .card .innerCard {
            display: flex;
            padding: 20px;
        }
        .card .image-container {
            flex: 1;
        }
        .card .image-container img {
            height: 154px !important;
            width: 350px !important;
            object-fit: cover;
            border-radius: 3px;
        }
        .card .hall-content, .card .booking-content {
            flex: 1;
            padding: 0 20px;
        }
        .card .hall-content div, .card .booking-content div {
            margin: 10px 0;
        }
        .card .button button {
            background-color: #007bff;
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
        }
        .card .button button:hover {
            background-color: #0056b3;
        }
        .hall_name{
            color: #4E4332;
            font-weight: 500;
            font-size: 30px;
        }
        .hall_location{
            color: #4E4332;
            font-weight: 500;
            font-size: 20px;
        }
        .price{
            font-weight: 500;
            font-size: 20px;
        }
        .hall-content , .booking-content, .hall-content p{
            align-items: center;
        }
        
        .bookeduration{
            font-weight: 500;
            font-size: 20px;
        }
        .book-c{
            flex-shrink: 1;
            font-weight: 500;
            font-size: 20px;
        }
        footer {
      position: fixed;
      bottom: 0;
      width: 100%;
      height: 2.5rem;
    }
    </style>
	 <% 
    if (request.getSession().getAttribute("customer") == null) {
        response.sendRedirect("viewLogin");
    }
	%>
</head>
<body>
   <header>
        <nav class="navbar navbar-expand-lg navbar-light bg-light" id="customNavbar">
            <a class="navbar-brand" href="<%= request.getContextPath() %>/index.jsp"><img src="${pageContext.request.contextPath}/assert/image/Logo.1.1.png" id="company-logo" alt="Company Logo"></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent" style="margin-left:40% ">
              <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                  <a class="nav-link" href= '<%= request.getContextPath() %>/index.jsp'>Home</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href='<%= request.getContextPath() %>/blogs'>Blogs</a>
                </li>
                <li class="nav-item dropdown">
                  <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Hall Events
                  </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown" id="Events-DropDown">
                    <a class="dropdown-item" href='<%= request.getContextPath() %>/viewHalls'>Wedding</a>
                    <a class="dropdown-item" href='<%= request.getContextPath() %>/viewHalls'>Corporate Party</a>
                    <a class="dropdown-item" href='<%= request.getContextPath() %>/viewHalls'>Conference</a>
                    <a class="dropdown-item" href='<%= request.getContextPath() %>/viewHalls'>Concert</a>
                    <a class="dropdown-item" href='<%= request.getContextPath() %>/viewHalls'>Exhibition</a>
                    <a class="dropdown-item" href='<%= request.getContextPath() %>/viewHalls'>Product Launch</a>
                    <a class="dropdown-item" href='<%= request.getContextPath() %>/viewHalls'>Training Session</a>
                  </div>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href='<%= request.getContextPath() %>/facilites'>Facilities</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href='<%= request.getContextPath() %>/contact'>Contact</a>
                </li>
                <% if(session.getAttribute("customer")==null){%>
                <li class="nav-item">
                  <a class="nav-link"  id="login">Login</a>
                </li>
                <%}
                else{ %>
                <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="userMenu" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor" class="bi bi-person" viewBox="0 0 16 16">
                                <path d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6m2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0m4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4m-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10s-3.516.68-4.168 1.332c-.678.678-.83 1.418-.832 1.664z"/>
                            </svg>
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="userMenu">
                            <li><a class="dropdown-item ms-0" href="<%= request.getContextPath() %>/viewBooking" style ="color: #4e4332 !important;">My Bookings</a></li>
                             <li><a class="dropdown-item ms-0" href="<%= request.getContextPath() %>/RequestHall" style ="color: #4e4332 !important;">Booking Request</a></li>
                               <li><a class="dropdown-item ms-0" href="<%= request.getContextPath() %>/logout" style ="color: #4e4332 !important;" id="logout">Logout</a></li>
                      	</ul>
                </li>
                <%} %>
              </ul>
            </div>
          </nav>
    </header>
    <!--Logout modal-->
	 <div class="modal" id="logoutModal" tabindex="-1" aria-labelledby="logoutModalLabel" aria-hidden="true">
 <form action="logout" method="get">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="logoutModalLabel">Confirm Logout</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      	</div>
     	 <div class="modal-body">
        	<p>Are you sure you want to logout?</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
        <button type="submit" class="btn btn-outline-danger">Logout</button>
      </div>
    </div>
  </div> 
  </form>
</div> 
    <div class="container">
        <div><h2>My Booking</h2></div>
        <c:if test="${not empty PaymentList}">
        <c:forEach var="payment" items="${PaymentList}" varStatus="status">
        <div class="card">
            <div class="innerCard row">
                <div class="image-container col-3">
                    <a class="hall_link" data-hall-id="${hall.hallId}" data-index="${status.index}"><img src="<%= request.getContextPath() %>/assert/image/hallcard-1.jpg" alt="hall"></a>
                </div>
                <div class="content col-8">
                    <div class="hall-content d-flex">
                        <div class="hall_name pe-4"><strong>${payment.book.hall.hallName}</strong></div>
                        <div class="hall_location pe-4 ">${payment.book.hall.location}</div> 
                        <div class="price pe-4"><p><strong>Per day price :</strong>&#8377; ${payment.book.hall.price}</p></div>
                    </div>
                    <div class="booking-content d-flex">
                        <div class="book-c flex-grow-0 flex-shrink-0 bookeduration pe-4"><strong>Start Date:</strong>${payment.book.startDate}</div>
                        <div class="book-c flex-grow-0 flex-shrink-0 paid pe-4 align-items-center"><strong>Paid:</strong> &#8377; ${payment.price}</div>
                        <div class="book-c flex-grow-0 flex-shrink-0 status pe-4 align-items-center">
					    <strong>Status:</strong> ${payment.paidStatus}
					</div>
					<c:choose>
					    <c:when test="${payment.paidStatus == 'ADVANCED'}">
					    <form action="fullPayment" method="get">
					        <div class="book-c flex-grow-0 flex-shrink-0 mt-2 pe-4 align-items-center">
					        	 <input value="${payment.paymentId}" name="paymentId" style="display:none"/>
					            <button class="btn btn-outline-success btn-block">Pay</button>
					        </div>
					    </form>
					    </c:when>
					    <c:when test="${payment.paidStatus == 'ADVANCED' || payment.paidStatus == 'PAID'}">
					        <div class="book-c flex-grow-0 flex-shrink-0 mt-2 pe-4 align-items-center">
					            <button class="btn btn-outline-primary btn-block">CANCEL</button>
					        </div>
					    </c:when>
					</c:choose>
                    </div>
            </div>
            </div>
			<form id="form-${status.index}" style="display:none" class="submission" action="${pageContext.request.contextPath}/showHallDetail" method="post">
			    <input type="hidden" name="hallId" id="hall-Id-${status.index}" value="${hall.hallId}">
			    <button type="submit" class="form-btn"></button>
			</form>
        </div>
        </c:forEach>
       </c:if>
       <c:if test="${empty PaymentList}">
    			<p>No payments found.</p>
		</c:if>
    </div>
    <script type="text/javascript">
    document.getElementById('confirmLogoutButton').addEventListener('click', function() {
        // Add your logout logic here
        window.location.href = '<%= request.getContextPath() %>/LogoutServlet'; // Replace 'logoutURL' with the actual URL to log out
      });

      // Show the modal when the logout dropdown item is clicked
      document.getElementById('logout').addEventListener('click', function(event) {
        event.preventDefault();
        var logoutModal = new bootstrap.Modal(document.getElementById('logoutModal'));
        logoutModal.show();
      });
    </script>
    <footer class="text-center pt-4 pb-4 align-items-center">
        © 2021 Copyright:
        <a class="text-reset fw-bold text-align-center" href="https://RoyalHalls.com/">RoyalHalls.com</a>
    </footer>
    <script type="text/javascript">
    
    document.addEventListener('DOMContentLoaded', function() {
        var links = document.querySelectorAll('.hall_link');

        links.forEach(function(link) {
            link.addEventListener('click', function(event) {
                event.preventDefault();
                var index = link.getAttribute('data-index');
                var form = document.getElementById('form-' + index);
                form.submit();
            });
        });
    });
   
    </script>
</body>
</html>