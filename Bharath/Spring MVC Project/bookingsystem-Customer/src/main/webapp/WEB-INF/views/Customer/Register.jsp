<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="Registerac.css">
    <script src="customerreg.js" defer></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <title>Register</title>
    <style>
        body {
            font-family: 'Poppins', sans-serif;
        }

        #ids {
            background-color: rgb(241, 240, 247);
            margin-bottom: 10px;
            position: sticky;
            top: 0px;
            z-index: 1;
        }

        h1 {
            color: rgb(36, 36, 52)!important;
            font-size: 27px!important;
            font-family: 'Roboto', sans-serif!important;
            font-weight: bolder!important;
            text-align: left!important;
        }

        .ud {
            position: relative;
            display: inline-block;
        }

        .us {
            font-family: 'Roboto', sans-serif!important;
            font-weight: 600;
        }

        .usd {
            font-weight: 400;
        }

        .bsd {
            font-weight: bold;
        }

        .ud::after {
            content: '';
            position: absolute;
            left: 0;
            bottom: -4px;
            width: 100%;
            height: 4px;
            background-color: rgb(65, 86, 246);
            z-index: 2;
        }

        .reds {
            color: red;
            font-weight: bold;
        }

        .space {
            margin-left: 100px;
        }

        .bgcolor {
            background-color: rgb(241, 240, 247);
            color: white;
            text-decoration: none!important;
        }

        .fse {
            font-size: 17px;
            font-weight: 450;
            color: rgba(43, 80, 182, 0.938)!important;
        }

        #navlin {
            font-weight: 600;
            padding-left: 10px;
        }

        #navlin a {
            text-decoration: none!important;
            font-weight: 700;
        }

        #form {
            width: 680px;
            margin-left: auto;
            margin-right: auto;
            background-color: rgb(239, 239, 252);
            border-radius: 5px;
            padding: 30px;
        }
        a:hover {
    color: rgb(241, 6, 190) !important;
}

.navbar-nav .nav-link.active {
    background: #243346;
    color: white !important;
    height: auto;
}


        h1 {
            text-align: center;
            color: #792099;
        }

        #form button {
            background-color: #2335d7;
            color: white;
            border: 1px solid #792099;
            border-radius: 5px;
            padding: 10px;
            margin: 20px 0px;
            cursor: pointer;
            font-size: 20px;
            width: 100%;
        }

        .input-group {
            display: flex;
            flex-direction: column;
            margin-bottom: 15px;
        }

        .input-group.row {
            display: flex;
            flex-direction: row;
            justify-content: space-between;
        }

        .input-group input {
            border-radius: 5px;
            font-size: 20px;
            margin-top: 5px;
            padding: 10px;
            border: 1px solid rgb(34, 193, 195);
        }

        .input-group input:focus {
            outline: 0;
        }

        .input-group .error {
            color: rgb(242, 18, 18);
            font-size: 16px;
            margin-top: 5px;
        }

        .input-group.success input {
            border-color: #0cc477;
        }

        .input-group.error input {
            border-color: rgb(206, 67, 67);
        }

        .sh a {
            text-decoration: none!important;
        }

        .success-message {
            color: green;
            font-size: 14px;
            margin-top: 10px;
            text-align: center;
        }
        
    </style>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light sticky-header" id="ids">
    <div class="container-fluid">
        <img src="${pageContext.request.contextPath}/Images/Joylogo.png" alt="logo" width="60px" height="50px">
        <a class="navbar-brand pt-1 p-3 d-flex align-items-center fs-4" href="#">
            <span class="text-primary fontsw fw-bold pt-2">Joy<span class="text-success ms-2">R</span>ider</span>
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto mb-auto mb-lg-0 fs-5 space">
                <li class="nav-item fcolor"><a class="nav-link fse ms-5" aria-current="page" href="home">Home</a></li>
                <li class="nav-item fcolor"><a class="nav-link fse ms-5" aria-current="page" href="about">About us</a></li>
                <li class="nav-item fcolor"><a class="nav-link fse ms-5" aria-current="page" href="book">Booking</a></li>
                <li class="nav-item active fcolor"><a class="nav-link fse ms-5" aria-current="page" href="contact">Contact us</a></li>
                <%@ page import="com.bus.model.CustomersNew" %>
                	<%
				    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); 
				    response.setHeader("Pragma", "no-cache"); 
				    response.setDateHeader("Expires", 0); 
				%>
                <%
                    CustomersNew customers = (CustomersNew) session.getAttribute("customersNew");
                    if (customers != null) {
                %>
                <li class="nav-item fcolor"><a class="nav-link fse ms-5" href="cancel">Cancel Booking</a></li>
                <li class="nav-item fcolor"><a class="nav-link fse ms-5" href="view">View Booking</a></li>
                <li class="nav-item fcolor"><a class="nav-link fse ms-5" href="logout">Logout</a></li>
                <li class="nav-item fcolor"><span class="nav-link fse ms-5"><%= customers.getFirstName() %> <%= customers.getLastName() %></span></li>
                <% } else { %>
                <li class="nav-item fcolor"><a class="nav-link active fse ms-5" aria-current="page" href="login">Login/Register</a></li>
                <% } %>
            </ul>
        </div>
    </div>
