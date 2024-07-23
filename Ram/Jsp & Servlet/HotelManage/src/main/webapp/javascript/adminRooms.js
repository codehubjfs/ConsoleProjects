/**
 * 
 */

  document.addEventListener('DOMContentLoaded', function () {
      const form = document.getElementById('roomForm');
      const roomType = document.getElementById('room-type');
      const roomStatus = document.getElementById('room-status');
      const bedCapacity = document.getElementById('bed-capacity');
      const rent = document.getElementById('rent');
      const tableBody = document.getElementById('roomTableBody');
      let serialNumber = 1; // Initial serial number

      let rowToEdit = null;
      let rowToDelete = null;

      function validateInput(input, regex, errorMessage) {
          if (!regex.test(input.value.trim())) {
              input.classList.add('is-invalid');
              input.nextElementSibling.textContent = errorMessage;
              return false;
          } else {
              input.classList.remove('is-invalid');
              input.classList.add('is-valid');
              input.nextElementSibling.textContent = ''; // Clear the error message
              return true;
          }
      }

      function resetForm() {
          form.reset();
          roomType.classList.remove('is-valid', 'is-invalid');
          roomStatus.classList.remove('is-valid', 'is-invalid');
          bedCapacity.classList.remove('is-valid', 'is-invalid');
          rent.classList.remove('is-valid', 'is-invalid');
      }

      function resetEditForm() {
          document.getElementById('editRoomForm').reset();
          document.getElementById('edit-room-type').classList.remove('is-valid', 'is-invalid');
          document.getElementById('edit-room-status').classList.remove('is-valid', 'is-invalid');
          document.getElementById('edit-bed-capacity').classList.remove('is-valid', 'is-invalid');
          document.getElementById('edit-rent').classList.remove('is-valid', 'is-invalid');
      }

      function addRowToTable(roomType, roomStatus, bedCapacity, rent) {
          const row = document.createElement('tr');
          row.innerHTML = `
              <td>${serialNumber++}</td>
              <td>${roomType}</td>
              <td>${roomStatus}</td>
              <td>${bedCapacity}</td>
              <td>${rent}</td>
              <td>
                  <button class="btn btn-warning btn-sm edit-button" data-toggle="modal" data-target="#editRoomModal">Edit</button>
                  <button class="btn btn-danger btn-sm delete-button" data-toggle="modal" data-target="#deleteRoomModal">Delete</button>
              </td>
          `;
          tableBody.appendChild(row);

          const editButton = row.querySelector('.edit-button');
          const deleteButton = row.querySelector('.delete-button');

          editButton.addEventListener('click', function () {
              rowToEdit = row;
              document.getElementById('edit-room-type').value = row.cells[1].textContent;
              document.getElementById('edit-room-status').value = row.cells[2].textContent;
              document.getElementById('edit-bed-capacity').value = row.cells[3].textContent;
              document.getElementById('edit-rent').value = row.cells[4].textContent;
          });

          deleteButton.addEventListener('click', function () {
              rowToDelete = row;
          });
      }

      form.addEventListener('submit', function (event) {
          event.preventDefault();

          if (!validateInput(roomType, /^[a-zA-Z\s]+$/, 'Please enter a valid room type (letters only).') ||
              !validateInput(roomStatus, /^[a-zA-Z\s]+$/, 'Please enter a valid room status (letters only).') ||
              !validateInput(bedCapacity, /^\d+$/, 'Please enter a valid bed capacity (numbers only).') ||
              !validateInput(rent, /^\d+$/, 'Please enter a valid rent amount (numbers only).')) {
              return;
          }

          addRowToTable(roomType.value, roomStatus.value, bedCapacity.value, rent.value);
          resetForm();
          $('#addRoomModal').modal('hide');
      });
/*
      document.getElementById('confirmDelete').addEventListener('click', function () {
          if (rowToDelete) {
              rowToDelete.remove();
              rowToDelete = null;
              $('#deleteRoomModal').modal('hide');
          }
      });
*/


      document.getElementById('editRoomForm').addEventListener('submit', function (event) {
          event.preventDefault(); // Prevent default form submission

          if (rowToEdit) {
              const editRoomType = document.getElementById('edit-room-type');
              const editRoomStatus = document.getElementById('edit-room-status');
              const editBedCapacity = document.getElementById('edit-bed-capacity');
              const editRent = document.getElementById('edit-rent');

              // Validate inputs in the edit form
              if (!validateInput(editRoomType, /^[a-zA-Z\s]+$/, 'Please enter a valid room type (letters only).') ||
                  !validateInput(editRoomStatus, /^[a-zA-Z\s]+$/, 'Please enter a valid room status (letters only).') ||
                  !validateInput(editBedCapacity, /^\d+$/, 'Please enter a valid bed capacity (numbers only).') ||
                  !validateInput(editRent, /^\d+$/, 'Please enter a valid rent amount (numbers only).')) {
                  return;
              }

              // Update the table row with new values
              const cells = rowToEdit.cells;
              cells[1].textContent = editRoomType.value;
              cells[2].textContent = editRoomStatus.value;
              cells[3].textContent = editBedCapacity.value;
              cells[4].textContent = editRent.value;

              // Hide the edit modal
              $('#editRoomModal').modal('hide');

              // Reset the edit form
              resetEditForm();
              rowToEdit = null;
          }
      });

      // Real-time validation for add form
      roomType.addEventListener('input', function () {
          validateInput(roomType, /^[a-zA-Z\s]+$/, 'Please enter a valid room type (letters only).');
      });

      roomStatus.addEventListener('input', function () {
          validateInput(roomStatus, /^[a-zA-Z\s]+$/, 'Please enter a valid room status (letters only).');
      });

      bedCapacity.addEventListener('input', function () {
          validateInput(bedCapacity, /^\d+$/, 'Please enter a valid bed capacity (numbers only).');
      });

      rent.addEventListener('input', function () {
          validateInput(rent, /^\d+$/, 'Please enter a valid rent amount (numbers only).');
      });

      // Real-time validation for edit form
      document.getElementById('edit-room-type').addEventListener('input', function () {
          validateInput(this, /^[a-zA-Z\s]+$/, 'Please enter a valid room type (letters only).');
      });

      document.getElementById('edit-room-status').addEventListener('input', function () {
          validateInput(this, /^[a-zA-Z\s]+$/, 'Please enter a valid room status (letters only).');
      });

      document.getElementById('edit-bed-capacity').addEventListener('input', function () {
          validateInput(this, /^\d+$/, 'Please enter a valid bed capacity (numbers only).');
      });

      document.getElementById('edit-rent').addEventListener('input', function () {
          validateInput(this, /^\d+$/, 'Please enter a valid rent amount (numbers only).');
      });
  });