<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Forgot Password</title>
    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: url('../../Images/password.png');
            background-repeat: no-repeat;
            background-size: cover;
            height: 100vh;
            margin: 0;
            display: flex;
            flex-direction: column; 
        }

        header {
            background-color: #ffffff; 
            padding: 10px 20px; 
        }

       .navbar {
    display: flex;
    justify-content: space-between;
    align-items: center;
    list-style-type: none;
    margin: 0;
    padding: 10px 20px; 
    background-color: #163c83; 
    font-size:25px;
}


        .navbar img {
            height: 40px; 
            margin-right: 10px; 
        }

        .navbar .right-align {
            margin-left: auto; 
        }

        .navbar a {
            text-decoration: none; 
            color: #000000; 
        }

        .navbar a:hover {
            color: #007bff; 
        }

        .card {
            margin-top: 200px;
            border-radius: 1rem;
            width: 30rem; 
            padding: 20px;
            height: 400px; 
            margin-left: 100px; 
            background-color: rgb(192, 221, 252);
        }

        .form-control {
            border: 1px solid #ccc;
            color: #333;
        }

        .form-control::placeholder {
            color: #ccc;
            opacity: 1;
            font-size: 16px;
        }

        .form-outline {
            text-align: left; 
        }

        .btn-primary {
            background-color: #13377c;
            color: #b8e906;
            font-weight: bold;
        }

        .btn-primary:hover {
            background-color: #0e2a62;
            color: #a6d205;
        }

        .feedback {
            text-align: center;
            margin-top: 10px;
        }

        .invalid-feedback {
            color: red;
            font-size: 17px;
            text-align: left;
        }
    </style>
</head>
<body>
    <header>
        <nav>
            <ul class="navbar pt-3">
                <li><img src="../../Images/image1.png" alt="logo"></li>
                <li>Joy Rider</li>
                <li class="right-align"><a href="http://127.0.0.1:5500/customer/index.html" class="text-decoration-none text-primary"><i class="fas fa-home"></i> View Website</a></li>
            </ul>
        </nav>
    </header>
    <div class="card text-dark p-5">
        <div class="card-body">
            <h2 class="fw-bold mb-4 text-center">Forgot Password</h2>
            <form action="${pageContext.request.contextPath}/ForgotPasswordController" method="post" class="needs-validation" novalidate>
                <div class="form-outline mb-4">
                    <label for="email" class="form-label">Email</label>
                    <input type="email" id="email" name="email" class="form-control form-control-lg" placeholder="Type your email" required/>
                    <div class="invalid-feedback">
                        Please enter a valid email address.
                    </div>
                </div>
                <button type="submit" class="btn btn-primary btn-lg w-100">Submit</button>
                <div class="feedback text-danger">
                    ${errorMessage}
                </div>
                <div class="feedback text-success">
                    ${successMessage}
                </div>
            </form>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <script>
        (function () {
            'use strict';

            window.addEventListener('load', function () {
                var forms = document.getElementsByClassName('needs-validation');

                var validation = Array.prototype.filter.call(forms, function (form) {
                    form.addEventListener('submit', function (event) {
                        if (form.checkValidity() === false) {
                            event.preventDefault();
                            event.stopPropagation();
                        }
                        form.classList.add('was-validated');
                    }, false);
                });
            }, false);
        })();
    </script>
</body>
</html>
