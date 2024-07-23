/**
 * 
 */

    function validateField(fieldName) {
      var fieldValue = document.getElementById(fieldName).value.trim();
      var errorElement = document.getElementById(fieldName + 'Error');
      var errorMessage = '';
    
      var nameRegex = /^[a-zA-Z]+$/;
      var ageRegex = /^\d{1,3}$/;
      var phoneRegex = /^\d{10}$/;
      var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    
      switch (fieldName) {
        case 'firstName':
        case 'lastName':
          if (fieldValue === '') {
            errorMessage = fieldName === 'firstName' ? 'First Name cannot be empty.' : 'Last Name cannot be empty.';
          } else if (!fieldValue.match(nameRegex)) {
            errorMessage = fieldName === 'firstName' ? 'First Name should only contain alphabets.' : 'Last Name should only contain alphabets.';
          }
          break;
        case 'age':
          if (fieldValue === '') {
            errorMessage = 'Age cannot be empty.';
          } else if (!fieldValue.match(ageRegex)) {
            errorMessage = 'Age should be a valid number.';
          }
          break;
        case 'gender':
          if (fieldValue === '') {
            errorMessage = 'Please select a gender.';
          }
          break;
        case 'phone':
          if (fieldValue === '') {
            errorMessage = 'Phone Number cannot be empty.';
          } else if (!fieldValue.match(phoneRegex)) {
            errorMessage = 'Phone Number should be a valid 10-digit number.';
          }
          break;
        case 'address':
          if (fieldValue === '') {
            errorMessage = 'Address cannot be empty.';
          }
          break;
        case 'state':
          if (fieldValue === '') {
            errorMessage = 'Please select a state.';
          }
          break;
        case 'email':
          if (fieldValue === '') {
            errorMessage = 'Email cannot be empty.';
          } else if (!fieldValue.match(emailRegex)) {
            errorMessage = 'Please enter a valid email address.';
          }
          break;
        case 'password':
          if (fieldValue === '') {
            errorMessage = 'Password cannot be empty.';
          } else if (fieldValue.length < 8) {
            errorMessage = 'Password should be at least 8 characters long.';
          }
          break;
        case 'confirmPassword':
          var passwordValue = document.getElementById('password').value.trim();
          if (fieldValue === '') {
            errorMessage = 'Confirm Password cannot be empty.';
          } else if (fieldValue !== passwordValue) {
            errorMessage = 'Passwords do not match.';
          }
          break;
        default:
          break;
      }
    
      if (errorMessage !== '') {
        errorElement.innerHTML = errorMessage;
      } else {
        errorElement.innerHTML = '';
      }
    }
    
    function validateForm() {
      var fields = ['firstName', 'lastName', 'age', 'gender', 'phone', 'address', 'state', 'email', 'password', 'confirmPassword'];
      var isValid = true;
    
      fields.forEach(function(field) {
        validateField(field);
        if (document.getElementById(field + 'Error').innerHTML !== '') {
          isValid = false;
        }
      });
    
      return isValid;
    }
    