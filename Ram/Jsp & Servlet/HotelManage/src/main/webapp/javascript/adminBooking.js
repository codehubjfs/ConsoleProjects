/**
 * 
 */
    function handleBookingForm(event) {
        event.preventDefault();
        console.log("Form submitted");
    
        const form = event.target;
        if (!form.checkValidity()) {
            form.classList.add('was-validated');  // Add Bootstrap's validation class to show validation messages
            return;
        }
    
        console.log("Form is valid");
    
        // Retrieve form data
        const customerName = document.getElementById('customerName').value;
        const customerGender = document.getElementById('customerGender').value;
        const roomNumber = document.getElementById('roomNumber').value;
        const checkInDate = document.getElementById('checkInDate').value;
        const checkOutDate = document.getElementById('checkOutDate').value;
    
        console.log("Customer Name:", customerName);
        console.log("Customer Gender:", customerGender);
        console.log("Room Number:", roomNumber);
        console.log("Check-In Date:", checkInDate);
        console.log("Check-Out Date:", checkOutDate);
    
        // Add booking to the table
        const bookingTableBody = document.getElementById('bookingTableBody');
        const newRow = bookingTableBody.insertRow();
    
        const idCell = newRow.insertCell(0);
        const nameCell = newRow.insertCell(1);
        const genderCell = newRow.insertCell(2);
        const roomCell = newRow.insertCell(3);
        const checkInCell = newRow.insertCell(4);
        const checkOutCell = newRow.insertCell(5);
        const statusCell = newRow.insertCell(6);
        const actionsCell = newRow.insertCell(7);
    
        idCell.innerHTML = bookingTableBody.rows.length + 1;  
        nameCell.innerHTML = customerName;
        genderCell.innerHTML = customerGender;
        roomCell.innerHTML = roomNumber;
        checkInCell.innerHTML = checkInDate;
        checkOutCell.innerHTML = checkOutDate;
        statusCell.innerHTML = 'Pending';
        actionsCell.innerHTML = `
            <button type="button" class="view-icon" data-toggle="tooltip" data-placement="top" title="Approved">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-hand-thumbs-up-fill" viewBox="0 0 16 16">
                    <path d="M6.956 1.745C7.021.81 7.908.087 8.864.325l.261.066c.463.116.874.456 1.012.965.22.816.533 2.511.062 4.51a10 10 0 0 1 .443-.051c.713-.065 1.669-.072 2.516.21.518.173.994.681 1.2 1.273.184.532.16 1.162-.234 1.733q.086.18.138.363c.077.27.113.567.113.856s-.036.586-.113.856c-.039.135-.09.273-.16.404.169.387.107.819-.003 1.148a3.2 3.2 0 0 1-.488.901c.054.152.076.312.076.465 0 .305-.089.625-.253.912C13.1 15.522 12.437 16 11.5 16H8c-.605 0-1.07-.081-1.466-.218a4.8 4.8 0 0 1-.97-.484l-.048-.03c-.504-.307-.999-.609-2.068-.722C2.682 14.464 2 13.846 2 13V9c0-.85.685-1.432 1.357-1.615.849-.232 1.574-.787 2.132-1.41.56-.627.914-1.28 1.039-1.639.199-.575.356-1.539.428-2.59z"/>
                </svg>
            </button>
            <button type="button" class="view-icon" data-toggle="tooltip" data-placement="top" title="Rejected">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x-circle" viewBox="0 0 16 16">
                    <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16"/>
                    <path d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708"/>
                </svg>
            </button>
        `;
    
        console.log("Booking added to table");
    
        
        form.reset();
        $('#addBookingModal').modal('hide');
    }