<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, com.spring.model.Courses,com.spring.model.Instructor" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asserts/css/Courses.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/asserts/js/Courses.js"></script>
    <style>
    @charset "ISO-8859-1";
.dropdown-menu a{
    padding: 10px;
}
.vh-100 {
    height: 100vh;
}
.vertical-nav {
    width: 200px;
    height: 100%;
    position: fixed;
    top:85px; /* height of the top navbar */
    left: 0;
    padding-top: 20px;
   z-index: 9999;
}
.main-content {
    margin-left: 220px; /* width of the vertical navbar + padding */
    padding-top: 20px;
}
main {
    display: block; /* By default, main tag content is displayed as block */
}

/* Media query for screens smaller than a laptop */
@media (max-width: 1024px) {
    main {
        display: inline; /* Change display to inline for smaller screens */
        width: 100%; /* Ensure it takes full width of the viewport */
    }
}
#card
{
   
}
@media(max-width:1465px)
{
    #card
    {
        display: inline;
        height: 80%;
        width: 80%;
    }
}
    
    </style>
    <script>
    document.addEventListener('DOMContentLoaded', function() {
        const triggerModalBtn = document.getElementById('triggerModalBtn');
        const confirmModal = new bootstrap.Modal(document.getElementById('confirmModal'));
        const confirmBtn = document.getElementById('confirmBtn');

        triggerModalBtn.addEventListener('click', function() {
            confirmModal.show();
        });

        confirmBtn.addEventListener('click', function() {
            console.log("Confirmed!");
            confirmModal.hide();
        });
    });
    function validateFormCourseName()
        {
        let isusername=document.getElementById("courseName").value;
        if(/\d/.test(isusername))
        {
            const errmsg= document.getElementById("errcourseName");
            errmsg.innerText="Do not Enter number"
        }
        else
        {
             const errmsg= document.getElementById("errcourseName");
            errmsg.innerText=""
        }
        }
    function validateStartDate()
    {
        let startDate=document.getElementById("startDate").value;
        const inputDate=new Date(startDate);
        var today=new Date();
        today.setHours(0,0,0,0)
        if(inputDate<today)
        {
            const err= document.getElementById("startDateerr")
            err.innerText="Start Date should be greater than today"
        }
        else
        {
            const err= document.getElementById("startDateerr")
            err.innerText=""
        }
    }
    function validateEndDate()
    {
        let endDate=document.getElementById("endDate").value;
        const end=new Date(endDate);
        let startDate=document.getElementById("startDate").value;
        const start=new Date(startDate);
        if(start>end)
        {
            const err= document.getElementById("endDateerr")
            err.innerText="End Date should be greater than Start Date"
        }
        else
        {
            const err= document.getElementById("endDateerr")
            err.innerText=""
        }
    }
    </script>
