 function openEditModal( ) {
            // document.getElementById('editBookingId').value = id;
            // document.getElementById('editCustomerName').value = customerName;
            // document.getElementById('editCar').value = car;
            // document.getElementById('editDate').value = date;
            // document.getElementById('editDuration').value = duration;
            var statusjs=document.getElementById('editStatus').value;
            document.getElementsByClassName('status').textContent=statusjs;
            // document.getElementById('editBookingId').value = status;
            var editModal = new bootstrap.Modal(document.getElementById('editModal'));
            editModal.show();

        }
        // Function to save changes

    document.querySelectorAll('.status')
    .forEach(button => button.addEventListener('click',function() {
        let row = this.closest('tr');
        var modal  = new bootstrap.Modal(document.getElementById('editModal'));
        modal.show();
        document.querySelector('.btn-eddit').addEventListener('click',function(){
            let selectText =  row.querySelector('.status-text');
            let choosen = document.querySelector('.edit-sts');
            console.log(choosen.value+" "+selectText);
            selectText.textContent = choosen.value;
        })
    }));

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