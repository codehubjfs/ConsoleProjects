<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminstyles.css">
   <script type="text/javascript" src="${pageContext.request.contextPath}/js/script.js"></script>
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
    <title>Category-Management</title>
    
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
                      <a class="nav-link pt-4 active" href="${pageContext.request.contextPath}/CategoryManagementController">Category Management</a>
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
            <div class="col-md-10  body-block-table-customer">
                <div class="content justify-content-center">
                    <div class="container table-responsive">
                        <div class="container mt-4 mb-4">
                            <div class="row justify-content-between">
                                <div class="col-md-7 col-sm-4">
                                    <h2>All Categories</h2>
                                </div>
                                <div class="col-md-4 col-sm-4 text-end">
                                    <button class="btn btn-lg btn-outline-success" onclick="addDataModal()">
                                        Add <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus-circle-fill" viewBox="0 0 16 16">
                                            <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0M8.5 4.5a.5.5 0 0 0-1 0v3h-3a.5.5 0 0 0 0 1h3v3a.5.5 0 0 0 1 0v-3h3a.5.5 0 0 0 0-1h-3z"/>
                                          </svg>
                                    </button>
                                </div>

                            </div>
                        </div>
                        
                            <table class="table  table-bordered text-center" id="category-table">
                                <thead>
                                    <tr>
                                        <th>S.No</th>
                                        <th style="display:none"></th>
                                        <th>Name</th>
                                        <th>Category-Status</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
                            <c:forEach var="category" items="${categoryList}" varStatus="status">
                            	
                                    <tr>
                                    	<td>${status.count}</td>
                                        <td class="categoryId border-left" style="display:none">${category.categoryId}</td>
                                        <td class="category-name">${category.categoryName}</td>
                                        <form action="${pageContext.request.contextPath}/CategoryManagementEditController" method="post">
                                        <input type="hidden" name="category-id" value="${category.categoryId}">
                                        <td>
                                            <span class="status-text">${category.verificationStatus}</span>
                                            <select class="form-select status-select" name="v-status" style="display: none;">
                                                <option value="VERIFIED" selected>VERIFIED</option>                                             
                                                <option value="NOT-VERIFIED">NOT-VERIFIED</option>
                                            </select>
                                        </td>
                                        <c:if test="${category.verificationStatus!='DELETED'}">
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
                                            <button type="button"
                                                class="btn btn-dark rounded-pill btn-sm mt-2 mx-1 cancel-btn">
                                                <i class="fas fa-times-circle"></i>
                                            </button>
                                        </td>
                                        
                                        </c:if>
                                        <c:if test="${category.verificationStatus=='DELETED'}">
                                        <td class="d-flex justify-content-center">
                                        	
                                            <button type="submit" class="btn btn-success rounded-pill btn-sm mt-2 mx-1 save-btn" disabled>
                                                <i class="fas fa-save"></i>
                                            </button>
                                   </form>
                                            <button class="btn btn-primary btn-sm edit-btn rounded-pill mt-2 mx-1" disabled>
                                                <i class="bi bi-pencil-square"></i>
                                            </button>
                                            <button class="btn btn-danger rounded-pill btn-sm mt-2 mx-1 del-btn" disabled>
                                                <i class="bi bi-trash3-fill"></i>
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
                                        <td class="categoryId">002</td>
                                        <td>Accessories</td>
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
                                        <td class="categoryId">003</td>
                                        <td>Gaming</td>
                                        <td>
                                            <span class="status-text">VERIFIED</span>
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
                                          
                                            <button type="button"
                                                class="btn btn-dark rounded-pill btn-sm mt-2 mx-1 cancel-btn">
                                                <i class="fas fa-times-circle"></i>
                                            </button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="categoryId">004</td>
                                        <td>Wearables</td>
                                        <td>
                                            <span class="status-text">VERIFIED</span>
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
                                           
                                            <button type="button"
                                                class="btn btn-dark rounded-pill btn-sm mt-2 mx-1 cancel-btn">
                                                <i class="fas fa-times-circle"></i>
                                            </button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="categoryId">005</td>
                                        <td>Home Appliances</td>
                                        <td>
                                            <span class="status-text">VERIFIED</span>
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
                                           
                                            <button type="button"
                                                class="btn btn-dark rounded-pill btn-sm mt-2 mx-1 cancel-btn">
                                                <i class="fas fa-times-circle"></i>
                                            </button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="categoryId">006</td>
                                        <td>Health & Beauty</td>
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
                                           
                                            <button type="button"
                                                class="btn btn-dark rounded-pill btn-sm mt-2 mx-1 cancel-btn">
                                                <i class="fas fa-times-circle"></i>
                                            </button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="categoryId">007</td>
                                        <td>Fashion</td>
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
                                                                                       
                                            <button type="button"
                                                class="btn btn-dark rounded-pill btn-sm mt-2 mx-1 cancel-btn">
                                                <i class="fas fa-times-circle"></i>
                                            </button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="categoryId">008</td>
                                        <td>Sports</td>
                                        <td>
                                            <span class="status-text">VERIFIED</span>
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
                                           
                                           
                                            <button type="button"
                                                class="btn btn-dark rounded-pill btn-sm mt-2 mx-1 cancel-btn">
                                                <i class="fas fa-times-circle"></i>
                                            </button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="categoryId">009</td>
                                        <td>Books</td>
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
                                    </tr>
                                    
                                    <tr>
                                        <td class="categoryId">010</td>
                                        <td>Automotive</td>
                                        <td>
                                            <span class="status-text">VERIFIED</span>
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
    <!-- Edit Modal -->
    <div class="modal fade" id="editModal" tabindex="-1" aria-labelledby="editModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="editModalLabel">Edit Category</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form id="editForm">
                        
                        <div class="mb-3">
                            <label for="editCustomerName" class="form-label">Category Name</label>
                            <input type="text" class="form-control" id="editCustomerName">
                        </div>
                        
                        <div class="mb-3">
                            <label for="editStatus" class="form-label">Category Status</label>
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
                    <h5 class="modal-title" id="viewModalLabel">View Category</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <p><strong>Category ID:</strong> <span id="viewCategoryId"></span></p>
                    <p><strong>Category Name:</strong> <span id="viewCategoryName"></span></p>
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
                <form action="${pageContext.request.contextPath}/CategoryManagementDeleteController" method="post">
                <div class="modal-body">
                
                	<input type="hidden" id="cId" name="catId" value="">
                    <p>Are you sure you want to delete Category <span id="deleteCategoryId" class="text-danger"></span>?</p>
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
                    <h5 class="modal-title" id="addModalLabel">Add Category</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <form action="${pageContext.request.contextPath}/CategoryManagementAddController" method="post" id="addForm">
                <div class="modal-body">
                    
                        <div class="mb-3">
                            <label for="addCategoryName" class="form-label">Category Name</label>
                            <span class="text-primary">Note : Length should be between 4 to 20</span>
                            <input type="text" class="form-control" name="catName" id="addCategoryName" oninput="isCategoryNameValid()">
                            <span id="message"></span>
                        </div>
                        
                        <!-- <div class="mb-3">
                            <label for="addCategoryStatus" class="form-label">Category Status</label>
                            <input type="text" class="form-control" id="addCategoryStatus">
                        </div> -->
                    
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-success disabled"  id="category-add" data-bs-dismiss="modal">add Catgeory</button>
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                </div>
                </form>
            </div>
        </div>
		
     </div>
    <script>

function isCategoryNameValid() {
    var categoryName = document.getElementById('addCategoryName').value;
    console.log(categoryName);

    let match = /^[a-zA-Z]{4,}$/; // Updated regex to ensure it matches the full string

    // Cache the DOM elements
    var btn = document.getElementById('category-add');
    var msg = document.getElementById('message');

    if (match.test(categoryName)) {
        msg.classList.remove('text-danger');
        msg.classList.add('text-success');
        msg.innerHTML = 'Valid Category Name';
        btn.classList.remove('disabled');
    } else {
        msg.classList.remove('text-success');
        msg.classList.add('text-danger');
        msg.innerHTML = 'Invalid Category Name (name can have only alphabets)';
        btn.classList.add('disabled');
    }
}

$(document).ready(function() {
    $('#category-table').DataTable({
    	"pageLength": 5,
      //disable sorting on last column
      "columnDefs": [
        { "orderable": false, "targets": 3 }
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
                let categoryName = row.querySelector('.category-name');
                document.getElementById('cId').value = row.querySelector('.categoryId').textContent;
                document.getElementById('deleteCategoryId').innerHTML = categoryName.textContent;
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