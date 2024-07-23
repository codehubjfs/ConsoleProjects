<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminstyles.css">
   
    <!-- Data Table CSS -->
	<link rel='stylesheet' href='https://cdn.datatables.net/1.13.5/css/dataTables.bootstrap5.min.css'>
	<script src='https://code.jquery.com/jquery-3.7.0.js'></script>
	<!-- Data Table JS -->
	<script src='https://cdn.datatables.net/1.13.5/js/jquery.dataTables.min.js'></script>
	<script src='https://cdn.datatables.net/responsive/2.1.0/js/dataTables.responsive.min.js'></script>
	<script src='https://cdn.datatables.net/1.13.5/js/dataTables.bootstrap5.min.js'></script>
	<!-- Data Table JS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>SubCategory-Management</title>
    
</head>
<body style="width:100vw">
<%
response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
	if(request.getSession().getAttribute("admin")==null){
		response.sendRedirect("index.jsp");
	}
%>
    <div class="container">
        <div class="row">
            <nav class="col-md-2 col-2  sidebar position-fixed pt-0 px-0" id="sidebar">
                <div class="pt-0 px-0">
                  <div class="logo-divv">
                    <a class="navbar-brand" href="#">
                      <img class="img-fluid logo-img" src="${pageContext.request.contextPath}/images/logo.png" alt="MDB Logo" loading="lazy" />
                    </a>
                  </div>
                  <div class="user-pic d-flex flex-column  justify-content-center align-items-center">
                    <div>
                      <img src="${pageContext.request.contextPath}/images/avatar.png" class="img-fluid rounded-pill" width="60" height="50" alt="">
                    <a data-toggle="collapse" data-bs-toggle="collapse" href="#profileMenu" role="button" aria-expanded="true" aria-controls="profileMenu">
                      <span class="px-1">${sessionScope.admin.getUserName()} <i class="bi bi-caret-down-fill"></i></span></a>
                    </div>
                      <div class="collapse collapse-menu mt-2" id="profileMenu">
                        <div class="card card-body" id="cards-bodyy">
                            <div class="row pt-2 pb-2 px-1 menuss">
                                <a href="#" class="dropdown-item">Profile</a>
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
                      <a class="nav-link pt-4" href="${pageContext.request.contextPath}/AdminDashBoardController">Dashboard</a>
                    </li>
                    <li class="nav-item side-barnav">
                      <a class="nav-link pt-4" href="${pageContext.request.contextPath}/CustomerManagementController">Customer Management</a>
                    </li>
                    <li class="nav-item side-barnav">
                      <a class="nav-link  pt-4" href="${pageContext.request.contextPath}/SellerManagementController">Vendor Management</a>
                    </li>
                    <li class="nav-item side-barnav">
                      <a class="nav-link pt-4" href="${pageContext.request.contextPath}/ProductManagementController">Product Management</a>
                    </li>
                    <li class="nav-item side-barnav">
                      <a class="nav-link pt-4" href="${pageContext.request.contextPath}/CategoryManagementController">Category Management</a>
                    </li>
                    <li class="nav-item side-barnav active">
                      <a class="nav-link pt-4 active" href="${pageContext.request.contextPath}/SubCategoryManagementController">Sub-Category Management</a>
                    </li>
                    <li class="nav-item side-barnav">
                      <a class="nav-link pt-4" href="${pageContext.request.contextPath}/AdminManagementController">Admin Management</a>
                  </li>
                  
                </div>
                </div>
              </nav>
            <div class="col-md-10  table-responsive body-block-table-sub">
                <div class="content">
                    <div class="container">
                        <div class="container mt-4 mb-4">
                            <div class="row justify-content-between">
                                <div class="col-7">
                                    <h2>All Sub-Category</h2>
                                </div>
                                <div class="col-4 text-end">
                                    <button class="btn btn-lg btn-outline-success" onclick="addDataModal()">
                                        Add <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus-circle-fill" viewBox="0 0 16 16">
                                            <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0M8.5 4.5a.5.5 0 0 0-1 0v3h-3a.5.5 0 0 0 0 1h3v3a.5.5 0 0 0 1 0v-3h3a.5.5 0 0 0 0-1h-3z"/>
                                          </svg>
                                    </button>
                                </div>

                            </div>
                        </div>
                        <div class="table-responsive">
                            <table class="table  table-bordered text-center" id="sub-category-table">
                                <thead>
                                    <tr>
                                        <th>S.No</th>
                                        <th style="display:none"></th>
                                        <th>Sub-Category Name</th>
                                        <th>Category Name</th>
                                        <th>Status</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
                            <c:forEach var="subcategory" items="${subCategoryList}" varStatus="status">
                            
                                    <tr>
                                   
                                    	<td class="status-id">${status.count}</td>
                                        <td class="subCategoryId" style="display:none">${subcategory.subCategoryId}</td>
                                        <td class="subcategory-name">${subcategory.subCategoryName}</td>
                                         <form action="${pageContext.request.contextPath}/SubCategoryManagementEditController" method="post">
                                        <input type="hidden" name="subcategory-id" value="${subcategory.subCategoryId}">
                                        <td class="category-name">${subcategory.category.categoryName}</td>
                                        <td>
                                            <span class="status-text">${subcategory.verificationStatus}</span>
                                            <select class="form-select status-select" name="v-status" style="display: none;">
                                                <option value="VERIFED" selected>VERIFIED</option>
                                                <option value="NOT-VERIFIED">NOT-VERIFIED</option>
                                            </select>
                                        </td>
                                        <c:if test="${subcategory.verificationStatus!='DELETED'}">
                                        	<td class="d-flex justify-content-center">
                                            <button type="submit" class="btn btn-success rounded-pill btn-sm mt-2 mx-1 save-btn">
                                                <i class="fas fa-save"></i>
                                            </button>
                                          </form>
                                            <button class="btn btn-primary btn-sm edit-btn rounded-pill mt-2 mx-1">
                                                <i class="bi bi-pencil-square"></i>
                                            </button>
                                            <button class="btn btn-danger rounded-pill btn-sm mt-2 mx-1 del-btn">
                                                <i class="bi bi-trash3-fill"></i>
                                            </button>
                                            <!-- <button class="btn btn-secondary rounded-pill btn-sm mt-2 mx-1"
                                                onclick="viewProductDetail(new Product('Router Max','BrandJ','$149','In Stock','Huetrap9','A router is a network device that connects multiple networks.','Dual Band, 1Gbps','VERIFED','Computers','Networking'))">
                                                <i class="bi bi-eye-fill"></i>
                                            </button> -->
                                            
                                            <button type="button"
                                                class="btn btn-dark rounded-pill btn-sm mt-2 mx-1 cancel-btn">
                                                <i class="fas fa-times-circle"></i>
                                            </button>
                                        </td>
                                        
                                        </c:if>
                                        <c:if test="${subcategory.verificationStatus=='DELETED'}">
                                        	<td class="d-flex justify-content-center">
                                            <button class="btn btn-success rounded-pill btn-sm mt-2 mx-1 save-btn" disabled>
                                                <i class="fas fa-save"></i>
                                            </button>
                                          </form>
                                            <button class="btn btn-primary btn-sm edit-btn rounded-pill mt-2 mx-1" disabled>
                                                <i class="bi bi-pencil-square"></i>
                                            </button>
                                            <button class="btn btn-danger rounded-pill btn-sm mt-2 mx-1 del-btn" disabled>
                                                <i class="bi bi-trash3-fill"></i>
                                            </button>
                                            <!-- <button class="btn btn-secondary rounded-pill btn-sm mt-2 mx-1"
                                                onclick="viewProductDetail(new Product('Router Max','BrandJ','$149','In Stock','Huetrap9','A router is a network device that connects multiple networks.','Dual Band, 1Gbps','VERIFED','Computers','Networking'))">
                                                <i class="bi bi-eye-fill"></i>
                                            </button> -->
                                            
                                            <button type="button"
                                                class="btn btn-dark rounded-pill btn-sm mt-2 mx-1 cancel-btn" disabled>
                                                <i class="fas fa-times-circle"></i>
                                            </button>
                                        </td>
                                        
                                        </c:if>
                                        
                                    </tr>
                                    </c:forEach>
                               <!--      <tr>
                                        <td class="subCategoryId">002</td>
                                        <td>Laptops</td>
                                        <td>Electronics</td>
                                        <td>
                                            <span class="status-text">NOT-VERIFED</span>
                                            <select class="form-select status-select" style="display: none;">
                                                <option value="VERIFED" selected>VERIFIED</option>
                                                <option value="DELETED">DELETED</option>
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
                                            <!-- <button class="btn btn-secondary rounded-pill btn-sm mt-2 mx-1"
                                                onclick="viewProductDetail(new Product('Router Max','BrandJ','$149','In Stock','Huetrap9','A router is a network device that connects multiple networks.','Dual Band, 1Gbps','VERIFED','Computers','Networking'))">
                                                <i class="bi bi-eye-fill"></i>
                                            </button> 
                                            
                                            <button type="button"
                                                class="btn btn-dark rounded-pill btn-sm mt-2 mx-1 cancel-btn">
                                                <i class="fas fa-times-circle"></i>
                                            </button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="subCategoryId">003</td>
                                        <td>Headphones</td>
                                        <td>Electronics</td>
                                        <td>
                                            <span class="status-text">VERIFED</span>
                                            <select class="form-select status-select" style="display: none;">
                                                <option value="VERIFED" selected>VERIFIED</option>
                                                <option value="DELETED">DELETED</option>
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
                                            <!-- <button class="btn btn-secondary rounded-pill btn-sm mt-2 mx-1"
                                                onclick="viewProductDetail(new Product('Router Max','BrandJ','$149','In Stock','Huetrap9','A router is a network device that connects multiple networks.','Dual Band, 1Gbps','VERIFED','Computers','Networking'))">
                                                <i class="bi bi-eye-fill"></i>
                                            </button> 
                                            
                                            <button type="button"
                                                class="btn btn-dark rounded-pill btn-sm mt-2 mx-1 cancel-btn">
                                                <i class="fas fa-times-circle"></i>
                                            </button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="subCategoryId">004</td>
                                        <td>Tablets</td>
                                        <td>Electronics</td>
                                        <td>
                                            <span class="status-text">VERIFED</span>
                                            <select class="form-select status-select" style="display: none;">
                                                <option value="VERIFED" selected>VERIFIED</option>
                                                <option value="DELETED">DELETED</option>
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
                                            <!-- <button class="btn btn-secondary rounded-pill btn-sm mt-2 mx-1"
                                                onclick="viewProductDetail(new Product('Router Max','BrandJ','$149','In Stock','Huetrap9','A router is a network device that connects multiple networks.','Dual Band, 1Gbps','VERIFED','Computers','Networking'))">
                                                <i class="bi bi-eye-fill"></i>
                                            </button> 
                                            
                                            <button type="button"
                                                class="btn btn-dark rounded-pill btn-sm mt-2 mx-1 cancel-btn">
                                                <i class="fas fa-times-circle"></i>
                                            </button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="subCategoryId">005</td>
                                        <td>Printers</td>
                                        <td>Electronics</td>
                                        <td>
                                            <span class="status-text">NOT-VERIFED</span>
                                            <select class="form-select status-select" style="display: none;">
                                                <option value="VERIFED" selected>VERIFIED</option>
                                                <option value="DELETED">DELETED</option>
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
                                            <!-- <button class="btn btn-secondary rounded-pill btn-sm mt-2 mx-1"
                                                onclick="viewProductDetail(new Product('Router Max','BrandJ','$149','In Stock','Huetrap9','A router is a network device that connects multiple networks.','Dual Band, 1Gbps','VERIFED','Computers','Networking'))">
                                                <i class="bi bi-eye-fill"></i>
                                            </button> 
                                            
                                            <button type="button"
                                                class="btn btn-dark rounded-pill btn-sm mt-2 mx-1 cancel-btn">
                                                <i class="fas fa-times-circle"></i>
                                            </button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="subCategoryId">006</td>
                                        <td>Cameras</td>
                                        <td>Electronics</td>
                                        <td>
                                            <span class="status-text">VERIFED</span>
                                            <select class="form-select status-select" style="display: none;">
                                                <option value="VERIFED" selected>VERIFIED</option>
                                                <option value="DELETED">DELETED</option>
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
                                            <!-- <button class="btn btn-secondary rounded-pill btn-sm mt-2 mx-1"
                                                onclick="viewProductDetail(new Product('Router Max','BrandJ','$149','In Stock','Huetrap9','A router is a network device that connects multiple networks.','Dual Band, 1Gbps','VERIFED','Computers','Networking'))">
                                                <i class="bi bi-eye-fill"></i>
                                            </button>
                                            
                                            <button type="button"
                                                class="btn btn-dark rounded-pill btn-sm mt-2 mx-1 cancel-btn">
                                                <i class="fas fa-times-circle"></i>
                                            </button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="subCategoryId">007</td>
                                        <td>Smartwatches</td>
                                        <td>Electronics</td>
                                        <td>
                                            <span class="status-text">VERIFED</span>
                                            <select class="form-select status-select" style="display: none;">
                                                <option value="VERIFED" selected>VERIFIED</option>
                                                <option value="DELETED">DELETED</option>
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
                                            <!-- <button class="btn btn-secondary rounded-pill btn-sm mt-2 mx-1"
                                                onclick="viewProductDetail(new Product('Router Max','BrandJ','$149','In Stock','Huetrap9','A router is a network device that connects multiple networks.','Dual Band, 1Gbps','VERIFED','Computers','Networking'))">
                                                <i class="bi bi-eye-fill"></i>
                                            </button> 
                                            
                                            <button type="button"
                                                class="btn btn-dark rounded-pill btn-sm mt-2 mx-1 cancel-btn">
                                                <i class="fas fa-times-circle"></i>
                                            </button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="subCategoryId">008</td>
                                        <td>Monitors</td>
                                        <td>Electronics</td>
                                        <td>
                                            <span class="status-text">NOT-VERIFIED</span>
                                            <select class="form-select status-select" style="display: none;">
                                                <option value="VERIFED" selected>VERIFIED</option>
                                                <option value="DELETED">DELETED</option>
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
                                            <!-- <button class="btn btn-secondary rounded-pill btn-sm mt-2 mx-1"
                                                onclick="viewProductDetail(new Product('Router Max','BrandJ','$149','In Stock','Huetrap9','A router is a network device that connects multiple networks.','Dual Band, 1Gbps','VERIFED','Computers','Networking'))">
                                                <i class="bi bi-eye-fill"></i>
                                            </button> 
                                            
                                            <button type="button"
                                                class="btn btn-dark rounded-pill btn-sm mt-2 mx-1 cancel-btn">
                                                <i class="fas fa-times-circle"></i>
                                            </button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="subCategoryId">009</td>
                                        <td>Audio</td>
                                        <td>Electronics</td>
                                        <td>
                                            <span class="status-text">VERIFED</span>
                                            <select class="form-select status-select" style="display: none;">
                                                <option value="VERIFED" selected>VERIFIED</option>
                                                <option value="DELETED">DELETED</option>
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
                                            <!-- <button class="btn btn-secondary rounded-pill btn-sm mt-2 mx-1"
                                                onclick="viewProductDetail(new Product('Router Max','BrandJ','$149','In Stock','Huetrap9','A router is a network device that connects multiple networks.','Dual Band, 1Gbps','VERIFED','Computers','Networking'))">
                                                <i class="bi bi-eye-fill"></i>
                                            </button> 
                                            
                                            <button type="button"
                                                class="btn btn-dark rounded-pill btn-sm mt-2 mx-1 cancel-btn">
                                                <i class="fas fa-times-circle"></i>
                                            </button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="subCategoryId">010</td>
                                        <td>Software</td>
                                        <td>Electronics</td>
                                        <td>
                                            <span class="status-text">DELETED</span>
                                            <select class="form-select status-select" style="display: none;">
                                                <option value="VERIFED" selected>VERIFIED</option>
                                                <option value="DELETED">DELETED</option>
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
                                            <!-- <button class="btn btn-secondary rounded-pill btn-sm mt-2 mx-1"
                                                onclick="viewProductDetail(new Product('Router Max','BrandJ','$149','In Stock','Huetrap9','A router is a network device that connects multiple networks.','Dual Band, 1Gbps','VERIFED','Computers','Networking'))">
                                                <i class="bi bi-eye-fill"></i>
                                            </button>
                                            
                                            <button type="button"
                                                class="btn btn-dark rounded-pill btn-sm mt-2 mx-1 cancel-btn">
                                                <i class="fas fa-times-circle"></i>
                                            </button>
                                        </td>
                                    </tr>  -->
                                </tbody>
                            
                        </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Edit Modal -->
    <div class="modal fade" id="editModal" tabindex="-1" aria-labelledby="editModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="editModalLabel">Edit Sub-Category</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form id="editForm">
                        
                        <div class="mb-3">
                            <label for="editCustomerName" class="form-label">Sub-Category Name</label>
                            <input type="text" class="form-control" id="editCustomerName">
                        </div>

                        <div class="dropdown mb-3 d-flex">
                            <p>Category Name</p>
                            <button class="btn btn-secondary dropdown-toggle mx-1 btn-sm text-center" type="button" id="dropdownMenuButton" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                              
                            </button>
                            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                              <a class="dropdown-item" href="#">Electronics</a>
                              <a class="dropdown-item" href="#">Accessories</a>
                              <a class="dropdown-item" href="#">gaming</a>
                              <a class="dropdown-item" href="#">Wearables</a>
                              <a class="dropdown-item" href="#">Home Appliances</a>
                              <a class="dropdown-item" href="#">Health & Beauty</a>
                              <a class="dropdown-item" href="#">Fashion</a>
                              <a class="dropdown-item" href="#">Sports</a>
                              <a class="dropdown-item" href="#">Books</a>
                              <a class="dropdown-item" href="#">Automotive</a> 
                            </div>
                          </div>
                        
                        <div class="mb-3">
                            <label for="editStatus" class="form-label">Sub-Category Status</label>
                            <input type="text" class="form-control" id="editStatus">
                        </div>
                        <button type="button" class="btn btn-primary" data-bs-dismiss="modal">Save changes</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- View Modal -->
    <div class="modal fade" id="viewModal" tabindex="-1" aria-labelledby="viewModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="viewModalLabel">View Sub-Category</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <p><strong>Sub-Category ID:</strong> <span id="viewSubCategoryId"></span></p>
                    <p><strong>Sub-Category Name:</strong> <span id="viewSubsubCategoryName"></span></p>
                    <p><strong>Category Name:</strong> <span id="viewsubCategoryName"></span></p>
                    <p><strong>Status:</strong> <span id="viewStatus"></span></p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>

    <!-- Delete Modal -->
    <div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="deleteModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="deleteModalLabel">Delete Booking</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <form action="${pageContext.request.contextPath}/SubCategoryManagementDeleteController" method="post">
                <div class="modal-body">
                	<input type="hidden" id="cId" name="subcatId" value="">
                    <p>Are you sure you want to delete subcategory ID <span id="deleteSubCategoryId" class="text-danger"></span>?</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                    <button type="submit" class="btn btn-danger" id="btn-confirm" data-bs-dismiss="modal">Delete</button>
                </div>
                </form>
            </div>
        </div>
    </div>

    <!-- Add Modal -->
     <div class="modal fade" id="addModal" tabindex="-1" aria-labelledby="addModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="addModalLabel">Add Sub-Category</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                 <form action="${pageContext.request.contextPath}/SubCategoryManagementAddController" method="post" id="addForm">
                <div class="modal-body">
                   
                        <div class="mb-3">
                            <label for="addSubsubCategoryName" class="form-label">SubCategory Name</label>
                            <span class="text-primary">Note : Length should be between 4 to 20</span>
                            <input type="text" class="form-control" name="sub-category-input" id="addSubCategoryName" oninput="isSubCategoryNameValid()">
                            <span id="message"></span>
                        </div>
                        <div class="dropdown mb-3 d-flex">
                            <p>Category Name</p>
                            <select class="form-select status-select" name="category-name">
                            
                            <c:forEach var="category" items="${categoryList}">
                            	
                                <option value="${category.categoryId}" selected>${category.categoryName}</option>
                           </c:forEach>
                            <!--    <option value="Accessories">Accessories</option>
                                <option value="gaming">gaming</option>
                                <option value="Wearables">Wearables</option>
                                <option value="home Appliances">Home Appliances</option>
                                <option value="Health & Beauty">Health & Beauty</option>
                                <option value="Fashion">Fashion</option>
                                <option value="Sport">Sports</option>
                                <option value="Books">Books</option>
                                <option value="Automotive">Automotive</option>  --> 
                            </select>
                            </div>
                            
                    
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-success disabled" data-bs-dismiss="modal" id="subCategory-add">add sub-Catgeory</button>
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                </div>
                </form>
            </div>
        </div>
	
     </div>
     <script type="text/javascript" src="${pageContext.request.contextPath}/js/script.js"></script>
    <script>
       /* function isSubCategoryNameValid() {
        var subCategoryName = document.getElementById('addSubCategoryName').value;
        console.log(subCategoryName);

        let match = /^[a-zA-Z]{4,}$/; // Updated regex to ensure it matches the full string

        // Cache the DOM elements
        var btn = document.getElementById('subCategory-add');
        var msg = document.getElementById('message');

        if (match.test(subCategoryName)) {
            msg.classList.remove('text-danger');
            msg.classList.add('text-success');
            msg.innerHTML = 'Valid Category Name';
            btn.classList.remove('disabled');
        } else {
            msg.classList.remove('text-success');
            msg.classList.add('text-danger');
            msg.innerHTML = 'Invalid Category Name (name can have only alphabets) and length between 4 to 20';
            btn.classList.add('disabled');
        }
        
       
} */

