<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hotel Management System - Admin</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin/adminRoomType.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark fixed-top bg-dark">
        <a class="navbar-brand" href="./main.html"><img src="./images/logo.jpg" alt="Logo" /></a>
        <span class="navbar-text mx-auto"><span style="font-size: 30px; color:white">Rk Hotel Management</span></span>
        <div class="dropdown profile">
            <img src="./images/admin.jpg" alt="Profile Picture" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" />
            <div class="dropdown-menu dropdown-menu-right">
                <a class="dropdown-item" href="${pageContext.request.contextPath}/ViewProfileServlet">View Profile</a>
                <a class="dropdown-item" href="${pageContext.request.contextPath}/views/admin/account.jsp">Account Settings</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="${pageContext.request.contextPath}/views/admin/index.jsp">Sign Out</a>
            </div>
        </div>
    </nav>

    <!-- Breadcrumbs -->
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="./main.jsp">Home</a></li>
            <li class="breadcrumb-item active" aria-current="page">View Rooms</li>
        </ol>
    </nav>

    <div class="sidebar">
      <div class="list-group">
        <a href="${pageContext.request.contextPath}/views/admin/dashboard.jsp" class="list-group-item ">DASHBOARD</a>
        <a href="${pageContext.request.contextPath}/ViewBooking" class="list-group-item ">Bookings</a>
        <a href="${pageContext.request.contextPath}/ListStaffServlet" class="list-group-item">Front Desk Staff</a>
        <a href="${pageContext.request.contextPath}/ListKeeperServlet" class="list-group-item">Housekeeper Staff</a>
        <a href="#roomsSubmenu" class="list-group-item dropdown-toggle" data-toggle="collapse">Rooms</a>
        <div class="collapse" id="roomsSubmenu">
          <a href="${pageContext.request.contextPath}/ListRoomsServlet" class="list-group-item pl-5" >All Rooms</a>
          <a href="${pageContext.request.contextPath}/ListRoomTypeServlet" class="list-group-item pl-5  active">Room Types</a>
        </div>
        <a href="${pageContext.request.contextPath}/views/admin/invoice.jsp" class="list-group-item">Invoice Details</a>
        <a href="${pageContext.request.contextPath}/ViewCustomer" class="list-group-item">Customers</a>
        <hr>
        <a href="${pageContext.request.contextPath}/views/admin/settings.jsp" class="list-group-item">Settings</a>
      </div>
    </div>

    <div class="container">
        <!-- Button to Open the Modal -->
        <div class="row">
            <div class="col-md-8 offset-md-2 text-right mt-3">
                <button type="button" class="btn btn-secondary" data-toggle="modal" data-target="#addRoomModal">
                    Add Room Type
                </button>
            </div>
        </div>
        
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

        <!-- The Modal -->
          <div class="modal fade" id="addRoomModal" tabindex="-1" role="dialog" aria-labelledby="addRoomTypeModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="addRoomTypeModalLabel">Add Room Type</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <!-- Card with Form -->
                <div class="card">
                    <div class="card-header">
                        <h2>Add Room Type</h2>
                    </div>
                    <div class="card-body">
                        <form id="roomTypeForm" action="${pageContext.request.contextPath}/AddRoomTypeServlet" method="post" onsubmit="return validateForm()">
    <div class="form-group">
        <label for="type_id">Type ID</label>
        <input type="text" class="form-control" id="type_id" name="type_id" required>
        <div class="invalid-feedback" id="typeIdError"></div>
    </div>
    <div class="form-group">
        <label for="room_name">Room Name</label>
        <input type="text" class="form-control" id="room_name" name="room_name" required>
        <div class="invalid-feedback" id="roomNameError"></div>
    </div>
    <div class="form-group">
        <label for="bed_capacity">Bed Capacity</label>
        <input type="number" class="form-control" id="bed_capacity" name="bed_capacity" required>
        <div class="invalid-feedback" id="bedCapacityError"></div>
    </div>
    <div class="form-group">
        <label for="amenity">Amenity</label>
        <textarea class="form-control" id="amenity" name="amenity" required></textarea>
        <div class="invalid-feedback" id="amenityError"></div>
    </div>
    <div class="form-group">
        <label for="no_of_room">Number of Rooms</label>
        <input type="number" class="form-control" id="no_of_room" name="no_of_room" required>
        <div class="invalid-feedback" id="noOfRoomError"></div>
    </div>
    <div class="form-group">
        <label for="rent">Rent</label>
        <input type="number" class="form-control" id="rent" name="rent" required>
        <div class="invalid-feedback" id="rentError"></div>
    </div>
    <button type="submit" class="btn btn-dark">Add Room Type</button>
