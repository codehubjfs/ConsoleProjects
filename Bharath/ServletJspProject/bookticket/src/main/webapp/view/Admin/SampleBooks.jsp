<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Seat Selection and Total Price Calculation</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2>Seat Selection</h2>
        <form id="seatSelectionForm" action="${pageContext.request.contextPath}/BookingController" method="post">
            <div class="mb-3">
                <label for="departure">Departure:</label>
                <input type="text" class="form-control" id="departure" name="departure" required>
            </div>
            <div class="mb-3">
                <label for="arrival">Arrival:</label>
                <input type="text" class="form-control" id="arrival" name="arrival" required>
            </div>
            <div class="mb-3">
                <label>Select Seat Number:</label><br>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="checkbox" id="seat1A" name="seatSelection[]" value="1A">
                    <label class="form-check-label" for="seat1A">1A</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="checkbox" id="seat1B" name="seatSelection[]" value="1B">
                    <label class="form-check-label" for="seat1B">1B</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="checkbox" id="seat2A" name="seatSelection[]" value="2A">
                    <label class="form-check-label" for="seat2A">2A</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="checkbox" id="seat2B" name="seatSelection[]" value="2B">
                    <label class="form-check-label" for="seat2B">2B</label>
                </div>
                <!-- Add more checkboxes as needed -->
            </div>

            <!-- Hidden input for total price -->
            <input type="hidden" id="totalPriceInput" name="totalPrice">

            <button type="button" class="btn btn-primary" onclick="calculateTotal()">Calculate Total Price</button>
            <button type="submit" class="btn btn-success mt-3">Submit Booking</button>
        </form>

        <div id="selectedSeats" class="mt-4">
            <h4>Selected Seats:</h4>
            <ul id="selectedSeatsList"></ul>
            <p>Total Price: <span id="totalPriceDisplay"></span></p>
        </div>
    </div>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script>
        function calculateTotal() {
            var selectedSeats = [];
            $('input[name="seatSelection[]"]:checked').each(function() {
                selectedSeats.push($(this).val());
            });

            // Calculate total price (dummy calculation for example)
            var totalPrice = selectedSeats.length * 50; // Replace with actual price calculation

            // Update hidden input with total price
            $('#totalPriceInput').val(totalPrice);

            // Display selected seats and total price
            $('#selectedSeatsList').empty();
            selectedSeats.forEach(function(seat) {
                $('#selectedSeatsList').append('<li>' + seat + '</li>');
            });
            $('#totalPriceDisplay').text('$' + totalPrice.toFixed(2)); // Format price as needed

            // Print selected seats to console
            console.log(selectedSeats);
        }
    </script>
</body>
</html>
