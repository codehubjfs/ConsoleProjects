<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored = "false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Portal</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/Styles/adminPortal.css">
</head>
<body>
    
    <header>
    <div class="container-fluid"></div>
        <h1>Admin Portal</h1>
    </div>
    </header>

    <div class="d-flex" id="wrapper">
        <div class="border-right" id="sidebar-wrapper">
            <!-- <div class="sidebar-heading">Admin Portal</div> -->
            <div class="list-group list-group-flush" id="menu-items">
                <a href="#" class="list-group-item list-group-item-action" onclick="showSection('student-management')">Student Management</a>
                <a href="#" class="list-group-item list-group-item-action" onclick="showSection('teacher-management')">Teacher Management</a>
                <a href="#" class="list-group-item list-group-item-action" onclick="showSection('course-management')">Course Management</a>
                <a href="#" class="list-group-item list-group-item-action" onclick="showSection('reportsmanagement')">Reports Management</a>
            </div>
        </div>
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <div id="student-management" class="content-section">
                    <h3>Student Management</h3>
                    <div class="row">
                        <div class="col">
                            <h4>Add Student</h4>
                            <!-- <div class="container"> -->
                            <button class="btn btn-success" id="toggleStudentFormButton" onclick="toggleStudentForm()">Add Student</button>
                                <form action="${pageContext.request.contextPath}/InsertStudentServlet" style="display: none;"  method="post" id="addStudentForm" >
                                <div class="form-row">
                                    <div class="col">
                                        <label for="email">Email<span style="color: red;">*</span></label>
                                        <input type="email" name="email" id="Semail" placeholder="Email" class="form-control">
                                        <span id="studentEmailError" class="text-danger"></span>
                                    </div>
                                    <div class="col">
                                        <label for="password">Password<span style="color: red;">*</span></label>
                                         <input type="password" id="Spassword" placeholder="Password" class="form-control" value="Welcome@123" disabled>
                                         <input type="hidden" name="password" value="Welcome@123">
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="col">
                                        <label for="fname">First Name<span style="color: red;">*</span></label>
                                        <input type="text" name="fname" id="Sfname" placeholder="First Name" class="form-control">
                                        <span id="studentFirstNameError" class="text-danger"></span>
                                    </div>
                                    <div class="col">
                                        <label for="lname">Last Name<span style="color: red;">*</span></label>
                                        <input type="text" name="lname" id="Slname" placeholder="Last Name" class="form-control">
                                        <span id="studentLastNameError" class="text-danger"></span>
                                    </div>
                                </div>
                                 <div class="form-row">
        <div class="form-group col-md-12">
            <label for="SGender">Gender<span style="color: red;">*</span></label>
    <select id="SGender" name="gender" class="form-control">
        <option value="">Select Gender</option>
        <option value="M">Male</option>
        <option value="F">Female</option>
        <option value="O">Other</option>
    </select>
    <span id="teacherGenderError" class="text-danger"></span>
        </div>
    </div>
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="city">City<span style="color: red;">*</span></label>
                                        <input type="text" name="city" id="Scity" placeholder="City" class="form-control">
                                        <span id="studentCityError" class="text-danger"></span>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="country">Country<span style="color: red;">*</span></label>
                                        <input type="text" name="country" id="Scountry" placeholder="Country" class="form-control">
                                        <span id="studentCountryError" class="text-danger"></span>
                                    </div>
                                </div>
                                <button type="button" class="btn btn-primary" id="addStudentButton" onclick="addStudent()">Add Student</button>
                            </form>
                            <!-- </div> -->
                           
                        </div>
                    </div>
<h4 class="mt-4">Student List</h4>
<table class="table table-bordered">
<thead>
<tr>
<th>Student ID</th>
<th>Email</th>
<th>First Name</th>
<th>Last Name</th>
<th>Gender</th>
<th>City</th>
<th>Country</th>
<th>Actions</th>
</tr>
</thead>
<tbody>
  <c:forEach var="student" items="${listStudent}">
                                <tr>
                                <td>${student.sid}</td>
                                    <td>${student.email}</td>
                                    <td>${student.fname}</td>
                                    <td>${student.lname}</td>
                                    <td>${student.gender}</td>
                                    <td>${student.city}</td>
                                    <td>${student.country}</td>
                                    <td><button class="btn btn-primary btn-sm" data-toggle="modal" onclick="editStudent(this)">Edit</button> <button class="btn btn-danger btn-sm" onclick="deleteStudent(this)">Delete</button></td>
                                </tr>
                            </c:forEach>
