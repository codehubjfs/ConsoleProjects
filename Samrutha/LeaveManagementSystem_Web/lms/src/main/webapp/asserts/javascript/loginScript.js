function forgotPassword(){
  // Get the form element and login button
  const form = document.querySelector('form');
  const loginButton = document.querySelector('button');

  loginButton.addEventListener('click', (e) => {
      // Prevent the default form submission behavior
      e.preventDefault();

      // Check if all fields are filled
      const usernameField = document.getElementById('Username');
      const emailField = document.getElementById('email');

      // Regular expression for email validation
      const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

      if (usernameField.value && emailField.value && emailPattern.test(emailField.value)) {
          // Redirect to the corresponding dashboard based on the selected value
          alert('Request sent to the Admin successfully...!');
      } else {
          // Show an error message if any fields are empty or if the email format is invalid
          alert('Please enter valid data in all fields');
      }
  });
}

function validateForm() {
            var username = document.getElementById('Username').value;
            var password = document.getElementById('password').value;
            var usertype = document.getElementById('select').value;
            var validationMessage = "";

            // Reset validation messages
            document.getElementById('usernameFeedback').innerHTML = '';
            document.getElementById('passwordFeedback').innerHTML = '';
            document.getElementById('usertypeFeedback').innerHTML = '';

            if (username.trim() === "") {
                document.getElementById('usernameFeedback').innerHTML = 'Username is required.';
                validationMessage += "Username is required.<br>";
            }

            if (password.trim() === "") {
                document.getElementById('passwordFeedback').innerHTML = 'Password is required.';
                validationMessage += "Password is required.<br>";
            }

            if (usertype === "Select user type") {
                document.getElementById('usertypeFeedback').innerHTML = 'User type is required.';
                validationMessage += "User type is required.<br>";
            }

            if (validationMessage !== "") {
                return false;
            }

            return true;
        }

        document.getElementById('Username').addEventListener('input', function() {
            document.getElementById('usernameFeedback').innerHTML = '';
        });

        document.getElementById('password').addEventListener('input', function() {
            document.getElementById('passwordFeedback').innerHTML = '';
        });

        document.getElementById('select').addEventListener('change', function() {
            document.getElementById('usertypeFeedback').innerHTML = '';
        });



