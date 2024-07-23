<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Form</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/AdminStyle.css">
    
    <style>
        body {
            background: linear-gradient(to right, #6a8cce, #6d9ad1); 
        }
        .gradient-custom {
            padding-top: 60px;
            height: 30px !important;
        }
        .form-control {
            color: rgb(25, 25, 25) !important;
            border: 1px solid #ccc;
        }
        .form-control::placeholder {
            color: #ccc;
            opacity: 1;
            font-size: 20px;
        }
        .teemail {
            text-align: left;
            margin-left: 5px;
            font-size: 16px;
            padding-bottom: 4px;
            font-family: sans-serif;
        }
        .error-message {
            color: red;
            font-size: 17px;
            margin-top: 5px;
            text-align: left;
        }
        #loginButton {
            background-color: #13377c;
            color: #b8e906;
            font-weight: bold;
            font-size: 23px;
        }
        .right-align {
            padding-left: 75%;
            color: #b8e906 !important;
        }
        .invalid-feedback {
            text-align: left;
        }
       .no-hover {
        color: black;
        text-decoration: none;
    }
    .no-hover:hover {
        color: #2335d7!important; 
        text-decoration: none;
    }
    </style>
</head>
<body>
    <header>
        <nav>
            <ul class="pt-3">
                <li><img src="${pageContext.request.contextPath}/Images/image1.png" alt="logo"></li>
                <li>Joy Rider</li>
                <li class="right-align"><a href="customer" class="text-decoration-none text-primary"><i class="fas fa-home"></i> view website</a></li>
            </ul>
        </nav>
    </header>
    <section class="vh-100 gradient-custom">
        <div class="container py-5 h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                    <div class="card text-dark" style="border-radius: 1rem;">
                        <div class="card-body p-5 text-center">
                            <div class="mb-md-5 mt-md-4 pb-5">
                                <h2 class="fw-bold mb-2 text-uppercase texts">Login</h2>
                                <p class="text-dark-50 mb-5 texts">Enter your Email and Password!</p>

                                <form action="loginnew" id="loginForm"  class="needs-validation" novalidate>
                                    <div class="form-outline form-white mb-4">
                                        <div class="teemail texts">
                                            <label for="typeEmailX">Email</label>
                                        </div>
                                        <input type="email" id="typeEmailX" name="email" class="form-control form-control-lg" placeholder="Type your email" required/>
                                        <div class="invalid-feedback">
                                            Please enter a valid email address.
                                        </div>
                                    </div>

                                    <div class="form-outline form-white mb-4">
                                        <div class="teemail texts">
                                            <label for="typePasswordX">Password</label>
                                        </div>
                                        <input type="password" id="typePasswordX" name="password" class="form-control form-control-lg" placeholder="Type your password" required/>
                                        <div class="invalid-feedback">
                                            Please enter your password.
                                        </div>
                                    </div>

                                    <p class="small mb-5 pb-lg-2 text-end ">
                                        <a class="text-dark-50 text-decoration-none no-hover" href="ForgotPassword.jsp">Forgot password?</a>
                                    </p>

                                    <button id="loginButton" class="btn btn-outline-dark btn-lg px-5" type="submit">Login</button>
                                    <div id="alertMessage" class="text-danger mt-3" style="display: none;">
                                        Please enter a valid email and password!
                                    </div>
                                    <p>${error}</p> 
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
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
                            document.getElementById('alertMessage').style.display = 'block';
                        } else {
                            document.getElementById('alertMessage').style.display = 'none';
                        }
                        form.classList.add('was-validated');
                    }, false);
                });
            }, false);
        })();
   
        /*document.addEventListener('DOMContentLoaded', (event) => {
            // Prevent navigating forward to the dashboard
            if (window.history && window.history.pushState) {
                window.history.pushState(null, null, document.title);
                window.history.pushState(null, null, document.title);
                window.history.go(-1);

                window.onpopstate = function () {
                    window.history.go(-1);
                };
            }
        });*/
    </script>
</body>
</html>
