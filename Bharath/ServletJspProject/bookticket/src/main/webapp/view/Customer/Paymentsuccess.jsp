<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Payment Success</title>
    <style>
    * {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

body {
    font-family: Arial, sans-serif;
    background-color: #f0f0f0;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
}

/* Payment success container */
.payment-success {
    width: 300px;
    background-color: #fff;
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    text-align: center;
}

/* Green tick icon */
.success-icon {
    margin-bottom: 20px;
}

/* Payment details */
.success-details {
    border-top: 1px solid #ccc;
    padding-top: 15px;
}

.success-details h3 {
    color: green;
    margin-bottom: 10px;
}

.success-details p {
    margin-bottom: 5px;
    text-align:left;
}
.success-details .rs{
    text-align:right;
}
    
    </style>
</head>
<body>
    <div class="payment-success">
        <div class="success-icon">
            <!-- Green tick icon -->
            <svg xmlns="http://www.w3.org/2000/svg" width="50" height="50" fill="green" class="bi bi-check-circle" viewBox="0 0 16 16">
                <path d="M8 0C3.58 0 0 3.58 0 8s3.58 8 8 8 8-3.58 8-8-3.58-8-8-8zm3.97 5.97l-5.3 5.3a.75.75 0 0 1-1.06 0l-2.5-2.5a.75.75 0 1 1 1.06-1.06l1.97 1.97 4.72-4.72a.75.75 0 1 1 1.06 1.06z"/>
            </svg>
        </div>
        <div class="success-details">
            <h3>Payment Successful!</h3>
            <p>Amount: <span class="rs">$100</span></p>
            <p>Paid Date and Time: <span class="rs">July 6, 2024 12:30 PM</span></p>
            <p>Reference Number: <span class="rs">ABC123XYZ</span></p>
        </div>
    </div>
</body>
</html>
