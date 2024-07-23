<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 <%@ page import="java.util.Map" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/asserts/css/customerstyles.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.9.1/font/bootstrap-icons.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <!-- <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"> -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>Document</title>

    <style>
        /* Existing CSS code */
        
        .product-cardd {
            border-style: solid;
            border-color: whitesmoke;
            border-bottom-width: 1px;
            border-top-width: 1px;
            border-left-width: 0px;
            border-right-width: 0px;
            display: flex;
            flex-wrap: nowrap;
            padding: 20px;
            background-color: white !important;
        }
        
        .products:hover .name-pro {
            color: rgb(27, 99, 174) !important;
        }
        
        .shoes {
            width: 80%;
            margin-left: 20%;
        }
        
        .products a {
            text-decoration: none;
        }
        
        .product-outer img {
            min-height: 110px !important;
            max-height: 190px !important;
            min-width: 45px;
        }
        
        .product-info a {
            text-decoration: none;
            color: white;
            padding: 6px;
            border-radius: 7px;
        }
        
        .footer {
            background-color: #f8f9fa;
            padding-top: 1px;
        }
        
        .footer h5 {
            margin-bottom: 20px;
            font-weight: bold;
        }
        
        .footer a {
            color: rgb(27, 99, 174);
            text-decoration: none;
        }
        
        .footer a:hover {
            color: gray;
        }
        
        .footer .social-icons a {
            font-size: 1.5rem;
            margin-right: 10px;
            color: rgb(27, 99, 174);
        }
        
        .footer .social-icons a:hover {
            color: rgb(27, 99, 174);
        }
        
        body {
            background-color: #e9e9e9;
        }
        
        /* .container {
            margin-top: 10px;
        } */
        
        .item {
            background: #fff;
            -webkit-box-shadow: 1px 1px 1px rgba(0, 0, 0, 0.1);
            box-shadow: 1px 1px 1px rgba(0, 0, 0, 0.1);
            padding: 20px;
            margin-bottom: 20px;
            overflow: hidden;
            position: relative;
            height: 300px;
        }
        
        .item h4 {
            font-size: 1rem;
        }
        
        .text-primary {
            color: #ff6b6b !important;
        }
        
        .item img {
            margin: 0 auto;
            display: inherit;
            width: 230px;
            height: 164px;
        }
        
        .btn {
            font-weight: 400;
            border: 1px solid transparent;
            padding: .375rem .75rem;
            font-size: 1rem;
            line-height: 1.5;
            border-radius: .25rem;
        }
        
        .btn-dark {
            border-radius: 50px !important;
            padding-left: 30px !important;
            padding-right: 30px !important;
            margin-bottom: 10px;
        }
        
        .btn-unique {
            color: #212529;
            background-color: rgb(27, 99, 174);
            border-color: rgb(27, 99, 174);
            color: #fff;
        }
        
        .btn-unique:hover {
            color: rgb(27, 99, 174);
            border-color: rgb(27, 99, 174);
            border-radius: 3px;
        }
        
        #category-menu-bar {
            font-weight: 500;
            margin-top: 150px;
        }
        
        .dropdown-content {
            display: none;
            position: absolute;
            background-color: #f9f9f9;
            min-width: 60px;
            box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
            z-index: 1;
            border-radius: 5px;
        }
        
        .grey-lightclr {
            background-color: rgb(239, 239, 239) !important;
        }
        
        .dropdown-content a {
            text-decoration: none;
        }
        
        .dropdown {
            position: relative;
            display: inline-block;
        }
        
        .dropdown:hover .dropdown-content {
            display: block;
        }
        
        .top-cat-menu:hover {
            color: rgb(27, 99, 174) !important;
        }
        
        .categorya {
            font-size: 13px;
            color: grey;
            margin: 0;
        }
        
        a {
            text-decoration: none;
        }
        
        .cat-menu-container {
            width: 900px !important;
        }
        
        .btn-serch {
            background-color: rgb(27, 99, 174);
            color: white;
        }
        
        .btn-serch:hover {
            border-color: rgb(27, 99, 174);
            border-radius: 5px;
            color: rgb(27, 99, 174) !important;
        }
        
        /* Responsive CSS */
        
        @media (max-width: 1200px) {
            .cat-menu-container {
                width: 100% !important;
            }
        }
        
        @media (max-width: 992px) {
            .d-flex {
                flex-direction: column !important;
                align-items: center;
            }
        
            .dropdown-content {
                position: static;
                width: 100%;
                box-shadow: none;
            }
        
            .dropdown-content .row {
                flex-direction: column;
            }
        
            .cat-menu-container {
                width: 100%;
            }
        }
        
        @media (max-width: 768px) {
            .top-cat-menu {
                font-size: 14px;
            }
        
            .categorya {
                font-size: 12px;
            }
        
            .cat-menu-container {
                padding: 10px;
            }
        
            .dropdown-content {
                padding: 0;
            }
        
            .dropdown-content .row {
                flex-direction: column;
            }
        
            .dropdown-content .col {
                width: 100%;
                padding: 0;
            }
        }
        
        @media (max-width: 576px) {
            .d-flex {
                flex-direction: column;
                align-items: center;
            }
        
            .top-cat-menu {
                font-size: 12px;
            }
        
            .cat-menu-container {
                padding: 5px;
            }
        }
        
        </style>
        
