-<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false"%>
    <%@ page import="java.util.*, com.letsbuy.beans.*" %>
    
    
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
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/2.4.0/jspdf.umd.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf-autotable/3.5.17/jspdf.plugin.autotable.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/docx/7.1.1/docx.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/FileSaver.js/2.0.5/FileSaver.min.js"></script>
<!-- Data Table JS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Customer Management</title>
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
                      <img class="img-fluid logo-img" src="${pageContext.request.contextPath}/asserts/images/logo.png" alt="MDB Logo" />
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
                      <a class="nav-link pt-4"  href="AdminDashBoardController">Dashboard</a>
                    </li>
                    <li class="nav-item side-barnav">
                      <a class="nav-link pt-4 active" href="CustomerManagementController">Customer Management</a>
                    </li>
                    <li class="nav-item side-barnav">
                      <a class="nav-link  pt-4" href="SellerManagementController">Vendor Management</a>
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
                                    <h2>All Customers</h2>
                                    <button id="export-pdf" class="btn btn-outline-dark btn-sm">Export to PDF</button>
                                </div>
                                <div class="col pt-3">
                                	<select id="status-filter" class="form-select" style="max-width:130px">
                                	<option value="ALL" selected>ALL</option>
                                		<option value="ACTIVE">ACTIVE</option>
                                         <option value="BLOCKED">BLOCKED</option>
                                         
                                	</select>
                                </div>

                            </div>
                        </div>
                        <table class="table  table-bordered" id="customer-table">
                            <thead class="text-center">
                                <tr>
                                	
                                    <th>S.No</th>
                                    <th style="display:none"></th>
                                    <th>Username</th>
                                    <th>MobileNumber</th>
                                    <th>Email</th>
                                    <th>Account Status</th>
                                    <th>Actions</th>
                                </tr>
                            </thead>
                            <tbody class="text-center align-items-center">
                           <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
                            <c:forEach var="user" items="${customer}" varStatus="status">
                            
                                <tr data-filter="${user.account.accountStatus}">
                                	
                                    <td class="status-id">${status.count}</td>
                                    <td class="td-cId" style="display:none">${user.customerId}</td>
                                    <td class="td-username">${user.account.userName}</td>
                                 
                                    <!-- <td>bBha@1223</td>
                                <td>No. 1, New Bangaru Naidu Colony, K.K. Nagar (West), Chennai - 600078.</td> -->
                                    <td class="td-mobileno">${user.mobileNumber}</td>
                                    <td class="td-email">${user.email}</td>
                                    <td>
                                        <span class="status-text">${user.account.accountStatus}</span>
                                        <select class="form-select status-select" style="display: none;">
                                            <option value="ACTIVE" selected>ACTIVE</option>
                                            <option value="BLOCKED">BLOCKED</option>
                                        </select>
                                    </td>
                                    <c:if test="${user.account.accountStatus!= 'DELETED'}">
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
                                        <button class="btn btn-secondary rounded-pill btn-sm mt-2 mx-1 view-btn"
                                        onclick="viewCustomerDetail(new Customer('${user.account.userName}','${user.firstName}','${user.lastName}','${user.address}',${user.mobileNumber},'${user.email}','${user.gender}','${user.account.accountStatus}'))">
                                            <i class="bi bi-eye-fill"></i>
                                        </button>
                                        
                                        <button type="button"
                                            class="btn btn-dark rounded-pill btn-sm mt-2 mx-1 cancel-btn">
                                            <i class="fas fa-times-circle"></i>
                                        </button>
                                    </td>
									</c:if>
									<c:if test="${user.account.accountStatus== 'DELETED'}">
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
                                        <button class="btn btn-secondary rounded-pill btn-sm mt-2 mx-1 view-btn" disabled
                                        onclick="viewCustomerDetail(new Customer('${user.customerId}','${user.firstName}','${user.lastName}','${user.address}',${user.mobileNumber},'${user.email}','${user.gender}','${user.account.accountStatus}'))">
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
                                


                                
                                <!-- Add more rows here -->
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
                <form action="CustomerManagementDeleteController" method="post">
                <div class="modal-body">
                	<input type="hidden" class="customerId" name="cId" value="">
                    <p>Are you sure you want to delete Customer in S.No <span id="deleteCustomerId" class="text-danger"></span>?</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                    <button type="submit" class="btn btn-danger" id="btn-confirm" data-bs-dismiss="modal">Delete</button>
                </div>
                </form>
            </div>
        </div>
    </div>

    <div class="modal" id="customerModal">
        <div class="modal-dialog">
            <div class="modal-content">
                <!-- Modal Header -->
                <div class="modal-header justify-content-between">
                    <h4 class="modal-title">Customer Details</h4>
                    <button type="button" class="close" data-bs-dismiss="modal">
                        <i class="bi bi-x"></i>
                    </button>
                </div>
                <!-- Modal Body -->
                <div class="modal-body">
                    <div class="row">
                        <div class="col-md-6">
                            <h5>First Name:</h5>
                            <p id="cusFname">John</p>
                        </div>
                        <div class="col-md-6">
                            <h5>Last Name:</h5>
                            <p id="cusLname">Doe</p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <h5>Username:</h5>
                            <p id="cususerName"></p>
                        </div>
                        <div class="col-md-6">
                            <h5>Phone Number:</h5>
                            <p id="cusMobileNumber">(555) 123-4567</p>
                        </div>

                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <h5>Address:</h5>
                            <p id="cusaddress">1234 Elm Street, Springfield, IL, 62704</p>
                        </div>
                        <div class="col-md-6">
                            <h5>Email:</h5>
                            <p id="cusEmailId">john_doe@example.com</p>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-6">
                            <h5>Account Status:</h5>
                            <p id="cusAccountstatus">Active</p>
                        </div>
                        <div class="col-md-6">
                            <h5>Gender:</h5>
                            <p id="cusGender">Male</p>
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
        class Customer {
            constructor(username, firstname, lastname, address, mobileNumber, emailId, gender, accountStatus) {
                this.username = username;
                this.firstname = firstname;
                this.lastname = lastname;
                this.address = address;
                this.mobileNumber = mobileNumber;
                this.emailId = emailId;
                this.gender = gender;
                this.accountStatus = accountStatus;

            }
        }
        
        
        $(document).ready(function() {
            $('#customer-table').DataTable({
            	"pageLength": 5,
              //disable sorting on last column
              "columnDefs": [
                { "orderable": false, "targets":6 }
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

        function viewCustomerDetail(customer) {

            document.getElementById('cususerName').innerHTML = customer.username;
            document.getElementById('cusFname').innerHTML = customer.firstname;
            document.getElementById('cusLname').innerHTML = customer.lastname;
            document.getElementById('cusaddress').innerHTML = customer.address;
            document.getElementById('cusMobileNumber').innerHTML = customer.mobileNumber;
            document.getElementById('cusEmailId').innerHTML = customer.emailId;
            document.getElementById('cusGender').innerHTML = customer.gender;
            document.getElementById('cusAccountstatus').innerHTML = customer.accountStatus;

            let viewModal = new bootstrap.Modal(document.getElementById('customerModal'));
            viewModal.show();
        }
        
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
        })
      };
        
        
        
       /* document.querySelectorAll('.view-btn').forEach(button=>{
        	button.addEventListener('click',function(){
        		let row = this.closest('tr');
        		Customer customer = new Customer();
        		customer.username = row.querySelector('.td-username');
        		customer.firstname = 
        	})
        	
        	
        }) */
        

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
                let cid = row.querySelector('.td-cId');
                //console.log(cid.textContent);
                let statusSelect = row.querySelector('.status-select');
                let statusText = row.querySelector('.status-text');
                statusText.textContent = statusSelect.value;
                statusText.style.display = 'block';
                statusSelect.style.display = 'none';
                row.querySelector('.edit-btn').style.display = 'inline-block';
                row.querySelector('.save-btn').style.visibility = 'hidden';
                row.querySelector('.cancel-btn').style.visibility = 'hidden';
              
                    location.href = "${pageContext.request.contextPath}/CustomerManagementEditController?customer="+statusSelect.value+"&cid="+cid.textContent;
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
                let id = row.querySelector('.td-cId').textContent;
                document.getElementById('deleteCustomerId').innerHTML = row.querySelector('.status-id').innerHTML;
                document.querySelector('.customerId').value =id;
                var deleteModal = new bootstrap.Modal(document.getElementById('deleteModal'));
                deleteModal.show();
                document.querySelector('#btn-confirm').addEventListener('click',function(){
                    row.remove();
                    
                });
                
            });
        });
        
        document.getElementById('export-pdf').addEventListener('click', function () {
            const { jsPDF } = window.jspdf;
            const doc = new jsPDF();

            doc.autoTable({ html: '#customer-table' });

            doc.save('customerdata.pdf');
        });
       
    </script>
</body>

</html>