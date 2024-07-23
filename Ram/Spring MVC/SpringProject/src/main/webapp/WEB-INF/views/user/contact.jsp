<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Contact Us - Rk Hotel</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Lato:wght@400;700&family=Playfair+Display:wght@400;700&display=swap">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asserts/css/user/contact.css" />
</head>
<style>
.nav-link.active {
    background-color:grey;
    padding: 5px 5px;
    border-radius: 100px;
}
.hero {
    background-image: url("${pageContext.request.contextPath}/asserts/images/cityhotel.jpg");
    height: 100vh;
    color: #fff;
    display: flex;
    justify-content: center;
    align-items: center;
}
.hero {
    height: calc(100vh - 70px);
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
    background: rgba(0, 0, 0, 0.5);
}
.hero .container {
    position: relative;
    z-index: 1;
}
.hero__text-box {
    color: #fff;
    text-shadow: 0 2px 4px rgba(0, 0, 0, 0.6);
    text-align: center;
    max-width: 600px;
    margin: 0 auto;
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
            <a class="navbar-brand" href="main">Rk Hotel</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="main">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="vr">Rooms</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="about">About</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="contact">Contact</a>
                    </li>
                    <ul class="navbar-nav ml-auto">
                        <% 
                            String user = (String) session.getAttribute("user");
                            System.out.println("Mail : " + user);
                            if (user != null && !user.isEmpty()) {
                        %>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <img src="${pageContext.request.contextPath}/asserts/images/profile1.jpg" alt="Profile" class="rounded-circle mr-2" style="width: 30px; height: 30px;">
                                <h6 class="mb-0" th:text="${user}"></h6>
                            </a>
                            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="profile">View Profile</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="logoutUser">Logout</a>
                            </div>
                        </li>
                        <% } else { %>
                        <li class="nav-item">
                            <a class="nav-link btn btn-light text-white" href="connect">
                                <span style="color: black">Login / Register</span>
                            </a>
                        </li>
                        <% } %>
                    </ul>
                </ul>
            </div>
        </div>
    </nav>
    <div id="hero" class="hero d-flex justify-content-center align-items-center">
        <div class="container text-center text-white">
            <h1 class="display-3">Contact Us</h1>
            <p class="lead">"Talk to Us: We're Here to Help"</p>
            <c:choose>
                <c:when test="${not empty sessionScope.user}">
                    <a class="btn btn-dark" href="vr">Book</a>
                </c:when>
                <c:otherwise>
                    <button class="btn btn-dark" disabled="true">Book</button>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</header>

 <c:if test="${not empty contact.name}">
        <div class="toast" role="alert" aria-live="assertive" aria-atomic="true" data-delay="5000" style="position: absolute; top: 20px; right: 20px;">
            <div class="toast-header">
                <strong class="me-auto">Notification</strong>
                <button type="button" class="ml-2 mb-1 close" data-dismiss="toast" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="toast-body">
                ${contact.name}
                <%
                session.removeAttribute("contact");
                %>
            </div>
        </div>
        <script>
            $(document).ready(function() {
                $('.toast').toast('show');
            });
        </script>
    </c:if>
<main>
    <section class="contact py-5">
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <h2>Get in Touch</h2>
                    <p>Feel free to reach out to us with any questions or concerns. We are here to assist you.</p>
                    <form action="refer" method="post">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Your Name" name="name">
                        </div>
                        <div class="form-group">
                            <input type="email" class="form-control" placeholder="Your Email" name="email">
                        </div>
                        <div class="form-group">
                            <textarea class="form-control" rows="5" placeholder="Your Message" name="msg"></textarea>
                        </div>
                        <button type="submit" class="btn btn-success">Submit</button>
                    </form>
                </div>
                <div class="col-lg-6">
                    <div class="row">
                        <div class="col-lg-12">
                            <h2>Visit Us</h2>
                            <address>
                                <a href="https://www.google.com/maps?q=85+Krishna+Garden,+Singanallur,+Tamil+Nadu+641005" target="_blank">
                                    Vertical Garden<br>
                                    85, Krishna Garden, Singanallur, Tamil Nadu 641005
                                </a>
                            </address>
                        </div>
                        <div class="col-lg-12">
                            <h2>Call Us</h2>
                            <p><a href="tel:+919080280180">Phone: +91 9080280180</a></p>
                        </div>
                        <div class="col-lg-12">
                            <h2>Email Us</h2>
                            <p><a href="mailto:info@rkhotel.com">info@rkhotel.com</a></p>
                        </div>
                    </div>
                    <div class="map-responsive mt-4">
                        <iframe 
                        src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3936.9033642116295!2d77.0276955!3d11.0039244!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3ba8576dae6312a7%3A0x9969b109d3845886!2sVertical%20Garden!5e0!3m2!1sen!2sin!4v1626105971441!5m2!1sen!2sin" 
                        width="600" 
                        height="450" 
                        style="border:0;" 
                        allowfullscreen="" 
                        loading="lazy">
                        </iframe>
                    </div>
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
