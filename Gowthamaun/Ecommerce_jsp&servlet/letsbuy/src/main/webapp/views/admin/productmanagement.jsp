<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminstyles.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
	 <!-- Data Table CSS -->
	<link rel='stylesheet' href='https://cdn.datatables.net/1.13.5/css/dataTables.bootstrap5.min.css'>
	<script src='https://code.jquery.com/jquery-3.7.0.js'></script>
	<!-- Data Table JS -->
	<script src='https://cdn.datatables.net/1.13.5/js/jquery.dataTables.min.js'></script>
	<script src='https://cdn.datatables.net/responsive/2.1.0/js/dataTables.responsive.min.js'></script>
	<script src='https://cdn.datatables.net/1.13.5/js/dataTables.bootstrap5.min.js'></script>
	<!-- Data Table JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Product-Management</title>
    
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
                      <img class="img-fluid logo-img" src="${pageContext.request.contextPath}/images/logo.png" alt="MDB Logo"  />
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
                      <a class="nav-link pt-4 active" href="${pageContext.request.contextPath}/ProductManagementController">Product Management</a>
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
                                <div class="col-6">
                                    <h2>All Products</h2>
                                </div>
                                <div class="col-6 text-end">
                                    <!-- <button class="btn btn-lg btn-outline-success">
                                        Add <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus-circle-fill" viewBox="0 0 16 16">
                                            <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0M8.5 4.5a.5.5 0 0 0-1 0v3h-3a.5.5 0 0 0 0 1h3v3a.5.5 0 0 0 1 0v-3h3a.5.5 0 0 0 0-1h-3z"/>
                                          </svg>
                                    </button> -->
                                </div>

                            </div>
                        </div>
                         
                        <table class="table  table-bordered text-center" id="product-table">
                            <thead>
                                <tr>
                                    <th>S.No</th>
                                    <th style="display:none"></th>
                                    <th>Name</th>
                                    <!-- <th>Password</th> -->
                                    <th>Brand</th>
                                    <!-- <th>Specification</th> -->
                                
                                    
                                    <th>Price</th>
                                    <!-- <th>sub-category</th> -->
                                    <!-- <th>Category</th> -->
                                    <th>Product Status</th>
                                    <th>Vendor Name</th>
                                    <th>Verified-Status</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>
                             <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
                            <c:forEach var="product" items="${productList}" varStatus="status">
                                <tr>
                                	<td class="serial-id">${status.count}</td>
                                    <td  class="productId" style="display:none">${product.productId}</td>
                                    <td class="product-name">${product.productName}</td>
                                    <td class="prduct-brand">${product.brand}</td>
                                    <!-- <td>6GB RAM, 128GB Storage</td> -->
                                    
                                    <td class="product-price">&#8377;${product.productPrice}</td>
                                    <!-- <td>Smartphones</td> -->
                                    <!-- <td>Electronics</td> -->
                                    <td class="product-status">${product.productStatus}</td>
                                    <td class="vendor-name">${product.vendor.account.userName}</td>
                                    <td>
                                        <span class="status-text">${product.verificationStatus}</span>
                                        <select class="form-select status-select" style="display: none;">
                                            <option value="VERIFIED" selected>VERIFIED</option>
                                            <option value="BLOCKED">BLOCKED</option>
                                            <option value="NOT-VERIFIED">NOT-VERIFIED</option>
                                        </select>
                                    </td>
                                    <c:if test="${product.verificationStatus!='DELETED'}">
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
                                            onclick="viewProductDetail(new Product('${product.productName}','${product.brand}','${product.productPrice}','${product.productStatus}','${product.vendor.account.userName}','${product.subtitle }','${product.description}','${product.verificationStatus}','${product.subCategrory.category.categoryName}','${product.subCategrory.subCategoryName}'))">
                                            <i class="bi bi-eye-fill"></i>
                                        </button>
                                        
                                        <button type="button"
                                            class="btn btn-dark rounded-pill btn-sm mt-2 mx-1 cancel-btn">
                                            <i class="fas fa-times-circle"></i>
                                        </button>
                                    	</td>
                                    </c:if>
                                    <c:if test="${product.verificationStatus=='DELETED'}">
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
                                            onclick="viewProductDetail(new Product('${product.productName}','${product.brand}','${product.productPrice}','${product.productStatus}','${product.vendor.account.userName}','${product.subtitle }','${product.description}','${product.verificationStatus}','${product.subCategrory.category.categoryName}','${product.subCategrory.subCategoryName}'))">
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
                            <!--    <tr>
                                    <td  class="productId">002</td>
                                    <td>Laptop Pro</td>
                                    <td>Asus</td>
                                    <!-- <td>16GB RAM, 512GB SSD</td> 
                                    
                                    <td>$1299</td>
                                    <!-- <td>Laptops</td> 
                                    <!-- <td>Computers</td> 
                                    <td>In Stock</td>
                                    <td>Fritzberg10</td>
                                    <td>
                                        <span class="status-text">VERIFIED</span>
                                        <select class="form-select status-select" style="display: none;">
                                            <option value="ACTIVE" selected>VERIFIED</option>
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
                                            onclick="viewProductDetail(new Product('Laptop Pro','Asus','$1299','In Stock','Fritzberg10','A laptop best for performance.','16GB RAM, 512GB SSD','VERIFED','Electronics','Laptops'))">
                                            <i class="bi bi-eye-fill"></i>
                                        </button>
                                       
                                        <button type="button"
                                            class="btn btn-dark rounded-pill btn-sm mt-2 mx-1 cancel-btn">
                                            <i class="fas fa-times-circle"></i>
                                        </button>
                                    </td>
                                </tr>
                                <tr>
                                    <td  class="productId">003</td>
                                    <td>Wireless Earbuds</td>
                                    <td>Noise</td>
                                    <!-- <td>Bluetooth 5.0, Noise Cancelling</td> 
                                    
                                    <td>$199</td>
                                    <td>In Stock</td>
                                    <!-- <td>Audio</td>
                                    <td>Accessories</td> -->
                                    <!-- <td>Out of Stock</td>
                                    <td>Fritzberg10</td>
                                    <td>
                                        <span class="status-text">VERIFIED</span>
                                        <select class="form-select status-select" style="display: none;">
                                            <option value="ACTIVE" selected>VERIFIED</option>
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
                                            onclick="viewProductDetail(new Product('Wireless Earbuds','Noise','$199','Out of Stock','Fritzberg10','A earbuds which makes you feel the bass','Bluetooth 5.0, Noise Cancelling','VERIFED','Electronics','Audio'))">
                                            <i class="bi bi-eye-fill"></i>
                                        </button>
                                        
                                        <button type="button"
                                            class="btn btn-dark rounded-pill btn-sm mt-2 mx-1 cancel-btn">
                                            <i class="fas fa-times-circle"></i>
                                        </button>
                                    </td>
                                </tr>
                                <tr>
                                    <td  class="productId">004</td>
                                    <td>4K TV</td>
                                    <td>Sony</td>
                                    <!-- <td>55 inches, Smart TV</td> 
                                    
                                    <td>$999</td>
                                    <!-- <td>Televisions</td> -->
                                    <!-- <td>Electronics</td>
                                    <td>In Stock</td>
                                    <td>Highlander001</td>
                                    <td>
                                        <span class="status-text">VERIFIED</span>
                                        <select class="form-select status-select" style="display: none;">
                                            <option value="ACTIVE" selected>VERIFIED</option>
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
                                            onclick="viewProductDetail(new Product('4K TV','Sony','$999','In Stock','Highlander001','A 4k hd resolution TV.','55 inches, Smart TV','VERIFED','Electronics','Televisions'))">
                                            <i class="bi bi-eye-fill"></i>
                                        </button>
                                        
                                        <button type="button"
                                            class="btn btn-dark rounded-pill btn-sm mt-2 mx-1 cancel-btn">
                                            <i class="fas fa-times-circle"></i>
                                        </button>
                                    </td>
                                </tr>
                                <tr>
                                    <td  class="productId">005</td>
                                    <td>Gaming Laptop</td>
                                    <td>HP</td>
                                    <!-- <td>1TB Storage, 4K Gaming</td> 
                                    
                                    <td>$499</td>
                                    <!-- <td>Gaming</td> -->
                                    <!-- <td>Electronics</td> 
                                    <td>Pre-order</td>
                                    <td>UCB009</td>
                                    <td>
                                        <span class="status-text">VERIFIED</span>
                                        <select class="form-select status-select" style="display: none;">
                                            <option value="ACTIVE" selected>VERIFIED</option>
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
                                            onclick="viewProductDetail(new Product('Gaming Laptop','HP','$499','In Stock','UCB009','A Laptop which works faster.','1TB Storage, 4K Gaming','VERIFED','Electronics','Laptops'))">
                                            <i class="bi bi-eye-fill"></i>
                                        </button>
                                        
                                        <button type="button"
                                            class="btn btn-dark rounded-pill btn-sm mt-2 mx-1 cancel-btn">
                                            <i class="fas fa-times-circle"></i>
                                        </button>
                                    </td>
                                </tr>
                                <tr>
                                    <td  class="productId">006</td>
                                    <td>Smart Watch</td>
                                    <td>Puma</td>
                                    <!-- <td>Heart Rate Monitor, GPS</td>
                                    
                                    <td>$249</td>
                                    <!-- <td>Wearables</td> -->
                                    <!-- <td>Accessories</td> 
                                    <td>In Stock</td>
                                    <td>Puma10</td>
                                    <td>
                                        <span class="status-text">VERIFIED</span>
                                        <select class="form-select status-select" style="display: none;">
                                            <option value="ACTIVE" selected>VERIFIED</option>
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
                                            onclick="viewProductDetail(new Product('Smart Watch','Puma','$249','In Stock','Puma10','A smartwatch which tracks your health and productivity.','Heart Rate Monitor, GPS','VERIFED','Accessories','Smartwatches'))">
                                            <i class="bi bi-eye-fill"></i>
                                        </button>
                                        
                                        <button type="button"
                                            class="btn btn-dark rounded-pill btn-sm mt-2 mx-1 cancel-btn">
                                            <i class="fas fa-times-circle"></i>
                                        </button>
                                    </td>
                                </tr>
                                <tr>
                                    <td  class="productId">007</td>
                                    <td>Tablet Plus</td>
                                    <td>Dell</td>
                                    <!-- <td>10.5 inches, 64GB Storage</td> 
                                   
                                    <td>$499</td>
                                    <!-- <td>Tablets</td> -->
                                    <!-- <td>Computers</td> 
                                    <td>In Stock</td>
                                    <td>Huetrap9</td>
                                    <td>
                                        <span class="status-text">VERIFIED</span>
                                        <select class="form-select status-select" style="display: none;">
                                            <option value="ACTIVE" selected>VERIFIED</option>
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
                                            onclick="viewProductDetail(new Product('Tablet Plus','Dell','$499','In Stock','Huetrap9','A Tablet which keeps you entertained.','10.5 inches, 64GB Storage','VERIFED','Computers','Tablets'))">
                                            <i class="bi bi-eye-fill"></i>
                                        </button>
                                        
                                        <button type="button"
                                            class="btn btn-dark rounded-pill btn-sm mt-2 mx-1 cancel-btn">
                                            <i class="fas fa-times-circle"></i>
                                        </button>
                                    </td>
                                </tr>
                                <tr>
                                    <td  class="productId">008</td>
                                    <td>Bluetooth Speaker</td>
                                    <td>Boat</td>
                                    <!-- <td>Waterproof, 12-hour Battery</td>
                                    
                                    <td>$99</td>
                                    <!-- <td>Audio</td> -->
                                    <!-- <td>Accessories</td> 
                                    <td>In Stock</td>
                                    <td>UCB009</td>
                                    <td>
                                        <span class="status-text">NOT-VERIFIED</span>
                                        <select class="form-select status-select" style="display: none;">
                                            <option value="ACTIVE" selected>VERIFIED</option>
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
                                            onclick="viewProductDetail(new Product('Bluetooth Speaker','Boat','$99','In Stock','UCB009','A speaker which makes your home feel like Theater.','Waterproof, 12-hour Battery','VERIFED','Accessories','Audio'))">
                                            <i class="bi bi-eye-fill"></i>
                                        </button>
                                       
                                        <button type="button"
                                            class="btn btn-dark rounded-pill btn-sm mt-2 mx-1 cancel-btn">
                                            <i class="fas fa-times-circle"></i>
                                        </button>
                                    </td>
                                </tr>
                                <tr>
                                    <td  class="productId">009</td>
                                    <td>Digital Camera</td>
                                    <td>Canon</td>
                                    <!-- <td>24MP, 4K Video</td> 
                                    
                                    <td>$799</td>
                                    <!-- <td>Cameras</td> -->
                                    <!-- <td>Photography</td> 
                                    <td>In Stock</td>
                                    <td>UCB009</td>
                                    <td>
                                        <span class="status-text">VERIFIED</span>
                                        <select class="form-select status-select" style="display: none;">
                                            <option value="ACTIVE" selected>VERIFIED</option>
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
                                            onclick="viewProductDetail(new Product('Digital Camera','Canon','$799','In Stock','UCB009','A camera is an optical device that records images.','24MP, 4K Video','VERIFED','Photography','Cameras'))">
                                            <i class="bi bi-eye-fill"></i>
                                        </button>
                                        
                                        <button type="button"
                                            class="btn btn-dark rounded-pill btn-sm mt-2 mx-1 cancel-btn">
                                            <i class="fas fa-times-circle"></i>
                                        </button>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="productId">010</td>
                                    <td>Router Max</td>
                                    <td>BrandJ</td>
                                     <td>Dual Band, 1Gbps</td>
                                    
                                    <td>$149</td>
                                     <td>Networking</td>
                                     <td>Computers</td> 
                                    <td>In Stock</td>
                                    <td>Huetrap9</td>
                                    <td>
                                        <span class="status-text">VERIFIED</span>
                                        <select class="form-select status-select" style="display: none;">
                                            <option value="ACTIVE" selected>VERIFIED</option>
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
    <div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="deleteModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="deleteModalLabel">Delete Booking</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <form action="${pageContext.request.contextPath}/ProductManagementDeleteController">
                <div class="modal-body">
                	<input type="hidden" class="productsId" name="pId" value="">
                    <p>Are you sure you want to delete Product with S.no <span id="deleteProductId" class="text-danger"></span>?</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                    <button type="submit" class="btn btn-danger" id="btn-confirm" data-bs-dismiss="modal">Delete</button>
                </div>
                </form>
            </div>
        </div>
    </div>
    <div class="modal" id="productModal">
        <div class="modal-dialog">
            <div class="modal-content">
                <!-- Modal Header -->
                <div class="modal-header justify-content-between">
                    <h4 class="modal-title">product Details</h4>
                    <button type="button" class="close" data-bs-dismiss="modal">
                        <i class="bi bi-x"></i>
                    </button>
                </div>
                <!-- Modal Body -->
                <div class="modal-body">
                    <div class="row">
                        <div class="col-md-6">
                            <h5>Product Name:</h5>
                            <p id="productName">John</p>
                        </div>
                        <div class="col-md-6">
                            <h5>Product Brand:</h5>
                            <p id="productBrand">Doe</p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <h5>Product Price:</h5>
                            <p id="productPrice"></p>
                        </div>
                        <div class="col-md-6">
                            <h5>Stock Status:</h5>
                            <p id="productStockStatus">(555) 123-4567</p>
                        </div>

                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <h5>Vendor Name:</h5>
                            <p id="productVendorName">1234 Elm Street, Springfield, IL, 62704</p>
                        </div>
                        <div class="col-md-6">
                            <h5>Description:</h5>
                            <p id="productDescription">Active</p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <h5>Specification:</h5>
                            <p id="productSpecification">1234 Elm Street, Springfield, IL, 62704</p>
                        </div>
                        <div class="col-md-6">
                            <h5>Verified Status:</h5>
                            <p id="productVerifiedStatus">Active</p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <h5>Category Name:</h5>
                            <p id="productCategoryName">1234 Elm Street, Springfield, IL, 62704</p>
                        </div>
                        <div class="col-md-6">
                            <h5>Sub-Category Name:</h5>
                            <p id="productSubCategoryName">Active</p>
                        </div>
                    </div>
                    

                    <!-- <div class="row">
                        <div class="col-md-6">
                            <h5>Account Status:</h5>
                            <p id="cusAccountstatus">Active</p>
                        </div>
                        <div class="col-md-6">
                            <h5>Gender:</h5>
                            <p id="cusGender">Male</p>
                        </div>
                    </div> -->
                </div>
                <!-- Modal Footer -->
                <div class="modal-footer">
                    <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>

    <script>
        class Product {
            constructor(name, brand, price, stockStatus, vendorName,description,specification, verifiedStatus,categoryName,subCategoryName) {
                this.name = name;
                this.brand = brand;
                this.price = price;
                this.stockStatus = stockStatus;
                this.vendorName = vendorName;
                this.description = description;
                this.specification = specification;
                this.verifiedStatus = verifiedStatus;
                this.categoryName = categoryName;
                this.subCategoryName = subCategoryName;
             }
        }
        
        
        $(document).ready(function() {
            $('#product-table').DataTable({
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


        function viewProductDetail(product) {

            document.getElementById('productName').innerHTML = product.name;
            document.getElementById('productBrand').innerHTML = product.brand;
            document.getElementById('productPrice').innerHTML = product.price;
            document.getElementById('productStockStatus').innerHTML = product.stockStatus;
            document.getElementById('productVendorName').innerHTML = product.vendorName;
            document.getElementById('productDescription').innerHTML = product.description;
            document.getElementById('productSpecification').innerHTML = product.specification;
            document.getElementById('productVerifiedStatus').innerHTML = product.verifiedStatus;
            document.getElementById('productCategoryName').innerHTML = product.categoryName;
            document.getElementById('productSubCategoryName').innerHTML = product.subCategoryName.toUpperCase();

            let viewModal = new bootstrap.Modal(document.getElementById('productModal'));
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
                statusText.textContent = statusSelect.value;
                let pid = row.querySelector('.productId');
                statusText.style.display = 'block';
                statusSelect.style.display = 'none';
                row.querySelector('.edit-btn').style.display = 'inline-block';
                row.querySelector('.save-btn').style.visibility = 'hidden';
                row.querySelector('.cancel-btn').style.visibility = 'hidden';
                
                location.href = "${pageContext.request.contextPath}/ProductManagementEditController?status="+statusSelect.value+"&pId="+pid.textContent;
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
                let id = row.querySelector('.productId');
                let status_id = row.querySelector('.serial-id');
                console.log(status_id);
                document.getElementById('deleteProductId').innerHTML = status_id.textContent;
               	document.querySelector('.productsId').value = id.textContent;
                var deleteModal = new bootstrap.Modal(document.getElementById('deleteModal'));
                deleteModal.show();
                document.querySelector('#btn-confirm').addEventListener('click',function(){
                	
                    row.remove();
                });
                
            });
        });
        // document.getElementById('nav-opration').addEventListener('click', function () {
        //     var sidebar = document.getElementById('sidebar');
        //     var mainContent = document.getElementById('main-content');
        //     sidebar.classList.toggle('sidebar-hidden');
        //     mainContent.classList.toggle('expanded-content');
        //     // mainContent.classList.toggle('justify-content-center');
        // });
    </script>
</body>
</html>