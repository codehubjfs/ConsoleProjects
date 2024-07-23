// Validation functions
document.addEventListener('DOMContentLoaded', () => {
    // Function to show the appropriate section
    window.showSection = function(sectionId) {
        const sections = document.querySelectorAll('.content-section');
        sections.forEach(section => {
            section.style.display = 'none';
        });
        document.getElementById(sectionId).style.display = 'block';
    };
    
    // Function to show the "Edit Student" modal with populated data
// Edit student
window.editStudent = function(button) {
    const row = button.parentElement.parentElement;
    const studentId = row.cells[0].textContent;
    const email = row.cells[1].textContent;
    const firstName = row.cells[2].textContent;
    const lastName = row.cells[3].textContent;
    const gender = row.cells[4].textContent;
    const city = row.cells[5].textContent;
    const country = row.cells[6].textContent;

    document.getElementById('editStudentId').value = studentId;
    document.getElementById('editStudentEmail').value = email;
    document.getElementById('editStudentFirstName').value = firstName;
    document.getElementById('editStudentLastName').value = lastName;
    document.getElementById('editStudentGender').value = gender;
    document.getElementById('editStudentCity').value = city;
    document.getElementById('editStudentCountry').value = country;

    $('#studentModal').modal('show');
};

// Function to confirm deletion of the student
// Function to show the "Delete Confirmation" modal
window.deleteStudent=function(button) {
    var row = button.closest('tr');
    var sid = row.cells[0].innerText;
    
    // Attach the student ID to the delete button for reference
    document.getElementById('confirmDeleteButton').setAttribute('data-student-id', sid);
    
    // Show the modal
    $('#deleteConfirmationModal').modal('show');
}

    window.addStudent = function() {
        const email = document.getElementById('studentEmail').value;
        const firstName = document.getElementById('studentFirstName').value;
        const lastName = document.getElementById('studentLastName').value;
        const gender = document.getElementById('studentGender').value;
        const city = document.getElementById('studentCity').value;
        const country = document.getElementById('studentCountry').value;
        const password = document.getElementById('studentPassword').value;
    
        let valid = true;
    
        if (!validateEmail(email)) {
            document.getElementById('studentEmailError').textContent = 'Invalid email';
            valid = false;
        } else {
            document.getElementById('studentEmailError').textContent = '';
        }
        if (!validateName(firstName)) {
            document.getElementById('studentFirstNameError').textContent = 'First name is required and must not contain numeric digits or exceed 20 characters';
            valid = false;
        } else {
            document.getElementById('studentFirstNameError').textContent = '';
        }
        if (!validateName(lastName)) {
            document.getElementById('studentLastNameError').textContent = 'Last name is required and must not contain numeric digits or exceed 20 characters';
            valid = false;
        } else {
            document.getElementById('studentLastNameError').textContent = '';
        }
        if (!gender) {
            document.getElementById('studentGenderError').textContent = 'Gender is required';
            valid = false;
        } else {
            document.getElementById('studentGenderError').textContent = '';
        }
        if (!validateName(city)) {
            document.getElementById('studentCityError').textContent = 'City is required and must not contain numeric digits or exceed 20 characters';
            valid = false;
        } else {
            document.getElementById('studentCityError').textContent = '';
        }
        if (!validateName(country)) {
            document.getElementById('studentCountryError').textContent = 'Country is required and must not contain numeric digits or exceed 20 characters';
            valid = false;
        } else {
            document.getElementById('studentCountryError').textContent = '';
        }
        if (!validatePassword(password)) {
            document.getElementById('studentPasswordError').textContent = 'Password must contain 1 special character, 1 uppercase letter, 1 lowercase letter, 1 numeric digit, and be between 8-20 characters long';
            valid = false;
        } else {
            document.getElementById('studentPasswordError').textContent = '';
        }
    
        if (!valid) return;
    
    };
    

    
    
    window.allocateCourseTeacher = function() {
        // Get the values of the course and teacher dropdowns
        var courseId = document.getElementById('courseId2').value;
        var teacherId = document.getElementById('teacherId').value;
    
        // Validate the inputs
        var isValid = true;
        if (!courseId) {
            document.getElementById('courseIdError1').textContent = 'Please select a course';
            isValid = false;
        } else {
            document.getElementById('courseIdError1').textContent = '';
        }
        if (!teacherId) {
            document.getElementById('teacherIdError').textContent = 'Please select a teacher';
            isValid = false;
        } else {
            document.getElementById('teacherIdError').textContent = '';
        }
    
 
    };

    window.allocateCourseStudent = function() {
        // Get the values of the course and student dropdowns
        var courseId = document.getElementById('courseId').value;
        var studentId = document.getElementById('studentId').value;
    
        // Validate the inputs
        var isValid = true;
        if (!courseId) {
            document.getElementById('courseIdError').textContent = 'Please select a course';
            isValid = false;
        } else {
            document.getElementById('courseIdError').textContent = '';
        }
        if (!studentId) {
            document.getElementById('studentIdError').textContent = 'Please select a student';
            isValid = false;
        } else {
            document.getElementById('studentIdError').textContent = '';
        }
    
       
    };
    
    window.addTeacher = function() {
        const email = document.getElementById('teacherEmail').value;
        const firstName = document.getElementById('teacherFirstName').value;
        const lastName = document.getElementById('teacherLastName').value;
        const gender = document.getElementById('teacherGender').value;
        const city = document.getElementById('teacherCity').value;
        const country = document.getElementById('teacherCountry').value;
        const password = document.getElementById('teacherPassword').value;
    
        let valid = true;
    
        if (!validateEmail(email)) {
            document.getElementById('teacherEmailError').textContent = 'Invalid email';
            valid = false;
        } else {
            document.getElementById('teacherEmailError').textContent = '';
        }
        if (!validateName(firstName)) {
            document.getElementById('teacherFirstNameError').textContent = 'First name is required and must not contain numeric digits or exceed 20 characters';
            valid = false;
        } else {
            document.getElementById('teacherFirstNameError').textContent = '';
        }
        if (!validateName(lastName)) {
            document.getElementById('teacherLastNameError').textContent = 'Last name is required and must not contain numeric digits or exceed 20 characters';
            valid = false;
        } else {
            document.getElementById('teacherLastNameError').textContent = '';
        }
        if (!gender) {
            document.getElementById('teacherGenderError').textContent = 'Gender is required';
            valid = false;
        } else {
            document.getElementById('teacherGenderError').textContent = '';
        }
        if (!validateCityCountry(city)) {
            document.getElementById('teacherCityError').textContent = 'City is required and must not contain numeric digits or exceed 20 characters';
            valid = false;
        } else {
            document.getElementById('teacherCityError').textContent = '';
        }
        if (!validateCityCountry(country)) {
            document.getElementById('teacherCountryError').textContent = 'Country is required and must not contain numeric digits or exceed 20 characters';
            valid = false;
        } else {
            document.getElementById('teacherCountryError').textContent = '';
        }
        if (!validatePassword(password)) {
            document.getElementById('teacherPasswordError').textContent = 'Password must contain at least one uppercase letter, one lowercase letter, one numeric digit, and one special character, and be 8-20 characters long';
            valid = false;
        } else {
            document.getElementById('teacherPasswordError').textContent = '';
        }
    
        if (!valid) return;
    
    };
    
    // Email validation function
    function validateEmail(email) {
        const re = /^[^\s@]+@[^\s@]+\.[^\s@]{2,30}$/;
        return re.test(email);
    }

    // Name, City, Country validation function
function validateName(value) {
    const re = /^[A-Za-z\s]{1,20}$/;
    return re.test(value);
}

function validateCityCountry(value) {
    const re = /^[A-Za-z\s]{1,20}$/;
    return re.test(value);
}

// Password validation function
function validatePassword(password) {
    const re = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[\W_]).{8,20}$/;
    return re.test(password);
}
    

    











// JavaScript for Admin Portal

// Toggle sidebar
document.getElementById("menu-toggle").addEventListener("click", function(e) {
    e.preventDefault();
    document.getElementById("wrapper").classList.toggle("toggled");
});

// Show specific section


// Logout function
function logout() {
    
    window.location.href = "Home/index.html";
}




// Generate reports
// Function to generate reports
window.reportsmanagement = function() {
    const studentsInCoursesCtx = document.getElementById('studentsInCoursesChart').getContext('2d');
    const studentsInCoursesChart = new Chart(studentsInCoursesCtx, {
        type: 'bar',
        data: {
            labels: ['Course 1', 'Course 2', 'Course 3', 'Course 4', 'Course 5'],
            datasets: [{
                label: 'Number of Students',
                data: [12, 19, 3, 5, 2],
                backgroundColor: 'rgba(54, 162, 235, 0.2)',
                borderColor: 'rgba(54, 162, 235, 1)',
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

    const studentPerformanceCtx = document.getElementById('studentPerformanceChart').getContext('2d');
    const studentPerformanceChart = new Chart(studentPerformanceCtx, {
        type: 'line',
        data: {
            labels: ['Week 1', 'Week 2', 'Week 3', 'Week 4', 'Week 5'],
            datasets: [{
                label: 'Student Performance',
                data: [65, 59, 80, 81, 56],
                backgroundColor: 'rgba(153, 102, 255, 0.2)',
                borderColor: 'rgba(153, 102, 255, 1)',
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

    const assessmentsInCoursesCtx = document.getElementById('assessmentsInCoursesChart').getContext('2d');
    const assessmentsInCoursesChart = new Chart(assessmentsInCoursesCtx, {
        type: 'pie',
        data: {
            labels: ['Course 1', 'Course 2', 'Course 3', 'Course 4', 'Course 5'],
            datasets: [{
                label: 'Assessments',
                data: [5, 10, 15, 20, 25],
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
            responsive: true
        }
    });
}

// Call the function to generate reports once the DOM is fully loaded
document.addEventListener('DOMContentLoaded', generateReports);

});