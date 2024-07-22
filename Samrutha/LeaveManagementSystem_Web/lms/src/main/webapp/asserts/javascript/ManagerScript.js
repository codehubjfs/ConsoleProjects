document.addEventListener('DOMContentLoaded', function() {
	
    const analysisChartCanvas = document.getElementById('analysisChart');
    const analysisChart = new Chart(analysisChartCanvas, {
        type: 'line',
        data: {
            labels: ['Sick Leave', 'Casual Leave', 'Vacation Leave'],
            datasets: [{
                label: 'Leave Type',
                data: [6 , 1 , 0], 
                borderColor: '#040430', 
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
});


