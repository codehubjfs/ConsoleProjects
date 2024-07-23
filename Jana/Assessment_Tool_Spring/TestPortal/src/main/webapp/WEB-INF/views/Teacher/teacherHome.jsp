<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    
   <%  HttpSession session1 = request.getSession(); 
    if (session == null || session.getAttribute("email") == null) {
        response.sendRedirect(request.getContextPath() + "/loginPage");
        return;
    } %>
 
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Teacher Portal</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Asserts/Styles/studentHomeStyle.css"> <!-- Ensure the path to your CSS file is correct -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
</head>
<body>

<header class="container-fluid" id="header">
   <h1>Assessment Hub</h1>
   
</header>

<div class="container-fluid">
    <div class="row">
        <!-- First Column: Navigation Icons -->
        
    <div class="col-1 text-center nav-icons" id="navigation">
        <div class="fixed nav">
            <div><span class="material-symbols-outlined" id="profile" data-toggle="modal" data-target="#profileModal">account_circle</span></div>
            <label for="profile" id="nav-desc">Profile</p>
            <div><span class="material-symbols-outlined" id="assessment">school</span></div>
            <label for="assessment" id="nav-desc">Assessments</p>
            <div><span class="material-symbols-outlined" id="LeaderBoard">assessment</span></div>
            <label for="LeaderBoard" id="nav-desc">LeaderBoard</p>
            <div><span class="material-symbols-outlined" id="logout" data-toggle="modal" data-target="#logoutModal">logout</span></div>
            <label for="logout" class="nav-desc">Logout</label>
        </div>
    </div>

        <!-- Second Column: Courses List -->
        <div class="col-11 offset-1">
            <div class="row mb-4" id="badgesContainer">
                <!-- Courses Enrolled -->
                <div class="col-md-2 text-center">
                    <span class="material-symbols-outlined">book</span>
                    <p>Courses Enrolled</p>
                    <span class="badge text-bg-primary">16</span>
                </div>
                <!-- Completed -->
                <div class="col-md-2 text-center">
                    <span class="material-symbols-outlined">check_circle</span>
                    <p>Completed</p>
                    <span class="badge text-bg-primary">5</span>
                </div>
                <!-- In Progress -->
                <div class="col-md-2 text-center">
                    <span class="material-symbols-outlined">hourglass_top</span>
                    <p>In Progress</p>
                    <span class="badge text-bg-primary">11</span>
                </div>
                <!-- Badges -->
                <div class="col-md-2 text-center">
                    <span class="material-symbols-outlined">military_tech</span>
                    <p>Badges</p>
                    <span class="badge text-bg-primary">56</span>
                </div>
                <!-- Super-Badges -->
                <div class="col-md-2 text-center">
                    <span class="material-symbols-outlined">star</span>
                    <p>Super-Badges</p>
                    <span class="badge text-bg-primary">7</span>
                </div>
            
        </div>
            <h2 class="text-center" id="hero">My Courses</h2>
            <div class="row">
                <c:forEach var="course" items="${courses}">
                    <div class="col-md-4">
                        <a href="${pageContext.request.contextPath}/instructor/assessments?courseId=${course.cid}&courseName=${fn:escapeXml(course.cname)}" style="text-decoration: none;">
                            <div class="card course-card">
                                <img src="https://png.pngtree.com/background/20240112/original/pngtree-e-learning-in-a-digital-world-3d-books-and-mobile-devices-picture-image_7228456.jpg">
                                <div class="card-body">
                                <div class="row">
                                <h5 class="course-title text-center">${course.cname}</h5>
                                </div>
                                <div class="row">
                                    <div class="col-6">
                                        <p class="card-title"><span class="material-symbols-outlined">event</span> Start Date</p>
                                        <p class="card-text"><span class="material-symbols-outlined">schedule</span>${course.start_date}</p>
                                    </div>
                                    <div class="col-6">
                                        <p class="card-title"><span class="material-symbols-outlined">event</span> End Date</p>
                                        <p class="card-text"><span class="material-symbols-outlined">schedule</span>${course.end_date}</p>
                                    </div>
                                   </div>
                                </div>
                            </div>
                        </a>
                    </div>
              </c:forEach>
                </div>
        </div>
                
                
            </div>
        </div>
        
          <!-- Profile Modal -->
<div class="modal fade" id="profileModal" tabindex="-1" role="dialog" aria-labelledby="profileModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="profileModalLabel">Profile</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="text-center mb-4">
                    <img src="https://static.vecteezy.com/system/resources/previews/005/836/460/non_2x/cute-male-teacher-funny-cartoon-illustration-free-vector.jpg" class="rounded-circle" alt="Profile Avatar" id="profile-img">
                </div>
                <form action="/instructor/updateTeacher" method="post">
                    <div class="form-group">
                        <label for="eid">Instructor ID</label>
                        <input type="text" class="form-control" id="eid" name="eid" value="${teacher.eid}" readonly>
                    </div>
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input type="email" class="form-control" id="email" name="email" value="${teacher.email}" readonly>
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type="password" class="form-control" id="password" name="password" value="${teacher.password} readonly">
                    </div>
                    <div class="form-group">
                        <label for="fname">First Name</label>
                        <input type="text" class="form-control" id="fname" name="fname" value="${teacher.fname}">
                    </div>
                    <div class="form-group">
                        <label for="lname">Last Name</label>
                        <input type="text" class="form-control" id="lname" name="lname" value="${teacher.lname}">
                    </div>
                    <div class="form-group">
                        <label for="gender">Gender</label>
                        <input type="text" class="form-control" id="gender" name="gender" value="${teacher.gender}">
                    </div>
                    <div class="form-group">
                        <label for="city">City</label>
                        <input type="text" class="form-control" id="city" name="city" value="${teacher.city}">
                    </div>
                    <div class="form-group">
                        <label for="country">Country</label>
                        <input type="text" class="form-control" id="country" name="country" value="${teacher.country}">
                    </div>
                    <button type="submit" class="btn btn-link" id="changePassword">Change Password</button>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>
        
        <!-- Logout Confirmation Modal -->
<div class="modal fade" id="logoutModal" tabindex="-1" aria-labelledby="logoutModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="logoutModalLabel">Confirm Logout</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Are you sure you want to logout?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                <button type="button" class="btn btn-danger" id="confirmLogout">Logout</button>
            </div>
        </div>
    </div>
</div>
         

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="${pageContext.request.contextPath}/Asserts/Scripts/student.js"></script>

</body>
</html>