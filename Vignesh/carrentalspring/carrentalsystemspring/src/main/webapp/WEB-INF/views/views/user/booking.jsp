<!DOCTYPE html>
<html>
<head>
    <title>Car Rental Booking</title>
   
</head>
<body>


    <h2>Car Rental Booking</h2>
    <form action="../../BookingServlet" method="post">
        <!-- Personal Information -->
        <fieldset>
            <legend>Personal Information:</legend>
            <label for="fullName">Full Name:</label><br>
            <input type="text" id="fullName" name="fullName" ><br><br>

            <label for="contactNumber">Contact Number:</label><br>
            <input type="text" id="contactNumber" name="contactNumber" ><br><br>

            <label for="email">Email:</label><br>
            <input type="email" id="email" name="email" ><br><br>

            <label for="address">Address:</label><br>
            <textarea id="address" name="address" ></textarea><br><br>
        </fieldset>

        
        
         

        <!-- Rental Details -->
        <fieldset>
            <legend>Rental Details:</legend>
            <label for="pickupLocation">Pickup Location:</label><br>
            <input type="text" id="pickupLocation" name="pickupLocation" ><br><br>

            <label for="pickupDate">Pickup Date and Time:</label><br>
            <input type="datetime-local" id="pickupDate" name="pickupDate" ><br><br>

            <label for="dropoffLocation">Drop-off Location:</label><br>
            <input type="text" id="dropoffLocation" name="dropoffLocation" ><br><br>

            <label for="dropoffDate">Drop-off Date and Time:</label><br>
            <input type="datetime-local" id="dropoffDate" name="dropoffDate" ><br><br>

            <label for="carType">Car Type/Model:</label><br>
            <select id="carType" name="carType" >
                <option value="Sedan">Sedan</option>
                <option value="SUV">SUV</option>
                <option value="Truck">Truck</option>
            </select><br><br>
        </fieldset>

        <!-- Payment Information -->
        <fieldset>
            <legend>Payment Information:</legend>
            <div id="totalAmountDisplay">Total Amount: $0.00</div>
            <input type="hidden" id="totalAmount" name="totalAmount" value="0.00"><br>

            <label for="paymentMethod">Payment Method:</label><br>
            <select id="paymentMethod" name="paymentMethod" >
                <option value="Credit Card">Credit Card</option>
                <option value="Debit Card">Debit Card</option>
                <option value="PayPal">PayPal</option>
                <option value="Google Pay">Google Pay</option>
                <option value="Apple Pay">Apple Pay</option>
            </select><br><br>

            <label for="cardNumber">Card Number:</label><br>
            <input type="text" id="cardNumber" name="cardNumber" ><br><br>

            <label for="expiryDate">Card Expiry Date:</label><br>
            <input type="month" id="expiryDate" name="expiryDate"><br><br>

            <label for="cvv">Card Security Code (CVV):</label><br>
            <input type="text" id="cvv" name="cvv" ><br><br>
        </fieldset>

        <input type="submit" value="Book Now">
    </form>
</body>
</html>
