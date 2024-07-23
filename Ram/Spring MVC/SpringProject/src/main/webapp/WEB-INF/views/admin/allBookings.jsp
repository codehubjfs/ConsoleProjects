<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hotel Management System - Admin</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
     <!-- Font Awesome Icons (optional for icons) -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
     <!-- Include jsPDF Library -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/2.4.0/jspdf.umd.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/1.4.1/html2canvas.min.js"></script>
   	<link rel="stylesheet" href="${pageContext.request.contextPath}/asserts/css/admin/booking.css">
   	<script src='https://code.jquery.com/jquery-3.7.0.js'></script>
	<!-- Data Table JS -->
	<script src='https://cdn.datatables.net/1.13.5/js/jquery.dataTables.min.js'></script>
	<script src='https://cdn.datatables.net/responsive/2.1.0/js/dataTables.responsive.min.js'></script>
	<script src='https://cdn.datatables.net/1.13.5/js/dataTables.bootstrap5.min.js'></script>
   	
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark fixed-top bg-dark">
        <a class="navbar-brand" href="Dashboard"
          ><img src="${pageContext.request.contextPath}/asserts/images/logo.jpg" alt="Logo"
        /></a>
        <span class="navbar-text mx-auto"
          ><span style="font-size: 30px; color:white">Rk Hotel Management</span></span
        >
        <!-- <form class="form-inline ml-auto mr-2">
          <input
            class="form-control mr-sm-2"
            type="search"
            placeholder="Search"
            aria-label="Search"
          />
          <button class="btn btn-outline-light" type="submit">Search</button>
        </form> -->
        <div class="dropdown profile">
          <img
            src="${pageContext.request.contextPath}/asserts/images/admin.jpg"
            alt="Profile Picture"
            class="dropdown-toggle"
            data-toggle="dropdown"
            aria-haspopup="true"
            aria-expanded="false"
          />
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
        <a href="viewBookings" class="list-group-item active">Bookings</a>
        <a href="ListStaffServlet" class="list-group-item">Front Desk Staff</a>
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
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="dashboard">Home</a></li>
                <li class="breadcrumb-item active" aria-current="page">Bookings</li>
            </ol>
        </nav>

        <!-- Add Booking Button
        
<div class="container mt-5 ">
    <div class="card">
      <div class="card-header">
        <h2>Add Booking <img src="./images/admin.jpg" width="50" height="50" alt="Admin" style="border-radius: 50%;"></h2>
        <button type="button" class="btn btn-secondary" data-toggle="modal" data-target="#addBookingModal">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus-circle-dotted" viewBox="0 0 16 16">
                <path d="M8 0q-.264 0-.523.017l.064.998a7 7 0 0 1 .918 0l.064-.998A8 8 0 0 0 8 0M6.44.152q-.52.104-1.012.27l.321.948q.43-.147.884-.237L6.44.153zm4.132.271a8 8 0 0 0-1.011-.27l-.194.98q.453.09.884.237zm1.873.925a8 8 0 0 0-.906-.524l-.443.896q.413.205.793.459zM4.46.824q-.471.233-.905.524l.556.83a7 7 0 0 1 .793-.458zM2.725 1.985q-.394.346-.74.74l.752.66q.303-.345.648-.648zm11.29.74a8 8 0 0 0-.74-.74l-.66.752q.346.303.648.648zm1.161 1.735a8 8 0 0 0-.524-.905l-.83.556q.254.38.458.793l.896-.443zM1.348 3.555q-.292.433-.524.906l.896.443q.205-.413.459-.793zM.423 5.428a8 8 0 0 0-.27 1.011l.98.194q.09-.453.237-.884zM15.848 6.44a8 8 0 0 0-.27-1.012l-.948.321q.147.43.237.884zM.017 7.477a8 8 0 0 0 0 1.046l.998-.064a7 7 0 0 1 0-.918zM16 8a8 8 0 0 0-.017-.523l-.998.064a7 7 0 0 1 0 .918l.998.064A8 8 0 0 0 16 8M.152 9.56q.104.52.27 1.012l.948-.321a7 7 0 0 1-.237-.884l-.98.194zm15.425 1.012q.168-.493.27-1.011l-.98-.194q-.09.453-.237.884zM.824 11.54a8 8 0 0 0 .524.905l.83-.556a7 7 0 0 1-.458-.793zm13.828.905q.292-.434.524-.906l-.896-.443q-.205.413-.459.793zm-12.667.83q.346.394.74.74l.66-.752a7 7 0 0 1-.648-.648zm11.29.74q.394-.346.74-.74l-.752-.66q-.302.346-.648.648zm-1.735 1.161q.471-.233.905-.524l-.556-.83a7 7 0 0 1-.793.458zm-7.985-.524q.434.292.906.524l.443-.896a7 7 0 0 1-.793-.459zm1.873.925q.493.168 1.011.27l.194-.98a7 7 0 0 1-.884-.237zm4.132.271a8 8 0 0 0 1.012-.27l-.321-.948a7 7 0 0 1-.884.237l.194.98zm-2.083.135a8 8 0 0 0 1.046 0l-.064-.998a7 7 0 0 1-.918 0zM8.5 4.5a.5.5 0 0 0-1 0v3h-3a.5.5 0 0 0 0 1h3v3a.5.5 0 0 0 1 0v-3h3a.5.5 0 0 0 0-1h-3z"/>
              </svg> Create Book
        </button>
      </div>
      <div class="card-body">
        <p>Use the button above to add a new Book.</p>
      </div>
    </div>
  </div>
   -->
        <!-- <div class="mb-3">
            <button type="button" class="btn btn-dark" data-toggle="modal" data-target="#addBookingModal">
                Add Booking
            </button>
        </div> -->
       

 <table id="bookingsTable" class="table table-striped table-bordered" >
        <thead class="thead-dark">
            <tr>
                <th scope="col">Serial No</th>
                <th scope="col">Customer Name</th>
                <th scope="col">PHONE_NO</th>
                <th scope="col">Room No</th>
                <th scope="col">Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="booking" items="${bookings}" varStatus="loop">
                <tr>
                    <td>${loop.index + 1}</td>
                    <td>${booking.customer_name}</td>
                    <td>${booking.phone_no}</td>
                    <td>${booking.room}</td>
                    <td>
                        <button class="btn btn-primary btn-sm" data-toggle="modal" data-target="#viewModal-${booking.id}">
                            <i class="fas fa-eye"></i> View
                        </button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<!-- Modals for viewing details -->
