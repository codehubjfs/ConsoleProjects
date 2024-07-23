<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cancel Ticket</title>
    <link rel="stylesheet" href="/customer/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    
   <style>
 body {
    margin: 0;
    font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
    background-color: #4b6891;
    color: #fff;
}

.cancel-ticket-container {
    text-align: center;
    margin: 50px auto;
    width: 80%;
}
.cancel-ticket-container h1{
    text-align: center;
    margin: 50px auto;
    width: 80%;
    font-size: 30px;
}
.cancel-ticket-form {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
}

.form-group {
    display: flex;
    flex-direction: column;
    align-items: flex-start; /* Align items to the left */
    margin-bottom: 20px;
    width: 100%;
    max-width: 500px; /* Adjust this width as needed */
}

.icon-label {
    margin-bottom: 10px;
    font-weight: bold;
}

.hidden-label {
    display: none;
}

.form-group input,
.form-group select {
    padding: 10px;
    border: 1px solid black;
    border-radius: 5px;
    margin: 5px 0;
    width: 100%; /* Adjust the width to fit the container */
}

.mobile-input {
    display: flex;
    width: 100%;
}

.mobile-input select {
    flex: none; 
    margin-right: 5px;
    width: 70px;
}

.mobile-input input {
    flex: 3;
}

.submit-btn {
    background-color: #ff5733;
    color: #fff;
    border: none;
    padding: 15px 30px;
    border-radius: 5px;
    cursor: pointer;
    margin-top: 20px;
}

.submit-btn:hover {
    background-color: #ff7961;
}
 .custom-navbar {
            background-color:rgb(241, 240, 247); /* Replace with your desired color */
        }

</style>
</head>
<body>
   <nav class="navbar navbar-expand-lg navbar-light sticky-header custom-navbar" id="ids">
            <div class="container-fluid">
                <img src="../../Images/Joylogo.png" alt="logo" width="50px" height="50px">
                <a class="navbar-brand pt-1 p-3 d-flex-align-items-center fs-4" href="#">
                    <span class="text-primary fw-bold">Joy<span class="text-success ms-2">R</span>ider</span> 
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mb-auto mb-lg-0 fs-5 space">
                        <li class="nav-item fcolor">
                            <a class="nav-link fse ms-1" aria-current="page" href="http://127.0.0.1:5500/customer/index.html">Home</a>
                        </li>
                        <li class="nav-item fcolor">
                            <a class="nav-link fse ms-5" aria-current="page" href="http://127.0.0.1:5500/customer/Aboutus/About.html">About us</a>
                        </li>
                        <li class="nav-item fcolor">
                            <a class="nav-link fse ms-5" aria-current="page" href="http://127.0.0.1:5500/customer/Booking/Book.html">Booking</a>
                        </li>
                        <li class="nav-item fcolor">
                            <a class="nav-link fse ms-5 active" aria-current="page" href="http://127.0.0.1:5500/customer/cancelticket/Viewticket.html">Cancel Booking</a>
                        </li>
                        <li class="nav-item fcolor">
                            <a class="nav-link fse ms-5" aria-current="page" href="http://127.0.0.1:5500/customer/cancelticket/Viewticket.html">View Booking</a>
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
    <main>
        <!DOCTYPE html>
        <html lang="en">
        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Cancel Ticket</title>
            <link rel="stylesheet" href="styles.css">
        </head>
        <body>
            <div class="cancel-ticket-container">
                <h1>Cancel your Ticket</h1> 
                <form class="cancel-ticket-form">
                    <div class="form-group">
                        <label class="icon-label" for="ticket-number"><i class="fas fa-ticket-alt"></i> TICKET NUMBER</label>
                        <input type="text" id="ticket-number" placeholder="Enter your ticket number">
                    </div>
                    <div class="form-group">
                        <label class="icon-label" for="mobile-number"><i class="fas fa-mobile-alt"></i> MOBILE NUMBER</label>
                        <div class="mobile-input">
                            <select>
                                <option value="+91">+91</option>
                            </select>
                            <input type="text" id="mobile-number" placeholder="Enter your mobile number">
                        </div>
                    </div>
                    <button type="submit" class="submit-btn">SUBMIT</button>
                </form>
            </div>
        </body>
        </html>
        
    </main>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
</body>
</html>
