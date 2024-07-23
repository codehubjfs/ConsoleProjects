<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/customerstyles.css">
</head>


<body>
    
    <div class="navbar navbar-expand-lg navbar-light bg-white shadow-sm fixed-top" id="main-navv">
        <div class="container-fluid">
            <a class="navbar-brand d-none d-md-block" href="homepage.html">
                <img src="${pageContext.request.contextPath}/images/logo.png" class="rounded" width="210" height="110" alt="">
            </a>
            <a class="navbar-brand d-md-none" href="homepage.html">
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
                	<li class="nav-item txt-nav invisible" id="login-pg">
                        <a class="nav-link" href="${pageContext.request.contextPath}/views/customer/login.jsp">
                            <i class="fa fa-user"></i> Login
                        </a>
                    </li>
                    
                    <li class="nav-item txt-nav">
                        <a class="nav-link" href="cartpage.html">
                            <i class="fa fa-shopping-cart"></i> Cart
                        </a>
                    </li>
                    <!--   <li class="nav-item">
                        <a class="nav-link" href="#">
                            <i class="fa fa-heart"></i> Wishlist (0)
                        </a>
                    </li> --> 
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            <i class="fa fa-user"></i> Username
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

    <div class="container-fluid" style="margin-top: 150px;">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid d-flex"> <a class="navbar-brand" href="#">SiteBack</a>
                <ul class="nav nav-tabs" id="myTab" role="tablist">
                    <li class="nav-item" role="presentation"> <a class="nav-link active" id="home-tab" data-bs-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">Couches</a> </li>
                    <li class="nav-item" role="presentation"> <a class="nav-link" id="profile-tab" data-bs-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false">Chair</a> </li>
                    <li class="nav-item" role="presentation"> <a class="nav-link" id="contact-tab" data-bs-toggle="tab" href="#contact" role="tab" aria-controls="contact" aria-selected="false">Dining</a> </li>
                </ul>
            </div>
        </nav>
    </div>
    <div class="container-fluid mt-2 mb-5">
        <div class="products">
            <div class="tab-content" id="myTabContent">
                <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                    <!-- <div class="d-flex justify-content-between p-3 bg-white mb-3 align-items-center"> <span class="fw-bold text-uppercase">Luxury Couch</span>
                        <div> <img src="https://img.icons8.com/windows/100/000000/list.png" width="30" /> <img src="https://img.icons8.com/ios-filled/100/000000/squared-menu.png" width="25" /> </div>
                    </div> -->
                    <div class="row g-3">
                        <div class="col-md-4">
                            <div class="card"> <img src="${pageContext.request.contextPath}/images/furnitures/SOMPPzU.jpeg" class="card-img-top">
                                <div class="card-body">
                                    <div class="d-flex justify-content-between"> <span class="fw-bold">Wood Sofa set-3</span> <span class="fw-bold">$550</span> </div>
                                    <p class="card-text mb-1 mt-1">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                    <div class="d-flex align-items-center flex-row"> <img src="${pageContext.request.contextPath}/images/furnitures/safety-icon.png" width="20"> <span class="guarantee">2 Years Guarantee</span> </div>
                                </div>
                                <hr>
                                <div class="card-body">
                                    <div class="text-right buttons"> <button class="btn btn-outline-dark">add to wishlist</button> <button class="btn btn-dark">Add to cart</button> </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="card"> <img src="${pageContext.request.contextPath}/images/furnitures/couches2.jpeg" class="card-img-top">
                                <div class="card-body">
                                    <div class="d-flex justify-content-between"> <span class="fw-bold">Wood Sofa set-3</span> <span class="fw-bold">$600</span> </div>
                                    <p class="card-text mb-1 mt-1">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                    <div class="d-flex align-items-center flex-row"> <img src="${pageContext.request.contextPath}/images/furnitures/safety-icon.png" width="20"> <span class="guarantee">1 Years Guarantee</span> </div>
                                </div>
                                <hr>
                                <div class="card-body">
                                    <div class="text-right buttons"> <button class="btn btn-outline-dark">add to wishlist</button> <button class="btn btn-dark">Add to cart</button> </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="card"> <img src="${pageContext.request.contextPath}/images/furnitures/couches3.jpeg" class="card-img-top">
                                <div class="card-body">
                                    <div class="d-flex justify-content-between"> <span class="fw-bold">Wood Sofa set-2</span> <span class="fw-bold">$1,000</span> </div>
                                    <p class="card-text mb-1 mt-1">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                    <div class="d-flex align-items-center flex-row"> <img src="${pageContext.request.contextPath}/images/furnitures/safety-icon.png" width="20"> <span class="guarantee">4 Years Guarantee</span> </div>
                                </div>
                                <hr>
                                <div class="card-body">
                                    <div class="text-right buttons"> <button class="btn btn-outline-dark">add to wishlist</button> <button class="btn btn-dark">Add to cart</button> </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="card"> <img src="${pageContext.request.contextPath}/images/furnitures/couches4.jpeg" class="card-img-top">
                                <div class="card-body">
                                    <div class="d-flex justify-content-between"> <span class="fw-bold">Wood Sofa set-4</span> <span class="fw-bold">$850</span> </div>
                                    <p class="card-text mb-1 mt-1">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                    <div class="d-flex align-items-center flex-row"> <img src="${pageContext.request.contextPath}/images/furnitures/safety-icon.png" width="20"> <span class="guarantee">3 Years Guarantee</span> </div>
                                </div>
                                <hr>
                                <div class="card-body">
                                    <div class="text-right buttons"> <button class="btn btn-outline-dark">add to wishlist</button> <button class="btn btn-dark">Add to cart</button> </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="card"> <img src="${pageContext.request.contextPath}/images/furnitures/couches5.jpeg" class="card-img-top">
                                <div class="card-body">
                                    <div class="d-flex justify-content-between"> <span class="fw-bold">Wood Sofa set-5</span> <span class="fw-bold">$15,50</span> </div>
                                    <p class="card-text mb-1 mt-1">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                    <div class="d-flex align-items-center flex-row"> <img src="${pageContext.request.contextPath}/images/furnitures/safety-icon.png" width="20"> <span class="guarantee">8 Years Guarantee</span> </div>
                                </div>
                                <hr>
                                <div class="card-body">
                                    <div class="text-right buttons"> <button class="btn btn-outline-dark">add to wishlist</button> <button class="btn btn-dark">Add to cart</button> </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="card"> <img src="${pageContext.request.contextPath}/images/furnitures/couches6.jpeg" class="card-img-top">
                                <div class="card-body">
                                    <div class="d-flex justify-content-between"> <span class="fw-bold">Wood Sofa set-3</span> <span class="fw-bold">$550</span> </div>
                                    <p class="card-text mb-1 mt-1">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                    <div class="d-flex align-items-center flex-row"> <img src="${pageContext.request.contextPath}/images/furnitures/safety-icon.png" width="20"> <span class="guarantee">2 Years Guarantee</span> </div>
                                </div>
                                <hr>
                                <div class="card-body">
                                    <div class="text-right buttons"> <button class="btn btn-outline-dark">add to wishlist</button> <button class="btn btn-dark">Add to cart</button> </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                    <!--Chairs-->
                    <!-- <div class="d-flex justify-content-between p-3 bg-white mb-3 align-items-center"> <span class="fw-bold text-uppercase">Luxury Chairs</span>
                        <div> <img src="https://img.icons8.com/windows/100/000000/list.png" width="30" /> <img src="https://img.icons8.com/ios-filled/100/000000/squared-menu.png" width="25" /> </div>
                    </div> -->
                    <div class="row g-3">
                        <div class="col-md-4">
                            <div class="card"> <img src="${pageContext.request.contextPath}/images/furnitures/Chairs/chair1.jpeg" class="card-img-top">
                                <div class="card-body">
                                    <div class="d-flex justify-content-between"> <span class="fw-bold">Wodden chairs set-2</span> <span class="fw-bold">$150</span> </div>
                                    <p class="card-text mb-1 mt-1">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                    <div class="d-flex align-items-center flex-row"> <img src="${pageContext.request.contextPath}/images/furnitures/safety-icon.png" width="20"> <span class="guarantee">4 Years Guarantee</span> </div>
                                </div>
                                <hr>
                                <div class="card-body">
                                    <div class="text-right buttons"> <button class="btn btn-outline-dark">add to wishlist</button> <button class="btn btn-dark">Add to cart</button> </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="card"> <img src="${pageContext.request.contextPath}/images/furnitures/Chairs/chair2.jpeg" class="card-img-top">
                                <div class="card-body">
                                    <div class="d-flex justify-content-between"> <span class="fw-bold">Wodden Chairs Premium set-2</span> <span class="fw-bold">$200</span> </div>
                                    <p class="card-text mb-1 mt-1">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                    <div class="d-flex align-items-center flex-row"> <img src="${pageContext.request.contextPath}/images/furnitures/safety-icon.png" width="20"> <span class="guarantee">2 Years Guarantee</span> </div>
                                </div>
                                <hr>
                                <div class="card-body">
                                    <div class="text-right buttons"> <button class="btn btn-outline-dark">add to wishlist</button> <button class="btn btn-dark">Add to cart</button> </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="card"> <img src="${pageContext.request.contextPath}/images/furnitures/Chairs/chair3.jpeg" class="card-img-top">
                                <div class="card-body">
                                    <div class="d-flex justify-content-between"> <span class="fw-bold">Office Chairs set-2</span> <span class="fw-bold">$500</span> </div>
                                    <p class="card-text mb-1 mt-1">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                    <div class="d-flex align-items-center flex-row"> <img src="${pageContext.request.contextPath}/images/furnitures/safety-icon.png" width="20"> <span class="guarantee">7 Years Guarantee</span> </div>
                                </div>
                                <hr>
                                <div class="card-body">
                                    <div class="text-right buttons"> <button class="btn btn-outline-dark">add to wishlist</button> <button class="btn btn-dark">Add to cart</button> </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="card"> <img src="${pageContext.request.contextPath}/images/furnitures/Chairs/chair4.jpeg" class="card-img-top">
                                <div class="card-body">
                                    <div class="d-flex justify-content-between"> <span class="fw-bold">Wodden Chair set-3</span> <span class="fw-bold">$350</span> </div>
                                    <p class="card-text mb-1 mt-1">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                    <div class="d-flex align-items-center flex-row"> <img src="${pageContext.request.contextPath}/images/furnitures/safety-icon.png" width="20"> <span class="guarantee">3 Years Guarantee</span> </div>
                                </div>
                                <hr>
                                <div class="card-body">
                                    <div class="text-right buttons"> <button class="btn btn-outline-dark">add to wishlist</button> <button class="btn btn-dark">Add to cart</button> </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="card"> <img src="${pageContext.request.contextPath}/images/furnitures/Chairs/chair5.jpeg" class="card-img-top">
                                <div class="card-body">
                                    <div class="d-flex justify-content-between"> <span class="fw-bold">Dinning chairs set-4</span> <span class="fw-bold">$200</span> </div>
                                    <p class="card-text mb-1 mt-1">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                    <div class="d-flex align-items-center flex-row"> <img src="${pageContext.request.contextPath}/images/furnitures/safety-icon.png" width="20"> <span class="guarantee">8 Years Guarantee</span> </div>
                                </div>
                                <hr>
                                <div class="card-body">
                                    <div class="text-right buttons"> <button class="btn btn-outline-dark">add to wishlist</button> <button class="btn btn-dark">Add to cart</button> </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="card"> <img src="${pageContext.request.contextPath}/images/furnitures/Chairs/chair6.jpeg" class="card-img-top">
                                <div class="card-body">
                                    <div class="d-flex justify-content-between"> <span class="fw-bold">Office Chairs set-2</span> <span class="fw-bold">$450</span> </div>
                                    <p class="card-text mb-1 mt-1">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                    <div class="d-flex align-items-center flex-row"> <img src="${pageContext.request.contextPath}/images/furnitures/safety-icon.png" width="20"> <span class="guarantee">3 Years Guarantee</span> </div>
                                </div>
                                <hr>
                                <div class="card-body">
                                    <div class="text-right buttons"> <button class="btn btn-outline-dark">add to wishlist</button> <button class="btn btn-dark">Add to cart</button> </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="tab-pane fade" id="contact" role="tabpanel" aria-labelledby="contact-tab">
                    <!--Dining-->
                    <!-- <div class="d-flex justify-content-between p-3 bg-white mb-3 align-items-center"> <span class="fw-bold text-uppercase">Luxury Dining</span>
                        <div> <img src="https://img.icons8.com/windows/100/000000/list.png" width="30" /> <img src="https://img.icons8.com/ios-filled/100/000000/squared-menu.png" width="25" /> </div>
                    </div> -->
                    <div class="row g-3">
                        <div class="col-md-4">
                            <div class="card"> <img src="${pageContext.request.contextPath}/images/furnitures/dining/dining1.jpeg" class="card-img-top">
                                <div class="card-body">
                                    <div class="d-flex justify-content-between"> <span class="fw-bold">Dinning table set-4</span> <span class="fw-bold">$450</span> </div>
                                    <p class="card-text mb-1 mt-1">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                    <div class="d-flex align-items-center flex-row"> <img src="${pageContext.request.contextPath}/images/furnitures/safety-icon.png" width="20"> <span class="guarantee">4 Years Guarantee</span> </div>
                                </div>
                                <hr>
                                <div class="card-body">
                                    <div class="text-right buttons"> <button class="btn btn-outline-dark">add to wishlist</button> <button class="btn btn-dark">Add to cart</button> </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="card"> <img src="${pageContext.request.contextPath}/images/furnitures/dining/dining2.jpeg" class="card-img-top">
                                <div class="card-body">
                                    <div class="d-flex justify-content-between"> <span class="fw-bold">Dinning set set-8</span> <span class="fw-bold">$2,000</span> </div>
                                    <p class="card-text mb-1 mt-1">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                    <div class="d-flex align-items-center flex-row"> <img src="${pageContext.request.contextPath}/images/furnitures/safety-icon.png" width="20"> <span class="guarantee">6 Years Guarantee</span> </div>
                                </div>
                                <hr>
                                <div class="card-body">
                                    <div class="text-right buttons"> <button class="btn btn-outline-dark">add to wishlist</button> <button class="btn btn-dark">Add to cart</button> </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="card"> <img src="${pageContext.request.contextPath}/images/furnitures/dining/dining3.jpeg" class="card-img-top">
                                <div class="card-body">
                                    <div class="d-flex justify-content-between"> <span class="fw-bold">Dinning chairs set-3</span> <span class="fw-bold">$900</span> </div>
                                    <p class="card-text mb-1 mt-1">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                    <div class="d-flex align-items-center flex-row"> <img src="${pageContext.request.contextPath}/images/furnitures/safety-icon.png" width="20"> <span class="guarantee">4 Years Guarantee</span> </div>
                                </div>
                                <hr>
                                <div class="card-body">
                                    <div class="text-right buttons"> <button class="btn btn-outline-dark">add to wishlist</button> <button class="btn btn-dark">Add to cart</button> </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="card"> <img src="${pageContext.request.contextPath}/images/furnitures/dining/dining4.jpeg" class="card-img-top">
                                <div class="card-body">
                                    <div class="d-flex justify-content-between"> <span class="fw-bold">Dinning table set-10</span> <span class="fw-bold">$3,500</span> </div>
                                    <p class="card-text mb-1 mt-1">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                    <div class="d-flex align-items-center flex-row"> <img src="${pageContext.request.contextPath}/images/furnitures/safety-icon.png" width="20"> <span class="guarantee">6 Years Guarantee</span> </div>
                                </div>
                                <hr>
                                <div class="card-body">
                                    <div class="text-right buttons"> <button class="btn btn-outline-dark">add to wishlist</button> <button class="btn btn-dark">Add to cart</button> </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="card"> <img src="${pageContext.request.contextPath}/images/furnitures/dining/dining5.jpeg" class="card-img-top">
                                <div class="card-body">
                                    <div class="d-flex justify-content-between"> <span class="fw-bold">Table chair set-5</span> <span class="fw-bold">$250</span> </div>
                                    <p class="card-text mb-1 mt-1">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                    <div class="d-flex align-items-center flex-row"> <img src="${pageContext.request.contextPath}/images/furnitures/safety-icon.png" width="20"> <span class="guarantee">8 Years Guarantee</span> </div>
                                </div>
                                <hr>
                                <div class="card-body">
                                    <div class="text-right buttons"> <button class="btn btn-outline-dark">add to wishlist</button> <button class="btn btn-dark">Add to cart</button> </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="card"> <img src="${pageContext.request.contextPath}/images/furnitures/dining/dining6.jpeg" class="card-img-top">
                                <div class="card-body">
                                    <div class="d-flex justify-content-between"> <span class="fw-bold">Luxury Dinning set-7</span> <span class="fw-bold">$750</span> </div>
                                    <p class="card-text mb-1 mt-1">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                    <div class="d-flex align-items-center flex-row"> <img src="${pageContext.request.contextPath}/images/furnitures/safety-icon.png" width="20"> <span class="guarantee">6 Years Guarantee</span> </div>
                                </div>
                                <hr>
                                <div class="card-body">
                                    <div class="text-right buttons"> <button class="btn btn-outline-dark">add to wishlist</button> <button class="btn btn-dark">Add to cart</button> </div>
                                </div>
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
</body>
</html>