<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asserts/css/admin/details.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="script.js" defer></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    
</head>
<body>
    <div class="container-fluid">
        <div class="row">
            <!-- Sidebar -->
            <div class="col-2 sidebar">
                <div class="logo">
                    <img src="${pageContext.request.contextPath}/asserts/image/admin/ticket-perforated-fill (1).svg" alt="Logo"> 
                    <span>Ticket Raise</span>
                </div>
                <nav>
                     <a href="${pageContext.request.contextPath}/AdminDashboardController" id="sidereport">Dashboard</a>
 
                    <button class="dropdown-btn" data-bs-toggle="collapse" data-bs-target="#userManagementDropdown" aria-expanded="false" aria-controls="userManagementDropdown">
                        User Management
                        <i class="fa fa-caret-down"></i>
                    </button>
                    <div class="collapse" id="userManagementDropdown">
                       <a href="${pageContext.request.contextPath}/AdminStudentUserController">Student</a>
                        <a href="wardenmanagement.jsp">Warden</a>
                        <a href="supervisormanagement.jsp">Supervisor</a>
                           <a href="${pageContext.request.contextPath}/AdminWorkerManagementController">Workers</a>
                    </div>
                    
                       <a href="${pageContext.request.contextPath}/AdminReportManagementController" class="active" id="sidereport">Report Management</a>
                     <a href="${pageContext.request.contextPath}//logout" id="sidereport">Log Out</a>
                 </nav>
                
            </div>

            <!-- Main Content -->
            <div class="col-10 main-content">
                <div class="row">
                    <div class="col-12">
                        <div class="header">
                            <h2>Report Management</h2> 
                            <div class="user-profile">
                                <div class="dropdownprofile">
                                    <img src="${pageContext.request.contextPath}/asserts/image/admin/person-circle (1).svg" alt="User Profile" id="profileDropdown" class="dropdown-toggle" aria-haspopup="true" aria-expanded="false">
                                    <button class="dropdown-btn"><i class="fa fa-caret-down1"></i></button>
                                    <div class="dropdown-container" id="dropdownContainer">
                                        <a href="#">View profile</a>
                                        <a href="#">Account Setting</a>
                                        <hr>
                                        <a href="..\Home\home.html">Sign Out</a>
                                    </div>
                                </div>
                            </div>

                            <div class="left-profile">
                                <div class="role">Admin</div>
                                <c:forEach items="${AdminDetails}" var="admin">
                                
                                	${admin.name}
                                </c:forEach>
                            </div>
                            
                        </div>
                    </div>
                </div>
                <nav aria-label="breadcrumb">
                    <ol class="breadcrumb">
                        
                         <li class="breadcrumb-item "><a href="${pageContext.request.contextPath}/AdminDashboardController">Dashboard</a></li>
                        <li class="breadcrumb-item "><a href="${pageContext.request.contextPath}/AdminReportManagementController">Report Management</a></li>
                        <li class="breadcrumb-item active" aria-current="page">Warden Details</li>
                    </ol>
                </nav>

                <br>
                <br>
                <h3>Warden Details</h3>
                
                
                <br>
                
                               
                           
                           
                        
                     <table class="table table-striped table-bordered" id="myTable">
                    <thead class="thead-Dark">               
                           
                
                        <tr>
                       		<th scope='col'>S.No</th>
                            <th scope="col">Name</th>
                            <th scope="col">Mailid</th>
                          
                           
                            
                            
                            
                        </tr>
                    </thead>
                        <tbody>
                        	<c:forEach items="${wardendetails}" var="warden" varStatus="status">
	                      		<tr data-item-id="${warden.wardenid}">
	                      		
	                      			<td>${status.count}</td>
	                      			<td class="warden">${warden.name}</td>
	                      			<td>${warden.mailid}</td>
	                      			
	                      			
	                      		</tr>
                      		</c:forEach>
                       </tbody> 

                   
                </table>


                <!-- Sales Mapping by Country Section -->
                

                <!-- Volume vs Service Level and New Users Sections -->
                
            
        </div>
    </div>
<script>