</tbody>
</table>


<div class="container-fluid mt-5">
    <h3>Course Allocation (Student)</h3>
    <form id="courseAllocationFormStudent" onsubmit="event.preventDefault(); allocateCourseStudent();">
        <div class="form-row align-items-end">
            <div class="form-group col-md-4">
                <label for="courseId">Course ID<span style="color: red;">*</span></label>
                <select id="courseId" class="form-control">
                    <option value="">Select Course</option>
                    <!-- Add course options here -->
                    <option value="course1">Course 1</option>
                    <option value="course2">Course 2</option>
                </select>
                <span id="courseIdError" class="text-danger"></span>
            </div>
            <div class="form-group col-md-4">
                <label for="studentId">Student ID<span style="color: red;">*</span></label>
                <select id="studentId" class="form-control">
                    <option value="">Select Student</option>
                    <!-- Add student options here -->
                    <option value="student1">Student 1</option>
                    <option value="student2">Student 2</option>
                </select>
                <span id="studentIdError" class="text-danger"></span>
            </div>
            <div class="form-group col-md-2">
                <button type="submit" class="btn btn-primary">Allocate</button>
            </div>
        </div>
    </form>
    
    <table class="table table-bordered mt-4">
        <thead>
            <tr>
                <th>Course ID</th>
                <th>Student ID</th>
            </tr>
        </thead>
        <tbody id="allocationTableBodyStudent">
            <!-- Added details will appear here -->
        </tbody>
    </table>
</div>
</div>
<div id="teacher-management" class="content-section" style="display:none;">
<h3>Teacher Management</h3>
<div class="row">
<div class="col">
<h4>Add Teacher</h4>
<button class="btn btn-success" id="toggleTeacherFormButton" onclick="toggleTeacherForm()">Add Teacher<i class="bi bi-person-add"></i></button>
<form id="addTeacherForm" style="display: none;" action="${pageContext.request.contextPath}/InsertTeacherServlet" method="post" onsubmit="event.preventDefault(); addTeacher();">
    <div class="form-row">
<div class="col">
    <label for="teacherEmail">Email<span style="color: red;">*</span></label>
    <input type="text" name="email" id="teacherEmail" placeholder="Email" class="form-control">
    <span id="teacherEmailError" class="text-danger"></span>
</div>
<div class="col">
    <label for="teacherPassword">Password<span style="color: red;">*</span></label>
    <input type="password" name="password" id="teacherPassword" placeholder="Password" class="form-control" value="Welcome@123" disabled>
    <span id="teacherPasswordError" class="text-danger"></span>
</div>
</div>
<div class="form-row">
<div class="col">
    <label for="teacherFirstName">First Name<span style="color: red;">*</span></label>
    <input type="text" name="fname" id="teacherFirstName" placeholder="First Name" class="form-control">
    <span id="teacherFirstNameError" class="text-danger"></span>
</div>
<div class="col">
    <label for="teacherLastName">Last Name<span style="color: red;">*</span></label>
    <input type="text" name="lname" id="teacherLastName" placeholder="Last Name" class="form-control">
    <span id="teacherLastNameError" class="text-danger"></span>
</div>
</div>
<div class="form-row">
<!-- <div class="col"> -->
    <div class="form-group col-md-6">
    <label for="teacherGender">Gender<span style="color: red;">*</span></label>
    <select id="teacherGender" name="gender" class="form-control">
        <option value="">Select Gender</option>
        <option value="M">Male</option>
        <option value="F">Female</option>
        <option value="O">Other</option>
    </select>
    <span id="teacherGenderError" class="text-danger"></span>
<!-- </div> -->
</div>
</div>
<div class="form-row">
<div class="form-group col-md-6">
    <label for="teacherCity">City<span style="color: red;">*</span></label>
    <input type="text" name="city" id="teacherCity" placeholder="City" class="form-control">
    <span id="teacherCityError" class="text-danger"></span>
</div>
<div class="form-group col-md-6">
    <label for="teacherCountry">Country<span style="color: red;">*</span></label>
    <input type="text" name="country" id="teacherCountry" placeholder="Country" class="form-control">
    <span id="teacherCountryError" class="text-danger"></span>
