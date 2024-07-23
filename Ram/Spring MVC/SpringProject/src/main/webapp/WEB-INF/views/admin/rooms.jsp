<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored= "false" %>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hotel Management System - Admin</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asserts/css/admin/room.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <style>
.error-message {
    color: red;
    display: none; /* Hide by default */
}

.is-invalid {
    border-color: red; /* Highlight invalid inputs */
}

            
        }
.table th, .table td {
    padding: 10px;
    text-align: left;
    vertical-align: middle;
}

.col-serial {
    width: 5%;  /* Adjust percentage as needed */
}

.col-room-id {
    width: 10%;  /* Adjust percentage as needed */
}

.col-type-id {
    width: 10%;  /* Adjust percentage as needed */
}

.col-room-name {
    width: 20%;  /* Adjust percentage as needed */
}

.col-room-status {
    width: 15%;  /* Adjust percentage as needed */
}

.col-room-condition {
    width: 15%;  /* Adjust percentage as needed */
}

.col-actions {
    width: 25%;  /* Adjust percentage as needed */
}

    </style>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark fixed-top bg-dark">
        <a class="navbar-brand" href="Dashboard"><img src="${pageContext.request.contextPath}/asserts/images/logo.jpg" alt="Logo" /></a>
        <span class="navbar-text mx-auto"><span style="font-size: 30px; color:white">Rk Hotel Management</span></span>
        <div class="dropdown profile">
            <img src="${pageContext.request.contextPath}/asserts/images/admin.jpg" alt="Profile Picture" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" />
            <div class="dropdown-menu dropdown-menu-right">
                <a class="dropdown-item" href="admin">View Profile</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="logout">Sign Out</a>
            </div>
        </div>
    </nav>

    <!-- Breadcrumbs -->
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="dashboard">Home</a></li>
            <li class="breadcrumb-item active" aria-current="page">View Rooms</li>
        </ol>
    </nav>

    <div class="sidebar">
      <div class="list-group">
        <a href="dashboard" class="list-group-item ">DASHBOARD</a>
        <a href="viewBookings" class="list-group-item ">Bookings</a>
        <a href="ListStaffServlet" class="list-group-item">Front Desk Staff</a>
        <a href="ListKeeperServlet" class="list-group-item">Housekeeper Staff</a>
        <a href="#roomsSubmenu" class="list-group-item dropdown-toggle" data-toggle="collapse">Rooms</a>
        <div class="collapse" id="roomsSubmenu">
          <a href="ShowRoom" class="list-group-item pl-5 active" >All Rooms</a>
          <a href="RoomType" class="list-group-item pl-5 ">Room Types</a>
        </div>
        <a href="payments" class="list-group-item ">Invoice Details</a>
        <a href="Customers" class="list-group-item">Customers</a>
        <hr>
      </div>
    </div>

    <div class="container">
        <!-- Button to Open the Modal -->
        <div class="row">
            <div class="col-md-8 offset-md-2 text-right mt-3">
                <button type="button" class="btn btn-secondary" data-toggle="modal" data-target="#addRoomModal">
                    Add Rooms 
                </button>
            </div>
        </div>

        <!-- The Modal -->

      <!-- Add Room Modal -->
<div class="modal fade" id="addRoomModal" tabindex="-1" role="dialog" aria-labelledby="addRoomModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="addRoomModalLabel">Add Room</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
               <form action="add" method="post" id="roomForm" onsubmit="return validateRoomForm()">
    <div class="form-group">
        <label for="roomId">Room No</label>
        <input type="number" class="form-control" id="roomId" name="room_Id" >
        <small class="error-message" id="roomIdError">Invalid Room ID. Only positive numbers are allowed.</small>
    </div>
    <div class="form-group">
        <label for="typeId">Type ID</label>
        <input type="number" class="form-control" id="typeId" name="type_Id" >
        <small class="error-message" id="typeIdError">Invalid Type ID. Only positive numbers are allowed.</small>
    </div>
    <div class="form-group">
        <label for="roomStatus">Room Status</label>
        <select class="form-control" id="roomStatus" name="room_status">
            <option value="">Select Status</option>
            <option value="Available">Available</option>
            <option value="Under-maintenance">Under-maintenance</option>
            <option value="Occupied">Occupied</option>
            <option value="Booked">Booked</option>
        </select>
        <small class="error-message" id="roomStatusError">Invalid Room Status.</small>
    </div>
    <div class="form-group">
        <label for="roomCondition">Room Condition</label>
        <select class="form-control" id="roomCondition" name="room_condition">
            <option value="">Select Condition</option>
            <option value="Clean">Clean</option>
            <option value="Dirty">Dirty</option>
        </select>
        <small class="error-message" id="roomConditionError">Invalid Room Condition.</small>
    </div>
    <button type="submit" class="btn btn-primary">Add Room</button>
