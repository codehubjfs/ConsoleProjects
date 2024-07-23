 function openEditModal(id, customerName, car, date, duration, status) {
            document.getElementById('editBookingId').value = id;
            document.getElementById('editCustomerName').value = customerName;
            document.getElementById('editCar').value = car;
            document.getElementById('editDate').value = date;
            document.getElementById('editDuration').value = duration;
            document.getElementById('editStatus').value = status;
            var editModal = new bootstrap.Modal(document.getElementById('editModal'));
            editModal.show();
        }
        
const currentPage = window.location.href;


if (currentPage.includes('bookingsadmin.html')) {
    document.getElementById('booking').classList.add('active');
} else if (currentPage.includes('carlist.html')) {
    document.getElementById('carsLink').classList.add('active');
}


        function openViewModal(id, customerName, car, date, duration, status) {
            document.getElementById('viewBookingId').innerText = id;
            document.getElementById('viewCustomerName').innerText = customerName;
            document.getElementById('viewCar').innerText = car;
            document.getElementById('viewDate').innerText = date;
            document.getElementById('viewDuration').innerText = duration;
            document.getElementById('viewStatus').innerText = status;
            var viewModal = new bootstrap.Modal(document.getElementById('viewModal'));
            viewModal.show();
        }

        function openDeleteModal(id) {
            document.getElementById('deleteBookingId').innerText = id;
            var deleteModal = new bootstrap.Modal(document.getElementById('deleteModal'));
            deleteModal.show();
        }