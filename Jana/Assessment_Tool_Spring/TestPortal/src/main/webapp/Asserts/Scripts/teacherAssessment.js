function filterCards() {
    var input, filter, cards, cardContainer, h4, title, i;
    input = document.getElementById("searchInput");
    filter = input.value.toUpperCase();
    cardContainer = document.getElementById("assessment-content");
    cards = cardContainer.getElementsByClassName("course-card");
    for (i = 0; i < cards.length; i++) {
        title = cards[i].querySelector(".card-body h4");
        if (title.innerText.toUpperCase().indexOf(filter) > -1) {
            cards[i].parentElement.style.display = "";
        } else {
            cards[i].parentElement.style.display = "none";
        }
    }
}

function validateForm() {
        var valid = true;

        // Get form fields
        var aName = document.getElementById('aName').value;
        var aDate = document.getElementById('aDate').value;
        var startTime = document.getElementById('startTime').value;
        var endTime = document.getElementById('endTime').value;
        var duration = document.getElementById('duration').value;
        var totalMarks = document.getElementById('totalMarks').value;

        // Get error fields
        var aNameError = document.getElementById('aNameError');
        var aDateError = document.getElementById('aDateError');
        var startTimeError = document.getElementById('startTimeError');
        var endTimeError = document.getElementById('endTimeError');
        var durationError = document.getElementById('durationError');
        var totalMarksError = document.getElementById('totalMarksError');

        // Reset error messages
        aNameError.textContent = '';
        aDateError.textContent = '';
        startTimeError.textContent = '';
        endTimeError.textContent = '';
        durationError.textContent = '';
        totalMarksError.textContent = '';

        // Validate assessment name (no special characters)
        var specialCharPattern = /[!@#\$%\^\&*\)\(+=._-]+/;
        if (specialCharPattern.test(aName)) {
            aNameError.textContent = 'Assessment name must not contain special characters.';
            valid = false;
        }

        // Validate date (not in the past)
        var today = new Date().toISOString().split('T')[0];
        if (aDate < today) {
            aDateError.textContent = 'Date must not be in the past.';
            valid = false;
        }

        // Validate start time and end time
        if (startTime >= endTime) {
            startTimeError.textContent = 'Start time must be before end time.';
            endTimeError.textContent = 'End time must be after start time.';
            valid = false;
        }

        // Ensure required fields are not empty
        if (!aName) {
            aNameError.textContent = 'Assessment name is required.';
            valid = false;
        }
        if (!aDate) {
            aDateError.textContent = 'Date is required.';
            valid = false;
        }
        if (!startTime) {
            startTimeError.textContent = 'Start time is required.';
            valid = false;
        }
        if (!endTime) {
            endTimeError.textContent = 'End time is required.';
            valid = false;
        }
        if (!duration) {
            durationError.textContent = 'Duration is required.';
            valid = false;
        }
        if (!totalMarks) {
            totalMarksError.textContent = 'Total marks are required.';
            valid = false;
        }

        return valid;
    }
    
    // Add event listeners to clear error messages on input
    
    function openEditModal(aid, aname, adate, sttime, endtime, duration, totMark, cid, eid) {
        document.getElementById('editAid').value = aid;
        document.getElementById('editAName').value = aname;
       // Format date for input type="date"
    var formattedDate = adate.split(' ')[0]; // Extract YYYY-MM-DD part
    document.getElementById('editADate').value = formattedDate;
        document.getElementById('editStartTime').value = sttime;
        document.getElementById('editEndTime').value = endtime;
        document.getElementById('editDuration').value = duration;
        document.getElementById('editTotalMarks').value = totMark;
        document.getElementById('editCid').value = cid;
        document.getElementById('editEid').value = eid;

        $('#editAssessmentModal').modal('show');
    }

    function openDeleteModal(aid) {
        document.getElementById('deleteAid').value = aid;
        $('#deleteAssessmentModal').modal('show');
    }

    function validateEditForm() {
        var valid = true;

        // Get form fields
        var aName = document.getElementById('editAName').value;
        var aDate = document.getElementById('editADate').value;
        var startTime = document.getElementById('editStartTime').value;
        var endTime = document.getElementById('editEndTime').value;
        var duration = document.getElementById('editDuration').value;
        var totalMarks = document.getElementById('editTotalMarks').value;

        // Get error fields
        var aNameError = document.getElementById('editANameError');
        var aDateError = document.getElementById('editADateError');
        var startTimeError = document.getElementById('editStartTimeError');
        var endTimeError = document.getElementById('editEndTimeError');
        var durationError = document.getElementById('editDurationError');
        var totalMarksError = document.getElementById('editTotalMarksError');

        // Reset error messages
        aNameError.textContent = '';
        aDateError.textContent = '';
        startTimeError.textContent = '';
        endTimeError.textContent = '';
        durationError.textContent = '';
        totalMarksError.textContent = '';

        // Validate assessment name (no special characters)
        var specialCharPattern = /[!@#\$%\^\&*\)\(+=._-]+/;
        if (specialCharPattern.test(aName)) {
            aNameError.textContent = 'Assessment name must not contain special characters.';
            valid = false;
        }

        // Validate date (not in the past)
        var today = new Date().toISOString().split('T')[0];
        if (aDate < today) {
            aDateError.textContent = 'Date must not be in the past.';
            valid = false;
        }

        // Validate start time and end time
        if (startTime >= endTime) {
            startTimeError.textContent = 'Start time must be before end time.';
            endTimeError.textContent = 'End time must be after start time.';
            valid = false;
        }

        // Ensure required fields are not empty
        if (!aName) {
            aNameError.textContent = 'Assessment name is required.';
            valid = false;
        }
        if (!aDate) {
            aDateError.textContent = 'Date is required.';
            valid = false;
        }
        if (!startTime) {
            startTimeError.textContent = 'Start time is required.';
            valid = false;
        }
        if (!endTime) {
            endTimeError.textContent = 'End time is required.';
            valid = false;
        }
        if (!duration) {
            durationError.textContent = 'Duration is required.';
            valid = false;
        }
        if (!totalMarks) {
            totalMarksError.textContent = 'Total marks are required.';
            valid = false;
        }

        return valid;
    }
    
    document.addEventListener('DOMContentLoaded', function() {
    var editFields = [
        { field: 'editAName', errorField: 'editANameError' },
        { field: 'editADate', errorField: 'editADateError' },
        { field: 'editStartTime', errorField: 'editStartTimeError' },
        { field: 'editEndTime', errorField: 'editEndTimeError' },
        { field: 'editDuration', errorField: 'editDurationError' },
        { field: 'editTotalMarks', errorField: 'editTotalMarksError' }
    ];

    var formFields = [
        { field: 'aName', errorField: 'aNameError' },
        { field: 'aDate', errorField: 'aDateError' },
        { field: 'startTime', errorField: 'startTimeError' },
        { field: 'endTime', errorField: 'endTimeError' },
        { field: 'duration', errorField: 'durationError' },
        { field: 'totalMarks', errorField: 'totalMarksError' }
    ];

    function addInputEventListeners(fields) {
        fields.forEach(function(item) {
            var input = document.getElementById(item.field);
            var errorField = document.getElementById(item.errorField);

            input.addEventListener('input', function() {
                errorField.textContent = '';
            });
        });
    }

    addInputEventListeners(editFields);
    addInputEventListeners(formFields);
});

    // Prevent link navigation when clicking on edit or delete buttons
    //document.querySelectorAll('.course-card .card-footer .btn').forEach(button => {
      //  button.addEventListener('click', function(event) {
      //      event.stopPropagation();
      //  });
   // });

function filterAssessments(status) {
            // Remove active class from all buttons
            document.querySelectorAll('.filters .btn').forEach(btn => btn.classList.remove('active'));

            // Add active class to the clicked button
            document.getElementById('filter' + capitalize(status)).classList.add('active');

            // Hide all assessment content
            document.querySelectorAll('.assessment-content').forEach(content => content.classList.remove('active'));

            // Show the assessment content that matches the status
            document.getElementById(status).classList.add('active');

            // Move the slider
            const slider = document.getElementById('filterSlider');
            const activeBtn = document.querySelector('.filters .btn.active');
            slider.style.left = activeBtn.offsetLeft + 'px';
            slider.style.width = activeBtn.offsetWidth + 'px';
        }

        function capitalize(str) {
            return str.charAt(0).toUpperCase() + str.slice(1);
        }

        window.addEventListener('DOMContentLoaded', (event) => {
            const activeBtn = document.querySelector('.filters .btn.active');
            const slider = document.getElementById('filterSlider');
            slider.style.left = activeBtn.offsetLeft + 'px';
            slider.style.width = activeBtn.offsetWidth + 'px';
        });
        function filterCards() {
            const searchInput = document.getElementById('searchInput').value.toLowerCase();
            document.querySelectorAll('.course-card').forEach(card => {
                const title = card.querySelector('.card-body h4').textContent.toLowerCase();
                if (title.includes(searchInput)) {
                    card.style.display = '';
                } else {
                    card.style.display = 'none';
                }
            });
        }