
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Panel</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <!-- Boxicons CSS for icons -->
    <link href="https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/@mdi/font/css/materialdesignicons.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link rel="stylesheet" href="..\..\assets\css\admin.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <style>
        .container {
            padding-top: 20px;
        }

        .card {
            height: 150px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
            transition: transform 0.2s;
        }

        .card:hover {
            transform: translateY(-5px);
        }

        .card-title {
            text-align: center;
            font-size: 1.2rem;
            font-weight: bold;
        }

        .card-text {
            text-align: center;
            font-size: 2rem;
            font-weight: bold;
        }

        .chart-container {
            margin-top: 40px;
            height: auto; /* Adjusted to be responsive */
            display: flex;
            justify-content: center;
            align-items: center;
            gap: 50px;
        }

        .chart-container .chart {
            border: 1px solid #1b1b1b;
            border-radius: 5px;
            padding: 15px;
            margin-bottom: 20px;
            flex: 1;
        }

        .chart-container .chart h5 {
            text-align: center;
            margin-bottom: 20px;
        }

        /* Ensure charts are responsive */
        @media (max-width: 768px) {
            .chart-container {
                flex-direction: column; /* Stack charts vertically on smaller screens */
            }
            .chart-container .chart {
                width: 100%; /* Full width on smaller screens */
                max-width: 100%;
            }
        }
        
      
    </style>
</head>

<%

   response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//http 1.1
   response.setHeader("Pragma","no-cache");//http1.0
   response.setHeader("Expires","0");// Proxies
   
   if(session.getAttribute("admin")==null){
	   
		request.getRequestDispatcher("/views/Admin/AdminLogin.jsp").forward(request, response);
   }

%>


<body id="body-pd">
    <header class="header" id="header">
        <div class="header_toggle">
            <i class='bx bx-menu' id="header-toggle"></i>
        </div>
        <div class="header_info">
            <div class="header_img">
                <img src="${pageContext.request.contextPath}/assets/image/admin.png" alt="Profile Image">
            </div>
            <span class="admin_text">${admin.name}</span>
            <div class="header_icons">
                <i class='bx bx-bell' id="notification-icon" title="Notifications"></i>
                <i class='bx bx-envelope' id="message-icon" title="Messages"></i>
                <i class='bx' id="logout-icon" title=""></i>
            </div>
        </div>
    </header>
    <div class="l-navbar" id="nav-bar">
        <nav class="nav">
            <div>
                <a href="#" class="nav_logo">
                    <img src="${pageContext.request.contextPath}/assets/images/head.2.png" alt="">
                </a>
                <div class="nav_list">
                    <a href="${pageContext.request.contextPath}/views/Admin/admin.jsp" class="nav_link active">
                        <i class='bx bx-grid-alt nav_icon'></i>
                        <span class="nav_name">Dashboard</span>
                    </a>
                    <a href="../../AdminRetriveData" class="nav_link">
                        <i class='fas fa-users nav_icon'></i>
                        <span class="nav_name">Job Seekers</span>
                    </a>
                    <a href="../../AdminEmployerView" class="nav_link">
                        <i class='fas fa-user-tie nav_icon'></i>
                        <span class="nav_name">Employers</span>
                    </a>
                     <a href="../../JobsController" class="nav_link">
                        <i class='fas fa-briefcase nav_icon'></i>
                        <span class="nav_name">Jobs</span>
                    </a>
                    <a href="../../AdminProfileView" class="nav_link">
                        <i class='bx bx-user nav_icon'></i>
                        <span class="nav_name">My Profile</span>
                    </a>
                     <a href="#" class="nav_link" id="logout-link">
                        <i class='bx bx-log-out nav_icon'></i>
                        <span class="nav_name">Sign Out</span>
                    </a>
                </div>
            </div>
        </nav>
    </div>

    <div class="container mt-5">
        <div class="row mt-4">
            <div class="col-md-6 col-lg-3 mb-4">
                <div class="card text-white bg-primary">
                    <div class="card-body">
                        <h5 class="card-title">Job Seekers</h5>
                        <p class="card-text">${seekerSize}</p>
                    </div>
                </div>
            </div>
            <div class="col-md-6 col-lg-3 mb-4">
                <div class="card text-white bg-success">
                    <div class="card-body">
                        <h5 class="card-title">Employers</h5>
                        <p class="card-text">${employe}</p>
                    </div>
                </div>
            </div>
            <div class="col-md-6 col-lg-3 mb-4">
                <div class="card text-white bg-warning">
                    <div class="card-body">
                        <h5 class="card-title">Jobs</h5>
                        <p class="card-text">${jobSize}</p>
                    </div>
                </div>
            </div>
            <div class="col-md-6 col-lg-3 mb-4">
                <div class="card text-white bg-danger">
                    <div class="card-body">
                        <h5 class="card-title">Applications</h5>
                        <p class="card-text">20</p>
                    </div>
                </div>
            </div>
        </div>

        <div class="row chart-container">
            <div class="col-lg-5 col-md-12 chart">
                <h5>USERS</h5>
                <canvas id="lineChart"></canvas>
            </div>
            <div class="col-lg-5 col-md-12 chart">
                <h5>Job Applications</h5>
                <canvas id="barChart"></canvas>
            </div>
        </div>
    </div>