</head>
<body>
    <!-- Top Horizontal Navbar -->
    <nav class="navbar navbar-expand-lg navbar-light fixed-top" style="background-color: #0092CA;">
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
                    <a class="nav-link dropdown-toggle" href="#" id="languageDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Language</a>
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
                            <a class="dropdown-item" href="logOut">LogOut</a>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </nav>

    <!-- Vertical Navigation Bar with Toggle Button -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation" id="sidebarToggle">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <div class="bg-dark text-light vh-100 vertical-nav">
                <div class="nav flex-column p-1">
                   <!-- <a href="index.jsp" class="nav-item nav-link text-light pb-2 pt-5">Dashboard</a>-->
                    <a href="dash" class="nav-item nav-link text-light pb-2 pt-4">DashBoard</a>
                    <a href="redirectCourses" class="nav-item nav-link text-light pb-2 pt-4">Course Management</a>
                    <a href="users" class="nav-item nav-link text-light pb-2 pt-4">User Management</a>    
                   <!-- <a href="Profile.jsp" class="nav-item nav-link text-light pb-2 pt-4">Profile</a>-->
                   
                </div>
            </div>
        </div>
    </nav>

    <div class="p-5">
        <main role="main" class="container mt-4 col-md-9 ml-sm-auto col-lg-10 pl-5 pt-3">
            <h1 class="header">Courses</h1>
            <img src="asserts/images/plus-circle.svg" height="50px" width="50px" alt="Add Course" class="container-fluid float-right action-icon edit-icon pr-1" style="padding-left: 90%;" data-toggle="modal" data-target="#editModal">
            <div class="row d-flex flex-wrap align-items-stretch">
                <% 
                    ArrayList<Courses> coursesList = (ArrayList<Courses>) request.getAttribute("coursesList");
                    for (Courses c : coursesList) { 
                %>
                <div class="col-sm-4 p-3">
                    <div id="card" class="card shadow-sm p-3 d-flex" style="width:350px; display:flex">
                        <div class="card-body">
                            <img src="asserts/images/book-half (1).svg" height="50px" width="50px" class="p-1 mb-4 img-responsive card-img float-left" alt="Card Image">
                            <h5 class="text-center pb-1"><%= c.getCoursename() %></h5>
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
                            <div class="d-flex pb-3">
                                <a href="#" class="pr-2">
                                    <div class="d-flex">
                                        <img src="asserts/images/calendar-date.svg" class="pr-1">
                                        <p class="text pt-3"><%= c.getStartDate() %></p>
                                    </div>
                                </a>
                                <a href="#">
                                    <div class="d-flex pl-3">
                                        <img src="asserts/images/calendar-date.svg" class="pr-1">
                                        <p class="text pt-3"><%= c.getEndDate() %></p>
                                    </div>
                                </a>
                            </div>
                            <div class="d-flex pr-1 pt-2">
                                <a href="AdminViewModules?courseId=<%= c.getCourseId() %>&cname=<%= c.getCoursename() %>&startDate=<%= c.getStartDate() %>&endDate=<%= c.getEndDate() %>&instructorId=<%= c.getInstructorId() %>" class="btn btn-primary">View Modules</a>
                                <div class="pr-5"></div>
                                <a href="#" class="pl-4" data-toggle="modal" data-target="#editNameModal" data-course-id="<%= c.getCourseId() %>" data-course-name="<%= c.getCoursename() %>" data-instructor-name="3" data-start-date="<%= c.getStartDate() %>" data-end-date="<%= c.getEndDate() %>"><img src="asserts/images/pencil-square.svg"></a>
                                <a href="#" class="pr-2 pl-2" data-toggle="modal" data-target="#uploadModal"><img src="asserts/images/upload.svg"></a>
                                <a href="#" class="pr-2" data-toggle="modal" data-target="#confirmModal" data-course-id="<%= c.getCourseId() %>">
                                    <img src="asserts/images/trash3-fill.svg">
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
                <% } %>
            </div>
        </main>
    </div>

    <!-- Modals -->
    <div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="editModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="editModalLabel">Add Courses</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form id="addCourseForm" action="addCourse" >
    <div class="form-group">
        <label for="courseName">Course Name</label>
        <input type="text" class="form-control" id="courseName" name="courseName" required>
        <div class="invalid-feedback">Course name must not contain numbers or special characters.</div>
    </div>
    <div class="form-group">
        <label for="instructorName">Instructor Name</label>
        <select class="form-select form-control" aria-label="Default select example" id="InstructorDropDown" name="instructorName" required>
            <% ArrayList<Instructor> instructorsList = (ArrayList<Instructor>) session.getAttribute("instructorList");
                for (Instructor i : instructorsList) { 
            %>
                <option value="<%= i.getInstructorid() %>"><%= i.getFirstname() + " " + i.getLastname() %></option>
            <% } %>
        </select>
        <div class="invalid-feedback">Please select an instructor.</div>
    </div>
    <div class="form-group">
        <label for="startDate">Start Date</label>
        <input type="date" class="form-control" id="startDate" name="startDate" required>
        <div class="invalid-feedback">Start date must be greater than today.</div>
    </div>
    <div class="form-group">
        <label for="endDate">End Date</label>
        <input type="date" class="form-control" id="endDate" name="endDate" required>
        <div class="invalid-feedback">End date must be greater than start date.</div>
    </div>
    <button type="submit" class="btn btn-primary">Add Course</button>
</form>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="editNameModal" tabindex="-1" role="dialog" aria-labelledby="editNameModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="editNameModalLabel">Edit Course</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form id="editCourseForm" action="editCourse" >
    <input type="hidden" id="editCourseId" name="courseId">
    <div class="form-group">
        <label for="editCourseName">Course Name</label>
        <input type="text" class="form-control" id="editCourseName" name="courseName" required>
        <div class="invalid-feedback">Course name must not contain numbers or special characters.</div>
    </div>
    <div class="form-group">
        <label for="editInstructorName">Instructor Name</label>
        <select class="form-select form-control" aria-label="Default select example" id="editInstructorDropDown" name="instructorName" required>
            <% ArrayList<Instructor> instructorList = (ArrayList<Instructor>) session.getAttribute("instructorList");
                for (Instructor i : instructorList) { 
            %>
                <option value="<%= i.getInstructorid() %>"><%= i.getFirstname() + " " + i.getLastname() %></option>
            <% } %>
        </select>
        <div class="invalid-feedback">Please select an instructor.</div>
    </div>
    <div class="form-group">
        <label for="editStartDate">Start Date</label>
        <input type="date" class="form-control" id="editStartDate" name="startDate" onchange="startDate()" required>
        <div class="invalid-feedback">Start date must be greater than today.</div>
    </div>
    <div class="form-group">
        <label for="editEndDate">End Date</label>
        <input type="date" class="form-control" id="editEndDate" name="endDate" required>
        <div class="invalid-feedback">End date must be greater than start date.</div>
    </div>
    <button type="submit" class="btn btn-primary">Save Changes</button>
