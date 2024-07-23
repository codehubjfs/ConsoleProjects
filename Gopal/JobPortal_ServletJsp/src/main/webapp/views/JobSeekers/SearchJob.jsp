<!DOCTYPE html>
<html lang="en">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My Profile</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <!-- Boxicons CSS for icons -->
    <link href="https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css" rel="stylesheet">
    <!-- Font Awesome for icons -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
    <link rel="stylesheet" href= "${pageContext.request.contextPath}/assets/css/seeker.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Custom CSS -->
    <style>
        /* Custom Styles */
        .status-active {
            color: green;
        }

        .status-inactive {
            color: red;
        }

        .modal.fade .modal-dialog {
            transition: transform 0.3s ease-out;
            transform: translate(0, -50px);
        }

        .modal.fade.show .modal-dialog {
            transform: translate(0, 0);
        }

        .bordered-container {
            padding: 1rem;
            border-radius: 5px;
            overflow-x: auto;
        }

        .pagination {
            margin-top: 20px;
        }

        .pagination .page-item .page-link {
            color: #101315;
        }

        .pagination .page-item.active .page-link {
            background-color: #007bff;
            border-color: #007bff;
        }

        .h4 {
            color: rgb(36, 43, 94);
        }

        .bordered-container {
            min-height: 600px;
            margin-bottom: 20px;
            display: flex;
            flex-direction: column;
            justify-content: space-between;
        }

        .table thead th {
            background-color: rgb(36, 43, 94);
            color: white;
        }

        .form-inline {
            padding: 10px;
        }

        .pagination {
            margin-top: 1px;
        }

        .header_info {
            display: flex;
            align-items: center;
        }

        .header_icons {
            display: flex;
            align-items: center;
            margin-left: 20px;
        }

        .header_icons i {
            font-size: 24px;
            color: white;
            margin-left: 15px;
            cursor: pointer;
        }

        .header_img {
            margin-right: 10px;
        }

        .admin_text {
            margin-right: 10px;
        }

        .container {
            padding-top: 20px;
        }

        /* Profile-specific styles */
        .profile-details {
            padding: 20px;
            background-color: #f9f9f9;
            border-radius: 10px;
            margin-bottom: 20px;
        }

        .profile-details h2 {
            color: #333;
            margin-bottom: 20px;
            border-bottom: 1px solid #ccc;
            padding-bottom: 10px;
        }

        .profile-details .profile-info {
            margin-bottom: 20px;
        }

        .profile-details .profile-info label {
            font-weight: bold;
        }

        .profile-details .profile-image {
            text-align: center;
        }

        .profile-details .profile-image img {
            width: 150px;
            height: 150px;
            border-radius: 50%;
            object-fit: cover;
            border: 4px solid #007bff;
        }

        .edit-mode .form-control {
            background-color: #fff;
            border: 1px solid #ccc;
            box-shadow: none;
        }

        #body-pd {
            background-color: rgb(241, 241, 241);
        }
       
       #title {
        margin-top: 100px;
       }
       .nav_link {
    text-decoration: none !important;
}
       
    </style>
    <style>
        /* Custom Styles */
        .status-active {
            color: green;
        }

        .status-inactive {
            color: red;
        }

        .modal.fade .modal-dialog {
            transition: transform 0.3s ease-out;
            transform: translate(0, -50px);
        }

        .modal.fade.show .modal-dialog {
            transform: translate(0, 0);
        }

        .bordered-container {
            padding: 1rem;
            border-radius: 5px;
            overflow-x: auto;
        }

        .pagination {
            margin-top: 20px;
        }

        .pagination .page-item .page-link {
            color: #101315;
        }

        .pagination .page-item.active .page-link {
            background-color: #007bff;
            border-color: #007bff;
        }

        .h4 {
            color: rgb(36, 43, 94);
        }

        .bordered-container {
            min-height: 600px;
            margin-bottom: 20px;
            display: flex;
            flex-direction: column;
            justify-content: space-between;
        }

        .table thead th {
            background-color: rgb(36, 43, 94);
            color: white;
        }

        .form-inline {
            padding: 10px;
        }

        .pagination {
            margin-top: 1px;
        }

        .header_info {
            display: flex;
            align-items: center;
        }

        .header_icons {
            display: flex;
            align-items: center;
            margin-left: 20px;
        }

        .header_icons i {
            font-size: 24px;
            color: white;
            margin-left: 15px;
            cursor: pointer;
        }

        .header_img {
            margin-right: 10px;
        }

        .admin_text {
            margin-right: 10px;
        }

        .container {
            padding-top: 20px;
        }

        /* Profile-specific styles */
        .profile-details {
            padding: 20px;
            background-color: #f9f9f9;
            border-radius: 10px;
            margin-bottom: 20px;
        }

        .profile-details h2 {
            color: #333;
            margin-bottom: 20px;
            border-bottom: 1px solid #ccc;
            padding-bottom: 10px;
        }

        .profile-details .profile-info {
            margin-bottom: 20px;
        }

        .profile-details .profile-info label {
            font-weight: bold;
        }

        .profile-details .profile-image {
            text-align: center;
        }

        .profile-details .profile-image img {
            width: 150px;
            height: 150px;
            border-radius: 50%;
            object-fit: cover;
            border: 4px solid #007bff;
        }

        .edit-mode .form-control {
            background-color: #fff;
            border: 1px solid #ccc;
            box-shadow: none;
        }

        #body-pd {
            background-color: rgb(241, 241, 241);
        }

        #title {
            margin-top: 100px;
        }

        /* Custom styles for search bar */
        .search-bar {
            display: flex;
            flex-wrap: wrap;
            justify-content:space-evenly;
            align-items: center;
            padding: 20px;
            background-color: #fff;
            /* border: 1px solid #ccc; */
            border-radius: 10px;
            margin-bottom: 20px;
        }

        .search-bar .form-group {
            margin: 10px;
        }

        .search-bar .form-control {
            height: 45px;
            font-size: 18px;
        }

        .search-bar .btn {
            height: 45px;
            font-size: 18px;
            padding: 0 20px;
        }

        .job-container {
            padding-top: 20px;
        }

        .nav_link {
            text-decoration: none !important;
        }

        @media (max-width: 768px) {
            .search-bar {
                flex-direction: column;
            }

            .job-card .card-body {
                flex-direction: column;
                text-align: center;
            }

            .job-card .card-body img {
                margin-bottom: 10px;
            }

            .job-card .card-body button {
                width: 100%;
                margin-top: 10px;
            }
        }
    </style>
