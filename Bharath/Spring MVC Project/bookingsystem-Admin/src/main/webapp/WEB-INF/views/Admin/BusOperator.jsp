<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="../../style/AdminStyle.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.css">
    <script type="text/javascript" src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.js"></script>
    <script src="../Script.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>
<style>
.sidebar a {
    text-decoration: none;
}

.sidebar a.active {
    color: #d7df3f;
    background-color: #102754;
    border-radius: 15px;
    padding-left: 10px;
}
</style>
<body>
    <header>
        <nav>
            <ul>
                <li><img src="../Images/image1.png" alt="logo"></li>
                <li>Joy Rider</li>
                <li class="right-align"><img src="../Images/profile.png" alt="image"></li>
                <li>Charles Harris<div class="cent">Admin</div>
                </li>
            </ul>
        </nav>
    </header>
    <div class="container">
        <aside class="sidebar">
            <ul>
                <li class="sidebar-title" class="mt-5">ADMINISTRATOR</li>
                <li class="submenu">
                    <a href="http://127.0.0.1:5500/Admin/Index.html" onclick="toggleSubmenu('dashboardSubmenu')">DASHBOARD</a>
                    <ul id="dashboardSubmenu" style="display: none;">
                        <li class="space"><a href="#">- Analytics</a></li>
                    </ul>
                </li>
                <li class="submenu">
                    <a href="#" onclick="toggleSubmenu('userManagementSubmenu')" class="active">USER MANAGEMENT</a>
                    <ul id="userManagementSubmenu" style="display: none;">
                        <li class="space"><a href="http://127.0.0.1:5500/Admin/usermanament/customer.html#ch3">- Customer List</a></li>
                        <li class="spaceup"><a href="http://127.0.0.1:5500/Admin/usermanament/Busoperator.html#ch2">- Bus Operator List</a></li>
                    </ul>
                </li>
                <li class="submenu">
                    <a href="#" onclick="toggleSubmenu('routeManagementSubmenu')">ROUTE MANAGEMENT</a>
                    <ul id="routeManagementSubmenu" style="display: none;">
                        <li class="space"><a href="http://127.0.0.1:5500/Admin/RouteManagement/Routes.html">- Route Details</a></li>
                    </ul>
                </li>
                <!-- <li><a href="#">POPULAR ROUTES</a></li> -->
                <!-- <li class="menu-title">GENERAL</li> -->
                <div class="downside">
                <li>
                <a href="http://127.0.0.1:5500/Admin/Addadmin/Adminadd.html">ADD NEW ADMIN</a></li>
                <li><a href="http://127.0.0.1:5500/Admin/adminlogin/loginadmin.html">LOGOUT</a></li></div>
            </ul>
        </aside>
        <main class="content">
            <h2>User Management</h2>
                <h2>Bus Operator</h2>
                <!-- <div class="button-container">
                    <button class="add-customer-btn" onclick="openAddCustomerModal()">Add Customer</button>
                </div> -->
                <br>
                <div class="dt-container">
                    <table id="example" class="display" style="width:100%">
                    <thead>
                        <tr>
                            <th>S.No</th>
                            <th>Company Name</th>
                            <th>Bus Operator Name</th>
                            <th>Email</th>
                            <th>Password</th>
                            <th>Availability</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>1</td>
                            <td>primo company</td>
                            <td>Robert Brown</td>
                            <td>Robert@gmail.com</td>
                            <td>Joh@23ns</td>
                            <td class="availability">Active</td>
                            <td class="action-icons"> 
                                <button class="edit-btn" title="Edit" onclick="editStatus(this)" class="ai"><img src="../Images/edit.png" width="25px" alt=""></button> 
                                <img src="../Images/visible.png" width="20px" alt="View" title="View" onclick="viewDetails(this)" class="icon">
                            </td>
                        </tr>
                        <tr>
                            <td>2</td>
                            <td>Libertyexpress</td>
                            <td>Liam J</td>
                            <td>Liberty@gmail.com</td>
                            <td>lib@Er445</td>
                            <td class="availability">Active</td>
                            <td class="action-icons"> 
                                <button class="edit-btn" title="Edit" onclick="editStatus(this)" class="ai"><img src="../Images/edit.png" width="25px" alt=""></button> 
                                <img src="../Images/visible.png" width="20px" alt="View" title="View" onclick="viewDetails(this)" class="icon">
                            </td>
                        </tr>
                        <tr>
                            <td>3</td>
                            <td>GreenWichBus</td>
                            <td>Raj kumar</td>
                            <td>Green@gmail.com</td>
                            <td>Wich@gre2</td>
                            <td class="availability">Active</td>
                            <td class="action-icons"> 
                                <button class="edit-btn" title="Edit" onclick="editStatus(this)" class="ai"><img src="../Images/edit.png" width="25px" alt=""></button> 
                                <img src="../Images/visible.png" width="20px" alt="View" title="View" onclick="viewDetails(this)" class="icon">
                            </td>
                        </tr>
                        <tr>
                            <td>4</td>
                            <td>Primobus</td>
                            <td>Tim S</td>
                            <td>tim22@gmail.com</td>
                            <td>nj@23Sff</td>
                            <td class="availability">Active</td>
                            <td class="action-icons"> 
                                <button class="edit-btn" title="Edit" onclick="editStatus(this)" class="ai"><img src="../Images/edit.png" width="25px" alt=""></button> 
                                <img src="../Images/visible.png" width="20px" alt="View" title="View" onclick="viewDetails(this)" class="icon">
                            </td>
                        </tr>
                    </tbody>
                </table> 
         
            </div>
            <!--original-->
            <div id="myModal" class="modal">
                <div class="modal-content">
                    <span class="close" onclick="closeModal()">&times;</span>
                    <div class="modal-header">Customer Details</div>
                    <p id="modalDetails"></p>
                </div>
            </div>
            <!-- The Modal -->
             <div id="addCustomerModal" class="modal">
                <div class="modal-content">
                    <span class="close" onclick="closeAddCustomerModal()">&times;</span>
                    <div class="modal-header">Add Customer</div>
                    <form id="addCustomerForm">
                        <label>Enter name:</label>
                        <input type="text" id="customerName" placeholder="Name" required><br>
                        <label>Enter email:</label>
                        <input type="email" id="customerEmail" placeholder="Email" required><br>
                        <label>Enter password:</label>
                        <input type="password" id="customerPassword" placeholder="Password" required><br>
                        <label>Enter phone number:</label>
                         <input type="tel" id="customerPhone" placeholder="Phone Number" required><br>
                        <button type="reset" class="reset-btn">Reset</button> 
                        <button type="button" onclick="saveCustomer()" class="btn">Add</button>
                    </form>
                </div>
            </div>
            <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
            <script src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.min.js"></script>
            <script>
                function editStatus(button) {
                    var row = button.parentNode.parentNode;
                    var statusCell = row.cells[5]; // Assuming "Status" is the 6th column (0-based index)
        
                    var currentValue = statusCell.innerText;
                    var select = document.createElement('select');
                    select.innerHTML = '<option value="Active">Active</option><option value="Inactive">Inactive</option>';
                    select.value = currentValue;
                    statusCell.innerText = '';
                    statusCell.appendChild(select);
        
                    // Add "Save" icon
                    var saveIcon = document.createElement('i');
                    saveIcon.className = 'fas fa-save save';
                    saveIcon.title = 'Save';
                    saveIcon.style.fontSize='28px';
                    saveIcon.onclick = function() {
                        saveStatus(this);
                    };
                    button.parentNode.appendChild(saveIcon);
        
                    // Disable the "Edit" button
                    button.disabled = true;
                }
        
                function saveStatus(icon) {
                    var row = icon.parentNode.parentNode;
                    var statusCell = row.cells[5]; // Assuming "Status" is the 6th column (0-based index)
        
                    var select = statusCell.querySelector('select');
                    var editedValue = select.value;
                    statusCell.innerText = editedValue;
        
                    // Remove "Save" icon
                    var editBtn = row.querySelector('.edit-btn');
                    editBtn.disabled = false;
                    icon.parentNode.removeChild(icon);
                }
                // S.No: ${row.cells[0].innerText}<br>
                 function viewDetails(img) {
                    var row = img.parentNode.parentNode;
                    var details = `
                        Name: &nbsp;${row.cells[1].innerText}<br>
                        Gender: &nbsp;male <br>
                        Username:&nbsp;Bhar@22<br>
                        Email: &nbsp;${row.cells[2].innerText}<br>
                        Password:&nbsp;${row.cells[3].innerText}<br>
                        Phonenumber:&nbsp;9089078907<br>
                    `;
                    document.getElementById('modalDetails').innerHTML = details;
                    document.getElementById('myModal').style.display = "block";
                }
        
                function closeModal() {
                    document.getElementById('myModal').style.display = "none";
                }
                function openAddCustomerModal() {
                document.getElementById('addCustomerModal').style.display = 'block';
            }
        
            function closeAddCustomerModal() {
                document.getElementById('addCustomerModal').style.display = 'none';
            }
        
            function saveCustomer() {
                // Get values from form
                const name = document.getElementById('customerName').value;
                const email = document.getElementById('customerEmail').value;
                const password = document.getElementById('customerPassword').value;
        
                // Insert a new row into the table
                const table = document.getElementById('customerTable').getElementsByTagName('tbody')[0];
                const newRow = table.insertRow();
                const cell1 = newRow.insertCell(2);
                const cell2 = newRow.insertCell(3);
                const cell3 = newRow.insertCell(4);
                cell1.innerHTML = name;
                cell2.innerHTML = email;
                cell3.innerHTML = password;
        
                // Close the modal
                closeAddCustomerModal();
        
                // Reset the form fields
                document.getElementById('addCustomerForm').reset();
            }
            $(document).ready(function() {
            $('#example').DataTable();
        });
    </script>