<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asserts/css/adminstyles.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
    <!-- Data Table CSS -->
	<link rel='stylesheet' href='https://cdn.datatables.net/1.13.5/css/dataTables.bootstrap5.min.css'>
	<script src='https://code.jquery.com/jquery-3.7.0.js'></script>
	<!-- Data Table JS -->
<script src='https://cdn.datatables.net/1.13.5/js/jquery.dataTables.min.js'></script>
<script src='https://cdn.datatables.net/responsive/2.1.0/js/dataTables.responsive.min.js'></script>
<script src='https://cdn.datatables.net/1.13.5/js/dataTables.bootstrap5.min.js'></script>
<!-- Data Table JS -->
 <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/2.4.0/jspdf.umd.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf-autotable/3.5.17/jspdf.plugin.autotable.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/docx/7.1.1/docx.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/FileSaver.js/2.0.5/FileSaver.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Vendor Management</title>

</head>
<body style="width:100vw">
<%
/*
response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
	if(request.getSession().getAttribute("admin")==null){
		response.sendRedirect("index.jsp");
	} */
%>
      <div class="container">
        <div class="row">
            <nav class="col-md-2 col-2  sidebar position-fixed pt-0 px-0" id="sidebar">
                <div class="pt-0 px-0">
                  <div class="logo-divv">
                    <a class="navbar-brand" href="#">
                      <img class="img-fluid logo-img" src="${pageContext.request.contextPath}/asserts/images/logo.png" alt="MDB Logo"  />
                    </a>
                  </div>
                  <div class="user-pic d-flex flex-column  justify-content-center align-items-center">
                    <div>
                      <img src="${pageContext.request.contextPath}/asserts/images/avatar.png" class="img-fluid rounded-pill" width="60" height="50" alt="">
                    <a data-toggle="collapse" data-bs-toggle="collapse" href="#profileMenu" role="button" aria-expanded="true" aria-controls="profileMenu">
                      <span class="px-1">${sessionScope.admin.getUserName()} <i class="bi bi-caret-down-fill"></i></span></a>
                    </div>
                      <div class="collapse collapse-menu mt-2" id="profileMenu">
                        <div class="card card-body" id="cards-bodyy">
                            <div class="row pt-2 pb-2 px-1 menuss">
                                <a href="AdminManagementController" class="dropdown-item">Profile</a>
                            </div>
                             <!--     <div class="row pt-2 pb-2 px-1 menuss">
                                <a href="#" class="dropdown-item">Settings</a>
                            </div>  -->
                            <div class="row pt-2 pb-2 px-1 menuss">
                                <a href="${pageContext.request.contextPath}/AdminLogoutController" class="dropdown-item">Logout</a>
                            </div>
                        </div>
                    </div>
                  </div>
                  <div class="nav flex-column d-flex justify-content-center" id="sidenavs">
                  
                    <li class="nav-item side-barnav">
                      <a class="nav-link pt-4" href="AdminDashBoardController">Dashboard</a>
                    </li>
                    <li class="nav-item side-barnav">
                      <a class="nav-link pt-4" href="CustomerManagementController">Customer Management</a>
                    </li>
                    <li class="nav-item side-barnav">
                      <a class="nav-link  pt-4 active" href="SellerManagementController">Vendor Management</a>
                    </li>
                    <li class="nav-item side-barnav">
                      <a class="nav-link pt-4" href="${pageContext.request.contextPath}/ProductManagementController">Product Management</a>
                    </li>
                    <li class="nav-item side-barnav">
                      <a class="nav-link pt-4" href="${pageContext.request.contextPath}/CategoryManagementController">Category Management</a>
                    </li>
                    <li class="nav-item side-barnav">
                      <a class="nav-link pt-4" href="${pageContext.request.contextPath}/SubCategoryManagementController">Sub-Category Management</a>
                    </li>
                    <li class="nav-item side-barnav">
                      <a class="nav-link pt-4" href="${pageContext.request.contextPath}/AdminManagementController">Admin Management</a>
                  </li>
                  
                </div>
                </div>
              </nav>
            <div class="col-md-10 body-block-table-customer">
                <div class="content">
                    <div class="container table-responsive">
                        <div class="container mt-4 mb-4">
                            <div class="row">
                                <div class="col-10">
                                    <h2>All Vendors</h2>
                                    <button id="export-pdf" class="btn btn-outline-dark btn-sm">Export to PDF</button>
                                </div>
                                
                                <div class="col pt-3">
                                	<select id="status-filter" class="form-select" style="max-width:130px">
                                	<option value="ALL" selected>ALL</option>
                                		<option value="ACTIVE">ACTIVE</option>
                                         <option value="BLOCKED">BLOCKED</option>
                                         <option value="NOT-VERIFIED">NOT-VERIFIED</option>
                                	</select>
                                
                                	
                                </div>

                            </div>
                        </div>
                        <table class="table  table-bordered table-hover" id="vendor-table">
                            <thead class="text-center">
                                <tr>
                                    <th>S.no</th>
                                    <th style="display:none"></th>
                                    <th>Username</th>
                                    <!-- <th>Address</th> -->
                                    <th>Mobile Number</th>
                                    <th>Email</th>
                                    <th>Aadhar Number</th>
                                    <th>Account Status</th>
                                    <th>Actions</th>
                                </tr>
                            </thead>
                            <tbody class="text-center">
                            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
                            <c:forEach var="user" items="${seller}" varStatus="status">
                                <tr data-filter="${user.account.accountStatus}">
                                	<td class="status-id">${status.count}</td>
                                    <td  class="vendorId" style="display:none">${user.vendorId}</td>
                                    <td class="td-usernsme">${user.account.userName}</td>
                                    <!-- <td>Address</td> -->
                                    <td class="td-mobileno">${user.mobileNumber}</td>
                                    <td class="td-email">${user.email}</td>
                                    <td class="td-aadhar">9870 3456 7890</td>
                                    <td>
                                        <span class="status-text">${user.account.accountStatus}</span>
                                        <select class="form-select status-select" style="display: none;">
                                            <option value="ACTIVE" selected>ACTIVE</option>
                                            <option value="BLOCKED">BLOCKED</option>
                                            <option value="NOT-VERIFIED">NOT-VERIFIED</option>
                                        </select>
                                    </td>
                                    <c:if test="${user.account.accountStatus!='DELETED'}">
                                    <td class="d-flex justify-content-center">
                                    <button class="btn btn-success rounded-pill btn-sm mt-2 mx-1 save-btn">
                                            <i class="fas fa-save"></i>
                                        </button>
                                        <button class="btn btn-primary btn-sm edit-btn rounded-pill mt-2 mx-1">
                                            <i class="bi bi-pencil-square"></i>
                                        </button>
                                        <button class="btn btn-danger rounded-pill btn-sm mt-2 mx-1 del-btn">
                                            <i class="bi bi-trash3-fill"></i>
                                        </button>
                                        <button class="btn btn-secondary rounded-pill btn-sm mt-2 mx-1"
                                            onclick="viewVendorDetail(new Vendor('${user.account.userName}','${user.address}',${user.mobileNumber},'${user.email}','${user.aadharNumber}','${user.account.accountStatus}'))">
                                            <i class="bi bi-eye-fill"></i>
                                        </button>
                                        
                                        <button type="button"
                                            class="btn btn-dark rounded-pill btn-sm mt-2 mx-1 cancel-btn">
                                            <i class="fas fa-times-circle"></i>
                                        </button>
                                    </td>
                                    </c:if>
                                    
                                    <c:if test="${user.account.accountStatus=='DELETED'}">
                                    <td class="d-flex justify-content-center">
                                    <button class="btn btn-success rounded-pill btn-sm mt-2 mx-1 save-btn" disabled>
                                            <i class="fas fa-save"></i>
                                        </button>
                                        <button class="btn btn-primary btn-sm edit-btn rounded-pill mt-2 mx-1" disabled>
                                            <i class="bi bi-pencil-square"></i>
                                        </button>
                                        <button class="btn btn-danger rounded-pill btn-sm mt-2 mx-1 del-btn" disabled>
                                            <i class="bi bi-trash3-fill"></i>
                                        </button>
                                        <button class="btn btn-secondary rounded-pill btn-sm mt-2 mx-1" disabled
                                            onclick="viewVendorDetail(new Vendor('${user.account.userName}','${user.address}',${user.mobileNumber},'${user.email}','${user.aadharNumber}','${user.account.accountStatus}'))">
                                            <i class="bi bi-eye-fill"></i>
                                        </button>
                                        
                                        <button type="button"
                                            class="btn btn-dark rounded-pill btn-sm mt-2 mx-1 cancel-btn" disabled>
                                            <i class="fas fa-times-circle"></i>
                                        </button>
                                    </td>
                                    </c:if>
                                </tr>
                                </c:forEach>
                             <!--     <tr>
                                    <td  class="vendorId">2</td>
                                    <td>Highlander001</td>
                                    <!-- <td>Address</td>
                                    <td>63803 03221</td>
                                    <td>Highlander@gmail.com</td>
                                    <td>9312 3456 7890</td>
                                    <td>
                                        <span class="status-text">ACTIVE</span>
                                        <select class="form-select status-select" style="display: none;">
                                            <option value="ACTIVE" selected>ACTIVE</option>
                                            <option value="BLOCKED">BLOCKED</option>
                                            <option value="NOT-VERIFIED">NOT-VERIFIED</option>
                                        </select>
                                    </td>
                                    <td class="d-flex justify-content-center">
                                    <button class="btn btn-success rounded-pill btn-sm mt-2 mx-1 save-btn">
                                            <i class="fas fa-save"></i>
                                        </button>
                                        <button class="btn btn-primary btn-sm edit-btn rounded-pill mt-2 mx-1">
                                            <i class="bi bi-pencil-square"></i>
                                        </button>
                                        <button class="btn btn-danger rounded-pill btn-sm mt-2 mx-1 del-btn">
                                            <i class="bi bi-trash3-fill"></i>
                                        </button>
                                        <button class="btn btn-secondary rounded-pill btn-sm mt-2 mx-1"
                                            onclick="viewVendorDetail(new Vendor('Highlander001','1/15, P.V.R. Street, Meenampakkam, Chennai - 600028.',6380303221,'Highlander@gmail.com','9312 3456 7890','ACTIVE'))">
                                            <i class="bi bi-eye-fill"></i>
                                        </button>
                                        
                                        <button type="button"
                                            class="btn btn-dark rounded-pill btn-sm mt-2 mx-1 cancel-btn">
                                            <i class="fas fa-times-circle"></i>
                                        </button>
                                    </td>
                                </tr>
                                <tr>
                                    <td  class="vendorId">3</td>
                                    <td>Puma10</td>
                                    <!-- <td>Address</td>
                                    <td>95142 06944</td>
                                    <td>puma@gmail.com</td>
                                    <td>9112 3456 7890</td>
                                    <td>
                                        <span class="status-text">ACTIVE</span>
                                        <select class="form-select status-select" style="display: none;">
                                            <option value="ACTIVE" selected>ACTIVE</option>
                                            <option value="BLOCKED">BLOCKED</option>
                                            <option value="NOT-VERIFIED">NOT-VERIFIED</option>
                                        </select>
                                    </td>
                                    <td class="d-flex justify-content-center">
                                    <button class="btn btn-success rounded-pill btn-sm mt-2 mx-1 save-btn">
                                            <i class="fas fa-save"></i>
                                        </button>
                                        <button class="btn btn-primary btn-sm edit-btn rounded-pill mt-2 mx-1">
                                            <i class="bi bi-pencil-square"></i>
                                        </button>
                                        <button class="btn btn-danger rounded-pill btn-sm mt-2 mx-1 del-btn">
                                            <i class="bi bi-trash3-fill"></i>
                                        </button>
                                        <button class="btn btn-secondary rounded-pill btn-sm mt-2 mx-1"
                                            onclick="viewVendorDetail(new Vendor('Puma10','1/15, P.V.R. Street, Meenampakkam, Chennai - 600028.',9514206944,'puma@gmail.com','9112 3456 7890','ACTIVE'))">
                                            <i class="bi bi-eye-fill"></i>
                                        </button>
                                        
                                        <button type="button"
                                            class="btn btn-dark rounded-pill btn-sm mt-2 mx-1 cancel-btn">
                                            <i class="fas fa-times-circle"></i>
                                        </button>
                                    </td>
                                </tr>
                                <tr>
                                    <td  class="vendorId">4</td>
                                    <td>MastHarbour7</td>
                                    <!-- <td>Address</td> 
                                    <td>86101 72466</td>
                                    <td>mastharbour@gmail.com</td>
                                    <td>9012 3456 7890</td>
                                    <td>
                                        <span class="status-text">ACTIVE</span>
                                        <select class="form-select status-select" style="display: none;">
                                            <option value="ACTIVE" selected>ACTIVE</option>
                                            <option value="BLOCKED">BLOCKED</option>
                                            <option value="NOT-VERIFIED">NOT-VERIFIED</option>
                                        </select>
                                    </td>
                                    <td class="d-flex justify-content-center">
                                    <button class="btn btn-success rounded-pill btn-sm mt-2 mx-1 save-btn">
                                            <i class="fas fa-save"></i>
                                        </button>
                                        <button class="btn btn-primary btn-sm edit-btn rounded-pill mt-2 mx-1">
                                            <i class="bi bi-pencil-square"></i>
                                        </button>
                                        <button class="btn btn-danger rounded-pill btn-sm mt-2 mx-1 del-btn">
                                            <i class="bi bi-trash3-fill"></i>
                                        </button>
                                        <button class="btn btn-secondary rounded-pill btn-sm mt-2 mx-1"
                                            onclick="viewVendorDetail(new Vendor('MastHarbour7','1/15, P.V.R. Street, Meenampakkam, Chennai - 600028.',8610172466,'mastharbour@gmail.com','9012 3456 7890','ACTIVE'))">
                                            <i class="bi bi-eye-fill"></i>
                                        </button>
                                        
                                        <button type="button"
                                            class="btn btn-dark rounded-pill btn-sm mt-2 mx-1 cancel-btn">
                                            <i class="fas fa-times-circle"></i>
                                        </button>
                                    </td>
                                </tr>
                                <tr>
                                    <td  class="vendorId">5</td>
                                    <td>UCB009</td>
                                    <!-- <td>Address</td> 
                                    <td>91591 78462</td>
                                    <td>UCB@gmail.com</td>
                                    <td>9987 3456 7890</td>
                                    <td>
                                        <span class="status-text">ACTIVE</span>
                                        <select class="form-select status-select" style="display: none;">
                                            <option value="ACTIVE" selected>ACTIVE</option>
                                            <option value="BLOCKED">BLOCKED</option>
                                            <option value="NOT-VERIFIED">NOT-VERIFIED</option>
                                        </select>
                                    </td>
                                    <td class="d-flex justify-content-center">
                                     <button class="btn btn-success rounded-pill btn-sm mt-2 mx-1 save-btn">
                                            <i class="fas fa-save"></i>
                                        </button>
                                        <button class="btn btn-primary btn-sm edit-btn rounded-pill mt-2 mx-1">
                                            <i class="bi bi-pencil-square"></i>
                                        </button>
                                        <button class="btn btn-danger rounded-pill btn-sm mt-2 mx-1 del-btn">
                                            <i class="bi bi-trash3-fill"></i>
                                        </button>
                                        <button class="btn btn-secondary rounded-pill btn-sm mt-2 mx-1"
                                            onclick="viewVendorDetail(new Vendor('UCB009','1/15, P.V.R. Street, Meenampakkam, Chennai - 600028.',9159178462,'UCB@gmail.com','9987 3456 7890','ACTIVE'))">
                                            <i class="bi bi-eye-fill"></i>
                                        </button>
                                       
                                        <button type="button"
                                            class="btn btn-dark rounded-pill btn-sm mt-2 mx-1 cancel-btn">
                                            <i class="fas fa-times-circle"></i>
                                        </button>
                                    </td>
                                </tr>
                                <tr>
                                    <td  class="vendorId">6</td>
                                    <td>BeingHuman3</td>
                                    <!-- <td>Address</td> 
                                    <td>93139 35741</td>
                                    <td>beinghuman@gmail.com</td>
                                    <td>9967 3456 7890</td>
                                    <td>
                                        <span class="status-text">ACTIVE</span>
                                        <select class="form-select status-select" style="display: none;">
                                            <option value="ACTIVE" selected>ACTIVE</option>
                                            <option value="BLOCKED">BLOCKED</option>
                                            <option value="NOT-VERIFIED">NOT-VERIFIED</option>
                                        </select>
                                    </td>
                                    <td class="d-flex justify-content-center">
                                    <button class="btn btn-success rounded-pill btn-sm mt-2 mx-1 save-btn">
                                            <i class="fas fa-save"></i>
                                        </button>
                                        
                                        <button class="btn btn-primary btn-sm edit-btn rounded-pill mt-2 mx-1">
                                            <i class="bi bi-pencil-square"></i>
                                        </button>
                                        <button class="btn btn-danger rounded-pill btn-sm mt-2 mx-1 del-btn">
                                            <i class="bi bi-trash3-fill"></i>
                                        </button>
                                        <button class="btn btn-secondary rounded-pill btn-sm mt-2 mx-1"
                                            onclick="viewVendorDetail(new Vendor('BeingHuman3','1/15, P.V.R. Street, Meenampakkam, Chennai - 600028.',9313935741,'beinghuman@gmail.com','9967 3456 7890','ACTIVE'))">
                                            <i class="bi bi-eye-fill"></i>
                                        </button>
                                        
                                        <button type="button"
                                            class="btn btn-dark rounded-pill btn-sm mt-2 mx-1 cancel-btn">
                                            <i class="fas fa-times-circle"></i>
                                        </button>
                                    </td>
                                </tr>
                                <tr>
                                    <td  class="vendorId">7</td>
                                    <td>HRX1007</td>
                                    <!-- <td>Address</td> 
                                    <td>78923 43451</td>
                                    <td>hrx@gmail.com</td>
                                    <td>9311 3456 7890</td>
                                    <td>
                                        <span class="status-text">ACTIVE</span>
                                        <select class="form-select status-select" style="display: none;">
                                            <option value="ACTIVE" selected>ACTIVE</option>
                                            <option value="BLOCKED">BLOCKED</option>
                                            <option value="NOT-VERIFIED">NOT-VERIFIED</option>
                                        </select>
                                    </td>
                                    <td class="d-flex justify-content-center">
                                    	 <button class="btn btn-success rounded-pill btn-sm mt-2 mx-1 save-btn">
                                            <i class="fas fa-save"></i>
                                        </button>
                                        <button class="btn btn-primary btn-sm edit-btn rounded-pill mt-2 mx-1">
                                            <i class="bi bi-pencil-square"></i>
                                        </button>
                                        <button class="btn btn-danger rounded-pill btn-sm mt-2 mx-1 del-btn">
                                            <i class="bi bi-trash3-fill"></i>
                                        </button>
                                        <button class="btn btn-secondary rounded-pill btn-sm mt-2 mx-1"
                                            onclick="viewVendorDetail(new Vendor('HRX1007','1/15, P.V.R. Street, Meenampakkam, Chennai - 600028.',7892343451,'hrx@gmail.com','9311 3456 7890','ACTIVE'))">
                                            <i class="bi bi-eye-fill"></i>
                                        </button>
                                       
                                        <button type="button"
                                            class="btn btn-dark rounded-pill btn-sm mt-2 mx-1 cancel-btn">
                                            <i class="fas fa-times-circle"></i>
                                        </button>
                                    </td>
                                </tr>
                                <tr>
                                    <td  class="vendorId">8</td>
                                    <td>Mufti00</td>
                                    <!-- <td>Address</td>
                                    <td>86374 65744</td>
                                    <td>mufti@gmail.com</td>
                                    <td>9345 2345 7890</td>
                                    <td>
                                        <span class="status-text">ACTIVE</span>
                                        <select class="form-select status-select" style="display: none;">
                                            <option value="ACTIVE" selected>ACTIVE</option>
                                            <option value="BLOCKED">BLOCKED</option>
                                            <option value="NOT-VERIFIED">NOT-VERIFIED</option>
                                        </select>
                                    </td>
                                    <td class="d-flex justify-content-center">
                                    <button class="btn btn-success rounded-pill btn-sm mt-2 mx-1 save-btn">
                                            <i class="fas fa-save"></i>
                                        </button>
                                        <button class="btn btn-primary btn-sm edit-btn rounded-pill mt-2 mx-1">
                                            <i class="bi bi-pencil-square"></i>
                                        </button>
                                        <button class="btn btn-danger rounded-pill btn-sm mt-2 mx-1 del-btn">
                                            <i class="bi bi-trash3-fill"></i>
                                        </button>
                                        <button class="btn btn-secondary rounded-pill btn-sm mt-2 mx-1"
                                            onclick="viewVendorDetail(new Vendor('Mufti00','1/15, P.V.R. Street, Meenampakkam, Chennai - 600028.',8637465744,'mufti@gmail.com','9345 2345 7890','ACTIVE'))">
                                            <i class="bi bi-eye-fill"></i>
                                        </button>
                                        
                                        <button type="button"
                                            class="btn btn-dark rounded-pill btn-sm mt-2 mx-1 cancel-btn">
                                            <i class="fas fa-times-circle"></i>
                                        </button>
                                    </td>
                                </tr>
                                <tr>
                                    <td  class="vendorId">9</td>
                                    <td>Huetrap9</td>
                                    <!-- <td>Address</td>
                                    <td>93562 72266</td>
                                    <td>huetrap@gmail.com</td>
                                    <td>9012 1123 7890</td>
                                    <td>
                                        <span class="status-text">ACTIVE</span>
                                        <select class="form-select status-select" style="display: none;">
                                            <option value="ACTIVE" selected>ACTIVE</option>
                                            <option value="BLOCKED">BLOCKED</option>
                                            <option value="NOT-VERIFIED">NOT-VERIFIED</option>
                                        </select>
                                    </td>
                                    <td class="d-flex justify-content-center">
                                     <button class="btn btn-success rounded-pill btn-sm mt-2 mx-1 save-btn">
                                            <i class="fas fa-save"></i>
                                        </button>
                                        <button class="btn btn-primary btn-sm edit-btn rounded-pill mt-2 mx-1">
                                            <i class="bi bi-pencil-square"></i>
                                        </button>
                                        <button class="btn btn-danger rounded-pill btn-sm mt-2 mx-1 del-btn">
                                            <i class="bi bi-trash3-fill"></i>
                                        </button>
                                        <button class="btn btn-secondary rounded-pill btn-sm mt-2 mx-1"
                                            onclick="viewVendorDetail(new Vendor('Huetrap9','1/15, P.V.R. Street, Meenampakkam, Chennai - 600028.',9356272266,'huetrap@gmail.com','9012 1123 7890','ACTIVE'))">
                                            <i class="bi bi-eye-fill"></i>
                                        </button>
                                       
                                        <button type="button"
                                            class="btn btn-dark rounded-pill btn-sm mt-2 mx-1 cancel-btn">
                                            <i class="fas fa-times-circle"></i>
                                        </button>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="vendorId">10</td>
                                    <td>Fritzberg10</td>
                                    <!-- <td>Address</td>
                                    <td>91561 08461</td>
                                    <td>fritzberg@gmail.com</td>
                                    <td>9789 3456 7890</td>
                                    <td>
                                        <span class="status-text">NOT-VERIFIED</span>
                                        <select class="form-select status-select" style="display: none;">
                                            <option value="ACTIVE" selected>ACTIVE</option>
                                            <option value="BLOCKED">BLOCKED</option>
                                            <option value="NOT-VERIFIED">NOT-VERIFIED</option>
                                        </select>
                                    </td>
                                    <td class="d-flex justify-content-center">
                                    <button class="btn btn-success rounded-pill btn-sm mt-2 mx-1 save-btn">
                                            <i class="fas fa-save"></i>
                                        </button>
                                        <button class="btn btn-primary btn-sm edit-btn rounded-pill mt-2 mx-1">
                                            <i class="bi bi-pencil-square"></i>
                                        </button>
                                        <button class="btn btn-danger rounded-pill btn-sm mt-2 mx-1 del-btn">
                                            <i class="bi bi-trash3-fill"></i>
                                        </button>
                                        <button class="btn btn-secondary rounded-pill btn-sm mt-2 mx-1"
                                            onclick="viewVendorDetail(new Vendor('Fritzberg10','1/15, P.V.R. Street, Meenampakkam, Chennai - 600028.',9156108461,'fritzberg@gmail.com','9789 3456 7890','ACTIVE'))">
                                            <i class="bi bi-eye-fill"></i>
                                        </button>
                                        
                                        <button type="button"
                                            class="btn btn-dark rounded-pill btn-sm mt-2 mx-1 cancel-btn">
                                            <i class="fas fa-times-circle"></i>
                                        </button>
                                    </td>
                                </tr> -->
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="deleteModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="deleteModalLabel">Delete Booking</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <form action="SellerManagementEditController" method="get">
                <div class="modal-body">
                	<input type="hidden" class="vendorsId" name="vid" value="">
                	<input type="hidden" class="" name="vendor" value="DELETED">
                    <p>Are you sure you want to delete Vendor in S.no <span id="deleteVendorId" class="text-danger"></span>?</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                    <button type="submit" class="btn btn-danger" id="btn-confirm" data-bs-dismiss="modal">Delete</button>
                </div>
                </form>
            </div>
        </div>
    </div>
    <div class="modal" id="vendorModal">
        <div class="modal-dialog">
            <div class="modal-content">
                <!-- Modal Header -->
                <div class="modal-header justify-content-between">
                    <h4 class="modal-title">vendor Details</h4>
                    <button type="button" class="close" data-bs-dismiss="modal">
                        <i class="bi bi-x"></i>
                    </button>
                </div>
                <!-- Modal Body -->
                <div class="modal-body">
                    <div class="row">
                        <div class="col-md-6">
                            <h5>UserName:</h5>
                            <p id="vendoruserName">John</p>
                        </div>
                        <div class="col-md-6">
                            <h5>AadharNumber:</h5>
                            <p id="vendorAadharNumber">Doe</p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <h5>Email Id:</h5>
                            <p id="vendorEmailId"></p>
                        </div>
                        <div class="col-md-6">
                            <h5>Phone Number:</h5>
                            <p id="vendorMobileNumber">(555) 123-4567</p>
                        </div>

                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <h5>Address:</h5>
                            <p id="vendorAddress">1234 Elm Street, Springfield, IL, 62704</p>
                        </div>
                        <div class="col-md-6">
                            <h5>Account Status:</h5>
                            <p id="vendorAccountstatus">Active</p>
                        </div>
                    </div>

                   
                </div>
                <!-- Modal Footer -->
                <div class="modal-footer">
                    <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>

  

    <script>

