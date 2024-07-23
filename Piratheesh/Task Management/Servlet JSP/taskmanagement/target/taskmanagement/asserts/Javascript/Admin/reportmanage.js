document.addEventListener("DOMContentLoaded", function() {
    var ctx1 = document.getElementById('employeeChart').getContext('2d');
    var employeeChart = new Chart(ctx1, {
        type: 'pie',
        data: {
            labels: ['Added', 'Not Added'],
            datasets: [{
                label: 'Employees',
                data: [30, 70],
                backgroundColor: ['#1A4D2E', '#E8DFCA'],
                borderColor: ['#1A4D2E', '#E8DFCA'],
                borderWidth: 1
            }]
        },
        options: {
            responsive: true,
            maintainAspectRatio: false,
            plugins: {
                legend: {
                    position: 'top',
                },
            }
        }
    });

    var ctx2 = document.getElementById('adminChart').getContext('2d');
    var adminChart = new Chart(ctx2, {
        type: 'pie',
        data: {
            labels: ['Added', 'Not Added'],
            datasets: [{
                label: 'Admins',
                data: [10, 90],
                backgroundColor: ['#4F6F52', '#F5EFE6'],
                borderColor: ['#4F6F52', '#F5EFE6'],
                borderWidth: 1
            }]
        },
        options: {
            responsive: true,
            maintainAspectRatio: false,
            plugins: {
                legend: {
                    position: 'top',
                },
            }
        }
    });

    var ctx3 = document.getElementById('employeeAdminChart').getContext('2d');
    var employeeAdminChart = new Chart(ctx3, {
        type: 'bar',
        data: {
            labels: ['Employees', 'Admins'],
            datasets: [{
                label: 'Working',
                data: [40, 10],
                backgroundColor: ['#1A4D2E', '#4F6F52'],
                borderColor: ['#1A4D2E', '#4F6F52'],
                borderWidth: 1
            }]
        },
        options: {
            responsive: true,
            maintainAspectRatio: false,
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });

    var ctx4 = document.getElementById('sampleReportChart').getContext('2d');
    var sampleReportChart = new Chart(ctx4, {
        type: 'line',
        data: {
            labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
            datasets: [{
                label: 'Sample Report',
                data: [10, 20, 30, 40, 50, 60, 70],
                backgroundColor: 'rgba(26, 77, 46, 0.2)',
                borderColor: '#1A4D2E',
                borderWidth: 1
            }]
        },
        options: {
            responsive: true,
            maintainAspectRatio: false,
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });
});
