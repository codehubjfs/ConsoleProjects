<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Front Desk Staff</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asserts/css/admin/staff.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <style>
        .error-message {
    color: red;
    font-size: 0.875rem; /* Adjust font size as needed */
}
        
    </style>
    <% 
        HttpSession session1 = request.getSession(false);
        if (session1 == null || session1.getAttribute("username") == null) {
            response.sendRedirect("index.jsp");
        }
    %>
</head>
<body>
    <!-- Header -->
    <nav class="navbar navbar-expand-lg navbar-dark fixed-top bg-dark">
        <a class="navbar-brand" href="Dashboard"><img src="${pageContext.request.contextPath}/asserts/images/logo.jpg" alt="Logo"></a>
        <span class="navbar-text mx-auto"><span style="font-size: 30px; color:white">Rk Hotel Management</span></span>
        <div class="dropdown profile">
            <img src="${pageContext.request.contextPath}/asserts/images/admin.jpg" alt="Profile Picture" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <div class="dropdown-menu dropdown-menu-right">
                <a class="dropdown-item" href="admin">View Profile</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="logout">Sign Out</a>
            </div>
        </div>
    </nav>

    <!-- Sidebar -->
    <div class="sidebar">
      <div class="list-group">
        <a href="dashboard" class="list-group-item ">DASHBOARD</a>
        <a href="viewBookings" class="list-group-item ">Bookings</a>
        <a href="ListStaffServlet" class="list-group-item active" >Front Desk Staff</a>
        <a href="ListKeeperServlet" class="list-group-item">Housekeeper Staff</a>
        <a href="#roomsSubmenu" class="list-group-item dropdown-toggle" data-toggle="collapse">Rooms</a>
        <div class="collapse" id="roomsSubmenu">
          <a href="ShowRoom" class="list-group-item pl-5" >All Rooms</a>
          <a href="RoomType" class="list-group-item pl-5 ">Room Types</a>
        </div>
        <a href="payments" class="list-group-item">Invoice Details</a>
        <a href="Customers" class="list-group-item">Customers</a>
        <hr>
      </div>
    </div>

    <!-- Content -->
    <div class="container content">
        <!-- Breadcrumbs -->
        <nav aria-label="breadcrumb" style="--bs-breadcrumb-divider: '>'; "class="ml-auto">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="dashboard">Home</a></li>
                <li class="breadcrumb-item active" aria-current="page">Receptionist</li>
            </ol>
        </nav>

        <!-- Add Receptionist Button -->
        <div class="container mt-5">
            <div class="card">
                <div class="card-header">
                    <h2>Add Receptionist <i class="fas fa-user-plus"></i></h2>
                    <button type="button" class="btn btn-secondary" data-toggle="modal" data-target="#addReceptionistModal">Add Receptionist</button>
                </div>
                <div class="card-body">
                    <p>Use the add button above to add a new receptionist.</p>
                </div>
            </div>
        </div>
        
    

        <!-- Add Receptionist Modal -->
        <div class="modal fade ${not empty param.emailError || not empty param.phoneError ? 'show' : ''}" id="addReceptionistModal" tabindex="-1" role="dialog" aria-labelledby="addReceptionistModalLabel" aria-hidden="true" style="${not empty param.emailError || not empty param.phoneError ? 'display: block;' : ''}">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="addReceptionistModalLabel">Add Receptionist</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                          <form id="receptionistForm" action="InsertStaff" method="post" onsubmit="return validateForm()">
        <div class="form-group">
            <label for="receptionistName">Name</label>
            <input type="text" class="form-control" id="receptionistName" name="name" value="${param.name}">
            <small class="error-message" id="nameError">Invalid name. Only letters and spaces are allowed and must be at least 3 characters long.</small>
        </div>
        <div class="form-group">
            <label for="receptionistEmail">Email address</label>
            <input type="email" class="form-control" id="receptionistEmail" name="email" value="${param.email}">
            <small class="error-message" id="emailError">Invalid Email</small>
            <small class="error-message">${requestScope.emailError}</small>
        </div>
        <div class="form-group">
            <label for="receptionistPhone">Phone</label>
            <input type="text" class="form-control" id="receptionistPhone" name="phone_no" value="${param.phone_no}">
            <small class="error-message" id="phoneError">Enter 10 digits only</small>
            <small class="error-message">${requestScope.phoneError}</small>
        </div>
        <div class="form-group">
            <label for="receptionistPassword">Password</label>
            <input type="password" class="form-control" id="receptionistPassword" value="Welcome@123" name="password" required>
            <div class="form-check mt-2">
                <input type="checkbox" class="form-check-input" id="showPassword">
                <label class="form-check-label" for="showPassword">Show Password</label>
            </div>
            <small class="error-message" id="passwordError">Password should be at least 8 characters long.</small>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            <button type="submit" class="btn btn-primary">Save changes</button>
        </div>
    </form>
                    </div>
                </div>
            </div>
        </div>

        <!-- Edit Receptionist Modal -->
        <div class="modal fade" id="editReceptionistModal" tabindex="-1" role="dialog" aria-labelledby="editReceptionistModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="editReceptionistModalLabel">Edit Receptionist</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form id="editReceptionistForm" action="editStaff" method="post" onsubmit="return validateEditForm()">
                            <input type="hidden" id="editReceptionistEmail" name="email">
                            <div class="form-group">
                                <label for="editReceptionistName">Name</label>
                                <input type="text" class="form-control" id="editReceptionistName" name="name">
                                <div class="invalid-feedback">Please enter a name. Only letters and spaces are allowed and must be at least 3 characters long.</div>
                            </div>
                            <div class="form-group">
                                <label for="editReceptionistPhone">Phone</label>
                                <input type="text" class="form-control" id="editReceptionistPhone" name="phone_no">
                                <div class="invalid-feedback">Please enter a valid phone number. Only 10 digits are allowed.</div>
                            </div>
                            <div class="form-group">
                                <label for="editReceptionistPassword">Password</label>
                                <input type="password" class="form-control" id="editReceptionistPassword" name="password">
                                <div class="form-check mt-2">
                                    <input type="checkbox" class="form-check-input" id="editShowPassword">
                                    <label class="form-check-label" for="editShowPassword">Show Password</label>
                                </div>
                                <div class="invalid-feedback">Password should be at least 8 characters long.</div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                <button type="submit" class="btn btn-primary">Save changes</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

       <!-- Delete Receptionist Modal -->
