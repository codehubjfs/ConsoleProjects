<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    <%
    HttpSession session1 = request.getSession(false); 
    if (session == null || session.getAttribute("email") == null) {
        response.sendRedirect(request.getContextPath() + "/views/Login/login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Assessment Hub</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/Styles/studentHomeStyle.css"> <!-- Ensure the path to your CSS file is correct -->
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
            <div><span class="material-symbols-outlined" id="home">home</span></div>
            <label for="home" id="nav-desc">Home</p>
            <div><span class="material-symbols-outlined" id="assessment">school</span></div>
            <label for="assessment" id="nav-desc">Assessments</p>
            <div><span class="material-symbols-outlined" id="LeaderBoard">assessment</span></div>
            <label for="LeaderBoard" id="nav-desc">LeaderBoard</p>
            <div><span class="material-symbols-outlined" id="logout">logout</span></div>
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
                    <span class="badge text-bg-primary rounded-pill">16</span>
                </div>
                <!-- Completed -->
                <div class="col-md-2 text-center">
                    <span class="material-symbols-outlined">check_circle</span>
                    <p>Completed</p>
                    <span class="badge text-bg-primary rounded-pill">5</span>
                </div>
                <!-- In Progress -->
                <div class="col-md-2 text-center">
                    <span class="material-symbols-outlined">hourglass_top</span>
                    <p>In Progress</p>
                    <span class="badge text-bg-primary rounded-pill">11</span>
                </div>
                <!-- Badges -->
                <div class="col-md-2 text-center">
                    <span class="material-symbols-outlined">military_tech</span>
                    <p>Badges</p>
                    <span class="badge text-bg-primary rounded-pill">56</span>
                </div>
                <!-- Super-Badges -->
                <div class="col-md-2 text-center">
                    <span class="material-symbols-outlined">star</span>
                    <p>Super-Badges</p>
                    <span class="badge text-bg-primary rounded-pill">7</span>
                </div>
            
        </div>
            <h2 class="text-center" id="hero">My Courses</h2>
            <div class="row">
                <c:forEach var="course" items="${courses}">
                    <div class="col-md-4">
                        <a href="${pageContext.request.contextPath}/AssessmentServlet?courseId=${course.courseId}&courseName=${fn:escapeXml(course.courseName)}" style="text-decoration: none;">
                            <div class="card course-card">
                                <img src="https://png.pngtree.com/background/20240112/original/pngtree-e-learning-in-a-digital-world-3d-books-and-mobile-devices-picture-image_7228456.jpg">
                                <div class="card-body">
                                <div class="row">
                                <h5 class="course-title text-center">${course.courseName}</h5>
                                </div>
                                <div class="row">
                                    <div class="col-6">
                                        <p class="card-title"><span class="material-symbols-outlined">event</span> Start Date</p>
                                        <p class="card-text"><span class="material-symbols-outlined">schedule</span>${course.startDate}</p>
                                    </div>
                                    <div class="col-6">
                                        <p class="card-title"><span class="material-symbols-outlined">event</span> End Date</p>
                                        <p class="card-text"><span class="material-symbols-outlined">schedule</span>${course.endDate}</p>
                                    </div>
                                   </div>
                                </div>
                            </div>
                        </a>
                    </div>
              </c:forEach>
                </div>
        </div>
                
                <!-- Repeat similar blocks for other courses -->
            </div>
        </div>
         <%--       </div>
            </div>
            </div>
        </div>
    </div> 
</div>--%> 

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="${pageContext.request.contextPath}/resources/Scripts/student.js"></script>
</body>
</html>