</head>
<%
   if(session.getAttribute("seeker")==null){
	   
		request.getRequestDispatcher("/views/JobSeekers/seekerlogin.jsp").forward(request, response);
   }

%>
<body id="body-pd">
 
    <header class="header" id="header">
        <div class="header_toggle">
            <i class='bx bx-menu' id="header-toggle"></i>
        </div>
        <div class="header_info">
            <div class="header_img">
                <img src="/Admin - Copy/image/admin.png" alt="Profile Image">
            </div>
            <span class="admin_text">${seeker.name}</span>
            <div class="header_icons">
                <i class='bx bx-bell' id="notification-icon" title="Notifications"></i>
                <i class='bx bx-envelope' id="message-icon" title="Messages"></i>
               
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
                    <a href="/jobseeker/html/index copy.html" class="nav_link ">
                        <i class='fas fa-tachometer-alt nav_icon' title="Dashboard"></i>
                        <span class="nav_name">Dashboard</span>
                    </a>
                    <a href="${pageContext.request.contextPath}/JobSeekerProfileRetriveController" class="nav_link">
                        <i class='fas fa-id-badge nav_icon' title="My Profile"></i>
                        <span class="nav_name">My Profile</span>
                    </a>
                    <a href="${pageContext.request.contextPath}/SeekerProfileEditController" class="nav_link ">
                        <i class='fas fa-user-edit nav_icon' title="Edit Profile"></i>
                        <span class="nav_name">Edit Profile</span>
                    </a>
                    <a href="${pageContext.request.contextPath}/JobSearchController" class="nav_link active">
                        <i class='fas fa-search nav_icon' title="Job Search"></i>
                        <span class="nav_name">Job Search</span>
                    </a>
                    <a href="${pageContext.request.contextPath}/AppliedJobController" class="nav_link">
                        <i class='fas fa-briefcase nav_icon' title="Applied Jobs"></i>
                        <span class="nav_name">Applied Jobs</span>
                    </a>
                    <a href="${pageContext.request.contextPath}/SeekerPasswordView" class="nav_link">
                        <i class='fas fa-key nav_icon' title="Reset Password"></i>
                        <span class="nav_name">Reset Password</span>
                    </a>
                    <a href="#" class="nav_link" id="logout-link">
                        <i class='bx bx-log-out nav_icon'></i>
                        <span class="nav_name">LogOut</span>
                    </a>
                </div>
            </div>
        </nav>
    </div>

    <div id="title">
        <div class="container">
            <form class="search-bar form-inline justify-content" id="searchForm">
                <div class="form-group">
                    <input type="text" class="form-control input-lg" id="jobTitle" placeholder="Job Title">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control input-lg" id="location" placeholder="Location">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control input-lg" id="company" placeholder="Company">
                </div>
                <button type="submit" class="btn btn-primary btn-lg ">Search</button>
            </form>
        </div>
    </div>

    
    
    
