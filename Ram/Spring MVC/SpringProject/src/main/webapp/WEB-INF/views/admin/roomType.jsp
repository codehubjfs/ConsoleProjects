<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hotel Management System - Admin</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asserts/css/admin/roomType.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    
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
          <a href="ShowRoom" class="list-group-item pl-5" >All Rooms</a>
          <a href="RoomType" class="list-group-item pl-5  active">Room Types</a>
        </div>
        <a href="payments" class="list-group-item">Invoice Details</a>
        <a href="Customers" class="list-group-item">Customers</a>
        <hr>
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
                       <form id="roomTypeForm" action="${pageContext.request.contextPath}/addRoomType" method="post" onsubmit="return validateForm()">
    <div class="form-group">
        <label for="type_id">Type ID</label>
        <input type="text" class="form-control" id="type_id" name="type_id" oninput="validateTypeId()" >
        <div class="invalid-feedback" id="typeIdError" style="display:none; color: red;"></div>
    </div>
    <div class="form-group">
        <label for="room_name">Room Name</label>
        <input type="text" class="form-control" id="room_name" name="room_name" oninput="validateRoomName()" >
        <div class="invalid-feedback" id="roomNameError" style="display:none; color: red;"></div>
    </div>
    <div class="form-group">
        <label for="bed_capacity">Bed Capacity</label>
        <input type="number" class="form-control" id="bed_capacity" name="bed_capacity" oninput="validateBedCapacity()" >
        <div class="invalid-feedback" id="bedCapacityError" style="display:none; color: red;"></div>
    </div>
    <div class="form-group">
        <label for="amenity">Amenity</label>
        <textarea class="form-control" id="amenity" name="amenity" oninput="validateAmenity()" ></textarea>
        <div class="invalid-feedback" id="amenityError" style="display:none; color: red;"></div>
    </div>
    <div class="form-group">
        <label for="no_of_room">Number of Rooms</label>
        <input type="number" class="form-control" id="no_of_room" name="no_of_room" oninput="validateNoOfRoom()" >
        <div class="invalid-feedback" id="noOfRoomError" style="display:none; color: red;"></div>
    </div>
    <div class="form-group">
        <label for="rent">Rent</label>
        <input type="number" class="form-control" id="rent" name="rent" oninput="validateRent()" >
        <div class="invalid-feedback" id="rentError" style="display:none; color: red;"></div>
    </div>
    <button type="submit" class="btn btn-dark">Add Room Type</button>
</form>

        <c:if test="${not empty successMessage}">
            <div class="alert alert-success mt-3">${successMessage}</div>
        </c:if>
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
                            <td>${roomType.type_id}</td>
                            <td>${roomType.room_name}</td>
                            <td>${roomType.bed_capacity}</td>
                            <td>${roomType.amenity}</td>
                            <td>${roomType.no_of_room}</td>
                            <td>${roomType.rent}</td>
                            <td>
                                <!-- Edit Button -->

    <button type="button" class="btn btn-primary btn-sm edit-btn" data-toggle="modal" data-target="#editRoomModal"
        data-id="${roomType.type_id}" data-name="${roomType.room_name}"
        data-capacity="${roomType.bed_capacity}" data-amenities="${roomType.amenity}"
        data-rooms="${roomType.no_of_room}" data-rent="${roomType.rent}">
        Edit
    </button>
                               
                                <a href="#" class="delete-btn" data-toggle="modal" data-target="#deleteRoomModal" data-id="${roomType.type_id}" onclick="openDeleteModal('${roomType.type_id}')">
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
                <form id="roomTypeForm" action="editRoomType" method="post" onsubmit="return validateForm()">
                    <div class="form-group">
                        <label for="type_id">Type ID</label>
                        <input type="text" class="form-control" id="type_id" name="type_id" readonly>
                        <div class="invalid-feedback" id="typeIdError"></div>
                    </div>
                    <div class="form-group">
                        <label for="room_name">Room Name</label>
                        <input type="text" class="form-control" id="room_name" name="room_name" oninput="validateRoomName()">
                        <div class="invalid-feedback" id="roomNameError"></div>
                    </div>
                    <div class="form-group">
                        <label for="bed_capacity">Bed Capacity</label>
                        <input type="number" class="form-control" id="bed_capacity" name="bed_capacity" oninput="validateBedCapacity()">
                        <div class="invalid-feedback" id="bedCapacityError"></div>
                    </div>
                    <div class="form-group">
                        <label for="amenity">Amenity</label>
                        <textarea class="form-control" id="amenity" name="amenity" oninput="validateAmenity()"></textarea>
                        <div class="invalid-feedback" id="amenityError"></div>
                    </div>
                    <div class="form-group">
                        <label for="no_of_room">Number of Rooms</label>
                        <input type="number" class="form-control" id="no_of_room" name="no_of_room" oninput="validateNoOfRoom()">
                        <div class="invalid-feedback" id="noOfRoomError"></div>
                    </div>
                    <div class="form-group">
                        <label for="rent">Rent</label>
                        <input type="number" class="form-control" id="rent" name="rent" oninput="validateRent()">
                        <div class="invalid-feedback" id="rentError"></div>
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
                <form id="deleteRoomForm" action="${pageContext.request.contextPath}/deleteRoomType" method="post">
                    <input type="hidden" id="delete-type-id" name="type_id" />
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
function openDeleteModal(aid) {
	 document.getElementById('delete-type-id').value =aid;
    $('#deleteRoomModal').modal('show');
    }
</script>

