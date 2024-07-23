<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html lang="en">	
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asserts/css/admin/reportmanagement.css">
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
                        <a href="${pageContext.request.contextPath}/WardenManagementController">Warden</a>
                        <a href="${pageContext.request.contextPath}/views/Admin/supervisormanagement.jsp">Supervisor</a>
                        <a href="${pageContext.request.contextPath}/AdminWorkerManagementController">Workers</a>
                    </div>
                    
                     <a href="#" class="active" id="sidereport">Report Management</a>
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
                                        <a href="${pageContext.request.contextPath}/index.jsp">Sign Out</a>
                                    </div>
                                </div>
                            </div>

                            <div class="left-profile">
                                <div class="role">Admin</div>
                                <div class="name">
                                <c:forEach items="${AdminName}" var="admin">
                                
                                	${admin.name}
                                </c:forEach>
                                
                                </div>
                            </div>
                            
                        </div>
                    </div>
                </div>
                <nav aria-label="breadcrumb">
                    <ol class="breadcrumb">
                        
                        <li class="breadcrumb-item "><a href="${pageContext.request.contextPath}/AdminDashboardController">Dashboard</a></li>
                        
                        <li class="breadcrumb-item active" aria-current="page">Report Management</li>
                    </ol>
                </nav>

                <!-- Top Metrics -->
                <div class="row metrics">
                    <div class="col-3">
                        <a href="${pageContext.request.contextPath}/AdminIssueRaised">
                            <div class="metric">
                                <div class="icon"><img src="${pageContext.request.contextPath}/asserts/image/admin/issuelogo.jpg" alt="Issue Raised"></div>
                                <div class="value">
                                ${NewIssueList}
                                </div>
                                <div class="label">Issue Raised</div>
                            </div>
                        </a> 
                    </div>
                    <div class="col-3">
                        <a href="${pageContext.request.contextPath}/AdminIssueAssigned"> 
                            <div class="metric">
                                <div class="icon"><img src="${pageContext.request.contextPath}/asserts/image/admin/assignedlogo.jpg" alt="Issue Assigned"></div>
                                <div class="value">
                                	${AssignedIssueList}
                                </div>
                                <div class="label">Issue Assigned</div>
                            </div>
                        </a>
                    </div>
                    <div class="col-3">
                        <a href="${pageContext.request.contextPath}/AdminIssueInprogress">
                            <div class="metric">
                                <div class="icon"><img src="${pageContext.request.contextPath}/asserts/image/admin/inprogresslogo.png" alt="In_Progress"></div>
                                <div class="value">
                               		 ${PendingIssueList}
                                </div>
                                <div class="label">In_Progress</div>
                            </div>
                        </a>
                    </div>
                    <div class="col-3" >
                       <a href="${pageContext.request.contextPath}/AdminTotalIssueController">
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
                </div>


                
                <div class="row metrics">
                     <div class="col-3" >
                       <a href="${pageContext.request.contextPath}/AdminWardenController">
                            <div class="metric">
                                <div class="icon">
                                   <img src="${pageContext.request.contextPath}/asserts/image/student/images-5.jpg" alt="Total Supervisors" height="41px;">
                                </div>
                                
                                <div class="value" >
                                    ${Wardencount}
                                </div>
                                <div class="label">Total Warden</div>
                            </div>
                        </a>
                        
                    </div>
                     <div class="col-3" >
                        <a href="${pageContext.request.contextPath}/AdminSupervisorController">
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
                    <div class="col-3" >
                        <a href="	${pageContext.request.contextPath}/AdminStudentController">
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
                        <a href="${pageContext.request.contextPath}/AdminWorkersController">
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
                    
                </div>

                

                <br>
                <br>
                <br>
                <br>
                <!-- Analysis Section -->
                <!-- Analysis Section -->
                <br>
                <br>
                <div class="row">
                    <div class="col-6" style="box-shadow: 0 0 0 2px rgb(240, 237, 237); width:48%;margin-left:10px">
                        <h4>Issue Raised per Month</h4>
                        <canvas id="issuesBarChart"></canvas>
                    </div>
                    <div class="col-6" style="box-shadow: 0 0 0 2px rgb(240, 237, 237);  width:48%;margin-left:20px">
                        <h4>Issue Status</h4>
                        <canvas id="issuesPieChart"></canvas>
                    </div>
                </div>
                <br>
                <br>
                <br>
                <br>
                <!-- Issue Categories Section -->


                

                <div class="row">
                    <div class="col-6" style="box-shadow: 0 0 0 2px rgb(240, 237, 237); width:48%;margin-left:10px">
                        <h4>Issue Category</h4>
                        <canvas id="issueCategoryChart"></canvas>
                    </div>
                    <div class="col-6"  style="box-shadow: 0 0 0 2px rgb(240, 237, 237);  width:48%;margin-left:20px">
                        <h4>Issue raised in Previous year and Present year</h4>
                        <canvas id="issuesLineChart"></canvas>
                    </div>
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

        
   
    var categoryChart = new Chart(ctxCategory, {
            type: 'doughnut',
            data: {
                labels: ['Food', 'Cleaning', 'Carpenter', 'Electricity', 'Plumber'],
                datasets: [{
                    label: 'Issue Categories',
                    data: [120, 90, 80, 50, 60],
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.2)',
                        'rgba(54, 162, 235, 0.2)',
                        'rgba(255, 206, 86, 0.2)',
                        'rgba(75, 192, 192, 0.2)',
                        'rgba(153, 102, 255, 0.2)'
                    ],
                    borderColor: [
                        'rgba(255, 99, 132, 1)',
                        'rgba(54, 162, 235, 1)',
                        'rgba(255, 206, 86, 1)',
                        'rgba(75, 192, 192, 1)',
                        'rgba(153, 102, 255, 1)'
                    ],
                    borderWidth: 1
                }]
            },
            options: {
                responsive: true
            }
        });

        
        var barChart = new Chart(ctxBar, {
            type: 'bar',
            data: {
                labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
                datasets: [{
                    label: 'Issues per Month',
                    data: [65, 59, 80, 81, 56, 55, 40],
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.2)',
                        'rgba(54, 162, 235, 0.2)',
                        'rgba(255, 206, 86, 0.2)',
                        'rgba(75, 192, 192, 0.2)',
                        'rgba(153, 102, 255, 0.2)',
                        'rgba(255, 159, 64, 0.2)',
                        'rgba(255, 99, 132, 0.2)'
                    ],
                    borderColor: [
                        'rgba(255, 99, 132, 1)',
                        'rgba(54, 162, 235, 1)',
                        'rgba(255, 206, 86, 1)',
                        'rgba(75, 192, 192, 1)',
                        'rgba(153, 102, 255, 1)',
                        'rgba(255, 159, 64, 1)',
                        'rgba(255, 99, 132, 1)'
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
    
    document.addEventListener('DOMContentLoaded', function() {
        var ctxBar = document.getElementById('issuesBarChart').getContext('2d');

        // Bar Chart
        var barChart = new Chart(ctxBar, {
            type: 'bar',
            data: {
                labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
                datasets: [{
                    label: 'Issues per Month',
                    data: [65, 59, 80, 81, 56, 55, 40],
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.2)',
                        'rgba(54, 162, 235, 0.2)',
                        'rgba(255, 206, 86, 0.2)',
                        'rgba(75, 192, 192, 0.2)',
                        'rgba(153, 102, 255, 0.2)',
                        'rgba(255, 159, 64, 0.2)',
                        'rgba(255, 99, 132, 0.2)'
                    ],
                    borderColor: [
                        'rgba(255, 99, 132, 1)',
                        'rgba(54, 162, 235, 1)',
                        'rgba(255, 206, 86, 1)',
                        'rgba(75, 192, 192, 1)',
                        'rgba(153, 102, 255, 1)',
                        'rgba(255, 159, 64, 1)',
                        'rgba(255, 99, 132, 1)'
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
    });
    const analysisChartCanvas = document.getElementById('issuesLineChart');
const analysisChart = new Chart(analysisChartCanvas, {
    type: 'line',
    data: {
        labels: ['Oct 2023', 'Nov 2023', 'Dec 2023', 'Jan 2024', 'Feb 2024', 'Mar 2024'],
        datasets: [{
            label: 'This Year',
            data: [7, 5, 8, 6, 9, 7], // Replace with actual data
            borderColor: 'rgba(255, 99, 132, 1)', // Red color
            fill: false,
            tension: 0.1 // Smoother line
        }, {
            label: 'This Month',
            data: [4, 6, 3, 5, 4, 5], // Replace with actual data
            borderColor: 'rgba(54, 162, 235, 1)', // Blue color
            fill: false,
            tension: 0.1 // Smoother line
        }]
    },
    options: {
        scales: {
            y: {
                beginAtZero: true
            }
        }
    }
});
    

});
    

</script>
    
</body>
</html>