<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored = "false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="image/LogoFavIcon.jpg">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
    <title>Booking Management</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/assert/css/AdminStyle.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/assert/css/bookingmanagement.css">
    <style>
    	.subcontainer{
    		margin-left:220px !important;
    	}
    </style>
	</head>
</head>
<body>
    <header class="header">
        <div class="logo">
            <img src="<%= request.getContextPath() %>/assert/image/Logo.1.1.png"  alt="" id="company-logo"/>
        </div>
        <div class="profile d-inline-block">
            <a class="d-flex align-items-center" data-bs-toggle="collapse" href="#profileMenu" role="button" aria-expanded="false" aria-controls="profileMenu">
                <div class="d-flex align-items-center">
                    <svg xmlns="http://www.w3.org/2000/svg" width="50" height="50" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
                        <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0"/>
                        <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8m8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1"/>
                      </svg>
                    <div class="mt-3 ms-2 me-4">
                        <h4 class="p-0 m-0">Administrator</h4>
                        <p>${sessionScope.userName.getUserName()}</p>
                    </div>
                </div>
            </a>
            <div class="collapse mt-2 pe-2 ps-2" style="position:absolute; z-index: 1;" id="profileMenu">
                <div class="card card-body">
                    <div class="row" style="padding-left: 10px; padding-right:10px;">
                        <a href="#" class="dropdown-item">Profile</a>
                    </div>
                    <div class="row" style="padding-left: 10px; padding-right:10px;">
                        <a href="#" class="dropdown-item">Settings</a>
                    </div>
                    <div class="row" style="padding-left: 10px; padding-right:10px;">
                        <a  href= '<%= request.getContextPath() %>/index.jsp' class="dropdown-item">Logout</a>
                    </div>
                </div>
            </div>
        </div>
    </header>
    <div class="subcontainer">
       <div class="innerContainer">
            <div class="sideNavBar">
            <div class="vertical-nav">
                <nav class="navbar navbar-expand-lg navbar-light main-left-nav" id="sideNav">
                    <ul class="nav flex-column">
                        <li class="nav-item">
                            <a class="nav-link" href="<%= request.getContextPath() %>/DashBoardServlet">Dashboard</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link booking-active" id="booking-active"  href="<%= request.getContextPath() %>/BookingManagementServlet">Booking Management</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link"  href="<%= request.getContextPath() %>/HallManagementServlet">Hall Management</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="<%= request.getContextPath() %>/CustomerManagementServlet">Customer Management</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="<%= request.getContextPath() %>/PaymentManagementServlet">Payment Management</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href= '<%= request.getContextPath() %>/index.jsp'>Sign Out</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">View Supports</a>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
        </div>
        <div class="bookingTable">
            <h1>Booking Details</h1>
            <div class="table-responsive-lg">
                <table class="table table-hover table-bordered" id ="bookingTable" style="width:80%;">
                    <thead class="thead-dark">
                    <div class="alert alert-warning alert-dismissible fade show" id="alertStatus" style="display:none" role="alert">
						  <p>Could not able to change confirmed booking.</p>
						  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
						</div>
                        <tr>
                        	<th style="display:none"></th>
                        	<th>SNo</th>
                            <th>User Name</th>
                            <th>Requested Hall</th>
                            <th>Start Date</th>
                            <th>End Date</th>
                            <th>Status</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                   <tbody>
					    <c:set var="count" value="0" />
					    <c:forEach items="${bookingList}" var="booking" varStatus="status">
					            <c:set var="count" value="${count + 1}" />
					            <tr>
					                	<td style="display:none" class="bookId">${booking.bookingId}</td>
					                    <td>${count}</td>
					                    <td>${booking.customer.userName}</td>
					                    <td>${booking.hall.hallName}</td>
					                    <td>${booking.startDate}</td>
					                    <td>${booking.endDate}</td>
					                    <td>
					                        <span class="status-text ${booking.bookStatus.toLowerCase()}" style="text-align: center; justify-content: center;">${booking.bookStatus}</span>
					                        <select class="form-select status-select" name="newStatus" style="display: none;">
					                            <option value="PENDING" <c:if test="${booking.bookStatus == 'PENDING'}">selected</c:if>>PENDING</option>
					                            <option value="APPROVED" <c:if test="${booking.bookStatus == 'APPROVED'}">selected</c:if>>APPROVED</option>
					                            <option value="CONFIRMED" <c:if test="${booking.bookStatus == 'CONFIRMED'}">selected</c:if>>CONFIRMED</option>
					                            <option value="CANCEL" <c:if test="${booking.bookStatus == 'CANCEL'}">selected</c:if>>CANCEL</option>
					                        </select>
					                    </td>
					                    <td>
					                        <button type="button" class="btn btn-outline-primary btn-sm edit-btn">
					                            <i class="fas fa-edit"></i>
					                        </button>
					                        <button type="submit" class="btn btn-outline-success btn-sm save-btn" style="display: none;">
					                            <i class="fas fa-save"></i>
					                        </button>
					                        <button type="button" class="btn btn-outline-danger btn-sm cancel-btn" style="display: none;">
					                            <i class="fas fa-times-circle"></i>
					                        </button>
					                        <input type="hidden" name="userId" value="${booking.bookingId}">
					                    </td>
					            </tr>
					    </c:forEach>
					    <c:if test="${empty bookingList}">
					        <tr>
					            <td colspan="6" class="text-center">No bookings available.</td>
					        </tr>
					    </c:if>
					</tbody>
                </table>
            </div>
        </div>
    </div>
   
    <div class="alert-container" style="position: fixed; top: 20px; right: 20px; z-index: 9999;"></div>
    <!-- jQuery -->
	<script src='https://code.jquery.com/jquery-3.7.0.js'></script>
	<!-- Data Table JS -->
	<script src='https://cdn.datatables.net/1.13.5/js/jquery.dataTables.min.js'></script>
	<script src='https://cdn.datatables.net/responsive/2.1.0/js/dataTables.responsive.min.js'></script>
	<script src='https://cdn.datatables.net/1.13.5/js/dataTables.bootstrap5.min.js'></script>
    <script>
    
    document.addEventListener('DOMContentLoaded', function() {
        let alertStatus = document.getElementById("alertStatus");
        alertStatus.style.display = 'none';

        document.querySelectorAll('.edit-btn').forEach(button => {
            button.addEventListener('click', function() {
                let row = this.closest('tr');
                let status = row.querySelector('.status-text').innerText.trim();
                console.log(status);

                if (status === "CONFIRMED") {
                    alertStatus.style.display = 'block';
                } else {
                    row.querySelector('.status-text').style.display = 'none';
                    row.querySelector('.status-select').style.display = 'block';
                    row.querySelector('.edit-btn').style.display = 'none';
                    row.querySelector('.save-btn').style.display = 'inline-block';
                    row.querySelector('.cancel-btn').style.display = 'inline-block';
                }
            });
        });
    });



        document.querySelectorAll('.cancel-btn').forEach(button => {
            button.addEventListener('click', function() {
                let row = this.closest('tr');
                let statusSelect = row.querySelector('.status-select');
                let statusText = row.querySelector('.status-text');
                statusSelect.value = statusText.textContent.trim();
                statusText.style.display = 'block';
                statusSelect.style.display = 'none';
                row.querySelector('.edit-btn').style.display = 'inline-block';
                row.querySelector('.save-btn').style.display = 'none';
                row.querySelector('.cancel-btn').style.display = 'none';
            });
        });
        document.querySelectorAll('.save-btn').forEach(button => {
            button.addEventListener('click', function () {
                let row = this.closest('tr');
                let cid = row.querySelector('.bookId');
                //console.log(cid.textContent);
                let statusSelect = row.querySelector('.status-select');
                let statusText = row.querySelector('.status-text');
                statusText.textContent = statusSelect.value;
                statusText.style.display = 'block';
                statusSelect.style.display = 'none';
                row.querySelector('.edit-btn').style.display = 'inline-block';
                row.querySelector('.save-btn').style.visibility = 'hidden';
                row.querySelector('.cancel-btn').style.visibility = 'hidden';
                location.href = "${pageContext.request.contextPath}/EditBookingController?status="+statusSelect.value+"&bookId="+cid.textContent;
            });
        });
        $(document).ready(function() {
            $('#bookingTable').DataTable({
            	"pageLength": 10,
              //disable sorting on last column
              "columnDefs": [
                { "orderable": false, "targets": 5 }
              ],
              language: {
                //customize pagination prev and next buttons: use arrows instead of words
                'paginate': {
                  'previous': '<span class="fa fa-chevron-left"></span>',
                  'next': '<span class="fa fa-chevron-right"></span>'
                },
                //customize number of elements to be displayed
                "lengthMenu": 'Display <select class="form-control input-sm">'+
                '<option value="10">10</option>'+
                '<option value="20">20</option>'+
                '<option value="30">30</option>'+
                '<option value="40">40</option>'+
                '<option value="50">50</option>'+
                '<option value="-1">All</option>'+
                '</select> results'
              }
            })  
        } );
    </script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>

