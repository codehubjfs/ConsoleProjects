 let cardToDelete = '';
        let cardToEdit = '';

        function openEditModal(id) {
            cardToEdit = 'card-' + id;
            const card = document.getElementById(cardToEdit);
            document.getElementById('editRate').value = card.querySelector('.rate').textContent.trim();
            document.getElementById('editPetrolType').value = card.querySelector('.petrol').textContent.trim();
            document.getElementById('editSeat').value = card.querySelector('.seat').textContent.trim();
            document.getElementById('editBaggage').value = card.querySelector('.baggage').textContent.trim();
            new bootstrap.Modal(document.getElementById('editModal')).show();
        }

        function saveChanges() {
            const card = document.getElementById(cardToEdit);
            card.querySelector('.rate').innerHTML = `<i class="fas fa-rupee-sign"></i> ${document.getElementById('editRate').value}`;
            card.querySelector('.petrol').innerHTML = `<i class="fas fa-gas-pump"></i> ${document.getElementById('editPetrolType').value}`;
            card.querySelector('.seat').innerHTML = ` <i class="fas fa-users"></i>${document.getElementById('editSeat').value}`;
            card.querySelector('.baggage').innerHTML = `<i class="fas fa-suitcase"></i> ${document.getElementById('editBaggage').value}`;
            new bootstrap.Modal(document.getElementById('editModal')).hide();
        }

        function openDeleteModal(id) {
            cardToDelete = 'card-' + id;
            document.getElementById('deleteBookingId').value = id;
            new bootstrap.Modal(document.getElementById('deleteModal')).show();
        }

        function deleteCard() {
            document.getElementById(cardToDelete).remove();
            new bootstrap.Modal(document.getElementById('deleteModal')).hide();
        }
        
const currentPage = window.location.href;

 
if (currentPage.includes('main.html')) {
    document.getElementById('dashboardLink').classList.add('active');
} else if (currentPage.includes('carlist.html')) {
    document.getElementById('carsLink').classList.add('active');
}
