<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Login - Hotel Booking App</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asserts/css/admin/index.css">
</head>
<style>
    body {
        background: rgba(0, 0, 0, 0.5) url('${pageContext.request.contextPath}/asserts/images/r4.jpg') no-repeat center center fixed;
        background-size: cover;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
        backdrop-filter: blur(3px); 
    }
</style>
<body>
    <div class="center-content">
        <h1>RK Hotel</h1>
    </div>
    <div class="container">
        <h2>Admin Login</h2>
        <form id="loginForm" action="${pageContext.request.contextPath}/adminLogin" onsubmit="validateForm(event)" method="post">
            <div class="form-group">
                <label for="login-username">Username</label>
                <input type="email" class="form-control" id="login-username" name="email">
                <div class="error-message text-danger" id="username-error"></div>
            </div>
            <div class="form-group">
                <label for="login-password">Password</label>
                <input type="password" class="form-control" id="login-password" name="password">
                <div class="error-message text-danger" id="password-error"></div>
            </div>
            <button type="submit" class="btn btn-primary btn-custom btn-block">Login</button>
            <c:if test="${not empty errorMessage}">
                <div class="alert alert-danger mt-2" role="alert">${errorMessage}</div>
            </c:if>
        </form>
        <div class="forgot-password">
            <a href="#" data-toggle="modal" data-target="#forgotPasswordModal">Forgot Password?</a>
        </div>
    </div>
    <!-- Forgot Password Modal -->
    <div class="modal fade" id="forgotPasswordModal" tabindex="-1" role="dialog" aria-labelledby="forgotPasswordModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="forgotPasswordModalLabel">Forgot Password</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form id="forgotPasswordForm" action="${pageContext.request.contextPath}/resetPassword" method="post">
                        <div class="form-group">
                            <label for="reset-email">Email</label>
                            <input type="email" class="form-control" id="reset-email" name="email" required>
                            <div class="error-message text-danger" id="reset-email-error"></div>
                        </div>
                        <div id="new-password-fields" style="display: none;">
                            <div class="form-group">
                                <label for="new-password">New Password</label>
                                <input type="password" class="form-control" id="new-password" name="newPassword">
                                <div class="error-message text-danger" id="new-password-error"></div>
                            </div>
                            <div class="form-group">
                                <label for="confirm-new-password">Confirm New Password</label>
                                <input type="password" class="form-control" id="confirm-new-password" name="confirmNewPassword">
                                <div class="error-message text-danger" id="confirm-new-password-error"></div>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
   
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script>
    function validateForm(event) {
        let valid = true;

        const username = document.getElementById('login-username').value.trim();
        const password = document.getElementById('login-password').value.trim();

        const usernameError = document.getElementById('username-error');
        const passwordError = document.getElementById('password-error');

        usernameError.textContent = '';
        passwordError.textContent = '';

        if (username === '') {
            usernameError.textContent = 'Please enter your username';
            valid = false;
        }

        if (password === '') {
            passwordError.textContent = 'Please enter your password';
            valid = false;
        }

        if (!valid) {
            event.preventDefault();
        }
    }
    </script>
    <script>
    document.getElementById('forgotPasswordForm').addEventListener('submit', function(event) {
    event.preventDefault();
    
    const email = document.getElementById('reset-email').value;
    const newPasswordFields = document.getElementById('new-password-fields');

    // Assuming AJAX is used to check if the email exists in the database
    fetch(`${pageContext.request.contextPath}/checkEmail`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ email: email })
    })
    .then(response => response.json())
    .then(data => {
        if (data.exists) {
            // Show new password fields
            newPasswordFields.style.display = 'block';
        } else {
            document.getElementById('reset-email-error').innerText = 'Email not found';
        }
    })
    .catch(error => console.error('Error:', error));
});
    </script>
</body>
</html>
