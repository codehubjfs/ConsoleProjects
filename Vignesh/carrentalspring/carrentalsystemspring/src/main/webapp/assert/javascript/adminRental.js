 let cardToDelete = '';
        let cardToEdit = '';

        function openEditModal(id) {
            cardToEdit = 'card-' + id;
            const card = document.getElementById(cardToEdit);
            document.getElementById('editRate').value = card.querySelector('.rate').textContent.trim();
            document.getElementById('editType').value = card.querySelector('.type').textContent.trim();
            document.getElementById('editDuration').value = card.querySelector('.duration').textContent.trim();
            document.getElementById('editAvailability').value = card.querySelector('.availability').textContent.trim();
            new bootstrap.Modal(document.getElementById('editModal')).show();
        }

        function saveChanges() {
            const card = document.getElementById(cardToEdit);
            card.querySelector('.rate').innerHTML = `<i class="fas fa-rupee-sign"></i> ${document.getElementById('editRate').value}`;
            card.querySelector('.type').innerHTML = `<i class="fas fa-car-side"></i> ${document.getElementById('editType').value}`;
            card.querySelector('.duration').innerHTML = `<i class="fas fa-clock"></i> ${document.getElementById('editDuration').value}`;
            card.querySelector('.availability').innerHTML = ` ${document.getElementById('editAvailability').value}`;
            new bootstrap.Modal(document.getElementById('editModal')).hide();
        }

        function openDeleteModal(id) {
            cardToDelete = 'card-' + id;
            document.getElementById('deletePackageId').value = id;
            new bootstrap.Modal(document.getElementById('deleteModal')).show();
        }


        function deleteCard() {
            document.getElementById(cardToDelete).remove();
            new bootstrap.Modal(document.getElementById('deleteModal')).hide();
        }