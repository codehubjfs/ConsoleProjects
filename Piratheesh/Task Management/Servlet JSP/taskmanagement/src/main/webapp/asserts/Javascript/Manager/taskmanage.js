
document.addEventListener('DOMContentLoaded', (event) => {
    const taskForm = document.getElementById('taskForm');
    const taskTable = document.getElementById('taskTable').getElementsByTagName('tbody')[0];
    let currentEditRow = null;

    taskForm.addEventListener('submit', function(event) {
        event.preventDefault();
        event.stopPropagation();
        taskForm.classList.add('was-validated');

        const taskName = document.getElementById('taskName');
        const taskDescription = document.getElementById('taskDescription');
        const taskID = document.getElementById('taskID');
        const startDate = document.getElementById('startDate');
        const endDate = document.getElementById('endDate');

        if (taskForm.checkValidity() === false) {
            return;
        }

        if (new Date(startDate.value) > new Date(endDate.value)) {
            endDate.setCustomValidity('End Date must be after Start Date');
            taskForm.classList.add('was-validated');
            return;
        } else {
            endDate.setCustomValidity('');
        }

        const task = {
            taskName: taskName.value,
            taskDescription: taskDescription.value,
            taskID: taskID.value,
            startDate: startDate.value,
            endDate: endDate.value
        };

        addTaskToTable(task);
        taskForm.reset();
        taskForm.classList.remove('was-validated');
        $('#addTaskModal').modal('hide');
        $('.modal-backdrop').remove(); // Remove the backdrop
    });

    function addTaskToTable(task) {
        const row = taskTable.insertRow();
        row.insertCell(0).innerText = task.taskName;
        row.insertCell(1).innerText = task.taskDescription;
        row.insertCell(2).innerText = task.taskID;
        row.insertCell(3).innerText = task.startDate;
        row.insertCell(4).innerText = task.endDate;

        const actionsCell = row.insertCell(5);
        const editButton = document.createElement('a');
        editButton.href = '#';
        editButton.classList.add('edit-task');
        editButton.dataset.toggle = 'modal';
        editButton.dataset.target = '#editTaskModal';
        editButton.innerHTML = '<i class="fa fa-edit"></i>';
        actionsCell.appendChild(editButton);

        const deleteButton = document.createElement('a');
        deleteButton.href = '#';
        deleteButton.classList.add('delete-task');
        deleteButton.dataset.toggle = 'modal';
        deleteButton.dataset.target = '#deleteTaskModal';
        deleteButton.innerHTML = '<i class="fa fa-trash"></i>';
        actionsCell.appendChild(deleteButton);

        editButton.addEventListener('click', function() {
            editTask(row);
        });

        deleteButton.addEventListener('click', function() {
            deleteTask(row);
        });
    }

    function editTask(row) {
        currentEditRow = row;
        const cells = row.getElementsByTagName('td');
        document.getElementById('editTaskName').value = cells[0].innerText;
        document.getElementById('editTaskDescription').value = cells[1].innerText;
        document.getElementById('editTaskID').value = cells[2].innerText;
        document.getElementById('editStartDate').value = cells[3].innerText;
        document.getElementById('editEndDate').value = cells[4].innerText;
    }

    document.getElementById('editTaskForm').addEventListener('submit', function(event) {
        event.preventDefault();
        event.stopPropagation();
        this.classList.add('was-validated');

        if (this.checkValidity() === false) {
            return;
        }

        const editTaskName = document.getElementById('editTaskName');
        const editTaskDescription = document.getElementById('editTaskDescription');
        const editTaskID = document.getElementById('editTaskID');
        const editStartDate = document.getElementById('editStartDate');
        const editEndDate = document.getElementById('editEndDate');

        if (new Date(editStartDate.value) > new Date(editEndDate.value)) {
            editEndDate.setCustomValidity('End Date must be after Start Date');
            this.classList.add('was-validated');
            return;
        } else {
            editEndDate.setCustomValidity('');
        }

        if (currentEditRow) {
            const cells = currentEditRow.getElementsByTagName('td');
            cells[0].innerText = editTaskName.value;
            cells[1].innerText = editTaskDescription.value;
            cells[2].innerText = editTaskID.value;
            cells[3].innerText = editStartDate.value;
            cells[4].innerText = editEndDate.value;

            $('#editTaskModal').modal('hide');
            $('.modal-backdrop').remove(); // Remove the backdrop
        }
    });

    function deleteTask(row) {
        document.getElementById('confirmDelete').onclick = function() {
            row.remove();
            $('#deleteTaskModal').modal('hide');
            $('.modal-backdrop').remove(); // Remove the backdrop
        };
    }
});





