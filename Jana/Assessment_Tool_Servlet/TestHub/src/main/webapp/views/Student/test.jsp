<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Assessment</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="../../resources/Styles/test.css">
</head>
<body>
    <div class="container">
        <header class="d-flex justify-content-between align-items-center my-4">
            <h1>Java Assessment</h1>
            <div>
                <span id="timer" class="badge badge-primary p-2">Time: 60:00</span>
            </div>
        </header>

        <div class="row">
            <!-- Question Navigation Table -->
            <div class="col-md-3 mb-4">
                <div id="questionNavigation" class="p-3 border bg-light">
                    <!-- Navigation buttons will be dynamically loaded here -->
                </div>
            </div>

            <!-- Question Container -->
            <div class="col-md-9 mb-4">
                <div id="questionContainer" class="p-3 border bg-light">
                    <!-- Questions will be dynamically loaded here -->
                </div>

                <div class="d-flex justify-content-between mt-4">
                    <button id="prevButton" class="btn btn-secondary" onclick="prevQuestion()">Previous</button>
                    <button id="nextButton" class="btn btn-secondary" onclick="nextQuestion()">Next</button>
                </div>

                <div class="text-center my-4">
                    <button class="btn btn-success" onclick="confirmSubmit()">Submit Test</button>
                </div>
            </div>
        </div>
    </div>

    <!-- Modal for displaying result -->
    <div class="modal fade" id="resultModal" tabindex="-1" role="dialog" aria-labelledby="resultModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="resultModalLabel">Test Results</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body text-center">
                    <h2>Your Score: <span id="score"></span></h2>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" onclick="redirectToHome()">Okay</button>
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
                        <li>Rule 2: You have 60 minutes to complete the test.</li>
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

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="../../resources/Scripts/test.js"></script>
</body>
</html>
