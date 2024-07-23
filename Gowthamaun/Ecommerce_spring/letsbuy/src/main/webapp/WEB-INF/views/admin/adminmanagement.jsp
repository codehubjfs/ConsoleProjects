<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asserts/css/adminstyles.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <style>
        .card-body {
            background-color: #f8f9fa;
            max-height: 400px; /* Set the maximum height */
            overflow-y: auto;  /* Enable vertical scrolling */
        }
        
        .card-body strong{
        	color: rgb(249,155,29);
        }
        
    </style>
</head>
<body>
<%
/*
response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
	if(request.getSession().getAttribute("admin")==null){
		response.sendRedirect("index.jsp");
	} */
%>
    <div class="container-fluid">
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
                      <span class="px-1">${sessionScope.admin.getUserName()}<i class="bi bi-caret-down-fill"></i></span></a>
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
                      <a class="nav-link pt-4" href="${pageContext.request.contextPath}/AdminDashBoardController">Dashboard</a>
                    </li>
                    <li class="nav-item side-barnav">
                      <a class="nav-link pt-4"  href="${pageContext.request.contextPath}/CustomerManagementController">Customer Management</a>
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
                    <li class="nav-item side-barnav">
                      <a class="nav-link pt-4" href="${pageContext.request.contextPath}/SubCategoryManagementController">Sub-Category Management</a>
                    </li>
                    <li class="nav-item side-barnav">
                      <a class="nav-link pt-4 active" href="${pageContext.request.contextPath}/AdminManagementController">Admin Management</a>
                  </li>
                  
                </div>
                </div>
              </nav>
            <div class="col-md-10">
                <div class="d-flex align-items-center justify-content-evenly vh-100">
                    <div class="invisible" id="outer-box" style="margin-left:20%;margin-right:200px" >
                    
                    
                    <div class="row" style="width:100vW">
                    	<div class="bg-white shadow rounded px-0 col-auto" style="width:500px">
                    
                        <div class="row px-0 mx-0">
                            <div class="col-12 mt-0 px-0 pb-5">
                                <div class="m-0 p-0 rounded-top mb-0" id="add-admin-top">
                                    <h3 class="text-white text-center p-5">Add Admin</h3>
                                </div>
                                <button class="btn btn-outline-success rounded-pill mx-2" onclick="showAdminCard()"><i class="bi bi-arrow-left-circle-fill"></i> Back</button>
                                <div class="mx-5">
                                    
                                    <form class="border-hidden" id="admin-add">
                                    <div class="px-5 mt-4">
                                        <label for="username" class="pb-2 px-2">Username</label>
                                        <input type="text" class="form-control rounded-pill" id="username" oninput="isUserNameValid()">
                                        <div class="invalid-feedback" id="invalid-username">input can be alphabets,numbers and Underscore(_)</div>
                                        <label for="password" class="pb-2 px-2 pt-2">Password</label>
                                        <input type="text" class="form-control rounded-pill" id="password" value="admin@123" disabled>
                                    </div>
                                    
                                </form>
                                </div>
                                <div class="text-center mt-4">
                                    <button type="button" class="btn  btn-lg rounded-pill px-5 disabled" id="add-btn" data-bs-toggle="modal" data-bs-target="#exampleModalCenter" onclick="initialiseData()">Add</button> 
                                </div>
                                
                            </div>
                        </div>
                    </div>
                    <div class="col-3 bg-white shadow rounded px-0 mx-3">
                    	<div class="container">
        <div class="card">
            <div class="card-header py-4 text-white" style="background-color:darkblue;">
                <h3>Admin User Instructions</h3>
            </div>
            <div class="card-body">
                <ul class="list-group">
                    <li class="list-group-item">
                        <strong>1. Add a New Admin:</strong> 
                        <p>To add a new admin, follow these steps:</p>
                        <ol>
                            <li>Navigate to the "User Management" section.</li>
                            <li>Click on "Add New User".</li>
                            <li>Fill in the required details for the new admin.</li>
                            <li>Set the default password to <code>admin@123</code>.</li>
                            <li>Click "Save" to create the new admin account.</li>
                        </ol>
                        <p>The new admin user can change their password in the "Edit Profile" menu.</p>
                    </li>
                    <li class="list-group-item">
                        <strong>2. Edit Profile:</strong> Admins can update their profile details and change their password. Navigate to the "Edit Profile" menu to make changes.
                    </li>
                    <li class="list-group-item">
                        <strong>3. Customer Management:</strong> Admins can manage customer information and interactions. Navigate to the "Customer Management" section to view and update customer details.
                    </li>
                    <li class="list-group-item">
                        <strong>4. Dashboard:</strong> Admins can view key metrics and insights. Navigate to the "Dashboard" section to access summaries of system activity and performance.
                    </li>
                    <li class="list-group-item">
                        <strong>5. Seller Management:</strong> Admins can manage seller accounts and information. Go to the "Seller Management" section to view, add, or update seller details.
                    </li>
                    <li class="list-group-item">
                        <strong>6. Product Management:</strong> Admins have access to create, update, and delete product listings. Navigate to the "Product Management" section to manage product details.
                    </li>
                    <li class="list-group-item">
                        <strong>7. Category Management:</strong> Admins can create and update categories. Go to the "Category Management" section to manage product categories.
                    </li>
                    <li class="list-group-item">
                        <strong>8. Subcategory Management:</strong> Admins can manage subcategories within categories. Navigate to the "Subcategory Management" section to create and update subcategories.
                    </li>
                </ul>
            </div>
        </div>
    </div>
                    </div>
                    </div>
                    
                    <p id="update-msg" style="display:none">${updateMessage}</p>
                    </div>
                    <div class="shadow px-0" id="outer-box2">
                        <div class="bg-white shadow rounded">
                            <div class="row">
                               <div class="col-5 d-flex flex-column align-items-center justify-content-center bg-primary text-center text-white">
                                   <img src="${pageContext.request.contextPath}/asserts/images/admin-icon.png" height="120" width="120" class="rounded-pill img-fluid" alt=""> 
                                   <p class=" p-1 pt-1 fs-5" >Admin</p>
                                   
                               </div> 
                               <div class="col-7 bg-white">
                                    <h5 class="mt-3">Admin Profile</h5>
                                    <hr>
                                    <h5 class="">UserName</h5>
                                    <p class="text-secondary " id="username-current">${sessionScope.admin.getUserName()}</p>
                                    <h5 class="mt-0">Password</h5>
                                    <p class="text-secondary mb-2" >*********</p>
                                  	<p id="password-current" style="display:none">${sessionScope.admin.getPassowrd()}</p>
                                  	<p id="admin-Id" style="display:none">${sessionScope.admin.getAdminId()}</p>
                                    <div class="row">
                                        <div class="col-6">
                                            <button class="btn btn-outline-primary btn-lg px-5 rounded-pill" id="profile-edit-btn">Edit</button> 
                                        </div>      
                                        <div class="col-6">
                                            <button class="btn btn-outline-secondary btn-lg px-5 rounded-pill" onclick="addAnotherAdmin()">Add</button> 
                                        </div>                                  
                                    </div>
                                    <hr>
                                    <div class="row text-center">
                                        <div class="col-12 mb-4">
                                            <button class="btn btn-outline-primary rounded-pill"><i class="bi bi-facebook"></i></button>
                                            <button class="btn btn-outline-primary rounded-pill"><i class="bi bi-instagram"></i></button>
                                            <button class="btn btn-outline-primary rounded-pill"><i class="bi bi-twitter"></i></button>
                                        </div>
                                    </div>
                               </div>
                            </div>
                        </div>
                    </div>
                </div> 
            </div>
        </div>
    </div>
    <!-- Add admin Confirmation Modal-->
    <div class="modal fade" id="exampleModalCenter" tabindex="-1" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalCenterTitle">Confirmation</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    Are you sure to add another admin?
                </div>
                <form action="${pageContext.request.contextPath}/AddAdminController" method="post">
                <input type="hidden" name="add-admin-username" id="add-admin-username">
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary" id="confirm-add-btn" data-bs-dismiss="modal">Make change</button>
                </div>
                </form>
            </div>
        </div>
    </div>
   
    <div class="toast-container" id="toast-msg-top">
        <div class="toast  text-white bg-success border-0 p-3" id="success-toast" role="alert" aria-live="assertive" aria-atomic="true">
            <div class="d-flex">
                <div class="toast-body fs-6" id="toast-msg">
                    Admin has been added successfully!
                </div>
                <button type="button" class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast" aria-label="Close"></button>
            </div>
        </div>
    </div>
    
    <!-- Edit user profile data modal-->
    <div class="modal fade" id="editUserModal" tabindex="-1" role="dialog" aria-labelledby="editUserModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="editUserModalLabel">Edit User Info</h5>
         <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
       <form id="editUserForm" action="${pageContext.request.contextPath}/AdminProfileEditController" method="post">
      <div class="modal-body">
       		 <input type="hidden" class="form-control" id="add-modal-adminId">
          <div class="">
            <label for="username">Username</label>
            <input type="text" class="form-control" id="add-modal-username" name="username" disabled> 
          </div>
          <div class="">
            <label for="password">Password</label>
            <input type="text" class="form-control" id="add-modal-password" name="edit-profile-password" oninput="validatePassword()">
            <div class="invalid-feedback" id="invalid-edit-password">Password is invalid</div>
          </div> 
      </div>
      <div class="modal-footer">
        
        <button type="reset" class="btn btn-success">reset</button>
        <button type="submit" class="btn btn-primary" id="btn-edit-submit" disabled onclick="submitEditUserForm()">Save changes</button>
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
      </div>
      </form>
    </div>
  </div>