class Vendor {
    constructor(username, address, mobileNumber, emailId, aadharNumber, accountStatus) {
        this.username = username;
        this.address = address;
        this.mobileNumber = mobileNumber;
        this.emailId = emailId;
        this.aadharNumber = aadharNumber;
        this.accountStatus = accountStatus;
    }
}

$(document).ready(function() {
    $('#vendor-table').DataTable({
    	"pageLength": 5,
      //disable sorting on last column
      "columnDefs": [
        { "orderable": false, "targets": 7 }
      ],
      language: {
        //customize pagination prev and next buttons: use arrows instead of words
        'paginate': {
          'previous': '<span class="fa fa-chevron-left"></span>',
          'next': '<span class="fa fa-chevron-right"></span>'
        },
        //customize number of elements to be displayed
        "lengthMenu": 'Display <select class="form-control input-sm">'+
        '<option value="5">5</option>'+
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



function viewVendorDetail(vendor) {

document.getElementById('vendoruserName').innerHTML = vendor.username;
document.getElementById('vendorAddress').innerHTML = vendor.address;
document.getElementById('vendorMobileNumber').innerHTML = vendor.mobileNumber;
document.getElementById('vendorEmailId').innerHTML = vendor.emailId;
document.getElementById('vendorAadharNumber').innerHTML = vendor.aadharNumber;
document.getElementById('vendorAccountstatus').innerHTML = vendor.accountStatus;

let viewModal = new bootstrap.Modal(document.getElementById('vendorModal'));
viewModal.show();
}
        document.querySelectorAll('.edit-btn').forEach(button => {
            button.addEventListener('click', function () {
                let row = this.closest('tr');
                row.querySelector('.status-text').style.display = 'none';
                row.querySelector('.status-select').style.display = 'block';
                row.querySelector('.edit-btn').style.display = 'none';
                row.querySelector('.save-btn').style.visibility = 'visible';
                row.querySelector('.cancel-btn').style.visibility = 'visible';
            });
        });

        document.querySelectorAll('.save-btn').forEach(button => {
            button.addEventListener('click', function () {
                let row = this.closest('tr');
                let statusSelect = row.querySelector('.status-select');
                let statusText = row.querySelector('.status-text');
                let cid = row.querySelector('.vendorId');
                statusText.textContent = statusSelect.value;
                statusText.style.display = 'block';
                statusSelect.style.display = 'none';
                row.querySelector('.edit-btn').style.display = 'inline-block';
                row.querySelector('.save-btn').style.visibility = 'hidden';
                row.querySelector('.cancel-btn').style.visibility = 'hidden';
                
                location.href = "${pageContext.request.contextPath}/SellerManagementEditController?vendor="+statusSelect.value+"&vid="+cid.textContent;
            });
        });

        document.querySelectorAll('.cancel-btn').forEach(button => {
            button.addEventListener('click', function () {
                let row = this.closest('tr');
                let statusSelect = row.querySelector('.status-select');
                let statusText = row.querySelector('.status-text');
                statusSelect.value = statusText.textContent;
                statusText.style.display = 'block';
                statusSelect.style.display = 'none';
                row.querySelector('.edit-btn').style.display = 'inline-block';
                row.querySelector('.save-btn').style.visibility = 'hidden';
                row.querySelector('.cancel-btn').style.visibility = 'hidden';
            });
        });

        document.querySelectorAll('.del-btn').forEach(button => {
            button.addEventListener('click', function () {
                let row = this.closest('tr');
                let id = row.querySelector('.vendorId').textContent;
                let status_id = row.querySelector('.status-id').textContent;
                document.getElementById('deleteVendorId').innerHTML = status_id;
                document.querySelector('.vendorsId').value = id;
                var deleteModal = new bootstrap.Modal(document.getElementById('deleteModal'));
                deleteModal.show();
                document.querySelector('#btn-confirm').addEventListener('click',function(){
                    row.remove();
                    
                });
                
            });
        });
        
        var filter_select = document.getElementById('status-filter');
        // console.log(filter_select);
         document.getElementById('status-filter').addEventListener('change',()=>{
         	console.log(filter_select.value);
         	filterData(filter_select.value);
         });
         
         function filterData(status){
         	document.querySelectorAll('tr').forEach(row=>{
         		let status_txt = row.getAttribute('data-filter');
         		row.style.display="";
         		if(status_txt!==null){
         		console.log("Inside filter : "+status_txt);
         		if(status!==status_txt && status!=="ALL"){
         				row.style.display="none";
         			}
         		
         		}
         	});
         }
        
        document.getElementById('export-pdf').addEventListener('click', function () {
            const { jsPDF } = window.jspdf;
            const doc = new jsPDF();

            doc.autoTable({ html: '#vendor-table' });

            doc.save('vendordata.pdf');
        });
        // Sidebar toggle functionality (if needed)
        // document.getElementById('nav-opration').addEventListener('click', function () {
        //     var sidebar = document.getElementById('sidebar');
        //     var mainContent = document.getElementById('main-content');
        //     sidebar.classList.toggle('sidebar-hidden');
        //     mainContent.classList.toggle('expanded-content');
        //     mainContent.classList.toggle('justify-content-center');
        // });
    </script>
</body>
</html>