<div class="container mt-3 job-container">
        <div class="row" id="jobCardsContainer">
            <!-- Job cards will be dynamically generated here -->
            <c:forEach var="job" items="${jobList}">
                <div class="col-10 mb-4">
                    <div class="card job-card">
                        <div class="row no-gutters align-items-center">
                            <div class="col-md-2 text-center">
                                <img src="${pageContext.request.contextPath}/assets/images/658378.gif" alt="Company Logo">
                            </div>
                            <div class="col-md-10">
                                <div class="card-body job-details">
                                    <h5 class="card-title"style="color: #28a745 !important">${job.jobTitle}</h5>
                                    <p class="card-text job-info">
                                        <i class="fas fa-briefcase job-icon"></i> ${job.jobTitle} | ${job.companyName}
                                    </p>
                                    
                                    
                                    <p class="card-text job-info">
                                        <i class="far fa-calendar-alt job-icon"></i> Posted Date: ${job.jobPosted} | Open Until: ${job.applicationDeadline}
                                    </p>
                                    <p class="card-location job-info">
                                        <i class="fas fa-money-bill-wave job-icon"></i> Salary | <i class="fas fa-map-marker-alt job-icon"></i> ${job.location} | <i class="fas fa-cogs job-icon"></i> ${job.jobType}
                                    </p>
                                    <!-- View Details Button -->
                                  
                                    <span class="applied-text">Applied Date : <span class="applied-date">Applied Date Here</span></span>
                                      <div class="d-flex justify-content-end">
                                    <button class="btn btn-primary btn-view-details mt-2" data-toggle="modal" data-target="#jobDetailsModal">View Details</button>
                                   <form action="${pageContext.request.contextPath}/SeekerApplyJob" method="post">
                                        <input type="hidden" name="job_id" value="${job.jobId}">
                                        <input type="hidden" name="seeker_id" value="${seeker.seeker_id}"> <!-- Replace with actual seeker ID -->
                                        <button type="submit" class="btn btn-success mt-2 ms-3">Apply</button>
                                    </form>
                                </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
    
    
    <!-- Bootstrap Modal -->
<!-- Success Modal -->
<div class="modal fade" id="successModal" tabindex="-1" aria-labelledby="successModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="successModalLabel">Application Submitted Successfully!</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Your application has been successfully submitted.
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

    
  <!-- Modal for Job Details -->
<div class="modal fade" id="jobDetailsModal" tabindex="-1" role="dialog" aria-labelledby="jobDetailsModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-top modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header" style="background-color: rgb(36, 43, 94);">
                <h5 class="modal-title" id="jobDetailsModalLabel" style="color: white;">Job Details</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <!-- Dynamic job details content -->
                <h5 class="card-title" id="modalJobTitle"></h5>
                <p class="card-text job-info" id="modalJobPosition">
                    <i class="fas fa-briefcase job-icon"></i> <span id="modalJobTitleEmployer"></span>
                </p>
                <p class="card-text job-info" id="modalPostedOpen">
                    <i class="far fa-calendar-alt job-icon"></i> Posted Date: <span id="modalJobPosted"></span> | Open Until: <span id="modalApplicationDeadline"></span>
                </p>
                <p class="card-text job-info" id="modalSalaryLocationType">
                    <i class="fas fa-money-bill-wave job-icon"></i> <span id="modalSalary"></span> | <i class="fas fa-map-marker-alt job-icon"></i> <span id="modalLocation"></span> | <i class="fas fa-cogs job-icon"></i> <span id="modalIndustry"></span>
                </p>
                <p class="card-text job-info" id="modalRequiredSkills">
                    <strong>Required Skills:</strong> <span id="modalRequiredSkillsText"></span>
                </p>
                <p class="card-text job-info" id="modalJobDescription">
                    <strong>Job Description:</strong> <span id="modalJobDescriptionText"></span>
                </p>
                <!-- Add more job details here as needed -->
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-bs-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

    

