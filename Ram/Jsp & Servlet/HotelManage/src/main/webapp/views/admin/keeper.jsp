<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Housekeeper Staff Management</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin/adminKeeper.css">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark fixed-top bg-dark">
    <a class="navbar-brand" href="./main.html">
        <img src="./images/logo.jpg" alt="Logo"/>
    </a>
    <span class="navbar-text mx-auto">
        <span style="font-size: 30px; color:white">Rk Hotel Management</span>
    </span>
    <div class="dropdown profile">
        <img src="../../images/admin.jpg" alt="Profile Picture" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"/>
        <div class="dropdown-menu dropdown-menu-right">
            <a class="dropdown-item" href="${pageContext.request.contextPath}/ViewProfileServlet">View Profile</a>
            <a class="dropdown-item" href="${pageContext.request.contextPath}/views/admin/account.jsp">Account Settings</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="${pageContext.request.contextPath}/views/admin/index.jsp">Sign Out</a>
        </div>
    </div>
</nav>

<div class="sidebar">
    <div class="list-group">
        <a href="${pageContext.request.contextPath}/views/admin/dashboard.jsp" class="list-group-item ">DASHBOARD</a>
        <a href="${pageContext.request.contextPath}/ViewBooking" class="list-group-item ">Bookings</a>
        <a href="${pageContext.request.contextPath}/ListStaffServlet" class="list-group-item">Front Desk Staff</a>
        <a href="${pageContext.request.contextPath}/ListKeeperServlet" class="list-group-item active" >Housekeeper Staff</a>
        <a href="#roomsSubmenu" class="list-group-item dropdown-toggle" data-toggle="collapse">Rooms</a>
        <div class="collapse" id="roomsSubmenu">
            <a href="${pageContext.request.contextPath}/ListRoomsServlet" class="list-group-item pl-5" >All Rooms</a>
            <a href="${pageContext.request.contextPath}/ListRoomTypeServlet" class="list-group-item pl-5 ">Room Types</a>
        </div>
        <a href="${pageContext.request.contextPath}/views/admin/invoice.jsp" class="list-group-item">Invoice Details</a>
        <a href="${pageContext.request.contextPath}/ViewCustomer" class="list-group-item">Customers</a>
        <hr>
        <a href="${pageContext.request.contextPath}/settings.jsp" class="list-group-item">Settings</a>
    </div>
</div>

<div class="container content">
    <nav aria-label="breadcrumb" style="--bs-breadcrumb-divider: '>';">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="./main.html">Home</a></li>
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
    <c:forEach var="keeper" items="${keepers}" varStatus="loop">
        <tr>
            <td><c:out value="${loop.index + 1}"/></td>
            <td><c:out value="${keeper.keeperName}"/></td>
            <td><c:out value="${keeper.email}"/></td>
            <td><c:out value="${keeper.phoneNo}"/></td>	
            <td><c:out value="${keeper.status}"/></td> <!-- Display status here -->
            <td>
               <!-- Edit Button -->
                            <a href="#"  class="edit-btn" data-toggle="modal" data-target="#editHousekeeperModal"
                               data-id="${keeper.id}"
    data-name="${keeper.keeperName}"
    data-email="${keeper.email}"
    data-phone="${keeper.phoneNo}"
    data-status="${keeper.status}">
                                <i class="fas fa-pencil-alt"></i>
                            </a>
                            <!-- Delete Button -->
                            <a href="#" class="btn btn-danger" onclick="prepareDelete('${keeper.email}')">Delete</a>


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
                <input type="text" class="form-control" id="housekeeperName" name="keeperName">
                <small class="text-danger" id="nameError"></small>
            </div>
            <div class="form-group">
                <label for="housekeeperEmail">Email</label>
                <input type="email" class="form-control" id="housekeeperEmail" name="email">
                <small class="text-danger" id="emailError"></small>
            </div>
            <div class="form-group">
                <label for="housekeeperPhone">Phone-No</label>
                <input type="text" class="form-control" id="housekeeperPhone" name="phoneNo">
                <small class="text-danger" id="phoneError"></small>
            </div>
            <div class="form-group">
                <label for="housekeeperPassword">Password</label>
                <input type="password" class="form-control" id="housekeeperPassword" value="Welcome@123" name="password">
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
                  <form id="editHousekeeperForm" action="${pageContext.request.contextPath}/EditKeeperServlet" method="post">
                    <input type="hidden" id="editHousekeeperId" name="id"> <!-- Hidden field for ID -->
                    <div class="form-group">
                        <label for="editHousekeeperName">Name</label>
                        <input type="text" class="form-control" id="editHousekeeperName" name="keeperName" required>
                        <div class="invalid-feedback">Please enter a valid name (letters only).</div>
                    </div>
                    <div class="form-group">
                        <label for="editHousekeeperEmail">Email</label>
                        <input type="email" class="form-control" id="editHousekeeperEmail" name="email" readonly>
                        <div class="invalid-feedback">Please enter a valid email address.</div>
                    </div>
                    <div class="form-group">
                        <label for="editHousekeeperPhone">Phone-No</label>
                        <input type="text" class="form-control" id="editHousekeeperPhone" name="phoneNo" required>
                        <div class="invalid-feedback">Please enter a valid phone number (10 digits).</div>
                    </div>
                    <div class="form-group">
                        <label for="editHousekeeperStatus">Status</label>
                        <select class="form-control" id="editHousekeeperStatus" name="status" required>
                            <option value="Available">Available</option>
                            <option value="Not Available">Not Available</option>
                        </select>
                        <div class="invalid-feedback">Please select a status.</div>
                    </div>
                    <button type="submit" class="btn btn-primary" onclick="validateEditForm()">Save Changes</button>
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
                    <button type="submit" class="btn btn-danger">Delete</button>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
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
        function validateForm() {
            let isValid = true;

            // Name validation
            const name = document.getElementById('housekeeperName').value;
            const nameError = document.getElementById('nameError');
            const namePattern = /^[a-zA-Z\s]{3,}$/;

            if (!namePattern.test(name)) {
                nameError.textContent = 'Invalid name. Only letters and spaces are allowed and must be at least 3 characters long.';
                isValid = false;
            } else {
                nameError.textContent = '';
            }

            // Email validation
            const email = document.getElementById('housekeeperEmail').value;
            const emailError = document.getElementById('emailError');
            const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

            if (!emailPattern.test(email)) {
                emailError.textContent = 'Invalid email address.';
                isValid = false;
            } else {
                emailError.textContent = '';
            }

            // Phone number validation
            const phone = document.getElementById('housekeeperPhone').value;
            const phoneError = document.getElementById('phoneError');
            const phonePattern = /^\d{10}$/;

            if (!phonePattern.test(phone)) {
                phoneError.textContent = 'Invalid phone number. It should be 10 digits.';
                isValid = false;
            } else {
                phoneError.textContent = '';
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

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