</div>
</div>
<button type="button" class="btn btn-primary" id="addTeacherButton" onclick="addTeacher()">Add Teacher</button>
</form>
</div>
</div>
<h4 class="mt-4">Teacher List</h4>
<table class="table table-bordered">
<thead>
<tr>
<th>Teacher ID</th>
<th>Email</th>
<th>First Name</th>
<th>Last Name</th>
<th>Gender</th>
<th>City</th>
<th>Country</th>
<th>Actions</th>
</tr>
</thead>
<tbody>
<c:forEach var="teacher" items="${listTeacher}">
                                <tr>
                                    <td>${teacher.eid}</td>
                                    <td>${teacher.email}</td>
                                    <td>${teacher.fname}</td>
                                    <td>${teacher.lname}</td>
                                    <td>${teacher.gender}</td>
                                    <td>${teacher.city}</td>
                                    <td>${teacher.country}</td>
                                    <td><button class="btn btn-primary btn-sm" onclick="editTeacher(this)">Edit</button> <button class="btn btn-danger btn-sm" onclick="deleteTeacher(this)">Delete</button></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                            </table>
<div class="container-fluid mt-5">
    <h3>Course Allocation (Teacher)</h3>
    <form id="courseAllocationFormTeacher" onsubmit="event.preventDefault(); allocateCourseTeacher();">
        <div class="form-row align-items-end">
            <div class="form-group col-md-4">
                <label for="teacherId">Teacher ID<span style="color: red;">*</span></label>
                <select id="teacherId" class="form-control" onchange="enableCourseSelection()">
                    <option value="">Select Teacher</option>
                    <c:forEach var="teacher" items="${teachers}">
                        <option value="${teacher.eId}">${teacher.fName}</option>
                    </c:forEach>
                </select>
                <span id="teacherIdError" class="text-danger"></span>
            </div>
            <div class="form-group col-md-4">
                <label for="courseId2">Course ID<span style="color: red;">*</span></label>
                <select id="courseId2" class="form-control" disabled>
                    <option value="">Select Course</option>
                </select>
                <span id="courseIdError1" class="text-danger"></span>
            </div>
            <div class="form-group col-md-2">
                <button type="submit" class="btn btn-primary">Allocate</button>
            </div>
        </div>
    </form>
    <table class="table table-bordered mt-4">
        <thead>
            <tr>
                <th>Teacher ID</th>
                <th>Course ID</th>
            </tr>
        </thead>
        <tbody id="allocationTableBodyTeacher">
            <!-- Added details will appear here -->
        </tbody>
    </table>
</div>
</div>
<div id="course-management" class="content-section" style="display:none;">
<h3>Course Management</h3>
<div class="row">
<div class="col-md-6">
<h4>Add Course</h4>
<form id="addCourseForm" onsubmit="event.preventDefault(); addCourse();">
<div class="form-group">
    <input type="text" id="courseName" placeholder="Course Name" class="form-control" required>
</div>
<div class="form-group">
    <textarea id="courseDescription" placeholder="Course Description" class="form-control" required></textarea>
</div>
<button type="submit" class="btn btn-primary">Add Course</button>
</form>
</div>
</div>
<h4 class="mt-4">Course List</h4>
<table class="table table-bordered">
<thead>
<tr>
<th>Course Name</th>
<th>Course Description</th>
<th>Actions</th>
</tr>
</thead>
<tbody id="courseList">
<!-- Course list will be populated here -->
</tbody>
</table>
</div>
<div id="reportsmanagement" class="content-section" style="display:none;">
    <h3>Reports Management</h3>
    <div class="row">
        <div class="col-md-12">
            <h4>Reports</h4>
            <div>
                <canvas id="studentsInCoursesChart" width="400" height="200"></canvas>
            </div>
            <div>
                <canvas id="studentPerformanceChart" width="400" height="200"></canvas>
            </div>
            <div>
                <canvas id="assessmentsInCoursesChart" width="400" height="200"></canvas>
            </div>
        </div>
    </div>
</div>

 <!-- Delete Confirmation Modal -->
<div class="modal fade" id="deleteConfirmationModal" tabindex="-1" role="dialog" aria-labelledby="deleteConfirmationModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="deleteConfirmationModalLabel">Confirm Delete</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Are you sure you want to delete ID: <span id="studentIdDisplay"></span>?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                <button type="button" class="btn btn-danger" id="confirmDeleteButton">Delete</button>
            </div>
        </div>
    </div>
</div>

