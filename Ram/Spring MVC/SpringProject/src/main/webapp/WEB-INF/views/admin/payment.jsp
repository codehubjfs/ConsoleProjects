<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

    
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Invoice List</title>
  <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asserts/css/admin/invoice.css">
  <link rel='stylesheet' href='https://cdn.datatables.net/1.13.5/css/dataTables.bootstrap5.min.css'>
	<script src='https://code.jquery.com/jquery-3.7.0.js'></script>
	<!-- Data Table JS -->
	<script src='https://cdn.datatables.net/1.13.5/js/jquery.dataTables.min.js'></script>
	<script src='https://cdn.datatables.net/responsive/2.1.0/js/dataTables.responsive.min.js'></script>
	<script src='https://cdn.datatables.net/1.13.5/js/dataTables.bootstrap5.min.js'></script>
  
  <style>
  .breadcrumb {
        position: relative;
        top: 0px;
        left: 15px;
        	
        z-index: 1000;
    }
   
    .table-container {
        display: flex;
        justify-content: center;
    }
  </style>
</head>
<body>
  <nav class="navbar navbar-expand-lg navbar-dark fixed-top bg-dark">
    <a class="navbar-brand" href="Dashboard"
      ><img src="${pageContext.request.contextPath}/asserts/images/logo.jpg" alt="Logo"
    /></a>
    <span class="navbar-text mx-auto"
      ><span style="font-size: 30px; color:white">Rk Hotel Management</span></span
    >
  
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
        <a href="viewBookings" class="list-group-item ">Bookings</a>
        <a href="ListStaffServlet" class="list-group-item">Front Desk Staff</a>
        <a href="ListKeeperServlet" class="list-group-item">Housekeeper Staff</a>
        <a href="#roomsSubmenu" class="list-group-item dropdown-toggle" data-toggle="collapse">Rooms</a>
        <div class="collapse" id="roomsSubmenu">
          <a href="ShowRoom" class="list-group-item pl-5" >All Rooms</a>
          <a href="RoomType" class="list-group-item pl-5 ">Room Types</a>
        </div>
        <a href="payments" class="list-group-item active">Invoice Details</a>
        <a href="Customers" class="list-group-item">Customers</a>
        <hr>
      </div>
    </div>

  <div class="content mt-5">
        <!-- Breadcrumbs -->
        <nav aria-label="breadcrumb" style="--bs-breadcrumb-divider: '>'; " >
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="dashboard">Home</a></li>
                <li class="breadcrumb-item active" aria-current="page">Receptionist</li>
            </ol>
        </nav>
        
         <!-- Export to PDF Button -->
      <div class="d-flex justify-content-end my-3">
    <button id="exportButton" class="btn btn-primary">Export to PDF</button>
</div>
        <div class="mt-5">
            <h2 style="text-align: center;">Invoice List</h2>
            <div class="card mb-4">
                <div class="card-header" style="text-align: center; font-size: large;">Customer Bookings</div>
                <div class="card-body table-container">
                    <table class="table table-bordered" id="myTable">
                         <thead class="thead-dark">
              <tr>
                <th scope="col">Serial No</th> <!-- Serial No -->
                <th scope="col">Payment ID</th>
                <th scope="col">Booking ID</th>
                <th scope="col">Amount</th>
                <th scope="col">Payment Date</th>
                <th scope="col">Payment Method</th>
                <th scope="col">Payment Status</th>
                <th scope="col">Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="payment" items="${payments}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td> <!-- Serial No -->
                    <td>${payment.payment_id}</td>
                    <td>${payment.booking_id}</td>
                    <td>${payment.payment_amt}</td>
                    <td>${payment.payment_date}</td>
                    <td>${payment.payment_method}</td>
                    <td>${payment.payment_status}</td>
                    <td>
                        <button class="btn btn-primary" data-toggle="modal" data-target="#viewModal-${payment.payment_id}">View</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
  
  
   
    <!-- Modal Structure -->
   <c:forEach var="payment" items="${payments}">
    <div class="modal fade" id="viewModal-${payment.payment_id}" tabindex="-1" role="dialog" aria-labelledby="viewModalLabel-${payment.payment_id}" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="viewModalLabel-${payment.payment_id}">Payment Details</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <p><strong>Payment ID:</strong> ${payment.payment_id}</p>
                    <p><strong>Booking ID:</strong> ${payment.booking_id}</p>
                    <p><strong>Amount:</strong> ${payment.payment_amt}</p>
                    <p><strong>Payment Date:</strong> ${payment.payment_date}</p>
                    <p><strong>Payment Method:</strong> ${payment.payment_method}</p>
                    <p><strong>Payment Status:</strong> ${payment.payment_status}</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
</c:forEach>


<!-- Include jQuery and Bootstrap JS -->

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<!-- Include jsPDF and html2canvas Libraries -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/2.4.0/jspdf.umd.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/0.4.1/html2canvas.min.js"></script>
<script>
$(document).ready(function() {
    $('#myTable').DataTable({
        "pageLength": 5,
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
<script>
    document.getElementById('exportButton').addEventListener('click', () => {
        const { jsPDF } = window.jspdf;
        const pdf = new jsPDF('p', 'pt', 'letter');

        const table = document.querySelector('.table');
        
        html2canvas(table, {
            onrendered: function(canvas) {
                const imgData = canvas.toDataURL('image/png');
                const imgProps = pdf.getImageProperties(imgData);
                const pdfWidth = pdf.internal.pageSize.getWidth();
                const pdfHeight = (imgProps.height * pdfWidth) / imgProps.width;

                pdf.addImage(imgData, 'PNG', 0, 0, pdfWidth, pdfHeight);
                pdf.save('payment_details.pdf');
            }
        });
    });
</script>
</body>
</html>
