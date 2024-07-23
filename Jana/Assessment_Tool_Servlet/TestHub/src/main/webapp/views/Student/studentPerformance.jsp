<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Dashboard</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../../resources/Styles/performance.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
</head>
<body>
<header class="container-fluid" id="header">
    <h1 class="container" id="bname">TESTOPHILE</h1>
    <div class="dropdown">
        <span class="material-symbols-outlined" id="profileDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">account_circle</span>
        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="profileDropdown">
            <a class="dropdown-item" href="#">Edit Profile</a>
            <a class="dropdown-item" href="#">Logout</a>
        </div>
    </div>
</header>

<div class="container-fluid">
    <div class="row">
        <!-- First Column: Navigation Icons -->
        <div class="col-2 text-center nav-icons" id="navigation">
            <div class="fixed-nav">
                <div><span class="material-symbols-outlined" id="home">home</span></div>
                <label for="home" id="nav-desc">Home</label>
                <div><span class="material-symbols-outlined" id="assessment">school</span></div>
                <label for="assessment" id="nav-desc">Assessments</label>
                <div><span class="material-symbols-outlined" id="LeaderBoard">assessment</span></div>
                <label for="LeaderBoard" id="nav-desc">LeaderBoard</label>
            </div>
        </div>

        <!-- Second Column: Performance Analysis -->
        <div class="col-10 offset-2"  style="margin-top: 120px;">
            <div class="row">
                <!-- First Sub-column -->
                <div class="col-md-6">
                    <div class="card mt-4">
                        <div class="card-title">
                            <h2>Progress Chart</h2>
                        </div>
                        <div class="card-body">
                            <canvas id="progressChart"></canvas>
                        </div>
                    </div>

                    <div class="card mt-4">
                        <div class="card-title">
                            <h2>Leaderboard</h2>
                        </div>
                        <div class="card-body">
                            <ul class="list-group">
                                <li class="list-group-item">Student A - 95%</li>
                                <li class="list-group-item">Student B - 90%</li>
                                <li class="list-group-item">Student C - 85%</li>
                                <li class="list-group-item">Student D - 80%</li>
                                <li class="list-group-item">Student E - 75%</li>
                            </ul>
                        </div>
                    </div>

                    <div class="card mt-4">
                        <div class="card-title">
                            <h2>Super-Badges Earned</h2>
                        </div>
                        <div class="card-body">
                            <canvas id="superBadgesChart"></canvas>
                        </div>
                    </div>
                </div>

                <!-- Second Sub-column -->
                <div class="col-md-6">
                    <div class="card mt-4">
                        <div class="card-title">
                            <h2>Performance Over Time</h2>
                        </div>
                        <div class="card-body">
                            <canvas id="performanceOverTimeChart"></canvas>
                        </div>
                    </div>

                    <div class="card mt-4">
                        <div class="card-title">
                            <h2>Course Completion Rates</h2>
                        </div>
                        <div class="card-body">
                            <canvas id="courseCompletionChart"></canvas>
                        </div>
                    </div>

                    <div class="card mt-4">
                        <div class="card-title">
                            <h2>Badges Earned</h2>
                        </div>
                        <div class="card-body">
                            <canvas id="badgesChart"></canvas>
                        </div>
                    </div>

                    
                </div>
            </div>
        </div>
    </div> 
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="../../resources/Scripts/performance.js"></script>
</body>
</html>
