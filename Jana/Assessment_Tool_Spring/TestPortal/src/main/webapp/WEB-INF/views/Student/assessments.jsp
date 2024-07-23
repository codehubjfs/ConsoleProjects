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
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Assessment</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Asserts/Styles/course.css">
</head>

<body>
    <header>
        <h1>Assessments</h1>
    </header>

    <div class="container-fluid">
        <div class="row">
            <!-- First Column: Navigation Icons -->
            <div class="col-1 text-center nav-icons" id="column1">
                <div><span class="material-symbols-outlined">home</span></div>
                <div><span class="material-symbols-outlined">school</span></div>
                <div><span class="material-symbols-outlined">assessment</span></div>
            </div>

            <!-- Second Column: Assessment Content -->
            <div class="col-11" id="course-name">
                <nav aria-label="breadcrumb">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/student/home">Home</a></li>
                        <li class="breadcrumb-item active" aria-current="page">Course</li>
                    </ol>
                </nav>

                <h2 class="text-center">${courseName}</h2>
                <div class="search-container">
                    <input type="text" placeholder="Search..." id="searchInput" onkeyup="filterCards()">
                    <button type="submit"><i class="material-symbols-outlined">search</i></button>
                </div>
                
                <div class="filter-container">
                    <div class="filter-option active" onclick="filterStatus('not yet started')">Not Yet Started</div>
                    <div class="filter-option inactive" onclick="filterStatus('started')">Started</div>
                    <div class="filter-option inactive" onclick="filterStatus('completed')">Completed</div>
                    <div class="filter-option inactive" onclick="filterStatus('missed')">Missed</div>
                    <div class="slider"></div>
                </div>

                <div class="row assessment-content" id="assessment-content">
                    <c:forEach var="assessment" items="${assessments}">
                        <div class="col-md-6 col-lg-4">
                            <div class="course-card" data-status="${assessment.status}">
                                <div class="card-body">
                                    <h4>${assessment.aname}</h4>
                                    <p><i class="fas fa-calendar-alt"></i> Date: ${assessment.adate}</p>
                                    <p><i class="fas fa-star"></i> Marks: ${assessment.tot_mark}</p>
                                    <p><i class="fas fa-redo-alt"></i> Attempts: 1</p>
                                    <p><i class="fas fa-clock"></i> Start Time: ${assessment.sttime}</p>
                                    <p><i class="fas fa-clock"></i> End Time: ${assessment.endtime}</p>
                                    <p><i class="fas fa-hourglass-half"></i> Duration: ${assessment.duration} mins</p>
                                    <c:if test="${assessment.status == 'not yet started'}">
                                        <span class="badge text-bg-primary">Not Yet Started</span>
                                    </c:if>
                                    <c:if test="${assessment.status == 'started'}">
                                        <a href="${pageContext.request.contextPath}/student/fetchQuestions?assessmentId=${assessment.aid}&duration=${assessment.duration}&AssessmentName=${assessment.aname}" class="btn btn-primary">Take Test</a>
                                        <span class="badge text-bg-success">Started</span>
                                    </c:if>
                                    <c:if test="${assessment.status == 'completed'}">
                                        <a href="${pageContext.request.contextPath}/student/AssessmentScore?assessmentId=${assessment.aid}&AssessmentName=${fn:escapeXml(assessment.aname)}" class="btn btn-danger">View Score</a>
                                    <!--      <span class="badge text-bg-dark">Completed</span> -->
                                    </c:if>
                                    <c:if test="${assessment.status == 'missed'}">
                                        <span class="badge text-bg-primary">Missed</span>
                                    </c:if>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/Asserts/Scripts/course.js"></script>
</body>

</html>