</div>
    

    <script>
        var userNames = [];
    	fetch('AdminUserNameController')
    	.then(response=>response.json())
    	.then(data=>{
    		userNames = data;
    	})
    	.catch(error=>{
    		alert('Error fetching admin usernames')
    		console.error('Error:', error);
    	});
        //  var password = "*******";
        //  var confirmPassword = "********";
        function initialiseData(){
        	var add_admin_username = document.getElementById('add-admin-username');
        	var entered_username = document.getElementById('username').value;
        	add_admin_username.value = entered_username;
        }

         function addAnotherAdmin(){
            var outerbox = document.getElementById('outer-box');
            var outerbox2 = document.getElementById('outer-box2');
            outerbox2.classList.add('invisible');
            outerbox.classList.remove('invisible');
         }

         function showAdminCard(){
            var outerbox = document.getElementById('outer-box');
            var outerbox2 = document.getElementById('outer-box2');
            outerbox.classList.add('invisible');
            outerbox2.classList.remove('invisible');
         }
         var form = document.getElementById('admin-add');
         
        function isUserNameValid(){
            let match = /^[a-zA-Z][a-zA-Z0-9_]{4,24}$/;
            let username = form.username.value.trim();
            let msg = document.getElementById('invalid-username');
            var btn = document.getElementById('add-btn');
            if(!match.test(username)){
            	if (!username.match(/^[a-zA-Z0-9_]+$/)) {
                    msg.innerHTML = "Username can contain only alphabets, numbers, and underscores";
                } else if (!username.match(/^.{5,24}$/)) {
                    msg.innerHTML = "Length should be between 5-24 characters";
                } else if (!username.match(/^[a-zA-Z]/)) {
                    msg.innerHTML = "Username should start with an alphabet";
                }
            	form.username.classList.add('is-invalid');
                btn.classList.add('disabled');
            }else if(userNames.includes(username)){
            	msg.innerHTML="Username already exist!!!";
            	form.username.classList.add('is-invalid');
                btn.classList.add('disabled');
            }else{
            	form.username.classList.remove('is-invalid');
                form.username.classList.add('is-valid');
                btn.classList.remove('disabled');
            }
            
            
        }
        
        var edit_form = document.getElementById('editUserForm');
        var passwordError = document.getElementById('invalid-edit-password');
        var subt_btn = document.getElementById('btn-edit-submit');
        function validatePassword() {
            let password = document.getElementById('add-modal-password').value.trim();
            if (!password.match(/^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%#?&])[A-Za-z\d@$!%*#?&]{8,20}$/)) {
               if(!password.match(/(?=.*[A-Za-z])/)){
                passwordError.innerHTML = "password should has atleast one alphabet";
               }else if(!password.match(/(?=.*\d)/)){
                passwordError.innerHTML = "password should has atleast one Number";
               }else if(!password.match(/(?=.*[@$!%#?&])/)){
                passwordError.innerHTML = "password should has atleast one Symbols[@$!%#?&]";
               }else if(!password.match(/^.{8,20}$/)){
                passwordError.innerHTML = "password Length should be 8-20";
               }
               document.getElementById('add-modal-password').classList.add('is-invalid');
               subt_btn.setAttribute('disabled','true');
                return false;
            } else {
            	document.getElementById('add-modal-password').classList.remove('is-invalid');
            	document.getElementById('add-modal-password').classList.add('is-valid');
            	subt_btn.removeAttribute('disabled');
                return true;
            }
        }
        
        document.getElementById('profile-edit-btn').addEventListener('click',function(){
        	let oldUsername = document.getElementById('username-current').textContent;
        	let oldPassword = document.getElementById('password-current').textContent;
        	let adminId = document.getElementById('admin-Id').textContent;
        	console.log(adminId);
        	let modal_username = document.getElementById('add-modal-username');
        	let modal_password = document.getElementById('add-modal-password');
        	let modal_adminId = document.getElementById('add-modal-adminId');
        	modal_username.value = oldUsername;
        	modal_password.value = oldPassword;
        	modal_adminId.value = adminId;
        	let editModal = new bootstrap.Modal(document.getElementById('editUserModal'));
        	editModal.show();
        });
        
		var update_msg = document.getElementById('update-msg').textContent;
		var toast_msg = document.getElementById('toast-msg');
		if(update_msg!==""){
			toast_msg.textContent = update_msg;
			var toastEl = document.getElementById('success-toast');
            var toast = new bootstrap.Toast(toastEl);
            toast.show();
		}
		
        document.getElementById('confirm-add-btn').addEventListener('click', function() {
            var toastEl = document.getElementById('success-toast');
            var toast = new bootstrap.Toast(toastEl);
            toast.show();
        });
    </script>
</body>
</html>