</nav>
    <div class="container">
 <form id="form" action="register" onsubmit="return validateForm()">
        <h1><span class="ud">Re</span>gistration</h1>
        <p>Enter your details to register</p>
        <div class="input-group row">
            <div class="col">
                <label for="firstname"><span class="us">First Name</span> <span class="reds">*</span></label>
                <input type="text" id="firstname" name="firstname" placeholder="Enter your first name" oninput="validateFirstName()">
                <div class="error" id="firstname_error"></div>
            </div>
            <div class="col">
                <label for="lastname"><span class="us">Last Name</span> <span class="reds">*</span></label>
                <input type="text" id="lastname" name="lastname" placeholder="Enter your last name" oninput="validateLastName()">
                <div class="error" id="lastname_error"></div>
            </div>
        </div>
        <div class="input-group">
            <label for="username"><span class="us">Username</span> <span class="reds">*</span></label>
            <input type="text" id="username" name="username" placeholder="Enter your username" oninput="validateUsername()">
            <div class="error" id="username_error"></div>
        </div>
        <div class="input-group">
            <label for="email"><span class="us">Email</span> <span class="reds">*</span></label>
            <input type="email" id="email" name="email" placeholder="Enter your email" oninput="validateEmail()">
            <div class="error" id="email_error"></div>
        </div>
          <c:if test="${not empty error}">
                    <div class="text-danger">${error}</div>
                </c:if>
        <div class="input-group">
            <label for="gender"><span class="us">Gender</span> <span class="reds">*</span></label>
            <div>
                <input type="radio" id="male" name="gender" value="male" onclick="validateGender()">
                <label for="male">Male</label>
                <input type="radio" id="female" name="gender" value="female" onclick="validateGender()">
                <label for="female">Female</label>
            </div>
            <div class="error" id="gender_error"></div>
        </div>
        <div class="input-group">
            <label for="password"><span class="us">Password</span> <span class="reds">*</span></label>
            <input type="password" id="password" name="password" placeholder="Enter your password" oninput="validatePassword()">
            <div class="error" id="password_error"></div>
        </div>
        <div class="input-group">
            <label for="phone"><span class="us">Phone Number</span> <span class="reds">*</span></label>
            <input type="tel" id="phone" name="phone" placeholder="Enter your phone number" oninput="validatePhoneNumber()">
            <div class="error" id="phone_error"></div>
        </div>
            <button type="submit">Register</button>
            <p class="sh">Already have an account?<a href="login"><span class="usd"> Sign in</span></a></p>
        </form>

    </div>
