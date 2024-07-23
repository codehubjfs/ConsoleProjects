<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Housekeeper Staff Management</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asserts/css/admin/keeper.css">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <style>
      .content {
            margin-left: 250px; /* Adjust this value according to your sidebar width */
            padding: 20px;
        }

   
    
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark fixed-top bg-dark">
    <a class="navbar-brand" href="Dashboard">
        <img src="${pageContext.request.contextPath}/asserts/images/logo.jpg" alt="Logo"/>
    </a>
    <span class="navbar-text mx-auto">
        <span style="font-size: 30px; color:white">Rk Hotel Management</span>
    </span>
   <div class="dropdown profile">
            <img src="${pageContext.request.contextPath}/asserts/images/admin.jpg" alt="Profile Picture" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <div class="dropdown-menu dropdown-menu-right">
                <a class="dropdown-item" href="admin">View Profile</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="logout">Sign Out</a>
            </div>
        </div>
</nav>

<div class="sidebar">
      <div class="list-group">
        <a href="dashboard" class="list-group-item ">DASHBOARD</a>
        <a href="viewBookings" class="list-group-item ">Bookings</a>
        <a href="ListStaffServlet" class="list-group-item">Front Desk Staff</a>
        <a href="ListKeeperServlet" class="list-group-item active">Housekeeper Staff</a>
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

<div class="container content">
    <nav aria-label="breadcrumb" style="--bs-breadcrumb-divider: '>';" class="ml-auto">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="dashboard">Home</a></li>
            <li class="breadcrumb-item active" aria-current="page">Housekeeper</li>
        </ol>
    </nav>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    <div class="container mt-5">
        <div class="card">
            <div class="card-header">
                <h2>Add HouseKeeper</h2>
                <button type="button" class="btn btn-secondary" data-toggle="modal" data-target="#addHousekeeperModal">
                    Add Housekeeper
                </button>
            </div>
            <div class="card-body">
                <p>Use the add button above to add a new staff.</p>
            </div>
        </div>
    </div>

    <div class="container mt-5">
        <h3 style="text-align: center; margin-top:1%">Housekeeper Info</h3>
        <table id="personTable" class="table booking-table">
            <thead class="thead-dark">
                 <tr>
        <th scope="col">Serial No</th>
        <th scope="col">Keeper Name</th>
        <th scope="col">Email</th>
        <th scope="col">Phone-No</th>
        <th scope="col">Status</th>
        <th scope="col">Actions</th>
   				 </tr>

            </thead>
            <tbody>
    <c:forEach var="keeper" items="${keeperList}" varStatus="loop">
        <tr>
            <td><c:out value="${loop.index + 1}"/></td>
            <td><c:out value="${keeper.name}"/></td>
            <td><c:out value="${keeper.email}"/></td>
            <td><c:out value="${keeper.phone_no}"/></td>	
            <td><c:out value="${keeper.status}"/></td> <!-- Display status here -->
            <td>
    <!-- Edit Button -->
    <button type="button" class="btn btn-primary btn-sm edit-btn" data-toggle="modal" data-target="#editHousekeeperModal"
        data-id="${keeper.keeper_id}"
        data-name="${keeper.name}"
        data-email="${keeper.email}"
        data-phone="${keeper.phone_no}"
        data-status="${keeper.status}">
        Edit
    </button>

    <!-- Space between buttons -->
    <span style="margin-left: 10px;"></span>

    <!-- Delete Button -->
    <a href="#" class="btn btn-danger btn-sm" onclick="prepareDelete('${keeper.email}')">Delete</a>
</td>

        </tr>
    </c:forEach>
</tbody>
        </table>
    </div>

    <nav aria-label="Page navigation">
        <ul class="pagination justify-content-center">
            <li class="page-item disabled">
                <a class="page-link" href="#" tabindex="-1" aria-disabled="true">Previous</a>
            </li>
            <li class="page-item"><a class="page-link" href="#">1</a></li>
            <li class="page-item"><a class="page-link" href="#">2</a></li>
            <li class="page-item"><a class="page-link" href="#">3</a></li>
            <li class="page-item">
                <a class="page-link" href="#">Next</a>
            </li>
        </ul>
    </nav>
</div>

		<!-- Add Housekeeper Modal -->