</form>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="confirmModal" tabindex="-1" role="dialog" aria-labelledby="confirmModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="confirmModalLabel">Delete Course</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    Are you sure you want to delete this course?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-danger" id="confirmDeleteLink">Delete</a>
                </div>
            </div>
        </div>
    </div>

    <!-- JavaScript -->
    <script>
        // Toggle sidebar
        $('#sidebarToggle').on('click', function () {
            $('.vertical-nav').toggleClass('open');
        });

        // Show edit course modal and populate with course details
        $('#editNameModal').on('show.bs.modal', function (event) {
            var button = $(event.relatedTarget);
            var courseId = button.data('course-id');
            var courseName = button.data('course-name');
            var instructorName = button.data('instructor-name');
            var startDate = button.data('start-date');
            var endDate = button.data('end-date');

            var modal = $(this);
            modal.find('#editCourseId').val(courseId);
            modal.find('#editCourseName').val(courseName);
            modal.find('#editInstructorName').val(instructorName);
            modal.find('#editStartDate').val(startDate);
            modal.find('#editEndDate').val(endDate);
        });

        // Show delete course modal and set delete link href
        $('#confirmModal').on('show.bs.modal', function (event) {
            var button = $(event.relatedTarget);
            var courseId = button.data('course-id');
            
            var modal = $(this);
            var deleteLink = modal.find('#confirmDeleteLink');
            
            deleteLink.attr('href', 'deleteCourse?courseId=' + courseId);
        });

        // Show confirm delete modal
        $(document).on('click', '[data-target="#confirmModal"]', function () {
            $('#confirmModal').modal('show');
        });
        
        //form add course validation 
        document.addEventListener('DOMContentLoaded', function() {
        const addCourseForm = document.getElementById('addCourseForm');

        addCourseForm.addEventListener('submit', function(event) {
            let isValid = true;
            const courseName = document.getElementById('courseName');
            const instructorDropDown = document.getElementById('InstructorDropDown');
            const startDate = document.getElementById('startDate');
            const endDate = document.getElementById('endDate');

            // Course name validation pattern (letters and spaces only)
            const courseNamePattern = /^[A-Za-z\s]+$/;

            if (!courseNamePattern.test(courseName.value)) {
                courseName.classList.add('is-invalid');
                isValid = false;
            } else {
                courseName.classList.remove('is-invalid');
            }

            if (!instructorDropDown.value) {
                instructorDropDown.classList.add('is-invalid');
                isValid = false;
            } else {
                instructorDropDown.classList.remove('is-invalid');
            }

            const today = new Date().toISOString().split('T')[0];

            if (!startDate.value || startDate.value <= today) {
                startDate.classList.add('is-invalid');
                isValid = false;
            } else {
                startDate.classList.remove('is-invalid');
            }

            if (!endDate.value || endDate.value <= startDate.value) {
                endDate.classList.add('is-invalid');
                isValid = false;
            } else {
                endDate.classList.remove('is-invalid');
            }

            if (!isValid) {
                event.preventDefault();
            }
        });
    });
//edit course validation 
document.addEventListener('DOMContentLoaded', function() {
        const editCourseForm = document.getElementById('editCourseForm');

        editCourseForm.addEventListener('submit', function(event) {
            let isValid = true;
            const courseName = document.getElementById('editCourseName');
            const instructorDropDown = document.getElementById('editInstructorDropDown');
            const startDate = document.getElementById('editStartDate');
            const endDate = document.getElementById('editEndDate');

            // Course name validation pattern (letters and spaces only)
            const courseNamePattern = /^[A-Za-z\s]+$/;

            if (!courseNamePattern.test(courseName.value)) {
                courseName.classList.add('is-invalid');
                isValid = false;
            } else {
                courseName.classList.remove('is-invalid');
            }

            if (!instructorDropDown.value) {
                instructorDropDown.classList.add('is-invalid');
                isValid = false;
            } else {
                instructorDropDown.classList.remove('is-invalid');
            }

            const today = new Date().toISOString().split('T')[0];

            if (!startDate.value || startDate.value <= today) {
                startDate.classList.add('is-invalid');
                isValid = false;
            } else {
                startDate.classList.remove('is-invalid');
            }

            if (!endDate.value || endDate.value <= startDate.value) {
                endDate.classList.add('is-invalid');
                isValid = false;
            } else {
                endDate.classList.remove('is-invalid');
            }

            if (!isValid) {
                event.preventDefault();
            }
        });
        
        
        //start Date
        function startDate()
        {
        	const today = new Date().toISOString().split('T')[0];

            if (!startDate.value || startDate.value <= today) {
                startDate.classList.add('is-invalid');
                isValid = false;
                return true;
            } else {
                startDate.classList.remove('is-invalid');
            }
            return false;
        }
        //end Date
        function endDate()
        {
        	if (!endDate.value || endDate.value <= startDate.value) {
                endDate.classList.add('is-invalid');
                isValid = false;
                return true;
            } else {
                endDate.classList.remove('is-invalid');
            }
        	return false;
        }
    });
    </script>
</body>
</html>