function isSubCategoryNameValid() {
    var subCategoryName = document.getElementById('addSubCategoryName').value.trim().toUpperCase();
    console.log(subCategoryName);

    // Updated regex to ensure it matches the full string
    let match = /^[a-zA-Z]{4,20}$/;
	let alphabet = /^[a-zA-Z]+$/;
	let lengthCheck = /^.{4,20}$/;
    // Cache the DOM elements
    var btn = document.getElementById('subCategory-add');
    var msg = document.getElementById('message');

    // Get all subcategory names from the table
    const tableSubCategoryNames = Array.from(document.querySelectorAll('.subcategory-name'))
                                       .map(td => td.textContent.trim().toUpperCase());

    if (!alphabet.test(subCategoryName)) {
        msg.classList.remove('text-success');
        msg.classList.add('text-danger');
        msg.innerHTML = 'Invalid Category Name (name can have only alphabets)';
        btn.classList.add('disabled');
    }else if(!lengthCheck.test(subCategoryName)){
    	 msg.classList.remove('text-success');
         msg.classList.add('text-danger');
         msg.innerHTML = 'Invalid Category Name (Length must between 4 to 20)';
         btn.classList.add('disabled');
    	
    } else if (tableSubCategoryNames.includes(subCategoryName)) {
        msg.classList.remove('text-success');
        msg.classList.add('text-danger');
        msg.innerHTML = 'Subcategory name already exists!';
        btn.classList.add('disabled');
    } else {
        msg.classList.remove('text-danger');
        msg.classList.add('text-success');
        msg.innerHTML = 'Valid Category Name';
        btn.classList.remove('disabled');
    }
}
        
        $(document).ready(function() {
            $('#sub-category-table').DataTable({
            	"pageLength": 5,
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
                statusText.textContent = statusSelect.value;
                statusText.style.display = 'block';
                statusSelect.style.display = 'none';
                row.querySelector('.edit-btn').style.display = 'inline-block';
                row.querySelector('.save-btn').style.visibility = 'hidden';
                row.querySelector('.cancel-btn').style.visibility = 'hidden';
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
                document.getElementById('deleteSubCategoryId').innerHTML = row.querySelector('.subCategoryId').textContent;
                document.getElementById('cId').value = row.querySelector('.subCategoryId').textContent;
               /* document.getElementById('deleteCategoryId').innerHTML = row.querySelector('.categoryId').textContent; */
                var deleteModal = new bootstrap.Modal(document.getElementById('deleteModal'));
                deleteModal.show();
                document.querySelector('#btn-confirm').addEventListener('click',function(){
                    row.remove();
                });
                
            });
        });
       
    </script>
</body>
</html>
