document.addEventListener("DOMContentLoaded", function () {
    const adminTableBody = document.getElementById("adminTableBody");
    const addAdminForm = document.getElementById("addAdminForm");
    const editAdminForm = document.getElementById("editAdminForm");
    const confirmDeleteAdminBtn = document.getElementById("confirmDeleteAdmin");

    let admins = [
        { username: "admin1", email: "admin1@example.com", password: "admin123" }
    ];

    function renderTable() {
        adminTableBody.innerHTML = "";
        admins.forEach((admin, index) => {
            const row = document.createElement("tr");
            row.innerHTML = `
                <td>${admin.username}</td>
                <td>${admin.email}</td>
                <td>${admin.password}</td>
                <td>
                    <a href="#" class="edit-admin" data-index="${index}" data-toggle="modal" data-target="#editAdminModal"><i class="fa fa-edit"></i></a>
                    <a href="#" class="delete-admin" data-index="${index}" data-toggle="modal" data-target="#deleteAdminModal"><i class="fa fa-trash"></i></a>
                </td>
            `;
            adminTableBody.appendChild(row);
        });
    }

    function validateForm(form) {
        let valid = true;
        // Reset validation messages
        form.querySelectorAll("input[required]").forEach(input => {
            input.classList.remove("is-invalid");
            if (!input.value.trim()) {
                input.classList.add("is-invalid");
                valid = false;
            }
        });
        return valid;
    }

    addAdminForm.addEventListener("submit", function (e) {
        e.preventDefault();
        if (validateForm(addAdminForm)) {
            const newAdmin = {
                username: addAdminForm.addAdminUsername.value,
                email: addAdminForm.addAdminEmail.value,
                password: "admin123"
            };
            admins.push(newAdmin);
            renderTable();
            addAdminForm.reset();
            $("#addAdminModal").modal("hide");
        }
    });

    editAdminForm.addEventListener("submit", function (e) {
        e.preventDefault();
        if (validateForm(editAdminForm)) {
            const index = editAdminForm.editAdminIndex.value;
            admins[index].username = editAdminForm.editAdminUsername.value;
            admins[index].email = editAdminForm.editAdminEmail.value;
            renderTable();
            $("#editAdminModal").modal("hide");
        }
    });

    adminTableBody.addEventListener("click", function (e) {
        if (e.target.classList.contains("edit-admin")) {
            const index = e.target.getAttribute("data-index");
            editAdminForm.editAdminIndex.value = index;
            editAdminForm.editAdminUsername.value = admins[index].username;
            editAdminForm.editAdminEmail.value = admins[index].email;
        } else if (e.target.classList.contains("delete-admin")) {
            const index = e.target.getAttribute("data-index");
            confirmDeleteAdminBtn.setAttribute("data-index", index);
        }
    });

    confirmDeleteAdminBtn.addEventListener("click", function () {
        const index = confirmDeleteAdminBtn.getAttribute("data-index");
        admins.splice(index, 1);
        renderTable();
        $("#deleteAdminModal").modal("hide");
    });

    // Clear form validation classes on modal open
    $('#addAdminModal').on('show.bs.modal', function () {
        addAdminForm.classList.remove("was-validated");
    });

    $('#editAdminModal').on('show.bs.modal', function () {
        editAdminForm.classList.remove("was-validated");
    });

    // Validate forms on submit
    addAdminForm.addEventListener('submit', function (event) {
        if (!validateForm(addAdminForm)) {
            event.preventDefault();
            event.stopPropagation();
            addAdminForm.classList.add('was-validated');
        }
    }, false);

    editAdminForm.addEventListener('submit', function (event) {
        if (!validateForm(editAdminForm)) {
            event.preventDefault();
            event.stopPropagation();
            editAdminForm.classList.add('was-validated');
        }
    }, false);

    renderTable();
});

// JavaScript code for handling Edit Profile functionality

// Populate profile modal with data
function populateProfileModal() {
    document.getElementById('profilePicture').src = userProfile.picture;
    document.getElementById('profileName').value = userProfile.name;
    document.getElementById('profileEmail').value = userProfile.email;
    document.getElementById('profilePhone').value = userProfile.phone;
    document.getElementById('profileOccupation').value = userProfile.occupation;
    document.getElementById('profileCity').value = userProfile.city;
}

// Save profile changes
document.getElementById('editProfileForm').addEventListener('submit', function(event) {
    event.preventDefault();
    userProfile.phone = document.getElementById('profilePhone').value;
    userProfile.city = document.getElementById('profileCity').value;
    alert('Profile updated successfully!');
    $('#editProfileModal').modal('hide');
});

// Populate profile modal on page load
document.addEventListener('DOMContentLoaded', populateProfileModal);