<div class="modal fade" id="deleteReceptionistModal" tabindex="-1" role="dialog" aria-labelledby="deleteReceptionistModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="deleteReceptionistModalLabel">Delete Receptionist</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id="deleteReceptionistForm" action="deleteStaff" method="post">
                    <p>Are you sure you want to delete this receptionist?</p>
                    <input type="hidden" id="deleteReceptionistEmail" name="email">
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-danger">Delete</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>


        <!-- Staff List -->
        <div class="container mt-5">
            <div class="card">
                <div class="card-header">
                    <h2>Receptionist Staff List</h2>
                </div>
                <div class="card-body">
                    <c:choose>
                        <c:when test="${not empty staffList}">
                            <div class="table-responsive">
                                <table class="table table-bordered table-hover">
                                    <thead class="thead-dark">
                                        <tr>
                                              <th>Staff ID</th>
								                <th>Name</th>
								                <th>Email</th>
								                <th>Phone</th>
                                            <th>Actions</th>
                                        </tr>
                                    </thead>
                                     <tbody>
            <c:forEach var="staff" items="${staffList}">
                <tr>
                    <td>${staff.staff_id}</td>
                    <td>${staff.name}</td>
                    <td>${staff.email}</td>
                    <td>${staff.phone_no}</td>
                         <td>
                                        <button class="btn btn-primary btn-sm" onclick="editStaff(${staff.staff_id}, '${staff.name}', '${staff.email}', '${staff.phone_no}', '${staff.password}')">Edit</button>
                                        <button class="btn btn-danger btn-sm" onclick="deleteStaff('${staff.email}')">Delete</button>
                                    </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <p>No receptionist staff found.</p>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
    </div>
    <script>
    function editStaff(staff_id, name, email, phone_no, password) {
        // Implement your edit logic here, for example, showing a modal with prefilled values
        console.log("Editing staff:", staff_id, name, email, phone_no, password);
        // Example: Open a modal and set values
        $('#editStaffModal').modal('show'); // Example modal show
        // Set values in modal fields
        $('#editStaffName').val(name);
        $('#editStaffEmail').val(email);
        $('#editStaffphone_no').val(phone_no);
        $('#editstaff_id').val(staff_id); // Assuming you have hidden input fields in your modal for staffId
        // Repeat for other fields like password if needed
    }

    function deleteStaff(email) {
        // Implement your delete logic here, for example, confirming deletion and then submitting a form
        console.log("Deleting staff:", email);
        if (confirm("Are you sure you want to delete this staff member?")) {
            // Example: Submit a form for deletion
            $('#deleteStaffForm input[name="email"]').val(email);
            $('#deleteStaffForm').submit(); // Assuming you have a form with id deleteStaffForm
        }
    }