<script>
    $(document).ready(function () {
        $('.btn-view-details').click(function () {
            // Fetch job details from the clicked card
            var jobCard = $(this).closest('.card.job-card');
            var jobTitle = jobCard.find('.card-title').text().trim();
            var jobPosition = jobCard.find('.job-info:eq(0)').text().trim().replace(' | ', ' | ');
            var jobPosted = jobCard.find('.job-info:eq(1)').text().trim().replace('Posted Date:', '').split('|')[0].trim();
            var applicationDeadline = jobCard.find('.job-info:eq(1)').text().trim().replace('Open Until:', '').trim();
            var salaryLocationType = jobCard.find('.job-info:eq(2)').text().trim();
            var requiredSkills = jobCard.find('.job-info:eq(3)').text().trim().replace('Required Skills:', '').trim();
            var jobDescription = jobCard.find('.job-info:eq(4)').text().trim().replace('Job Description:', '').trim();

            // Populate modal with fetched job details
            $('#modalJobTitle').text(jobTitle);
            $('#modalJobTitleEmployer').text(jobPosition);
            $('#modalJobPosted').text(jobPosted);
            $('#modalApplicationDeadline').text(applicationDeadline);
            $('#modalSalary').text(salaryLocationType.split('|')[0].trim());
            $('#modalLocation').text(salaryLocationType.split('|')[1].trim());
            $('#modalIndustry').text(salaryLocationType.split('|')[2].trim());
            $('#modalRequiredSkillsText').text(requiredSkills);
            $('#modalJobDescriptionText').text(jobDescription);

            // Show the modal
            $('#jobDetailsModal').modal('show');
        });
    });
</script>

    <div id="logoutModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="logoutModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header" style="background-color:rgb(36, 43, 94)">
                    <h5 class="modal-title" id="logoutModalLabel" style="color:white">Logout</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close">
                    </button>
                </div>
                <div class="modal-body">
                    <p>Are you sure you want to logout?</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                    <button type="button" id="confirmLogout" class="btn btn-primary" style="color:white">Logout</button>
                </div>
            </div>
        </div>
    </div>
    <!-- Bootstrap JS and jQuery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.7/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz4fnFO9gybBogGzjI4IHcE5O5p+4ujCq4OzH2VpZNR9PZ73fJf9BCLvHY" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/5.3.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9B8J2eFFSUUUHRc/kbY5aaO7C4mQeGz64lVFN5hFHz8B35u94B7B4QK" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.7/dist/umd/popper.min.js" integrity="sha384-<updated-integrity-hash>" crossorigin="anonymous"></script>

    <script>
        $(document).ready(function () {
            $('#logout-link').click(function () {
                $('#logoutModal').modal('show');
            });

            $('#confirmLogout').click(function () {
                window.location.href = 'http://127.0.0.1:5501/html/index.html';
            });
        });

       
    </script>

<script>
$(document).ready(function() {
    $('#searchForm').submit(function(e) {
        e.preventDefault();
        performFilter();
    });

    function performFilter() {
        const jobTitle = $('#jobTitle').val().toLowerCase();
        const location = $('#location').val().toLowerCase();
        const company = $('#company').val().toLowerCase();

        // Select all job cards
        const jobCards = $('.job-card');

        // Loop through each job card to check filters
        jobCards.each(function() {
            const card = $(this);
            const cardTitle = card.find('.card-title').text().toLowerCase();
            const cardCompany = card.find('.card-text').first().text().toLowerCase();
            const cardLocation = card.find('.card-location').text().toLowerCase();

            // Determine if the card should be shown based on filter criteria
            const titleMatch = (jobTitle === '' || cardTitle.includes(jobTitle));
            const companyMatch = (company === '' || cardCompany.includes(company));
            const locationMatch = (location === '' || cardLocation.includes(location));

            // Show or hide based on filter criteria
            if (titleMatch && companyMatch && locationMatch) {
                card.show();
            } else {
                card.hide();
            }
        });

        // Show message if no jobs match the filters
        const noJobsMessage = $('#noJobsMessage');
        if (jobCards.filter(':visible').length === 0) {
            noJobsMessage.show();
        } else {
            noJobsMessage.hide();
        }
    }
});
</script>

   
    <!-- Include jQuery and Bootstrap JS (already included in your code) -->



    <script src="${pageContext.request.contextPath}/assets/js/jobseeker.js"></script>
</body>