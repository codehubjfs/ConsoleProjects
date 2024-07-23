/**
 * 
 */


  const rooms = [
    { roomNo: 101, category: 'Single', price: 1000 },
    { roomNo: 102, category: 'Single', price: 1000 },
    { roomNo: 103, category: 'Single', price: 1000 },
    { roomNo: 104, category: 'Single', price: 1000 },
    { roomNo: 105, category: 'Single', price: 1000 },
    { roomNo: 201, category: 'Double', price: 2000 },
    { roomNo: 202, category: 'Double', price: 2000 },
    { roomNo: 203, category: 'Double', price: 2000 },
    { roomNo: 204, category: 'Double', price: 2000 },
    { roomNo: 205, category: 'Double', price: 2000 },
    { roomNo: 301, category: 'Family', price: 3000 },
    { roomNo: 401, category: 'Luxury', price: 4000 },
  ];

  let cart = [];

  function viewRooms(category) {
    const roomContainer = document.getElementById('roomContainer');
    roomContainer.innerHTML = ''; // Clear the container before inserting new rooms

   const filteredRooms = rooms.filter(room => room.category === category);
  filteredRooms.forEach(room => {
    const roomCard = `
      <div class="col-md-6 mb-4">
        <div class="card card-fixed-height">
          <div class="card-body">
            <h5 class="card-title">${category} Room</h5>
            <p>Room No: ${room.roomNo}</p>
            <p>Price: &#x20B9;${room.price} per night</p>
            <button class="btn btn-dark btn-fixed-right btn-sm" onclick="addToCart('${category}', ${room.roomNo}, ${room.price})" style="width:50px" >Book</button>
          </div>
        </div>
      </div>
    `;
    roomContainer.insertAdjacentHTML('beforeend', roomCard);
  });
  }

  function addToCart(category, roomNo, price) {
    const room = cart.find(item => item.roomNo === roomNo);
    if (room) {
      room.qty++;
    } else {
      cart.push({ category, roomNo, price, qty: 1 });
    }
    document.getElementById('confirmBookingButton').disabled = false;
    updateCartItemCount();
    updateCartModal();
  }

  function updateCartModal() {
    const cartItems = document.getElementById('cartItems');
    cartItems.innerHTML = '';

    cart.forEach(item => {
      const total = item.price * item.qty;
      const cartItem = `
        <tr>
          <td>${item.category} Room No: ${item.roomNo}</td>
          <td>&#x20B9;${item.price}</td>
          <td>${item.qty}</td>
          <td>&#x20B9;${total}</td>
          <td><button class="btn btn-danger btn-sm" onclick="removeFromCart(${item.roomNo})">Remove</button></td>
        </tr>
      `;
      cartItems.insertAdjacentHTML('beforeend', cartItem);
    });

    $('#cartModal').modal('show');
  }

  function removeFromCart(roomNo) {
    cart = cart.filter(item => item.roomNo !== roomNo);
    updateCartItemCount();
    updateCartModal();
    if (cart.length === 0) {
      document.getElementById('confirmBookingButton').disabled = true;
    }
  }

  function confirmBooking() {
    $('#cartModal').modal('hide');
    $('#bookingDetailsModal').modal('show');
  }

  function filterRooms() {
    const searchInput = document.getElementById('searchInput').value.toLowerCase();
    const minPrice = document.getElementById('minPrice').value;
    const maxPrice = document.getElementById('maxPrice').value;

    const roomContainer = document.getElementById('roomContainer');
    roomContainer.innerHTML = '';

    const filteredRooms = rooms.filter(room => {
      const matchesCategory = room.category.toLowerCase().includes(searchInput);
      const matchesMinPrice = !minPrice || room.price >= minPrice;
      const matchesMaxPrice = !maxPrice || room.price <= maxPrice;
      return matchesCategory && matchesMinPrice && matchesMaxPrice;
    });

    if (filteredRooms.length === 0) {
      roomContainer.innerHTML = '<p class="text-center">No rooms found matching the criteria.</p>';
    } else {
      filteredRooms.forEach(room => {
        const roomCard = `
          <div class="col-md-6 mb-4">
            <div class="card card-fixed-height">
              <div class="card-body">
                <h5 class="card-title">${room.category} Room</h5>
                <p>Room No: ${room.roomNo}</p>
                <p>Price: &#x20B9;${room.price} per night</p>
                <button class="btn btn-primary" onclick="addToCart('${room.category}', ${room.roomNo}, ${room.price})" style="width:100px">Book</button>
              </div>
            </div>
          </div>
        `;
        roomContainer.insertAdjacentHTML('beforeend', roomCard);
      });
    }
  }

  function showCartModal() {
    updateCartModal();
  }

  function updateCartItemCount() {
    const cartItemCount = document.getElementById('cartItemCount');
    const totalItems = cart.reduce((sum, item) => sum + item.qty, 0);
    cartItemCount.textContent = totalItems;
  }

  document.getElementById('bookingDetailsForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    const phone = document.getElementById('phone').value;

    console.log('Booking Details:', { name, email, phone, cart });

    alert('Booking Confirmed!');
    $('#bookingDetailsModal').modal('hide');

    cart = [];
    document.getElementById('confirmBookingButton').disabled = true;
    document.getElementById('bookingDetailsForm').reset();
    updateCartItemCount();
    updateCartModal();
  });

  function finalizeBooking() {
    alert('Booking Confirmed!');
    $('#confirmBookingModal').modal('hide');
    cart = [];
    document.getElementById('confirmBookingButton').disabled = true;
    updateCartItemCount();
    updateCartModal();
  }