document.addEventListener('DOMContentLoaded', () => {
    const taskForm = document.getElementById('taskForm');
    const editTaskForm = document.getElementById('editTaskForm');
    const taskTable = document.querySelector('.table tbody');
    let rowToDelete;

    // Function to handle form submission for adding a new task
    taskForm.addEventListener('submit', function (event) {
        event.preventDefault();
        event.stopPropagation();

        if (taskForm.checkValidity()) {
            const taskName = document.getElementById('taskName').value;
            const assignedTo = document.getElementById('assignedTo').value;
            const dueDate = document.getElementById('dueDate').value;
            const status = document.getElementById('status').value;

            const newRow = taskTable.insertRow(0);
            newRow.innerHTML = `
                <td>${taskName}</td>
                <td>${assignedTo}</td>
                <td>${dueDate}</td>
                <td>${status}</td>
                <td>
                    <a href="#" class="edit-task" data-toggle="modal" data-target="#editTaskModal" data-task='{"name": "${taskName}", "assignedTo": "${assignedTo}", "dueDate": "${dueDate}", "status": "${status}"}'><i class="fa fa-edit"></i></a>
                    <a href="#" class="delete-task"><i class="fa fa-trash"></i></a>
                </td>
                
            `;

            // Clear form fields
            taskForm.reset();
            taskForm.classList.remove('was-validated');
        } else {
            taskForm.classList.add('was-validated');
        }
    }, false);

    // Function to handle edit button click
    document.addEventListener('click', function (event) {
        if (event.target && event.target.matches('.edit-task, .edit-task i')) {
            const editButton = event.target.closest('.edit-task');
            const taskData = JSON.parse(editButton.getAttribute('data-task'));

            document.getElementById('editTaskId').value = editButton.closest('tr').rowIndex;
            document.getElementById('editTaskName').value = taskData.name;
            document.getElementById('editAssignedTo').value = taskData.assignedTo;
            document.getElementById('editDueDate').value = taskData.dueDate;
            document.getElementById('editStatus').value = taskData.status;
        }
    });

    // Function to handle save changes in the edit modal
    editTaskForm.addEventListener('submit', function (event) {
        event.preventDefault();
        event.stopPropagation();

        if (editTaskForm.checkValidity()) {
            const taskId = document.getElementById('editTaskId').value;
            const taskName = document.getElementById('editTaskName').value;
            const assignedTo = document.getElementById('editAssignedTo').value;
            const dueDate = document.getElementById('editDueDate').value;
            const status = document.getElementById('editStatus').value;

            const row = taskTable.rows[taskId - 1];
            row.cells[0].innerHTML = taskName;
            row.cells[1].innerHTML = assignedTo;
            row.cells[2].innerHTML = dueDate;
            row.cells[3].innerHTML = status;

            // Update data-task attribute
            row.cells[4].querySelector('.edit-task').setAttribute('data-task', JSON.stringify({
                name: taskName,
                assignedTo: assignedTo,
                dueDate: dueDate,
                status: status
            }));

            // Close the modal
            $('#editTaskModal').modal('hide');
            editTaskForm.reset();
            editTaskForm.classList.remove('was-validated');
        } else {
            editTaskForm.classList.add('was-validated');
        }
    }, false);

    // Function to handle delete button click
    document.addEventListener('click', function (event) {
        if (event.target && event.target.matches('.delete-task, .delete-task i')) {
            const deleteButton = event.target.closest('.delete-task');
            rowToDelete = deleteButton.closest('tr');
            $('#deleteTaskModal1').modal('show');
        }
    });

    // Function to handle delete confirmation
    document.getElementById('confirmDeleteButton').addEventListener('click', function () {
        taskTable.deleteRow(rowToDelete.rowIndex - 1);
        $('#deleteTaskModal1').modal('hide');
    });
});