</form>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

        <!-- Room Types Table -->
        <div class="row">
    <div class="col-md-10 offset-md-1">
        <div class="table-container">
            <table class="table table-bordered mt-5">
                <thead>
                    <tr>
                        <th>Serial No</th>
                        <th>Type Id</th>
                        <th>Room Name</th>
                        <th>Bed Capacity</th>
                        <th>Amenities</th>
                        <th>Number of Rooms</th>
                        <th>Rent</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- Iterate over roomTypes using JSTL -->
                   <c:forEach var="roomType" items="${roomTypes}" varStatus="status">
        <tr>
           					 <td>${status.index + 1}</td> <!-- Serial number -->
                            <td>${roomType.typeId}</td>
                            <td>${roomType.roomName}</td>
                            <td>${roomType.bedCapacity}</td>
                            <td>${roomType.amenity}</td>
                            <td>${roomType.noOfRooms}</td>
                            <td>${roomType.rent}</td>
                            <td>
                                <!-- Edit Button -->
                                <a href="#" class="edit-btn" data-toggle="modal" data-target="#editRoomModal"
                        data-id="${roomType.typeId}" data-name="${roomType.roomName}"
                        data-capacity="${roomType.bedCapacity}" data-amenities="${roomType.amenity}"
                        data-rooms="${roomType.noOfRooms}" data-rent="${roomType.rent}">
                        <i class="fas fa-edit"></i>
                    </a></i> 
                                </a>
                                <!-- Delete Button -->
                                 <!-- Delete Button (assuming similar structure) -->
                    <a href="#" class="delete-btn" data-toggle="modal" data-target="#deleteRoomTypeModal"
                        data-id="${roomType.typeId}">
                        <i class="fas fa-trash"></i> 
                    </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
         

	<!-- Edit Modal -->
<div class="modal fade" id="editRoomModal" tabindex="-1" role="dialog" aria-labelledby="editRoomModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="editRoomModalLabel">Edit Room Type</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id="editRoomForm" action="${pageContext.request.contextPath}/EditRoomTypesServlet" method="post">
                    <input type="hidden" id="edit-type-id" name="type-id" />
                    <div class="form-group">
                        <label for="edit-room-name">Room Name</label>
                        <input type="text" class="form-control" id="edit-room-name" name="room-name" required pattern="[a-zA-Z]">
                        <div class="invalid-feedback">Please enter a room name with at least 5 alphabetical characters.</div>
                    </div>
                    <div class="form-group">
                        <label for="edit-number-of-rooms">Number of Rooms</label>
                        <input type="number" class="form-control" id="edit-number-of-rooms" name="number-of-rooms" required>
                        <div class="invalid-feedback">Please enter the number of rooms.</div>
                    </div>
                    <div class="form-group">
                        <label for="edit-bed-capacity">Bed Capacity</label>
                        <input type="number" class="form-control" id="edit-bed-capacity" name="bed-capacity" required>
                        <div class="invalid-feedback">Please enter the bed capacity.</div>
                    </div>
                    <div class="form-group">
                        <label for="edit-amenities">Amenities</label>
                        <textarea class="form-control" id="edit-amenities" name="amenities" required></textarea>
                        <div class="invalid-feedback">Please enter the amenities.</div>
                    </div>
                    <div class="form-group">
                        <label for="edit-rent">Rent</label>
                        <input type="number" class="form-control" id="edit-rent" name="rent" required>
                        <div class="invalid-feedback">Please enter the rent amount.</div>
                    </div>
                    <button type="submit" class="btn btn-dark">Save Changes</button>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- Delete Modal -->