</form>

            </div>
        </div>
    </div>
</div>


      <!-- Room Types Table -->
<div class="row">
    <div class="col-md-8 offset-md-2">
        <div class="table-container">
            <table class="table mt-5">
               <thead>
                      <tr>
                        <th>Serial No</th>
                        <th>Room No</th>
                        <th>Type Id</th>
                        <th>Room Status</th>
                        <th>Room Condition</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="rooms" items="${room}" varStatus="status">
                        <tr>
                            <td>${status.index + 1}</td> <!-- Serial number -->
                            <td>${rooms.room_Id}</td>
                            <td>${rooms.type_Id}</td>
                            <td>${rooms.room_status}</td>
                            <td>${rooms.room_condition}</td>
                            <td>
                                <!-- Edit Button -->
                                <a href="#" class="edit-btn" data-toggle="modal" data-target="#editRoomModal"
                                    data-id="${rooms.room_Id}" data-type="${rooms.type_Id}"
                                    data-status="${rooms.room_status}" data-condition="${rooms.room_condition}">
                                    <i class="fas fa-edit"></i>
                                </a>
                               

                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
      
<!-- The Edit Modal -->
<!-- Edit Room Modal -->
<div class="modal fade" id="editRoomModal" tabindex="-1" role="dialog" aria-labelledby="editRoomModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="editRoomModalLabel">Edit Room</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="container mt-5">
                    <form action="editRoom" method="post" id="editRoomForm" onsubmit="return validateEditForm()">
                        <input type="hidden" name="action" value="edit">
                        <input type="hidden" id="edit-roomId" name="room_Id">
                        <div class="form-group">
                            <label for="edit-typeId">Type ID</label>
                            <input type="number" class="form-control" id="edit-typeId" name="type_Id" required>
                            <small class="error-message" id="edit-typeIdError">Invalid Type ID. Only positive numbers are allowed.</small>
                        </div>
                        <div class="form-group">
                            <label for="edit-roomStatus">Room Status</label>
                            <select class="form-control" id="edit-roomStatus" name="room_status" required>
                                <option value="">Select Status</option>
                                <option value="Available">Available</option>
                                <option value="Under-maintenance">Under-maintenance</option>
                                <option value="Occupied">Occupied</option>
                                <option value="Booked">Booked</option>
                            </select>
                            <small class="error-message" id="edit-roomStatusError">Invalid Room Status.</small>
                        </div>
                        <div class="form-group">
                            <label for="edit-roomCondition">Room Condition</label>
                            <select class="form-control" id="edit-roomCondition" name="room_condition" required>
                                <option value="">Select Condition</option>
                                <option value="Clean">Clean</option>
                                <option value="Dirty">Dirty</option>
                            </select>
                            <small class="error-message" id="edit-roomConditionError">Invalid Room Condition.</small>
                        </div>
                        <button type="submit" class="btn btn-primary">Save Changes</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>



<!-- Delete Modal -->
<div class="modal fade" id="deleteRoomModal" tabindex="-1" role="dialog" aria-labelledby="deleteRoomModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="deleteRoomModalLabel">Delete Room</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Are you sure you want to delete this room?
                <form id="deleteRoomForm" action="deleteRoom" method="post">
                    <input type="hidden" id="delete-roomId" name="type_Id" value="${rooms.type_Id}"  />
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
$(document).on("click", ".edit-btn", function() {
    var roomId = $(this).data("id");
    var typeId = $(this).data("type");
    var roomName = $(this).data("name");
    var roomStatus = $(this).data("status");
    var roomCondition = $(this).data("condition");

    $("#edit-room-id").val(roomId);
    $("#edit-room-type").val(typeId);
    $("#edit-room-name").val(roomName);
    $("#edit-room-status").val(roomStatus);
    $("#edit-room-condition").val(roomCondition);
});

