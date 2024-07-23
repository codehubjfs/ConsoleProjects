<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Instructors Table</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
    <style>
        .vh-100 { height: 100vh; }
        .vertical-nav { width: 200px; height: 100%; position: fixed; top: 56px; left: 0; padding-top: 20px; }
        .main-content { margin-left: 220px; padding-top: 20px; }
        @media (max-width: 767.98px) {
            .vertical-nav { width:4%; height: 100%; position: relative; top: 0; left: 0; }
            .main-content { margin-left: 0; width:40%;height:40%; }
        }
    </style>
</head>
<body>
<%@page import="java.util.*,com.spring.model.Ins"%> 

<!-- Top Horizontal Navbar -->
<nav class="navbar navbar-expand-lg navbar-light fixed-top" style="background-color: #0092CA;">
    <a class="navbar-brand" href="#">
        <img src="asserts/images/site-logo.png" height="60px" width="70px" alt="Logo">
    </a>
     <h1><i>CHECKMATE</i></h1>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="languageDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Language
                </a>
                <div class="dropdown-menu" aria-labelledby="languageDropdown">
                    <a class="dropdown-item" href="#">English</a>
                    <a class="dropdown-item" href="#">Spanish</a>
                    <a class="dropdown-item" href="#">French</a>
                </div>
            </li>
            <li class="nav-item pt-1 pl-3">
                <div class="dropdown d-flex">
                    <a href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <img src="asserts/images/person.svg" class="rounded-circle pr-1" alt="Profile Image">
                    </a>
                    <h6 class="pt-1"><%= session.getAttribute("username") %></h6>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                        <a class="dropdown-item" href="logOut">LogOut</a>
                    </div>
                </div>
            </li>
        </ul>
    </div>
</nav>

<!-- Vertical Navigation Bar -->
<div class="bg-dark text-light vh-100 vertical-nav mt-3">
    <div class="nav flex-column">
        <!-- <a href="index.jsp" class="nav-item nav-link text-light pb-2 pt-5">Dashboard</a>-->
                    <a href="redirectCourses" class="nav-item nav-link text-light pb-2 pt-4">Course Management</a>
                    <a href="dash" class="nav-item nav-link text-light pb-2 pt-4">DashBoard</a>
                    <a href="users" class="nav-item nav-link text-light pb-2 pt-4">User Management</a>    
                   <!-- <a href="Profile.jsp" class="nav-item nav-link text-light pb-2 pt-4">Profile</a>-->
                   
    </div>
</div>

