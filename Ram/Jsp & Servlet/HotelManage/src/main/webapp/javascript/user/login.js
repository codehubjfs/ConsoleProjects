/**
 * 
 */

 function validateForm() {
    // Reset error messages
    resetErrors();

    // Get form values
    const email = document.getElementById('email').value.trim();
    const password = document.getElementById('password').value.trim();

    let isValid = true;

    // Validate email
    if (email === '') {
      isValid = false;
      document.getElementById('emailError').innerText = 'Email is required.';
    } else if (!validateEmail(email)) {
      isValid = false;
      document.getElementById('emailError').innerText = 'Invalid email format.';
    }

    // Validate password
    if (password === '') {
      isValid = false;
      document.getElementById('passwordError').innerText = 'Password is required.';
    }

    return isValid;
  }

  function resetErrors() {
    document.getElementById('emailError').innerText = '';
    document.getElementById('passwordError').innerText = '';
  }

  function validateEmail(email) {
    // Regular expression for basic email validation
    const re = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    return re.test(email);
  }