<div id="logoutModal" class="modal fade center" tabindex="-1" aria-labelledby="logoutModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header" style="background-color:rgb(36, 43, 94)">
                <h5 class="modal-title" id="logoutModalLabel" style="color:white">Logout</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>Are you sure you want to logout?</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                <button type="button" id="confirmLogout" class="btn btn-primary" style="color:white">Logout</button>
            </div>
        </div>
    </div>
</div>

    <!-- Ensure Chart.js is loaded after jQuery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script src="../../assets/js/admin.js"></script>
    
    <script>
        $(document).ready(function() {
            // Data for Line Chart
            const lineData = {
                labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
                datasets: [{
                    label: 'Job Seekers',
                    data: [65, 59, 80, 81, 56, 55, 40],
                    backgroundColor: 'rgba(54, 162, 235, 0.2)',
                    borderColor: 'rgba(54, 162, 235, 1)',
                    borderWidth: 1,
                    fill: false
                },
                {
                    label: 'Employers',
                    data: [28, 48, 40, 19, 86, 27, 90],
                    backgroundColor: 'rgba(75, 192, 192, 0.2)',
                    borderColor: 'rgba(75, 192, 192, 1)',
                    borderWidth: 1,
                    fill: false
                },
                {
                    label: 'Applications',
                    data: [18, 48, 77, 9, 100, 27, 40],
                    backgroundColor: 'rgba(255, 206, 86, 0.2)',
                    borderColor:                    'rgba(255, 206, 86, 1)',
                    borderWidth: 1,
                    fill: false
                }]
            };

            // Config for Line Chart
            const lineConfig = {
                type: 'line',
                data: lineData,
                options: {
                    responsive: true,
                    scales: {
                        y: {
                            beginAtZero: true
                        }
                    },
                    plugins: {
                        legend: {
                            position: 'top',
                        },
                        tooltip: {
                            enabled: true,
                        }
                    }
                }
            };

            // Initialize Line Chart
            const lineCtx = document.getElementById('lineChart').getContext('2d');
            new Chart(lineCtx, lineConfig);

            // Data for Bar Chart
            const barData = {
                labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
                datasets: [{
                    label: 'Applications',
                    data: [12, 19, 3, 5, 2, 3, 7],
                    backgroundColor: 'rgba(255, 99, 132, 0.2)',
                    borderColor: 'rgba(255, 99, 132, 1)',
                    borderWidth: 1
                }]
            };

            // Config for Bar Chart
            const barConfig = {
                type: 'bar',
                data: barData,
                options: {
                    responsive: true,
                    scales: {
                        y: {
                            beginAtZero: true
                        }
                    },
                    plugins: {
                        legend: {
                            position: 'top',
                        },
                        tooltip: {
                            enabled: true,
                        }
                    }
                }
            };

            // Initialize Bar Chart
            const barCtx = document.getElementById('barChart').getContext('2d');
            new Chart(barCtx, barConfig);
            
            
        });
        
        $(document).ready(function () {
            $('#logout-link').click(function () {
                $('#logoutModal').modal('show');
            });

            $('#confirmLogout').click(function () {
                // Perform logout action here
            	window.location.href = "${pageContext.request.contextPath}/AdminLogout";
            });
        });
    </script>
</body>

</html>