<div class="modal fade" id="deleteRoomModal" tabindex="-1" role="dialog" aria-labelledby="deleteRoomModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="deleteRoomModalLabel">Delete Room Type</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Are you sure you want to delete this room type?
                <form id="deleteRoomForm" action="${pageContext.request.contextPath}/DeleteRoomTypeServlet" method="post">
                    <input type="hidden" id="delete-type-id" name="type-id" />
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                <button type="submit" form="deleteRoomForm" class="btn btn-danger">Delete</button>
            </div>
        </div>
    </div>
</div>
<script>
    document.addEventListener('DOMContentLoaded', function () {
        var editButtons = document.querySelectorAll('.edit-btn');
        editButtons.forEach(function (button) {
            button.addEventListener('click', function (event) {
                event.preventDefault();

                var id = button.getAttribute('data-id');
                var name = button.getAttribute('data-name');
                var capacity = button.getAttribute('data-capacity');
                var amenities = button.getAttribute('data-amenities');
                var rooms = button.getAttribute('data-rooms');
                var rent = button.getAttribute('data-rent');

                document.getElementById('edit-type-id').value = id;
                document.getElementById('edit-room-name').value = name;
                document.getElementById('edit-bed-capacity').value = capacity;
                document.getElementById('edit-amenities').value = amenities;
                document.getElementById('edit-number-of-rooms').value = rooms;
                document.getElementById('edit-rent').value = rent;
            });
        });

        // JavaScript validation for room-name field
        var roomNameInput = document.getElementById('edit-room-name');
        roomNameInput.addEventListener('input', function () {
            if (!roomNameInput.checkValidity()) {
                roomNameInput.classList.add('is-invalid');
            } else {
                roomNameInput.classList.remove('is-invalid');
            }
        });

        // Other field validations similar to room-name
        // Implement validation for bed-capacity, amenities, number-of-rooms, rent here
        // Example:
        var bedCapacityInput = document.getElementById('edit-bed-capacity');
        bedCapacityInput.addEventListener('input', function () {
            if (!bedCapacityInput.checkValidity()) {
                bedCapacityInput.classList.add('is-invalid');
            } else {
                bedCapacityInput.classList.remove('is-invalid');
            }
        });
    });
</script>

<script>
	
	  document.addEventListener('DOMContentLoaded', function() {
	        // Get all the delete buttons
	        var deleteButtons = document.querySelectorAll('.delete-btn');

	        // Add click event listeners to the delete buttons
	        deleteButtons.forEach(function(button) {
	            button.addEventListener('click', function(event) {
	                // Prevent default link behavior
	                event.preventDefault();
	                
	                // Get data attributes from the button
	                var serialNumber = this.getAttribute('data-id');

	                // Set the value in the modal form field
	                document.getElementById('delete-serial-number').value = serialNumber;
	            });
	        });
	    });

