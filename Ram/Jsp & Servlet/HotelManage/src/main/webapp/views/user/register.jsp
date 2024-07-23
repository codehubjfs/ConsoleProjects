<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Register - Hotel Booking App</title>
  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <!-- Font Awesome for icons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
  <!-- Custom CSS -->
  <link rel="stylesheet" href="../../css/user/register.css">
</head>
<body>

<div class="container">
  <div class="title">Rk Hotel</div>
  <div class="row justify-content-center">
    <div class="col-md-8">
      <div class="card">
        <button class="back-button" onclick="window.history.back();">
          <i class="fas fa-arrow-left"></i> Back
        </button>
        <div class="card-body">
          <h3 class="text-center mb-4"><i class="fas fa-user-plus icon"></i>Create Your Account</h3>
          <form id="registrationForm" action="../../RegisterServlet" method="post" onsubmit="return validateForm()">
            <div class="form-group">
              <label for="firstName"><i class="fas fa-user icon"></i>First Name</label>
              <input type="text" id="firstName" name="firstName" class="form-control" onchange="validateField('firstName')">
              <div id="firstNameError" class="error-message"></div>
            </div>
            <div class="form-group">
              <label for="lastName"><i class="fas fa-user icon"></i>Last Name</label>
              <input type="text" id="lastName" name="lastName" class="form-control" onchange="validateField('lastName')">
              <div id="lastNameError" class="error-message"></div>
            </div>
            <div class="form-group">
              <label for="age"><i class="fas fa-calendar-alt icon"></i>Age</label>
              <input type="number" id="age" name="age" class="form-control" onchange="validateField('age')">
              <div id="ageError" class="error-message"></div>
            </div>
            <div class="form-group">
              <label for="gender"><i class="fas fa-venus-mars icon"></i>Gender</label>
              <select id="gender" name="gender" class="form-control" onchange="validateField('gender')">
                <option value="">Choose...</option>
                <option value="Male">Male</option>
                <option value="Female">Female</option>
                <option value="Other">Other</option>
              </select>
              <div id="genderError" class="error-message"></div>
            </div>
            <div class="form-group">
              <label for="phone"><i class="fas fa-phone icon"></i>Phone Number</label>
              <input type="tel" id="phone" name="phone" class="form-control" onchange="validateField('phone')">
              <div id="phoneError" class="error-message"></div>
            </div>
            <div class="form-group">
              <label for="address"><i class="fas fa-home icon"></i>Address</label>
              <input type="text" id="address" name="address" class="form-control" onchange="validateField('address')">
              <div id="addressError" class="error-message"></div>
            </div>
            <div class="form-group">
              <label for="state"><i class="fas fa-map-marker-alt icon"></i>State</label>
              <select id="state" name="state" class="form-control" onchange="validateField('state')">
                <option value="">Select State</option>
                <!-- Add all state options here -->
                <option value="Andhra Pradesh">Andhra Pradesh</option>
                <option value="Arunachal Pradesh">Arunachal Pradesh</option>
                <option value="Assam">Assam</option>
                <option value="Bihar">Bihar</option>
                <option value="Chhattisgarh">Chhattisgarh</option>
                <option value="Goa">Goa</option>
                <option value="Gujarat">Gujarat</option>
                <option value="Haryana">Haryana</option>
                <option value="Himachal Pradesh">Himachal Pradesh</option>
                <option value="Jharkhand">Jharkhand</option>
                <option value="Karnataka">Karnataka</option>
                <option value="Kerala">Kerala</option>
                <option value="Madhya Pradesh">Madhya Pradesh</option>
                <option value="Maharashtra">Maharashtra</option>
                <option value="Manipur">Manipur</option>
                <option value="Meghalaya">Meghalaya</option>
                <option value="Mizoram">Mizoram</option>
                <option value="Nagaland">Nagaland</option>
                <option value="Odisha">Odisha</option>
                <option value="Punjab">Punjab</option>
                <option value="Rajasthan">Rajasthan</option>
                <option value="Sikkim">Sikkim</option>
                <option value="Tamil Nadu">Tamil Nadu</option>
                <option value="Telangana">Telangana</option>
                <option value="Tripura">Tripura</option>
                <option value="Uttar Pradesh">Uttar Pradesh</option>
                <option value="Uttarakhand">Uttarakhand</option>
                <option value="West Bengal">West Bengal</option>
                <option value="Andaman and Nicobar Islands">Andaman and Nicobar Islands</option>
                <option value="Chandigarh">Chandigarh</option>
                <option value="Dadra and Nagar Haveli and Daman and Diu">Dadra and Nagar Haveli and Daman and Diu</option>
                <option value="Delhi">Delhi</option>
                <option value="Lakshadweep">Lakshadweep</option>
                <option value="Puducherry">Puducherry</option>
                <option value="Ladakh">Ladakh</option>
                <option value="Jammu and Kashmir">Jammu and Kashmir</option>
              </select>
              <div id="stateError" class="error-message"></div>
            </div>
            <div class="form-group">
              <label for="email"><i class="fas fa-envelope icon"></i>Email</label>
              <input type="email" id="email" name="email" class="form-control" onchange="validateField('email')">
              <div id="emailError" class="error-message"></div>
            </div>
            <div class="form-group">
              <label for="password"><i class="fas fa-lock icon"></i>Password</label>
              <input type="password" id="password" name="password" class="form-control" onchange="validateField('password')">
              <div id="passwordError" class="error-message"></div>
            </div>
            <div class="form-group">
              <label for="confirmPassword"><i class="fas fa-lock icon"></i>Confirm Password</label>
              <input type="password" id="confirmPassword" name="confirmPassword" class="form-control" onchange="validateField('confirmPassword')">
              <div id="confirmPasswordError" class="error-message"></div>
            </div>
            <div class="text-center">
              <button type="submit" class="btn btn-primary">Register</button>
            </div>
            <div class="text-center mt-3">
              <a href="login.jsp">Already have an account? Login</a>
            </div>
          </form>
          
        </div>
      </div>
    </div>
  </div>
</div>

<!-- Bootstrap JavaScript and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="../../javascript/user/register.js"></script>

</body>
</html>
