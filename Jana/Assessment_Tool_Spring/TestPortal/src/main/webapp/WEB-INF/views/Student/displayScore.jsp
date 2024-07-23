<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <title>Assessment Score</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway:400,700">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/Styles/displayScore.css">
    <style>
       body {
            background-color: #e7e6fa;
            font-family: 'Lucida Sans', Geneva, Verdana, sans-serif;
        }

        header {
            background-color: #17163B;
            color: aliceblue;
            height: 100px;
            padding: 10px;
            position: fixed;
            z-index: 1000;
            width: 100%;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        #column1 {
            background-color: #17163B;
            color: #ffffff;
            padding: 15px 0;
            width: 100px;
            position: fixed;
            top: 0;
            bottom: 0;
            left: 0;
            z-index: 1000;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        #column1 .material-symbols-outlined {
            font-size: 36px;
            margin-bottom: 20px;
            padding-top: 50px;
            cursor: pointer;
        }

        .breadcrumb {
            margin-top: 120px;
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

        .content-container {
            margin-left: 110px; /* Adjust this value based on the width of column1 */
            padding: 20px;
        }
    </style>
</head>

<body>
    <header class="container-fluid">
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
            <div class="col-11 content-container">
                <nav aria-label="breadcrumb">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/student/home">Home</a></li>
                        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/student/assessments?courseId=${sessionScope.courseId}&courseName=${sessionScope.courseName}">Assessments</a></li>
                        <li class="breadcrumb-item active" aria-current="page">Assessment Score</li>
                    </ol>
                </nav>

                <div class="assessment-title">
                    <h1>${assessment.aname}</h1>
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
            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>