<main role="main" class="main-content container-fluid mt-5 ml-5">
    <div class="container mt-5">
        <button class="btn btn-primary mb-3" data-toggle="modal" data-target="#addModal">Add Instructor</button>
        <table class="table table-bordered text-center" id="instructorsTable">
            <thead class="thead-dark">
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Department</th>
                    <th>Date of Birth</th>
                    <th>Username</th>
                    <th>Password</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody id="instructorsTableBody">
                <tr>
                    <td>John</td>
                    <td>Doe</td>
                    <td>Computer Science</td>
                    <td>1995-01-15</td>
                    <td>johndoe</td>
                    <td>password123</td>
                    <td>
                        <img src="asserts/images/pencil-square.svg" alt="Edit" class="action-icon edit-icon pr-1" data-toggle="modal" data-target="#editModal" data-student-id="1" onclick="populateEditModal(this)">
                        <img src="asserts/images/trash3-fill.svg" alt="Delete" class="action-icon delete-icon" data-student-id="1" onclick="deleteRow(this)">
                    </td>
                </tr>
                <%ArrayList<Ins> insList = (ArrayList<Ins>) session.getAttribute("insList"); %>
                <%for (Ins s : insList) { %>
                <tr>
                    <td><%= s.getFirstname()%></td>
                    <td><%= s.getLastname() %></td>
                    <td><%= s.getDepartment() %></td>
                    <td><%= s.getDob() %></td>
                    <td><%= s.getUsername() %></td>
                    <td><%= s.getPassword() %></td>
                    <td>
                        <img src="asserts/images/pencil-square.svg" alt="Edit" class="action-icon edit-icon pr-1 edit-student" data-toggle="modal" data-target="#editModal" data-student-id="<%= s.getInsid() %>" onclick="populateEditModal(this)">
						<a href="#" ><img src="asserts/images/trash3-fill.svg" id="triggerModalBtn" data-toggle="modal" data-student-id="<%= s.getInsid() %>" data-target="#confirmModal"></a>
                        
                        <!-- <img src="asserts/images/trash3-fill.svg" alt="Delete" class="action-icon delete-icon" data-student-id="" onclick="deleteRow(this)">-->
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </div>
    
    <!-- Add Modal -->
    <div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="addModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="addModalLabel">Add Instructor</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form id="addForm" action="addInstructor" >
    <div class="form-group">
        <label for="addFirstName">First Name</label>
        <input type="text" class="form-control" id="addFirstName" name="firstname" required>
        <div class="invalid-feedback">First name must not contain numbers or special characters.</div>
    </div>
    <div class="form-group">
        <label for="addLastName">Last Name</label>
        <input type="text" class="form-control" id="addLastName" name="lastname" required>
        <div class="invalid-feedback">Last name must not contain numbers or special characters.</div>
    </div>
    <div class="form-group">
        <label for="addDepartment">Department</label>
        <select class="form-control" id="addDepartment" name="department" required>
            <option value="Computer Science">Computer Science</option>
            <option value="Information Technology">Information Technology</option>
        </select>
        <div class="invalid-feedback">Please select a department.</div>
    </div>
    <div class="form-group">
        <label for="addDob">Date of Birth</label>
        <input type="date" class="form-control" id="addDob" name="dob" required>
        <div class="invalid-feedback">Please provide a valid date of birth.</div>
    </div>
    <div class="form-group">
        <label for="addUsername">Username</label>
        <input type="text" class="form-control" id="addUsername" name="username" required>
        <div class="invalid-feedback">Please provide a username.</div>
    </div>
    <div class="form-group">
        <label for="addPassword">Password</label>
        <input type="password" class="form-control" id="addPassword" name="password" required>
        <div class="invalid-feedback">Please provide a password.</div>
    </div>
    
    <div class="modal-footer">
        <button type="submit" class="btn btn-primary">Save</button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
    </div>
</form>
                </div>
            </div>
        </div>
    </div>
    
    <div class="modal fade" id="confirmModal" tabindex="-1" role="dialog" aria-labelledby="confirmModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="confirmModalLabel">Delete Instructor</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    Are you sure you want to delete Student?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                    <a href="" type="submit" class="btn btn-danger" id="confirmDeleteLink" >Delete</a>
                </div>
            </div>
        </div>
    </div>
    <!-- Edit Modal -->
    <div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="editModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="editModalLabel">Edit Instructor</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form id="editForm" action="editInstructor">
                        <div class="form-group">
                            <label for="editFirstName">First Name</label>
                            <input type="text" class="form-control" id="editFirstName" name="firstname" required>
                        </div>
                        <div class="form-group">
                            <label for="editLastName">Last Name</label>
                            <input type="text" class="form-control" id="editLastName" name="lastname" required>
                        </div>
                        <div class="form-group">
                            <label for="editDepartment">Department</label>
                            <select class="form-control" id="editDepartment" name="department">
                                <option value="Computer Science">Computer Science</option>
                                <option value="Information Technology">Information Technology</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="editDob">Date of Birth</label>
                            <input type="date" class="form-control" id="editDob" name="dob" required>
                        </div>
                        <div class="form-group">
                            <label for="editUsername">Username</label>
                            <input type="text" class="form-control" id="editUsername" name="username" required>
                        </div>
                        <div class="form-group">
                            <label for="editPassword">Password</label>
                            <input type="password" class="form-control" id="editPassword" name="password" required>
                        </div>
                        <input type="number" id="editStudentId" name="studentId"> <!-- Hidden input for studentId -->
                        
                        <div class="modal-footer">
                            <button type="submit" class="btn btn-primary">Save changes</button>
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</main>

<script>
$(document).ready(function() {
    $('#instructorsTable').DataTable();
});

document.addEventListener('DOMContentLoaded', function() {
    document.querySelectorAll('.edit-student').forEach(button => {
        button.addEventListener('click', function() {
            const studentId = this.getAttribute('data-student-id');
            document.getElementById('editStudentId').value = studentId;
        });
    });
});

function populateEditModal(element) {
    var studentId = element.getAttribute('data-student-id');
    var row = element.closest('tr');
    var firstName = row.children[0].textContent;
    var lastName = row.children[1].textContent;
    var department = row.children[2].textContent;
    var dob = row.children[3].textContent;
    var username = row.children[4].textContent;
    var password = row.children[5].textContent;
    var studentId= row.children[6].textContent;
    console.log(studentId);
    document.getElementById('editFirstName').value = firstName;
    document.getElementById('editLastName').value = lastName;
    document.getElementById('editDepartment').value = department;
    document.getElementById('editDob').value = dob;
    document.getElementById('editUsername').value = username;
    document.getElementById('editPassword').value = password;
    document.getElementById('editStudentId').value = studentId; // Set the studentId in the hidden input
}

//function deleteRow(element) {
  //  var studentId = element.getAttribute('data-student-id');
   // var row = element.closest('tr');

    //if (confirm('Are you sure you want to delete this student?')) {
        // Make an AJAX request to the server to delete the student
      //  fetch(`${pageContext.request.contextPath}/AdminDeleteStudent`, {
        //    method: 'POST',
          //  headers: {
            //    'Content-Type': 'application/x-www-form-urlencoded',
          //  },
           // body: new URLSearchParams({ studentId: studentId })
       // })
       // .then(response => response.json())
       // .then(data => {
         //   if (data.success) {
           //     row.remove();
             //   alert('Student deleted successfully.');
         //   } else {
           //     alert('Failed to delete student.');
            //}
        //})
        //.catch(error => console.error('Error:', error));
   // }
//}
$('#confirmModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget);
        var studentId = button.data('student-id');
        
        var modal = $(this);
        var deleteLink = modal.find('#confirmDeleteLink');
        
        deleteLink.attr('href', 'DeleteInstructors?studentId=' + studentId);
    });
    