</script>

 <script>
        // Function to validate Serial Number
        function validateSerialNumber() {
            var serialNumber = document.getElementById('serial-number').value.trim();
            var serialNumberError = document.getElementById('serial-number').nextElementSibling;

            if (!serialNumber) {
                serialNumberError.style.display = 'block';
            } else {
                serialNumberError.style.display = 'none';
            }
        }

        // Function to validate Room Name
        function validateRoomName() {
            var roomName = document.getElementById('room-name').value.trim();
            var roomNameError = document.getElementById('room-name').nextElementSibling;

            if (!roomName) {
                roomNameError.style.display = 'block';
            } else {
                roomNameError.style.display = 'none';
            }
        }

        // Function to validate Number of Rooms
        function validateNumberOfRooms() {
            var numberOfRooms = document.getElementById('number-of-rooms').value.trim();
            var numberOfRoomsError = document.getElementById('number-of-rooms').nextElementSibling;

            if (!numberOfRooms || numberOfRooms <= 0) {
                numberOfRoomsError.style.display = 'block';
            } else {
                numberOfRoomsError.style.display = 'none';
            }
        }

        // Function to validate Bed Capacity
        function validateBedCapacity() {
            var bedCapacity = document.getElementById('bed-capacity').value.trim();
            var bedCapacityError = document.getElementById('bed-capacity').nextElementSibling;

            if (!bedCapacity || bedCapacity <= 0) {
                bedCapacityError.style.display = 'block';
            } else {
                bedCapacityError.style.display = 'none';
            }
        }

        // Function to validate Amenities
        function validateAmenities() {
            var amenities = document.getElementById('amenities').value.trim();
            var amenitiesError = document.getElementById('amenities').nextElementSibling;

            if (!amenities) {
                amenitiesError.style.display = 'block';
            } else {
                amenitiesError.style.display = 'none';
            }
        }

        // Add event listeners to input fields
        document.getElementById('serial-number').addEventListener('input', validateSerialNumber);
        document.getElementById('room-name').addEventListener('input', validateRoomName);
        document.getElementById('number-of-rooms').addEventListener('input', validateNumberOfRooms);
        document.getElementById('bed-capacity').addEventListener('input', validateBedCapacity);
        document.getElementById('amenities').addEventListener('input', validateAmenities);

        // Function to validate form on submit
        function validateForm() {
            validateSerialNumber();
            validateRoomName();
            validateNumberOfRooms();
            validateBedCapacity();
            validateAmenities();

            // Check if there are any error messages displayed
            var serialNumberError = document.getElementById('serial-number').nextElementSibling.style.display !== 'none';
            var roomNameError = document.getElementById('room-name').nextElementSibling.style.display !== 'none';
            var numberOfRoomsError = document.getElementById('number-of-rooms').nextElementSibling.style.display !== 'none';
            var bedCapacityError = document.getElementById('bed-capacity').nextElementSibling.style.display !== 'none';
            var amenitiesError = document.getElementById('amenities').nextElementSibling.style.display !== 'none';

            // Prevent form submission if any error messages are displayed
            if (serialNumberError || roomNameError || numberOfRoomsError || bedCapacityError || amenitiesError) {
                return false;
            }
            return true;
        }
    </script>	
	<script src="${pageContext.request.contextPath}/javascript/adminRoomType.js"></script>
   <script>
    // Function to validate Type ID
    function validateTypeId() {
        var typeId = document.getElementById('type_id').value.trim();
        var typeIdError = document.getElementById('typeIdError');

        if (!typeId) {
            typeIdError.textContent = 'Please enter a Type ID.';
            typeIdError.style.display = 'block';
        } else {
            typeIdError.style.display = 'none';
        }
    }

    // Function to validate Room Name
    function validateRoomName() {
        var roomName = document.getElementById('room_name').value.trim();
        var roomNameError = document.getElementById('roomNameError');

        if (!roomName) {
            roomNameError.textContent = 'Please enter a Room Name.';
            roomNameError.style.display = 'block';
        } else {
            roomNameError.style.display = 'none';
        }
    }

    // Function to validate Bed Capacity
    function validateBedCapacity() {
        var bedCapacity = document.getElementById('bed_capacity').value.trim();
        var bedCapacityError = document.getElementById('bedCapacityError');

        if (!bedCapacity || bedCapacity <= 0) {
            bedCapacityError.textContent = 'Please enter a valid Bed Capacity.';
            bedCapacityError.style.display = 'block';
        } else {
            bedCapacityError.style.display = 'none';
        }
    }

    // Function to validate Amenities
    function validateAmenities() {
        var amenities = document.getElementById('amenity').value.trim();
        var amenitiesError = document.getElementById('amenityError');

        if (!amenities) {
            amenitiesError.textContent = 'Please enter Amenities.';
            amenitiesError.style.display = 'block';
        } else {
            amenitiesError.style.display = 'none';
        }
    }

    // Function to validate Number of Rooms
    function validateNumberOfRooms() {
        var numberOfRooms = document.getElementById('no_of_room').value.trim();
        var numberOfRoomsError = document.getElementById('noOfRoomError');

        if (!numberOfRooms || numberOfRooms <= 0) {
            numberOfRoomsError.textContent = 'Please enter a valid Number of Rooms.';
            numberOfRoomsError.style.display = 'block';
        } else {
            numberOfRoomsError.style.display = 'none';
        }
    }

    // Function to validate Rent
    function validateRent() {
        var rent = document.getElementById('rent').value.trim();
        var rentError = document.getElementById('rentError');

        if (!rent || rent <= 0) {
            rentError.textContent = 'Please enter a valid Rent amount.';
            rentError.style.display = 'block';
        } else {
            rentError.style.display = 'none';
        }
    }

    // Add event listeners to input fields
    document.getElementById('type_id').addEventListener('input', validateTypeId);
    document.getElementById('room_name').addEventListener('input', validateRoomName);
    document.getElementById('bed_capacity').addEventListener('input', validateBedCapacity);
    document.getElementById('amenity').addEventListener('input', validateAmenities);
    document.getElementById('no_of_room').addEventListener('input', validateNumberOfRooms);
    document.getElementById('rent').addEventListener('input', validateRent);

    // Function to validate form on submit
    function validateForm() {
        // Validate each field
        validateTypeId();
        validateRoomName();
        validateBedCapacity();
        validateAmenities();
        validateNumberOfRooms();
        validateRent();

        // Check if there are any error messages displayed
        var typeIdError = document.getElementById('typeIdError').style.display !== 'none';
        var roomNameError = document.getElementById('roomNameError').style.display !== 'none';
        var bedCapacityError = document.getElementById('bedCapacityError').style.display !== 'none';
        var amenitiesError = document.getElementById('amenityError').style.display !== 'none';
        var numberOfRoomsError = document.getElementById('noOfRoomError').style.display !== 'none';
        var rentError = document.getElementById('rentError').style.display !== 'none';

        // Prevent form submission if any error messages are displayed
        return !typeIdError && !roomNameError && !bedCapacityError && !amenitiesError && !numberOfRoomsError && !rentError;
    }
