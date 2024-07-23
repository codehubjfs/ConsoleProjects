<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.springproject.model.Booking" %>
<%@ page import ="com.springproject.model.RoomType" %>


<%
    HttpSession session1 = request.getSession();
    Booking booking = (Booking) session1.getAttribute("booking");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Payment Module</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700;800;900&display=swap');

        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Poppins', sans-serif;
        }

        .container {
            margin: 30px auto;
        }

        .container .card {
            width: 100%;
            box-shadow: rgba(0, 0, 0, 0.24) 0px 3px 8px;
            background: #fff;
            border-radius: 0px;
        }

        body {
            background: #eee
        }

        .btn.btn-primary {
            background-color: #ddd;
            color: black;
            box-shadow: none;
            border: none;
            font-size: 20px;
            width: 100%;
            height: 100%;
        }

        .btn.btn-primary:focus {
            box-shadow: none;
        }

        .container .card .img-box {
            width: 80px;
            height: 50px;
        }

        .container .card img {
            width: 100%;
            object-fit: fill;
        }

        .container .card .number {
            font-size: 24px;
        }

        .container .card-body .btn.btn-primary .fab.fa-cc-paypal {
            font-size: 32px;
            color: #3333f7;
        }

        .fab.fa-cc-amex {
            color: #1c6acf;
            font-size: 32px;
        }

        .fab.fa-cc-mastercard {
            font-size: 32px;
            color: red;
        }

        .fab.fa-cc-discover {
            font-size: 32px;
            color: orange;
        }

        .c-green {
            color: green;
        }

        .box {
            height: 40px;
            width: 50px;
            display: flex;
            align-items: center;
            justify-content: center;
            background-color: #ddd;
        }

        .btn.btn-primary.payment {
            background-color: #1c6acf;
            color: white;
            border-radius: 0px;
            height: 50px;
            display: flex;
            align-items: center;
            justify-content: center;
            margin-top: 24px;
        }

        .btn.btn-secondary.back {
            background-color: #6c757d;
            color: white;
            border-radius: 0px;
            height: 50px;
            display: flex;
            align-items: center;
            justify-content: center;
            margin-top: 24px;
            margin-left: 10px;
        }

        .form__div {
            height: 50px;
            position: relative;
            margin-bottom: 24px;
        }

        .form-control {
            width: 100%;
            height: 45px;
            font-size: 14px;
            border: 1px solid #DADCE0;
            border-radius: 0;
            outline: none;
            padding: 2px;
            background: none;
            z-index: 1;
            box-shadow: none;
        }

        .form__label {
            position: absolute;
            left: 16px;
            top: 10px;
            background-color: #fff;
            color: #80868B;
            font-size: 16px;
            transition: .3s;
            text-transform: uppercase;
        }

        .form-control:focus + .form__label {
            top: -8px;
            left: 12px;
            color: #1A73E8;
            font-size: 12px;
            font-weight: 500;
            z-index: 10;
        }

        .form-control:not(:placeholder-shown).form-control:not(:focus) + .form__label {
            top: -8px;
            left: 12px;
            font-size: 12px;
            font-weight: 500;
            z-index: 10;
        }

        .form-control:focus {
            border: 1.5px solid #1A73E8;
            box-shadow: none;
        }
          @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700;800;900&display=swap');

        body {
            background-color: #eee;
            font-family: 'Poppins', sans-serif;
        }

        .container {
            margin-top: 30px;
        }

        .card {
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            border: none;
            margin-bottom: 20px;
        }

        .btn-primary {
            background-color: #007bff;
            border-color: #007bff;
        }

        .btn-primary:hover {
            background-color: #0069d9;
            border-color: #0062cc;
        }

        .payment-method {
            cursor: pointer;
            padding: 10px;
            transition: background-color 0.3s ease;
            border-radius: 5px;
            margin-bottom: 10px;
        }

        .payment-method:hover {
            background-color: #f2f2f2;
        }
    </style>
