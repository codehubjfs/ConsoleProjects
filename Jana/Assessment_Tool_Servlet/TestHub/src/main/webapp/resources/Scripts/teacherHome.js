document.addEventListener('DOMContentLoaded', () => {
    fetchTeachers();

    // Function to show the appropriate section
    window.showSection = function(sectionId) {
        const sections = document.querySelectorAll('.content-section');
        sections.forEach(section => {
            section.style.display = 'none';
        });
        document.getElementById(sectionId).style.display = 'block';
    };

    window.enableCourseSelection = function() {
        const teacherId = document.getElementById('teacherId').value;
        const courseIdSelect = document.getElementById('courseId2');

        if (teacherId) {
            fetchCoursesForTeacher(teacherId);
            courseIdSelect.disabled = false;
        } else {
            courseIdSelect.disabled = true;
            courseIdSelect.innerHTML = '<option value="">Select Course</option>';
        }
    };

    window.fetchCoursesForTeacher = function(teacherId) {
        fetch(`fetchCourses?teacherId=${teacherId}`)
            .then(response => response.json())
            .then(data => {
                const courseIdSelect = document.getElementById('courseId2');
                courseIdSelect.innerHTML = '<option value="">Select Course</option>';
                data.forEach(course => {
                    const option = document.createElement('option');
                    option.value = course.courseId;
                    option.textContent = course.courseName;
                    courseIdSelect.appendChild(option);
                });
            })
            .catch(error => console.error('Error fetching courses:', error));
    };

    function fetchTeachers() {
        fetch('fetchTeachers')
            .then(response => response.json())
            .then(data => {
                const teacherIdSelect = document.getElementById('teacherId');
                teacherIdSelect.innerHTML = '<option value="">Select Teacher</option>';
                data.forEach(teacher => {
                    const option = document.createElement('option');
                    option.value = teacher.eId;
                    option.textContent = teacher.fName;
                    teacherIdSelect.appendChild(option);
                });
            })
            .catch(error => console.error('Error fetching teachers:', error));
    }

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

    window.editTeacher = function(button) {
        const row = button.parentElement.parentElement;
        const teacherId = row.cells[0].textContent;
        const email = row.cells[1].textContent;
        const firstName = row.cells[2].textContent;
        const lastName = row.cells[3].textContent;
        const gender = row.cells[4].textContent;
        const city = row.cells[5].textContent;
        const country = row.cells[6].textContent;

        document.getElementById('editTeacherId').value = teacherId;
        document.getElementById('editTeacherEmail').value = email;
        document.getElementById('editTeacherFirstName').value = firstName;
        document.getElementById('editTeacherLastName').value = lastName;
        document.getElementById('editTeacherGender').value = gender;
        document.getElementById('editTeacherCity').value = city;
        document.getElementById('editTeacherCountry').value = country;

        $('#teacherModal').modal('show');
    };

    window.deleteStudent = function(button) {
        var row = button.closest('tr');
        var sid = row.cells[0].innerText;

        // Attach the student ID to the delete button for reference
        document.getElementById('confirmDeleteButton').setAttribute('data-student-id', sid);

        // Display the student ID in the modal body
        document.getElementById('studentIdDisplay').innerText = sid;

        // Set the onclick attribute to direct to DeleteStudentServlet with the SID
        document.getElementById('confirmDeleteButton').setAttribute('onclick', 'window.location.href="DeleteStudentServlet?sid=' + encodeURIComponent(sid) + '"');

        // Show the modal
        $('#deleteConfirmationModal').modal('show');
    };

    window.deleteTeacher = function(button) {
        var row = button.closest('tr');
        var sid = row.cells[0].innerText;

        // Attach the student ID to the delete button for reference
        document.getElementById('confirmDeleteButton').setAttribute('data-student-id', sid);

        // Display the student ID in the modal body
        document.getElementById('studentIdDisplay').innerText = sid;

        // Set the onclick attribute to direct to DeleteTeacherServlet with the SID
        document.getElementById('confirmDeleteButton').setAttribute('onclick', 'window.location.href="DeleteTeacherServlet?sid=' + encodeURIComponent(sid) + '"');

        // Show the modal
        $('#deleteConfirmationModal').modal('show');
    };

    window.toggleStudentForm = function() {
        var formContainer = document.getElementById('addStudentForm');
        var toggleButton = document.getElementById('toggleStudentFormButton');
        if (formContainer.style.display === 'none') {
            formContainer.style.display = 'block';
            toggleButton.textContent = 'Close';
        } else {
            formContainer.style.display = 'none';
            toggleButton.textContent = 'Add Student';
        }
    };

    window.toggleTeacherForm = function() {
        var formContainer = document.getElementById('addTeacherForm');
        var toggleButton = document.getElementById('toggleTeacherFormButton');
        if (formContainer.style.display === 'none') {
            formContainer.style.display = 'block';
            toggleButton.textContent = 'Close';
        } else {
            formContainer.style.display = 'none';
            toggleButton.textContent = 'Add Teacher';
        }
    };

    window.fetchUnassignedStudents = function() {
        var courseId = document.getElementById("courseId2").value;
        if (courseId) {
            window.location.href = 'UnassignedStudentsServlet?courseId=' + encodeURIComponent(courseId);
        }
    };

    window.addStudent = function() {
        const email = document.getElementById('Semail').value;
        const firstName = document.getElementById('Sfname').value;
        const lastName = document.getElementById('Slname').value;
        const gender = document.getElementById('SGender').value;
        const city = document.getElementById('Scity').value;
        const country = document.getElementById('Scountry').value;
        const password = document.getElementById('Spassword').value;

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
        if (!validateCityCountry(city)) {
            document.getElementById('studentCityError').textContent = 'City is required and must not contain numeric digits or exceed 20 characters';
            valid = false;
        } else {
            document.getElementById('studentCityError').textContent = '';
        }
        if (!validateCityCountry(country)) {
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

        if (valid) {
            document.getElementById('addStudentForm').submit(); // Submit the form if valid
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
            document.getElementById('teacherPasswordError').textContent = 'Password must contain 1 special character, 1 uppercase letter, 1 lowercase letter, 1 numeric digit, and be between 8-20 characters long';
            valid = false;
        } else {
            document.getElementById('teacherPasswordError').textContent = '';
        }

        if (valid) {
            document.getElementById('addTeacherForm').submit(); // Submit the form if valid
        }
    };

    function validateEmail(email) {
        const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return re.test(email);
    }

    function validateName(name) {
        const re = /^[a-zA-Z]{1,20}$/;
        return re.test(name);
    }

    function validateCityCountry(name) {
        const re = /^[a-zA-Z\s]{1,20}$/;
        return re.test(name);
    }

    function validatePassword(password) {
        const re = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[\W_]).{8,20}$/;
        return re.test(password);
    }
});
