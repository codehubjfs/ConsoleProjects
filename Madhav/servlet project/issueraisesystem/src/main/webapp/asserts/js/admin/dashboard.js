// JavaScript code to generate Chart.js charts

// Example Chart.js setup for analysisChart
const analysisChartCanvas = document.getElementById('analysisChart');
const analysisChart = new Chart(analysisChartCanvas, {
    type: 'line',
    data: {
        labels: ['Oct 2023', 'Nov 2023', 'Dec 2023', 'Jan 2024', 'Feb 2024', 'Mar 2024'],
        datasets: [{
            label: 'This Year',
            data: [7, 5, 8, 6, 9, 7], // Replace with actual data
            borderColor: 'rgba(255, 99, 132, 1)', // Red color
            fill: false,
            tension: 0.1 // Smoother line
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



// Example Chart.js setup for targetRealityChart
const targetRealityChartCanvas = document.getElementById('targetRealityChart');
const targetRealityChart = new Chart(targetRealityChartCanvas, {
    type: 'bar',
    data: {
        labels: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul'],
        datasets: [{
            label: 'Reality Sales',
            data: [25, 20, 30, 28, 35, 40, 38], // Replace with actual data
            backgroundColor: 'rgba(75, 192, 192, 1)', // Green color
            borderWidth: 1
        }, {
            label: 'Target Sales',
            data: [30, 28, 35, 32, 40, 45, 42], // Replace with actual data
            backgroundColor: 'rgba(255, 159, 64, 1)', // Orange color
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

// Example Chart.js setup for volumeServiceChart
const volumeServiceChartCanvas = document.getElementById('volumeServiceChart');
const volumeServiceChart = new Chart(volumeServiceChartCanvas, {
    type: 'bar',
    data: {
        labels: ['Week 1', 'Week 2', 'Week 3', 'Week 4', 'Week 5'],
        datasets: [{
            label: 'Service Level 1',
            data: [12, 18, 15, 20, 25], // Replace with actual data
            backgroundColor: 'rgba(54, 162, 235, 1)', // Blue color
            borderWidth: 1
        }, {
            label: 'Service Level 2',
            data: [10, 15, 12, 18, 22], // Replace with actual data
            backgroundColor: 'rgba(255, 206, 86, 1)', // Yellow color
            borderWidth: 1
        }, {
            label: 'Service Level 3',
            data: [8, 12, 10, 15, 18], // Replace with actual data
            backgroundColor: 'rgba(75, 192, 192, 1)', // Green color
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


const ctx = document.getElementById('ticketStatusChart').getContext('2d');
    const ticketStatusChart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: ['Tickets'],
            datasets: [
                {
                    label: 'Raised Tickets',
                    data: [12122],
                    backgroundColor: 'rgba(255, 99, 132, 0.2)',
                    borderColor: 'rgba(255, 99, 132, 1)',
                    borderWidth: 1
                },
                {
                    label: 'Resolved Tickets',
                    data: [8823],
                    backgroundColor: 'rgba(75, 192, 192, 0.2)',
                    borderColor: 'rgba(75, 192, 192, 1)',
                    borderWidth: 1
                }
            ]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });


    
    



    