<div class="modal fade" id="addHousekeeperModal" tabindex="-1" role="dialog" aria-labelledby="addHousekeeperModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="addHousekeeperModalLabel">Add Housekeeper</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
              <form id="addHousekeeperForm" action="${pageContext.request.contextPath}/InsertKeeperServlet" method="post" onsubmit="return validateForm()">
                    <div class="form-group">
                        <label for="housekeeperName">Name</label>
                        <input type="text" class="form-control" id="housekeeperName" name="name">
                        <small class="error-message" id="nameError"></small>
                    </div>
                    <div class="form-group">
                        <label for="housekeeperEmail">Email</label>
                        <input type="email" class="form-control" id="housekeeperEmail" name="email">
                        <small class="error-message" id="emailError"></small>
                    </div>
                    <div class="form-group">
                        <label for="housekeeperPhone">Phone</label>
                        <input type="text" class="form-control" id="housekeeperPhone" name="phone_no">
                        <small class="error-message" id="phoneError"></small>
                    </div>
                    <div class="form-group">
                        <label for="housekeeperPassword">Password</label>
                        <input type="password" class="form-control" id="housekeeperPassword" name="password" value="Welcome@123">
                        <div class="form-check mt-2">
                            <input type="checkbox" class="form-check-input" id="showPasswordCheck" onclick="togglePassword()">
                            <label class="form-check-label" for="showPasswordCheck">Show Password</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="housekeeperStatus">Status</label>
                        <select class="form-control" id="housekeeperStatus" name="status">
                            <option value="Available">Available</option>
                            <option value="Not Available">Not Available</option>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-primary">Add Housekeeper</button>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- Edit Housekeeper Modal -->
<div class="modal fade" id="editHousekeeperModal" tabindex="-1" role="dialog" aria-labelledby="editHousekeeperModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="editHousekeeperModalLabel">Edit Housekeeper</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id="editHousekeeperForm" action="EditKeeper" method="post">
                    <input type="hidden" id="editHousekeeperId" name="id"> <!-- Hidden field for ID -->
                    <div class="form-group">
                        <label for="editHousekeeperName">Name</label>
                        <input type="text" class="form-control" id="editHousekeeperName" name="name" value="${keeper.name}" required>
                        <small class="text-danger">${error}</small>
                    </div>
                    <div class="form-group">
                        <label for="editHousekeeperEmail">Email</label>
                        <input type="email" class="form-control" id="editHousekeeperEmail" name="email" value="${keeper.email}" readonly>
                    </div>
                    <div class="form-group">
                        <label for="editHousekeeperPhone">Phone-No</label>
                        <input type="text" class="form-control" id="editHousekeeperPhone" name="phone_no" value="${keeper.phone_no}" required>
                        <small class="text-danger">${error}</small>
                    </div>
                    <div class="form-group">
                        <label for="editHousekeeperStatus">Status</label>
                        <select class="form-control" id="editHousekeeperStatus" name="status" required>
                            <option value="Available" ${keeper.status == 'Available' ? 'selected' : ''}>Available</option>
                            <option value="Not Available" ${keeper.status == 'Not Available' ? 'selected' : ''}>Not Available</option>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-primary">Save Changes</button>
                    <small class="text-success">${message}</small>
                    <small class="text-danger">${error}</small>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- Delete Housekeeper Modal -->
<div class="modal fade" id="deleteHousekeeperModal" tabindex="-1" role="dialog" aria-labelledby="deleteHousekeeperModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="deleteHousekeeperModalLabel">Delete Housekeeper</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id="deleteHousekeeperForm" action="${pageContext.request.contextPath}/DeleteKeeperServlet" method="post">
                    <!-- Hidden input to store housekeeper's email -->
                    <input type="hidden" id="deleteHousekeeperEmail" name="email">
                    <p>Are you sure you want to delete this housekeeper?</p>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                    <button type="submit" class="btn btn-danger">Delete</button>
                </form>
            </div>
        </div>
    </div>
</div>

<script>
    function prepareDelete(email) {
        document.getElementById('deleteHousekeeperEmail').value = email;
        $('#deleteHousekeeperModal').modal('show'); // Show the modal
    }
</script>

<script>
    $('#editHousekeeperModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget); // Button that triggered the modal
        var name = button.data('name'); // Extract info from data-* attributes
        var email = button.data('email');
        var phone = button.data('phone');
        var status = button.data('status');

        var modal = $(this);
        modal.find('.modal-title').text('Edit Housekeeper');
        modal.find('#editHousekeeperName').val(name);
        modal.find('#editHousekeeperEmail').val(email);
        modal.find('#editHousekeeperPhone').val(phone);
        modal.find('#editHousekeeperStatus').val(status);
    });
