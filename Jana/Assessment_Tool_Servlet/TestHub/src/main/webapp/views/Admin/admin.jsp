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
                                <form action="${pageContext.request.contextPath}/InsertStudentServlet" method="post" id="addStudentForm">
                                <div class="form-row">
                                    <div class="col">
                                        <label for="email">Email<span style="color: red;">*</span></label>
                                        <input type="email" name="email" id="email" placeholder="Email" class="form-control">
                                        <span id="studentEmailError" class="text-danger"></span>
                                    </div>
                                    <div class="col">
                                        <label for="password">Password<span style="color: red;">*</span></label>
                                         <input type="password" id="password" placeholder="Password" class="form-control" value="Welcome@123" disabled>
                                         <input type="hidden" name="password" value="Welcome@123">
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="col">
                                        <label for="fname">First Name<span style="color: red;">*</span></label>
                                        <input type="text" name="fname" id="fname" placeholder="First Name" class="form-control">
                                    </div>
                                    <div class="col">
                                        <label for="lname">Last Name<span style="color: red;">*</span></label>
                                        <input type="text" name="lname" id="lname" placeholder="Last Name" class="form-control">
                                    </div>
                                </div>
                                 <div class="form-row">
        <div class="form-group col-md-12">
            <label for="gender">Gender<span style="color: red;">*</span></label><br>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="gender" id="male" value="M">
                <label class="form-check-label" for="male">Male</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="gender" id="female" value="F">
                <label class="form-check-label" for="female">Female</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="gender" id="other" value="O">
                <label class="form-check-label" for="other">Other</label>
            </div>
        </div>
    </div>
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="city">City<span style="color: red;">*</span></label>
                                        <input type="text" name="city" id="city" placeholder="City" class="form-control">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="country">Country<span style="color: red;">*</span></label>
                                        <input type="text" name="country" id="country" placeholder="Country" class="form-control">
                                    </div>
                                </div>
                                <button type="submit" class="btn btn-primary" id="addButton">Add Student</button>
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
                                    <td><button class="btn btn-primary btn-sm" onclick="editStudent(this)">Edit</button> <button class="btn btn-danger btn-sm" onclick="deleteStudent(this)">Delete</button></td>
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
<form id="addTeacherForm" onsubmit="event.preventDefault(); addTeacher();">
    <div class="form-row">
<div class="col">
    <label for="teacherEmail">Email<span style="color: red;">*</span></label>
    <input type="text" id="teacherEmail" placeholder="Email" class="form-control">
    <span id="teacherEmailError" class="text-danger"></span>
</div>
<div class="col">
    <label for="teacherPassword">Password<span style="color: red;">*</span></label>
    <input type="password" id="teacherPassword" placeholder="Password" class="form-control" value="Welcome@123" disabled>
    <span id="teacherPasswordError" class="text-danger"></span>
</div>
</div>
<div class="form-row">
<div class="col">
    <label for="teacherFirstName">First Name<span style="color: red;">*</span></label>
    <input type="text" id="teacherFirstName" placeholder="First Name" class="form-control">
    <span id="teacherFirstNameError" class="text-danger"></span>
</div>
<div class="col">
    <label for="teacherLastName">Last Name<span style="color: red;">*</span></label>
    <input type="text" id="teacherLastName" placeholder="Last Name" class="form-control">
    <span id="teacherLastNameError" class="text-danger"></span>
</div>
</div>
<div class="form-row">
<!-- <div class="col"> -->
    <div class="form-group col-md-6">
    <label for="teacherGender">Gender<span style="color: red;">*</span></label>
    <select id="teacherGender" class="form-control">
        <option value="">Select Gender</option>
        <option value="Male">Male</option>
        <option value="Female">Female</option>
        <option value="Other">Other</option>
    </select>
    <span id="teacherGenderError" class="text-danger"></span>
<!-- </div> -->
</div>
</div>
<div class="form-row">
<div class="form-group col-md-6">
    <label for="teacherCity">City<span style="color: red;">*</span></label>
    <input type="text" id="teacherCity" placeholder="City" class="form-control">
    <span id="teacherCityError" class="text-danger"></span>
</div>
<div class="form-group col-md-6">
    <label for="teacherCountry">Country<span style="color: red;">*</span></label>
    <input type="text" id="teacherCountry" placeholder="Country" class="form-control">
    <span id="teacherCountryError" class="text-danger"></span>
</div>
</div>
<button type="submit" class="btn btn-primary" id="addButton">Add Teacher</button>
</form>
</div>
</div>
<h4 class="mt-4">Teacher List</h4>
<table class="table table-bordered">
<thead>
<tr>
<th>Email</th>
<th>First Name</th>
<th>Last Name</th>
<th>Gender</th>
<th>City</th>
<th>Country</th>
<th>Actions</th>
</tr>
</thead>
<tbody id="teacherList">
<!-- Teacher list will be populated here -->
</tbody>
</table>
<div class="container-fluid mt-5">
    <h3>Course Allocation (Teacher)</h3>
    <form id="courseAllocationFormTeacher" onsubmit="event.preventDefault(); allocateCourseTeacher();">
        <div class="form-row align-items-end">
            <div class="form-group col-md-4">
                <label for="courseId2">Course ID<span style="color: red;">*</span></label>
                <select id="courseId2" class="form-control">
                    <option value="">Select Course</option>
                    <!-- Add course options here -->
                    <option value="course1">Course 1</option>
                    <option value="course2">Course 2</option>
                </select>
                <span id="courseIdError1" class="text-danger"></span>
            </div>
            <div class="form-group col-md-4">
                <label for="teacherId">Teacher ID<span style="color: red;">*</span></label>
                <select id="teacherId" class="form-control">
                    <option value="">Select Teacher</option>
                    <!-- Add teacher options here -->
                    <option value="teacher1">Teacher 1</option>
                    <option value="teacher2">Teacher 2</option>
                </select>
                <span id="teacherIdError" class="text-danger"></span>
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
                <th>Teacher ID</th>
            </tr>
        </thead>
        <tbody id="allocationTableBodyTeacher">
            <!-- Added details will appear here -->
        </tbody>
    </table>
</div>
</div>
<!-- </div> -->
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
                Are you sure you want to delete this student?
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
<form id="editTeacherForm">
<input type="hidden" id="editTeacherId">
<div class="form-group">
<label for="editTeacherEmail">Email</label>
<input type="email" class="form-control" id="editTeacherEmail" required>
</div>
<div class="form-group">
<label for="editTeacherFirstName">First Name</label>
<input type="text" class="form-control" id="editTeacherFirstName" required>
</div>
<div class="form-group">
<label for="editTeacherLastName">Last Name</label>
<input type="text" class="form-control" id="editTeacherLastName" required>
</div>
<div class="form-group">
<label for="editTeacherGender">Gender</label>
<select class="form-control" id="editTeacherGender" required>
<option value="Male">Male</option>
<option value="Female">Female</option>
<option value="Other">Other</option>
</select>
</div>
<div class="form-group">
<label for="editTeacherCity">City</label>
<input type="text" class="form-control" id="editTeacherCity" required>
</div>
<div class="form-group">
<label for="editTeacherCountry">Country</label>
<input type="text" class="form-control" id="editTeacherCountry" required>
</div>
<button type="button" class="btn btn-primary" onclick="saveTeacherChanges()">Save changes</button>
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


<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="${pageContext.request.contextPath}/resources/Scripts/adminPortal.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</body>
</html>
