<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
    />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"
    />
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css2?family=Lato:wght@400;700&family=Playfair+Display:wght@400;700&display=swap"
    />
   <link rel="stylesheet" href="css/user/main.css">
    
    <title>Rk Hotel</title>
    <style>
 .hero {
            background-image: url(images/cityhotel.jpg);
           /* background-color: #FCEE21 center/cover no-repeat;*/
            height: 100vh;
            color: #fff;
            display: flex;
            justify-content: center;
            align-items: center;
        }
         .hero {
    height: calc(100vh - 70px); /* Adjust the height of the hero section to exclude navbar height */
   /* background: url('./images/r2.jpg') no-repeat center center;*/
    background-color: linear-gradient(to bottom, #ffff00 0%, #ffffcc 100%);
    background-size: cover;
    position: relative;
    display: flex;
    justify-content: center;
    align-items: center;
    width: 100%;
}

.hero::before {
    content: "";
    position: absolute;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    background: rgba(0, 0, 0, 0.5); /* Add a semi-transparent overlay */
}

.hero .container {
    position: relative;
    z-index: 1;
}

.hero__text-box {
    color: #fff;
    text-shadow: 0 2px 4px rgba(0, 0, 0, 0.6);
    text-align: center;
    max-width: 600px; /* Limit the width of the text box */
    margin: 0 auto; /* Center the text box horizontally */
}

.hero__text-top {
    font-size: 3rem;
    font-weight: bold;
}

.hero__text-bottom {
    font-size: 5rem;
    font-weight: bold;
}
 
 </style>
    
  </head>
  <body>
    <header>
      <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container">
          <a class="navbar-brand" href="index.jsp">Rk Hotel</a>
         
          <button
            class="navbar-toggler"
            type="button"
            data-toggle="collapse"
            data-target="#navbarNav"
            aria-controls="navbarNav"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span class="navbar-toggler-icon"></span>
          </button>
         <div class="collapse navbar-collapse" id="navbarNav">
  <ul class="navbar-nav ml-auto">
    <li class="nav-item">
      <a class="nav-link" href="index.jsp">Home</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="views/user/room.jsp">Rooms</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="views/user/about.jsp">About</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="views/user/contact.jsp">Contact</a>
    </li>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
     <c:choose>
    <c:when test="${not empty sessionScope.user}">
        <li class="nav-item">
            <a class="nav-link btn btn-light text-white mr-2" href="views/user/room.jsp">
                <span style="color: black">Book</span>
            </a>				
        </li>
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle d-flex align-items-center" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    <img src="images/admin.jpg" alt="Profile" class="rounded-circle mr-2" style="width: 30px; height: 30px;">
    <h6 class="mb-0" th:text="${user}"></h6>
</a>

            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
                <a class="dropdown-item" href="${pageContext.request.contextPath}/FetchProfileServlet">View Profile</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="${pageContext.request.contextPath}/LogoutUserServlet">Logout</a>
            </div>
        </li>
    </c:when>
    <c:otherwise>
        <li class="nav-item">
            <a class="nav-link btn btn-light text-white" href="views/user/login.jsp">
                <span style="color: black">Login / Register</span>
            </a>
        </li>
    </c:otherwise>
</c:choose>
  </ul>
</div>
        </div>
      </nav>
      <div
        id="hero"
        class="hero d-flex justify-content-center align-items-center"
      >
        <div class="container text-center text-white">
          
          <h1 class="display-3" style="font-weight: bolder; font-style:oblique">Welcome to Rk Hotel</h1>
            <p class="lead" style="font-style: oblique;">Discover Your Perfect Stay</p>
          <!-- 
          <button class="btn btn-success mt-3" onclick="location.href='views/user/booking.jsp'">Book a Room</button>
           -->
           
        </div>
      </div>
    </header>

    <main>
      <!-- INFO SECTION -->
      <section class="info">
        <div class="container">
          <div class="row">
            <div class="col-md-6 d-flex flex-column justify-content-center">
              <div class="info-box mb-4">
                <i class="fas fa-check-circle fa-2x mb-2"></i>
                <p class="info-text">
                  Welcome to Rk Hotel, where luxury meets comfort. Enjoy
                  unparalleled hospitality, top-notch amenities, and a memorable
                  stay that will exceed your expectations.
                </p>
              </div>
              <div class="info-box mb-4">
                <i class="fas fa-briefcase fa-2x mb-2"></i>
                <p class="info-text">
                  Whether you're here for business or leisure, our hotel offers
                  the perfect blend of convenience and elegance, making every
                  moment special.
                </p>
              </div>
              <div class="info-box mb-4">
                <i class="fas fa-concierge-bell fa-2x mb-2"></i>
                <p class="info-text">
                  Our dedicated staff is always ready to assist you, ensuring
                  your stay is as comfortable and enjoyable as possible.
                </p>
              </div>
              <div class="info-box mb-4">
                <i class="fas fa-map-marker-alt fa-2x mb-2"></i>
                <p class="info-text">
                  Located in the heart of the city, Rk Hotel provides easy
                  access to major attractions, shopping centers, and business
                  hubs.
                </p>
              </div>
            </div>
            <div class="col-md-6 d-flex flex-column">
              <img
                src="images/roomback.jpg"
                alt="image"
                height="20"
                width="90%"
                class="img-fluid mb-3"
              />
              <img
                src="images/cityhotel.jpg"
                alt="image"
                height="20"
                width="90%"
                class="img-fluid"
              />
            </div>
          </div>
        </div>
      </section>

      <!-- ROOMS SECTION -->
      <section class="rooms py-5">
        <div class="container">
          <div class="row">
            <div class="col-md-6 mb-3">
              <div
                id="roomsCarousel"
                class="carousel slide"
                data-ride="carousel"
              >
                <div class="carousel-inner">
                  <div class="carousel-item active">
                    <img
                      src="images/r2.jpg"
                      class="d-block w-100"
                      alt="Room Image 1"
                    />
                  </div>
                  <div class="carousel-item">
                    <img
                      src="images/room1.jpg"
                      class="d-block w-100"
                      alt="Room Image 2"
                    />
                  </div>
                  <div class="carousel-item">
                    <img
                      src="images/roomback.jpg"
                      class="d-block w-100"
                      alt="Room Image 3"
                    />
                  </div>
                </div>
                <a
                  class="carousel-control-prev"
                  href="#roomsCarousel"
                  role="button"
                  data-slide="prev"
                >
                  <span
                    class="carousel-control-prev-icon"
                    aria-hidden="true"
                  ></span>
                  <span class="sr-only">Previous</span>
                </a>
                <a
                  class="carousel-control-next"
                  href="#roomsCarousel"
                  role="button"
                  data-slide="next"
                >
                  <span
                    class="carousel-control-next-icon"
                    aria-hidden="true"
                  ></span>
                  <span class="sr-only">Next</span>
                </a>
              </div>
            </div>
            <div class="col-md-6 d-flex flex-column justify-content-center">
              <h2 class="headline">Rooms</h2>
              <p>
                <i class="fas fa-bed"></i> Our rooms are designed to provide you
                with the utmost comfort and luxury. Each room features modern
                decor, comfortable bedding, and all the amenities you need for a
                relaxing stay.
              </p>
              <p>
                <i class="fas fa-tv"></i> Enjoy complimentary high-speed
                internet, flat-screen TVs, and stunning views from your window.
                Experience the perfect blend of elegance and convenience in
                every room.
              </p>
              <button class="btn btn-success mt-3" onclick="location.href='views/user/room.jsp'">Explore Now</button>

              <!-- <button class="btn btn-success mt-3">Explore Now</button> -->
            </div>
          </div>
        </div>
      </section>

     </div><!-- Facilities Section -->
  <div class="text-center mb-4">
    <h2>Facilities</h2>
    <div class="row">
      <div class="col-md-3">
        <div class="card">
          <div class="card-body">
            <i class="fas fa-swimmer fa-3x mb-3"></i>
            <h5 class="card-title">Swimming Pool</h5>
            <p class="card-text">Enjoy a relaxing swim in our state-of-the-art swimming pool.</p>
          </div>
        </div>
      </div>
      <div class="col-md-3">
        <div class="card">
          <div class="card-body">
            <i class="fas fa-dumbbell fa-3x mb-3"></i>
            <h5 class="card-title">Gym</h5>
            <p class="card-text">Stay fit during your stay with our fully-equipped gym.</p>
          </div>
        </div>
      </div>
      <div class="col-md-3">
        <div class="card">
          <div class="card-body">
            <i class="fas fa-utensils fa-3x mb-3"></i>
            <h5 class="card-title">Restaurant</h5>
            <p class="card-text">Delight in a variety of cuisines at our on-site restaurant.</p>
          </div>
        </div>
      </div>
      <div class="col-md-3">
        <div class="card">
          <div class="card-body">
            <i class="fas fa-spa fa-3x mb-3"></i>
            <h5 class="card-title">Spa</h5>
            <p class="card-text">Indulge in our luxurious spa treatments and services.</p>
          </div>
        </div>
      </div>
    </div>
    <div class="row mt-4">
      <div class="col-md-3">
        <div class="card">
          <div class="card-body">
            <i class="fas fa-parking fa-3x mb-3"></i>
            <h5 class="card-title">Parking</h5>
            <p class="card-text">Ample parking space with 24/7 security for your vehicle.</p>
          </div>
        </div>
      </div>
      <div class="col-md-3">
        <div class="card">
          <div class="card-body">
            <i class="fas fa-concierge-bell fa-3x mb-3"></i>
            <h5 class="card-title">24/7 Concierge</h5>
            <p class="card-text">Our concierge service is available round the clock to assist you.</p>
          </div>
        </div>
      </div>
      <div class="col-md-3">
        <div class="card">
          <div class="card-body">
            <i class="fas fa-wifi fa-3x mb-3"></i>
            <h5 class="card-title">Free Wi-Fi</h5>
            <p class="card-text">Stay connected with our complimentary high-speed internet access.</p>
          </div>
        </div>
      </div>
      <div class="col-md-3">
        <div class="card">
          <div class="card-body">
            <i class="fas fa-child fa-3x mb-3"></i>
            <h5 class="card-title">Kids Club</h5>
            <p class="card-text">Fun activities and games for children of all ages.</p>
          </div>
        </div>
      </div>
    </div>
    <div class="row mt-4">
      <div class="col-md-3">
        <div class="card">
          <div class="card-body">
            <i class="fas fa-business-time fa-3x mb-3"></i>
            <h5 class="card-title">Business Center</h5>
            <p class="card-text">Fully-equipped business center for all your professional needs.</p>
          </div>
        </div>
      </div>
      <div class="col-md-3">
        <div class="card">
          <div class="card-body">
            <i class="fas fa-bus fa-3x mb-3"></i>
            <h5 class="card-title">Airport Shuttle</h5>
            <p class="card-text">Convenient airport shuttle service for our guests.</p>
          </div>
        </div>
      </div>
      <div class="col-md-3">
        <div class="card">
          <div class="card-body">
            <i class="fas fa-paw fa-3x mb-3"></i>
            <h5 class="card-title">Pet Friendly</h5>
            <p class="card-text">We welcome your furry friends with open arms.</p>
          </div>
        </div>
      </div>
      <div class="col-md-3">
        <div class="card">
          <div class="card-body">
            <i class="fas fa-smoking-ban fa-3x mb-3"></i>
            <h5 class="card-title">Non-Smoking Rooms</h5>
            <p class="card-text">Enjoy your stay in our clean and smoke-free rooms.</p>
          </div>
        </div>
      </div>
    </div>
  </div>
  

      <!-- TESTIMONIAL SECTION -->
      <section class="testimonials">
        <div class="container">
          <h2 class="heading-text text-center mb-5">Customer Reviews</h2>
          <div class="scrolling-wrapper row flex-row flex-nowrap">
            <div class="col-12 col-md-4 text-center">
              <div class="slider-box p-4 border rounded">
                <i class="fas fa-quote-left text-success mb-3"></i>
                <p>
                  Rk Hotel provided an amazing experience. The rooms were
                  comfortable, the staff was friendly, and the food was
                  delicious. Highly recommend!
                </p>
                <div class="rating mb-3">
                  <i class="fas fa-star"></i>
                  <i class="fas fa-star"></i>
                  <i class="fas fa-star"></i>
                  <i class="fas fa-star"></i>
                  <i class="fas fa-star"></i>
                </div>
                <img
                  src="images/p1.jpg"
                  alt="user"
                  class="rounded-circle mb-3"
                  width="80"
                />
                <h3>Keerthy</h3>
              </div>
            </div>
             <div class="col-12 col-md-4 text-center">
              <div class="slider-box p-4 border rounded">
                <i class="fas fa-quote-left text-success mb-3"></i>
                <p>
                  A perfect getaway! The spa services were top-notch, and the
                  restaurant offered an exquisite dining experience. Will
                  definitely visit again.
                </p>
                <div class="rating mb-3">
                  <i class="fas fa-star"></i>
                  <i class="fas fa-star"></i>
                  <i class="fas fa-star"></i>
                  <i class="fas fa-star"></i>
                  <i class="fas fa-star"></i>
                </div>
                <img
                  src="images/p1.jpg"
                  alt="user"
                  class="rounded-circle mb-3"
                  width="80"
                />
                <h3>Rithik</h3>
              </div>
            </div>
            <div class="col-12 col-md-4 text-center">
              <div class="slider-box p-4 border rounded">
                <i class="fas fa-quote-left text-success mb-3"></i>
                <p>
                  The best hotel experience I've had in years. Everything was
                  perfect, from the room to the amenities. The staff was
                  incredibly hospitable.
                </p>
                <div class="rating mb-3">
                  <i class="fas fa-star"></i>
                  <i class="fas fa-star"></i>
                  <i class="fas fa-star"></i>
                  <i class="fas fa-star"></i>
                  <i class="fas fa-star"></i>
                </div>
                <img
                  src="images/p3.jpg"
                  alt="user"
                  class="rounded-circle mb-3"
                  width="80"
                />
                <h3>Priya</h3>
              </div>
            </div>

            <!-- NEW ADD -->
            <div class="col-12 col-md-4 text-center">
                <div class="slider-box p-4 border rounded">
                  <i class="fas fa-quote-left text-success mb-3"></i>
                  <p>
                   	Rk Hotel provided an amazing experience. The rooms were
                    comfortable, the staff was friendly, and the food was
                    delicious. Highly recommend!
                  </p>
                  <div class="rating mb-3">
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                  </div>
                  <img
                    src="images/p1.jpg"
                    alt="user"
                    class="rounded-circle mb-3"
                    width="80"
                  />
                  <h3>Keerthy</h3>
                </div>
              </div>
              <div class="col-12 col-md-4 text-center">
                <div class="slider-box p-4 border rounded">
                  <i class="fas fa-quote-left text-success mb-3"></i>
                  <p>
                    Rk Hotel provided an amazing experience. The rooms were
                    comfortable, the staff was friendly, and the food was
                    delicious. Highly recommend!
                  </p>
                  <div class="rating mb-3">
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                  </div>
                  <img
                    src="images/p1.jpg"
                    alt="user"
                    class="rounded-circle mb-3"
                    width="80"
                  />
                  <h3>Keerthy</h3>
                </div>
              </div>
              <div class="col-12 col-md-4 text-center">
                <div class="slider-box p-4 border rounded">
                  <i class="fas fa-quote-left text-success mb-3"></i>
                  <p>
                    Rk Hotel provided an amazing experience. The rooms were
                    comfortable, the staff was friendly, and the food was
                    delicious. Highly recommend!
                  </p>
                  <div class="rating mb-3">
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                  </div>
                  <img
                    src="images/p1.jpg"
                    alt="user"
                    class="rounded-circle mb-3"
                    width="80"
                  />
                  <h3>Keerthy</h3>
                </div>
              </div>
              <div class="col-12 col-md-4 text-center">
                <div class="slider-box p-4 border rounded">
                  <i class="fas fa-quote-left text-success mb-3"></i>
                  <p>
                    Rk Hotel provided an amazing experience. The rooms were
                    comfortable, the staff was friendly, and the food was
                    delicious. Highly recommend!
                  </p>
                  <div class="rating mb-3">
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                  </div>
                  <img
                    src="images/p1.jpg"
                    alt="user"
                    class="rounded-circle mb-3"
                    width="80"
                  />
                  <h3>Keerthy</h3>
                </div>
              </div>


            <!--  -->


          </div>
        </div>
      </section>
    </main>

    <!-- FOOTER SECTION -->
    <footer class="bg-dark text-white py-4">
      <div class="container">
        <div class="back-to-top text-center mb-3">
          <a href="#hero" class="text-white">
            <i class="fas fa-chevron-up"></i>
          </a>
        </div>
        <div class="footer__content row text-center text-md-left">
          <div class="col-md-4 mb-3">
            <h4>About</h4>
            <p>
              Rk Hotel offers luxurious rooms with top-notch amenities and
              exceptional service. Experience the best in comfort and
              convenience.
            </p>
          </div>
          <div class="col-md-4 mb-3">
            <h4>Payment Methods</h4>
            <p>Pay any way you choose, we support all major payment options</p>
            <ul class="list-inline payment-methods">
              <li class="list-inline-item">
                <a href="#" class="text-white">
                  <i class="fab fa-paypal fa-2x"></i>
                </a>
              </li>
              <li class="list-inline-item">
                <a href="#" class="text-white">
                  <i class="fab fa-cc-visa fa-2x"></i>
                </a>
              </li>
              <li class="list-inline-item">
                <a href="#" class="text-white">
                  <i class="fab fa-cc-mastercard fa-2x"></i>
                </a>
              </li>
              <li class="list-inline-item">
                <a href="#" class="text-white">
                  <i class="fab fa-apple-pay fa-2x"></i>
                </a>
              </li>
            </ul>
          </div>
          <div class="col-md-4 mb-3">
            <h4>Get Social</h4>
            <p>
              Follow us on social media to stay updated with the latest offers
              and news.
            </p>
            <ul class="list-inline social-icons">
              <li class="list-inline-item">
                <a href="#" class="text-white">
                  <i class="fab fa-facebook-f fa-2x"></i>
                </a>
              </li>
              <li class="list-inline-item">
                <a href="#" class="text-white">
                  <i class="fab fa-twitter fa-2x"></i>
                </a>
              </li>
              <li class="list-inline-item">
                <a href="#" class="text-white">
                  <i class="fab fa-instagram fa-2x"></i>
                </a>
              </li>
              <li class="list-inline-item">
                <a href="#" class="text-white">
                  <i class="fab fa-tripadvisor fa-2x"></i>
                </a>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </footer>   
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  </body>
</html>
