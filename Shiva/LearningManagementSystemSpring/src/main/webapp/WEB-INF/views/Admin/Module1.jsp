<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .dropdown-menu a {
            padding: 10px;
        }
        .vh-100 {
            height: 100vh;
        }
        .vertical-nav {
            width: 200px;
            height: 100%;
            position: fixed;
            top: 56px; /* height of the top navbar */
            left: 0;
            padding-top: 20px;
        }
        .main-content {
            margin-left: 220px; /* width of the vertical navbar + padding */
            padding-top: 20px;
        }
    </style>
    <link rel="stylesheet" href="Courses.css">
</head>
<body>
    <!-- Top Horizontal Navbar -->
    <nav class="navbar navbar-expand-lg navbar-light  fixed-top" style="background-color: #0092CA;">
        <a class="navbar-brand" href="#">
            <img src="asserts/images/site-logo.png" height="60px" width="70px" alt="Logo">
        </a>
         <h1><i>CHECKMATE</i></h1>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="languageDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Language
                    </a>
                    <div class="dropdown-menu" aria-labelledby="languageDropdown">
                        <a class="dropdown-item" href="#">English</a>
                        <a class="dropdown-item" href="#">Spanish</a>
                        <a class="dropdown-item" href="#">French</a>
                    </div>
                </li>
                <li class="nav-item pt-1 pl-3">
                    <div class="dropdown d-flex">
                        <a href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <img src="asserts/images/person.svg" class="rounded-circle pr-1" alt="Profile Image">
                        </a>
                        <h6 class="pt-1"><%= session.getAttribute("username") %></h6>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                            <a class="dropdown-item" href="logOut">Log Out</a>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </nav>

    <!-- Vertical Navigation Bar -->
    <div class="bg-dark text-light vh-100 vertical-nav" style="color: darkblue;">
        <div class="nav flex-column p-1">
           <!-- <a href="index.jsp" class="nav-item nav-link text-light pb-2 pt-5">Dashboard</a>-->
                    <a href="dash" class="nav-item nav-link text-light pb-2 pt-4">DashBoard</a>
                    <a href="redirectCourses" class="nav-item nav-link text-light pb-2 pt-4">Course Management</a>
                    <a href="users" class="nav-item nav-link text-light pb-2 pt-4">User Management</a>    
                   <!-- <a href="Profile.jsp" class="nav-item nav-link text-light pb-2 pt-4">Profile</a>-->
                    
        </div>
    </div>
    <div class="p-5">
        <main role="main" class="container mt-4 col-md-9 ml-sm-auto col-lg-10 pl-5 pt-3">
            <h1 class="header pt-4">Module -<%= session.getAttribute("coursename") %></h1>
            <nav aria-label="breadcrumb" class="pt-2">
	                    <ol class="breadcrumb">
	                      <li class="breadcrumb-item"><a href="redirectCourses">Courses</a></li>
	                      <li class="breadcrumb-item"><a href="#">Modules</a></li>
	                    </ol>
	                  </nav> 
            <img src="asserts/images/plus-circle.svg" height="50px" width="50px" alt="Edit" class="container-fluid float-right action-icon edit-icon pr-1" style="padding-left: 90%;" data-toggle="modal" data-target="#editModal"> 
            <div class="row d-flex flex-wrap align-items-stretch">

                <%@ page import="java.util.*,com.spring.model.Courses,com.spring.model.ModulesBean" %>
                <% ArrayList<ModulesBean> moduleList = (ArrayList<ModulesBean>) request.getAttribute("moduleList"); %>
                <% for (ModulesBean m : moduleList) { %>
                <div class="col-sm-4 p-3">
                    <div class="card shadow-sm p-3 d-flex" style="width:350px; display:flex">
                        <div class="card-body">
                            <img src="asserts/images/book-half (1).svg" height="50px" width="50px" class="p-1 mb-4 img-responsive card-img float-left" alt="Card Image 1">
                            <h5 class="text-center pb-1"><%= m.getModuleName() %></h5>
                            <div class="progress pb-1">
                                <div class="progress-bar" role="progressbar" style="width: 45%" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                            <div class="d-flex">
                                <a href="#" class="pr-2">
                                    <div class="d-flex">
                                        <img src="asserts/images/file-text.svg" class="pr-1">
                                        <p class="text pt-3">14 Assessments</p>
                                    </div>
                                </a>
                                <a href="#">
                                    <div class="d-flex">
                                        <img src="asserts/images/file-text.svg" class="pr-1">
                                        <p class="text pt-3">13 Assignments</p>
                                    </div>
                                </a>
                            </div>
                            <div class="d-flex pl-2 pb-3">
                                <a href="#" class="pr-2">
                                    <div class="d-flex">
                                        <img src="asserts/images/calendar-date.svg" class="pr-1">
                                        <p class="text pt-3"><%= ((List<Courses>)session.getAttribute("course")).get(0).getStartDate() %></p>
                                    </div>
                                </a>
                                <a href="#">
                                    <div class="d-flex pl-3">
                                        <img src="asserts/images/calendar-date.svg" class="pr-1">
                                        <p class="text pt-3"><%= ((List<Courses>)session.getAttribute("course")).get(0).getEndDate() %></p>
                                    </div>
                                </a>
                            </div>
                            <div class="d-flex pl-5" style="left:50%;rigth:50%">
                                <div class="pl-5"></div>
                                <a href="#" class="pr-1 edit-module" data-toggle="modal" data-module-name="<%= m.getModuleName() %>" data-module-id="<%= m.getModuleId() %>" data-target="#editNameModal"><img src="asserts/images/pencil-square.svg"></a>
                                <a href="#" class="pr-2 pl-2" data-toggle="modal" data-target="#uploadModal"><img src="asserts/images/upload.svg"></a>
                                <a href="#" ><img src="asserts/images/trash3-fill.svg" id="triggerModalBtn" data-toggle="modal" data-module-id="<%= m.getModuleId() %>" data-target="#confirmModal"></a>
                            </div>
                        </div>
                    </div>
                </div>
                <% } %>

            </div>
        </main>
    </div>
