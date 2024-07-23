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
    <link rel="stylesheet" href="../../resources/Styles/course.css">
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
                <li class="breadcrumb-item"><a href="../studentHome/studentHomeIndex.html">Home</a></li>
                <li class="breadcrumb-item active" aria-current="page">Course</li>
            </ol>
        </nav>
                <h2 class="text-center">JAVA</h2>
                <div class="search-container">
                    <input type="text" placeholder="Search..." id="searchInput" onkeyup="filterCards()">
                    <button type="submit"><i class="material-symbols-outlined">search</i></button>
                </div>
                <div class="btn-group-toggle" data-toggle="buttons">
                    <label class="btn btn-danger active" id="showPending">
                        <input type="radio" name="options" autocomplete="off" checked> Pending
                    </label>
                    <label class="btn btn-success" id="showCompleted">
                        <input type="radio" name="options" autocomplete="off"> Completed
                    </label>
                </div>
                <div class="row assessment-content" id="assessment-content">
                    <div class="col-md-6 col-lg-4">
                        <div class="course-card" data-status="pending">
                            <div class="card-body">
                                <h4>JDBC</h4>
                                <p><i class="fas fa-calendar-alt"></i> Date: January 1, 2025</p>
                                <p><i class="fas fa-star"></i> Marks: 100</p>
                                <p><i class="fas fa-redo-alt"></i> Attempts: 1</p>
                                <button class="btn btn-primary" onclick="showDetails('OOPS', 'January 1, 2025', 100, 1)" data-toggle="modal" data-target="#assessmentModal">Take Test</button>
                                <span class="badge text-bg-primary">New</span>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-4">
                        <div class="course-card" data-status="pending">
                            <div class="card-body">
                                <h4>Generics</h4>
                                <p><i class="fas fa-calendar-alt"></i> Date: January 1, 2025</p>
                                <p><i class="fas fa-star"></i> Marks: 100</p>
                                <p><i class="fas fa-redo-alt"></i> Attempts: 1</p>
                                <button class="btn btn-primary" onclick="showDetails('OOPS', 'January 1, 2025', 100, 1)" data-toggle="modal" data-target="#assessmentModal">Take Test</button>
                                <span class="badge text-bg-primary">New</span>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-4">
                        <div class="course-card" data-status="pending">
                            <div class="card-body">
                                <h4>Exception Handling</h4>
                                <p><i class="fas fa-calendar-alt"></i> Date: January 1, 2025</p>
                                <p><i class="fas fa-star"></i> Marks: 100</p>
                                <p><i class="fas fa-redo-alt"></i> Attempts: 1</p>
                                <button class="btn btn-primary" onclick="showDetails('OOPS', 'January 1, 2025', 100, 1)" data-toggle="modal" data-target="#assessmentModal">Take Test</button>
                                <span class="badge text-bg-primary">New</span>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-4">
                        <div class="course-card" data-status="completed">
                            <div class="card-body">
                                <h4>GENERICS</h4>
                                <p><i class="fas fa-calendar-alt"></i> Date: January 1, 2025</p>
                                <p><i class="fas fa-star"></i> Marks: 100</p>
                                <p><i class="fas fa-redo-alt"></i> Attempts: 1</p>
                                <span class="badge badge-success">Completed</span>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-4">
                        <div class="course-card" data-status="pending">
                            <div class="card-body">
                                <h4>THREADING</h4>
                                <p><i class="fas fa-calendar-alt"></i> Date: January 1, 2025</p>
                                <p><i class="fas fa-star"></i> Marks: 100</p>
                                <p><i class="fas fa-redo-alt"></i> Attempts: 1</p>
                                <button class="btn btn-primary" onclick="showDetails('THREADING', 'January 1, 2025', 100, 1)" data-toggle="modal" data-target="#assessmentModal">Take Test</button>
                                <span class="badge text-bg-primary">New</span>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-4">
                        <div class="course-card" data-status="completed">
                            <div class="card-body">
                                <h4>JDBC</h4>
                                <p><i class="fas fa-calendar-alt"></i> Date: January 1, 2025</p>
                                <p><i class="fas fa-star"></i> Marks: 100</p>
                                <p><i class="fas fa-redo-alt"></i> Attempts: 1</p>
                                <span class="badge badge-success">Completed</span>
                            </div>
                        </div>
                    </div>
                    <!-- Repeat the above div for more course cards as needed -->
                </div>
            </div>
        </div>
    </div>

    <!-- First Modal: Assessment Details -->
    <div class="modal fade" id="assessmentModal" tabindex="-1" role="dialog" aria-labelledby="assessmentModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="assessmentModalLabel">Assessment Details</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body" id="assessment-details">
                    <!-- Dynamic assessment details will be loaded here -->
                </div>
                <div class="modal-footer">
                    <a href="test.jsp"><button type="button" class="btn btn-primary" >Confirm</button></a>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                </div>
            </div>
        </div>
    </div>

    <!-- Second Modal: Examination Guidelines -->
    <!-- <div class="modal fade" id="guidelinesModal" tabindex="-1" role="dialog" aria-labelledby="guidelinesModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="guidelinesModalLabel">Examination Guidelines</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body" id="guidelines-details">
                    <p>Please read the following guidelines carefully before starting the examination:</p>
                    <ul>
                        <li>Ensure a stable internet connection throughout the exam.</li>
                        <li>Do not navigate away from the exam window, as this may result in automatic submission.</li>
                        <li>Read all questions carefully and manage your time wisely.</li>
                        <li>Do not use any unauthorized resources or assistance.</li>
                        <li>In case of any technical issues, contact the support team immediately.</li>
                    </ul>
                </div>
                <div class="modal-footer">
                    <a href="questions.html" class="btn btn-primary">Confirm</a>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                </div>
            </div>
        </div>
    </div> -->

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="../../resources/Scripts/course.js"></script>
</body>

</html>