document.addEventListener('DOMContentLoaded', function () {
            const rowsPerPage = 10;
            const table = document.querySelector('table tbody');
            const rows = table.querySelectorAll('tr');
            const pageCount = Math.ceil(rows.length / rowsPerPage);
            const paginationControls = document.getElementById('paginationControls');

            function showPage(page) {
                const start = (page - 1) * rowsPerPage;
                const end = start + rowsPerPage;

                rows.forEach((row, index) => {
                    if (index >= start && index < end) {
                        row.classList.remove('hidden');
                    } else {
                        row.classList.add('hidden');
                    }
                });
            }

            paginationControls.addEventListener('click', function (event) {
                if (event.target.tagName === 'A') {
                    event.preventDefault();
                    const page = Number(event.target.getAttribute('data-page'));
                    showPage(page);
                }
            });

            // Initialize to show the first page
            showPage(1);
        });

        
    function toggleSidebar() {
            var sidebar = document.getElementById("mySidebar");
            var content = document.querySelector('.content');
            if (sidebar.style.width === "250px") {
                sidebar.style.width = "0";
                content.style.marginLeft = "0";
            } else {
                sidebar.style.width = "250px";
                content.style.marginLeft = "250px";
            }
        }

        var dropdown = document.getElementsByClassName("dropdown-btn");
        var i;

        for (i = 0; i < dropdown.length; i++) {
            dropdown[i].addEventListener("click", function() {
                this.classList.toggle("inactive");
                var dropdownContent = this.nextElementSibling;
                if (dropdownContent.style.display === "block") {
                    dropdownContent.style.display = "none";
                } else {
                    dropdownContent.style.display = "block";
                }
            });
        }
     document.addEventListener('DOMContentLoaded', function() {
        var profileDropdown = document.getElementById('profileDropdown');
        var dropdownContainer = document.getElementById('dropdownContainer');
    
        profileDropdown.addEventListener('click', function() {
            dropdownContainer.style.display = dropdownContainer.style.display === 'block' ? 'none' : 'block';
        });
    
        // Close the dropdown if the user clicks outside of it
        window.onclick = function(event) {
            if (!event.target.matches('#profileDropdown')) {
                if (dropdownContainer.style.display === 'block') {
                    dropdownContainer.style.display = 'none';
                }
            }
        }
    

    var ctxBar = document.getElementById('issuesBarChart').getContext('2d');
        var ctxPie = document.getElementById('issuesPieChart').getContext('2d');
        var ctxCategory = document.getElementById('issueCategoryChart').getContext('2d');

        var barChart = new Chart(ctxBar, {
            type: 'bar',
            data: {
                labels: ['Total Issues', 'Issue Raised', 'Issue Assigned', 'In Progress', 'Completed Issues'],
                datasets: [{
                    label: 'Number of Issues',
                    data: [300, 10, 25, 50, 75],
                    backgroundColor: [
                        'rgba(75, 192, 192, 0.2)',
                        'rgba(54, 162, 235, 0.2)',
                        'rgba(255, 206, 86, 0.2)',
                        'rgba(153, 102, 255, 0.2)',
                        'rgba(255, 159, 64, 0.2)'
                    ],
                    borderColor: [
                        'rgba(75, 192, 192, 1)',
                        'rgba(54, 162, 235, 1)',
                        'rgba(255, 206, 86, 1)',
                        'rgba(153, 102, 255, 1)',
                        'rgba(255, 159, 64, 1)'
                    ],
                    borderWidth: 1
                }]
            },
            options: {
                scales: {
                    yAxes: [{
                        ticks: {
                            beginAtZero: true
                        }
                    }]
                }
            }
        });

        var pieChart = new Chart(ctxPie, {
            type: 'pie',
            data: {
                labels: ['Total Issues', 'Issue Raised', 'Issue Assigned', 'In Progress', 'Completed Issues'],
                datasets: [{
                    label: 'Number of Issues',
                    data: [300, 10, 25, 50, 75],
                    backgroundColor: [
                        'rgba(75, 192, 192, 0.2)',
                        'rgba(54, 162, 235, 0.2)',
                        'rgba(255, 206, 86, 0.2)',
                        'rgba(153, 102, 255, 0.2)',
                        'rgba(255, 159, 64, 0.2)'
                    ],
                    borderColor: [
                        'rgba(75, 192, 192, 1)',
                        'rgba(54, 162, 235, 1)',
                        'rgba(255, 206, 86, 1)',
                        'rgba(153, 102, 255, 1)',
                        'rgba(255, 159, 64, 1)'
                    ],
                    borderWidth: 1
                }]
            },
            options: {
                responsive: true
            }
        });

        
    });

</script>
    
</body>
</html>