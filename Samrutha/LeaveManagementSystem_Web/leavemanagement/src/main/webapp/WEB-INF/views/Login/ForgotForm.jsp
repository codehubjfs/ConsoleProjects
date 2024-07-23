<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>LMS</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/asserts/css/style.css">
</head>
<body>
    <header>
        <div id="header-img"><img src="${pageContext.request.contextPath}/asserts/images/image1.png"></div>
        <div id="header-content"><h1>LEAVE MANAGEMENT SYSTEM</h1></div>
    </header>
    <div class="container-fluid p-5"> <!-- Added container-fluid class to make the container responsive -->
        <div class="row justify-content-center mb-5"> 
        <!-- Added row and justify-content-center to center the form horizontally -->
            <div class="col-md-4 col-sm-12 bg-white rounded shadow-lg p-3"> <!-- Made the form width responsive using col-md-4 and col-sm-12 -->
                <div class="container-image">
		            <img src="${pageContext.request.contextPath}/asserts/images/image1.png" class="rounded">
		        </div>
                <h3>Reset Password</h3>
                <form action="forgetpassword" onsubmit="return forgotPassword()">
				    <div class="mb-3">
				        <label for="Username" class="form-label">Username</label>
				        <input type="text" class="form-control" id="Username" placeholder="Enter Username">
				        <span id="usernameFeedback" style="color: red;"></span>
				    </div>
				    <div class="mb-3">
				        <label for="email" class="form-label">Email</label>
				        <input type="email" class="form-control" id="email" placeholder="Enter Email">
				        <span id="emailFeedback" style="color: red;"></span>
				    </div>
				    <span id="genericFeedback" style="color: red;"></span><br> <!-- Added span for generic feedback -->
				    <button type="submit" class="mx-auto btn btn-primary">Send Request</button> <!-- Made the button full-width using w-100 -->
				</form>
            </div>
        </div>
    </div>   
    <script src="${pageContext.request.contextPath}/asserts/javascript/loginScript.js"></script>
    <script>
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
            const genericFeedback = document.getElementById('genericFeedback');

            // Regular expression for email validation
            const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

            let valid = true;

            // Reset feedback messages
            usernameFeedback.textContent = '';
            emailFeedback.textContent = '';
            genericFeedback.textContent = '';

            if (!usernameField.value && !emailField.value) {
                genericFeedback.textContent = 'Enter the required data';
                valid = false;
            } else {
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
            }

            if (valid) {
                form.submit();
            }
        });

        return false; // To prevent the form from submitting immediately
    }
    </script>
</body>
</html>