// JavaScript to populate modal fields for deleting
$(document).on("click", ".delete-btn", function() {
    var roomId = $(this).data("id");
    $("#delete-room-id").val(roomId);
});
</script>
<script>
$(document).ready(function() {
    $('#deleteRoomModal').on('show.bs.modal', function(event) {
        var button = $(event.relatedTarget); // Button that triggered the modal
        var roomId = button.data('id'); // Extract info from data-* attributes

        // If necessary, you could initiate an AJAX request here
        // and then do the updating in a callback.
        // Update the modal's content.
        var modal = $(this);
        modal.find('#delete-roomId').val(roomId);
    });
});
</script>

<script>
//JavaScript for form validation
function validateRoomForm() {
    var roomId = document.getElementById("roomId").value.trim();
    var typeId = document.getElementById("typeId").value.trim();
    var roomStatus = document.getElementById("roomStatus").value.trim();
    var roomCondition = document.getElementById("roomCondition").value.trim();

    var roomIdError = document.getElementById("roomIdError");
    var typeIdError = document.getElementById("typeIdError");
    var roomStatusError = document.getElementById("roomStatusError");
    var roomConditionError = document.getElementById("roomConditionError");

    // Clear previous errors
    roomIdError.innerHTML = "";
    typeIdError.innerHTML = "";
    roomStatusError.innerHTML = "";
    roomConditionError.innerHTML = "";

    var isValid = true;

    // Validate Room ID
    if (roomId === "") {
        roomIdError.innerHTML = "Room ID is required";
        roomIdError.style.color = "red";
        isValid = false;
    } else if (isNaN(roomId) || parseInt(roomId) <= 0) {
        roomIdError.innerHTML = "Invalid Room ID. Only positive numbers are allowed.";
        roomIdError.style.color = "red";
        isValid = false;
    }

    // Validate Type ID
    if (typeId === "") {
        typeIdError.innerHTML = "Type ID is required";
        typeIdError.style.color = "red";
        isValid = false;
    } else if (isNaN(typeId) || parseInt(typeId) <= 0) {
        typeIdError.innerHTML = "Invalid Type ID. Only positive numbers are allowed.";
        typeIdError.style.color = "red";
        isValid = false;
    }

    // Validate Room Status
    if (roomStatus === "") {
        roomStatusError.innerHTML = "Room status is required";
        roomStatusError.style.color = "red";
        isValid = false;
    }

    // Validate Room Condition
    if (roomCondition === "") {
        roomConditionError.innerHTML = "Room condition is required";
        roomConditionError.style.color = "red";
        isValid = false;
    }

    return isValid;
}


