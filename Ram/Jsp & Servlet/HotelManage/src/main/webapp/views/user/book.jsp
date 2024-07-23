<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>RK Hotel Booking</title>
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="../../css/user/booking.css">
  <style>
    /* Your existing styles */
  </style>
</head>
<body>
<header>
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
      <a class="navbar-brand" href="main.jsp">RK Hotel</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
        aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item">
            <a class="nav-link" href="main.jsp">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="room.jsp">Rooms</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="about.jsp">About</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="contact.jsp">Contact</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#cartSection">Cart <span id="cartItemCount" class="badge badge-danger"><%= session.getAttribute("cart") != null ? ((List<Room>) session.getAttribute("cart")).size() : 0 %></span></a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
  <div id="hero" class="hero">
    <div class="container text-center text-white">
      <h1>Welcome to RK Hotel</h1>
      <p class="lead">"Unlock Your Dream Room"</p>
    </div>
  </div>
</header>

<main class="container mt-4">
  <h2 class="text-center mb-4" style="font-weight: bolder; color:rgb(255, 143, 0)">Rooms Available</h2>

  <div class="row">
    <%
      List<Room> rooms = (List<Room>) request.getAttribute("rooms");
      if (rooms != null) {
        for (Room room : rooms) {
    %>
      <div class="col-md-3 mb-4">
        <div class="card card-fixed-height">
          <img src="../../images/<%= room.getType().toLowerCase() %>.jpg" class="card-img-top" alt="<%= room.getType() %> Room">
          <div class="card-body">
            <h5 class="card-title"><%= room.getType() %> Room</h5>
            <p class="card-text">$<%= room.getPrice() %> per night</p>
            <form action="rooms" method="post">
              <input type="hidden" name="roomId" value="<%= room.getId() %>">
              <button class="btn btn-primary" type="submit">Book Now</button>
            </form>
          </div>
        </div>
      </div>
    <%
        }
      }
    %>
  </div>

  <!-- Cart Section -->
  <h2 class="text-center mb-4" id="cartSection">Your Cart</h2>
  <%
    List<Room> cart = (List<Room>) session.getAttribute("cart");
    if (cart != null && !cart.isEmpty()) {
  %>
  <table class="table">
    <thead>
      <tr>
        <th scope="col">Room Type</th>
        <th scope="col">Price</th>
        <th scope="col">Action</th>
      </tr>
    </thead>
    <tbody>
      <%
        double total = 0;
        for (Room room : cart) {
          total += room.getPrice();
      %>
      <tr>
        <td><%= room.getType() %></td>
        <td>$<%= room.getPrice() %></td>
        <td>
          <form action="cart" method="post">
            <input type="hidden" name="_method" value="delete">
            <input type="hidden" name="roomId" value="<%= room.getId() %>">
            <button class="btn btn-danger" type="submit">Remove</button>
          </form>
        </td>
      </tr>
      <%
        }
      %>
      <tr>
        <td colspan="2" class="text-right"><strong>Total: $<%= total %></strong></td>
        <td>
          <form action="checkout" method="post">
            <button class="btn btn-primary" type="submit">Proceed to Checkout</button>
          </form>
        </td>
      </tr>
    </tbody>
  </table>
  <%
    } else {
  %>
  <p class="text-center">Your cart is empty.</p>
  <%
    }
  %>
</main>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="../../javascript/user/booking.js"></script>
</body>
</html>
