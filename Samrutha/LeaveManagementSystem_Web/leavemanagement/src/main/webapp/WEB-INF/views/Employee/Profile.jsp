
<%@page import="com.leavemanagement.model.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile</title>
     
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/asserts/css/EmployeeStyle.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <style>
          .card {
            font-size: 15px;
            margin: 30px;
            margin-left: 20%;
        }
        .profile-card {
            background-color: #f8f9fa;
            width: 40rem;
            height: 40rem;
            border: none;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        .profile-img {
            width: 100px;
            height: 100px;
            border-radius: 50%;
            border: 3px solid #040430;
        }
        .form-control-plaintext {
            /* background-color: #e9ecef; */
            border: 1px solid #e9ecef;
            border-radius: .25rem;
            padding: .375rem .75rem;
        }
        .modal-content {
            border-radius: 10px;
        }
        .btn-primary {
            background-color: #007bff;
            border-color: #007bff;
        }
        .btn-secondary {
            background-color: #6c757d;
            border-color: #6c757d;
        }
        label{
            margin-left: 120px;
            text-align: left;
        }
        .form-group{
            padding: 2px;
        }
        p{
        	margin-bottom:10px;
        }
        h4{
        	padding-bottom:20px;
        }
        @media (max-width: 767.98px) {
            .profile-card {
                margin: 20px auto;
                width: auto;
                height: 48rem;
               
            }
            label {
                margin-left: 0;
            }
            .form-group {
                margin-bottom: 10px;
            }
        }
    </style>
</head>
<body>
     <header class="header fixed-top">
        <div class="header-img"><img src="${pageContext.request.contextPath}/asserts/images/image1.png" alt="Logo"></div>
        <a href="${pageContext.request.contextPath}/eprofile" style="color: white;text-decoration: none;">
	        <div id="header-profile">
	        <div id="header-content"><p style="padding-top:15px; padding-right:5px"><%=session.getAttribute("username") %></p></div>
	        <div id="icon"><img src="${pageContext.request.contextPath}/asserts/images/image2.svg" alt="Icon" style="margin-top:15px;justify-content:center;height:25px"></div>
	        </div>
        </a>
    </header>
       <div class="row">
        <nav id="sidebar" class="col-md-2 sidebar sidebar-sticky collapse d-md-block">
                <a class="nav-link" href="${pageContext.request.contextPath}/employee/edashboard">Dashboard</a>
                <a class="nav-link active" href="${pageContext.request.contextPath}/employee/eprofile">Profile</a>
                <a class="nav-link" href="${pageContext.request.contextPath}/employee/eleave">Applied Leaves</a>
                <a class="nav-link" href="${pageContext.request.contextPath}/employee/ehistory">History</a>
                <a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout</a>
        </nav>
        <div class="col-md-10 content">
            <div>
                <h1>Profile</h1>
            </div>
            <div>
                <nav aria-label="breadcrumb">
                  <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/employee/edashboard">Dashboard</a></li>
                    <li class="breadcrumb-item active" aria-current="page">Profile</li>
                  </ol>
                </nav>
            </div>
            <hr>



            <div class="card profile-card">
                <div class="card-body">
                    <img src="${pageContext.request.contextPath}/asserts/images/image2.svg" alt="Profile Image" class="profile-img mb-3">
                    <h3 class="card-title" style="color: #040430; background-color:#f8f9fa;"><%= ((Employee)session.getAttribute("employee")).getFirstName() + " " + ((Employee)session.getAttribute("employee")).getLastName() %></h3>
                    <p class="text-muted" style="font-size: 13px;">
                        <%= ((Employee) session.getAttribute("employee")).getRole() %><br>
                        <%= ((Employee) session.getAttribute("employee")).getDepartment().getDeptName() %>
                    </p>
                    <h4>Profile Information <button type="button" class="btn btn-sm btn-primary" data-toggle="modal" data-target="#editCompanyModal" style="padding-bottom: 1px;">Edit</button></h4>
                    <div class="profile-info mt-12">
                        
                        <form>
                        	<div class="form-group row">
                                <label for="userName" class="col-sm-3 col-form-label">Employee Id</label>
                                <div class="col-sm-5">
                                    <input type="Number" readonly class="form-control-plaintext" id="userName" value=<%= ((Employee)session.getAttribute("employee")).getEmpID()%>>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="userName" class="col-sm-3 col-form-label">Username</label>
                                <div class="col-sm-5">
                                    <input type="text" readonly class="form-control-plaintext" id="userName" value=<%= ((Employee)session.getAttribute("employee")).getUsername()%>>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="inputEmail" class="col-sm-3 col-form-label">Email</label>
                                <div class="col-sm-5">
                                    <input type="email" readonly class="form-control-plaintext" id="inputEmail" value=<%= ((Employee)session.getAttribute("employee")).getEmail()%>>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="companyAddress" class="col-sm-3 col-form-label">Password</label>
                                <div class="col-sm-5">
                                    <input type="password" readonly class="form-control-plaintext" id="companyAddress" value=<%= ((Employee)session.getAttribute("employee")).getPassword()%> style="overflow-y: auto;">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="Phone NUmber" class="col-sm-3 col-form-label">Join Date</label>
                                <div class="col-sm-5">
                                    <input type="tel" readonly class="form-control-plaintext" id="Phone Number" value=<%= ((Employee)session.getAttribute("employee")).getJoinDate()%>>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            
        </div>
    </div>
    <script src="${pageContext.request.contextPath}/asserts/javascript/EmployeeScript.js"></script>
    
    
    <div class="modal fade" id="editCompanyModal" tabindex="-1" role="dialog" aria-labelledby="applyLeaveModalLabel" aria-hidden="true">
	    <div class="modal-dialog" role="document">
	        <div class="modal-content">
	            <div class="modal-header">
	                <h5 class="modal-title" id="editCompanyModalLabel">Change Password</h5>
	            </div>
	            <div class="modal-body">
	                <form id="leaveForm" action="updateEprofile" method="post" onsubmit="return validateForm()">
	                    <div class="form-group">
	                        <label for="oldpassword" style="margin-left:0px">Old Password</label><br>                               
	                        <input type="password" name="oldPassword" id="oldpassword" oninput="clearError('oldPasswordError')" onblur="validateOldPassword()"><br>
	                        <span id="oldPasswordError" class="text-danger"></span>
	                    </div>
	                    <div class="form-group">
	                        <label for="newpassword" style="margin-left:0px">New Password</label><br>
	                        <input type="password" name="newPassword" id="newpassword" oninput="clearError('newPasswordError')" onblur="validateNewPassword()"><br>
	                        <span id="newPasswordError" class="text-danger"></span>
	                    </div>
	                    <div class="form-group">
	                        <label for="cfpassword" style="margin-left:0px">Confirm Password</label><br>
	                        <input type="password" name="CfPassword" id="cfpassword" oninput="clearError('confirmPasswordError')" onblur="validateConfirmPassword()"><br>
	                        <span id="confirmPasswordError" class="text-danger"></span>
	                    </div>
	                    <span id="formError" class="text-danger"></span>
	                   
	                    <div class="modal-footer">
	                        <button type="button" class="btn btn-secondary btn-sm" data-dismiss="modal">Close</button>
	                        <button type="submit" class="btn btn-primary btn-sm">Save Changes</button>
	                    </div>
	                </form>
	            </div>
	        </div>
	    </div>
	</div>
	<script>
	function validateForm() {
        var oldPassword = document.getElementById("oldpassword").value.trim();
        var newPassword = document.getElementById("newpassword").value.trim();
        var confirmPassword = document.getElementById("cfpassword").value.trim();
        var oldPasswordError = document.getElementById("oldPasswordError");
        var newPasswordError = document.getElementById("newPasswordError");
        var confirmPasswordError = document.getElementById("confirmPasswordError");
        var formError = document.getElementById("formError");

        // Reset previous errors
        oldPasswordError.textContent = "";
        newPasswordError.textContent = "";
        confirmPasswordError.textContent = "";
        formError.textContent = "";

        // Check if all fields were entered
        if (oldPassword === "" || newPassword === "" || confirmPassword === "") {
            formError.textContent = "Please fill in all fields.";
            return false;
        }

        // Check if new password matches confirm password
        if (newPassword !== confirmPassword) {
            confirmPasswordError.textContent = "New password and confirm password do not match.";
            return false;
        }

        // Check if password meets criteria
        var passwordRegex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*]).{8,}$/;
        if (!passwordRegex.test(newPassword)) {
            newPasswordError.textContent = "New password must be at least 8 characters long, contain a digit, an uppercase letter, a lowercase letter, and a special character (!@#$%^&*).";
            return false;
        }

        return true; // Form submission proceeds if all validations pass
    }

    function validateOldPassword() {
        var oldPassword = document.getElementById("oldpassword").value.trim();
        var oldPasswordError = document.getElementById("oldPasswordError");
        
        
        if (oldPassword === "") {
            oldPasswordError.textContent = "Old password is required.";
        } 
        else if(password != oldPassword){
        	oldPasswordError.textContent = "Old password does not match.";
        	
        }
        else {
            oldPasswordError.textContent = "";
        }
    }

    function validateNewPassword() {
        var newPassword = document.getElementById("newpassword").value.trim();
        var newPasswordError = document.getElementById("newPasswordError");
        var passwordRegex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*]).{8,}$/;
        if (!passwordRegex.test(newPassword)) {
            newPasswordError.textContent = "New password must be at least 8 characters long, contain a digit, an uppercase letter, a lowercase letter, and a special character (!@#$%^&*).";
        } else {
            newPasswordError.textContent = "";
        }
    }

    function validateConfirmPassword() {
        var newPassword = document.getElementById("newpassword").value.trim();
        var confirmPassword = document.getElementById("cfpassword").value.trim();
        var confirmPasswordError = document.getElementById("confirmPasswordError");
        if (newPassword !== confirmPassword) {
            confirmPasswordError.textContent = "New password and confirm password do not match.";
        } else {
            confirmPasswordError.textContent = "";
        }
    }

    function clearError(elementId) {
        document.getElementById(elementId).textContent = "";
        document.getElementById("formError").textContent = "";
    }
	</script>
	<script>
	var password='';
			document.addEventListener('DOMContentLoaded',function(){
				
				fetch('passwordchecker').then(response=>response.json()).then(data=>{
					password=data;
					
				})
				.catch(error=>{
					
				})
			})
			
			
	</script>
</body>
</html>