</script>
	<script>

      function validateForm() {
          var isValid = true;
          var roomTypePattern = /^[a-zA-Z\s]+$/;
          var numberPattern = /^[0-9]+$/;

          // Validate Room Type
          var roomType = document.getElementById('roomType').value;
          if (!roomTypePattern.test(roomType)) {
              document.getElementById('roomTypeError').style.display = 'block';
              isValid = false;
          } else {
              document.getElementById('roomTypeError').style.display = 'none';
          }

          // Validate Bed Capacity
          var bedCapacity = document.getElementById('bedCapacity').value;
          if (!numberPattern.test(bedCapacity) || bedCapacity <= 0) {
              document.getElementById('bedCapacityError').style.display = 'block';
              isValid = false;
          } else {
              document.getElementById('bedCapacityError').style.display = 'none';
          }

          // Validate Rent
          var rent = document.getElementById('rent').value;
          if (!numberPattern.test(rent) || rent <= 0) {
              document.getElementById('rentError').style.display = 'block';
              isValid = false;
          } else {
              document.getElementById('rentError').style.display = 'none';
          }

          return isValid;
      }

      function validateEditForm() {
          var isValid = true;
          var roomTypePattern = /^[a-zA-Z\s]+$/;
          var numberPattern = /^[0-9]+$/;

          // Validate Room Type
          var roomType = document.getElementById('editRoomType').value;
          if (!roomTypePattern.test(roomType)) {
              document.getElementById('editRoomTypeError').style.display = 'block';
              isValid = false;
          } else {
              document.getElementById('editRoomTypeError').style.display = 'none';
          }

          // Validate Bed Capacity
          var bedCapacity = document.getElementById('editBedCapacity').value;
          if (!numberPattern.test(bedCapacity) || bedCapacity <= 0) {
              document.getElementById('editBedCapacityError').style.display = 'block';
              isValid = false;
          } else {
              document.getElementById('editBedCapacityError').style.display = 'none';
          }

          // Validate Rent
          var rent = document.getElementById('editRent').value;
          if (!numberPattern.test(rent) || rent <= 0) {
              document.getElementById('editRentError').style.display = 'block';
              isValid = false;
          } else {
              document.getElementById('editRentError').style.display = 'none';
          }

          return isValid;
      }
	</script>
	<script>
	document.querySelectorAll('.edit-btn').forEach(button => {
	    button.addEventListener('click', () => {
	        const roomId = button.getAttribute('data-id');
	        const typeId = button.getAttribute('data-type');
	        const roomName = button.getAttribute('data-name');
	        const roomStatus = button.getAttribute('data-status');
	        const roomCondition = button.getAttribute('data-condition');

	        document.getElementById('edit-roomId').value = roomId;
	        document.getElementById('edit-typeId').value = typeId;
	        document.getElementById('edit-roomName').value = roomName;
	        document.getElementById('edit-roomStatus').value = roomStatus;
	        document.getElementById('edit-roomCondition').value = roomCondition;
	    });
	});
	</script>
	
	<script>
	function validateRoomId() {
	    const roomId = document.getElementById('roomId');
	    const errorMessage = document.getElementById('roomIdError');
	    if (roomId.value.trim() === '' || isNaN(roomId.value) || roomId.value <= 0) {
	        errorMessage.style.display = 'block';
	        roomId.classList.add('is-invalid');
	    } else {
	        errorMessage.style.display = 'none';
	        roomId.classList.remove('is-invalid');
	    }
	}

	function validateTypeId() {
	    const typeId = document.getElementById('typeId');
	    const errorMessage = document.getElementById('typeIdError');
	    if (typeId.value.trim() === '' || isNaN(typeId.value) || typeId.value <= 0) {
	        errorMessage.style.display = 'block';
	        typeId.classList.add('is-invalid');
	    } else {
	        errorMessage.style.display = 'none';
	        typeId.classList.remove('is-invalid');
	    }
	}

	function validateRoomStatus() {
	    const roomStatus = document.getElementById('roomStatus');
	    const errorMessage = document.getElementById('roomStatusError');
	    if (roomStatus.value.trim() === '') {
	        errorMessage.style.display = 'block';
	        roomStatus.classList.add('is-invalid');
	    } else {
	        errorMessage.style.display = 'none';
	        roomStatus.classList.remove('is-invalid');
	    }
	}

	function validateRoomCondition() {
	    const roomCondition = document.getElementById('roomCondition');
	    const errorMessage = document.getElementById('roomConditionError');
	    if (roomCondition.value.trim() === '') {
	        errorMessage.style.display = 'block';
	        roomCondition.classList.add('is-invalid');
	    } else {
	        errorMessage.style.display = 'none';
	        roomCondition.classList.remove('is-invalid');
	    }
	}

	function validateRoomForm() {
	    validateRoomId();
	    validateTypeId();
	    validateRoomStatus();
	    validateRoomCondition();
	    
	    // Return false if any field is invalid
	    return !document.querySelector('.is-invalid');
	}

	// Attach oninput validation
	document.getElementById('roomId').oninput = validateRoomId;
	document.getElementById('typeId').oninput = validateTypeId;
	document.getElementById('roomStatus').onchange = validateRoomStatus; // onchange for select
	document.getElementById('roomCondition').onchange = validateRoomCondition; // onchange for select
	</script>
</script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>