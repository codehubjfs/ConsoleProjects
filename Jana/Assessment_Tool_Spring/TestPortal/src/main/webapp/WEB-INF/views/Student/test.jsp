<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%  HttpSession session1 = request.getSession(); 
    if (session == null || session.getAttribute("email") == null) {
        response.sendRedirect(request.getContextPath() + "/loginPage");
        return;
    } %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Assessment</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Asserts/Styles/test.css">
</head>
<body>
    <div class="container">
        <header class="d-flex justify-content-between align-items-center my-4">
            <h1 class="text-center">${assessmentName}</h1>
            <div>
                <span id="timer" class="badge badge-primary p-2">Time: ${duration}:00</span>
            </div>
        </header>
        

        <div class="row">
            <!-- Question Navigation Table -->
            <div class="col-md-3 mb-4">
                <div id="questionNavigation" class="p-3 border bg-light">
                    <h4>Questions</h4>
                    <c:forEach var="question" items="${questions}" varStatus="status">
                        <button class="btn btn-unvisited" id="nav-button-${status.index}" onclick="jumpToQuestion(${status.index})">${status.index + 1}</button>
                    </c:forEach>
                </div>
            </div>

            <!-- Question Container -->
            <div class="col-md-9 mb-4">
                <div id="questionContainer" class="p-3 border bg-light">
                    <c:forEach var="question" items="${questions}" varStatus="status">
                        <div class="question" id="question${status.index}" style="display:none;" data-qid="${question.qid}">
                            <h4>${question.questions}</h4>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="answer${status.index}" id="c1${status.index}" value="A" onclick="saveAnswer(${status.index}, 'A')">
                                <label class="form-check-label" for="c1${status.index}">${question.c1}</label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="answer${status.index}" id="c2${status.index}" value="B" onclick="saveAnswer(${status.index}, 'B')">
                                <label class="form-check-label" for="c2${status.index}">${question.c2}</label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="answer${status.index}" id="c3${status.index}" value="C" onclick="saveAnswer(${status.index}, 'C')">
                                <label class="form-check-label" for="c3${status.index}">${question.c3}</label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="answer${status.index}" id="c4${status.index}" value="D" onclick="saveAnswer(${status.index}, 'D')">
                                <label class="form-check-label" for="c4${status.index}">${question.c4}</label>
                            </div>
                        </div>
                    </c:forEach>
                </div>

                <div class="d-flex justify-content-between mt-4">
                    <button id="prevButton" class="btn btn-secondary" onclick="prevQuestion()">Previous</button>
                    <button id="nextButton" class="btn btn-secondary" onclick="nextQuestion()">Next</button>
                </div>

                <div class="text-center my-4">
                    <form id="submitForm" action="StoreQuestionServlet" method="post">
                        <input type="hidden" name="assessmentId" value="${assessmentId}">
                        <input type="hidden" name="answerMap" id="answerMap">
                        <button type="button" class="btn btn-success" onclick="confirmSubmit()">Submit Test</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    

    <!-- Modal for confirmation message -->
    <div class="modal fade" id="confirmModal" tabindex="-1" role="dialog" aria-labelledby="confirmModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="confirmModalLabel">Confirm Submission</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    Are you sure you want to submit the test?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-danger" onclick="submitTest()">Yes</button>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">No</button>
                </div>
            </div>
        </div>
    </div>

    <!-- Modal for exam rules -->
    <div class="modal fade" id="rulesModal" tabindex="-1" role="dialog" aria-labelledby="rulesModalLabel" aria-hidden="true" data-backdrop="static" data-keyboard="false">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="rulesModalLabel">Exam Rules</h5>
                </div>
                <div class="modal-body">
                    <ul>
                        <li>Rule 1: Do not cheat.</li>
                        <li>Rule 2: You have <span id="duration">${duration}</span> minutes to complete the test.</li>
                        <li>Rule 3: Do not refresh the page.</li>
                        <!-- Add more rules as necessary -->
                    </ul>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" onclick="startExam()">Start Exam</button>
                </div>
            </div>
        </div>
    </div>
    
     <!-- Modal for Tab Switch Alert -->
        <div class="modal fade" id="tabAlertModal" tabindex="-1" aria-labelledby="tabAlertModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="tabAlertModalLabel">Tab Switch Alert</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <p id="tabAlertText">You have switched tabs. Please return to the test to continue.</p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary" onclick="resumeTest()">Resume Test</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modal for Tab Switch Submission -->
        <div class="modal fade" id="tabSwitchModal" tabindex="-1" aria-labelledby="tabSwitchModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="tabSwitchModalLabel">Test Submitted</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <p>You have switched tabs three times. Your test has been submitted.</p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary" onclick="submitTest()">OK</button>
                    </div>
                </div>
            </div>
        </div>

    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/Asserts/Scripts/test.js"></script>
</body>
</html>