</head>
<body class="bg-light">
    <div class="navbar navbar-expand-lg navbar-light bg-white shadow-sm fixed-top" id="main-navv">
        <div class="container-fluid">
            <a class="navbar-brand d-none d-md-block" href="#option-menu">
                <img src="${pageContext.request.contextPath}/asserts/images/logo.png" class="rounded" width="210" height="110" alt="">
            </a>
            <a class="navbar-brand d-md-none" href="#option-menu">
                <img src="${pageContext.request.contextPath}/asserts/images/logo.png" class="rounded" width="100" height="50" alt="">
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
                        <a class="nav-link" href="customerLogin">
                            <i class="fa fa-user"></i> Login
                        </a>
                    </li>
                    <li class="nav-item txt-nav">
                        <a class="nav-link" href="forwardHomepage">
                            <i class="fa fa-home"></i> Home
                        </a>
                    </li>
                    <li class="nav-item txt-nav">
                        <a class="nav-link" href="CustomerCartController">
                            <i class="fa fa-shopping-cart" value="${sessionScope.user.getMyCart().getMyCart().size()}" id="nav-cart"></i> Cart
                        </a>
                    </li>
                  
                    <li class="nav-item dropdown invisible" id="profile-pg">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            <i class="fa fa-user"></i> ${sessionScope.user.getFirstName()}
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="#"><i class="fa fa-user"></i> Profile</a></li>
                            <li><a class="dropdown-item" href="CustomerOrdersController"><i class="fa fa-list"></i> My Orders</a></li>
                            <li><a class="dropdown-item" href="CustomerLogoutController"><i class="fa fa-sign-out"></i> Logout</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </div>

    <div class="container-fluid bg-white" id="category-menu-bar">
        <div class="d-flex flex-row justify-content-evenly pt-2 pb-2">
            <div class="dropdown">
                <a href="" class="top-cat-menu"><span class="text-dark">Electronics</span></a>
                <div class="container">
                    <div class="dropdown-content pb-0">
                        <div class="row">
                            <div class="col bg-white cat-menu-container pt-3">
                                <a href="#">
                                    <p class="text-dark cat-topic">Mobiles</p>
                                </a>
                                <div class="category-menu-items pb-0">
                                    <a href="#" class="categorya">
                                        <p>Mi</p>
                                    </a>
                                    <a href="#" class="categorya">
                                        <p>Realme</p>
                                    </a>
                                    <a href="#" class="categorya">
                                        <p>Apple</p>
                                    </a>
                                    <a href="#" class="categorya">
                                        <p>Infinix</p>
                                    </a>
                                    <a href="#" class="categorya">
                                        <p>Oppo</p>
                                    </a>
                                    <a href="#" class="categorya">
                                        <p>Vivo</p>
                                    </a>
                                    <a href="#" class="categorya">
                                        <p>Samsung</p>
                                    </a>
                                    <a href="#" class="categorya">
                                        <p>Honor</p>
                                    </a>
                                    <a href="#" class="categorya">
                                        <p>Asus</p>
                                    </a>
                                    <a href="#" class="categorya">
                                        <p>Nothing</p>
                                    </a>
                                </div>
                            </div>

                            <div class="col bg-white grey-lightclr pt-3">
                                <a href="#">
                                    <p class="text-dark cat-topic">Mobile Accessories</p>
                                </a>
                                <div class="category-menu-items pb-0">
                                    <a href="#" class="categorya">
                                        <p>Mobile Cases</p>
                                    </a>
                                    <a href="#" class="categorya">
                                        <p>Headphones & Headsets</p>
                                    </a>
                                    <a href="#" class="categorya">
                                        <p>Power Banks</p>
                                    </a>
                                    <a href="#" class="categorya">
                                        <p>Screenguards</p>
                                    </a>
                                    <a href="#" class="categorya">
                                        <p>Oppo</p>
                                    </a>
                                    <a href="#" class="categorya">
                                        <p>Vivo</p>
                                    </a>
                                    <a href="#" class="categorya">
                                        <p>Samsung</p>
                                    </a>
                                </div>
                                <a href="#">
                                    <p class="text-dark cat-topic">Smart Wearable Tech's</p>
                                </a>
                                <div>
                                    <a href="#" class="categorya">
                                        <p>Smart watches</p>
                                    </a>
                                    <a href="#" class="categorya">
                                        <p>Smart Glasses</p>
                                    </a>
                                </div>
                                <a href="#">
                                    <p class="text-dark cat-topic">Health Care Appliances</p>
                                </a>
                                <div>
                                    <a href="#" class="categorya">
                                        <p>Bp Monitor</p>
                                    </a>
                                    <a href="#" class="categorya">
                                        <p>Weighting Scale</p>
                                    </a> 
                                </div>
                            </div>
                            <div class="col bg-white pt-3">
                                <a href="#">
                                    <p class="text-dark cat-topic">Laptops</p>
                                </a>
                                <div class="category-menu-items pb-0">
                                    <a href="#" class="categorya">
                                        <p>Gaming Laptop</p>
                                    </a>
                                    <a href="#" class="categorya">
                                        <p>Professional Laptops</p>
                                    </a>
                                   
                                </div>
                                <a href="#">
                                    <p class="text-dark cat-topic">Smart Wearable Tech's</p>
                                </a>
                                <div>
                                    <a href="#" class="categorya">
                                        <p>External Hard disks</p>
                                    </a>
                                    <a href="#" class="categorya">
                                        <p>Pendrives</p>
                                    </a>
                                    <a href="#" class="categorya">
                                        <p>Laptop Bags</p>
                                    </a>
                                    <a href="#" class="categorya">
                                        <p>Mouse</p>
                                    </a>
                                </div>
                                <a href="#">
                                    <p class="text-dark cat-topic">Computer Peripherals</p>
                                </a>
                                <div>
                                    <a href="#" class="categorya">
                                        <p>Printers</p>
                                    </a>
                                    <a href="#" class="categorya">
                                        <p>Monitors</p>
                                    </a> 
                                </div>
                            </div>
                            <div class="col grey-lightclr pt-3">
                                <a href="#">
                                    <p class="text-dark cat-topic">Speakers</p>
                                </a>
                                <div >
                                    <a href="#" class="categorya"><p>Home Audio Speakers</p></a>
                                    <a href="#" class="categorya"><p>Home Theatres</p></a>
                                    <a href="#" class="categorya"><p>SoundBars</p></a>
                                </div>
                                <a href="#"><p class="text-dark cat-topic">Camera</p></a>
                                <div>
                                    <a href="#" class="categorya"><p>DSLR & MirrorLess</p></a>
                                    <a href="#" class="categorya"><p>Compact & Bridge Cameras</p></a>
                                    <a href="#" class="categorya"><p>Sports & Actions</p></a>
                                </div>
                                <a href="#"><p class="text-dark cat-topic">Camera Accessories</p></a>
                                <div>
                                    <a href="#" class="categorya"><p>Lens</p></a>
                                    <a href="#" class="categorya"><p>Tripods</p></a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
             



            </div>
            <div class="dropdown">
                <a href="" class="top-cat-menu"><span class="text-dark">Tv & Appliances</span></a>
                <div class="container">
                    <div class="dropdown-content">
                        <div class="row">
                            <div class="col bg-white cat-menu-container pt-3">
                                <a href="#">
                                    <p class="text-dark cat-topic">Top Brands</p>
                                </a>
                                <div class="category-menu-items pb-0">
                                    <a href="#" class="categorya"><p>Mi</p></a>
                                    <a href="#" class="categorya"><p>Vu</p></a>
                                    <a href="#" class="categorya"><p>Thomson</p></a>
                                    <a href="#" class="categorya"><p>Samsung</p></a>
                                    <a href="#" class="categorya"><p>Nokia</p></a>
                                    <a href="#" class="categorya"><p>LG</p></a>
                                    
                                </div>
                                <a href="#"><p class="text-dark cat-topic">Shop By screen size</p></a>
                                <div>
                                    <a href="#" class="categorya"><p>24 & Below</p></a>
                                    <a href="#" class="categorya"><p>29-32</p></a>
                                    <a href="#" class="categorya"><p>39-43</p></a>
                                    <a href="#" class="categorya"><p>48-55</p></a>
                                </div>
                                <a href="#"><p class="text-dark cat-topic">Camera Accessories</p></a>
                                <div>
                                    <a href="#" class="categorya"><p>Lens</p></a>
                                    <a href="#" class="categorya"><p>Tripods</p></a>
                                </div>
                            </div>
                            <div class="col bg-white grey-lightclr cat-menu-container pt-3">
                                <a href="#">
                                    <p class="text-dark cat-topic">Washing Machine</p>
                                </a>
                                <div>
                                    <a href="#" class="categorya"><p>Fully Automatic Front Load</p></a>
                                    <a href="#" class="categorya"><p>Semi Automatic Top Load</p></a>
                                    <a href="#" class="categorya"><p>Fully Automatic Top Load</p></a>
                                    
                                    
                                </div>
                                <a href="#"><p class="text-dark cat-topic">Air Conditioners</p></a>
                                <div>
                                    <a href="#" class="categorya"><p>Inverter AC</p></a>
                                    <a href="#" class="categorya"><p>Split Ac</p></a>
                                    <a href="#" class="categorya"><p>Windows Ac</p></a>
                                    <!-- <a href="#" class="categorya"><p>48-55</p></a> -->
                                </div>
                                <a href="#"><p class="text-dark cat-topic">Refridgerators</p></a>
                                <div>
                                    <a href="#" class="categorya"><p>Single Door</p></a>
                                    <a href="#" class="categorya"><p>Double Door</p></a>
                                    <a href="#" class="categorya"><p>Triple Door</p></a>
                                    <a href="#" class="categorya"><p>Side By Side</p></a>
                                </div>
                            </div>

                            <div class="col bg-white cat-menu-container pt-3">
                                <a href="#">
                                    <p class="text-dark cat-topic">Kitchen Appliances</p>
                                </a>
                                <div>
                                    <a href="#" class="categorya"><p>Microwave Owens</p></a>
                                    <a href="#" class="categorya"><p>Juicer/Mixer/Grinder</p></a>
                                    <a href="#" class="categorya"><p>Electric Kettle</p></a>
                                    <a href="#" class="categorya"><p>Induction CookTops</p></a>
                                    <a href="#" class="categorya"><p>Hand Blenders</p></a>
                                    <a href="#" class="categorya"><p>Coffee Makers</p></a>
                                    
                                </div>
                                <a href="#"><p class="text-dark cat-topic">Small Home Appliances</p></a>
                                <div>
                                    <a href="#" class="categorya"><p>Irons</p></a>
                                    <a href="#" class="categorya"><p>Water Purifiers</p></a>
                                    <a href="#" class="categorya"><p>Air Coolers</p></a>
                                    <a href="#" class="categorya"><p>Fans</p></a>
                                    <a href="#" class="categorya"><p>Inverters</p></a>
                                </div>
                                <a href="#"><p class="text-dark cat-topic">Camera Accessories</p></a>
                                <div>
                                    <a href="#" class="categorya"><p>Lens</p></a>
                                    <a href="#" class="categorya"><p>Tripods</p></a>
                                </div>
                            </div>
                            <div class="col bg-white grey-lightclr cat-menu-container pt-3">
                                <a href="#">
                                    <p class="text-dark cat-topic">Top Brands</p>
                                </a>
                                <div>
                                    <a href="#" class="categorya"><p>Mi</p></a>
                                    <a href="#" class="categorya"><p>Vu</p></a>
                                    <a href="#" class="categorya"><p>Thomson</p></a>
                                    <a href="#" class="categorya"><p>Samsung</p></a>
                                    <a href="#" class="categorya"><p>Nokia</p></a>
                                    <a href="#" class="categorya"><p>LG</p></a>
                                    
                                </div>
                                <a href="#"><p class="text-dark cat-topic">Shop By screen size</p></a>
                                <div>
                                    <a href="#" class="categorya"><p>24 & Below</p></a>
                                    <a href="#" class="categorya"><p>29-32</p></a>
                                    <a href="#" class="categorya"><p>39-43</p></a>
                                    <a href="#" class="categorya"><p>48-55</p></a>
                                </div>
                                <a href="#"><p class="text-dark cat-topic">Camera Accessories</p></a>
                                <div>
                                    <a href="#" class="categorya"><p>Lens</p></a>
                                    <a href="#" class="categorya"><p>Tripods</p></a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="dropdown">
                <a href="" class="top-cat-menu"><span class="text-dark">Men</span></a>
                <div class="container">
                    <div class="dropdown-content">
                        <div class="row">
                            <div class="col bg-white cat-menu-container pt-3">
                                <a href="#"><p class="text-dark cat-topic">FootWear</p></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div>
                <span>Women</span>
            </div>
            <div>
                <span>Baby & Kids</span>
            </div>
            <div>
                <span>Home & Furniture</span>
            </div>
            <div>
                <span>Sports,Books & More</span>
            </div>
            <div>
                <span>Offer zone</span>
            </div>

        </div>

    </div>
    <div class="container-flex mt-3 bg-white px-4 pt-3 pb-1 align-items-center">
    	<nav aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="forwardHomepage">Home</a></li>
                <li class="breadcrumb-item">Mobiles</li>
                
            </ol>
        </nav>
    </div>
    <div class="container-fluid mt-4 row">
        <aside id="filter-bar" class="col-md-3 col-sm-3 bg-white col-lg-2 filter-bar" style="height: fit-content;">
            <div class="filter-content p-3">
                <h5>Filters</h5>
                <h6>Categories</h6>
                <p><a href="homepage.html">Homepage</a></p>
                <p>Mobiles</p>
                <h6>Price</h6>
                <div class="d-flex justify-content-between">
                    <select class="form-control w-50 mr-1">
                        <option>Min</option>
                        <option>₹1000</option>
                        <option>₹5000</option>
                        <option>₹10000</option>
                    </select>
                    <select class="form-control w-50 ml-1">
                        <option>₹30000+</option>
                        <option>₹20000</option>
                        <option>₹15000</option>
                        <option>₹10000</option>
                    </select>
                </div>
                <h6>Brand</h6>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="" id="brandMi">
                    <label class="form-check-label" for="brandMi">Mi</label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="" id="brandSamsung">
                    <label class="form-check-label" for="brandSamsung">Samsung</label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="" id="brandApple">
                    <label class="form-check-label" for="brandApple">Apple</label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="" id="brandOnePlus">
                    <label class="form-check-label" for="brandOnePlus">OnePlus</label>
                </div>
                <h6>Customer Ratings</h6>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="" id="rating4">
                    <label class="form-check-label" for="rating4">4★ & above</label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="" id="rating3">
                    <label class="form-check-label" for="rating3">3★ & above</label>
                </div>
                <h6>GST Invoice Available</h6>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="" id="gstInvoice">
                    <label class="form-check-label" for="gstInvoice">GST Invoice Available</label>
                </div>
            </div>
        </aside>
        <main class="col-md-9  col-lg-10">
         <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
         <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
         
         
            <c:forEach var="mobile" items="${mobiles}">
   
            <c:set var="originalPrice" value="${mobile.value.productPrice + (mobile.value.productPrice * 21 / 100)}" />
            <form action="MobileViewPageController" method="post">
            <input type="hidden" name="productId" value="${mobile.key}">
            <button type="submit" style="border: none;" class="text-start p-0">
            <div class="product-outer">
                <a href="${pageContext.request.contextPath}/views/customer/mobilepage.jsp" class="products text-decoration-none">
                    <div class="product-cardd bg-light product text-decoration-none">
                        <div class="col-md-2 col-sm-2 justify-content-center mb-3 mb-md-0 d-flex ">
                            <div>
                                <img class="img-fluid" src="${pageContext.request.contextPath}/asserts/images/Mobiles/mob1.webp"  alt="Product Image">
                            </div>
                            <div class="align-self-start mx-2">
                                <i class="bi bi-heart-fill text-secondary"></i>
                            </div>
                            
                        </div>
                        <div class="col-md-7 col-sm-6 product-info pt-0 px-2">
                            <h5 class="mb-0 pb-0 name-pro text-dark">${mobile.value.subtitle}(${mobile.key})</h5>
                            <div class="row pt-0 mt-0 mb-2 align-items-center">
                                <div class="col-auto mt-2">
                                    <span class="bg-success text-white p-1 rounded">
                                        4.4 <i class="bi bi-star-fill"></i>
                                    </span>
                                   
                                </div>
                                <div class="col px-0">
                                    <span class="text-secondary">2,823 Ratings & 124 Reviews</span>
                                </div>
                            </div>
                            <ul class="text-dark">
                           <c:forEach var="spec" items="${mobile.value.specifications}">
                                    <li>${spec}</li>
                            </c:forEach>
                          <!--       <li>16.94 cm(6.67 inch) Full HD+ AMOLED Display</li>
                                <li>108MP Rear Camera | 16MP Front Camera</li>
                                <li>5160 mAh Li-Polymer Battery</li>
                                <li>Mediatek Dimensity 920 Processor</li> -->
                                <li>${mobile.value.warranty} Warranty for Device and 6 Month Manufacturer Warranty for In-box Accessories</li>
                            </ul>
                        </div>
                        <div class="col-md-3 col-sm-2 text-left product-price px-1">
                            <h2 class="text-dark"><fmt:formatNumber value="${mobile.value.productPrice}" type="currency" currencySymbol="₹" minFractionDigits="0" maxFractionDigits="0"/></h2>
                            <p class="mb-0 text-dark"><span><strike><fmt:formatNumber value="${originalPrice}" type="currency" currencySymbol="₹" minFractionDigits="0" maxFractionDigits="0"/></strike> <span class="text-success fw-bold">21% off</span></span></p>
                            <p class="mb-0 text-dark">Free Delivery by <b>Tomorrow</b></p>
                            <p class="mb-0"><b class="text-success">Save Extra with combo offers</b></p>
                            <p><b class="text-success">Bank Offers</b></p>
                        </div>
                    </div>
                </a>
            </div>
            </button>
            </form>
            </c:forEach>
         <!--   <div class="product-outer">
                <a href="./productShowPage.html" class="products text-decoration-none">
                    <div class="product-cardd bg-light product text-decoration-none">
                        <div class="col-md-2 col-sm-2 justify-content-center mb-3 mb-md-0 d-flex ">
                            <div>
                                <img class="img-fluid" src="${pageContext.request.contextPath}/images/Mobiles/mob1.webp"  alt="Product Image">
                            </div>
                            <div class="align-self-start mx-2">
                                <i class="bi bi-heart-fill text-secondary"></i>
                            </div>
                            <!-- <div class="mt-3">
                                <input type="checkbox" id="add1">
                                <label for="add1">Add to Compare</label>
                            </div> 
                        </div>
                        <div class="col-md-7 col-sm-6 product-info pt-0 px-2">
                            <h5 class="mb-0 pb-0 name-pro text-dark">realme 12xx 5G (Twilight Purple, 128GB)</h5>
                            <div class="row pt-0 mt-0 mb-2 align-items-center">
                                <div class="col-auto mt-2">
                                    <span class="bg-success text-white p-1 rounded">
                                        4.4 <i class="bi bi-star-fill"></i>
                                    </span>
                                    <!-- <button class="btn btn-sm btn-success text-white p-1">
                                        <span class="ratings">4.4 </span><i class="bi bi-star-fill"></i>
                                    </button>
                                </div>
                                <div class="col px-0">
                                    <span class="text-secondary">2,823 Ratings & 124 Reviews</span>
                                </div>
                            </div>
                            <ul class="text-dark">
                                <li>8 GB RAM | 128 GB ROM | Expandable up to 2 TB</li>
                                <li>16.94 cm(6.67 inch) Full HD+ AMOLED Display</li>
                                <li>108MP Rear Camera | 16MP Front Camera</li>
                                <li>5160 mAh Li-Polymer Battery</li>
                                <li>Mediatek Dimensity 920 Processor</li>
                                <li>1 Year Manufacturer Warranty for Device and 6 Month Manufacturer Warranty for In-box Accessories</li>
                            </ul>
                        </div>
                        <div class="col-md-3 col-sm-2 text-left product-price px-1">
                            <h2 class="text-dark">$14,999</h2>
                            <p class="mb-0 text-dark"><span><strike>$18,999</strike> <span class="text-success fw-bold">21% off</span></span></p>
                            <p class="mb-0 text-dark">Free Delivery by <b>Tomorrow</b></p>
                            <p class="mb-0"><b class="text-success">Save Extra with combo offers</b></p>
                            <p><b class="text-success">Bank Offers</b></p>
                        </div>
                    </div>
                </a>
            </div>
        
            <div class="product-outer">
                <a href="./productShowPage.html" class="products text-decoration-none">
                    <div class="product-cardd bg-light product text-decoration-none">
                        <div class="col-md-2 col-sm-2 justify-content-center mb-3 mb-md-0 d-flex ">
                            <div class="">
                                <img class="img-fluid" src="${pageContext.request.contextPath}/images/Mobiles/mob2.webp"  alt="Product Image">
                            </div>
                            <div class="align-self-start mx-2">
                                <i class="bi bi-heart-fill text-secondary"></i>
                            </div>
                            <!-- <div class="mt-3">
                                <input type="checkbox" id="add1">
                                <label for="add1">Add to Compare</label>
                            </div> 
                        </div>
                        <div class="col-md-7 col-sm-6 product-info pt-0 px-2">
                            <h5 class="mb-0 pb-0 name-pro text-dark">Xiaomi 11i 5G (Purple Mist, 128 GB)</h5>
                            <div class="row pt-0 mt-0 mb-2 align-items-center">
                                <div class="col-auto mt-2">
                                    <span class="bg-success text-white p-1 rounded">
                                        4.2 <i class="bi bi-star-fill"></i>
                                    </span>
                                    <!-- <button class="btn btn-sm btn-success text-white p-1">
                                        <span class="ratings">4.4 </span><i class="bi bi-star-fill"></i>
                                    </button> 
                                </div>
                                <div class="col px-0">
                                    <span class="text-secondary">3,823 Ratings & 231 Reviews</span>
                                </div>
                            </div>
                            <ul class="text-dark">
                                <li>8 GB RAM | 128 GB ROM | Expandable up to 2 TB</li>
                                <li>16.94 cm(6.67 inch) Full HD+ AMOLED Display</li>
                                <li>108MP Rear Camera | 16MP Front Camera</li>
                                <li>5160 mAh Li-Polymer Battery</li>
                                <li>Mediatek Dimensity 920 Processor</li>
                                <li>1 Year Manufacturer Warranty for Device and 6 Month Manufacturer Warranty for In-box Accessories</li>
                            </ul>
                        </div>
                        <div class="col-md-3 col-sm-2 text-left product-price px-1">
                            <h2 class="text-dark">$14,999</h2>
                            <p class="mb-0 text-dark"><span><strike>$18,999</strike> <span class="text-success fw-bold">21% off</span></span></p>
                            <p class="mb-0 text-dark">Free Delivery by <b>Tomorrow</b></p>
                            <p class="mb-0"><b class="text-success">Save Extra with combo offers</b></p>
                            <p><b class="text-success">Bank Offers</b></p>
                        </div>
                    </div>
                </a>
            </div>
        
            <div class="product-outer">
                <a href="./productViewPage.html" class="products text-decoration-none">
                    <div class="product-cardd bg-light product text-decoration-none">
                        <div class="col-md-2 col-sm-2 justify-content-center mb-3 mb-md-0 d-flex ">
                            <div>
                                <img class="img-fluid" src="${pageContext.request.contextPath}/images/Mobiles/mob3.webp" alt="Product Image">
                            </div>
                            <div class="align-self-start mx-2">
                                <i class="bi bi-heart-fill text-secondary"></i>
                            </div>
                           
                        </div>
                        <div class="col-md-7 col-sm-6 product-info pt-0 px-2">
                            <h5 class="mb-0 pb-0 name-pro text-dark">realme 12xx 5G (Twilight Purple, 128GB)</h5>
                            <div class="row pt-0 mt-0 mb-2 align-items-center">
                                <div class="col-auto mt-2">
                                    <span class="bg-success text-white p-1 rounded">
                                        4.4 <i class="bi bi-star-fill"></i>
                                    </span>
                                 
                                </div>
                                <div class="col px-0">
                                    <span class="text-secondary">2,823 Ratings & 124 Reviews</span>
                                </div>
                            </div>
                            <ul class="text-dark">
                                <li>8 GB RAM | 128 GB ROM | Expandable up to 2 TB</li>
                                <li>16.94 cm(6.67 inch) Full HD+ AMOLED Display</li>
                                <li>108MP Rear Camera | 16MP Front Camera</li>
                                <li>5160 mAh Li-Polymer Battery</li>
                                <li>Mediatek Dimensity 920 Processor</li>
                                <li>1 Year Manufacturer Warranty for Device and 6 Month Manufacturer Warranty for In-box Accessories</li>
                            </ul>
                        </div>
                        <div class="col-md-3 col-sm-2 text-left product-price px-1">
                            <h2 class="text-dark">$14,999</h2>
                            <p class="mb-0 text-dark"><span><strike>$18,999</strike> <span class="text-success fw-bold">21% off</span></span></p>
                            <p class="mb-0 text-dark">Free Delivery by <b>Tomorrow</b></p>
                            <p class="mb-0"><b class="text-success">Save Extra with combo offers</b></p>
                            <p><b class="text-success">Bank Offers</b></p>
                        </div>
                    </div>
                </a>
            </div>
        
        
            <div class="product-outer">
                <a href="./productViewPage.html" class="products text-decoration-none">
                    <div class="product-cardd bg-light product text-decoration-none">
                        <div class="col-md-2 col-sm-2 justify-content-center mb-3 mb-md-0 d-flex ">
                            <div>
                                <img class="img-fluid" src="${pageContext.request.contextPath}/images/Mobiles/mob1.webp" alt="Product Image">
                            </div>
                            <div class="align-self-start mx-2">
                                <i class="bi bi-heart-fill text-secondary"></i>
                            </div>
                           
                        </div>
                        <div class="col-md-7 col-sm-6 product-info pt-0 px-2">
                            <h5 class="mb-0 pb-0 name-pro text-dark">realme 12xx 5G (Twilight Purple, 128GB)</h5>
                            <div class="row pt-0 mt-0 mb-2 align-items-center">
                                <div class="col-auto mt-2">
                                    <span class="bg-success text-white p-1 rounded">
                                        4.4 <i class="bi bi-star-fill"></i>
                                    </span>
                                    
                                </div>
                                <div class="col px-0">
                                    <span class="text-secondary">2,823 Ratings & 124 Reviews</span>
                                </div>
                            </div>
                            <ul class="text-dark">
                                <li>8 GB RAM | 128 GB ROM | Expandable up to 2 TB</li>
                                <li>16.94 cm(6.67 inch) Full HD+ AMOLED Display</li>
                                <li>108MP Rear Camera | 16MP Front Camera</li>
                                <li>5160 mAh Li-Polymer Battery</li>
                                <li>Mediatek Dimensity 920 Processor</li>
                                <li>1 Year Manufacturer Warranty for Device and 6 Month Manufacturer Warranty for In-box Accessories</li>
                            </ul>
                        </div>
                        <div class="col-md-3 col-sm-2 text-left product-price px-1">
                            <h2 class="text-dark">$14,999</h2>
                            <p class="mb-0 text-dark"><span><strike>$18,999</strike> <span class="text-success fw-bold">21% off</span></span></p>
                            <p class="mb-0 text-dark">Free Delivery by <b>Tomorrow</b></p>
                            <p class="mb-0"><b class="text-success">Save Extra with combo offers</b></p>
                            <p><b class="text-success">Bank Offers</b></p>
                        </div>
                    </div>
                </a>
            </div>
        
            <div class="product-outer">
                <a href="./productViewPage.html" class="products text-decoration-none">
                    <div class="product-cardd bg-light product text-decoration-none">
                        <div class="col-md-2 col-sm-2 justify-content-center mb-3 mb-md-0 d-flex ">
                            <div>
                                <img class="img-fluid" src="${pageContext.request.contextPath}/images/Mobiles/mob1.webp" alt="Product Image">
                            </div>
                            <div class="align-self-start mx-2">
                                <i class="bi bi-heart-fill text-secondary"></i>
                            </div>
                           
                        </div>
                        <div class="col-md-7 col-sm-6 product-info pt-0 px-2">
                            <h5 class="mb-0 pb-0 name-pro text-dark">realme 12xx 5G (Twilight Purple, 128GB)</h5>
                            <div class="row pt-0 mt-0 mb-2 align-items-center">
                                <div class="col-auto mt-2">
                                    <span class="bg-success text-white p-1 rounded">
                                        4.4 <i class="bi bi-star-fill"></i>
                                    </span>
                                   
                                </div>
                                <div class="col px-0">
                                    <span class="text-secondary">2,823 Ratings & 124 Reviews</span>
                                </div>
                            </div>
                            <ul class="text-dark">
                                <li>8 GB RAM | 128 GB ROM | Expandable up to 2 TB</li>
                                <li>16.94 cm(6.67 inch) Full HD+ AMOLED Display</li>
                                <li>108MP Rear Camera | 16MP Front Camera</li>
                                <li>5160 mAh Li-Polymer Battery</li>
                                <li>Mediatek Dimensity 920 Processor</li>
                                <li>1 Year Manufacturer Warranty for Device and 6 Month Manufacturer Warranty for In-box Accessories</li>
                            </ul>
                        </div>
                        <div class="col-md-3 col-sm-2 text-left product-price px-1">
                            <h2 class="text-dark">$14,999</h2>
                            <p class="mb-0 text-dark"><span><strike>$18,999</strike> <span class="text-success fw-bold">21% off</span></span></p>
                            <p class="mb-0 text-dark">Free Delivery by <b>Tomorrow</b></p>
                            <p class="mb-0"><b class="text-success">Save Extra with combo offers</b></p>
                            <p><b class="text-success">Bank Offers</b></p>
                        </div>
                    </div>
                </a>
            </div>  --> 
        </main>
    </div>

        
    </div>
    <script type="text/javascript">
    var login_nav = document.getElementById('login-pg');
	var seller_nav = document.getElementById('seller-pg');
	var profile_nav = document.getElementById('profile-pg');
	var currentUser = document.getElementById('navbarDropdown');
	var cart_nav = document.getElementById('nav-cart');
	console.log(currentUser.textContent);
	
	if(currentUser.textContent.trim()=== ""){
		login_nav.classList.remove('invisible');
		seller_nav.classList.remove('invisible');
		//profile_nav.classList.remove('invisible');
	}else{
		profile_nav.classList.remove('invisible');
		cart_nav.classList.add('needed');
	}
    </script>

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