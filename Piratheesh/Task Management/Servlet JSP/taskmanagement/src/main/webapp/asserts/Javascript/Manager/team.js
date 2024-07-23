const analysisChartCanvas = document.getElementById('analysisChart');
const analysisChart = new Chart(analysisChartCanvas, {
    type: 'line',
    data: {
        labels: ['Oct 2023', 'Nov 2023', 'Dec 2023', 'Jan 2024', 'Feb 2024', 'Mar 2024'],
        datasets: [{
            label: '80',
            data: [7, 5, 8, 6, 9, 7], // Replace with actual data
            borderColor: 'rgba(255, 99, 132, 1)', // Red color
            fill: false,
            tension: 0.1 // Smoother line
        }, {
            label: '112',
            data: [4, 6, 3, 5, 4, 5], // Replace with actual data
            borderColor: 'rgba(54, 162, 235, 1)', // Blue color
            fill: false,
            tension: 0.1 // Smoother line
        }, {
            label: '501',
            data: [6, 3, 7, 2, 8, 7], // Replace with actual data
            borderColor: 'rgba(245, 178, 39, 0.8)', // Blue color
            fill: false,
            tension: 0.1 // Smoother line
        }, {
            label: '301',
            data: [1, 2, 4, 5, 7, 8], // Replace with actual data
            borderColor: 'rgba(0, 0, 0, 0.8)', // Blue color
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

const analysisChartCanvas2 = document.getElementById('analysisChart2');
const analysisChart2 = new Chart(analysisChartCanvas2, {
    type: 'line',
    data: {
        labels: ['Oct 2023', 'Nov 2023', 'Dec 2023', 'Jan 2024', 'Feb 2024', 'Mar 2024'],
        datasets: [{
            label: '301',
            data: [7, 5, 8, 6, 9, 7], // Replace with actual data
            borderColor: 'rgba(255, 99, 132, 1)', // Red color
            fill: false,
            tension: 0.1 // Smoother line
        }, {
            label: '401',
            data: [4, 6, 3, 5, 4, 5], // Replace with actual data
            borderColor: 'rgba(54, 162, 235, 1)', // Blue color
            fill: false,
            tension: 0.1 // Smoother line
        }, {
            label: '501',
            data: [6, 3, 7, 2, 8, 7], // Replace with actual data
            borderColor: 'rgba(245, 178, 39, 0.8)', // Blue color
            fill: false,
            tension: 0.1 // Smoother line
        }, {
            label: '301',
            data: [1, 2, 4, 5, 7, 8], // Replace with actual data
            borderColor: 'rgba(0, 0, 0, 0.8)', // Blue color
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

const analysisChartCanvas3 = document.getElementById('analysisChart3');
const analysisChart3 = new Chart(analysisChartCanvas3, {
    type: 'line',
    data: {
        labels: ['Oct 2023', 'Nov 2023', 'Dec 2023', 'Jan 2024', 'Feb 2024', 'Mar 2024'],
        datasets: [{
            label: 'This Year',
            data: [7, 5, 8, 6, 9, 7], // Replace with actual data
            borderColor: 'rgba(255, 99, 132, 1)', // Red color
            fill: false,
            tension: 0.1 // Smoother line
        }, {
            label: 'This Month',
            data: [4, 6, 3, 5, 4, 5], // Replace with actual data
            borderColor: 'rgba(54, 162, 235, 1)', // Blue color
            fill: false,
            tension: 0.1 // Smoother line
        }, {
            label: '501',
            data: [6, 3, 7, 2, 8, 7], // Replace with actual data
            borderColor: 'rgba(245, 178, 39, 0.8)', // Blue color
            fill: false,
            tension: 0.1 // Smoother line
        }, {
            label: '301',
            data: [1, 2, 4, 5, 7, 8], // Replace with actual data
            borderColor: 'rgba(0, 0, 0, 0.8)', // Blue color
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

const analysisChartCanvas4 = document.getElementById('analysisChart4');
const analysisChart4 = new Chart(analysisChartCanvas4, {
    type: 'line',
    data: {
        labels: ['Oct 2023', 'Nov 2023', 'Dec 2023', 'Jan 2024', 'Feb 2024', 'Mar 2024'],
        datasets: [{
            label: 'This Year',
            data: [7, 5, 8, 6, 9, 7], // Replace with actual data
            borderColor: 'rgba(255, 99, 132, 1)', // Red color
            fill: false,
            tension: 0.1 // Smoother line
        }, {
            label: 'This Month',
            data: [4, 6, 3, 5, 4, 5], // Replace with actual data
            borderColor: 'rgba(54, 162, 235, 1)', // Blue color
            fill: false,
            tension: 0.1 // Smoother line
        }, {
            label: '501',
            data: [6, 3, 7, 2, 8, 7], // Replace with actual data
            borderColor: 'rgba(245, 178, 39, 0.8)', // Blue color
            fill: false,
            tension: 0.1 // Smoother line
        }, {
            label: '301',
            data: [1, 2, 4, 5, 7, 8], // Replace with actual data
            borderColor: 'rgba(0, 0, 0, 0.8)', // Blue color
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