<!-- Student Modal -->
<div class="modal fade" id="studentModal" tabindex="-1" role="dialog" aria-labelledby="studentModalLabel" aria-hidden="true">
<div class="modal-dialog" role="document">
<div class="modal-content">
<div class="modal-header">
<h5 class="modal-title" id="studentModalLabel">Edit Student</h5>
<button type="button" class="close" data-dismiss="modal" aria-label="Close">
<span aria-hidden="true">&times;</span>
</button>
</div>
<div class="modal-body">
<form id="editStudentForm" action= "${pageContext.request.contextPath}/EditStudentServlet" method="post">
<div class="form-group">
<label for="editStudentId">Student ID</label>
<input type="number" class="form-control" id="editStudentId" name="sid" required>
</div>
<div class="form-group">
<label for="editStudentEmail">Email</label>
<input type="email" class="form-control" id="editStudentEmail" name="email" required>
</div>
<div class="form-group">
<label for="editStudentFirstName">First Name</label>
<input type="text" class="form-control" id="editStudentFirstName" name="fname" required>
</div>
<div class="form-group">
<label for="editStudentLastName">Last Name</label>
<input type="text" class="form-control" id="editStudentLastName" name="lname" required>
</div>
<div class="form-group">
<label for="editStudentGender">Gender</label>
<select class="form-control" id="editStudentGender" name="gender" required>
<option value="M">Male</option>
<option value="F">Female</option>
<option value="O">Other</option>
</select>
</div>
<div class="form-group">
<label for="editStudentCity">City</label>
<input type="text" class="form-control" id="editStudentCity" name="city" required>
</div>
<div class="form-group">
<label for="editStudentCountry">Country</label>
<input type="text" class="form-control" id="editStudentCountry" name="country" required>
</div>
<button type="submit" class="btn btn-primary">Save changes</button>
</form>
</div>
</div>
</div>
</div>
<!-- Teacher Modal -->
<div class="modal fade" id="teacherModal" tabindex="-1" role="dialog" aria-labelledby="teacherModalLabel" aria-hidden="true">
<div class="modal-dialog" role="document">
<div class="modal-content">
<div class="modal-header">
<h5 class="modal-title" id="teacherModalLabel">Edit Teacher</h5>
<button type="button" class="close" data-dismiss="modal" aria-label="Close">
<span aria-hidden="true">&times;</span>
</button>
</div>
<div class="modal-body">
<form id="editTeacherForm" action= "${pageContext.request.contextPath}/EditTeacherServlet" method="post">
<div class="form-group">
<label for="editTeacherId">Teacher ID</label>
<input type="number" class="form-control" id="editTeacherId" name="eid" required>
</div>
<div class="form-group">
<label for="editTeacherEmail">Email</label>
<input type="email" class="form-control" id="editTeacherEmail" name = "email" required>
</div>
<div class="form-group">
<label for="editTeacherFirstName">First Name</label>
<input type="text" class="form-control" id="editTeacherFirstName" name = "fname" required>
</div>
<div class="form-group">
<label for="editTeacherLastName">Last Name</label>
<input type="text" class="form-control" id="editTeacherLastName" name = "lname" required>
</div>
<div class="form-group">
<label for="editTeacherGender">Gender</label>
<select class="form-control" id="editTeacherGender" name = "gender" required>
<option value="M">Male</option>
<option value="F">Female</option>
<option value="O">Other</option>
</select>
</div>
<div class="form-group">
<label for="editTeacherCity">City</label>
<input type="text" class="form-control" id="editTeacherCity" name = "city" required>
</div>
<div class="form-group">
<label for="editTeacherCountry">Country</label>
<input type="text" class="form-control" id="editTeacherCountry" name = "country" required>
</div>
<button type="submit" class="btn btn-primary">Save changes</button>
</form>
</div>
</div>
</div>
</div>

<!-- Course Modal -->
<div class="modal fade" id="courseModal" tabindex="-1" role="dialog" aria-labelledby="courseModalLabel" aria-hidden="true">
<div class="modal-dialog" role="document">
<div class="modal-content">
<div class="modal-header">
<h5 class="modal-title" id="courseModalLabel">Edit Course</h5>
<button type="button" class="close" data-dismiss="modal" aria-label="Close">
<span aria-hidden="true">&times;</span>
</button>
</div>
<div class="modal-body">
<form id="editCourseForm">
<input type="hidden" id="editCourseId">
<div class="form-group">
<label for="editCourseName">Course Name</label>
<input type="text" class="form-control" id="editCourseName" required>
</div>
<div class="form-group">
<label for="editCourseDescription">Course Description</label>
<textarea class="form-control" id="editCourseDescription" required></textarea>
</div>
<button type="button" class="btn btn-primary" onclick="saveCourseChanges()">Save changes</button>
</form>
</div>
</div>
</div>
</div>
</div>
</div>


<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="${pageContext.request.contextPath}/resources/Scripts/adminPortal.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</body>
</html>
