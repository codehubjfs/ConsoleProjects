<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="com.ticket.model.Customer" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Management</title>
    
       <link rel="stylesheet" href="${pageContext.request.contextPath}/style/AdminStyle.css">
 	
    <!-- Bootstrap Icons CSS -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.9.1/font/bootstrap-icons.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.css">
    <script type="text/javascript" src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <style>
    .displaysf{
      display: flex;
      }
          .action-column .edit-btn,
    .action-column .view-btn {
        margin-right: 10px;
    }
.hidden {
    display: none;
}

    .action-column .view-btn {
        margin-right: 0; /* To remove extra margin from the last element */
    }
   table {
    margin: 0 auto !important; /* Center the table horizontally */
    width: 100% !important; /* Example: Adjust width as needed */
}

thead th {
    text-align: center!important; /* Center align text in table header */
}

tbody td {
    text-align: left !important; /* Left align text in table body cells */
    vertical-align: middle!important; /* Align content vertically centered */
    padding-left:60px!important;
    	
}

.centered-actions {
    display: flex;
    justify-content: left !important; /* Center buttons horizontally */
    align-items: center !important; /* Center buttons vertically */
    gap: 5px; /* Adjust the space between buttons */
    text-align: center !important; /* Center align text within the action column */
    padding-left: 60px; /* Example: Adjust left padding as needed */
}

    
    </style>
</head>

<body>
    <header>
      <nav>
            <ul>
                <li><img src="${pageContext.request.contextPath}/Images/image1.png" alt="logo"></li>
                <li>Joy Rider</li>
                <li class="right-align"><img src="${pageContext.request.contextPath}/Images/profile.png" alt="image"></li>
                <li>Charles Harris <div class="cent">Admin</div>
                </li>
            </ul>
        </nav>
    </header>
    <div class="container">
        <aside class="sidebar">
            <ul>
                <li class="sidebar-title" class="mt-5">ADMINISTRATOR</li>
                <li class="submenu">
                    <a href="card" onclick="toggleSubmenu('dashboardSubmenu')">DASHBOARD</a>
                    <ul id="dashboardSubmenu" style="display: none;">
                        <li class="space"><a href="http://127.0.0.1:5500/Admin/usermanament/customer.html">- Analytics</a></li>
                    </ul>
                </li>
                <li class="submenu">
                    <a href="customers" class="actives" onclick="toggleSubmenu('userManagementSubmenu')">USER MANAGEMENT</a>
                    <ul id="userManagementSubmenu" style="display: none;">
                        <li class="space"><a href="http://127.0.0.1:5500/Admin/usermanament/customer.html">- Customer List</a></li>
                        <li class="spaceup"><a href="http://127.0.0.1:5500/Admin/usermanament/Busoperator.html">- Bus Operator List</a></li>
                    </ul>
                </li>
                <li class="submenu">
                    <a href="viewroutes" onclick="toggleSubmenu('routeManagementSubmenu')">ROUTE MANAGEMENT</a>
                    <ul id="routeManagementSubmenu" style="display: none;">
                        <li class="space"><a href="http://127.0.0.1:5500/Admin/RouteManagement/Routes.html">- Route Details</a></li>
                    </ul>
                </li>
                <!-- <li><a href="#">POPULAR ROUTES</a></li> -->
                <!-- <li class="menu-title">GENERAL</li> -->
                <div class="downside">
                <li>
                <a href="adminadd">ADD NEW ADMIN</a></li>
                <li><a href="logout">LOGOUT</a></li></div>
            </ul>
        </aside>
        <main class="content">
            <h2>User Management</h2>
            <h2>Customer List</h2>
            <br>
           <div class="dt-container">
    <table id="customerTable" class="display" style="width:100%">
        <thead>
            <tr>
                <th>S.No</th>
                <th>Name</th>
                <th>Email</th>
                <th>Password</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="customer" items="${customers}" varStatus="status">
        <tr>
            <td class="customerId" style="display:none;"><c:out value="${customer.customer_Id}" /></td>
            <td><c:out value="${status.index + 1}" /></td>
            <td><c:out value="${customer.firstName} ${customer.lastName}" /></td>
            <td><c:out value="${customer.email}" /></td>
                    <td><c:out value="${customer.password}" /></td>
                    <td class="status-column">
                        <span class="status-text ${customer.available.toLowerCase()}">${customer.available}</span>
                        <select class="form-select status-select" name="newStatus" style="display: none;">
                            <option value="ACTIVE" <c:if test="${customer.status == 'ACTIVE'}">selected</c:if>>ACTIVE</option>
                            <option value="INACTIVE" <c:if test="${customer.status == 'INACTIVE'}">selected</c:if>>INACTIVE</option>
                            <option value="BLOCKED" <c:if test="${customer.status == 'BLOCKED'}">selected</c:if>>BLOCKED</option>
                        </select>
                    </td>
                    <td>
                        <button type="button" class="btn btn-outline-primary btn-sm edit-btn">
                            <i class="fas fa-edit"></i>
                        </button>
                        <button type="submit" class="btn btn-outline-success btn-sm save-btn" style="display: none;">
                            <i class="fas fa-save"></i>
                        </button>
                        <button type="button" class="btn btn-outline-danger btn-sm cancel-btn" style="display: none;">
                            <i class="fas fa-times-circle"></i>
                        </button>
                        <input type="hidden" name="userId" value="${customer.customer_Id}">
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
            <div id="addCustomerModal" class="modal">
                <div class="modal-content">
                    <span class="close" onclick="closeAddCustomerModal()">&times;</span>
                    <div class="modal-header">Add Customer</div>
                    <form id="addCustomerForm" method="post" action="CustomerController">
                        <label>Enter name:</label>
                        <input type="text" name="name" placeholder="Name" required><br>
                        <label>Enter email:</label>
                        <input type="email" name="email" placeholder="Email" required><br>
                        <label>Enter password:</label>
                        <input type="password" name="password" placeholder="Password" required><br>
                        <label>Enter phone number:</label>
                        <input type="tel" name="phoneNumber" placeholder="Phone Number" required><br>
                        <label>Enter status:</label>
                        <input type="text" name="status" placeholder="Status" required><br>
                        <button type="reset" class="reset-btn">Reset</button> 
                        <button type="submit" class="btn">Add</button>
                    </form>
                </div>
            </div>      
        </main>
    </div>
