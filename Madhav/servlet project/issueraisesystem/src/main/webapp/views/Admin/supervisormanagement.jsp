<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asserts/css/admin/supervisormanagement.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="script.js" defer></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js" defer></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" defer></script>
    <style>
    
    
    #addStudentForm {
  
    width: 1100px;
    height:500px;
    margin: 20px auto;
    padding: 30px;
    background-color: #f8f9fa;
    border: 1px solid #dddddd;
    border-radius: 10px;
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
    font-family: 'Arial', sans-serif;
    animation: fadeIn 1s ease-in-out;
    margin-left:215px;
    margin-top:100px;
}

/* Section title styling */
.section-title {
    font-size: 20px;
    font-weight: bold;
    margin-bottom: 15px;
    color: #343a40;
}

/* Form elements styling */
.form-control {
    margin-bottom: 15px;
    padding: 12px;
    border: 1px solid #ccc;
    border-radius: 5px;
    width: 100%;
    transition: border-color 0.3s ease;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}
.section-title {
        font-size: 18px;
        font-weight: bold;
        margin-bottom: 15px;
        color: #333;
    }

/* Label styles */
label {
    font-weight: bold;
    color: #495057;
    margin-bottom: 8px;
    display: block;
}

/* Required indicator styles */
span.required {
    color: red;
}

/* Hover effect for form elements */
.form-control:hover {
    border-color: #007bff;
}

/* Submit button styling */
.btn-primary {
    background-color: #007bff;
    color: white;
    border: none;
    border-radius: 5px;
    padding: 12px 20px;
    font-size: 16px;
    cursor: pointer;
    transition: background-color 0.3s ease, transform 0.2s ease;
}

.btn-primary:hover {
    background-color: #0056b3;
    transform: scale(1.05);
}

/* Error feedback styling */
.invalid-feedback {
    color: red;
    font-size: 14px;
}

/* Optional: Adjust form layout for smaller screens */
@media (max-width: 768px) {
    #addStudentForm {
        padding: 20px;
    }
}

/* Animation */
@keyframes fadeIn {
    from {
        opacity: 0;
        transform: translateY(-20px);
    }
    to {
        opacity: 1;
        transform: translateY(0);
    }
}
    </style>
