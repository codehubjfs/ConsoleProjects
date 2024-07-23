document.addEventListener('DOMContentLoaded', (event) => {
    const taskForm = document.getElementById('taskForm');
    const taskTable = document.getElementById('taskTable').getElementsByTagName('tbody')[0];

    taskForm.addEventListener('submit', function (event) {
        if (taskForm.checkValidity() === false || !validateDates('startDate', 'endDate')) {
            event.preventDefault();
            event.stopPropagation();
            taskForm.classList.add('was-validated');
        }
    });

    function validateDates(startDateId, endDateId) {
        const startDate = document.getElementById(startDateId).value;
        const endDate = document.getElementById(endDateId).value;

        if (new Date(startDate) > new Date(endDate)) {
            alert('End Date should not be before Start Date');
            return false;
        }
        return true;
    }

    // Edit Task Modal
    const editTaskForm = document.getElementById('editTaskForm');
    let currentRow;

    taskTable.addEventListener('click', function (event) {
        if (event.target.closest('.edit-task')) {
            currentRow = event.target.closest('tr');

            document.getElementById('editTaskId').value = currentRow.cells[0].innerText; // Assuming task ID is in the first cell
            document.getElementById('editTaskName').value = currentRow.cells[1].innerText;
            document.getElementById('editTaskDescription').value = currentRow.cells[2].innerText;
            document.getElementById('editTaskPriority').value = currentRow.cells[3].innerText;
            document.getElementById('editStartDate').value = currentRow.cells[4].innerText;
            document.getElementById('editEndDate').value = currentRow.cells[5].innerText;
        }
    });

    // Enable task ID field before submitting the form
    editTaskForm.addEventListener('submit', function (event) {
        document.getElementById('editTaskId').disabled = false;
    });
});
