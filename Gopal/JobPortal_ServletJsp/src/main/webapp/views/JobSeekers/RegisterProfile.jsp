<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Register</title>
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
  <link rel="stylesheet" href="/css/style.css">
   <link rel="stylesheet" href="..\..\assets\css\adminlogin.css">
  <style>
    body {
      background-color: #f8f9fa;
    }
    .login-container {
      display: flex;
      justify-content: center;
      align-items: center;
      min-height: 85vh;
      padding: 20px;
    }
    .login-box {
      width: 100%;
      max-width: 800px;
      padding: 20px;
      border: 1px solid #ccc;
      border-radius: 5px;
      background-color: #fff;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }
    .login-box h4 {
      text-align: center;
      margin-bottom: 20px;
      font-family: sans-serif !important;
      border-bottom: 1px solid #ddd;
      padding-bottom: 10px;
    }
    .form-group {
      position: relative;
      margin-bottom: 20px;
    }
    .form-group label {
      font-weight: bold;
    }
    .form-control {
      padding-left: 2.5rem;
    }
    .form-control.is-invalid {
      border-color: red;
    }
    .form-control.is-valid {
      border-color: green;
    }
    .invalid-feedback,
    .valid-feedback {
      display: none;
    }
    .form-control.is-invalid ~ .invalid-feedback {
      display: block;
    }
    .form-control.is-valid ~ .valid-feedback {
      display: block;
    }
    .sub .forget {
      float: right;
    }
    .hi {
      border: 1px solid black;
      height: auto;
    }
    .signup {
      text-align: left !important;
    }
    .mandatory {
      color: red;
    }
    footer {
      background-color: #f8f9fa;
      padding: 20px 0;
    }
  </style>
</head>
<body>


  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#"><img src="..\..\assets\images\head.2.png" alt="Jobportal"></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse justify-content-center" id="navbarNav">
      <ul class="navbar-nav h6">
        <li class="nav-item">
          <a class="nav-link" href="/html/index.html"></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/html/index.html"></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/html/about.html"></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#"></a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link" href="#" id="loginDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            
          </a>
          <div class="dropdown-menu" aria-labelledby="loginDropdown">
            <a class="dropdown-item" href="employer_login.html">Employer</a>
            <a class="dropdown-item hi" href="#" data-toggle="modal" data-target="#loginModal">Job Seekers</a>
            <a class="dropdown-item" href="#">Admin</a>
          </div>
        </li>
      </ul>
    </div>
  </nav>
   <div class="login-container">
    <div class="login-box">
      <h4>Profile</h4>
    
        <form id="registerForm" action="${pageContext.request.contextPath}/SeekerRegister" method="post" enctype="multipart/form-data">
        <!-- Name -->
       
        <!-- Date of Birth -->
        <div class="form-group">
          <label for="dob">Date of Birth<span class="mandatory">*</span>:</label>
          <input type="date" class="form-control" id="dob" name="dob">
          <div class="invalid-feedback">Please select a valid date of birth.</div>
        </div>

        <!-- Gender -->
        <div class="form-group" name="gender">
          <label>Gender<span class="mandatory">*</span>:</label><br>
          <input type="radio" name="gender" value="male" > Male<br>
          <input type="radio" name="gender" value="female" > Female<br>
          <div class="invalid-feedback">Please select your gender.</div>
        </div>

        
          
          <!-- Address -->
          <div class="form-group">
            <label for="address">Address<span class="mandatory">*</span>:</label>
            <textarea class="form-control" id="address" name="address"></textarea>
            <div class="invalid-feedback">Please enter your address.</div>
          </div>
        <div class="form-section add-education-form">
            <h5>Education Details</h5>
            <div class="education-info">
 <!-- Course -->
 <div class="form-group">
    <label for="course">Course<span class="mandatory">*</span>:</label>
    <input type="text" class="form-control" id="course" name="course">
    <div class="invalid-feedback">Please enter your course.</div>
  </div>

   <!-- Specialization -->
   <div class="form-group">
    <label for="specialization">Specialization<span class="mandatory">*</span>:</label>
    <input type="text" class="form-control" id="specialization" name="specialization">
    <div class="invalid-feedback">Please enter your specialization.</div>
  </div>
  <!-- Institute -->
  <div class="form-group">
    <label for="institute">Institute<span class="mandatory">*</span>:</label>
    <input type="text" class="form-control" id="institute" name="institute">
    <div class="invalid-feedback">Please enter your institute.</div>
  </div>
  <!-- Passing Year -->
  <div class="form-group">
    <label for="passingYear">Passing Year<span class="mandatory">*</span>:</label>
    <input type="number" class="form-control" id="passingYear" name="passingYear">
    <div class="invalid-feedback">Please enter a valid passing year.</div>
  </div>



        <!-- CGPA -->
        <div class="form-group">
            <label for="cgpa">CGPA<span class="mandatory">*</span>:</label>
            <input type="number" step="0.01" class="form-control" id="cgpa" name="cgpa">
            <div class="invalid-feedback">Please enter a valid CGPA (1.0-10.0).</div>
          </div>
  
          <!-- Course Type -->
        <div class="form-group">
            <label for="courseType">Course Type<span class="mandatory">*</span>:</label>
            <input type="text" class="form-control" id="courseType" name="courseType">
            <div class="invalid-feedback">Please enter your course type.</div>
          </div>
      
</div>
       
<div class="form-section add-experience-form">
    <h5>Experience Details</h5>
    <div class="experience-info">
        <!-- Company Name -->
        <div class="form-group">
            <label for="companyName">Company Name<span class="mandatory">*</span>:</label>
            <input type="text" class="form-control" id="companyName" name="companyName">
            <div class="invalid-feedback">Please enter your company name.</div>
          </div>
          
        <!-- Years of Experience -->
        <div class="form-group">
            <label for="yearsExperience">Years of Experience<span class="mandatory">*</span>:</label>
            <input type="number" class="form-control" id="yearsExperience" name="experience">
            <div class="invalid-feedback">Please enter valid years of experience (0-50).</div>
          </div>
  <!-- Designation -->
  <div class="form-group">
    <label for="designation">Designation<span class="mandatory">*</span>:</label>
    <input type="text" class="form-control" id="designation" name="designation">
    <div class="invalid-feedback">Please enter your designation.</div>
  </div>
</div>

        <!-- Experience Description -->
        <div class="form-group">
            <label for="experienceDescription">Experience Description<span class="mandatory">*</span>:</label>
            <textarea class="form-control" id="experienceDescription" name="experienceDescription"></textarea>
            <div class="invalid-feedback">Please enter your experience description.</div>
          </div>

</div>
</div>
      

       

        <!-- Resume -->
        <div class="form-group">
          <label for="resume">Resume</label>
          <input type="file" class="form-control" id="resume" name="resume">
          <div class="invalid-feedback">Please upload your resume (max 5MB).</div>
        </div>

       

        

        
            <button type="submit" class="btn btn-primary ms-3">Submit</button>
            <!-- Submit Button -->
    
            <!-- Reset Button -->
            <button type="reset" class="btn  btn-secondary btn-lg float-right">Reset</button>
            <br>
            <a href="${pageContext.request.contextPath}/views/home/home.jsp"><i class="fas fa-sign-in-alt ms-5"></i> Back to Home</a>
          

        

        <!-- Submit Button -->
       
      </form>
    </div>
  </div>
</div>

<!-- Bootstrap and other scripts -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script>
  document.addEventListener('DOMContentLoaded', function() {
      // Function to validate Date of Birth
      function validateDateOfBirth() {
          var dobField = document.getElementById('dob');
          var selectedDate = new Date(dobField.value);
          var today = new Date();
          
          if (selectedDate >= today) {
              dobField.classList.add('is-invalid');
              dobField.nextElementSibling.style.display = 'block';
              return false;
          } else {
              dobField.classList.remove('is-invalid');
              dobField.nextElementSibling.style.display = 'none';
              return true;
          }
      }
  
      // Function to validate Gender selection
      function validateGender() {
          var genderInputs = document.getElementsByName('gender');
          var genderSelected = false;
  
          // Check if any gender option is selected
          for (var i = 0; i < genderInputs.length; i++) {
              if (genderInputs[i].checked) {
                  genderSelected = true;
                  break;
              }
          }
  
          // If no gender is selected, show error
          if (!genderSelected) {
              var genderFormGroup = document.querySelector('.form-group[name="gender"]');
              genderFormGroup.classList.add('is-invalid');
              genderFormGroup.querySelector('.invalid-feedback').style.display = 'block';
              return false;
          } else {
              var genderFormGroup = document.querySelector('.form-group[name="gender"]');
              genderFormGroup.classList.remove('is-invalid');
              genderFormGroup.querySelector('.invalid-feedback').style.display = 'none';
              return true;
          }
      }
  
      // Function to validate Experience Years
      function validateExperienceYears() {
          var yearsExperienceField = document.getElementById('yearsExperience');
          var years = parseInt(yearsExperienceField.value);
  
          if (isNaN(years) || years < 0 || years > 50) {
              yearsExperienceField.classList.add('is-invalid');
              return false;
          } else {
              yearsExperienceField.classList.remove('is-invalid');
              yearsExperienceField.classList.add('is-valid');
              return true;
          }
      }
  
      // Function to validate required fields
      function validateRequiredField(field) {
          var fieldValue = field.value.trim(); // Trim to remove whitespace
  
          // Check if field is empty
          if (fieldValue === '') {
              field.classList.add('is-invalid');
              field.nextElementSibling.style.display = 'block'; // Show error message
              return false;
          } else {
              // Clear any existing validation styles/messages
              field.classList.remove('is-invalid');
              field.nextElementSibling.style.display = 'none'; // Hide error message
              return true;
          }
      }
  
      // Function to validate Passing Year
      function validatePassingYear(field) {
          var year = parseInt(field.value);
  
          if (isNaN(year) || year < 1900 || year > new Date().getFullYear()) {
              field.classList.add('is-invalid');
              field.nextElementSibling.style.display = 'block';
              return false;
          } else {
              field.classList.remove('is-invalid');
              field.nextElementSibling.style.display = 'none';
              return true;
          }
      }
  
      // Function to validate Phone Number
    //   function validatePhoneNumber(field) {
    //       var phonePattern = /^\d{10}$/; // Example pattern for 10-digit phone number
  
    //       if (!phonePattern.test(field.value)) {
    //           field.classList.add('is-invalid');
    //           field.nextElementSibling.style.display = 'block';
    //           return false;
    //       } else {
    //           field.classList.remove('is-invalid');
    //           field.nextElementSibling.style.display = 'none';
    //           return true;
    //       }
    //   }
  
      // Function to validate CGPA
      function validateCGPA(field) {
          var cgpa = parseFloat(field.value);
          var isValid = !isNaN(cgpa) && cgpa >= 1.0 && cgpa <= 10.0;
  
          if (!isValid) {
              field.classList.add('is-invalid');
              field.nextElementSibling.style.display = 'block';
              return false;
          } else {
              field.classList.remove('is-invalid');
              field.classList.add('is-valid');
              field.nextElementSibling.style.display = 'none';
              return true;
          }
      }
  
      // Function to validate Resume Upload
      function validateResume(field) {
          var file = field.files[0];
          var maxSize = 5 * 1024 * 1024; // 5MB in bytes
  
          if (file && file.size > maxSize) {
              field.setCustomValidity('File size exceeds 5MB limit.');
              field.classList.add('is-invalid');
              return false;
          } else {
              field.setCustomValidity('');
              field.classList.remove('is-invalid');
              return true;
          }
      }
  
      // Add event listeners for field validations on change
      document.getElementById('dob').addEventListener('change', validateDateOfBirth);
      document.getElementsByName('gender').forEach(function(input) {
          input.addEventListener('change', validateGender);
      });
      document.getElementById('yearsExperience').addEventListener('change', validateExperienceYears);
      document.getElementById('designation').addEventListener('change', function() {
          validateRequiredField(this);
      });
      document.getElementById('institute').addEventListener('change', function() {
          validateRequiredField(this);
      });
      document.getElementById('passingYear').addEventListener('change', function() {
          validatePassingYear(this);
      });
      
      document.getElementById('cgpa').addEventListener('input', function() {
          validateCGPA(this);
      });
      document.getElementById('address').addEventListener('change', function() {
          validateRequiredField(this);
      });
      document.getElementById('course').addEventListener('change', function() {
          validateRequiredField(this);
      });
      document.getElementById('resume').addEventListener('change', function() {
          validateResume(this);
      });
      document.getElementById('specialization').addEventListener('change', function() {
          validateRequiredField(this);
      });
      document.getElementById('companyName').addEventListener('change', function() {
          validateRequiredField(this);
      });
      document.getElementById('experienceDescription').addEventListener('change', function() {
          validateRequiredField(this);
      });
      document.getElementById('courseType').addEventListener('change', function() {
          validateRequiredField(this);
      });
  
      // Form submission validation
      document.getElementById('registerForm').addEventListener('submit', function(event) {
          var isFormValid = true;
  
          // Validate Date of Birth
          if (!validateDateOfBirth()) {
              isFormValid = false;
          }
  
          // Validate Gender
          if (!validateGender()) {
              isFormValid = false;
          }
  
          // Validate Experience Years
          if (!validateExperienceYears()) {
              isFormValid = false;
          }
  
          // Validate other required fields
         
          if (!validateRequiredField(document.getElementById('dob'))) {
              isFormValid = false;
          }
          if (!validateRequiredField(document.getElementById('designation'))) {
              isFormValid = false;
          }
          if (!validateRequiredField(document.getElementById('institute'))) {
              isFormValid = false;
          }
          if (!validatePassingYear(document.getElementById('passingYear'))) {
              isFormValid = false;
          }
          
          if (!validateCGPA(document.getElementById('cgpa'))) {
              isFormValid = false;
          }
          if (!validateRequiredField(document.getElementById('address'))) {
              isFormValid = false;
          }
          if (!validateRequiredField(document.getElementById('course'))) {
              isFormValid = false;
          }
          if (!validateResume(document.getElementById('resume'))) {
              isFormValid = false;
          }
          if (!validateRequiredField(document.getElementById('specialization'))) {
              isFormValid = false;
          }
          if (!validateRequiredField(document.getElementById('companyName'))) {
              isFormValid = false;
          }
          if (!validateRequiredField(document.getElementById('experienceDescription'))) {
              isFormValid = false;
          }
          if (!validateRequiredField(document.getElementById('courseType'))) {
              isFormValid = false;
          }
  
          // Prevent form submission if not valid
          if (!isFormValid) {
              event.preventDefault(); // Prevent form submission
              // Optionally, scroll to the first invalid field for better UX
              var firstInvalidField = document.querySelector('.is-invalid');
              if (firstInvalidField) {
                  firstInvalidField.scrollIntoView({ behavior: 'smooth', block: 'start' });
              }
          }
      });
  
      // Reset validation state on form reset
      document.getElementById('registerForm').addEventListener('reset', function() {
          var formInputs = this.querySelectorAll('input, select, textarea');
          formInputs.forEach(function(input) {
              input.classList.remove('is-invalid', 'is-valid');
          });
          var errorMessages = this.querySelectorAll('.invalid-feedback');
          errorMessages.forEach(function(message) {
              message.style.display = 'none';
          });
      });
  });
</script>
  
  
  <footer class="footer">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <h5>ABOUT US</h5>
                <p>Job portal involves various aspects to engage both job seekers and employers effectively. Here's a breakdown of the types of content you might include.</p>
            </div>
            <div class="col-md-3">
                <h5>CONTACT INFO</h5>
                <p>Address: Salem, Tamil Nadu</p>
                <p>Phone: +91 9788336639</p>
                <p>Email: jobfinder@job.ac.com</p>
            </div>
            <div class="col-md-3">
                <h5>LINKS</h5>
                <p><a href="#">Terms & Conditions</a></p>
                <p><a href="#">Download Job Finder App</a></p>
                <p><a href="#">Vulnerability Disclosure Policy</a></p>
                <p><a href="#">International Jobs</a></p>
                <p><a href="#">Support</a></p>
            </div>
            <div class="col-md-3">
                <h5>FOLLOW US</h5>
                <p>Stay connected through our social media channels:</p>
                <p>
                  <a href="https://www.facebook.com" target="_blank" class="social-icon"><i class="fab fa-facebook-f"></i></a>
                  <a href="https://www.twitter.com" target="_blank" class="social-icon"><i class="fab fa-twitter"></i></a>
                  <a href="https://www.linkedin.com" target="_blank" class="social-icon"><i class="fab fa-linkedin-in"></i></a>
                  <a href="https://www.instagram.com" target="_blank" class="social-icon"><i class="fab fa-instagram"></i></a>
                </p>
            </div>
        </div>
    </div>
  </footer>
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
 
</body>
</html>


    