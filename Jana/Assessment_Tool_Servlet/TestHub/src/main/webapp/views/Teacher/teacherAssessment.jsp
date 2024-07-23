<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Assessment - Teacher View</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/Styles/course.css">
</head>

<body>
    <header>
        <h1>Teacher Assessments</h1>
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
                        <li class="breadcrumb-item"><a href="TestToHomeServlet">Home</a></li>
                        <li class="breadcrumb-item active" aria-current="page">Course</li>
                    </ol>
                </nav>
                
                <h2 class="text-center">${courseName}</h2>
                <div class="search-container">
                    <input type="text" placeholder="Search..." id="searchInput" onkeyup="filterCards()">
                    <button type="submit"><i class="material-symbols-outlined">search</i></button>
                </div>


                <div class="btn-group-toggle" data-toggle="buttons">
                    <label class="btn btn-danger active" id="showPending" onclick="filterStatus('pending')">
                        <input type="radio" name="options" autocomplete="off" checked> Pending
                    </label>
                    <label class="btn btn-success" id="showCompleted" onclick="filterStatus('completed')">
                        <input type="radio" name="options" autocomplete="off"> Completed
                    </label>
                </div>
                
                <!-- Button to trigger modal for adding new assessment -->
                <button class="btn btn-primary float-center" data-toggle="modal" data-target="#addAssessmentModal">
                    <i class="material-symbols-outlined">add</i> Add Assessment
                </button>
                
                <div class="row assessment-content" id="assessment-content">  
                    <c:forEach var="assessment" items="${assessments}">
                        <div class="col-md-6 col-lg-4">
                        <a href="${pageContext.request.contextPath}/DirectToEditServlet?aId=${assessment.aid}&aName=${fn:escapeXml(assessment.aName)}" style="text-decoration: none;">
                            <div class="course-card" data-status="${assessment.status}">
                                <div class="card-body">
                                    <h4>${assessment.aName}</h4>
                                    <p><i class="fas fa-calendar-alt"></i> Date: ${assessment.aDate}</p>
                                    <p><i class="fas fa-star"></i> Marks: ${assessment.tot_marks}</p>
                                    <p><i class="fas fa-redo-alt"></i> Attempts: 1</p>
                                    <div class="card-footer">
                                        <a href="${pageContext.request.contextPath}/EditAssessmentServlet?assessmentId=${assessment.aid}" class="btn btn-warning">
                                            <i class="fas fa-edit"></i> Edit
                                        </a>
                                        <a href="${pageContext.request.contextPath}/CompleteAssessmentServlet?assessmentId=${assessment.aid}" class="btn btn-success">
                                            <i class="fas fa-check"></i> Complete
                                        </a>
                                        <a href="${pageContext.request.contextPath}/ViewResultsServlet?assessmentId=${assessment.aid}" class="btn btn-info">
                                            <i class="fas fa-eye"></i> View Results
                                        </a>
                                    </div>
                                </div>
                            </div>
                            </a>
                        </div>
                    </c:forEach>
                    <!-- Repeat the above div for more course cards as needed -->
                </div>
            </div>
        </div>
    </div>

    <!-- Modal for adding new assessment -->
    <div class="modal fade" id="addAssessmentModal" tabindex="-1" role="dialog" aria-labelledby="addAssessmentModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="addAssessmentModalLabel">Add New Assessment</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form id="addAssessmentForm" action="${pageContext.request.contextPath}/AddAssessmentServlet" method="post">
    <div class="form-group">
        <label for="aName">Assessment Name</label>
        <input type="text" class="form-control" id="aName" name="aName" required>
        <span id="aName-error" class="error-message"></span>
    </div>
    <div class="form-group">
        <label for="stTime">Start Time</label>
        <input type="time" class="form-control" id="stTime" name="stTime" required>
        <span id="stTime-error" class="error-message"></span>
    </div>
    <div class="form-group">
        <label for="endTime">End Time</label>
        <input type="time" class="form-control" id="endTime" name="endTime" required>
        <span id="endTime-error" class="error-message"></span>
    </div>
    <div class="form-group">
        <label for="duration">Duration (minutes)</label>
        <input type="number" class="form-control" id="duration" name="duration" required>
        <span id="duration-error" class="error-message"></span>
    </div>
    <div class="form-group">
        <label for="totMarks">Total Marks</label>
        <input type="number" class="form-control" id="totMarks" name="totMarks" required>
        <span id="totMarks-error" class="error-message"></span>
    </div>
    <div class="form-group">
        <label for="cid">Course ID</label>
        <input type="number" class="form-control" id="cid" name="cid" value="${courseId}" readonly>
    </div>
    <div class="form-group">
        <label for="aDate">Assessment Date</label>
        <input type="date" class="form-control" id="aDate" name="aDate" required>
        <span id="aDate-error" class="error-message"></span>
    </div>
    <div class="form-group">
        <label for="eid">Examiner ID</label>
        <input type="number" class="form-control" id="eid" name="eid" value="${sessionScope.eid}" readonly>
    </div>
    <div class="form-group">
        <input type="hidden" id="courseName" name="courseName" value="${courseName}">
    </div>
    <button type="submit" class="btn btn-primary">Add Assessment</button>
</form>

                </div>
            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/Scripts/teacherAssessment.js"></script>
</body>

</html>