</head>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-lg-6 mb-4">
                <div class="card p-4">
                    <h4 class="mb-4">Booking Summary</h4>
                     <p><strong>Customer Name:</strong> ${booking.customer_name}</p>
                    <p><strong>Gender:</strong> ${booking.gender}</p>
                    <p><strong>Phone Number:</strong> ${booking.phoneNo}</p>
                    <p><strong>Room Number:</strong> ${booking.room}</p>
                    <p><strong>Check-in Date:</strong> ${booking.check_in}</p>
                    <p><strong>Check-out Date:</strong> ${booking.check_out}</p>
                    <p><strong>Room Rent:</strong> ${booking.rent}</p>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="card p-4">
                    <h4 class="mb-4">Payment Methods</h4>
                    
                    <!-- PayPal Collapse -->
                    <div class="payment-method" data-toggle="collapse" href="#paypalCollapse">
                        <i class="fab fa-cc-paypal"></i> PayPal
                    </div>
                    <div id="paypalCollapse" class="collapse">
                        <form action="processPayment" method="POST">
                            <input type="hidden" name="paymentMethod" value="PayPal">
                            <input type="hidden" name="bookingId" value="${booking.id}">
                            <div class="form-group">
                                <input type="text" class="form-control" name="paypalId" placeholder="PayPal ID" required>
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="amount" placeholder="Amount" value="${booking.rent}" readonly>
                            </div>
                            <button type="submit" class="btn btn-primary btn-block">Pay with PayPal</button>
                        </form>
                    </div>
                    
                    <!-- Credit Card Collapse -->
                    <div class="payment-method" data-toggle="collapse" href="#creditCardCollapse">
                        <i class="far fa-credit-card"></i> Credit Card
                    </div>
                    <div id="creditCardCollapse" class="collapse">
                        <form action="processPayment" method="POST">
                            <input type="hidden" name="paymentMethod" value="Credit Card">
                            <input type="hidden" name="bookingId" value="${booking.id}">
                            <div class="form-group">
                                <input type="text" class="form-control" name="cardNumber" placeholder="Card Number" required>
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="expiryDate" placeholder="MM / YY" required>
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control" name="cvv" placeholder="CVV" required>
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="cardName" placeholder="Name on Card" required>
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="amount" placeholder="Amount" value="${booking.rent}" readonly>
                            </div>
                            <button type="submit" class="btn btn-primary btn-block">Pay with Credit Card</button>
                        </form>
                    </div>
                    
                    <!-- UPI Collapse -->
                    <div class="payment-method" data-toggle="collapse" href="#upiCollapse">
                        <i class="fas fa-mobile-alt"></i> UPI
                    </div>
                    <div id="upiCollapse" class="collapse">
                        <form action="processPayment" method="POST">
                            <input type="hidden" name="paymentMethod" value="UPI">
                            <input type="hidden" name="bookingId" value="${booking.id}">
                            <div class="form-group">
                                <input type="text" class="form-control" name="upiId" placeholder="UPI ID" required>
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="amount" placeholder="Amount" value="${booking.rent}" readonly>
                            </div>
                            <button type="submit" class="btn btn-primary btn-block">Pay with UPI</button>
                        </form>
                    </div>
                    
                    <!-- Debit Card Collapse -->
                    <div class="payment-method" data-toggle="collapse" href="#debitCardCollapse">
                        <i class="far fa-credit-card"></i> Debit Card
                    </div>
                    <div id="debitCardCollapse" class="collapse">
                        <form action="processPayment" method="POST">
                            <input type="hidden" name="paymentMethod" value="Debit Card">
                            <input type="hidden" name="bookingId" value="${booking.id}">
                            <div class="form-group">
                                <input type="text" class="form-control" name="cardNumber" placeholder="Card Number" required>
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="expiryDate" placeholder="MM / YY" required>
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control" name="cvv" placeholder="CVV" required>
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="cardName" placeholder="Name on Card" required>
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="amount" placeholder="Amount" value="${booking.rent}" readonly>
                            </div>
                            <button type="submit" class="btn btn-primary btn-block">Pay with Debit Card</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
      

    <!-- Bootstrap JS Bundle with Popper -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>

     <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/2.9.3/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
    