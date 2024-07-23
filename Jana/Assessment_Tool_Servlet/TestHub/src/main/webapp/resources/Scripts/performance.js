document.addEventListener('DOMContentLoaded', (event) => {
    document.querySelectorAll('.nav-icons .material-symbols-outlined').forEach(icon => {
        icon.addEventListener('click', () => {
            if (icon.textContent.trim() === 'home') {
                window.location.href = '../Home/index.html';
            } else if (icon.textContent.trim() === 'school') {
                window.location.href = '../course/course.html';
            } else if (icon.textContent.trim() === 'assessment') {
                window.location.href = '../assessment/assessment.html';
            }
        });
    });

    // Progress Chart
    var ctx1 = document.getElementById('progressChart').getContext('2d');
    new Chart(ctx1, {
        type: 'bar',
        data: {
            labels: ['Courses Enrolled', 'Completed', 'In Progress', 'Badges', 'Super-Badges'],
            datasets: [{
                label: 'Progress',
                data: [16, 5, 11, 56, 7],
                backgroundColor: [
                    'rgba(255, 99, 132, 0.2)',
                    'rgba(54, 162, 235, 0.2)',
                    'rgba(255, 206, 86, 0.2)',
                    'rgba(75, 192, 192, 0.2)',
                    'rgba(153, 102, 255, 0.2)'
                ],
                borderColor: [
                    'rgba(255, 99, 132, 1)',
                    'rgba(54, 162, 235, 1)',
                    'rgba(255, 206, 86, 1)',
                    'rgba(75, 192, 192, 1)',
                    'rgba(153, 102, 255, 1)'
                ],
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });

    // Performance Over Time Chart
    var ctx2 = document.getElementById('performanceOverTimeChart').getContext('2d');
    new Chart(ctx2, {
        type: 'line',
        data: {
            labels: ['January', 'February', 'March', 'April', 'May', 'June'],
            datasets: [{
                label: 'Performance Over Time',
                data: [65, 59, 80, 81, 56, 55],
                backgroundColor: 'rgba(75, 192, 192, 0.2)',
                borderColor: 'rgba(75, 192, 192, 1)',
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });

    // Course Completion Chart
    var ctx3 = document.getElementById('courseCompletionChart').getContext('2d');
    new Chart(ctx3, {
        type: 'doughnut',
        data: {
            labels: ['Completed', 'In Progress', 'Not Started'],
            datasets: [{
                label: 'Course Completion Rates',
                data: [50, 30, 20],
                backgroundColor: [
                    'rgba(75, 192, 192, 0.2)',
                    'rgba(255, 206, 86, 0.2)',
                    'rgba(255, 99, 132, 0.2)'
                ],
                borderColor: [
                    'rgba(75, 192, 192, 1)',
                    'rgba(255, 206, 86, 1)',
                    'rgba(255, 99, 132, 1)'
                ],
                borderWidth: 1
            }]
        },
        options: {
            responsive: true,
            maintainAspectRatio: false
        }
    });

    // Badges Earned Chart
    var ctx4 = document.getElementById('badgesChart').getContext('2d');
    new Chart(ctx4, {
        type: 'pie',
        data: {
            labels: ['Badges', 'Super-Badges'],
            datasets: [{
                label: 'Badges Earned',
                data: [70, 30],
                backgroundColor: [
                    'rgba(153, 102, 255, 0.2)',
                    'rgba(54, 162, 235, 0.2)'
                ],
                borderColor: [
                    'rgba(153, 102, 255, 1)',
                    'rgba(54, 162, 235, 1)'
                ],
                borderWidth: 1
            }]
        },
        options: {
            responsive: true,
            maintainAspectRatio: false
        }
    });

    // Super-Badges Earned Chart
    var ctx5 = document.getElementById('superBadgesChart').getContext('2d');
    new Chart(ctx5, {
        type: 'polarArea',
        data: {
            labels: ['Super-Badge 1', 'Super-Badge 2', 'Super-Badge 3'],
            datasets: [{
                label: 'Super-Badges Earned',
                data: [10, 20, 30],
                backgroundColor: [
                    'rgba(255, 99, 132, 0.2)',
                    'rgba(255, 206, 86, 0.2)',
                    'rgba(75, 192, 192, 0.2)'
                ],
                borderColor: [
                    'rgba(255, 99, 132, 1)',
                    'rgba(255, 206, 86, 1)',
                    'rgba(75, 192, 192, 1)'
                ],
                borderWidth: 1
            }]
        },
        options: {
            responsive: true,
            maintainAspectRatio: false
        }
    });

    // Scroll event for header and nav bar color change
    window.addEventListener("scroll", function() {
        var header = document.getElementById("header");
        var nav = document.getElementById("navigation");
        if (window.scrollY > 150) {
            header.classList.add("scrolled");
            nav.classList.add("scrolled");
        } else {
            header.classList.remove("scrolled");
            nav.classList.remove("scrolled");
        }
    });
});
