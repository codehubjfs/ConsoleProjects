<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminstyles.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Admin Login</title>
</head>
<body>
    <nav class="container-fluid fixed-top bg-white">
        <div class="row align-items-center">
            <div class="text-start col-12">
                <a class="navbar-brand" href="#">
                    <img class="img-fluid" src="${pageContext.request.contextPath}/images/logo.png" height="122" width="216" alt="MDB Logo" loading="lazy" />
                </a>
            </div>
        </div>
    </nav>

    <div class="bg-light vh-100">
    <%
    response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0); %>
        <div id="outer-boxx" class="bg-white  shadow rounded">
            <div class="row px-0 mx-0">
                <div class="col-12 mt-0 px-0 pb-5">
                    <div class="bg-primary m-0 p-0 rounded-top mb-5">
                        <h3 class="text-white text-center p-5">Admin Login</h3>
                    </div>
                    <form method="post" action="${pageContext.request.contextPath}/AdminLoginController">
					    <div class="mx-5">
					        <div class="px-5 mt-4">
					            <label for="username" class="pb-2 px-2">Username</label>
					            <input type="text" id="username" name="username" class="form-control rounded-pill" oninput="validateForm()">
					            <div class="invalid-feedback" id="invalid-username">Invalid Username</div>
					        </div>
					        <div class="px-5 mt-4">
					            <label for="password" class="pb-2 px-2">Password</label>
					            <input type="password" id="password" name="password" class="form-control rounded-pill" oninput="validateForm()">
					             <div class="invalid-feedback" id="invalid-username">Invalid Password</div>
					            <p id="message"></p>
					        </div>
					     <!--     <div class="mt-2 text-end px-5">
					            <a href="#" class="text-decoration-none">Forget password?</a>
					        </div> -->
					         <div class="text-center mt-4">
					              <button type="submit" class="btn btn-outline-primary btn-lg rounded-pill px-5 disabled" id="login-btn" onclick="validateCredentials()">Login</button>
					              <div id="errorMessage" class="text-danger mt-3"><%= request.getAttribute("msg")!=null?request.getAttribute("msg"):"" %></div>
					         </div>
					    </div>
					</form>
                </div>
            </div>
        </div> 
    </div>

    <script>
        function validateForm() {
            const username = document.getElementById('username').value;
            const password = document.getElementById('password').value;
            const loginBtn = document.getElementById('login-btn');

            const isUsernameValid = /^[a-zA-Z0-9_]{5,}$/.test(username);
            const isPasswordValid = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,20}$/.test(password);

            if (isUsernameValid) {
                document.getElementById('username').classList.remove('is-invalid');
                document.getElementById('username').classList.add('is-valid');
            } else {
                document.getElementById('username').classList.remove('is-valid');
                document.getElementById('username').classList.add('is-invalid');
            }

            if (isPasswordValid) {
                document.getElementById('password').classList.remove('is-invalid');
                document.getElementById('password').classList.add('is-valid');
            } else {
                document.getElementById('password').classList.remove('is-valid');
                document.getElementById('password').classList.add('is-invalid');
            }

            if (isUsernameValid && isPasswordValid) {
                loginBtn.classList.remove('disabled');
            } else {
                loginBtn.classList.add('disabled');
            }
        }

        function validateCredentials() {
            const username = document.getElementById('username').value;
            const password = document.getElementById('password').value;
            
            if (username === 'admin_1' && password === '1234567@a') {
                alert('Login successful');
                window.location.href = './dashboard.jsp';
            } else {
                document.getElementById('errorMessage').style.display = 'block';
            }
        }
    </script>
</body>
</html>