<c:forEach var="booking" items="${bookings}">
    <div class="modal fade" id="viewModal-${booking.id}" tabindex="-1" role="dialog" aria-labelledby="viewModalLabel-${booking.id}" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="viewModalLabel-${booking.id}">Booking Details</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">${booking.id}</h5>
                            
                            <p class="card-text"><strong>Phone:</strong> ${booking.phone_no}</p>
                            <p class="card-text"><strong>Room Number:</strong> ${booking.room}</p>
                            
                            <p class="card-text"><strong>Check-in:</strong> ${booking.check_in}</p>
                            <p class="card-text"><strong>Check-out:</strong> ${booking.check_out}</p>
                            <p class="card-text"><strong>Status:</strong> ${booking.booking_status}</p>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">
                        <i class="fas fa-times"></i> Close
                    </button>
                </div>
            </div>
        </div>
    </div>
</c:forEach>
    
    
    <!-- Add Booking Modal 
    <div class="modal fade" id="addBookingModal" tabindex="-1" role="dialog" aria-labelledby="addBookingModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="addBookingModalLabel">Add Booking</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form id="addBookingForm" onsubmit="handleBookingForm(event)">
                        <div class="form-group">
                            <label for="customerName">Customer Name</label>
                            <input type="text" class="form-control" id="customerName" placeholder="Enter customer name" required>
                            <div class="invalid-feedback">Please enter a customer name.</div>
                        </div>
                        <div class="form-group">
                            <label for="customerGender">Gender</label>
                            <select class="form-control" id="customerGender" required>
                                <option value="" disabled selected>Select gender</option>
                                <option value="Male">Male</option>
                                <option value="Female">Female</option>
                                <option value="Other">Other</option>
                            </select>
                            <div class="invalid-feedback">Please select a gender.</div>
                        </div>
                        <div class="form-group">
                            <label for="roomNumber">Room Number</label>
                            <input type="text" class="form-control" id="roomNumber" placeholder="Enter room number" required>
                            <div class="invalid-feedback">Please enter a room number.</div>
                        </div>
                        
                        
                        <div class="form-group">
                            <label for="checkInDate">Check-in Date</label>
                            <input type="date" class="form-control" id="checkInDate" required>
                            <div class="invalid-feedback">Please select a check-in date.</div>
                        </div>
                        <div class="form-group">
                            <label for="checkOutDate">Check-out Date</label>
                            <input type="date" class="form-control" id="checkOutDate" required>
                            <div class="invalid-feedback">Please select a check-out date.</div>
                        </div>
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
   -->
   
<script src="../../javascript/adminBooking.js"></script>
    
    <!-- JavaScript -->
   
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script>
        // JavaScript to handle modal opening and form submission
        $(document).ready(function () {
            $('#addBookingForm').submit(function (event) {
                // Prevent default form submission
                event.preventDefault();
                
                // Here, you can handle the form submission, e.g., send data to server using AJAX
                // For simplicity, let's just log the form data to the console
                var formData = $(this).serializeArray();
                console.log(formData);
                
                // Close the modal
                $('#addBookingModal').modal('hide');
            });
        });
    </script>
    <script>
    document.getElementById('exportButton').addEventListener('click', () => {
        const { jsPDF } = window.jspdf;
        const pdf = new jsPDF('p', 'pt', 'letter');
        const table = document.querySelector('.booking-table');

        html2canvas(table).then((canvas) => {
            const imgData = canvas.toDataURL('image/png');
            const imgProps = pdf.getImageProperties(imgData);
            const pdfWidth = pdf.internal.pageSize.getWidth();
            const pdfHeight = (imgProps.height * pdfWidth) / imgProps.width;

            pdf.addImage(imgData, 'PNG', 0, 0, pdfWidth, pdfHeight);
            pdf.save('booking_info.pdf');
        });
    });
</script>
 <script>
$(document).ready(function() {
    $('#bookingsTable').DataTable({
        "pageLength": 4,
        // Disable sorting on last column
        "columnDefs": [
            { "orderable": false, "targets": 4 }
        ],
        "dom": '<"top"f>rt<"bottom"lp><"clear">',
        language: {
            // Customize pagination prev and next buttons: use arrows instead of words
            'paginate': {
                'previous': '<span class="fa fa-chevron-left"></span>',
                'next': '<span class="fa fa-chevron-right"></span>'
            },
            // Customize number of elements to be displayed
            "lengthMenu": 'Display <select class="form-control input-sm">'+
            '<option value="5">5</option>'+
            '<option value="10">10</option>'+
            '<option value="20">20</option>'+
            '<option value="30">30</option>'+
            '<option value="40">40</option>'+
            '<option value="50">50</option>'+
            '<option value="-1">All</option>'+
            '</select> results'
        }
    });
});

</script>
</body>
</html>
