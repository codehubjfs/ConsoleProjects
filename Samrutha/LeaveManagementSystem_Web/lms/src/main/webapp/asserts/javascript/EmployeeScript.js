// Input data
var sickLeaveCount =  parseInt(document.getElementById("sickleave").textContent);
var casualLeaveCount = parseInt(document.getElementById("casualleave").textContent);
var vacationLeaveCount =  parseInt(document.getElementById("vacationleave").textContent);

// Calculate total leave count
var totalLeaveCount = 15;

// Calculate percentages
var sickLeavePercentage = (sickLeaveCount / totalLeaveCount) * 100;
var casualLeavePercentage = (casualLeaveCount / totalLeaveCount) * 100;
var vacationLeavePercentage = (vacationLeaveCount / totalLeaveCount) * 100;

// Round percentages to the nearest 20
var maxPercentage = 100;

// Chart configuration
var ctx = document.getElementById('leaveChart').getContext('2d');
var myChart = new Chart(ctx, {
    type: 'bar',
    data: {
        labels: ['Sick Leave', 'Casual Leave', 'Vacation Leave'],
        datasets: [{
            label: 'Leave Count',
            data: [sickLeavePercentage, casualLeavePercentage, vacationLeavePercentage],
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)'
            ],
            borderColor: [
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)'
            ],
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            x: {
                grid: {
                    display: false
                }
            },
            y: {
                beginAtZero: true,
                max: maxPercentage,
                ticks: {
                    stepSize: 5, // Adjust this value to reduce the space between values
                    callback: function(value) {
                        return value + "%";
                    }
                },
                grid: {
                    display: false
                }
            }
        },
        plugins: {
            legend: {
                display: true
            },
            title: {
                display: true,
                text: 'Leave Percentage Distribution'
            }
        }
    }
});




//validate form

document.getElementById('leaveType').addEventListener('change', function() {
    validateLeaveType();
});
document.getElementById('startDate').addEventListener('change', function() {
    validateStartDate();
    daysCount();
});
document.getElementById('endDate').addEventListener('change', function() {
    validateEndDate();
    daysCount()
});
document.getElementById('leaveReason').addEventListener('input', function() {
    validateLeaveReason();
});
document.getElementById('employeeSuggestion').addEventListener('change', function() {
    validateEmployeeSuggestion();
});

// Additional event listeners for real-time validation
document.getElementById('leaveType').addEventListener('input', function() {
    validateLeaveType();
});
document.getElementById('startDate').addEventListener('input', function() {
    validateStartDate();
    daysCount();
});
document.getElementById('endDate').addEventListener('input', function() {
    validateEndDate();
    daysCount();
});
document.getElementById('leaveReason').addEventListener('input', function() {
    validateLeaveReason();
});
document.getElementById('employeeSuggestion').addEventListener('input', function() {
    validateEmployeeSuggestion();
});

function validateLeaveType() {
    var leaveType = document.getElementById('leaveType').value;
    var leaveTypeFeedback = document.getElementById('leaveTypeFeedback');
    if (leaveType === "Enter leave type") {
        leaveTypeFeedback.innerHTML = "Leave Type is required.";
        document.getElementById('leaveType').style.border = "1px solid red";
    } else {
        leaveTypeFeedback.innerHTML = "";
        document.getElementById('leaveType').style.border = "";
        
    }
}


function validateStartDate() {
    var startDateInput = document.getElementById('startDate').value;
    var startDateFeedback = document.getElementById('startDateFeedback');
    var currentDate = new Date();

    if (!startDateInput) {
        startDateFeedback.innerHTML = "Start date is required.";
        document.getElementById('startDate').classList.add("error-border");
    } else {
        var startDate = new Date(startDateInput);
        startDate.setHours(0, 0, 0, 0);
        if (startDate < currentDate) {
            startDateFeedback.innerHTML = "Start date cannot be in the past.";
            document.getElementById('startDate').classList.add("error-border");
        } else {
            startDateFeedback.innerHTML = "";
            document.getElementById('startDate').classList.remove("error-border");
        }
    }
}

function validateEndDate() {
    var startDateInput = document.getElementById('startDate').value;
    var endDateInput = document.getElementById('endDate').value;
    var endDateFeedback = document.getElementById('endDateFeedback');

    if (!endDateInput) {
        endDateFeedback.innerHTML = "End date is required.";
        document.getElementById('endDate').classList.add("error-border");
    } else {
        var endDate = new Date(endDateInput);
        if (startDateInput) {
            var startDate = new Date(startDateInput);
            if (startDate > endDate) {
                endDateFeedback.innerHTML = "End date must be greater than the start date.";
                document.getElementById('endDate').classList.add("error-border");
            } else {
                endDateFeedback.innerHTML = "";
                document.getElementById('endDate').classList.remove("error-border");
            }
        } else {
            endDateFeedback.innerHTML = "";
            document.getElementById('endDate').classList.remove("error-border");
        }
    }
    daysCount();
}

function daysCount(){
    var startDateInput = document.getElementById('startDate').value;
    var endDateInput = document.getElementById('endDate').value;
    var countField = document.getElementById('count');

    if (startDateInput && endDateInput) {
        var startDate = new Date(startDateInput);
        var endDate = new Date(endDateInput);

        var timeDifference = endDate.getTime() - startDate.getTime();
        var daysDifference = timeDifference / (1000 * 3600 * 24) + 1;

        countField.value = daysDifference;
    } else {
        countField.value = 0;
    }
}
function validateLeaveReason() {
    var leaveReason = document.getElementById('leaveReason').value;
    var leaveReasonFeedback = document.getElementById('leaveReasonFeedback');

    if (leaveReason === "") {
        leaveReasonFeedback.innerHTML = "Leave Reason is required.";
        document.getElementById('leaveReason').style.border = "1px solid red";
    } else if (leaveReason.length <= 10) {
        leaveReasonFeedback.innerHTML = "Leave reason must be greater than 10 characters.";
        document.getElementById('leaveReason').style.border = "1px solid red";
    } else {
        leaveReasonFeedback.innerHTML = "";
        document.getElementById('leaveReason').style.border = "";
    }
}

function validateEmployeeSuggestion() {
    var employeeSuggestion = document.getElementById('employeeSuggestion').value;
    var employeeSuggestionFeedback = document.getElementById('employeeSuggestionFeedback');
    if (employeeSuggestion === "Suggest the employee name to alter work") {
        employeeSuggestionFeedback.innerHTML = "Employee Suggestion is required.";
        document.getElementById('employeeSuggestion').style.border = "1px solid red";
    } else {
        employeeSuggestionFeedback.innerHTML = "";
        document.getElementById('employeeSuggestion').style.border = "";
    }
}

function validateForm() {
    validateLeaveType();
    validateStartDate();
    validateEndDate();
    validateLeaveReason();
    validateEmployeeSuggestion();

    var leaveTypeFeedback = document.getElementById('leaveTypeFeedback').innerHTML;
    var startDateFeedback = document.getElementById('startDateFeedback').innerHTML;
    var endDateFeedback = document.getElementById('endDateFeedback').innerHTML;
    var leaveReasonFeedback = document.getElementById('leaveReasonFeedback').innerHTML;
    var employeeSuggestionFeedback = document.getElementById('employeeSuggestionFeedback').innerHTML;

    return leaveTypeFeedback === "" && startDateFeedback === "" && endDateFeedback === "" && leaveReasonFeedback === "" && employeeSuggestionFeedback === "";
}

document.querySelector('form').addEventListener('submit', function(event) {
    if (!validateForm()) {
        event.preventDefault();
    }
});
