<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="${pageContext.request.contextPath}/asserts/js/admin/dashboard.js" defer></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asserts/css/admin/dashboard.css">
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
                    <a href="#" class="active" id="sidereport">Dashboard</a>
 
                    <button class="dropdown-btn" data-bs-toggle="collapse" data-bs-target="#userManagementDropdown" aria-expanded="false" aria-controls="userManagementDropdown">
                        User Management
                        <i class="fa fa-caret-down"></i>
                    </button>
                    <div class="collapse" id="userManagementDropdown">
                        <a href="${pageContext.request.contextPath}/AdminStudentUserController">Student</a>
                        <a href="${pageContext.request.contextPath}/WardenManagementController">Warden</a>
                        <a href="${pageContext.request.contextPath}/SuperVisorManagementController">Supervisor</a>
                        <a href="${pageContext.request.contextPath}/AdminWorkerManagementController">Workers</a>
                    </div>
                    	
                     <a href="${pageContext.request.contextPath}/AdminReportManagementController" id="sidereport">Report Management</a>
                     <a href="${pageContext.request.contextPath}//logout" id="sidereport">Log Out</a>
                 </nav>
                
            </div>

            <!-- Main Content -->
            <div class="col-10 main-content">
                <div class="row">
                    <div class="col-12">
                        <div class="header">
                            <h2>Dashboard Overview</h2>
                           
                           
                            <div class="user-profile">
                                <div class="dropdown profile">
                                    <img src="${pageContext.request.contextPath}/asserts/image/admin/person-circle (1).svg" alt="User Profile" id="profileDropdown" class="dropdown-toggle" aria-haspopup="true" aria-expanded="false">
                                    <button class="dropdown-btn"><i class="fa fa-caret-down1"></i></button>
                                    <div class="dropdown-container" id="dropdownContainer">
                                        <a href="#">View profile</a>
                                        <a href="#">Account Setting</a>
                                        <hr>
                                        <a href="${pageContext.request.contextPath}//logout">Sign Out</a>
                                    </div>
                                </div>
                            </div>

                            <div class="left-profile">
                                <div class="role">Admin</div>
                                <div class="name">
                               
                                <c:forEach items="${AdminDetails}" var="admin">
                                
                                	${admin.name}
                                </c:forEach>
                                
                                </div>
                            </div>
                            
                        </div>
                    </div>
                </div>
                <nav aria-label="breadcrumb">
                    <ol class="breadcrumb">
                        
                        <li class="breadcrumb-item active" aria-current="page">Dashboard</li>
                    </ol>
                </nav>

                <!-- Top Metrics -->
                <div class="row metrics">
                    <div class="col-3" >
                      
                            <div class="metric">
                                <div class="icon">
                                    <img src="${pageContext.request.contextPath}/asserts/image/admin/hourglass-split.svg" alt="Total Supervisors">
                                </div>
                                
                                <div class="value" >
                                    ${TotalIssueList}
                                </div>
                                <div class="label">Total Issue</div>
                            </div>
                        </a>
                        
                    </div>
                    <div class="col-3" >
                       
                            <div class="metric">
                                <div class="icon">
                                    <img src="${pageContext.request.contextPath}/asserts/image/admin/png-transparent-completed-text-trademark-logo.png" alt="Total Supervisors">
                                </div>
                                <div class="value">
                                    ${CompletedIssueList}
                                </div>
                                <div class="label">Issue Completed</div>
                            </div>
                       
                        
                    </div>
                    <div class="col-3" >
                       
                            <div class="metric">
                                <div class="icon">
                                    <img src="${pageContext.request.contextPath}/asserts/image/admin/not-completed-rubber-stamp-vector-12439898.jpg" alt="Total Supervisors">
                                </div>
                                <div class="value">
                                    ${PendingIssueList}
                                </div>
                                <div class="label">Issue Pending</div>
                            </div>
                        </a>
                        
                    </div>
                    <div class="col-3" >
                        
                            <div class="metric">
                                <div class="icon">
                                    <img src="${pageContext.request.contextPath}/asserts/image/admin/supervisorlogo.jpg" alt="Total Supervisors">
                                </div>
                                <div class="value">
                                    ${SupervisorCount}
                                </div>
                                <div class="label">Total Supervisors</div>
                            </div>
                        </a>
                        
                    </div>
                </div>
                
                <div class="row metrics">
                    <div class="col-3" >
                        
                            <div class="metric">
                                <div class="icon">
                                    <img src="${pageContext.request.contextPath}/asserts/image/student/images-5.jpg" alt="Total Supervisors" height="41px;">
                                </div>
                                <div class="value">
                                    ${Wardencount}
                                </div>
                                <div class="label">Total Warden</div>
                            </div>
                        </a>
                        
                    </div>
                    <div class="col-3" >
                       
                            <div class="metric" style="padding-bottom:32px;">
                                <div class="icon" >
                                <img src="${pageContext.request.contextPath}/asserts/image/student/studentlogo.png" alt="Total Wardens" >
                                </div>
                               <div class="value">
                                    ${StudentCount}
                                </div>
                                <div class="label">Total Student</div>
                            </div>
                        </a>
                        
                    </div>
                    <div class="col-3">
                       
                            <div class="metric" style="padding-bottom:32px;">
                                <div class="icon" >
                                	<img src="${pageContext.request.contextPath}/asserts/image/admin/labour.png" alt="Total Workers" height="30px;">
                                </div>
                                <div class="value">
                                ${WorkersCount}
                                </div>
                                <div class="label">Total Workers</div>
                            </div>
                        </a>
                        
                    </div>
                    
                  <div class="col-3">
                     
                            <div class="metric" style="padding-bottom:32px;">
                                <div class="icon" >
                                	<img src="${pageContext.request.contextPath}/asserts/image/admin/istockphoto-1362142320-612x612.jpg" alt="Total Workers" height="28px;">
                                </div>
                                <div class="value">
                                ${NewIssueList}
                                </div>
                                <div class="label">New Issue</div>
                            </div>
                        </a>
                        
                    </div>
                   </div>

                <!-- Analysis Section -->
                <div class="row" >
                    <div class="col-6">
                        <div class="analysis-card">
                            <h3>Analysis</h3>
                            <div class="tabs">
                                <button class="tab active">This Year</button>
                                <button class="tab">This Month</button>
                                <button class="tab">This Week</button>
                            </div>
                            <canvas id="analysisChart" style="width:100%;max-width:600px;"></canvas>
                        </div>  
                    </div>

                    <!-- Target vs Reality Section -->
                    
                     <div class="col-6">
                        <div class="ticket-system-card">
                             <h3>Tickets Raised vs Resolved</h3>
                             <canvas id="issuesBarChart"></canvas>
                            
                            <canvas id="ticketStatusChart" style="width:100%;max-width:600px;height:10px;"></canvas>
                            
                                    <div class="chart-data">
                                        <div class="data-item">
                                            <img src="${pageContext.request.contextPath}/asserts/image/admin/resolved.png" alt="Resolved Tickets">
                                            <span>Resolved Tickets</span>
                                            <span>8,823</span>
                                        </div>
                                        <div class="data-item">
                                            <img src="${pageContext.request.contextPath}/asserts/image/admin/images.png" alt="Raised Tickets">
                                            <span>Raised Tickets</span>
                                             <span>12,122</span>
                                        </div>
                                    </div>
                        </div>
                     </div>
                       
                </div>

                <!-- Sales Mapping by Category Section -->
                <div class="category-issue">
                    <h3>Issue Category</h3>
                </div>
                <div class="row">
                    <div class="col-2 cardspace">
                        <div class="sales-mapping-card">
                            <h5>Food</h5>
                            <div class="map-container">
                                <img src="${pageContext.request.contextPath}/asserts/image/admin/foodcard.png" alt="World Map">
                                <div class="issue-count">Issues: 15</div>
                            </div>
                        </div>
                    </div>
                    <div class="col-2 cardspace">
                        <div class="sales-mapping-card">
                            <h5>Electricity</h5>
                            <div class="map-container">
                                <img src="${pageContext.request.contextPath}/asserts/image/admin/electricitycard.jpg" alt="World Map">
                                <div class="issue-count">Issues: 22</div>
                            </div>
                        </div>
                    </div>
                    <div class="col-2 cardspace">
                        <div class="sales-mapping-card">
                            <h5>Carpentary</h5>
                            <div class="map-container">
                                <img src="${pageContext.request.contextPath}/asserts/image/admin/furniturecard.png" alt="World Map">
                                <div class="issue-count">Issues: 10</div>
                            </div>
                        </div>
                    </div>
                    <div class="col-2 cardspace">
                        <div class="sales-mapping-card">
                            <h5>Cleaning</h5>
                            <div class="map-container">
                                <img src="${pageContext.request.contextPath}/asserts/image/admin/cleaningcard.png" alt="World Map">
                                <div class="issue-count">Issues: 8</div>
                            </div>
                        </div>
                    </div>
                    <div class="col-2 cardspace">
                        <div class="sales-mapping-card">
                            <h5>Hall Seating</h5>
                            <div class="map-container">
                                <img src="${pageContext.request.contextPath}/asserts/image/admin/seatingcard.jpg" alt="World Map">
                                <div class="issue-count">Issues: 15</div>
                            </div>
                        </div>
                    </div>
                </div>


                <br>

                <div class="row">
                    
                    <div class="col-2 cardspacesecond">
                        <div class="sales-mapping-card">
                            <h5>Insects Problem</h5>
                            <div class="map-container">
                                <img src="${pageContext.request.contextPath}/asserts/image/admin/insectcard.png" alt="World Map">
                                <div class="issue-count">Issues: 22</div>
                            </div>
                        </div>
                    </div>
                    <div class="col-2 cardspace">
                        <div class="sales-mapping-card">
                            <h5>Plumbing</h5>
                            <div class="map-container">
                                <img src="${pageContext.request.contextPath}/asserts/image/admin/plumbingcard.jpg" alt="World Map">
                                <div class="issue-count">Issues: 10</div>
                            </div>
                        </div>
                    </div>
                    <div class="col-2 cardspace">
                        <div class="sales-mapping-card">
                            <h5>Civil</h5>
                            <div class="map-container">
                                <img src="${pageContext.request.contextPath}/asserts/image/admin/civilcard.png" alt="World Map">
                                <div class="issue-count">Issues: 8</div>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Volume vs Service Level and New Users Sections -->
                
            </div>
        </div>
    </div>
    <script>
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
    });
    var ctxBar = document.getElementById('issuesBarChart').getContext('2d');
     
        var barChart = new Chart(ctxBar, {
            type: 'bar',
            data: {
                labels: ['Total Issues', 'New Issue', 'Issue Assigned', 'In Progress', 'Completed Issues'],
                datasets: [{
                    label: 'Number of Tickets',
                    data: [300, 10, 25, 50, 75],
                    backgroundColor: [
                        'rgba(72, 190, 182, 0.2)',
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
                    borderWidth: 2
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
        
    
    
</script>
</body>
</html>