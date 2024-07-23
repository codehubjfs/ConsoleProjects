<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>About Us - Rk Hotel</title>
 
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
   
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
 
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Lato:wght@400;700&family=Playfair+Display:wght@400;700&display=swap">
    <link rel="stylesheet" href="../../css/user/about.css">
</head>
<style>
 .hero {
            background-image: url(../../images/cityhotel.jpg);
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
<body>
    <header>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container">
                <a class="navbar-brand" href="main.jsp">Rk Hotel</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
      <a class="nav-link" href="../../index.jsp">Home</a>
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
                            <a class="nav-link btn btn-light text-white" href="${pageContext.request.contextPath}/CommonRoomServlet"><span style="color: black">Book</span></a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <div id="hero" class="hero d-flex justify-content-center align-items-center">
            <div class="container text-center text-white">
                <h1 class="display-3">"Meet the Heart of RK HOTEL"</h1>
                <button class="btn btn-success mt-3" onclick="location.href='${pageContext.request.contextPath}/CommonRoomServlet'">Book a Room</button>
            </div>
        </div>
    </header>

    <main>
        <!-- ABOUT US SECTION -->
        <section class="about-us py-5">
            <div class="container">
                <div class="row">
                    <div class="col-md-6">
                        <h2 class="headline">About Us</h2>
                        <p>
                            At Rk Hotel, we are committed to providing our guests with a memorable and comfortable stay. Our hotel is more than just a place to stay; it's a home away from home where every guest is treated like family.
                        </p>
                        <p>
                            Our journey began with a vision to create a luxurious yet welcoming space for travelers from all walks of life. From our friendly staff to our meticulously designed rooms, every aspect of Rk Hotel reflects our dedication to hospitality excellence.
                        </p>
                        <p>
                            Whether you're traveling for business or leisure, we strive to exceed your expectations at every turn. We invite you to experience the warmth and hospitality of Rk Hotel and make lasting memories with us.
                        </p>
                    </div>
                    <div class="col-md-6">
                        <img src="./images/rep.jpg" alt="About Us Image" class="img-fluid">
                    </div>
                </div>
            </div>
        </section>
    </main>

    <footer class="bg-dark text-white py-4">
        <div class="container">
            <div class="back-to-top text-center mb-3">
                <a href="#hero" class="text-white"><i class="fas fa-chevron-up"></i></a>
            </div>
            <div class="footer__content row text-center text-md-left">
                <div class="col-md-4 mb-3">
                    <h4>About</h4>
                    <p>Rk Hotel offers luxurious rooms with top-notch amenities and exceptional service. Experience the best in comfort and convenience.</p>
                </div>
                <div class="col-md-4 mb-3">
                    <h4>Payment Methods</h4>
                    <p>Pay any way you choose, we support all major payment options</p>
                    <ul class="list-inline payment-methods">
                        <li class="list-inline-item"><a href="#" class="text-white"><i class="fab fa-paypal fa-2x"></i></a></li>
                        <li class="list-inline-item"><a href="#" class="text-white"><i class="fab fa-cc-visa fa-2x"></i></a></li>
                        <li class="list-inline-item"><a href="#" class="text-white"><i class="fab fa-cc-mastercard fa-2x"></i></a></li>
                        <li class="list-inline-item"><a href="#" class="text-white"><i class="fab fa-apple-pay fa-2x"></i></a></li>
                    </ul>
                </div>
                <div class="col-md-4 mb-3">
                    <h4>Get Social</h4>
                    <p>Follow us on social media to stay updated with the latest offers and news.</p>
                    <ul class="list-inline social-icons">
                        <li class="list-inline-item"><a href="#" class="text-white"><i class="fab fa-facebook-f fa-2x"></i></a></li>
                        <li class="list-inline-item"><a href="#" class="text-white"><i class="fab fa-twitter fa-2x"></i></a></li>
                        <li class="list-inline-item"><a href="#" class="text-white"><i class="fab fa-instagram fa-2x"></i></a></li>
                        <li class="list-inline-item"><a href="#" class="text-white"><i class="fab fa-tripadvisor fa-2x"></i></a></li>
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

