/**
 * 
 */
document.getElementById('nameForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const nameInput = document.getElementById('nameInput').value;
    if (/\d/.test(nameInput)) {
        // If the name contains numbers
        document.getElementById('modalBody').textContent = 'Name should not contain numbers.';
        $('#alertModal').modal('show');
    } else {
        // If the name does not contain numbers
        document.getElementById('modalBody').textContent = 'Name is valid.';
        $('#alertModal').modal('show');
    }
});