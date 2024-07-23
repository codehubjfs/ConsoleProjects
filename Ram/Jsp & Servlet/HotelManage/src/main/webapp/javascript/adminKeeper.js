/**
 * 
 */
 $(document).ready(function () {
        let housekeepers = [];
        let editIndex = -1;

        function renderTable() {
            const tbody = $('#personTable tbody');
            tbody.empty();
            housekeepers.forEach((housekeeper, index) => {
                tbody.append(`
                    <tr>
                        <td>${index + 1}</td>
                        <td>${housekeeper.name}</td>
                        <td>${housekeeper.email}</td>
                        <td>${housekeeper.phone}</td>
                        <td>${housekeeper.lastCleanDate || '-'}</td>
                        <td>${housekeeper.nextCleanDate || '-'}</td>
                        <td>${housekeeper.status}</td>
                        <td>
                            <button class="btn btn-info btn-sm edit-btn" data-index="${index}">Edit</button>
                            <button class="btn btn-danger btn-sm delete-btn" data-index="${index}">Delete</button>
                        </td>
                    </tr>
                `);
            });
        }

        $('#addHousekeeperForm').submit(function (event) {
            event.preventDefault();
            const housekeeper = {
                name: $('#housekeeperName').val(),
                email: $('#housekeeperEmail').val(),
                phone: $('#housekeeperPhone').val(),
                status: $('#housekeeperStatus').val(),
                lastCleanDate: null,
                nextCleanDate: null
            };
            housekeepers.push(housekeeper);
            renderTable();
            $('#addHousekeeperModal').modal('hide');
            this.reset();
        });

        $(document).on('click', '.edit-btn', function () {
            editIndex = $(this).data('index');
            const housekeeper = housekeepers[editIndex];
            $('#editHousekeeperName').val(housekeeper.name);
            $('#editHousekeeperEmail').val(housekeeper.email);
            $('#editHousekeeperPhone').val(housekeeper.phone);
            $('#editHousekeeperStatus').val(housekeeper.status);
            $('#editHousekeeperModal').modal('show');
        });

        $('#editHousekeeperForm').submit(function (event) {
            event.preventDefault();
            housekeepers[editIndex] = {
                ...housekeepers[editIndex],
                name: $('#editHousekeeperName').val(),
                email: $('#editHousekeeperEmail').val(),
                phone: $('#editHousekeeperPhone').val(),
                status: $('#editHousekeeperStatus').val()
            };
            renderTable();
            $('#editHousekeeperModal').modal('hide');
            editIndex = -1;
        });

        $(document).on('click', '.delete-btn', function () {
            const index = $(this).data('index');
            housekeepers.splice(index, 1);
            renderTable();
        });
    });