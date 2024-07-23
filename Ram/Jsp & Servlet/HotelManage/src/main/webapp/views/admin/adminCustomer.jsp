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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin/adminCustomer.css">
  </head>
  <body>
    <nav class="navbar navbar-expand-lg navbar-dark fixed-top bg-dark">
      <a class="navbar-brand" href="./main.html"><img src="./images/logo.jpg" alt="Logo" /></a>
      <span class="navbar-text mx-auto"><span style="font-size: 30px; color:white">Rk Hotel Management</span></span>
      <div class="dropdown profile">
        <img src="./images/admin.jpg" alt="Profile Picture" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" />
        <div class="dropdown-menu dropdown-menu-right">
         <a class="dropdown-item" href="${pageContext.request.contextPath}/views/admin/account.jsp">Account Settings</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="${pageContext.request.contextPath}/views/admin/index.jsp">Sign Out</a>
        </div>
      </div>
    </nav>

    <nav aria-label="breadcrumb">
      <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="./main.html">Home</a></li>
        <li class="breadcrumb-item active" aria-current="page">View Customer</li>
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
          <a href="${pageContext.request.contextPath}/ListRoomsServlet" class="list-group-item pl-5" active>All Rooms</a>
          <a href="${pageContext.request.contextPath}/ListRoomTypeServlet" class="list-group-item pl-5 ">Room Types</a>
        </div>
        <a href="${pageContext.request.contextPath}/invoice.jsp" class="list-group-item">Invoice Details</a>
        <a href="${pageContext.request.contextPath}/ViewCustomer" class="list-group-item">Customers</a>
        <hr>
        <a href="${pageContext.request.contextPath}/settings.jsp" class="list-group-item">Settings</a>
      </div>
    </div>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


    <div class="container content">
     
      <div class="d-flex justify-content-end my-3">
        <button id="exportButton" class="btn btn-primary">Export to PDF</button>
      </div>
      <h2 style="text-align: center;">View All Customers</h2>
      <table id="bookingsTable" class="table table-striped table-bordered">
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
              <td>${customer.firstName} ${customer.lastName}</td>
              <td>${customer.email}</td>
              <td>${customer.phoneNo}</td>
              <td>
                <button class="btn btn-primary" data-toggle="modal" data-target="#viewModal-${customer.customerId}">View</button>
              </td>
            </tr>
          </c:forEach>
        </tbody>
    </table>
    
    <!-- Modals for View -->
    
     <!-- Modals for viewing details -->
    <c:forEach var="customer" items="${customers}">
      <div class="modal fade" id="viewModal-${customer.customerId}" tabindex="-1" role="dialog" aria-labelledby="viewModalLabel-${customer.customerId}" aria-hidden="true">
        <div class="modal-dialog" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="viewModalLabel-${customer.customerId}">Customer Details</h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div class="modal-body">
              <div class="card">
                <div class="card-body">
                  <h5 class="card-title">${customer.firstName} ${customer.lastName}</h5>
                  <p class="card-text"><strong>Customer Id: </strong> ${customer.customerId}</p>
                  <p class="card-text"><strong>Email:</strong> ${customer.email}</p>
                  <p class="card-text"><strong>Phone:</strong> ${customer.phoneNo}</p>
                  <p class="card-text"><strong>Address:</strong> ${customer.address}</p>

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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.7.0/chart.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.3/dist/Chart.min.js"></script>
  </body>
</html>
