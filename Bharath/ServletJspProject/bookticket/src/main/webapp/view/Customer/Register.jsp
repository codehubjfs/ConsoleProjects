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
            <img src="image/image1.png" alt="logo" width="50px" height="50px">
            <a class="navbar-brand pt-1 p-3 d-flex-align-items-center fs-4" href="#">
                <span class="text-primary fw-bold">Joy<span class="text-success ms-2">R</span>ider</span> 
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mb-auto mb-lg-0 fs-5 space">
                    <li class="nav-item fcolor">
                        <a class="nav-link active fse ms-1" aria-current="page" href="http://127.0.0.1:5500/customer/index.html">Home</a>
                    </li>
                    <li class="nav-item fcolor">
                        <a class="nav-link fse ms-5" aria-current="page" href="http://127.0.0.1:5500/customer/Aboutus/About.html">About us</a>
                    </li>
                    <li class="nav-item fcolor">
                        <a class="nav-link fse ms-5" aria-current="page" href="http://127.0.0.1:5500/customer/Booking/Book.html">Booking</a>
                    </li>
                    <li class="nav-item fcolor">
                        <a class="nav-link fse ms-5" aria-current="page" href="http://127.0.0.1:5500/customer/Contactus/Contact.html">Contact us</a>
                    </li>
                    <li class="nav-item fcolor">
                        <a class="nav-link fse ms-5" aria-current="page" href="http://127.0.0.1:5500/customer/Login/customerlogin.html">Login/Register</a>
                    </li>
                    <li class="nav-item fcolor">
                        <img src="Images/account.png" class="mt-1 ms-0" alt="" width="30px">
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="bgcolor">
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item" id="navlin"><a href="http://127.0.0.1:5500/customer/index.html">Home</a></li>
                <li class="breadcrumb-item active" aria-current="page">Register</li>
            </ol>
        </nav>
    </div>
    <div class="container">
        <form id="form" action="Register" onsubmit="return validateForm()">
            <h1><span class="ud">Re</span>gistration</h1>
            <p>Enter your details to register</p>
            <br>
            <div class="input-group row">
                <div class="col">
                    <label for="firstname"><span class="us">First Name</span> <span class="reds">*</span></label>
                    <input type="text" id="firstname" name="firstname" placeholder="Enter your first name">
                    <div class="error" id="firstname_error"></div>
                </div>
                <div class="col">
                    <label for="lastname"><span class="us">Last Name</span> <span class="reds">*</span></label>
                    <input type="text" id="lastname" name="lastname" placeholder="Enter your last name">
                    <div class="error" id="lastname_error"></div>
                </div>
            </div>
            <div class="input-group">
                <label for="username"><span class="us">Username</span> <span class="reds">*</span></label>
                <input type="text" id="username" name="username" placeholder="Enter your username">
                <div class="error" id="username_error"></div>
            </div>
            <div class="input-group">
                <label for="email"><span class="us">Email</span> <span class="reds">*</span></label>
                <input type="email" id="email" name="email" placeholder="Enter your email">
                <div class="error" id="email_error"></div>
            </div>
            <div class="input-group">
                <label for="gender"><span class="us">Gender</span> <span class="reds">*</span></label>
                <div>
                    <input type="radio" id="male" name="gender" value="male">
                    <label for="male">Male</label>
                    <input type="radio" id="female" name="gender" value="female">
                    <label for="female">Female</label>
                </div>
                <div class="error" id="gender_error"></div>
            </div>
            <div class="input-group">
                <label for="password"><span class="us">Password</span> <span class="reds">*</span></label>
                <input type="password" id="password" name="password" placeholder="Enter your password">
                <div class="error" id="password_error"></div>
            </div>
            <div class="input-group">
                <label for="phone"><span class="us">Phone Number</span> <span class="reds">*</span></label>
                <input type="tel" id="phone" name="phone" placeholder="Enter your phone number">
                <div class="error" id="phone_error"></div>
            </div>
            <button type="submit">Register</button>
            <p class="sh">Already have an account?<a href="customerlogin.html"><span class="usd"> Sign in</span></a></p>
        </form>
        <div class="success-message" id="success-message"></div>
    </div>
</body>
</html>