</script>

    <!-- JavaScript -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script>
        document.getElementById("showPassword").addEventListener("change", function() {
            let passwordInput = document.getElementById("receptionistPassword");
            passwordInput.type = this.checked ? "text" : "password";
        });

        document.getElementById("editShowPassword").addEventListener("change", function() {
            let passwordInput = document.getElementById("editReceptionistPassword");
            passwordInput.type = this.checked ? "text" : "password";
        });

        function validateEditForm() {
            let name = document.getElementById('editReceptionistName').value;
            let phone = document.getElementById('editReceptionistPhone').value;
            let password = document.getElementById('editReceptionistPassword').value;

            let nameRegex = /^[A-Za-z\s]{3,}$/;
            let phoneRegex = /^\d{10}$/;

            let isValid = true;

            if (!nameRegex.test(name)) {
                document.getElementById('editReceptionistName').classList.add('is-invalid');
                isValid = false;
            } else {
                document.getElementById('editReceptionistName').classList.remove('is-invalid');
            }

            if (!phoneRegex.test(phone)) {
                document.getElementById('editReceptionistPhone').classList.add('is-invalid');
                isValid = false;
            } else {
                document.getElementById('editReceptionistPhone').classList.remove('is-invalid');
            }

            if (password.length < 8) {
                document.getElementById('editReceptionistPassword').classList.add('is-invalid');
                isValid = false;
            } else {
                document.getElementById('editReceptionistPassword').classList.remove('is-invalid');
            }

            return isValid;
        }


        function validateEditForm() {
            let valid = true;
            const name = document.getElementById("editReceptionistName").value;
            const phone = document.getElementById("editReceptionistPhone").value;
            const password = document.getElementById("editReceptionistPassword").value;

            if (!/^[A-Za-z\s]{3,}$/.test(name)) {
                document.getElementById("editReceptionistName").classList.add("is-invalid");
                valid = false;
            } else {
                document.getElementById("editReceptionistName").classList.remove("is-invalid");
            }

            if (!/^\d{10}$/.test(phone)) {
                document.getElementById("editReceptionistPhone").classList.add("is-invalid");
                valid = false;
            } else {
                document.getElementById("editReceptionistPhone").classList.remove("is-invalid");
            }

            if (password.length < 8) {
                document.getElementById("editReceptionistPassword").classList.add("is-invalid");
                valid = false;
            } else {
                document.getElementById("editReceptionistPassword").classList.remove("is-invalid");
            }

            return valid;
        }

        function editStaff(staffId, name, email, phoneNo, password) {
            document.getElementById('editReceptionistName').value = name;
            document.getElementById('editReceptionistEmail').value = email;
            document.getElementById('editReceptionistPhone').value = phoneNo;
            document.getElementById('editReceptionistPassword').value = password;
            $('#editReceptionistModal').modal('show');
        }

        function deleteStaff(email) {
            document.getElementById('deleteReceptionistEmail').value = email;
            $('#deleteReceptionistModal').modal('show');
        }

    </script>
 <script>
    function validateForm() {
        var name = document.getElementById("receptionistName").value.trim();
        var email = document.getElementById("receptionistEmail").value.trim();
        var phone = document.getElementById("receptionistPhone").value.trim();
        var password = document.getElementById("receptionistPassword").value.trim();

        var nameError = document.getElementById("nameError");
        var emailError = document.getElementById("emailError");
        var phoneError = document.getElementById("phoneError");
        var passwordError = document.getElementById("passwordError");

        passwordError.innerHTML = "";
        nameError.innerHTML = "";
        emailError.innerHTML = "";
        phoneError.innerHTML = "";

        var isValid = true;

        var nameRegex = /^[a-zA-Z\s]{3,}$/;
        if (name === "") {
            nameError.innerHTML = "Name is required";
            nameError.style.color = "red";
            isValid = false;
        } else if (!nameRegex.test(name)) {
            nameError.innerHTML = "Name must be at least 3 characters long and contain only letters and spaces";
            nameError.style.color = "red";
            isValid = false;
        }

        // Validate email
        var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if (email === "") {
            emailError.innerHTML = "Email is required";
            emailError.style.color = "red";
            isValid = false;
        } else if (!emailRegex.test(email)) {
            emailError.innerHTML = "Invalid email format";
            emailError.style.color = "red";
            isValid = false;
        }

        

        if (phone === "") {
            phoneError.innerHTML = "Phone number is required";
            phoneError.style.color = "red";
            isValid = false;
        } else if (!/^\d{10}$/.test(phone)) {
            phoneError.innerHTML = "Enter a valid 10-digit phone number";
            phoneError.style.color = "red"; 
            isValid = false;
        }


        if (password === "") {
            passwordError.innerHTML = "Password is required";
            passwordError.style.color = "red";
            isValid = false;
        } else if (password.length < 8) {
            passwordError.innerHTML = "Password should be at least 8 characters long.";
            passwordError.style.color = "red";
            isValid = false;
        }

        return isValid;
    }
</script>

    
</body>
</html>
