<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Hotel Management System - Admin</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet" />
    
      <!-- Include jsPDF Library -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/2.4.0/jspdf.umd.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/1.4.1/html2canvas.min.js"></script>
    <link rel='stylesheet' href='https://cdn.datatables.net/1.13.5/css/dataTables.bootstrap5.min.css'>
	<script src='https://code.jquery.com/jquery-3.7.0.js'></script>
	<!-- Data Table JS -->
	<script src='https://cdn.datatables.net/1.13.5/js/jquery.dataTables.min.js'></script>
	<script src='https://cdn.datatables.net/responsive/2.1.0/js/dataTables.responsive.min.js'></script>
	<script src='https://cdn.datatables.net/1.13.5/js/dataTables.bootstrap5.min.js'></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asserts/css/admin/customer.css">
  </head>
  <body>
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

    <nav aria-label="breadcrumb">
      <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="dashboard">Home</a></li>
        <li class="breadcrumb-item active" aria-current="page">View Customer</li>
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
          <a href="RoomType" class="list-group-item pl-5 ">Room Types</a>
        </div>
        <a href="payments" class="list-group-item">Invoice Details</a>
        <a href="Customers" class="list-group-item active">Customers</a>
        <hr>
      </div>
    </div>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


    <div class="container content">
     
      <div class="d-flex justify-content-end my-3">
        <button id="exportButton" class="btn btn-primary">Export to PDF</button>
      </div>
      <h2 style="text-align: center;">View All Customers</h2>
      <table id="bookingsTable" class="table table-striped table-bordered" >
          <thead>
          <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Phone No</th>
            <th>Action</th>
          </tr>
        </thead>
         <tbody>
        <c:forEach var="customer" items="${customers}">
            <tr>
                <td>${customer.first_name} ${customer.last_name}</td>
                <td>${customer.email}</td>
                <td>${customer.phone}</td>
                <td>
                    <button class="btn btn-primary" data-toggle="modal" data-target="#viewModal-${customer.id}">View</button>
                </td>
            </tr>
        </c:forEach>
    </tbody>
    </table>
    
    <!-- Modals for View -->
    
     <!-- Modals for Viewing Customer Details -->
<c:forEach var="customer" items="${customers}">
    <div class="modal fade" id="viewModal-${customer.id}" tabindex="-1" role="dialog" aria-labelledby="viewModalLabel-${customer.id}" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="viewModalLabel-${customer.id}">Customer Details</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">${customer.first_name} ${customer.last_name}</h5>
                            <p class="card-text"><strong>Email:</strong> ${customer.email}</p>
                            <p class="card-text"><strong>Phone:</strong> ${customer.phone}</p>
                            <p class="card-text"><strong>Address:</strong> ${customer.address}</p>
                            <p class="card-text"><strong>Age:</strong> ${customer.age}</p>
                            <p class="card-text"><strong>Gender:</strong> ${customer.gender}</p>
                            <p class="card-text"><strong>State:</strong> ${customer.state}</p>
                            <!-- Add more fields as needed -->
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
</c:forEach>

    
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
     <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.7.0/chart.min.js"></script>
    
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.3/dist/Chart.min.js"></script>
<script>
      document.getElementById('exportButton').addEventListener('click', () => {
          const { jsPDF } = window.jspdf;
          const pdf = new jsPDF('p', 'pt', 'letter');
          const table = document.querySelector('.table');

          html2canvas(table).then((canvas) => {
              const imgData = canvas.toDataURL('image/png');
              const imgProps = pdf.getImageProperties(imgData);
              const pdfWidth = pdf.internal.pageSize.getWidth();
              const pdfHeight = (imgProps.height * pdfWidth) / imgProps.width;

              pdf.addImage(imgData, 'PNG', 0, 0, pdfWidth, pdfHeight);
              pdf.save('customer_info.pdf');
          });
      });
    </script>
    <script>
$(document).ready(function() {
    $('#bookingsTable').DataTable({
        "pageLength": 5,
        // Disable sorting on last column
        "columnDefs": [
            { "orderable": false, "targets": 3 }
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
