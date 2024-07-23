/**
 * 
 */
document.getElementById('myForm').addEventListener('submit', function(event) {
    event.preventDefault();
    validateForm();
  });

  function validateForm() {
    const email = document.getElementById('inputEmail4').value;
    const password = document.getElementById('inputPassword4').value;
    const firstName = document.getElementById('inputFName').value;
    const lastName = document.getElementById('inputLName').value;
    let errors = [];

    const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailPattern.test(email)) {
      errors.push("Please enter a valid email address.");
    }

    const passwordPattern = /^(?=.*[0-9])(?=.*[!@#$%^&*])/;
    if (!passwordPattern.test(password)) {
      errors.push("Password must contain at least one number and one special character.");
    }

    const namePattern = /^[A-Za-z]+$/;
    if (!namePattern.test(firstName)) {
      errors.push("First name should not contain any numbers.");
      const err=document.getElementById("inputFnameerr")
      err.innerText="Do not Enter Number";
    }
    if (!namePattern.test(lastName)) {
      errors.push("Last name should not contain any numbers.");
    }

    if (errors.length > 0) {
      document.getElementById('validationErrors').innerHTML = errors.join('<br>');
      $('#validationModal').modal('show');
    } else {
      // Form is valid, you can submit it or perform further actions here.
    }
  }