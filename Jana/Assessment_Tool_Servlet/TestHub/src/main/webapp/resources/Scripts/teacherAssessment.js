document.addEventListener('DOMContentLoaded', () => {
    fetchTeachers();

    // Function to show the appropriate section
    window.showSection = function(sectionId) {
        const sections = document.querySelectorAll('.content-section');
        sections.forEach(section => {
            section.style.display = 'none';
        });
        document.getElementById(sectionId).style.display = 'block';
    }

    // Form validation for Add Assessment form
    const addAssessmentForm = document.getElementById('addAssessmentForm');
    addAssessmentForm.addEventListener('submit', function(event) {
        event.preventDefault(); // Prevent form submission for now

        // Validation variables
        let isValid = true;
        const errors = [];

        // Reset previous error messages
        const errorMessages = document.querySelectorAll('.error-message');
        errorMessages.forEach(msg => msg.textContent = '');

        // Retrieve form fields
        const aName = document.getElementById('aName').value.trim();
        const stTime = document.getElementById('stTime').value.trim();
        const endTime = document.getElementById('endTime').value.trim();
        const duration = parseInt(document.getElementById('duration').value.trim());
        const totMarks = parseInt(document.getElementById('totMarks').value.trim());
        const aDate = document.getElementById('aDate').value.trim();

        // Validation functions
        function showError(fieldId, message) {
            const errorField = document.getElementById(`${fieldId}-error`);
            if (errorField) {
                errorField.textContent = message;
            }
            isValid = false;
        }

        function validateNotEmpty(value, fieldId, fieldName) {
            if (value === '') {
                showError(fieldId, `${fieldName} cannot be empty.`);
                return false;
            }
            return true;
        }

        function validateDateNotPast(dateValue, fieldId, fieldName) {
            const today = new Date();
            const selectedDate = new Date(dateValue);
            if (selectedDate < today) {
                showError(fieldId, `${fieldName} must not be in the past.`);
                return false;
            }
            return true;
        }

        function validateStartTimeBeforeEndTime(startTime, endTime) {
            const startTimeObj = new Date(`01/01/2000 ${startTime}`);
            const endTimeObj = new Date(`01/01/2000 ${endTime}`);
            if (startTimeObj >= endTimeObj) {
                showError('stTime', 'Start Time must be before End Time.');
                showError('endTime', 'End Time must be after Start Time.');
                return false;
            }
            return true;
        }

        function validateAssessmentName(value, fieldId, fieldName) {
            const regex = /^[a-zA-Z\s]*$/;
            if (!regex.test(value)) {
                showError(fieldId, `${fieldName} should only contain letters and spaces.`);
                return false;
            }
            return true;
        }

        // Perform validations
        isValid = validateNotEmpty(aName, 'aName', 'Assessment Name') && isValid;
        isValid = validateDateNotPast(aDate, 'aDate', 'Assessment Date') && isValid;
        isValid = validateStartTimeBeforeEndTime(stTime, endTime) && isValid;
        isValid = validateAssessmentName(aName, 'aName', 'Assessment Name') && isValid;

        // If all validations pass, submit the form
        if (isValid) {
            addAssessmentForm.submit();
        }
    });
});
