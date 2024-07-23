<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Assessment Score</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway:400,700">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/Styles/displayScore.css">
    <style>
        body {
            background-color: #e7e6fa;
            font-family: 'Lucida Sans', Geneva, Verdana, sans-serif;
            padding: 20px;
        }

        .breadcrumb {
            background-color: #fff;
            margin-bottom: 20px;
            border-radius: 5px;
        }

        .assessment-title {
            text-align: center;
            margin-bottom: 20px;
        }

        .score-container {
            text-align: center;
            background-color: #fff;
            padding: 20px;
            margin-bottom: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .score-container h2 {
            font-size: 48px;
            color: #4CAF50;
        }

        .question-card {
            background-color: #fff;
            padding: 20px;
            margin-bottom: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .correct {
            color: #4CAF50;
            font-weight: bold;
        }

        .incorrect {
            color: #F44336;
            font-weight: bold;
        }
        
        .question-card h4 {
            color: #333;
        }
        
        .options {
            margin-left: 20px;
        }
        
        .option {
            margin-bottom: 5px;
        }
        
        .option span {
            font-weight: bold;
        }
    </style>
</head>

<body>

    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="TestToHomeServlet">Home</a></li>
            <li class="breadcrumb-item"><a href="views/Student/studentHome.jsp">Courses</a></li>
            <li class="breadcrumb-item active" aria-current="page">Assessment Score</li>
        </ol>
    </nav>

    <div class="assessment-title">
        <h1>${assessment.aName}</h1>
    </div>

    <div class="score-container">
        <h2>Overall Score: ${totalScore}</h2>
    </div>

    <c:forEach var="question" items="${questions}">
        <div class="question-card">
            <h4>Question ${question.qid}: ${question.questions}</h4>
            <div class="options">
                <div class="option">A. ${question.c1}</div>
                <div class="option">B. ${question.c2}</div>
                <div class="option">C. ${question.c3}</div>
                <div class="option">D. ${question.c4}</div>
            </div>
            <p>Correct Answer: <span class="correct">${correctAnswers[question.qid]}</span></p>
            <p>Your Answer: 
                <span class="${studentAnswers[question.qid] == correctAnswers[question.qid] ? 'correct' : 'incorrect'}">
                    ${studentAnswers[question.qid]}
                </span>
            </p>
            <p>Marks: ${studentAnswers[question.qid] == correctAnswers[question.qid] ? question.mark : 0}</p>
        </div>
    </c:forEach>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>
