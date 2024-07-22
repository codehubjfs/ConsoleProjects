function forgotPassword() {
    // Get the form element and login button
    const form = document.querySelector('form');
    const loginButton = document.querySelector('button');

    loginButton.addEventListener('click', (e) => {
        // Prevent the default form submission behavior
        e.preventDefault();

        // Check if all fields are filled
        const usernameField = document.getElementById('Username');
        const emailField = document.getElementById('email');
        const usernameFeedback = document.getElementById('usernameFeedback');
        const emailFeedback = document.getElementById('emailFeedback');

        // Regular expression for email validation
        const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

        let valid = true;

        // Reset feedback messages
        usernameFeedback.textContent = '';
        emailFeedback.textContent = '';

        if (!usernameField.value) {
            usernameFeedback.textContent = 'Username is required';
            valid = false;
        }

        if (!emailField.value) {
            emailFeedback.textContent = 'Email is required';
            valid = false;
        } else if (!emailPattern.test(emailField.value)) {
            emailFeedback.textContent = 'Invalid email format';
            valid = false;
        }

        if (valid) {
            form.submit();
        }
    });

    return false; // To prevent the form from submitting immediately
}

		document.getElementById('Username').addEventListener('input', function() {
            validateUsername();
        });

        document.getElementById('password').addEventListener('input', function() {
            validatePassword();
        });

        document.getElementById('select').addEventListener('change', function() {
            validateUsertype();
        });

        function validateUsername() {
            var username = document.getElementById('Username').value;
            if (username.trim() === "") {
                document.getElementById('usernameFeedback').innerHTML = 'Username is required.';
                return false;
            } else {
                document.getElementById('usernameFeedback').innerHTML = '';
                return true;
            }
        }

        function validatePassword() {
            var password = document.getElementById('password').value;
            if (password.trim() === "") {
                document.getElementById('passwordFeedback').innerHTML = 'Password is required.';
                return false;
            } else {
                document.getElementById('passwordFeedback').innerHTML = '';
                return true;
            }
        }

        function validateUsertype() {
            var usertype = document.getElementById('select').value;
            if (usertype === "Select user type") {
                document.getElementById('usertypeFeedback').innerHTML = 'User type is required.';
                return false;
            } else {
                document.getElementById('usertypeFeedback').innerHTML = '';
                return true;
            }
        }

        function validateForm() {
            var isUsernameValid = validateUsername();
            var isPasswordValid = validatePassword();
            var isUsertypeValid = validateUsertype();

            return isUsernameValid && isPasswordValid && isUsertypeValid;
        }