document.addEventListener('DOMContentLoaded', function() {
    // Get all the edit buttons
    var editButtons = document.querySelectorAll('.edit-btn');

    // Add click event listeners to the edit buttons
    editButtons.forEach(function(button) {
        button.addEventListener('click', function() {
            // Get data attributes from the button
            var serialNumber = this.getAttribute('data-id');
            var roomName = this.getAttribute('data-name');
            var numberOfRooms = this.getAttribute('data-rooms');
            var bedCapacity = this.getAttribute('data-capacity');
            var amenities = this.getAttribute('data-amenities');

            // Set the values in the modal form fields
            document.getElementById('edit-serial-number').value = serialNumber;
            document.getElementById('edit-room-name').value = roomName;
            document.getElementById('edit-number-of-rooms').value = numberOfRooms;
            document.getElementById('edit-bed-capacity').value = bedCapacity;
            document.getElementById('edit-amenities').value = amenities;
        });
    });

    // Form validation
    var editRoomForm = document.getElementById('editRoomForm');
    editRoomForm.addEventListener('submit', function(event) {
        var isValid = true;
        var inputs = editRoomForm.querySelectorAll('input, textarea');

        inputs.forEach(function(input) {
            if (input.value.trim() === '') {
                isValid = false;
                input.classList.add('is-invalid');
            } else {
                input.classList.remove('is-invalid');
            }
        });

        if (!isValid) {
            event.preventDefault();
        }
    });
});
