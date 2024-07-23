<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <title>Assessment - Teacher View</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Asserts/Styles/teacherAssessment.css">
    <style>
        .filters {
            position: relative;
            display: flex;
            justify-content: space-around;
            margin-bottom: 20px;
        }

        .filters .btn {
            flex: 1;
            text-align: center;
            border-radius: 0;
        }

        .filters .slider {
            position: absolute;
            bottom: 0;
            left: 0;
            width: 33.33%;
            height: 4px;
            background-color: #007bff;
            transition: left 0.3s;
        }

        .filters .btn.active {
            font-weight: bold;
        }

        .filters .btn:not(.active) {
            opacity: 0.5;
        }

        .assessment-content {
            display: none;
            flex-wrap: wrap;
        }

        .assessment-content.active {
            display: flex;
        }

        .course-card {
            margin: 10px;
            flex: 1 1 calc(33.333% - 20px);
            box-sizing: border-box;
        }
    </style>
</head>

<body>
    <header>
        <h1>Assessment Hub</h1>
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
                        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/instructor/home">Home</a></li>
                        <li class="breadcrumb-item active" aria-current="page">Course</li>
                    </ol>
                </nav>
                <div class="container-fluid">
    <div class="row">
        <div class="col-lg-4">
            <h2>${courseName}</h2>
        </div>
        <div class="col-lg-4 text-center">
            <div class="search-container">
                <input type="text" placeholder="Search..." id="searchInput" onkeyup="filterCards()">
                <button type="submit"><i class="material-symbols-outlined">search</i></button>
            </div>
        </div>
        <div class="col-lg-4 text-right">
            <!-- Button to trigger modal for adding new assessment -->
            <button class="btn btn-success" data-toggle="modal" data-target="#addAssessmentModal">
                <i class="material-symbols-outlined">add</i> Add Assessment
            </button>
        </div>
    </div>
</div>


                <div class="btn-group-toggle filters" data-toggle="buttons">
                    <label class="btn btn-outline-primary active" id="filterNotYetStarted" onclick="filterAssessments('notYetStarted')">
                        <input type="radio" name="options" autocomplete="off" checked> Not Yet Published
                    </label>
                    <label class="btn btn-outline-primary" id="filterOngoing" onclick="filterAssessments('ongoing')">
                        <input type="radio" name="options" autocomplete="off"> Ongoing
                    </label>
                    <label class="btn btn-outline-primary" id="filterCompleted" onclick="filterAssessments('completed')">
                        <input type="radio" name="options" autocomplete="off"> Completed
                    </label>
                    <div class="slider" id="filterSlider"></div>
                </div>
                
               
                
                <!-- Sections for assessments -->
                <div id="notYetStarted" class="assessment-content active">
                    <c:forEach var="assessment" items="${assessments}">
                        <c:if test="${assessment.status == 'notyetstarted'}">
                        <a href="${pageContext.request.contextPath}/instructor/fetchQuestion?aid=${assessment.aid}&aname=${fn:escapeXml(assessment.aname)}" style="text-decoration: none;">
    <div class="course-card" data-status="not yet started">
        <div class="card-body">
            <h4>${assessment.aname}</h4>
            <p><i class="fas fa-calendar-alt"></i> Date: ${assessment.adate}</p>
            <p><i class="fas fa-star"></i> Marks: ${assessment.tot_mark}</p>
            <p><i class="fas fa-clock"></i> Start Time: ${assessment.sttime}</p>
            <p><i class="fas fa-clock"></i> End Time: ${assessment.endtime}</p>
            <p><i class="fas fa-hourglass-half"></i> Duration: ${assessment.duration} mins</p>
            </a>
            <div class="card-footer">
                <button class="btn btn-warning" onclick="openEditModal('${assessment.aid}', '${assessment.aname}', '${assessment.adate}', '${assessment.sttime}', '${assessment.endtime}', '${assessment.duration}', '${assessment.tot_mark}', '${assessment.cid}', '${assessment.eid}')">
                    <i class="fas fa-edit"></i> Edit
                </button>
                <button class="btn btn-danger" onclick="openDeleteModal('${assessment.aid}')">
                    <i class="fas fa-trash-alt"></i> Delete
                </button>
            </div>
        </div>
    </div>

                        </c:if>
                    </c:forEach>
                </div>

                <div id="completed" class="assessment-content">
                    <c:forEach var="assessment" items="${assessments}">
                        <c:if test="${assessment.status == 'completed'}">
                            <div class="course-card" data-status="completed">
                                <div class="card-body">
                                    <h4>${assessment.aname}</h4>
                                    <p><i class="fas fa-calendar-alt"></i> Date: ${assessment.adate}</p>
                                    <p><i class="fas fa-star"></i> Marks: ${assessment.tot_mark}</p>
                                    <p><i class="fas fa-clock"></i> Start Time: ${assessment.sttime}</p>
                                    <p><i class="fas fa-clock"></i> End Time: ${assessment.endtime}</p>
                                    <p><i class="fas fa-hourglass-half"></i> Duration: ${assessment.duration} mins</p>
                                    <div class="card-footer">
                                        <a href="${pageContext.request.contextPath}/instructor/fetchResults?assessmentId=${assessment.aid}&assessmentName=${assessment.aname}" class="btn btn-info">
                                            <i class="fas fa-eye"></i> View Results
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </c:if>
                    </c:forEach>
                </div>

                <div id="ongoing" class="assessment-content">
                    <c:forEach var="assessment" items="${assessments}">
                        <c:if test="${assessment.status == 'ongoing'}">
                            <div class="course-card" data-status="ongoing">
                                <div class="card-body">
                                    <h4>${assessment.aname}</h4>
                                    <p><i class="fas fa-calendar-alt"></i> Date: ${assessment.adate}</p>
                                    <p><i class="fas fa-star"></i> Marks: ${assessment.tot_mark}</p>
                                    <p><i class="fas fa-clock"></i> Start Time: ${assessment.sttime}</p>
                                    <p><i class="fas fa-clock"></i> End Time: ${assessment.endtime}</p>
                                    <p><i class="fas fa-hourglass-half"></i> Duration: ${assessment.duration} mins</p>
                                    <div class="card-footer">
                                        <a href="${pageContext.request.contextPath}/instructor/fetchResults?assessmentId=${assessment.aid}&assessmentName=${assessment.aname}" class="btn btn-info">
                                            <i class="fas fa-eye"></i> View Score
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </c:if>
                    </c:forEach>
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
                <form id="addAssessmentForm" action="${pageContext.request.contextPath}/instructor/addAssessment" method="post" onsubmit="return validateForm()">
                    <div class="form-group">
                        <label for="aName">Assessment Name</label>
                        <input type="text" class="form-control" id="aName" name="aName">
                        <span id="aNameError" class="text-danger"></span>
                    </div>
                    <div class="form-group">
                        <label for="aDate">Date</label>
                        <input type="date" class="form-control" id="aDate" name="aDate">
                        <span id="aDateError" class="text-danger"></span>
                    </div>
                    <div class="form-group">
                        <label for="startTime">Start Time</label>
                        <input type="time" class="form-control" id="startTime" name="startTime">
                        <span id="startTimeError" class="text-danger"></span>
                    </div>
                    <div class="form-group">
                        <label for="endTime">End Time</label>
                        <input type="time" class="form-control" id="endTime" name="endTime" >
                        <span id="endTimeError" class="text-danger"></span>
                    </div>
                    <div class="form-group">
                        <label for="duration">Duration (in minutes)</label>
                        <input type="number" class="form-control" id="duration" name="duration" >
                        <span id="durationError" class="text-danger"></span>
                    </div>
                    <div class="form-group">
                        <label for="totalMarks">Total Marks</label>
                        <input type="number" class="form-control" id="totalMarks" name="totalMarks">
                        <span id="totalMarksError" class="text-danger"></span>
                    </div>
                    <div class="form-group">
                        
                        <input type="hidden" class="form-control" id="cid" name="cid" value="${courseId}" readonly>
                        <span id="cidError" class="text-danger"></span>
                    </div>
                    <div class="form-group">
                        
                        <input type="hidden" class="form-control" id="eid" name="eid" value="${sessionScope.eid}" readonly>
                        <span id="eidError" class="text-danger"></span>
                    </div>
                    <button type="submit" class="btn btn-primary">Add Assessment</button>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- Edit Modal -->
