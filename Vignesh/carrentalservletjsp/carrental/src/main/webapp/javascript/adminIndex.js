  // Get the current page URL
const currentPage = window.location.href;
if (currentPage.includes('main.html')) {
    document.getElementById('dashboardLink').classList.add('active');
} else if (currentPage.includes('carlist.html')) {
    document.getElementById('carsLink').classList.add('active');
}
// Add similar conditions for other pages


      

        document.getElementById('carNumber').addEventListener('input', function() {
            const carNumberInput = this.value;
            const carNumberError = document.getElementById('carNumberError');
            if (!/^\d{0,4}$/.test(carNumberInput)){
                carNumberError.textContent = 'Car number must be a 4-digit number';
                this.value = carNumberInput.slice(0, 4).replace(/\D/g, '');
            } else {
                carNumberError.textContent = '';
            }
        });

        document.getElementById('date').addEventListener('input', function() {
            const selectedDate = new Date(this.value);
            const currentDate = new Date();
            const dateError = document.getElementById('dateError');
            if (selectedDate < currentDate.setHours(0, 0, 0, 0)) {
                dateError.textContent = 'Date must be today or in the future';
                this.value = '';
            } else {
                dateError.textContent = '';
            }
        });

        document.getElementById('time').addEventListener('input', function() {
            const selectedTime = new Date(document.getElementById('date').value + 'T' + this.value);
            const currentTime = new Date();
            const timeError = document.getElementById('timeError');
            if (selectedTime < currentTime) {
                timeError.textContent = 'Time must be now or in the future';
                this.value = '';
            } else {
                timeError.textContent = '';
            }
        });

        document.getElementById('checkBtn').addEventListener('click', function() {
            const carNumber = document.getElementById('carNumber').value;
            const date = document.getElementById('date').value;
            const time = document.getElementById('time').value;

            if (carNumber.length !== 4 || !/^\d{4}$/.test(carNumber)) {
                document.getElementById('carNumberError').textContent = 'Car number must be a 4-digit number';
                return;
            } else {
                document.getElementById('carNumberError').textContent = '';
            }

            if (!date) {
                document.getElementById('dateError').textContent = 'Please select a valid date';
                return;
            } else {
                document.getElementById('dateError').textContent = '';
            }

            if (!time) {
                document.getElementById('timeError').textContent = 'Please select a valid time';
                return;
            } else {
                document.getElementById('timeError').textContent = '';
            }

            alert('Car availability checked successfully');
        });