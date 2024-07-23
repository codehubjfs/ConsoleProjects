<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Assessment Questions</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" crossorigin="anonymous" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/Styles/addQuestion.css">
    
</head>
<body>
    <div class="container">
        <h2>Manage Questions for Assessment: ${aid} - ${aName}</h2>
        
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
                                <form action="${pageContext.request.contextPath}/AddQuestionToAssessmentServlet" method="get">
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
                            <a href="${pageContext.request.contextPath}/EditQuestionServlet?qid=${assessmentQuestion.qid}&aid=${assessment.aid}" class="btn btn-warning">Edit</a>
                            <form action="${pageContext.request.contextPath}/DeleteQuestionFromAssessmentServlet" method="post" style="display: inline;">
                                <input type="hidden" name="qid" value="${assessmentQuestion.qid}" />
                                <input type="hidden" name="aid" value="${assessment.aid}" />
                                <button type="submit" class="btn btn-danger">Delete</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
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
                <form action="${pageContext.request.contextPath}/AddNewQuestionServlet?aid=${aid}" method="post">
                    <div class="modal-body">
                        <div class="form-group">
                            <label for="questionText">Question Text</label>
                            <textarea class="form-control" id="questionText" name="questionText" required></textarea>
                        </div>
                        <div class="form-group">
                            <label for="option1">Option 1</label>
                            <input type="text" class="form-control" id="option1" name="option1" required>
                        </div>
                        <div class="form-group">
                            <label for="option2">Option 2</label>
                            <input type="text" class="form-control" id="option2" name="option2" required>
                        </div>
                        <div class="form-group">
                            <label for="option3">Option 3</label>
                            <input type="text" class="form-control" id="option3" name="option3" required>
                        </div>
                        <div class="form-group">
                            <label for="option4">Option 4</label>
                            <input type="text" class="form-control" id="option4" name="option4" required>
                        </div>
                        <div class="form-group">
                            <label for="correctAnswer">Correct Answer</label>
                            <input type="text" class="form-control" id="correctAnswer" name="correctAnswer" required>
                        </div>
                        <div class="form-group">
                            <label for="mark">Mark</label>
                            <input type="number" class="form-control" id="mark" name="mark" required>
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
    
    
    
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/Scripts/addQuestion.js"></script>
   
</body>
</html>