</head>
<body>
    <div class="container-fluid">
        <div class="row">
            <!-- Sidebar -->
            <div class="col-2 sidebar">
                <div class="logo">
                    <img src="${pageContext.request.contextPath}/asserts/image/admin/ticket-perforated-fill (1).svg" alt="Logo"> 
                    <span>Ticket Raise</span>
                </div>
                <nav>
                  <a href="${pageContext.request.contextPath}/AdminDashboardController" id="sidereport">Dashboard</a>

                    <div class="dropdown dropdowndemo">
                        <button class="dropdown-btn dropbutton1" >User Management
                            <i class="fa fa-caret-down"></i>
                        </button>
                        <div class="dropdown-container">
                        <a href="#" >Student</a>
                            
                        <a href="${pageContext.request.contextPath}/WardenManagementController">Warden</a>
                        <a href="#" class="active">Supervisor</a>
                        <a href="${pageContext.request.contextPath}/views/Admin/workersmanagement.jsp" >Workers</a>
                        </div>
                    </div>
                   
                    <a href="${pageContext.request.contextPath}/AdminReportManagementController">Report Management</a>
                    <a href="${pageContext.request.contextPath}//logout" >Log Out</a>
                </nav>
                
            </div>

            <!-- Main Content -->
            <div class="col-10 main-content">
                <div class="row">
                    <div class="col-12">
                        <div class="header">
                            <h2>Supervisor Management</h2>
                            <div class="user-profile">
                                <div class="dropdown profile1">
                                    <img src="${pageContext.request.contextPath}/asserts/image/admin/person-circle (1).svg" alt="User Profile" id="profileDropdown" class="dropdown-toggle" aria-haspopup="true" aria-expanded="false">
                                    <button class="dropdown-btn"><i class="fa fa-caret-down1"></i></button>
                                    <div class="dropdown-container" id="dropdownContainer">
                                        <a href="#">View profile</a>
                                        <a href="#">Account Setting</a>
                                        <hr>
                                        <a href="${pageContext.request.contextPath}//logout">Sign Out</a>
                                    </div>
                                </div>
                            </div>
                            <div class="left-profile">
                                <div class="role">Admin</div>
                                 <c:forEach items="${AdminDetails}" var="admin">
                                
                                	${admin.name}
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Top Metrics -->
                <nav aria-label="breadcrumb">
                    <ol class="breadcrumb">
                           <li class="breadcrumb-item "><a href="${pageContext.request.contextPath}/AdminDashboardController">Dashboard</a></li>
                        <li class="breadcrumb-item active" aria-current="page">Supervisor Management</li>
                    </ol>
                </nav>
                
               <button type="button" class="btn btn-primary mb-3" onclick="showAddStudentForm()">Add Supervisor</button>

                <!-- Add Student Form -->
                
                <!-- Success Message Container -->
                <div id="alerts"></div>
    <div id="successMessage" style="display: none;" class="alert alert-success alert-dismissible fade show" role="alert">
        Student added successfully!
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
                <div id="addStudentForm" class="modal">
                    <form action="${pageContext.request.contextPath}/AddSupervisorController" method="post" class="needs-validation" novalidate>
                        <div class="section-title">Student Information</div>
                       <div class="form-group">  
                        <div class="row mb-3">
                            <div class="col-md-3">
                                <label class="Name">Name <span style="color:red;">*</span></label>
                                <input type="text" name="supervisorName" id="supervisorName" class="form-control" placeholder="Name" required>
                                <div class="invalid-feedback">
                                    Name must contain only letters and spaces and be at least 3 characters long.
                                </div>
                            </div>
                            <div class="col-md-3">
                                <label class="department">Department <span style="color:red;">*</span></label>
                                <select name="department" id="department" class="form-control" required>
                                    <option value="" selected disabled>Department</option>
                                   <option value="food">food</option>
                                    <option value="electricals">electricals</option>
                                    <option value="cleaning">cleaning</option>
                                    <option value="Furniture">Furniture</option>
                                    <option value="Plumbing">Plumbing</option>
                                    <option value="Furniture">Furniture</option>
                                    <option value="Civil">Civil</option>
                                </select>
                                <div class="invalid-feedback">
                                    Please select a department.
                                </div>
                            </div>
                           
                            
                           
                            <div class="col-md-3">
                                <label class="mailid">Mail Id <span style="color:red;">*</span></label>
                                <input type="email" name="mailid" id="mailid" class="form-control" placeholder="Mail Id" required>
                               <div class="invalid-feedback" id="invalid-email">Please enter a valid email address.</div>
                               
                            </div>
                            <div class="col-md-3">
                    <label class="password">Password <span style="color:red;">*</span></label>
                    <input type="password" name="password" id="password" class="form-control" placeholder="Password" required>
                    <div class="invalid-feedback">
                        Password must contain at least one uppercase letter, one lowercase letter, one special character, and be at least 8 characters long.
                    </div>
                </div>
                        </div>
                      </div>
                      
                        <div class="row">
                            <div class="col-12 text-center">
                                <button type="submit" class="btn btn-primary">Submit</button>
                                <button type="button" class="btn btn-secondary" onclick="hideAddStudentForm()">Cancel</button>
                            </div>
                        </div>
                    </form>
                </div>

                <table class="table table-striped table-bordered" id="myTable">
                    <thead class="thead-Dark">               
                           
                
                        <tr>
                       		<th scope='col'>S.No</th>
                            <th scope="col">Name</th>
                            <th scope="col">Mailid</th>
                          	<th scope="col">department</th>
                            <th scope="col">Action</th>
                            
                            
                            
                        </tr>
                    </thead>
                        <tbody>
                        	<c:forEach items="${supervisorDetails}" var="supervisor" varStatus="status">
	                      		<tr data-item-id="${supervisor.mailid}">
	                      		
	                      			<td>${status.count}</td>
	                      			<td class="supervisorname">${supervisor.name}</td>
	                      			<td>${supervisor.mailid}</td>
	                      			<td class="supervisordepartment">${supervisor.department}</td>
	                      			<td>
		                                <div class="btn-group" role="group" aria-label="Action Buttons">
		                                    <button type="button" class="btn btn-outline-primary btn-sm" onclick="editStudent(this)">
		                                        <i class="fas fa-edit"></i>
		                                    </button>
		                                    <button type="button" class="btn btn-outline-danger btn-sm" onclick="deleteStudent(this)">
		                                        <i class="fas fa-trash"></i>
		                                    </button>
		                                </div>
	                            	</td>
	                      		</tr>
                      		</c:forEach>
                       </tbody> 

                   
                </table>

            </div>
        </div>
    </div>
	
	<div class="modal fade" id="editUserModal" tabindex="-1" role="dialog" aria-labelledby="editUserModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="editUserModalLabel">Edit User Info</h5>
         <button type="button" class="btn-close" data-dismiss="modal" aria-label="Close"></button>
      </div>
       <form id="editUserForm" action="${pageContext.request.contextPath}/EditSuperVisorController" method="get">
      <div class="modal-body">
      
       		<label for="mailid">Mailid:</label>
       		
       		<input type="text" class="form-control"  id="add-modal-disablemail" disabled>
       		
       		<input type="hidden" class="form-control"  id="add-modal-email" name="mailid">
       		
       		 
          <div class="">
            <label for="name">Name</label>
            <input type="text" class="form-control" id="add-modal-name" name="name">
             
          </div>
          
          <div class="">
            <label for="department">Department</label>
             <select name="department" id="add-modal-department" class="form-control" required>
                                    <option value="" selected disabled>Department</option>
                                   <option value="food">food</option>
                                    <option value="electricals">electricals</option>
                                    <option value="cleaning">cleaning</option>
                                    <option value="Furniture">Furniture</option>
                                    <option value="Plumbing">Plumbing</option>
                                    <option value="Furniture">Furniture</option>
                                    <option value="Civil">Civil</option>
                                </select>
          </div>
          
         
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary" onclick="submitEditUserForm()">Save changes</button>
      </div>
      </form>
    </div>
  </div>