<script>
function populateDeleteRoomModal(type_id) {
    document.getElementById('delete-type-id').value = type_id;
}

</script>
<script>
function validateTypeId() {
    const typeId = document.getElementById('type_id');
    const errorMessage = document.getElementById('typeIdError');
    if (typeId.value.trim() === '') {
        errorMessage.textContent = 'Type ID is required.';
        errorMessage.style.display = 'block';
        typeId.classList.add('is-invalid');
        return false;
    } else if (isNaN(typeId.value) || typeId.value <= 0) {
        errorMessage.textContent = 'Invalid Type ID. Only positive numbers are allowed.';
        errorMessage.style.display = 'block';
        typeId.classList.add('is-invalid');
        return false;
    } else {
        typeId.classList.remove('is-invalid');
        errorMessage.style.display = 'none';
        return true;
    }
}

function validateRoomName() {
    const roomName = document.getElementById('room_name');
    const errorMessage = document.getElementById('roomNameError');
    const regex = /^[A-Za-z\s]+$/; // Allows only alphabets and spaces
    if (roomName.value.trim() === '') {
        errorMessage.textContent = 'Room Name is required.';
        errorMessage.style.display = 'block';
        roomName.classList.add('is-invalid');
        return false;
    } else if (!regex.test(roomName.value.trim())) {
        errorMessage.textContent = 'Room Name must contain only alphabets.';
        errorMessage.style.display = 'block';
        roomName.classList.add('is-invalid');
        return false;
    } else {
        roomName.classList.remove('is-invalid');
        errorMessage.style.display = 'none';
        return true;
    }
}

function validateBedCapacity() {
    const bedCapacity = document.getElementById('bed_capacity');
    const errorMessage = document.getElementById('bedCapacityError');
    if (bedCapacity.value.trim() === '') {
        errorMessage.textContent = 'Bed Capacity is required.';
        errorMessage.style.display = 'block';
        bedCapacity.classList.add('is-invalid');
        return false;
    } else if (isNaN(bedCapacity.value) || bedCapacity.value <= 0) {
        errorMessage.textContent = 'Invalid Bed Capacity. Only positive numbers are allowed.';
        errorMessage.style.display = 'block';
        bedCapacity.classList.add('is-invalid');
        return false;
    } else {
        bedCapacity.classList.remove('is-invalid');
        errorMessage.style.display = 'none';
        return true;
    }
}

function validateAmenity() {
    const amenity = document.getElementById('amenity');
    const errorMessage = document.getElementById('amenityError');
    if (amenity.value.trim() === '') {
        errorMessage.textContent = 'Amenity is required.';
        errorMessage.style.display = 'block';
        amenity.classList.add('is-invalid');
        return false;
    } else {
        amenity.classList.remove('is-invalid');
        errorMessage.style.display = 'none';
        return true;
    }
}

function validateNoOfRoom() {
    const noOfRoom = document.getElementById('no_of_room');
    const errorMessage = document.getElementById('noOfRoomError');
    if (noOfRoom.value.trim() === '') {
        errorMessage.textContent = 'Number of Rooms is required.';
        errorMessage.style.display = 'block';
        noOfRoom.classList.add('is-invalid');
        return false;
    } else if (isNaN(noOfRoom.value) || noOfRoom.value <= 0) {
        errorMessage.textContent = 'Invalid Number of Rooms. Only positive numbers are allowed.';
        errorMessage.style.display = 'block';
        noOfRoom.classList.add('is-invalid');
        return false;
    } else {
        noOfRoom.classList.remove('is-invalid');
        errorMessage.style.display = 'none';
        return true;
    }
}

function validateRent() {
    const rent = document.getElementById('rent');
    const errorMessage = document.getElementById('rentError');
    if (rent.value.trim() === '') {
        errorMessage.textContent = 'Rent is required.';
        errorMessage.style.display = 'block';
        rent.classList.add('is-invalid');
        return false;
    } else if (isNaN(rent.value) || rent.value < 0) {
        errorMessage.textContent = 'Invalid Rent. Rent must be a positive number.';
        errorMessage.style.display = 'block';
        rent.classList.add('is-invalid');
        return false;
    } else {
        rent.classList.remove('is-invalid');
        errorMessage.style.display = 'none';
        return true;
    }
}

function validateForm() {
    let isValid = true;

    // Validate all fields
    isValid = validateTypeId() && isValid;
    isValid = validateRoomName() && isValid;
    isValid = validateBedCapacity() && isValid;
    isValid = validateAmenity() && isValid;
    isValid = validateNoOfRoom() && isValid;
    isValid = validateRent() && isValid;

    // If any field is invalid, prevent form submission
    if (!isValid) {
        return false;
    }

    return true;
}
</script>
<script>
document.addEventListener('DOMContentLoaded', function () {
    $('#editRoomModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget);
        var typeId = button.data('id');
        var roomName = button.data('name');
        var bedCapacity = button.data('capacity');
        var amenities = button.data('amenities');
        var noOfRoom = button.data('rooms');
        var rent = button.data('rent');

        var modal = $(this);
        modal.find('#type_id').val(typeId);
        modal.find('#room_name').val(roomName);
        modal.find('#bed_capacity').val(bedCapacity);
        modal.find('#amenity').val(amenities);
        modal.find('#no_of_room').val(noOfRoom);
        modal.find('#rent').val(rent);
    });
});
</script>

	<script src="${pageContext.request.contextPath}/javascript/adminRoomType.js"></script>
   
  
      <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
      <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
      <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  </body>
  </html>
  
