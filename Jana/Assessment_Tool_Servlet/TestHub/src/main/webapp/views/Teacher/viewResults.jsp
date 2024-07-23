<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Results</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/Styles/teacherResult.css"> <!-- Ensure the path to your CSS file is correct -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" crossorigin="anonymous" />
</head>

</head>
<body>
    <div class="container">
        <h2>Results for Assessment: ${assessment.aid} - ${assessment.aname}</h2>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Student ID</th>
                    <th>Student Name</th>
                    <th>Mark</th>
                    <c:forEach var="question" items="${questions}">
                        <th>Q${question.questionId}</th>
                    </c:forEach>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="result" items="${results}">
                    <tr>
                        <td>${result.studentId}</td>
                        <td>${result.studentName}</td>
                        <td>${result.studentMark}</td>
                        <c:forEach var="question" items="${questions}">
                            <td>
                                <c:choose>
                                    <c:when test="${result.studentAnswers[question.questionId] eq question.correctAnswer}">
                                        <i class="fas fa-check text-success"></i>
                                    </c:when>
                                    <c:otherwise>
                                        <i class="fas fa-times text-danger"></i>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </c:forEach>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
         </table>
        <div class="question-cards">
            <c:forEach var="allquestion" items="${allquestions}">
        <div class="question-card">
            <h4>Question ${allquestion.qid}: ${allquestion.questions}</h4>
            <div class="options">
                <div class="option">A. ${allquestion.c1}</div>
                <div class="option">B. ${allquestion.c2}</div>
                <div class="option">C. ${allquestion.c3}</div>
                <div class="option">D. ${allquestion.c4}</div>
            </div>
            <p>Correct Answer: <span class="correct">${allquestion.answer}</span></p>
        </div>
    </c:forEach>
        </div>
    </div>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/3.9.1/gsap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.7/dist/umd/popper.min.js" integrity="sha384-OERcA2D7ubbvmy0DIe6ILtRmx5i+QmYU5LYsRSdFw2aMFFtEfx8rW9ggt0fYUktB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-5RXj9z+6ZZp7bYGFOVP8LFidkqs6mPlWlzeP8DReId2QFaaSBFL6NBnaGhX8QVvM" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/js/all.min.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script src="${pageContext.request.contextPath}/resources/Scripts/adminPortal.js"></script>
</body>
</html>
