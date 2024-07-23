<%@ page import="java.util.List" %>
<%@ page import="bean.Customer" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Management</title>
    <link rel="stylesheet" href="style/AdminStyle.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.css">
    <script type="text/javascript" src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>

<body>
    <header>
      <nav>
            <ul>
                <li><img src="Images/image1.png" alt="logo"></li>
                <li>Joy Rider</li>
                <li class="right-align"><img src="Images/profile.png" alt="image"></li>
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
                    <a href="http://localhost:8038/bookticket/view/Admin/AdminIndex.jsp" onclick="toggleSubmenu('dashboardSubmenu')">DASHBOARD</a>
                    <ul id="dashboardSubmenu" style="display: none;">
                        <li class="space"><a href="#">- Analytics</a></li>
                    </ul>
                </li>
                <li class="submenu">
                    <a href="http://localhost:8038/bookticket/view/Admin/Customer.jsp#" onclick="toggleSubmenu('userManagementSubmenu')"  class="active">USER MANAGEMENT</a>
                    <ul id="userManagementSubmenu" style="display: none;">
                        <li class="space"><a href="http://127.0.0.1:5500/Admin/usermanament/customer.html#ch3">- Customer List</a></li>
                        <li class="spaceup"><a href="http://127.0.0.1:5500/Admin/usermanament/Busoperator.html#ch2">- Bus Operator List</a></li>
                    </ul>
                </li>
                <li class="submenu">
                    <a href="${pageContext.request.contextPath}/ViewRoutesController" onclick="toggleSubmenu('routeManagementSubmenu')" >ROUTE MANAGEMENT</a>
                    <ul id="routeManagementSubmenu" style="display: none;">
                        <li class="space"><a href="http://127.0.0.1:5500/Admin/RouteManagement/Routes.html">- Route Details</a></li>
                    </ul>
                </li>
                <!-- <li><a href="#">POPULAR ROUTES</a></li> -->
                <!-- <li class="menu-title">GENERAL</li> -->
                <div class="downside">
                <li>
                <a href="AddAdmin.jsp">ADD NEW ADMIN</a></li>
                <li><a href="Login.jsp">LOGOUT</a></li></div>
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
                        <%
                            List<Customer> customers = (List<Customer>) request.getAttribute("customers");
                            if (customers != null) {
                                int i = 1;
                                for (Customer customer : customers) {
                        %>
                            <tr>
                                <td><%= i++ %></td>
                                <td><%= customer.getFirstName() %></td>
                                <td><%= customer.getEmail() %></td>
                                <td><%= customer.getPassword() %></td>
                                <td class="action-icons"> 
                                    <button class="edit-btn" title="Edit" onclick="editStatus(this)" class="ai"><img src="../../Images/edit.png" width="25px" alt=""></button> 
                                    <img src="../../Images/visible.png" width="20px" alt="View" title="View" onclick="viewDetails(this)" class="icon">
                                </td>
                            </tr>
                        <%
                                }
                            }
                        %>
                    </tbody>
                </table>
            </div>

            <!-- Add Customer Modal -->
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

            <!-- Scripts -->
            <script>
                $(document).ready(function() {
                    $('#customerTable').DataTable();
                });

                function editStatus(button) {
                    var row = button.parentNode.parentNode;
                    var statusCell = row.cells[4];
                    var currentValue = statusCell.innerText;
                    var select = document.createElement('select');
                    select.innerHTML = '<option value="Active">Active</option><option value="Inactive">Inactive</option>';
                    select.value = currentValue;
                    statusCell.innerText = '';
                    statusCell.appendChild(select);

                    var saveIcon = document.createElement('i');
                    saveIcon.className = 'fas fa-save save';
                    saveIcon.title = 'Save';
                    saveIcon.style.fontSize='28px';
                    saveIcon.onclick = function() {
                        saveStatus(this);
                    };
                    button.parentNode.appendChild(saveIcon);
                    button.disabled = true;
                }

                function saveStatus(icon) {
                    var row = icon.parentNode.parentNode;
                    var statusCell = row.cells[4];
                    var select = statusCell.querySelector('select');
                    var editedValue = select.value;
                    statusCell.innerText = editedValue;
                    var editBtn = row.querySelector('.edit-btn');
                    editBtn.disabled = false;
                    icon.parentNode.removeChild(icon);
                }

                function viewDetails(img) {
                    var row = img.parentNode.parentNode;
                    var name = row.cells[1].innerText;
                    var email = row.cells[2].innerText;
                    var password = row.cells[3].innerText;
                    var status = row.cells[4].innerText;

                    var details = 'Name: ' + name + '\n' + 'Email: ' + email + '\n' + 'Password: ' + password + '\n' + 'Status: ' + status;
                    alert(details);
                }

                function openAddCustomerModal() {
                    document.getElementById('addCustomerModal').style.display = 'block';
                }

                function closeAddCustomerModal() {
                    document.getElementById('addCustomerModal').style.display = 'none';
                }

                function openEditCustomerModal() {
                    document.getElementById('editCustomerModal').style.display = 'block';
                }

                function closeEditCustomerModal() {
                    document.getElementById('editCustomerModal').style.display = 'none';
                }
            </script>
        </main>
    </div>
    <footer>
        <!-- Footer content -->
    </footer>
</body>
</html>