<div class="modal fade" id="editAssessmentModal" tabindex="-1" role="dialog" aria-labelledby="editAssessmentModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="editAssessmentModalLabel">Edit Assessment</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id="editAssessmentForm" action="${pageContext.request.contextPath}/instructor/editAssessment" method="post" onsubmit="return validateEditForm()">
                    <input type="hidden" id="editAid" name="aid">
                    <div class="form-group">
                        <label for="editAName">Assessment Name</label>
                        <input type="text" class="form-control" id="editAName" name="aname">
                        <span id="editANameError" class="text-danger"></span>
                    </div>
                    <div class="form-group">
                        <label for="editADate">Date</label>
                        <input type="date" class="form-control" id="editADate" name="adate">
                        <span id="editADateError" class="text-danger"></span>
                    </div>
                    <div class="form-group">
                        <label for="editStartTime">Start Time</label>
                        <input type="time" class="form-control" id="editStartTime" name="sttime">
                        <span id="editStartTimeError" class="text-danger"></span>
                    </div>
                    <div class="form-group">
                        <label for="editEndTime">End Time</label>
                        <input type="time" class="form-control" id="editEndTime" name="endtime">
                        <span id="editEndTimeError" class="text-danger"></span>
                    </div>
                    <div class="form-group">
                        <label for="editDuration">Duration (in minutes)</label>
                        <input type="number" class="form-control" id="editDuration" name="duration">
                        <span id="editDurationError" class="text-danger"></span>
                    </div>
                    <div class="form-group">
                        <label for="editTotalMarks">Total Marks</label>
                        <input type="number" class="form-control" id="editTotalMarks" name="tot_mark">
                        <span id="editTotalMarksError" class="text-danger"></span>
                    </div>
                    <div class="form-group">
                      <!--    <label for="editCid">Course ID</label> -->
                        <input type="hidden" class="form-control" id="editCid" name="cid" readonly>
                        <span id="editCidError" class="text-danger"></span>
                    </div>
                    <div class="form-group">
                      <!--  <label for="editEid">Educator ID</label> -->
                        <input type="hidden" class="form-control" id="editEid" name="eid" readonly>
                        <span id="editEidError" class="text-danger"></span>
                    </div>
                    <button type="submit" class="btn btn-primary">Update Assessment</button>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- Delete Modal -->
<div class="modal fade" id="deleteAssessmentModal" tabindex="-1" role="dialog" aria-labelledby="deleteAssessmentModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="deleteAssessmentModalLabel">Delete Assessment</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>Are you sure? All the assessment related data will be deleted.</p>
                <form id="deleteAssessmentForm" action="${pageContext.request.contextPath}/instructor/deleteAssessment" method="post">
                    <input type="hidden" id="deleteAid" name="aid">
                    <button type="submit" class="btn btn-danger">Delete</button>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                </form>
            </div>
        </div>
    </div>
</div>

    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/Asserts/Scripts/teacherAssessment.js"></script>
</body>

</html>
