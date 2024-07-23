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
    <link rel="stylesheet" href="/Admin new/css/style.css">
    <link rel="stylesheet" href="..\..\assets\css\adminprofile.css">
    <!-- Additional Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

    <style>
        /* Custom Styles */
        .status-active { color: green; }
        .status-inactive { color: red; }
        .modal.fade .modal-dialog { transition: transform 0.3s ease-out; transform: translate(0, -50px); }
        .modal.fade.show .modal-dialog { transform: translate(0, 0); }
        .bordered-container { padding: 1rem; border-radius: 5px; overflow-x: auto; }
        .pagination { margin-top: 20px; }
        .pagination .page-item .page-link { color: #101315; }
        .pagination .page-item.active .page-link { background-color: #007bff; border-color: #007bff; }
        .h4 { color: rgb(36, 43, 94); }
        .bordered-container { min-height: 600px; margin-bottom: 20px; display: flex; flex-direction: column; justify-content: space-between; }
        .table thead th { background-color: rgb(36, 43, 94); color: white; }
        .form-inline { padding: 10px; }
        .pagination { margin-top: 1px; }
        .header_info { display: flex; align-items: center; }
        .header_icons { display: flex; align-items: center; margin-left: 20px; }
        .header_icons i { font-size: 24px; color: white; margin-left: 15px; cursor: pointer; }
        .header_img { margin-right: 10px; }
        .admin_text { margin-right: 10px; }
    </style>
</head>

<body id="body-pd">
    <header class="header" id="header">
        <div class="header_toggle">
            <i class='bx bx-menu' id="header-toggle"></i>
        </div>
        <div class="header_info">
            <div class="header_img">
                <img src="${pageContext.request.contextPath}/assets/images/admin.png" alt="Profile Image">
            </div>
            <span class="admin_text">Admin</span>
            <div class="header_icons">
                <i class='bx bx-bell' id="notification-icon" title="Notifications"></i>
                <i class='bx bx-envelope' id="message-icon" title="Messages"></i>
                <i class='bx' id="logout-icon" title="Logout"></i>
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
                    <a href="#" class="nav_link active" id="dashboard-link">
                        <i class='bx bx-grid-alt nav_icon'></i>
                        <span class="nav_name">Dashboard</span>
                    </a>
                    <a href="#" class="nav_link" id="job-link">
                        <i class='fas fa-users nav_icon'></i>
                        <span class="nav_name">Job Seekers</span>
                    </a>
                    <a href="#" class="nav_link" id="seeker-link">
                        <i class='fas fa-user-tie nav_icon'></i>
                        <span class="nav_name">Employers</span>
                    </a>
                    <a href="#" class="nav_link" id="employer-link">
                        <i class='fas fa-briefcase nav_icon'></i>
                        <span class="nav_name">Jobs</span>
                    </a>
                    <a href="#" class="nav_link" id="profile-link">
                        <i class='bx bx-user nav_icon'></i>
                        <span class="nav_name">My Profile</span>
                    </a>
                    <a href="#" class="nav_link" id="logOut-link">
                        <i class='bx bx-log-out nav_icon'></i>
                        <span class="nav_name">Sign Out</span>
                    </a>
                </div>
            </div>
        </nav>
    </div>

    <div class="container" id="profile-content">
        <div class="container mt-5 offset-md-1rem bordered-container">
            <div class="admin-card text-center">
                <img src="https://img.icons8.com/bubbles/100/000000/user.png" alt="Admin Image">
                <h4 class="card-title"> Krishna</h4>
                <div class="card-info">
                    <i class="fas fa-envelope"></i>
                    <p class="card-text">admin@example.com</p>
                </div>
                <div class="card-info">
                    <i class="fas fa-user-tie"></i>
                    <p class="card-text">Role: Administrator</p>
                </div>
                <div class="card-info">
                    <i class="fas fa-phone"></i>
                    <p class="card-text">Phone: 9788336639</p>
                </div>
                <button class="btn btn-primary btn-block mb-2" id="editProfileBtn">Edit Profile</button>
                <button class="btn btn-secondary btn-block" id="registerAdminBtn">Create Admin</button>
            </div>
        </div>
    </div>

    <!-- Edit Profile Modal -->
    <div class="modal fade" id="editProfileModal" tabindex="-1" aria-labelledby="editProfileModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header" style="background-color:rgb(36, 43, 94)">
                    <h5 class="modal-title" id="editProfileModalLabel" style="color:white">Edit Profile</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form id="editProfileForm">
                        <div class="form-group">
                            <label for="adminIdInput">Admin_Id</label>
                            <input type="text" class="form-control" id="adminIdInput" value="Adm231" disabled>
                        </div>
                        <div class="form-group">
                            <label for="adminNameInput">Name</label>
                            <input type="text" class="form-control" id="adminNameInput" value="Krishna" required>
                            <div id="editNameError" class="error-message"></div>
                        </div>
                        <div class="form-group">
                            <label for="adminEmailInput">Email</label>
                            <input type="email" class="form-control" id="adminEmailInput" value="admin@example.com" required>
                            <div id="editEmailError" class="error-message"></div>
                        </div>
                        <div class="form-group">
                            <label for="adminPasswordInput">Password</label>
                            <input type="password" class="form-control" id="adminPasswordInput" required>
                            <div id="editPasswordError" class="error-message"></div>
                        </div>
                        <button type="submit" class="btn btn-primary">Save changes</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- Register Admin Modal -->
    <div class="modal fade" id="registerAdminModal" tabindex="-1" aria-labelledby="registerAdminModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header" style="background-color:rgb(36, 43, 94)">
                    <h5 class="modal-title" id="registerAdminModalLabel" style="color:white">Register Another Admin</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form id="registerAdminForm">
                        <div class="form-group">
                            <label for="newAdminName">Name</label>
                            <input type="text" class="form-control" id="newAdminName" required>
                            <div id="registerNameError" class="error-message"></div>
                        </div>
                        <div class="form-group">
                            <label for="newAdminEmail">Email</label>
                            <input type="email" class="form-control" id="newAdminEmail" required>
                            <div id="registerEmailError" class="error-message"></div>
                        </div>
                        <div class="form-group">
                            <label for="newAdminPassword">Password</label>
                            <input type="password" class="form-control" id="newAdminPassword" required>
                            <div id="registerPasswordError" class="error-message"></div>
                        </div>
                        <div class="form-group">
                            <label for="newAdminConfirmPassword">Confirm Password</label>
                            <input type="password" class="form-control" id="newAdminConfirmPassword" required>
                            <div id="registerConfirmPasswordError" class="error-message"></div>
                        </div>
                        <button type="submit" class="btn btn-primary">Register</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

<div id="logoutModal" class="modal"> <!-- Changed class to "modal" -->
            <div class="modal-dialog">
                <div class="modal-content">
                    <!-- <div class="modal-header" style="background-color:rgb(36, 43, 94)"> -->
                    <div class="modal-header" style="background-color:rgb(36, 43, 94)">
                        <h5 class="modal-title" style="color:white">Logout</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <p>Are you sure you want to logout?</p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                        <button type="button" id="confirmLogout" class="btn btn-primary"
                            style="color:white">Logout</button>
                    </div>
                </div>
            </div>
        </div>
    <!-- External JS libraries -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <!-- JavaScript -->
    <script>
        document.addEventListener("DOMContentLoaded", function() {
            const showNavbar = (toggleId, navId, bodyId, headerId) => {
                const toggle = document.getElementById(toggleId),
                    nav = document.getElementById(navId),
                    bodypd = document.getElementById(bodyId),
                    headerpd = document.getElementById(headerId);

                if (toggle && nav && bodypd && headerpd) {
                    toggle.addEventListener('click', () => {
                        nav.classList.toggle('show');
                        toggle.classList.toggle('bx-x');
                        bodypd.classList.toggle('body-pd');
                        headerpd.classList.toggle('body-pd');
                    });
                }
            };

            showNavbar('header-toggle', 'nav-bar', 'body-pd', 'header');

            const linkColor = document.querySelectorAll('.nav_link');

            function colorLink() {
                if (linkColor) {
                    linkColor.forEach(l => l.classList.remove('active'));
                    this.classList.add('active');
                }
            }
            linkColor.forEach(l => l.addEventListener('click', colorLink));
        });

        $(document).ready(function() {
            $('#editProfileBtn').on('click', function() {
                $('#editProfileModal').modal('show');
            });

            $('#registerAdminBtn').on('click', function() {
                $('#registerAdminModal').modal('show');
            });

            $('#editProfileForm').on('submit', function(e) {
                e.preventDefault();
                alert('Profile updated successfully!');
                $('#editProfileModal').modal('hide');
            });

            $('#registerAdminForm').on('submit', function(e) {
                e.preventDefault();
                const password = $('#newAdminPassword').val();
                const confirmPassword = $('#newAdminConfirmPassword').val();

                if (password !== confirmPassword) {
                    alert('Passwords do not match!');
                    return;
                }

                alert('New admin registered successfully!');
                $('#registerAdminModal').modal('hide');
            });
        });
    </script>
</body>

</html>
