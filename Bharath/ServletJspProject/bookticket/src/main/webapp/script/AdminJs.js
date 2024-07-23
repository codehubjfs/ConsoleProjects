// function handleDropdownChange(selectElement) {
//     if (selectElement.value === 'edit') {
//         editRow(selectElement);
//     } else if (selectElement.value === 'save') {
//         saveRow(selectElement);
//     }
// }

// function editRow(selectElement) {
//     let row = selectElement.closest('tr');
//     let cells = row.querySelectorAll('.data');
    
//     cells.forEach(cell => {
//         let originalText = cell.innerText;
//         cell.innerHTML = `<input type="text" value="${originalText}" />`;
//     });

//     updateDropdownOptions(selectElement, 'edit');
// }

// function saveRow(selectElement) {
//     let row = selectElement.closest('tr');
//     let cells = row.querySelectorAll('.data');

//     cells.forEach(cell => {
//         let input = cell.querySelector('input');
//         cell.innerText = input.value;
//     });

//     updateDropdownOptions(selectElement, 'save');
// }

// function updateDropdownOptions(selectElement, mode) {
//     let editOption = selectElement.querySelector('option[value="edit"]');
//     let saveOption = selectElement.querySelector('option[value="save"]');

//     if (mode === 'edit') {
//         editOption.disabled = true;
//         saveOption.disabled = false;
//         selectElement.value = "";
//     } else if (mode === 'save') {
//         editOption.disabled = false;
//         saveOption.disabled = true;
//         selectElement.value = "";
//     }
// }
// function editAvailability(button) {
//     const row = button.parentElement.parentElement;
//     const availabilityCell = row.querySelector('.availability');
//     const availabilityValue = availabilityCell.innerText;
//     availabilityCell.innerHTML = `<select class="editable">
//         <option value="active" ${availabilityValue === 'Active' ? 'selected' : ''}>Active</option>
//         <option value="inactive" ${availabilityValue === 'Inactive' ? 'selected' : ''}>Inactive</option>
//     </select>`;
// }

// function saveAvailability(button) {
//     const row = button.parentElement.parentElement;
//     const availabilityCell = row.querySelector('.availability');
//     const selectElement = availabilityCell.querySelector('select');
//     const selectedOption = selectElement.options[selectElement.selectedIndex].text;
//     availabilityCell.innerText = selectedOption;
// }


// function openModal() {
//     $('#myModal').modal('show');
// }

// // script.js

// // Function to toggle the sidebar visibility
// document.getElementById('sidebarToggle').addEventListener('click', function() {
//     document.querySelector('.sidebar').classList.toggle('open');
// });

// // Function to toggle the visibility of submenu items
// function toggleSubmenu(id) {
//     var submenu = document.getElementById(id);
//     submenu.style.display = submenu.style.display === 'none' ? 'block' : 'none';
// }


// function toggleSubmenu(submenuId) {
//     var submenu = document.getElementById(submenuId);
//     submenu.style.display = (submenu.style.display === 'none') ? 'block' : 'none';
// }

// function editAvailability(icon) {
//     var row = icon.closest('tr');
//     var availabilityCell = row.querySelector('.availability');
//     var isActive = availabilityCell.textContent.trim() === 'Active';

//     availabilityCell.innerHTML = `<select class="availability-dropdown">
//         <option value="Active" ${isActive ? 'selected' : ''}>Active</option>
//         <option value="Inactive" ${!isActive ? 'selected' : ''}>Inactive</option>
//     </select>`;
// }

// function saveAvailability(icon) {
//     var row = icon.closest('tr');
//     var availabilityCell = row.querySelector('.availability');
//     var dropdown = row.querySelector('.availability-dropdown');
//     var selectedValue = dropdown.value;

//     availabilityCell.textContent = selectedValue;
// }


// function editStatus(cell) {
//     var currentValue = cell.innerText;
//     var select = document.createElement('select');
//     select.innerHTML = '<option value="Active">Active</option><option value="Inactive">Inactive</option>';
//     select.value = currentValue;
//     cell.innerText = '';
//     cell.appendChild(select);
//     select.focus();
//     select.onblur = function() {
//         cell.innerText = select.value;
//     };
// }

// function editAvailability(icon, rowIndex) {
//     var table = $('#example').DataTable();
//     var row = table.row(rowIndex - 1);  // Adjust for 0-based indexing
//     var statusCell = row.data()[5];  // Assuming "Status" is the 6th column (0-based index)

//     // Trigger the edit of the status cell
//     editStatus(statusCell);
// }

// $(document).ready(function() {
//     $('#example').DataTable({
//         "pagingType": "simple_numbers",
//         "pageLength": 4,
//         "lengthMenu": [4, 10, 25, 50, 75, 100],
//         "searching": true,
//         "columnDefs": [{
//             "targets": [6],  // Index of the "Action" column (0-based index)
//             "orderable": false
//         }]
//     });
// })
function openAddCustomerModal() {
    document.getElementById('addCustomerModal').style.display = 'block';
}

function closeAddCustomerModal() {
    document.getElementById('addCustomerModal').style.display = 'none';
}

function saveCustomer() {
    // Get values from form
    const name = document.getElementById('customerName').value;
    const email = document.getElementById('customerEmail').value;
    const phone = document.getElementById('customerPhone').value;

    // Insert a new row into the table
    const table = document.getElementById('customerTable').getElementsByTagName('tbody')[0];
    const newRow = table.insertRow();
    const cell1 = newRow.insertCell(0);
    const cell2 = newRow.insertCell(1);
    const cell3 = newRow.insertCell(2);
    cell1.innerHTML = name;
    cell2.innerHTML = email;
    cell3.innerHTML = phone;

    // Close the modal
    closeAddCustomerModal();

    // Reset the form fields
    document.getElementById('addCustomerForm').reset();
}
function toggleSubmenu(id) {
    var submenu = document.getElementById(id);
    if (submenu.style.display === "none" || submenu.style.display === "") {
        submenu.style.display = "block";
    } else {
        submenu.style.display = "none";
    }
}



