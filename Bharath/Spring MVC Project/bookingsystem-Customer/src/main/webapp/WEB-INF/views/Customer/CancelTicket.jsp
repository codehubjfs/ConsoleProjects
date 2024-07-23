<%@ page import="com.bus.model.CustomersNew" %>
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
    
    background-color: white;
    color: black;
}

.text-dark:focus,
.text-dark:active {
    color: blue; 
    text-decoration: underline;
}


.text-dark:hover {
    color: blue; 
    text-decoration: underline;
}
a:hover {
	color: rgb(241, 6, 190) !important;
}

.navbar-nav .nav-link.active {
	background: #243346;
	color: white !important;
	height: auto;
}

.fse {
	font-size: 17px;
	font-weight: 450;
	color: rgba(43, 80, 182, 0.938) !important;
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
    align-items: flex-start; 
    margin-bottom: 20px;
    width: 100%;
    max-width: 500px; 
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
    width: 100%;
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
            background-color:rgb(241, 240, 247); 
        }
        .navbar {
    background-color: #f8f9fa; 
}
  .gets {
	font-weight: 500;
	font-size: 18px;
}   
.cancel-ticket-container {
            max-width: 600px;
            margin: 20px auto;
            padding: 20px;
            padding-left:50px;
            margin-top:90px;
            border: 1px solid #ccc;
            padding-top:60px;
            padding-bottom:50px;
            border-radius: 8px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }   
                .submit-btn:hover {
            background-color: #0056b3;
        }
        .error-message {
            color: red;
            font-size: 14px;
           

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
                <li class="nav-item fcolor"><a class="nav-link fse ms-5" aria-current="page" href="contact">Contact us</a></li>
                	<%
				    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); 
				    response.setHeader("Pragma", "no-cache"); 
				    response.setDateHeader("Expires", 0); 
				%>
                <%
                    CustomersNew customers = (CustomersNew) session.getAttribute("customersNew");
                    if (customers != null) {
                %>
                <li class="nav-item fcolor"><a class="nav-link fse active ms-5" href="cancel">Cancel Booking</a></li>
                <li class="nav-item fcolor"><a class="nav-link fse ms-5" href="view">View Booking</a></li>
                <li class="nav-item fcolor"><a class="nav-link fse ms-5" href="logout">Logout</a></li>
                <li class="nav-item fcolor"><span class="nav-link fse ms-5 text-uppercase"><%= customers.getFirstName() %> <%= customers.getLastName() %></span></li>
                <% } else { %>
                <li class="nav-item fcolor"><a class="nav-link fse ms-5" aria-current="page" href="login">Login/Register</a></li>
                <% } %>
            </ul>
        </div>
    </div>
</nav>

   <main>
    <div class="cancel-ticket-container">
        <h3>Cancel your Ticket</h3> <br>
        <form id="cancel-ticket-form" action="CancelSeat">
            <div class="form-group">
                <label class="icon-label" for="ticket-number"><i class="fas fa-ticket-alt"></i> TICKET NUMBER</label>
                <input type="number" id="ticket-number" name="bookingId" placeholder="Enter your ticket number">
                <div id="ticket-number-error" class="error-message"></div>
            </div>
            <button type="submit" class="submit-btn">SUBMIT</button>
        </form>
    </div>
</main>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
<script>
    document.getElementById('ticket-number').addEventListener('input', function(event) {
        var ticketNumberInput = event.target;
        var ticketNumberValue = ticketNumberInput.value.trim();
        var errorElement = document.getElementById('ticket-number-error');

        
        if (/^\d*$/.test(ticketNumberValue)) {
            errorElement.textContent = '';
        } else {
            errorElement.textContent = 'Please enter only numeric characters.';
        }
    });

    document.getElementById('cancel-ticket-form').addEventListener('submit', function(event) {
        var ticketNumberValue = document.getElementById('ticket-number').value.trim();
        var errorElement = document.getElementById('ticket-number-error');

     
        if (ticketNumberValue === '' || !/^\d+$/.test(ticketNumberValue)) {
            errorElement.textContent = 'Please enter a valid ticket number (numbers only).';
            event.preventDefault(); 
        } else {
            errorElement.textContent = ''; 
        }
    });
</script>
    
</body>
</html>
