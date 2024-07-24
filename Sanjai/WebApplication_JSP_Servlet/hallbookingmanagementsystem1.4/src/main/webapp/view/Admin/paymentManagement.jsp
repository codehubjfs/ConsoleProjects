<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored = "false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="image/LogoFavIcon.jpg">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-multiselect/0.9.15/css/bootstrap-multiselect.css" rel="stylesheet">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <title>Payment Management</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/assert/css/AdminStyle.css">

    <style>
        .btn-secondary{
            background-color: #AA8D6F ; 
            color:rgb(43, 40, 40) ; 
            font-weight: 500;
            border: none;
        }
        .btn-secondary:hover{
            background-color:#e0cab2;
        }
        .innerContainer{
            display: inline-flex;
        }
        .mainContent{
            margin-top: 30px;
            margin-left: 30px;
        }
        #paymentTable th, #paymentTable td{
            text-align: center;
        }
        .profile a{
            text-decoration: none;
            color:#4e4332;
        }
        table .td, table .tr{
            white-space: nowrap;
            padding-left: 30px;
            padding-right: 30px;
        }
        </style>
</head>
<body>
    <header class="header">
        <div class="logo">
            <img src="<%= request.getContextPath() %>/assert/image/Logo.1.1.png" alt="" id="company-logo"/>
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
                    <div class="row" style="padding-left: 15px; padding-right:15px;">
                        <a href="#" class="dropdown-item">Profile</a>
                    </div>
                    <div class="row" style="padding-left: 15px; padding-right:15px;">
                        <a href="#" class="dropdown-item">Settings</a>
                    </div>
                     <div class="row" style="padding-left: 10px; padding-right:10px;">
                        <a  href= '<%= request.getContextPath() %>/index.jsp' class="dropdown-item">Logout</a>
                    </div>
                </div>
            </div>
        </div>
    </header>
    <div class="subContainer">
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
        <div class="mainContent" style="margin-left:250px">
            <h1>Payment Details</h1>
            <div class="table-responsive-lg">
                <table id="paymentTable" class="table table-hover table-bordered"  style="width:60%;">
                    <thead class="thead-dark">
                        <tr>
                            <th style="width:150px;">Sno</th>
                            <th style="width:100px;">UserName</th>
                            <th style="width:150px;">Amount</th>
                            <th style="width:150px;">Time</th>
                            <th style="width:150px;">Status</th>
                            <th style="width:100px;">Payment Type</th>
                            <th style="width:100px;">Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:set var="count" value="0" />
                    <c:forEach items="${paymentList}" var="payment" varStatus="status">
                        <tr>
                            <td>${count+1}</td>
                            <td>${payment.book.customer.userName}</td>
                            <td>${payment.price}</td>
                            <td>${payment.paymentTime}</td>
                            <td>${payment.paidStatus}</td>
                            <td style="display:flex; gap: 10px;">
                                <button type="button" class="btn btn-secondary">
                                    <img src="<%= request.getContextPath() %>/assert/image/printer.svg" alt="Print">
                                </button>
                                <a href="invoice.html">
                                    <button type="button" class="btn btn-secondary" style="background-color: #AA8D6F;">View</button>
                                </a>
                            </td>
                        </tr>
                         </c:forEach>
					    <c:if test="${empty paymentList}">
					        <tr>
					            <td colspan="6" class="text-center">No Payment available.</td>
					        </tr>
					    </c:if>
                    </tbody>
                </table>
            </div>
            
        </div>
    <script>
        function redirectToInvoice() {
            window.location.href = 'invoice.html';
        }
    </script>
</body>
</html>