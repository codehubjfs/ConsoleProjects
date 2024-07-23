<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Front Desk Staff</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin/adminStaff.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
     <style>
        .error-message {
    display: none;
    color: red;
    font-size: 0.875rem;
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
            <a class="navbar-brand" href="./main.html"><img src="./images/logo.jpg" alt="Logo"></a>
            <span class="navbar-text mx-auto"><span style="font-size: 30px; color:white">Rk Hotel Management</span></span>
            <div class="dropdown profile">
                <img src="../../images/admin.jpg" alt="Profile Picture" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <div class="dropdown-menu dropdown-menu-right">
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/ViewProfileServlet">View Profile</a>
                <a class="dropdown-item" href="${pageContext.request.contextPath}/views/admin/account.jsp">Account Settings</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="${pageContext.request.contextPath}/LogoutAdminServlet">Sign Out</a>
                </div>
            </div>
        </nav>
    
        <!-- Sidebar -->
       <div class="sidebar">
      <div class="list-group">
        <a href="${pageContext.request.contextPath}/views/admin/dashboard.jsp" class="list-group-item ">DASHBOARD</a>
        <a href="${pageContext.request.contextPath}/ViewBooking" class="list-group-item ">Bookings</a>
        <a href="${pageContext.request.contextPath}/ListStaffServlet" class="list-group-item active">Front Desk Staff</a>
        <a href="${pageContext.request.contextPath}/ListKeeperServlet" class="list-group-item">Housekeeper Staff</a>
        <a href="#roomsSubmenu" class="list-group-item dropdown-toggle" data-toggle="collapse">Rooms</a>
        <div class="collapse" id="roomsSubmenu">
          <a href="${pageContext.request.contextPath}/ListRoomsServlet" class="list-group-item pl-5" >All Rooms</a>
          <a href="${pageContext.request.contextPath}/ListRoomTypeServlet" class="list-group-item pl-5 ">Room Types</a>
        </div>
        <a href="${pageContext.request.contextPath}/views/admin/invoice.jsp" class="list-group-item">Invoice Details</a>
        <a href="${pageContext.request.contextPath}/ViewCustomer" class="list-group-item">Customers</a>
        <hr>
        <a href="${pageContext.request.contextPath}/views/admin/settings.jsp" class="list-group-item">Settings</a>
      </div>
    </div>
    
        <!-- Content -->
        <div class="container content">
            <!-- Breadcrumbs -->
            <nav aria-label="breadcrumb" style="--bs-breadcrumb-divider: '>';">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/views/admin/dashboard.jsp">Home</a></li>
                    <li class="breadcrumb-item active" aria-current="page">Receptionist</li>
                </ol>
            </nav>
    
            <!-- Add Receptionist Button -->
            <div class="container mt-5">
                <div class="card">
                    <div class="card-header">
                        <h2>Add Receptionist <svg xmlns="http://www.w3.org/2000/svg" width="35" height="45" fill="currentColor" class="bi bi-person-fill-add" viewBox="0 0 16 16" >
                            <path d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7m.5-5v1h1a.5.5 0 0 1 0 1h-1v1a.5.5 0 0 1-1 0v-1h-1a.5.5 0 0 1 0-1h1v-1a.5.5 0 0 1 1 0m-2-6a3 3 0 1 1-6 0 3 3 0 0 1 6 0"/>
                            <path d="M2 13c0 1 1 1 1 1h5.256A4.5 4.5 0 0 1 8 12.5a4.5 4.5 0 0 1 1.544-3.393Q8.844 9.002 8 9c-5 0-6 3-6 4"/>
                        </svg></h2>
                        <button type="button" class="btn btn-secondary" data-toggle="modal" data-target="#addReceptionistModal">Add Receptionist</button>
                    </div>
                    <div class="card-body">
                        <p>Use the add button above to add a new receptionist.</p>
                    </div>
                </div>
            </div>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
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
                   <form id="receptionistForm" action="${pageContext.request.contextPath}/InsertStaffServlet" method="post" onsubmit="return validateForm()">
    <div class="form-group">
        <label for="receptionistName">Name</label>
        <input type="text" class="form-control" id="receptionistName" name="name" value="${param.name}" >
        <small class="error-message" id="nameError">Invalid name. Only letters and spaces are allowed and must be at least 3 characters long.</small>
    </div>
    <div class="form-group">
        <label for="receptionistEmail">Email address</label>
        <input type="email" class="form-control" id="receptionistEmail" name="email" value="${param.email}" >
        <small class="error-message" id="receptionistEmail">Invalid Email </small>
                        <small class="error-message">${requestScope.emailError}</small>
    </div>
    <div class="form-group">
        <label for="receptionistPhone">Phone</label>
        <input type="text" class="form-control" id="receptionistPhone" name="phone" value="${param.phone}">
        <small class="error-message" id="receptionistPhone">Enter 10 digits only </small>
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
                <form id="editReceptionistForm" action="${pageContext.request.contextPath}/EditStaffServlet" method="post" onsubmit="return validateEditForm()">
                    <input type="hidden" id="editReceptionistEmail" name="email">
                    <div class="form-group">
                        <label for="editReceptionistName">Name</label>
                        <input type="text" class="form-control" id="editReceptionistName" name="name">
                        <div class="invalid-feedback">Please enter a name. Only letters and spaces are allowed and must be at least 3 characters long.</div>
                    </div>
                    <div class="form-group">
                        <label for="editReceptionistEmailDisplay">Email address</label>
                        <input type="email" class="form-control" id="editReceptionistEmailDisplay" disabled>
                        <div class="invalid-feedback">Please enter a valid email address.</div>
                    </div>
                    <div class="form-group">
                        <label for="editReceptionistPhone">Phone</label>
                        <input type="text" class="form-control" id="editReceptionistPhone" name="phone">
                        <div class="invalid-feedback">Please enter a valid phone number. It should be 10 digits.</div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="submit" class="btn btn-primary" id="saveEditReceptionistBtn">Save Changes</button>
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
                <p>Are you sure you want to delete this receptionist?</p>
                <form id="deleteReceptionistForm" action="${pageContext.request.contextPath}/DeleteServlet" method="post">
                    <input type="hidden" id="staffEmail" name="email" />
                </form>
            </div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="submit" class="btn btn-danger" id="confirmDeleteReceptionistBtn">Delete</button>
            </div>
        </div>
    </div>
</div>

    		
            <!-- Receptionist Table -->
            <div class="container mt-5">
              <h2 style="text-align: center;">Receptionist Info</h2>
                <table class="table">
                    <thead class="thead-dark">
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Name</th>
                            <th scope="col">Email</th>
                            <th scope="col">Phone</th>
                           
                            <th scope="col">Actions</th>
                        </tr>
                    </thead>
                     <tbody>
    <c:forEach var="staff" items="${listStaff}">
        <tr>
            <th scope="row">${staff.id}</th>
            <td>${staff.name}</td>
            <td>${staff.email}</td>
            <td>${staff.phone}</td>
            <td>
                <!-- Edit Button -->
              <!-- Your button to trigger modal should have the email attribute -->
<a href="#" class="edit-btn" data-toggle="modal" data-target="#editReceptionistModal"
    data-id="${staff.id}" data-name="${staff.name}"
    data-email="${staff.email}" data-phone="${staff.phone}">
    <i class="fas fa-edit"></i> <!-- Edit Icon -->
</a>


               <!-- Delete Button -->
<a href="#" class="delete-btn" data-toggle="modal" data-target="#deleteReceptionistModal" data-email="${staff.email}">
    <i class="fas fa-trash"></i> <!-- Delete Icon -->
</a>
            </td>
        </tr>
    </c:forEach>
</tbody>
                </table>
            </div>
        </div>
        
        
        <script>
        $(document).ready(function () {
            $('#editReceptionistModal').on('show.bs.modal', function (event) {
                var button = $(event.relatedTarget); // Button that triggered the modal
                var email = button.data('email'); // Extract info from data-* attributes

                // Load the content of the modal with the existing data
                $.get("${pageContext.request.contextPath}/EditStaffServlet", { email: email }, function (data) {
                    $('#editReceptionistModal .modal-body').html(data);
                });
            });
        });
        </script>
        </script>
        <script>
        document.getElementById('showPassword').addEventListener('change', function() {
            var passwordField = document.getElementById('receptionistPassword');
            if (this.checked) {
                passwordField.type = 'text';
            } else {
                passwordField.type = 'password';
            }
        });

        // Function to validate name
        function validateName() {
            var name = document.getElementById('receptionistName').value.trim();
            var nameError = document.getElementById('nameError');
            var nameRegex = /^[a-zA-Z\s]+$/;

            if (name && !nameRegex.test(name)) {
                nameError.style.display = 'block';
            } else {
                nameError.style.display = 'none';
            }
        }

        // Function to validate email
        function validateEmail() {
            var email = document.getElementById('receptionistEmail').value.trim();
            var emailError = document.getElementById('emailError');
            var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

            if (email && !emailRegex.test(email)) {
                emailError.style.display = 'block';
            } else {
                emailError.style.display = 'none';
            }
        }

        // Function to validate phone
        function validatePhone() {
            var phone = document.getElementById('receptionistPhone').value.trim();
            var phoneError = document.getElementById('phoneError');
            var phoneRegex = /^\d{10}$/;

            if (phone && !phoneRegex.test(phone)) {
                phoneError.style.display = 'block';
            } else {
                phoneError.style.display = 'none';
            }
        }

        // Function to validate password
        function validatePassword() {
            var password = document.getElementById('receptionistPassword').value.trim();
            var passwordError = document.getElementById('passwordError');

            if (password && password.length < 8) {
                passwordError.style.display = 'block';
            } else {
                passwordError.style.display = 'none';
            }
        }

        // Add event listeners to input fields
        document.getElementById('receptionistName').addEventListener('input', validateName);
        document.getElementById('receptionistEmail').addEventListener('input', validateEmail);
        document.getElementById('receptionistPhone').addEventListener('input', validatePhone);
        document.getElementById('receptionistPassword').addEventListener('input', validatePassword);

        // Function to validate form on submit
        function validateForm() {
            validateName();
            validateEmail();
            validatePhone();
            validatePassword();

            // Check if there are any error messages displayed
            var nameError = document.getElementById('nameError').style.display !== 'none';
            var emailError = document.getElementById('emailError').style.display !== 'none';
            var phoneError = document.getElementById('phoneError').style.display !== 'none';
            var passwordError = document.getElementById('passwordError').style.display !== 'none';

            // Prevent form submission if any error messages are displayed
            if (nameError || emailError || phoneError || passwordError) {
                return false;
            }
            return true;
        }
        </script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script>
        
        document.addEventListener('DOMContentLoaded', function() {
            let confirmBtn = document.getElementById('confirmDeleteReceptionistBtn');
            let staffEmailInput = document.getElementById('staffEmail');

            $('#deleteReceptionistModal').on('show.bs.modal', function (event) {
                let button = $(event.relatedTarget);
                let staffEmail = button.data('email');
                staffEmailInput.value = staffEmail;
            });

            confirmBtn.addEventListener('click', function() {
                document.getElementById('deleteReceptionistForm').submit();
            });
        });

        
        
        document.getElementById('showPassword').addEventListener('click', function() {
            var passwordField = document.getElementById('receptionistPassword');
            if (this.checked) {
                passwordField.type = 'text';
            } else {
                passwordField.type = 'password';
            }
        });
        
    </script>
    
    <script>
    
    function openEditModal(receptionist) {
        document.getElementById('editReceptionistEmail').value = receptionist.email;
        document.getElementById('editReceptionistEmailDisplay').value = receptionist.email;
        document.getElementById('editReceptionistName').value = receptionist.name;
        document.getElementById('editReceptionistPhone').value = receptionist.phone;
        $('#editReceptionistModal').modal('show');
    }

    document.addEventListener('DOMContentLoaded', function () {
        document.getElementById('showPassword').addEventListener('change', function () {
            const passwordInput = document.getElementById('receptionistPassword');
            if (this.checked) {
                passwordInput.type = 'text';
            } else {
                passwordInput.type = 'password';
            }
        });

        document.getElementById('saveEditReceptionistBtn').addEventListener('click', function () {
            document.getElementById('editReceptionistForm').submit();
        });
    });

    function validateForm() {
        let isValid = true;

        const name = document.getElementById('receptionistName').value;
        const email = document.getElementById('receptionistEmail').value;
        const phone = document.getElementById('receptionistPhone').value;

        if (!/^[a-zA-Z\s]{3,}$/.test(name)) {
            isValid = false;
            document.getElementById('nameError').style.display = 'block';
        } else {
            document.getElementById('nameError').style.display = 'none';
        }

        if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email)) {
            isValid = false;
            document.getElementById('emailError').style.display = 'block';
        } else {
            document.getElementById('emailError').style.display = 'none';
        }

        if (!/^\d{10}$/.test(phone)) {
            isValid = false;
            document.getElementById('phoneError').style.display = 'block';
        } else {
            document.getElementById('phoneError').style.display = 'none';
        }

        return isValid;
    }

    function validateEditForm() {
        let isValid = true;

        const name = document.getElementById('editReceptionistName').value;
        const email = document.getElementById('editReceptionistEmail').value;
        const phone = document.getElementById('editReceptionistPhone').value;

        if (!/^[a-zA-Z\s]+$/.test(name)) {
            isValid = false;
            document.getElementById('editReceptionistName').classList.add('is-invalid');
        } else {
            document.getElementById('editReceptionistName').classList.remove('is-invalid');
        }

        if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email)) {
            isValid = false;
            document.getElementById('editReceptionistEmail').classList.add('is-invalid');
        } else {
            document.getElementById('editReceptionistEmail').classList.remove('is-invalid');
        }

        if (!/^\d{10}$/.test(phone)) {
            isValid = false;
            document.getElementById('editReceptionistPhone').classList.add('is-invalid');
        } else {
            document.getElementById('editReceptionistPhone').classList.remove('is-invalid');
        }

        return isValid;
    }

    </script>
    <script>
    document.addEventListener('DOMContentLoaded', function () {
        document.getElementById('showPassword').addEventListener('change', function () {
            const passwordInput = document.getElementById('receptionistPassword');
            if (this.checked) {
                passwordInput.type = 'text';
            } else {
                passwordInput.type = 'password';
            }
        });

        document.getElementById('saveEditReceptionistBtn').addEventListener('click', function () {
            document.getElementById('editReceptionistForm').submit();
        });
    });

    function validateForm() {
        let isValid = true;

        const name = document.getElementById('receptionistName').value;
        const email = document.getElementById('receptionistEmail').value;
        const phone = document.getElementById('receptionistPhone').value;

        if (!/^[a-zA-Z\s]{3,}$/.test(name)) {
            isValid = false;
            document.getElementById('nameError').style.display = 'block';
        } else {
            document.getElementById('nameError').style.display = 'none';
        }

        if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email)) {
            isValid = false;
            document.getElementById('emailError').style.display = 'block';
        } else {
            document.getElementById('emailError').style.display = 'none';
        }

        if (!/^\d{10}$/.test(phone)) {
            isValid = false;
            document.getElementById('phoneError').style.display = 'block';
        } else {
            document.getElementById('phoneError').style.display = 'none';
        }

        return isValid;
    }

    function validateEditForm() {
        let isValid = true;

        const name = document.getElementById('editReceptionistName').value;
        const email = document.getElementById('editReceptionistEmailDisplay').value; // Display email for validation
        const phone = document.getElementById('editReceptionistPhone').value;

        if (!/^[a-zA-Z\s]{3,}$/.test(name)) {
            isValid = false;
            document.getElementById('editReceptionistName').classList.add('is-invalid');
        } else {
            document.getElementById('editReceptionistName').classList.remove('is-invalid');
        }

        if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email)) {
            isValid = false;
            document.getElementById('editReceptionistEmailDisplay').classList.add('is-invalid');
        } else {
            document.getElementById('editReceptionistEmailDisplay').classList.remove('is-invalid');
        }

        if (!/^\d{10}$/.test(phone)) {
            isValid = false;
            document.getElementById('editReceptionistPhone').classList.add('is-invalid');
        } else {
            document.getElementById('editReceptionistPhone').classList.remove('is-invalid');
        }

        return isValid;
    }

    function openEditModal(receptionist) {
        document.getElementById('editReceptionistEmail').value = receptionist.email;
        document.getElementById('editReceptionistEmailDisplay').value = receptionist.email;
        document.getElementById('editReceptionistName').value = receptionist.name;
        document.getElementById('editReceptionistPhone').value = receptionist.phone;
        $('#editReceptionistModal').modal('show');
    }

    
    </script>
    </body>
    </html>
    