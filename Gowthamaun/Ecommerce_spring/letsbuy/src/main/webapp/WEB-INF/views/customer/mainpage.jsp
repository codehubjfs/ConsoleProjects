<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
  <%@ page import="com.letsbuy.beans.*" %>  
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Ecommerce Homepage</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <!-- <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"> -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
    
    
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/customerstyles.css">
</head>

<body class="bg-light">

    <div class="navbar navbar-expand-lg navbar-light bg-white shadow-sm fixed-top" id="main-navv">
        <div class="container-fluid">
            <a class="navbar-brand d-none d-md-block" href="#option-menu">
                <img src="${pageContext.request.contextPath}/images/logo.png" class="rounded" width="210" height="110" alt="">
            </a>
            <a class="navbar-brand d-md-none" href="#option-menu">
                <img src="${pageContext.request.contextPath}/images/logo.png" class="rounded" width="100" height="50" alt="">
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarContent" aria-controls="navbarContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarContent">
                <div class="d-flex ms-auto me-auto mt-2 mt-lg-0 search-bar-container">
                    <form class="w-100" role="search">
                        <div class="input-group">
                            <input type="search" placeholder="Search your product" class="form-control"/>
                            <button class="btn btn-serch" type="submit">
                                <i class="fa fa-search"></i>
                            </button>
                        </div>
                    </form>
                </div>
                <ul class="navbar-nav ms-auto">
                  <!--   <li class="nav-item txt-nav">
                        <a class="nav-link" href="${pageContext.request.contextPath}/views/customer/login.jsp">
                            <i class="fa fa-user"></i> Login
                        </a>
                    </li> -->
                    <li class="nav-item txt-nav">
                        <a class="nav-link" href="${pageContext.request.contextPath}/views/customer/cart.jsp">
                            <i class="fa fa-shopping-cart"></i> Cart (5)
                        </a>
                    </li>
                   <!--   <li class="nav-item">
                        <a class="nav-link" href="#">
                            <img src="images/Shop-1--Streamline-Ultimate.svg"  height="20" width="25" alt=""> Seller
                        </a>
                    </li> -->
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            <i class="fa fa-user"></i> ${requestScope.user.getFirstName()}
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="#"><i class="fa fa-user"></i> Profile</a></li>
                            <li><a class="dropdown-item" href="#"><i class="fa fa-list"></i> My Orders</a></li>
                            <!-- <li><a class="dropdown-item" href="#"><i class="fa fa-heart"></i> My Wishlist</a></li>
                            <li><a class="dropdown-item" href="#"><i class="fa fa-shopping-cart"></i> My Cart</a></li> -->
                            <li><a class="dropdown-item" href="#"><i class="fa fa-sign-out"></i> Logout</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <div class="container-flex d-flex mx-3 mb-2 bg-white justify-content-center" id="option-menu">
        <div class="row">
            <div class="col text-center pt-3 pb-3">
                <a class="nav-link" href="#">
                    <div class="col">
                        <img src="${pageContext.request.contextPath}/images/homepage/product-types/grocery.webp" height="90" alt="">
                        <h6 class="text-center">Grocery</h6>
                    </div>
                </a>
            </div>
            <div class="col text-center p-3">
                <a class="nav-link" href="views/customer/mobilepage.jsp">
                    <div class="col">
                        <img src="${pageContext.request.contextPath}/images/homepage/product-types/mobiles.webp" height="90" alt="">
                        <h6 class="text-center">Mobile</h6>
                    </div>
                </a>
            </div>
            <div class="col text-center p-3">
                <a class="nav-link" href="#">
                    <div class="col">
                        <img src="${pageContext.request.contextPath}/images/homepage/product-types/fashion.jpg" height="90" alt="">
                        <h6 class="text-center">Fashion</h6>
                    </div>
                </a>
            </div>
            <div class="col text-center p-3">
                <a class="nav-link" href="productspage.html">
                    <div class="col">
                        <img src="${pageContext.request.contextPath}/images/homepage/product-types/electronics.png" height="90" alt="">
                        <h6 class="text-center">Electronics</h6>
                    </div>
                </a>
            </div>
            <div class="col text-center p-3">
                <a class="nav-link" href="#">
                    <div class="col">
                        <img src="${pageContext.request.contextPath}/images/homepage/product-types/furniture.jpg" height="90" alt="">
                        <h6 class="text-center">Home & Furniture</h6>
                    </div>
                </a>
            </div>
            <div class="col text-center p-3">
                <a class="nav-link" href="#">
                    <div class="col">
                        <img src="${pageContext.request.contextPath}/images/homepage/product-types/appliances.webp" height="90" alt="">
                        <h6 class="text-center">Appliances</h6>
                    </div>
                </a>
            </div>
            <div class="col text-center p-3">
                <a class="nav-link" href="#">
                    <div class="col">
                        <img src="${pageContext.request.contextPath}/images/homepage/product-types/toy.jpg" height="90" alt="">
                        <h6 class="text-center">Beauty,toys & More</h6>
                    </div>
                </a>
            </div>
        </div>
    </div>
   

            <div id="carouselExampleIndicators" class="carousel slide mx-3 mt-4" data-bs-ride="carousel" data-bs-interval="1000">
                <ol class="carousel-indicators">
                  <li data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active"></li>
                  <li data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1"></li>
                  <li data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2"></li>
                  <li data-bs-target="#carouselExampleIndicators" data-bs-slide-to="3"></li>
                  <li data-bs-target="#carouselExampleIndicators" data-bs-slide-to="4"></li>
                </ol>
                <div class="carousel-inner">
                  <div class="carousel-item active">
                    <img class="d-block w-100" src="${pageContext.request.contextPath}/images/homepage/carousel/offer1.webp" alt="First slide">
                  </div>
                  <div class="carousel-item">
                    <img class="d-block w-100" src="${pageContext.request.contextPath}/images/homepage/carousel/offer2.webp" alt="Second slide">
                  </div>
                  <div class="carousel-item">
                    <img class="d-block w-100" src="${pageContext.request.contextPath}/images/homepage/carousel/offer3.webp" alt="Third slide">
                  </div>
                  <div class="carousel-item">
                    <img class="d-block w-100" src="${pageContext.request.contextPath}/images/homepage/carousel/off4.jpg" alt="Fourth slide">
                  </div>
                  <div class="carousel-item">
                    <img class="d-block w-100" src="${pageContext.request.contextPath}/images/homepage/carousel/offer4.webp" alt="Fifth slide">
                  </div>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-bs-slide="prev">
                  <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                  <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-bs-slide="next">
                  <span class="carousel-control-next-icon" aria-hidden="true"></span>
                  <span class="sr-only">Next</span>
                </a>
              </div>
              


    <div class="container-flex bg-white m-3 p-2 px-3 ">
        <h5 class="mt-2">Best of Electronics</h5>
        <div class="row d-flex">
            <div class="col rounded border show-items text-center m-2 p-3">
                <img src="${pageContext.request.contextPath}/images/homepage/homepage-products/earbud.jpg" width="200" height="250" alt="">
                <p>Best wireless Headphones</p>
                <h5>Grab Now</h5>
            </div>
            <div class="col rounded border show-items text-center m-2 p-3">
                <img src="${pageContext.request.contextPath}/images/homepage/homepage-products/smartwatch.jpeg" width="200" height="250" alt="">
                <p>Best wireless Headphones</p>
                <h5>Grab Now</h5>
            </div>
            <div class="col rounded border show-items text-center m-2 p-3">
                <img src="${pageContext.request.contextPath}/images/homepage/homepage-products/speaker.webp" width="200" height="250" alt="">
                <p>Best wireless Headphones</p>
                <h5>Grab Now</h5>
            </div>
            <div class="col rounded border show-items text-center m-2 p-3">
                <img src="${pageContext.request.contextPath}/images/homepage/homepage-products/canon-camera.jpg" width="200" height="250" alt="">
                <p>Best wireless Headphones</p>
                <h5>Grab Now</h5>
            </div>
            <div class="col rounded border show-items text-center m-2 p-3">
                <img src="${pageContext.request.contextPath}/images/homepage/homepage-products/monitor.jpg" width="200" height="250" alt="">
                <p>Best wireless Headphones</p>
                <h5>Grab Now</h5>
            </div>
        </div>

    </div>

    <div class="container-flex bg-white m-3 p-2 px-3 overflow-hidden">
        <div class="row d-flex justify-content-between mt-2 mb-3 fixed">
            <div class="col">
                <h5 class="">Beauty food,toys & More</h5>
            </div>
            <div class="col text-end">
                <button class="btn btn-sm btnn rounded-pill"><i class="bi bi-chevron-right"></i></button>
            </div>
        </div>
        <div class="row d-flex">
            <div class="col rounded border show-items text-center m-2 p-3">
                <img src="${pageContext.request.contextPath}/images/homepage/homepage-products/flair-pen.jpg" width="200" height="250" alt="">
                <p>Best wireless Headphones</p>
                <h5>Grab Now</h5>
            </div>
            <div class="col rounded border show-items text-center m-2 p-3">
                <img src="${pageContext.request.contextPath}/images/homepage/homepage-products/cycle.jpg" width="200" height="250" alt="">
                <p>Best wireless Headphones</p>
                <h5>Grab Now</h5>
            </div>
            <div class="col rounded border show-items text-center m-2 p-3">
                <img src="${pageContext.request.contextPath}/images/homepage/homepage-products/teddy-bear.webp" width="200" height="250" alt="">
                <p>Best wireless Headphones</p>
                <h5>Grab Now</h5>
            </div>
            <div class="col rounded border show-items text-center m-2 p-3">
                <img src="${pageContext.request.contextPath}/images/homepage/homepage-products/dry-fruit.jpg" width="200" height="250" alt="">
                <p>Best wireless Headphones</p>
                <h5>Grab Now</h5>
            </div>
            <div class="col rounded border show-items text-center m-2 p-3">
                <img src="${pageContext.request.contextPath}/images/homepage/homepage-products/monitor.jpg" width="200" height="250" alt="">
                <p>Best wireless Headphones</p>
                <h5>Grab Now</h5>
            </div>

        </div>

    </div>
    <div class="container-flex mx-2">
        <div class="row justify-content-evenly">
            <div class="col-auto bg-white">
                <div class="row d-flex justify-content-between mt-4 mb-3 fixed">
                    <div class="col-auto">
                        <h4>Best Gadget & Appliances</h4>
                    </div>
                    <div class="col-auto text-end">
                        <button class="btn btnn btn-sm rounded-pill"><i class="bi bi-chevron-right"></i></button>
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <div class="row">
                            <div class="col rounded border show-items text-center m-2 p-3">
                                <img src="${pageContext.request.contextPath}/images/homepage/homepage-products/watch-strap.jpeg" width="180" height="250" alt="">
                                <p>Smart Watch Straps</p>
                                <h5 class="text-success">Min. 40% Off</h5>
                            </div>
                            <div class="col rounded border show-items text-center m-2 p-3">
                                <img src="${pageContext.request.contextPath}/images/homepage/homepage-products/gold-trimmer.jpeg" width="180" height="250" alt="">
                                <p>Best wireless Headphones</p>
                                <h5 class="text-success">Grab Now</h5>
                            </div>
                        </div>
                    
                    
                        <div class="row">
                            <div class="col rounded border show-items text-center m-2 p-3">
                                <img src="${pageContext.request.contextPath}/images/homepage/homepage-products/watch-smart.jpeg" width="180" height="250" alt="">
                                <p>Best wireless Headphones</p>
                                <h5 class="text-success">Grab Now</h5>
                            </div>
                            <div class="col rounded border show-items text-center m-2 p-3">
                                <img src="${pageContext.request.contextPath}/images/homepage/homepage-products/ups-battery.jpeg" width="180" height="250" alt="">
                                <p>Best wireless Headphones</p>
                                <h5 class="text-success">Grab Now</h5>
                            </div>
                        </div>

                    </div>
                    
                    
                </div>
            </div>
            <div class="col-auto bg-white ">
                <div class="row d-flex justify-content-between mt-4 mb-3 fixed">
                    <div class="col-auto">
                        <h4>Home Decors & Furnishing</h4>
                    </div>
                    <div class="col text-end">
                        <button class="btn btnn btn-sm rounded-pill"><i class="bi bi-chevron-right"></i></button>
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <div class="row">
                            <div class="col rounded border show-items text-center m-2 p-3">
                                <img src="${pageContext.request.contextPath}/images/homepage/homepage-products/decor-statue.jpeg" width="180" height="250" alt="">
                                <p>Best wireless Headphones</p>
                                <h5 class="text-success">Grab Now</h5>
                            </div>
                            <div class="col rounded border show-items text-center m-2 p-3">
                                <img src="${pageContext.request.contextPath}/images/homepage/homepage-products/fan.webp" width="180" height="250" alt="">
                                <p>Best wireless Headphones</p>
                                <h5 class="text-success">Grab Now</h5>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col rounded border show-items text-center m-2 p-3">
                                <img src="${pageContext.request.contextPath}/images/homepage/homepage-products/peacock-clock.jpg" width="180" height="250" alt="">
                                <p>Best wireless Headphones</p>
                                <h5 class="text-success">Grab Now</h5>
                            </div>
                            <div class="col rounded border show-items text-center m-2 p-3">
                                <img src="${pageContext.request.contextPath}/images/homepage/homepage-products/key-chain.jpg" width="180" height="250" alt="">
                                <p>Best wireless Headphones</p>
                                <h5 class="text-success">Grab Now</h5>
                            </div>
                        </div>

                    </div>
                    
                    
                </div>
            </div>
            <div class="col-auto bg-white ">
                <div class="row d-flex justify-content-between mt-4 mb-3 fixed">
                    <div class="col-auto">
                        <h4>Best of Health & Wellness</h4>
                    </div>
                    <div class="col text-end">
                        <button class="btn btnn btn-sm rounded-pill"><i class="bi bi-chevron-right"></i></button>
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <div class="row">
                            <div class="col rounded border show-items text-center m-2 p-3">
                                <img src="${pageContext.request.contextPath}/images/homepage/homepage-products/water-bottle.jpeg" width="180" height="250" alt="">
                                <p>Best wireless Headphones</p>
                                <h5 class="text-success">Grab Now</h5>
                            </div>
                            <div class="col rounded border show-items text-center m-2 p-3">
                                <img src="${pageContext.request.contextPath}/images/homepage/homepage-products/workout-set.jpeg" width="180" height="250" alt="">
                                <p>Best wireless Headphones</p>
                                <h5 class="text-success">Grab Now</h5>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col rounded border show-items text-center m-2 p-3">
                                <img src="${pageContext.request.contextPath}/images/homepage/homepage-products/cycle.jpg" width="180" height="250" alt="">
                                <p>Best wireless Headphones</p>
                                <h5 class="text-success">Grab Now</h5>
                            </div>
                            <div class="col rounded border show-items text-center m-2 p-3">
                                <img src="${pageContext.request.contextPath}/images/homepage/homepage-products/cycle.jpg" width="180" height="250" alt="">
                                <p>Best wireless Headphones</p>
                                <h5 class="text-success">Grab Now</h5>
                            </div>
                        </div>

                    </div>
                </div>
            </div>

        </div>
    </div>

    <footer class="footer mt-5 shadow bg-white">
        <div class="container">
          <div class="row">
            <div class="col-md-3 col-6">
              <h5>Company</h5>
              <ul class="list-unstyled">
                <li><a href="#">About Us</a></li>
                <li><a href="#">Careers</a></li>
                <li><a href="#">Press</a></li>
                <li><a href="#">Blog</a></li>
              </ul>
            </div>
            <div class="col-md-3 col-6">
              <h5>Support</h5>
              <ul class="list-unstyled">
                <li><a href="#">Help Center</a></li>
                <li><a href="#">Safety Information</a></li>
                <li><a href="#">Cancellation Options</a></li>
                <li><a href="#">Contact Us</a></li>
              </ul>
            </div>
            <div class="col-md-3 col-6">
              <h5>Services</h5>
              <ul class="list-unstyled">
                <li><a href="#">Account</a></li>
                <li><a href="#">Order Tracking</a></li>
                <li><a href="#">Wishlist</a></li>
                <li><a href="#">Customer Service</a></li>
              </ul>
            </div>
            <div class="col-md-3 col-6">
              <h5>Follow Us</h5>
              <div class="social-icons">
                <a href="#"><i class="bi bi-facebook"></i></a>
                <a href="#"><i class="bi bi-twitter"></i></a>
                <a href="#"><i class="bi bi-instagram"></i></a>
                <a href="#"><i class="bi bi-linkedin"></i></a>
              </div>
            </div>
          </div>
          <div class="row mt-4">
            <div class="col text-center">
              <p>&copy; 2024 MyEcommerce. All rights reserved.</p>
            </div>
          </div>
        </div>
      </footer>

    <!-- jQuery and Bootstrap JS -->
   
</body>

</html>