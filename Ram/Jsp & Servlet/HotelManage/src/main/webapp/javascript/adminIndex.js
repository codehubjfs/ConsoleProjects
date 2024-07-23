/**
 * 
 */

        // Your existing JavaScript code
        function validateUsername() {
            var username = document.getElementById('login-username').value;
            var usernameError = document.getElementById('username-error');
            
            if (username === 'Ram@12') {
                usernameError.innerHTML = '';
                return true;
            } else {
                usernameError.innerHTML = 'Invalid username';
                return false;
            }
        }

        function validatePassword() {
            var password = document.getElementById('login-password').value;
            var passwordError = document.getElementById('password-error');
            
            if (password === '1234') {
                passwordError.innerHTML = '';
                return true;
            } else {
                passwordError.innerHTML = 'Invalid password';
                return false;
            }
        }

        
    