</script>
<script>
    document.addEventListener('DOMContentLoaded', function () {
        // Event listener for edit buttons
        var editButtons = document.querySelectorAll('.edit-btn');
        editButtons.forEach(function (button) {
            button.addEventListener('click', function (event) {
                event.preventDefault(); // Prevent default link behavior

                // Extract data attributes from the clicked button
                var id = button.getAttribute('data-id');
                var name = button.getAttribute('data-name');
                var email = button.getAttribute('data-email');
                var phone = button.getAttribute('data-phone');
                var status = button.getAttribute('data-status');

                // Populate the modal fields with extracted data
                document.getElementById('editHousekeeperId').value = id;
                document.getElementById('editHousekeeperName').value = name;
                document.getElementById('editHousekeeperEmail').value = email;
                document.getElementById('editHousekeeperPhone').value = phone;
                document.getElementById('editHousekeeperStatus').value = status;
            });
        });

        // Validation function for the edit form (replace with your validation logic)
        function validateEditForm() {
            // Example validation (add your specific validation rules)
            var name = document.getElementById('editHousekeeperName').value.trim();
            var email = document.getElementById('editHousekeeperEmail').value.trim();
            var phone = document.getElementById('editHousekeeperPhone').value.trim();

            if (name.length === 0 || email.length === 0 || phone.length === 0) {
                alert('Please fill out all fields.');
                return false;
            }

            // Example email validation (add your specific validation)
            var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            if (!emailRegex.test(email)) {
                alert('Please enter a valid email address.');
                return false;
            }

            // Example phone number validation (add your specific validation)
            var phoneRegex = /^\d{10}$/;
            if (!phoneRegex.test(phone)) {
                alert('Please enter a valid phone number (10 digits).');
                return false;
            }

            // Form is valid
            return true;
        }
    });
</script>

 <script>
 function validateEditHousekeeperForm() {
	    let isValid = true;

	    // Validate name
	    const name = document.getElementById('editHousekeeperName').value;
	    const nameError = document.getElementById('nameError');
	    const nameRegex = /^[a-zA-Z\s]{3,}$/;
	    if (!nameRegex.test(name)) {
	        nameError.textContent = "Name must be at least 3 characters long and contain only letters.";
            nameError.style.color = "red";

	        isValid = false;
	    } else {
	        nameError.textContent = "";
	    }

	    // Validate email
	    const email = document.getElementById('editHousekeeperEmail').value;
	    const emailError = document.getElementById('emailError');
	    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
	    if (!emailRegex.test(email)) {
	        emailError.textContent = "Invalid email format.";
            emailError.style.color = "red";

	        isValid = false;
	    } else {
	        emailError.textContent = "";
	    }

	    // Validate phone number
	    const phone = document.getElementById('editHousekeeperPhone').value;
	    const phoneError = document.getElementById('phoneError');
	    const phoneRegex = /^\d{10}$/;
	    if (!phoneRegex.test(phone)) {
	        phoneError.textContent = "Phone number must be exactly 10 digits.";
            phoneError.style.color = "red";

	        isValid = false;
	    } else {
	        phoneError.textContent = "";
	    }

	    return isValid;
	}
        function togglePassword() {
            const passwordField = document.getElementById('housekeeperPassword');
            if (passwordField.type === 'password') {
                passwordField.type = 'text';
            } else {
                passwordField.type = 'password';
            }
        }
    </script>
<script>
document.addEventListener('DOMContentLoaded', function () {
    var editHousekeeperModal = document.getElementById('editHousekeeperModal');
    editHousekeeperModal.addEventListener('show.bs.modal', function (event) {
        var button = event.relatedTarget;
        var id = button.getAttribute('data-id');
        var name = button.getAttribute('data-name');
        var email = button.getAttribute('data-email');
        var phone = button.getAttribute('data-phone');
        var status = button.getAttribute('data-status');

        var modal = editHousekeeperModal;
        modal.querySelector('#editHousekeeperId').value = id;
        modal.querySelector('#editHousekeeperName').value = name;
        modal.querySelector('#editHousekeeperEmail').value = email;
        modal.querySelector('#editHousekeeperPhone').value = phone;
        modal.querySelector('#editHousekeeperStatus').value = status;
    });

    var deleteHousekeeperModal = document.getElementById('deleteHousekeeperModal');
    deleteHousekeeperModal.addEventListener('show.bs.modal', function (event) {
        var button = event.relatedTarget;
        var email = button.getAttribute('data-email');

        var modal = deleteHousekeeperModal;
        modal.querySelector('#deleteHousekeeperEmail').value = email;
    });
});
</script>

<script>

    document.getElementById('showPasswordCheck').addEventListener('click', function() {
        var passwordField = document.getElementById('housekeeperPassword');
        if (this.checked) {
            passwordField.type = 'text';
        } else {
            passwordField.type = 'password';
        }
    });
});
</script>
<script>
        function togglePassword() {
            var passwordField = document.getElementById("housekeeperPassword");
            if (passwordField.type === "password") {
                passwordField.type = "text";
            } else {
                passwordField.type = "password";
            }
        }

        function validateForm() {
            var name = document.getElementById("housekeeperName").value.trim();
            var email = document.getElementById("housekeeperEmail").value.trim();
            var phone = document.getElementById("housekeeperPhone").value.trim();
            var password = document.getElementById("housekeeperPassword").value.trim();

            var nameError = document.getElementById("nameError");
            var emailError = document.getElementById("emailError");
            var phoneError = document.getElementById("phoneError");

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

            return isValid;
        }
    </script>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
