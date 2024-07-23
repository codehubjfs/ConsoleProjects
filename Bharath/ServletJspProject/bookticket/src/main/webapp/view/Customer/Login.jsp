<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous">
    </script>
    <link rel="stylesheet" href="LoginStyle.css">
    <title>Bus Booking Login</title>
    <style>
    
body{
    font-family: Arial, sans-serif;
	background-image: url("../../Images/imagebig.jpg");
	background-repeat: no-repeat; 
	background-size: cover;
}

#ids{
    background-color: rgb(241, 240, 247);
    margin-bottom: 10px;
    position:sticky;
    top:0px;
    z-index: 1;
}
.space{
    margin-left:100px;
    /* word-spacing: 20px; */
}
.bgcolor{
    background-color: rgb(241, 240, 247);
    color: white;
	text-decoration: none!important;
}
.fse{
    font-size: 17px;
    font-weight:450;
    color: rgba(43, 80, 182, 0.938)!important;
}
#navlin {
    font-weight: 600;
    padding-left: 10px;
  }
#navlin a{
    text-decoration: none!important;
    font-weight:700;
  }
.navbar-brand span {
    display: inline-block;
}
.container{
	position: relative;
	margin-top: 40px;
	width: 450px;
	height: auto;
	background: rgb(86,119,200);
	border-radius: 5px;
	border: 4px solid rgb(25, 27, 52);
	backdrop-filter: blur(10px);
}
.container h2{
    text-align: center;
}
.label{
	padding: 20px 130px;
	font-size: 30px;
	font-weight: bold;
	color: #e1e1e9;
}
.login_form{
	padding: 20px 40px;
}
.login_form .font{
	font-size: 18px;
	color: #d9d7eb;
	margin: 5px 0;
}
h2{
	padding-top: 20px;
	color:white;
	font-weight: bold;
}
a:hover {
    color: rgb(241, 6, 190) !important;
}

.navbar-nav .nav-link.active {
    background: #243346;
    color: white !important;
    height: auto;
}

.login_form input{
	height: 40px;
	width: 350px;
	padding: 0 5px;
	font-size: 18px;
	outline: none;
	border: 1px solid silver;
}
.login_form .font2{
	margin-top: 30px;
}
.login_form button{
	margin: 45px 0 30px 0;
	height: 45px;
	width: 365px;
	font-size: 20px;
	color: white;
	outline: none;
	cursor: pointer;
	font-weight: bold;
	background: #1A237E;
	border-radius: 3px;
	border: 1px solid #3949AB;
	transition: .5s;
}
.login_form button:hover{
	background: #f0f0f5;
	color: #1A237E!important;
}
.login_form #email_error,
.login_form #pass_error{
	width: 345px;
	font-size: 16px;
	color: #faf7f9;
	text-align: left;
	border-radius: 5px;
	padding-bottom: 0px;
	display: none;
}
.rs{
	font-weight: bold!important;
	color:rgb(240, 237, 242)!important;
}
.rs:hover{
	color: aqua !important;;
}
.sh{
	color:white;
}
.sh a{
	text-decoration: none!important;
	color: white;
}
.fw{
	font-weight: bold;
	font-size: 20px;
	color: white;
	line-height: 40px;
}
    
    </style>
</head>

<body>
    <nav class="navbar navbar-expand-lg navbar-light sticky-header" id="ids">
        <div class="container-fluid">
            <img src="../../Images/image1.png" alt="logo" width="50px" height="50px">
            <a class="navbar-brand pt-1 p-3 d-flex-align-items-center fs-4" href="#">
                <span class="text-primary fw-bold">Joy<span class="text-success ms-2">R</span>ider</span>
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mb-auto mb-lg-0 fs-5 space">
                    <li class="nav-item fcolor">
                        <a class="nav-link fse ms-1" aria-current="page"
                            href="http://127.0.0.1:5500/customer/index.html">Home</a>
                    </li>
                    <li class="nav-item fcolor">
                        <a class="nav-link fse ms-5" aria-current="page"
                            href="http://127.0.0.1:5500/customer/Aboutus/About.html">About us</a>
                    </li>
                    <li class="nav-item fcolor">
                        <a class="nav-link fse ms-5" aria-current="page"
                            href="http://127.0.0.1:5500/customer/Booking/Book.html">Booking</a>
                    </li>
                    <!-- <li class="nav-item fcolor">
                        <a class="nav-link fse ms-5" aria-current="page" href="#">Cancel Booking</a>
                    </li>
                    <li class="nav-item fcolor">
                        <a class="nav-link fse ms-5" aria-current="page" href="#">View Booking</a>
                    </li> -->
                    <li class="nav-item fcolor">
                        <a class="nav-link fse ms-5" aria-current="page"
                            href="http://127.0.0.1:5500/customer/Contactus/Contact.html">Contact us</a>
                    </li>
                    <li class="nav-item fcolor">
                        <a class="nav-link active fse ms-5" aria-current="page"
                            href="http://127.0.0.1:5500/customer/Login/customerlogin.html">Login/Register</a>
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
                <li class="breadcrumb-item" id="navlin"><a href="http://127.0.0.1:5500/customer/index.html">Home</a>
                </li>
                <li class="breadcrumb-item active" aria-current="page">Login</li>
            </ol>
        </nav>
    </div>
    <div class="container pt-3">
        <h2>Login</h2>
        <!-- <h1 class="label">User Login</h1> -->
        <form class="login_form" action="${pageContext.request.contextPath}/CustomerLoginController" method="post" name="form" onsubmit="return validated()">
            <div class="fw">Email</div>
             <input autocomplete="on" type="text" name="email" placeholder="Enter your mail"><!--  -->
            <div id="email_error">Please Enter Email id</div>
            <div class="fw"><br>Password</div>
            <input type="password" name="password" placeholder="Enter your password">
            <div><p class="text-end text-white pb-0">Forgot password?</div>
                <div id="pass_error">Please Enter Password</div>
            <!-- <button type="submit">Login</button> -->
            <button type="submit" style="text-decoration: none;color:aliceblue" placeholder="Enter your password">Login</button>
        </form>
        <div class="text-center pb-5 sh ">Don't have an account?
            <a href="http://127.0.0.1:5500/customer/Login/Registration.html" class="text-dark rs">Register now</a>
        </div>
    </div>
    <script src="validate.js"></script>
</body>

</html>