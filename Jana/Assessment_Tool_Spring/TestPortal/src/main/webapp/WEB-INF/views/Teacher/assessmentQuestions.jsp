<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
    <title>Manage Assessment Questions</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" />
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" crossorigin="anonymous" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Asserts/Styles/addQuestion.css">
</head>
<body>
<header><h1>Assessment Hub</h1></header>
<div class="container-fluid">
    <div class="row">
        <!-- First Column: Navigation Icons -->
        <div class="col-1 text-center nav-icons d-flex flex-column align-items-center" id="column1">
            <div><span class="material-symbols-outlined">home</span></div>
            <div><span class="material-symbols-outlined">school</span></div>
            <div><span class="material-symbols-outlined">assessment</span></div>
        </div>

        <!-- Second Column: Assessment Content -->
        <div class="col-11 d-flex justify-content-center" id="course-name">
            <div class="container">
                <nav aria-label="breadcrumb">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/instructor/home">Home</a></li>
                        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/instructor/assessments?courseId=${sessionScope.courseId}&courseName=${sessionScope.courseName}">Assessments</a></li>
                        <li class="breadcrumb-item active" aria-current="page">Manage Question</li>
                    </ol>
                </nav>

                <h2>Manage Questions for Assessment: ${aid} - ${aname}</h2>

                <!-- Buttons to select between existing or new questions -->
                <div class="mb-3">
                    <button id="showExistingQuestions" class="btn btn-primary">Add Existing Questions</button>
                    <button id="showNewQuestionModal" class="btn btn-secondary" data-toggle="modal" data-target="#newQuestionModal">Add New Question</button>
                </div>

                <!-- Table for existing questions -->
                <div id="existingQuestions" style="display: none;">
                    <h4>Existing Questions</h4>
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Question ID</th>
                                <th>Question Text</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="question" items="${questions}">
                                <tr>
                                    <td>${question.qid}</td>
                                    <td>${question.questions}</td>
                                    <td>
                                        <form action="${pageContext.request.contextPath}/instructor/assignQuestion">
                                            <input type="hidden" name="qid" value="${question.qid}" />
                                            <input type="hidden" name="aid" value="${aid}" />
                                            <button type="submit" class="btn btn-success">Add</button>
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>

                <!-- List of questions added to the assessment -->
                <h4>Assessment Questions</h4>
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Question ID</th>
                            <th>Question Text</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="assessmentQuestion" items="${assessmentQuestions}">
                            <tr>
                                <td>${assessmentQuestion.qid}</td>
                                <td>${assessmentQuestion.questions}</td>
                                <td>
    <a href="${pageContext.request.contextPath}/EditQuestionServlet?qid=${assessmentQuestion.qid}&aid=${assessment.aid}" class="btn btn-warning">
        <i class="fas fa-edit"></i>
    </a>
    <form action="${pageContext.request.contextPath}/instructor/deleteQuestion" method="post" style="display: inline;">
        <input type="hidden" name="qid" value="${assessmentQuestion.qid}" />
        <input type="hidden" name="aid" value="${aid}" />
        <button type="submit" class="btn btn-danger">
            <i class="fas fa-trash-alt"></i>
        </button>
    </form>
</td>

                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<!-- Modal for adding a new question -->
<div class="modal fade" id="newQuestionModal" tabindex="-1" role="dialog" aria-labelledby="newQuestionModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="newQuestionModalLabel">Add New Question</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form id="addQuestionForm" action="${pageContext.request.contextPath}/instructor/addQuestion?aid=${aid}" method="post">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="questionText">Question Text</label>
                        <textarea class="form-control" id="questionText" name="questionText"></textarea>
                    </div>
                    <div class="form-group">
                        <label for="option1">Option 1</label>
                        <input type="text" class="form-control" id="option1" name="option1">
                    </div>
                    <div class="form-group">
                        <label for="option2">Option 2</label>
                        <input type="text" class="form-control" id="option2" name="option2">
                    </div>
                    <div class="form-group">
                        <label for="option3">Option 3</label>
                        <input type="text" class="form-control" id="option3" name="option3">
                    </div>
                    <div class="form-group">
                        <label for="option4">Option 4</label>
                        <input type="text" class="form-control" id="option4" name="option4">
                    </div>
                    <div class="form-group">
                        <label for="correctAnswer">Correct Answer</label>
                        <select class="form-control" id="correctAnswer" name="correctAnswer">
                            <option value="">Select Correct Answer</option>
                            <option value="A">A</option>
                            <option value="B">B</option>
                            <option value="C">C</option>
                            <option value="D">D</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="mark">Mark</label>
                        <input type="number" class="form-control" id="mark" name="mark">
                    </div>
                    <input type="hidden" name="aid" value="${assessment.aid}" />
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Add Question</button>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- Modal for editing a question -->
<div class="modal fade" id="editQuestionModal" tabindex="-1" role="dialog" aria-labelledby="editQuestionModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="editQuestionModalLabel">Edit Question</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form id="editQuestionForm" action="${pageContext.request.contextPath}/instructor/editQuestion" method="post">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="editQuestionText">Question Text</label>
                        <textarea class="form-control" id="editQuestionText" name="questionText"></textarea>
                    </div>
                    <div class="form-group">
                        <label for="editOption1">Option 1</label>
                        <input type="text" class="form-control" id="editOption1" name="option1">
                    </div>
                    <div class="form-group">
                        <label for="editOption2">Option 2</label>
                        <input type="text" class="form-control" id="editOption2" name="option2">
                    </div>
                    <div class="form-group">
                        <label for="editOption3">Option 3</label>
                        <input type="text" class="form-control" id="editOption3" name="option3">
                    </div>
                    <div class="form-group">
                        <label for="editOption4">Option 4</label>
                        <input type="text" class="form-control" id="editOption4" name="option4">
                    </div>
                    <div class="form-group">
                        <label for="editCorrectAnswer">Correct Answer</label>
                        <select class="form-control" id="editCorrectAnswer" name="correctAnswer">
                            <option value="">Select Correct Answer</option>
                            <option value="A">A</option>
                            <option value="B">B</option>
                            <option value="C">C</option>
                            <option value="D">D</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="editMark">Mark</label>
                        <input type="number" class="form-control" id="editMark" name="mark">
                    </div>
                    <input type="hidden" id="editQuestionId" name="qid" />
                    <input type="hidden" id="editAssessmentId" name="aid" />
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Save Changes</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/Asserts/Scripts/addQuestion.js"></script>
   
</body>
</html>