</div>
<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="editModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="editModalLabel">Add Modules</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id="editForm" action="addModule" >
                    <div class="form-group">
                    	<label for="courseID">Course Id</label>
                    	<input type="number" class="form-control" id="addcourseId" name="addcourseId" value="<%= session.getAttribute("courseId")%>" disabled>
                        <label for="editFirstName">Module Name</label>
                        <input type="text" class="form-control" id="editFirstName" name="moduleName" required>
                    </div>
                    <input type="hidden" id="editRowIndex">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="submit" class="btn btn-primary" form="editForm">Save changes</button>
                </form>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="editNameModal" tabindex="-1" role="dialog" aria-labelledby="editNameModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="editNameModalLabel">Edit Module</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id="editNameForm" action="AdminEditModule" >
                    <div class="form-group">
                        <label for="editModuleName">Module Name</label>
                        <input type="text" class="form-control" id="editModuleName" name="moduleName" required>
                    </div>
                    <input type="hidden" id="editModuleId" name="moduleId">
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="submit" class="btn btn-primary" form="editNameForm">Save changes</button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="confirmModal" tabindex="-1" role="dialog" aria-labelledby="confirmModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="confirmModalLabel">Delete Module</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Are you sure you want to delete this module?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                <a href="" type="button" class="btn btn-danger" id="confirmDeleteLink">Delete</a>
            </div>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<script>
    document.addEventListener('DOMContentLoaded', function() {
        document.querySelectorAll('.edit-module').forEach(button => {
            button.addEventListener('click', function() {
                const moduleName = this.getAttribute('data-module-name');
                const moduleId = this.getAttribute('data-module-id');
                document.getElementById('editModuleName').value = moduleName;
                document.getElementById('editModuleId').value = moduleId;
            });
        });
    });

    $('#confirmModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget);
        var moduleId = button.data('module-id');
        
        var modal = $(this);
        var deleteLink = modal.find('#confirmDeleteLink');
        
        deleteLink.attr('href', 'deleteModule?moduleId=' + moduleId);
    });

    $(document).on('click', '[data-target="#confirmModal"]', function () {
        $('#confirmModal').modal('show');
    });
</script>

</body>
</html>