</body>


<script>
    function validateForm() {
        // Reset error messages
        resetErrors();

        // Validate each field
        let isValid = true;
        if (!validateFirstName()) isValid = false;
        if (!validateLastName()) isValid = false;
        if (!validateUsername()) isValid = false;
        if (!validateEmail()) isValid = false;
        if (!validateGender()) isValid = false;
        if (!validatePassword()) isValid = false;
        if (!validatePhoneNumber()) isValid = false;

        return isValid;
    }

    function validateFirstName() {
        let firstname = document.getElementById('firstname').value.trim();
        let firstname_error = document.getElementById('firstname_error');
        if (firstname === '') {
            firstname_error.textContent = 'First Name cannot be empty';
            return false;
        } else if (!/^[a-zA-Z]+$/.test(firstname)) {
            firstname_error.textContent = 'First Name must contain only letters';
            return false;
        } else if (firstname.length < 3) {
            firstname_error.textContent = 'First Name must be at least 3 characters';
            return false;
        } else {
            firstname_error.textContent = '';
            return true;
        }
    }

    function validateLastName() {
        let lastname = document.getElementById('lastname').value.trim();
        let lastname_error = document.getElementById('lastname_error');
        if (lastname === '') {
            lastname_error.textContent = 'Last Name cannot be empty';
            return false;
        } else if (!/^[a-zA-Z]+$/.test(lastname)) {
            lastname_error.textContent = 'Last Name must contain only letters';
            return false;
        } else {
            lastname_error.textContent = '';
            return true;
        }
    }

    function validateUsername() {
        let username = document.getElementById('username').value.trim();
        let username_error = document.getElementById('username_error');
        if (username === '') {
            username_error.textContent = 'Username cannot be empty';
            return false;
        } else {
            username_error.textContent = '';
            return true;
        }
    }

    function validateEmail() {
        let email = document.getElementById('email').value.trim();
        let email_error = document.getElementById('email_error');
        if (email === '') {
            email_error.textContent = 'Email cannot be empty';
            return false;
        } else if (!/^\S+@\S+\.\S+$/.test(email)) {
            email_error.textContent = 'Please enter a valid email address';
            return false;
        } else {
            email_error.textContent = '';
            return true;
        }
    }

    function validateGender() {
        let gender_error = document.getElementById('gender_error');
        if (!document.getElementById('male').checked && !document.getElementById('female').checked) {
            gender_error.textContent = 'Please select your gender';
            return false;
        } else {
            gender_error.textContent = '';
            return true;
        }
    }

    function validatePassword() {
        let password = document.getElementById('password').value;
        let password_error = document.getElementById('password_error');
        if (password === '') {
            password_error.textContent = 'Password cannot be empty';
            return false;
        } else if (password.length < 8 || !/[a-z]/.test(password) || !/[A-Z]/.test(password) || !/[0-9]/.test(password) || !/[!@#$%^&*]/.test(password)) {
            password_error.textContent = 'Password must be at least 8 characters long and include at least one lowercase, one uppercase, one number, and one special character (!@#$%^&*)';
            return false;
        } else {
            password_error.textContent = '';
            return true;
        }
    }

    function validatePhoneNumber() {
        let phone = document.getElementById('phone').value.trim();
        let phone_error = document.getElementById('phone_error');
        if (phone === '') {
            phone_error.textContent = 'Phone number cannot be empty';
            return false;
        } else if (!/^[6-9]\d{9}$/.test(phone)) {
            phone_error.textContent = 'Please enter a valid 10-digit phone number starting with 6, 7, 8, or 9';
            return false;
        } else {
            phone_error.textContent = '';
            return true;
        }
    }

    function resetErrors() {
        let errorElements = document.getElementsByClassName('error');
        for (let i = 0; i < errorElements.length; i++) {
            errorElements[i].textContent = '';
        }
    }
</script>
    </script>
</html>