</div>
   <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" defer></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js" defer></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"  defer></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.min.js" defer></script>
   <script>
   
   
        // Show the Add Student form
        function showAddStudentForm() {
            document.getElementById('addStudentForm').style.display = 'block';
            document.body.insertAdjacentHTML('beforeend', '<div class="modal-backdrop"></div>');
        }
        

        function validateAndSubmitForm(event) {
            event.preventDefault(); // Prevent the default form submission
            if (validateForm()) {
                document.querySelector('.needs-validation').submit();
                $('#successModal').modal('show'); // Show the success modal
            }
        }

        // Hide the Add Student form
        function hideAddStudentForm() {
            document.getElementById('addStudentForm').style.display = 'none';
            const backdrop = document.querySelector('.modal-backdrop');
            if (backdrop) backdrop.remove();
        }

        // Validation logic for the form
        (function() {
            'use strict';
            window.addEventListener('load', function() {
                var forms = document.getElementsByClassName('needs-validation');
                Array.prototype.filter.call(forms, function(form) {
                    form.addEventListener('submit', function(event) {
                        if (form.checkValidity() === false) {
                            event.preventDefault();
                            event.stopPropagation();
                        }
                        form.classList.add('was-validated');
                    }, false);
                });
            }, false);
        })();
    </script>
    <script>
    var mail=[];
    
    document.addEventListener('DOMContentLoaded', function() {
    	 
    	
    	
    	
    	  //Checking mail id is already there
            
            fetch('${pageContext.request.contextPath}/SupervisorMailidController')
	       .then(response => response.json())
	       .then(data => {
	    	   mail = data;
	       })
	       .catch(error => {
	           alert('Error fetching email');
	           console.error('Error:', error);
	       });
    	
    	console.log(mail)
      
        document.getElementById('supervisorName').addEventListener('input', validateName);
        document.getElementById('mailid').addEventListener('input', validateEmail);
        document.getElementById('password').addEventListener('input', validatePassword);

        // Remove error messages when the user starts typing
        
    });

    

    function validateName() {
        var nameInput = document.getElementById('supervisorName');
        var name = nameInput.value;
        var nameValid = /^[A-Za-z\s]{3,}$/.test(name);

        if (!nameValid) {
            nameInput.setCustomValidity('Invalid');
        } else {
            nameInput.setCustomValidity('');
        }

        return nameValid;
    }

    function validateEmail() {
        var emailInput = document.getElementById('mailid');
        var email = emailInput.value;
        var emailerror=document.getElementById('invalid-email');
        var emailValid = /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email);

        if (!emailValid) {
            emailInput.setCustomValidity('Invalid email address');
            showErrorMessage('mailid', 'Please enter a valid email address.');
        }
        else if(mail.includes(email)){
        	console.log("mailid already exicited");
        	emailerror.innerHTML='mailid already exicited';
        	emailInput.setCustomValidity('Invalid');
        }
        
        else {
            emailInput.setCustomValidity('');
        }

        return emailValid;
    }

    function validatePassword() {
        var passwordInput = document.getElementById('password');
        var password = passwordInput.value;
        var passwordValid = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/.test(password);

        if (!passwordValid) {
            passwordInput.setCustomValidity('Password must contain at least one uppercase letter, one lowercase letter, one special character, and be at least 8 characters long');
        } else {
            passwordInput.setCustomValidity('');
        }

        return passwordValid;
    }

    function showErrorMessage(fieldId, message) {
        var field = document.getElementById(fieldId);
        var errorElement = field.nextElementSibling;
        if (errorElement && errorElement.classList.contains('invalid-feedback')) {
        	console.log("Inside error show");
            errorElement.innerHTML = message;
            errorElement.style.display = 'block';
        }
    }

    function removeErrorMessage(fieldId) {
        var field = document.getElementById(fieldId);
        var errorElement = field.nextElementSibling;
        if (errorElement && errorElement.classList.contains('invalid-feedback')) {
            errorElement.style.display = 'none';
        }
    }

       
            
    </script>
	
	<script>
    function deleteStudent(button) {
        const confirmed = confirm("Are you sure you want to delete this item?");
        if (confirmed) {
            const itemId = button.closest('tr').getAttribute('data-item-id');
            console.log(itemId);
            fetch('${pageContext.request.contextPath}/DeleteSupervisorController?id=' + itemId, {
                method: 'get'
            })
            .then(response => {
                if (response.ok) {
                    // Show success message using Bootstrap alert
                    const alertSuccess = `<div class="alert alert-success alert-dismissible fade show" role="alert">
                                            Item deleted successfully
                                            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                                          </div>`;
                    document.getElementById('alerts').innerHTML = alertSuccess;
                    
                    // Optionally redirect to another page
                    setTimeout(() => {
                        window.location.href = '${pageContext.request.contextPath}/SuperVisorManagementController';
                    }, 2000); // Redirect after 2 seconds
                } else {
                    // Show error message using Bootstrap alert
                    const alertError = `<div class="alert alert-danger alert-dismissible fade show" role="alert">
                                          Failed to delete item
                                          <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                                        </div>`;
                    document.getElementById('alerts').innerHTML = alertError;
                }
            })
            .catch(error => console.error('Error:', error));
        }
    }
    
 function editStudent(student){
    	
    	let row = student.closest('tr');
    	let supervisor_name = row.querySelector('.supervisorname');
    	let department=row.querySelector('.supervisordepartment');
    	
    	
    	
    	let editModal = new bootstrap.Modal(document.getElementById('editUserModal'));
    	editModal.show();
    	let username = document.getElementById('add-modal-name');
    	
    	var mailid=student.closest('tr').getAttribute('data-item-id');
    	
    	let tempMail=document.getElementById('add-modal-disablemail');
        let editDepartment=document.getElementById('add-modal-department');
    	let editMail=document.getElementById('add-modal-email');
    	
    	
    	editMail.value=mailid;
    	editDepartment.value='md';
    	tempMail.value=mailid;
    	username.value=supervisor_name.textContent;
    	
    		
    }
</script>

    
   
</body>
</html>