</script>


<script>
// Function to validate the form on submit
function validateForm() {
    let isValid = true;

    // Validate Type ID
    let typeId = document.getElementById("type_id").value.trim();
    if (typeId === "") {
        document.getElementById("typeIdError").textContent = "Type ID is required";
        isValid = false;
    } else {
        document.getElementById("typeIdError").textContent = "";
    }

    // Validate Room Name
    let roomName = document.getElementById("room_name").value.trim();
    if (roomName === "") {
        document.getElementById("roomNameError").textContent = "Room Name is required";
        isValid = false;
    } else {
        document.getElementById("roomNameError").textContent = "";
    }

    // Validate Bed Capacity
    let bedCapacity = document.getElementById("bed_capacity").value.trim();
    if (bedCapacity === "" || isNaN(bedCapacity) || bedCapacity <= 0) {
        document.getElementById("bedCapacityError").textContent = "Valid Bed Capacity is required";
        isValid = false;
    } else {
        document.getElementById("bedCapacityError").textContent = "";
    }

    // Validate Amenity
    let amenity = document.getElementById("amenity").value.trim();
    if (amenity === "") {
        document.getElementById("amenityError").textContent = "Amenity is required";
        isValid = false;
    } else {
        document.getElementById("amenityError").textContent = "";
    }

    // Validate Number of Rooms
    let noOfRooms = document.getElementById("no_of_room").value.trim();
    if (noOfRooms === "" || isNaN(noOfRooms) || noOfRooms <= 0) {
        document.getElementById("noOfRoomError").textContent = "Valid Number of Rooms is required";
        isValid = false;
    } else {
        document.getElementById("noOfRoomError").textContent = "";
    }

    // Validate Rent
    let rent = document.getElementById("rent").value.trim();
    if (rent === "" || isNaN(rent) || rent <= 0) {
        document.getElementById("rentError").textContent = "Valid Rent is required";
        isValid = false;
    } else {
        document.getElementById("rentError").textContent = "";
    }

    return isValid;
}

// Event listeners for real-time validation on input change
document.getElementById("type_id").addEventListener("input", function () {
    validateForm();
});
document.getElementById("room_name").addEventListener("input", function () {
    validateForm();
});
document.getElementById("bed_capacity").addEventListener("input", function () {
    validateForm();
});
document.getElementById("amenity").addEventListener("input", function () {
    validateForm();
});
document.getElementById("no_of_room").addEventListener("input", function () {
    validateForm();
});
document.getElementById("rent").addEventListener("input", function () {
    validateForm();
});

</script>
  
      <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
      <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
      <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  </body>
  </html>
  