</body>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.js"></script>
    <script>
    $(document).ready(function() {
        $('#customerTable').DataTable();
    });


        document.querySelectorAll('.edit-btn').forEach(button => {
            button.addEventListener('click', function() {
                let row = this.closest('tr');
                row.querySelector('.status-text').style.display = 'none';
                row.querySelector('.status-select').style.display = 'block';
                row.querySelector('.edit-btn').style.display = 'none';
                row.querySelector('.save-btn').style.display = 'inline-block';
                row.querySelector('.cancel-btn').style.display = 'inline-block';
            });
        });

        document.querySelectorAll('.cancel-btn').forEach(button => {
            button.addEventListener('click', function() {
                let row = this.closest('tr');
                let statusSelect = row.querySelector('.status-select');
                let statusText = row.querySelector('.status-text');
                statusSelect.value = statusText.textContent.trim();
                statusText.style.display = 'block';
                statusSelect.style.display = 'none';
                row.querySelector('.edit-btn').style.display = 'inline-block';
                row.querySelector('.save-btn').style.display = 'none';
                row.querySelector('.cancel-btn').style.display = 'none';
            });
        });
        document.querySelectorAll('.save-btn').forEach(button => {
            	button.addEventListener('click', function () {
                let row = this.closest('tr');
                let cid = row.querySelector('.customerId');
                //console.log(cid.textContent);
                  let statusSelect = row.querySelector('.status-select');
                let statusText = row.querySelector('.status-text');
                statusText.textContent = statusSelect.value;
                statusText.style.display = 'block';
                statusSelect.style.display = 'none';
                row.querySelector('.edit-btn').style.display = 'inline-block';
                row.querySelector('.save-btn').style.visibility = 'hidden';
                row.querySelector('.cancel-btn').style.visibility = 'hidden';
                location.href = "updateCustomer?status="+statusSelect.value+"&id="+cid.textContent;
            });
        });
        function viewDetails(icon) {
            const row = icon.closest('tr');
            const name = row.cells[1].innerText;
            const email = row.cells[2].innerText;
            const password = row.cells[3].innerText;
            const status = row.querySelector('.status-column .view-mode').innerText;

            const details = `Name: ${name}\nEmail: ${email}\nPassword: ${password}\nStatus: ${status}`;
            alert(details);
        }
        
    </script>
</html>