document.addEventListener('DOMContentLoaded', function() {
    const addForm = document.getElementById('addForm');

    addForm.addEventListener('submit', function(event) {
        let isValid = true;
        const firstName = document.getElementById('addFirstName');
        const lastName = document.getElementById('addLastName');
        const department = document.getElementById('addDepartment');
        const dob = document.getElementById('addDob');
        const username = document.getElementById('addUsername');
        const password = document.getElementById('addPassword');

        // Name validation pattern (letters only)
        const namePattern = /^[A-Za-z]+$/;

        if (!namePattern.test(firstName.value)) {
            firstName.classList.add('is-invalid');
            isValid = false;
        } else {
            firstName.classList.remove('is-invalid');
        }

        if (!namePattern.test(lastName.value)) {
            lastName.classList.add('is-invalid');
            isValid = false;
        } else {
            lastName.classList.remove('is-invalid');
        }

        if (!department.value) {
            department.classList.add('is-invalid');
            isValid = false;
        } else {
            department.classList.remove('is-invalid');
        }

        if (!dob.value) {
            dob.classList.add('is-invalid');
            isValid = false;
        } else {
            dob.classList.remove('is-invalid');
        }

        if (!username.value) {
            username.classList.add('is-invalid');
            isValid = false;
        } else {
            username.classList.remove('is-invalid');
        }

        if (!password.value) {
            password.classList.add('is-invalid');
            isValid = false;
        } else {
            password.classList.remove('is-invalid');
        }

        if (!isValid) {
            event.preventDefault();
        }
    });
});
</script>

</body>
</html>
