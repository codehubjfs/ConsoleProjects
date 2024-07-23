<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Car Rent Dashboard</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
        <title>Car Rent Dashboard</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="${ pageContext.request.contextPath}/assert/css/adminBooking.css">
    <script defer type="text/javascript" src="../../javascript/adminBooking.js"></script>
    
    <!-- Include jsPDF, autoTable, docx, and FileSaver libraries -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/2.4.0/jspdf.umd.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf-autotable/3.5.17/jspdf.plugin.autotable.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/docx/7.1.1/docx.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/FileSaver.js/2.0.5/FileSaver.min.js"></script>
    
    <style> @media (max-width: 1000px) {
            .sidebar {
                width: 100%;
                height: auto;
                position: relative;
            }
            .sidebar a {
                float: left;
            }
            .sidebar a:last-child {
                border-bottom: none;
            }
        }
        @media (min-width: 400px) {
            .sidebar {
                width: 250px;
                height: 100%;
                position: fixed;
            }
        }
        table.stylish-table {
            width: 100%;
            border-collapse: collapse;
            margin: 25px 0;
            font-size: 18px;
            text-align: left;
        }
        
        table.stylish-table thead tr {
            background-color: grey;
            color: #ffffff;
            text-align: left;
        }
        
        table.stylish-table th,
        table.stylish-table td {
            padding: 12px 15px;
        }
        body{
         background-image: linear-gradient(to right,#e3e2e2 ,white)
        }
        th{
       background-color:orange;
        }
        td{
        color:black
        }
        h1{
        color:black;
        }
        
        
        </style>
    
</head>
<body>
    <div class="sidebar container-fluid">
        <img src="${ pageContext.request.contextPath}/assert/images/logo2.png" alt="Logo"> <span style="text-align: center; padding: 10px;">
            <span style="color: orange;">GO</span> TRIP </span>  
        <a id="dashboardLink" href="${pageContext.request.contextPath}/admin-dashboard">Dashboard</a>
        <a href="${pageContext.request.contextPath}/admincars">Cars</a>
        <a href="${pageContext.request.contextPath}/bookingmanagement">Bookings</a>
         <a href="${pageContext.request.contextPath}/customermanagement">Customer</a>
        
    </div>
    <div class="content ">
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
              <li class="breadcrumb-item"><a href="main.html">Dashboard</a></li>
             
              <li class="breadcrumb-item active" aria-current="page">Booking </li>
            </ol>
          </nav>
        <div class="header row">
            <div class="name col mx-0">
            <!-- <h6>Rose</h6> -->    
            </div>
            <div class="profile col mx-0">
                <a class="d-block" data-bs-toggle="collapse" href="#profileMenu" role="button" aria-expanded="false" aria-controls="profileMenu">
                    <img class="rounded-pill align-self-center" src="${ pageContext.request.contextPath}/assert/images/profile.jpg" height="50" width="60" alt="">
                </a>
                <div class="collapse mt-2" id="profileMenu">
                    <div class="card card-body">
                        <div class="row pt-2 pb-2 menuss">
                            <a href="#" class="dropdown-item">Profile</a>
                        </div>
                        <div class="row pt-2 pb-2 menuss">
                            <a href="#" class="dropdown-item">Settings</a>
                        </div>
                        <div class="row pt-2 pb-2 menuss">
                            <a href="loginadmin.html" class="dropdown-item">Logout</a>
                        </div>
                        
                        
                    </div>
                </div>
            </div>
        </div>

        <h1 >Booking Management</h1>
       
         <button id="export-pdf" class="btn btn-outline-dark btn-sm">Export to PDF</button>
            <table class="stylish-table">
        <thead>
         
                <th>ID</th>
                <th>Start Date</th>
                <th>End Date</th>
                <th>Status</th>
                <th>Car Name</th>
                <th>User Name</th>
                <th>Rental Rate</th>
                <th>Actions</th>
                <th></th>
            
        </thead>
        <tbody>
         <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
            <c:forEach var="booking" items="${bookings}" varStatus="loop">
                <tr>
                    <td>${loop.index+1}</td>
                    <td>${booking.start_date}</td>
                    <td>${booking.end_date}</td>
                    <td>${booking.booking_status}</td>
                    <td>${booking.car_name}</td>
                    <td>${booking.user_name}</td>
                    
             
                    <td>${booking.rental_rate}</td>
                    
                     <td>
                      <button type="button" class="btn btn-warning btn-sm edit-booking-btn" data-booking-id="${booking.booking_id}" data-booking-status="${booking.booking_status}" data-bs-toggle="modal" data-bs-target="#editBookingStatusModal">Edit Status</button>
                            <button type="button" class="btn btn-danger btn-sm delete-booking-btn" data-booking-id="${booking.booking_id}" data-bs-toggle="modal" data-bs-target="#deleteBookingModal">Delete</button>
                    </td>
                
                    
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
     <div class="modal fade" id="editBookingStatusModal" tabindex="-1" aria-labelledby="editBookingStatusModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="editBookingStatusModalLabel">Edit Booking Status</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <form id="editBookingStatusForm" method="post" action="${pageContext.request.contextPath}/updateBookingStatus">
                            <input type="hidden" id="editBookingId" name="bookingId">
                            <div class="form-group">
                                <label for="editBookingStatus">Status</label>
                                <select class="form-control" id="editBookingStatus" name="bookingStatus" required>
                                    <option value="pending">Pending</option>
                                    <option value="confirmed">Confirmed</option>
                                    <option value="completed">Completed</option>
                                </select>
                            </div>
                            <button type="submit" class="btn btn-primary">Update Status</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <!-- Delete Booking Modal -->
        <div class="modal fade" id="deleteBookingModal" tabindex="-1" aria-labelledby="deleteBookingModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="deleteBookingModalLabel">Delete Booking</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        Are you sure you want to delete this booking?
                    </div>
                    <div class="modal-footer">
                        <form id="deleteBookingForm" method="get" action="${pageContext.request.contextPath}/deleteBooking">
                            <input type="hidden" id="deleteBookingId" name="bookingId">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                            <button type="submit" class="btn btn-danger">Delete</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <script>
            // JavaScript to populate the edit status modal with the selected booking data
            document.querySelectorAll('.edit-booking-btn').forEach(button => {
                button.addEventListener('click', () => {
                    const bookingId = button.getAttribute('data-booking-id');
                    const bookingStatus = button.getAttribute('data-booking-status');
                    document.getElementById('editBookingId').value = bookingId;
                    document.getElementById('editBookingStatus').value = bookingStatus;
                });
            });

            // JavaScript to set bookingId in the delete modal form
            document.querySelectorAll('.delete-booking-btn').forEach(button => {
                button.addEventListener('click', () => {
                    const bookingId = button.getAttribute('data-booking-id');
                    document.getElementById('deleteBookingId').value = bookingId;
                });
            });
        </script>
        <script>
document.getElementById('export-pdf').addEventListener('click', function () {
    const { jsPDF } = window.jspdf;
    const doc = new jsPDF();

    doc.autoTable({ html: '#car-list' });

    doc.save('table.pdf');
});
</script>
    
</body>
</html>
