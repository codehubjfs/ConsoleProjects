document.addEventListener('DOMContentLoaded', function () {
    const taskForm = document.getElementById('taskForm');
    const employeeTableBody = document.getElementById('employeeTableBody');
    const addTaskModal = new bootstrap.Modal(document.getElementById('addTaskModal'));
    const editTaskModal = new bootstrap.Modal(document.getElementById('editTaskModal'));
    const deleteTaskModal = new bootstrap.Modal(document.getElementById('deleteTaskModal'));
    const editTaskForm = document.getElementById('editTaskForm');
    const confirmDelete = document.getElementById('confirmDelete');
    let employees = [];
    let currentEditIndex = null;
    let currentDeleteIndex = null;

    taskForm.addEventListener('submit', function (event) {
        event.preventDefault();
        if (!taskForm.checkValidity()) {
            event.stopPropagation();
            taskForm.classList.add('was-validated');
            return;
        }

        const empName = document.getElementById('empName').value;
        const empID = document.getElementById('empID').value;
        const emailId = document.getElementById('emailId').value;
        const password = document.getElementById('password').value;
        const city = document.getElementById('city').value;
        const hiredate = document.getElementById('hiredate').value;
        const magid = document.getElementById('magid').value;

        const employee = {
            empName,
            empID,
            emailId,
            password,
            city,
            hiredate,
            magid
        };

        employees.push(employee);
        renderEmployeeTable();
        taskForm.reset();
        taskForm.classList.remove('was-validated');
        addTaskModal.hide();
    });

    function renderEmployeeTable() {
        employeeTableBody.innerHTML = '';
        employees.forEach((employee, index) => {
            const row = document.createElement('tr');
            row.innerHTML = `
                <td>${employee.empName}</td>
                <td>${employee.empID}</td>
                <td>${employee.emailId}</td>
                <td>${employee.password}</td>
                <td>${employee.city}</td>
                <td>${employee.hiredate}</td>
                <td>${employee.magid}</td>
                <td>
                    <button class="btn btn-warning btn-sm edit-btn" data-index="${index}"><i class="fa fa-edit"></i></button>
                    <button class="btn btn-danger btn-sm delete-btn" data-index="${index}"><i class="fa fa-trash"></i></button>
                </td>
            `;
            employeeTableBody.appendChild(row);
        });

        document.querySelectorAll('.edit-btn').forEach(button => {
            button.addEventListener('click', function () {
                const index = this.dataset.index;
                currentEditIndex = index;
                const employee = employees[index];
                document.getElementById('editEmpIndex').value = index;
                document.getElementById('editEmpName').value = employee.empName;
                document.getElementById('editEmpID').value = employee.empID;
                document.getElementById('editEmailId').value = employee.emailId;
                document.getElementById('editPassword').value = employee.password;
                document.getElementById('editCity').value = employee.city;
                document.getElementById('editHiredate').value = employee.hiredate;
                document.getElementById('editMagid').value = employee.magid;
                editTaskModal.show();
            });
        });

        document.querySelectorAll('.delete-btn').forEach(button => {
            button.addEventListener('click', function () {
                const index = this.dataset.index;
                currentDeleteIndex = index;
                deleteTaskModal.show();
            });
        });
    }

    editTaskForm.addEventListener('submit', function (event) {
        event.preventDefault();
        if (!editTaskForm.checkValidity()) {
            event.stopPropagation();
            editTaskForm.classList.add('was-validated');
            return;
        }

        const index = document.getElementById('editEmpIndex').value;
        const empName = document.getElementById('editEmpName').value;
        const empID = document.getElementById('editEmpID').value;
        const emailId = document.getElementById('editEmailId').value;
        const password = document.getElementById('editPassword').value;
        const city = document.getElementById('editCity').value;
        const hiredate = document.getElementById('editHiredate').value;
        const magid = document.getElementById('editMagid').value;

        employees[index] = {
            empName,
            empID,
            emailId,
            password,
            city,
            hiredate,
            magid
        };

        renderEmployeeTable();
        editTaskForm.classList.remove('was-validated');
        editTaskModal.hide();
    });

    confirmDelete.addEventListener('click', function () {
        if (currentDeleteIndex !== null) {
            employees.splice(currentDeleteIndex, 1);
            renderEmployeeTable();
            deleteTaskModal.hide();
            currentDeleteIndex = null;
        }
    });

    renderEmployeeTable();
});
