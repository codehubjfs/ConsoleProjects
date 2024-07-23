<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Invalid Login</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <style>
        body {
            background: linear-gradient(to right, #6a8cce, #6d9ad1);
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .gradient-custom {
            background: rgba(255, 255, 255, 0.8);
            border-radius: 1rem;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }
        .error-message {
            color: red;
            font-size: 20px;
            font-weight: bold;
        }
        .card-body h2 {
            font-size: 24px;
        }
    </style>
</head>
<body>
    <section class="gradient-custom p-4">
        <div class="container">
            <div class="row d-flex justify-content-center align-items-center">
                    <div class="card text-dark">
                        <div class="card-body p-5 text-center">
                            <h2 class="fw-bold mb-2">Login Failed</h2>
                            <p class="error-message">Invalid email or password. Please try again.</p>
                            <a href="view/Admin/Login.jsp" class="btn btn-primary btn-lg">Back to Login</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</body>
</html>
