<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/customerstyles.css">
    <!-- <style src="../Css/styles.css" type="stylesheet"></style> -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>ProductPage</title>
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
                  
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            <i class="fa fa-user"></i> Username
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="#"><i class="fa fa-user"></i> Profile</a></li>
                            <li><a class="dropdown-item" href="#"><i class="fa fa-list"></i> My Orders</a></li>
                            <li><a class="dropdown-item" href="#"><i class="fa fa-sign-out"></i> Logout</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <div class="product-content bg-white mx-5 row pt-3">
        <div class="img-block col-4">
            <div class="product-outers">
                <div class="d-flex ">
                    <div class="small-imgs">
                        <div class="border text-center small-image p-2 px-3">
                            <img class="img-fluid" src="${pageContext.request.contextPath}/images/Mobiles/LargeMiImage/large-mi1.webp" alt="">
                        </div>
                        <div class="border text-center small-image  p-2 px-3">
                            <img class="img-fluid" src="${pageContext.request.contextPath}/images/Mobiles/LargeMiImage/large-mi1-1.webp" height="60" alt="">
                        </div>
                        <div class="border text-center small-image  p-2 px-3">
                            <img class="img-fluid" src="${pageContext.request.contextPath}/images/Mobiles/LargeMiImage/large-mi1-2.webp" height="60" alt="">
                        </div>
                        <div class="border text-center small-image p-2 px-3">
                            <img class="img-fluid" src="${pageContext.request.contextPath}/images/Mobiles/LargeMiImage/large-mi1-3.webp" height="60" alt="">
                        </div>
                    </div>
                    <div class="larger-img border p-5">
                        <!-- <div class="">
                            <button class="btn rounded-pill shadow bg-white text-secondary"><i class="bi bi-heart-fill"></i></button>
                        </div> -->
                        <div class="disp-img-big">
                            <img class="img-fluid" id="showBig" src="${pageContext.request.contextPath}/images/Mobiles/LargeMiImage/large-mi1.webp" alt="">
                        </div>
                    </div>
    
    
    
                </div>
                <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
         		<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
         		<% boolean alreadyExist = false; %> 
         		<c:set var="product" value="${choosen}"/>
         		<c:set var="originalPrice" value="${product.productPrice + (product.productPrice * 21 / 100)}" />
                <div class="d-flex mt-3 down-btns justify-content-between">
                	<form action="${pageContext.request.contextPath}/ProductAddCartController" method="post" class="m-0">
                	<input type="hidden" name="productId" value="${product.productId}">
                    <button class="btn-add-cart p-3 border-0" style="width:165px"><%
                    if(request.getAttribute("isExist").equals("true")){ %>
                    	GO TO CART
                <%    }else{ %>
                	ADD TO CART
              <%  }
                    %></button>
                    </form>
                    <form action="${pageContext.request.contextPath}/ProductMakeOrderController"  method="post" class="m-0">
                    <input type="hidden" name="productId" value="${product.productId}">
                    <button class="btn-buy-now p-3 border-0" style="width:175px">BUY NOW</button>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-8 px-2">
            <div class="product-desc-body">
                <p class="fs-4 mb-0">${product.subtitle}</p>
                <div class="row pt-0 mt-0 mb-2 align-items-center">
                    <div class="col-auto mt-2">
                        <span class="bg-success text-white p-1  rounded">
                            4.4 <i class="bi bi-star-fill"></i>
                        </span>
                        <!-- <button class="btn btn-sm btn-success text-white p-1">
                            <span class="ratings">4.4 </span><i class="bi bi-star-fill"></i>
                        </button> -->
                    </div>
                </div>
                <div class="col px-0 pt-1">
                    <span class="text-secondary">2,823 Ratings & 124 Reviews</span>
                </div>
                <p class="text-success pt-2 fw-bold">Extra $5000 off</p>
                <!-- <h2 class="text-dark">$14,999</h2> -->
                <p class="mb-0 text-dark"><span class="text-dark fs-2"><fmt:formatNumber value="${product.productPrice}" type="currency" currencySymbol="₹" minFractionDigits="0" maxFractionDigits="0"/></span><span
                        class="text-secondary"><strike><fmt:formatNumber value="${originalPrice}" type="currency" currencySymbol="₹" minFractionDigits="0" maxFractionDigits="0"/></strike> <span class="text-success fw-bold">21%
                            off</span></span></p>
                <p class="text-dark">+ ₹59 Secured Packaging Fee</p>
                <div class="offers">
                   
                        <div class="offer d-flex">
                            <img src="${pageContext.request.contextPath}/images/Mobiles/offer-img.webp" alt="">
                            <div class="offer-desc">
                                <p class="fs-6 px-2">Bank OfferGet ₹50 instant discount on first Flipkart UPI
                                    transaction on order of ₹200 and above</p>
                            </div>
                            <a href="" class="text-decoration-none">T&C</a>
                        </div>
                        <div class="offer d-flex">
                            <img src="${pageContext.request.contextPath}/images/Mobiles/offer-img.webp" alt="">
                            <div class="offer-desc">
                                <p class="fs-6 px-2">Bank Offer5% Cashback on Flipkart Axis Bank Card</p>
                            </div>
                            <a href="" class="text-decoration-none">T&C</a>
                        </div>
                        <div class="offer d-flex">
                            <img src="${pageContext.request.contextPath}/images/Mobiles/offer-img.webp" alt="">
                            <div class="offer-desc">
                                <p class="fs-6 px-2">Buy for 2000 get ₹500 off your Next Buy</p>
                            </div>
                            <a href="" class="text-decoration-none">T&C</a>
                        </div>
                    
                </div>
                <div class="warranty-desc d-flex ">
                    <div class="brand-product-logo ">
                        <img src="${pageContext.request.contextPath}/images/Mobiles/xiaomi.png" class="img-fluid" height="30" width="70" alt="">
                    </div>
                    <div class="warranty-line">
                        <p>${product.warranty} Manufacturer Warranty for Phone and 6 Months Warranty for in the Box Accessories <a href="">Know More</a></p>
                    </div>
                </div>
                <div class="diff-variations px-2 mt-3">
                    <div class="row">
                        <div class="col-auto">
                            <p class="text-secondary fs-5">Color</p>
                        </div>
                        <div class="col-auto d-flex">
                            <div class="diff-colours border d-flex justify-content-center align-items-center p-1">
                               <a href=""> <img src="${pageContext.request.contextPath}/images/Mobiles/small-img1.jpeg" class="img-fluid"></a>
                            </div>
                            <div class="diff-colours border d-flex justify-content-center align-items-center p-1 mx-4">
                                <a href=""> <img src="${pageContext.request.contextPath}/images/Mobiles/small-img1.jpeg" class="img-fluid"></a>
                             </div>
                             <div class="diff-colours border d-flex justify-content-center align-items-center p-1">
                                <a href=""> <img src="${pageContext.request.contextPath}/images/Mobiles/small-img1.jpeg" class="img-fluid"></a>
                             </div>
                             <div class="diff-colours border d-flex justify-content-center align-items-center p-1 mx-4">
                                <a href=""> <img src="${pageContext.request.contextPath}/images/Mobiles/small-img1.jpeg" class="img-fluid"></a>
                             </div>
                        </div>
                        <div class="col-auto">
                            <p class="text-secondary fs-5 ">RAM</p>
                        </div>
                        <div class="col-auto">
                            <a href="" class="btn btn-outline-secondary p-1 px-2 mx-2">6 GB</a>
                            <a href="" class="btn btn-outline-secondary p-1 px-2">8 GB</a>
                        </div>
                    </div>
                    <div class="highlight-feature mt-3 d-flex">
                        <div class="col-auto">
                            <p class="text-secondary fs-5 ">Highlights</p>
                        </div>
                        <div class="col-auto mx-3 mt-1">
                            <ul>
                            <c:forEach var="spec" items="${product.specifications}">
                            	<li class="mt-2">${spec}</li>
                            </c:forEach>
                                
                           <!--       <li class="mt-2">16.94 cm (6.67 inch) Full HD+ AMOLED Display</li>
                                <li class="mt-2">108MP Rear Camera | 16MP Front Camera</li>
                                <li class="mt-2">5160 mAh Li-Polymer Battery</li>
                                <li class="mt-2">Mediatek Dimensity 920 Processor</li> -->
                            </ul>
                        </div>
                    </div>
                    <div class="vendor-detail mt-3 d-flex">
                        <div class="col-auto">
                            <p class="text-secondary fs-5">Seller</p>
                        </div>
                        <div class="col-auto mx-5 px-2 mt-1">
                            <div class="row px-3">
                                <div class="col-auto mx-0">
                                    <p class="text-primary fw-bold">Vision Star</p>
                                </div>
                                <div class="col-auto">
                                    <span class="bg-primary text-white p-1  rounded">
                                        4.4 <i class="bi bi-star-fill"></i>
                                    </span> 
                                </div>
                            </div>
                            <ul>
                                <li>7 Days Service Center Replacement/Repair</li>
                                <li class="mt-2">GST invoice available</li>
                            </ul>
                            <p class="text-primary fw-bold mx-3">See other sellers</p>
                        </div>
                    </div>
                    <div class="row description-details">
                        <div class="row">
                            <div class="col-auto">
                                <p class="text-secondary fs-5">Description</p>
                            </div>
                            <div class="col-10 mt-1 desc-para">
                                <p>Let yourself experience and immerse in the world of mesmerising smartphone experience with Xiaomi 11i 5G which comes loaded with mind-blowing features. This phone features a monstrous 5160 mAh battery with 67 W Turbo Charging capability that powers up the device up to 50% in about 13 minutes. Additionally, powered by the Mediatek Dimensity 920 5G processor, this phone offers a great deal of smoothness, performance, and efficiency in operation. Furthermore, the triple camera setup which comprises a 108 MP Camera, an 8 MP Ultra Wide Sensor, and a 2 MP Macro Camera allows you to capture stunning images which seize the memorable moments. Moreover, the 16.94 cm (6.67) AMOLED FHD+ (2400x1080) Punch Hole display with a 1.76 mm narrow bezel of this phone and versatile refresh rates of 120 Hz and 360 Hz enables you to stay on top of your gaming stint, allowing you to redefine smoothness.</p>
                            </div>
                        </div>
                    </div>
                    <div class="product-detail-desc mx-2 mt-4">
                        <div class="row custom-box-border d-flex align-items-center p-2">
                           <div >
                            <h3 >Product Description</h3>
                           </div>
                        </div>
                        <div class="row custom-box-border p-2 align-items-center">
                            <div class="col-9">
                                <p class="mb-2 fs-4 feature-title-desc">Monstrous 5160 mAh Battery</p>
                                <p>The Xiaomi 11i 5G smartphone charges up to 50% in about 13 minutes, courtesy of a 5160 mAh gigantic battery that boasts a 67 W Turbo Charging capability. This way, you can simply relax and enjoy a stress-free user experience without clinging to the charging cord.</p>
                            </div>
                            <div class="col">
                                <img src="${pageContext.request.contextPath}/images/Mobiles/specification/desc-battery-mi.webp" class="img-fluid" alt="">
                            </div>
                        </div>
                        <div class="row custom-box-border p-2 align-items-center">
                            <div class="col">
                                <img src="${pageContext.request.contextPath}/images/Mobiles/specification/desc-speed-mi.webp" class="img-fluid" alt="">
                            </div>
                            <div class="col-9">
                                <p class="mb-2 fs-4 feature-title-desc">Futuristic Design</p>
                                <p>With 8-band 5G compatibility, the futuristic architecture of this smartphone empowers you with unmatched connectivity, enabling you to stay connected with the world and allowing you to enjoy almost everything that the world has to offer.</p>
                            </div>
                            
                        </div>
                        <div class="row custom-box-border p-2 align-items-center">
                            <div class="col-9">
                                <p class="mb-2 fs-4 feature-title-desc">Immaculate Mediatek Dimensity 920 5G Processor</p>
                                <p>You can experience the fine top-notch cameras, a flawless display, immaculate communication, and immense battery life owing to the innovative Dimensity 920 5G processor, which boasts a clock speed of up to 2.5 GHz and is designed on a power-efficient 6 nm process architecture.</p>
                            </div>
                            <div class="col">
                                <img src="${pageContext.request.contextPath}/images/Mobiles/specification/desc-processor-mi.webp" class="img-fluid" alt="">
                            </div>
                        </div>
                        <div class="row custom-box-border p-2 align-items-center">
                            <div class="col">
                                <img src="${pageContext.request.contextPath}/images/Mobiles/specification/desc-camera-mi.webp" class="img-fluid" alt="">
                            </div>
                            <div class="col-9">
                                <p class="mb-2 fs-4 feature-title-desc">
                                    Terrific Triple Camera Setup</p>
                                <p>With the 108 MP Triple superior camera setup that comprises a 108 MP Camera, an 8 MP Ultra Wide Sensor, and a 2 MP Macro Camera, you can snap, seize, and fascinate the whole world with a gentle click. Moreover, the camera setup of this phone features a multitude of sophisticated photography settings that allow you to generate stunning images with impeccable imagery.</p>
                            </div>
                            
                        </div>
                        <div class="row custom-box-border p-2 align-items-center">
                            <div class="col-9">
                                <p class="mb-2 fs-4 feature-title-desc">Heightened Audio Experience</p>
                                <p>This device produces coherent and comprehensive sound waves with little or no interruption when combined with Dual Symmetrical Stereo Speakers. Furthermore, Dolby Atmos sported by the audio setup of this phone does an excellent job of harmonising your audio experience and delivering an authentic 360-degree surround sound sensation, allowing you to engross yourself in your entertainment.</p>
                            </div>
                            <div class="col">
                                <img src="${pageContext.request.contextPath}/images/Mobiles/specification/desc-audio-mi.webp" class="img-fluid" alt="">
                            </div>
                        </div>
                        <div class="row custom-box-border p-2 align-items-center">
                            <div class="col">
                                <img src="${pageContext.request.contextPath}/images/Mobiles/specification/desc-entertainment-mi.webp" class="img-fluid" alt="">
                            </div>
                            <div class="col-9">
                                <p class="mb-2 fs-4 feature-title-desc">Uninterrupted Entertainment</p>
                                <p>An extremely tiny 2.96 mm Punch Hole Display and 1.76 mm Super Slim Bezel add to the fine display quality, allowing the entertainment to glide over your screen and providing an immersive experience.

                                </p>
                            </div>
                            
                        </div>
                        <div class="row custom-box-border-last p-2 align-items-center">
                            <div class="col-9">
                                <p class="mb-2 fs-4 feature-title-desc">Intuitive Display</p>
                                <p>Enjoy a top-of-the-line 16.94 cm (6.67) AMOLED FHD+ (2400x1080) touchscreen that enhances the fluency and richness of your viewing experience. Furthermore, navigation and app switching is streamlined efficiently with the 120Hz smooth refresh rate. Additionally, the 360 Hz touch sampling rate results in a display that is incredibly responsive, allowing for a truly seamless and dynamic gaming stint.</p>
                            </div>
                            <div class="col">
                                <img src="${pageContext.request.contextPath}/images/Mobiles/specification/desc-display-mi.webp" class="img-fluid" alt="">
                            </div>
                        </div>
                        
                    </div>
                    <div class="product-specs-detail mt-5 mx-2">
                        <div class="row custom-box-border p-3">
                            <h3>Specifications</h3>
                        </div>
                        <div class="row  custom-box-border">
                            <div class="row mt-4 mb-3 mx-0">
                                <p class="fs-4 mb-0">General</p>
                            </div>
                            <div class="row  px-4">
                                <div class="col-12">
                                    <div class="row mt-0">
                                        <div class="col-3">
                                            <p class="text-secondary">In the box</p>
                                        </div>
                                        <div class="col-9">
                                            <p>Handset, 67 W Power Adapter, USB Cable, SIM Eject Tool, Warranty Card, User Guide, Clear Soft Case, Screen Protector Pre-Applied on the Phone</p>
                                        </div>
                                    </div>
    
                                    <div class="row mt-0">
                                        <div class="col-3">
                                            <p class="text-secondary">Model Number</p>
                                        </div>
                                        <div class="col-9">
                                            <p>MZB0BSJIN|MZB0AJ3IN</p>
                                        </div>
                                    </div>
    
                                    <div class="row mt-0">
                                        <div class="col-3">
                                            <p class="text-secondary">Model Name</p>
                                        </div>
                                        <div class="col-9">
                                            <p>11i5G</p>
                                        </div>
                                    </div>
    
                                    <div class="row mt-0">
                                        <div class="col-3">
                                            <p class="text-secondary">Color</p>
                                        </div>
                                        <div class="col-9">
                                            <p>Purple Mist</p>
                                        </div>
                                    </div>
    
                                    <div class="row mt-0">
                                        <div class="col-3">
                                            <p class="text-secondary">Browse Type</p>
                                        </div>
                                        <div class="col-9">
                                            <p>Smartphones</p>
                                        </div>
                                    </div>
    
                                    <div class="row mt-0">
                                        <div class="col-3">
                                            <p class="text-secondary">SIM Type</p>
                                        </div>
                                        <div class="col-9">
                                            <p>Dual Sim</p>
                                        </div>
                                    </div>
    
                                    <div class="row mt-0">
                                        <div class="col-3">
                                            <p class="text-secondary">Hybrid Sim Slot</p>
                                        </div>
                                        <div class="col-9">
                                            <p>Yes</p>
                                        </div>
                                    </div>
    
                                    <div class="row mt-0">
                                        <div class="col-3">
                                            <p class="text-secondary">Touch Screen</p>
                                        </div>
                                        <div class="col-9">
                                            <p>Yes</p>
                                        </div>
                                    </div>
    
                                    <div class="row mt-0">
                                        <div class="col-3">
                                            <p class="text-secondary">OTG Compatible</p>
                                        </div>
                                        <div class="col-9">
                                            <p>Yes</p>
                                        </div>
                                    </div>
    
                                    <div class="row mt-0">
                                        <div class="col-3">
                                            <p class="text-secondary">Quick Charging</p>
                                        </div>
                                        <div class="col-9">
                                            <p>Yes</p>
                                        </div>
                                    </div>
    
                                    <div class="row mt-0">
                                        <div class="col-3">
                                            <p class="text-secondary">Sound Enhancements</p>
                                        </div>
                                        <div class="col-9">
                                            <p>Dual Symmetrical Stereo Speakers (Dolby Atmos, Hi-Res Audio Certification, Hi-Res Wireless Certification)</p>
                                        </div>
                                    </div>
    
                                    <div class="row mt-0">
                                        <div class="col-3">
                                            <p class="text-secondary">SAR Value</p>
                                        </div>
                                        <div class="col-9">
                                            <p>Head: 0.824W/Kg, Body: 0.608W/Kg</p>
                                        </div>
                                    </div>
                                   
    
                                </div>
                            </div>
                        </div>
                        <div class="row  custom-box-border">
                            <div class="row mt-4 mb-3 mx-0">
                                <p class="fs-4 mb-0">Display Features</p>
                            </div>
                            <div class="row  px-4">
                                <div class="col-12">
                                    <div class="row mt-0">
                                        <div class="col-3">
                                            <p class="text-secondary">Display Size</p>
                                        </div>
                                        <div class="col-9">
                                            <p>16.94 cm (6.67 inch)</p>
                                        </div>
                                    </div>
    
                                    <div class="row mt-0">
                                        <div class="col-3">
                                            <p class="text-secondary">Resolution</p>
                                        </div>
                                        <div class="col-9">
                                            <p>
                                                2400 x 1080</p>
                                        </div>
                                    </div>
    
                                    <div class="row mt-0">
                                        <div class="col-3">
                                            <p class="text-secondary">Resolution Type</p>
                                        </div>
                                        <div class="col-9">
                                            <p>Full HD+ AMOLED Display</p>
                                        </div>
                                    </div>
    
                                    <div class="row mt-0">
                                        <div class="col-3">
                                            <p class="text-secondary">GPU</p>
                                        </div>
                                        <div class="col-9">
                                            <p>ARM Mali-G68 MC4</p>
                                        </div>
                                    </div>
    
                                    <div class="row mt-0">
                                        <div class="col-3">
                                            <p class="text-secondary">Display Type</p>
                                        </div>
                                        <div class="col-9">
                                            <p>Full HD+ AMOLED Dot Display
                                            </p>
                                        </div>
                                    </div>
    
                                    <div class="row mt-0">
                                        <div class="col-3">
                                            <p class="text-secondary">HD Game Support</p>
                                        </div>
                                        <div class="col-9">
                                            <p>Yes</p>
                                        </div>
                                    </div>
    
                                    <div class="row mt-0">
                                        <div class="col-3">
                                            <p class="text-secondary">Display Colors</p>
                                        </div>
                                        <div class="col-9">
                                            <p>16M</p>
                                        </div>
                                    </div>                              
                                </div>
                            </div>
                        </div>
                        <div class="row custom-box-border">
                            <div class="row mt-4 mb-3 mx-0">
                                <p class="fs-4 mb-0">Os & Processor Features</p>
                            </div>
                            <div class="row  px-4">
                                <div class="col-12">
                                    <div class="row mt-0">
                                        <div class="col-3">
                                            <p class="text-secondary">
                                                Operating System</p>
                                        </div>
                                        <div class="col-9">
                                            <p>Android 11</p>
                                        </div>
                                    </div>
    
                                    <div class="row mt-0">
                                        <div class="col-3">
                                            <p class="text-secondary">Processor Brand</p>
                                        </div>
                                        <div class="col-9">
                                            <p>Mediatek</p>
                                        </div>
                                    </div>
    
                                    <div class="row mt-0">
                                        <div class="col-3">
                                            <p class="text-secondary">Processor Type</p>
                                        </div>
                                        <div class="col-9">
                                            <p>Mediatek Dimensity 920</p>
                                        </div>
                                    </div>
    
                                    <div class="row mt-0">
                                        <div class="col-3">
                                            <p class="text-secondary">Processor Core</p>
                                        </div>
                                        <div class="col-9">
                                            <p>Octa Core</p>
                                        </div>
                                    </div>
    
                                    <div class="row mt-0">
                                        <div class="col-3">
                                            <p class="text-secondary">Primary Clock Speed</p>
                                        </div>
                                        <div class="col-9">
                                            <p>2.5 GHz
                                            </p>
                                        </div>
                                    </div>
    
                                    <div class="row mt-0">
                                        <div class="col-3">
                                            <p class="text-secondary">Secondary Clock Speed</p>
                                        </div>
                                        <div class="col-9">
                                            <p>2 GHz</p>
                                        </div>
                                    </div>
    
                                    <div class="row mt-0">
                                        <div class="col-3">
                                            <p class="text-secondary">Operating Frequency</p>
                                        </div>
                                        <div class="col-9">
                                            <p>5G NR: N1, N3, N5, N8, N28, N40, N77, N78, 4G FDD: B1, B3, B5, B8, 4G TDD: B40, B41, 3G WCDMA: B1, B2, B5, B8, 2G GSM: B2, B3, B5, B8</p>
                                        </div>
                                    </div>                              
                                </div>
                            </div> 
                        </div>

                        <div class="row custom-box-border">
                            <div class="row mt-4 mb-3 mx-0">
                                <p class="fs-4 mb-0">Memory & Storage Features</p>
                            </div>
                            <div class="row  px-4">
                                <div class="col-12">
                                    <div class="row mt-0">
                                        <div class="col-3">
                                            <p class="text-secondary">
                                                Internal Storage</p>
                                        </div>
                                        <div class="col-9">
                                            <p>128 GB</p>
                                        </div>
                                    </div>
    
                                    <div class="row mt-0">
                                        <div class="col-3">
                                            <p class="text-secondary">RAM</p>
                                        </div>
                                        <div class="col-9">
                                            <p>8 GB</p>
                                        </div>
                                    </div>
    
                                    <div class="row mt-0">
                                        <div class="col-3">
                                            <p class="text-secondary">Expandable Storage</p>
                                        </div>
                                        <div class="col-9">
                                            <p>1 TB</p>
                                        </div>
                                    </div>
    
                                    <div class="row mt-0">
                                        <div class="col-3">
                                            <p class="text-secondary">Supported Memory Card Type</p>
                                        </div>
                                        <div class="col-9">
                                            <p>microSD</p>
                                        </div>
                                    </div>
    
                                    <div class="row mt-0">
                                        <div class="col-3">
                                            <p class="text-secondary">Memory Card Slot Type</p>
                                        </div>
                                        <div class="col-9">
                                            <p>Hybrid Slot</p>
                                        </div>
                                    </div>
    
                                    <div class="row mt-0">
                                        <div class="col-3">
                                            <p class="text-secondary">Call Log Memory</p>
                                        </div>
                                        <div class="col-9">
                                            <p>Yes</p>
                                        </div>
                                    </div>                              
                                </div>
                            </div> 
                        </div>

                        <div class="row custom-box-border">
                            <div class="row mt-4 mb-3 mx-0">
                                <p class="fs-4 mb-0">Call Features</p>
                            </div>
                            <div class="row  px-4">
                                <div class="col-12">
                                    <div class="row mt-0">
                                        <div class="col-3">
                                            <p class="text-secondary">Call Wait/Hold</p>
                                        </div>
                                        <div class="col-9">
                                            <p>Yes</p>
                                        </div>
                                    </div>
    
                                    <div class="row mt-0">
                                        <div class="col-3">
                                            <p class="text-secondary">Hands Free</p>
                                        </div>
                                        <div class="col-9">
                                            <p>Yes</p>
                                        </div>
                                    </div>
    
                                    <div class="row mt-0">
                                        <div class="col-3">
                                            <p class="text-secondary">Video Call Support</p>
                                        </div>
                                        <div class="col-9">
                                            <p>Yes</p>
                                        </div>
                                    </div>
    
                                    <div class="row mt-0">
                                        <div class="col-3">
                                            <p class="text-secondary">Call Divert</p>
                                        </div>
                                        <div class="col-9">
                                            <p>Yes</p>
                                        </div>
                                    </div>
    
                                    <div class="row mt-0">
                                        <div class="col-3">
                                            <p class="text-secondary">Phone Book</p>
                                        </div>
                                        <div class="col-9">
                                            <p>Yes</p>
                                        </div>
                                    </div>
    
                                    <div class="row mt-0">
                                        <div class="col-3">
                                            <p class="text-secondary">Call Timer</p>
                                        </div>
                                        <div class="col-9">
                                            <p>Yes</p>
                                        </div>
                                    </div>  
                                    
                                    <div class="row mt-0">
                                        <div class="col-3">
                                            <p class="text-secondary">Speaker Phone</p>
                                        </div>
                                        <div class="col-9">
                                            <p>Yes</p>
                                        </div>
                                    </div> 

                                    <div class="row mt-0">
                                        <div class="col-3">
                                            <p class="text-secondary">Call Records</p>
                                        </div>
                                        <div class="col-9">
                                            <p>Yes</p>
                                        </div>
                                    </div> 
                                </div>
                            </div> 
                        </div>
                        <div class="row custom-box-border-last">
                            <div class="row mt-4 mb-3 mx-0">
                                <p class="fs-4 mb-0">Warranty</p>
                            </div>
                            <div class="row  px-4">
                                <div class="col-12">
                                    <div class="row mt-0">
                                        <div class="col-3">
                                            <p class="text-secondary">Warranty Summary</p>
                                        </div>
                                        <div class="col-9">
                                            <p>1 Year Manufacturer Warranty for Phone and 6 Months Warranty for in the Box Accessories</p>
                                        </div>
                                    </div>
    
                                    <div class="row mt-0">
                                        <div class="col-3">
                                            <p class="text-secondary">Warranty Service Type</p>
                                        </div>
                                        <div class="col-9">
                                            <p>NA</p>
                                        </div>
                                    </div>
    
                                    <div class="row mt-0">
                                        <div class="col-3">
                                            <p class="text-secondary">Domestic Warranty</p>
                                        </div>
                                        <div class="col-9">
                                            <p>1 Year</p>
                                        </div>
                                    </div>
    
                                    
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="mt-5 product-reviews mx-2">
                       <div class="row">
                        <div class="col-12">
                            <div class="row p-3 custom-box-border align-items-center justify-content-between">
                                <div class="col-auto">
                                    <h2>Ratings & Reviews</h2>
                                </div>
                                <div class="col-auto">
                                    <button class="bg-white text-dark rate-btn shadow">Rate Product</button>
                                </div>
                            </div>
                            <div class="row p-3 custom-box-border">
                                <div class="col-2 align-self-center text-center">
                                    <h2>4.2&#9733;</h2>
                                    <p class="text-secondary">2,350 Ratings & 200 Reviews</p>
                                </div>
                                <div class="col-4">
                                    <div class="row rating-box justify-content-center align-items-center">
                                        <div class="col-auto px-0">
                                            <h6 class="px-0">5&#9733;</h6>
                                        </div>
                                        <div class="col-7 px-0 mx-0 px-3 pb-2 align-self-center">
                                            <div class="progress p-bar">
                                                <div class="progress-bar bg-success " role="progressbar" style="width: 100%;" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100"></div>
                                            </div>
                                        </div>
                                        <div class="col-3 mt-1 mx-0 px-0">
                                            <p class="text-secondary  ratings-count">1,350</p>
                                        </div>
                                    </div>

                                    <div class="row rating-box justify-content-center align-items-center">
                                        <div class="col-auto px-0">
                                            <h6 class="px-0">4&#9733;</h6>
                                        </div>
                                        <div class="col-7 px-0 mx-0 px-3 pb-2 align-self-center">
                                            <div class="progress p-bar">
                                                <div class="progress-bar bg-success " role="progressbar" style="width: 20%;" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100"></div>
                                            </div>
                                        </div>
                                        <div class="col-3 mt-1 mx-0 px-0">
                                            <p class="text-secondary  ratings-count">600</p>
                                        </div>
                                    </div>

                                    <div class="row rating-box justify-content-center align-items-center">
                                        <div class="col-auto px-0">
                                            <h6 class="px-0">3&#9733;</h6>
                                        </div>
                                        <div class="col-7 px-0 mx-0 px-3 pb-2 align-self-center">
                                            <div class="progress p-bar">
                                                <div class="progress-bar bg-success " role="progressbar" style="width: 10%;" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100"></div>
                                            </div>
                                        </div>
                                        <div class="col-3 mt-1 mx-0 px-0">
                                            <p class="text-secondary  ratings-count">110</p>
                                        </div>
                                    </div>

                                    <div class="row rating-box justify-content-center align-items-center">
                                        <div class="col-auto px-0">
                                            <h6 class="px-0">2&#9733;</h6>
                                        </div>
                                        <div class="col-7 px-0 mx-0 px-3 pb-2 align-self-center">
                                            <div class="progress p-bar">
                                                <div class="progress-bar bg-warning " role="progressbar" style="width: 20%;" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100"></div>
                                            </div>
                                        </div>
                                        <div class="col-3 mt-1 mx-0 px-0">
                                            <p class="text-secondary  ratings-count">135</p>
                                        </div>
                                    </div>

                                    <div class="row rating-box justify-content-center align-items-center">
                                        <div class="col-auto px-0">
                                            <h6 class="px-0">1&#9733;</h6>
                                        </div>
                                        <div class="col-7 px-0 mx-0 px-3 pb-2 align-self-center">
                                            <div class="progress p-bar">
                                                <div class="progress-bar bg-danger " role="progressbar" style="width: 30%;" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100"></div>
                                            </div>
                                        </div>
                                        <div class="col-3 mt-1 mx-0 px-0">
                                            <p class="text-secondary  ratings-count">250</p>
                                        </div>
                                    </div>                                    
                                </div>
                                <div class="col-auto col-sm-6">
                                    <div class="row justify-content-between  text-center fw-bold">
                                        
                                            <div class="col ">
                                                <div class="progress-circle" data-progress="3.6">
                                                    <div class="progress-value">3.6</div>
                                                </div>
                                                <p>Camera</p>
                                            </div>
                                            <div class="col">
                                                <div class="progress-circle" data-progress="4.1">
                                                    <div class="progress-value">4.1</div>
                                                </div>
                                                <p>Battery</p>
                                            </div>
                                            <div class="col">
                                                <div class="progress-circle" data-progress="4.2">
                                                    <div class="progress-value">4.2</div>
                                                </div>
                                                <p>Display</p>
                                            </div>
                                            <div class="col">
                                                <div class="progress-circle" data-progress="3.8">
                                                    <div class="progress-value">3.8</div>
                                                </div>
                                                <p>Design</p>
                                            </div>
                                        
                                    </div>
                                </div>
                                <div class="row mt-3">
                                    <div class="col-2 p-2">
                                        <img src="${pageContext.request.contextPath}/images/Mobiles/customer-review/redmi-review.png" class="img-fluid" alt="">
                                    </div>
                                    <div class="col-2 p-2">
                                        <img src="${pageContext.request.contextPath}/images/Mobiles/customer-review/redmi-review.png" class="img-fluid" alt="">
                                    </div>
                                    <div class="col-2 p-2">
                                        <img src="${pageContext.request.contextPath}/images/Mobiles/customer-review/redmi-review.png" class="img-fluid" alt="">
                                    </div>
                                    <div class="col-2 p-2">
                                        <img src="${pageContext.request.contextPath}/images/Mobiles/customer-review/redmi-review.png" class="img-fluid" alt="">
                                    </div>
                                    <div class="col-2 p-2">
                                        <img src="${pageContext.request.contextPath}/images/Mobiles/customer-review/redmi-review.png" class="img-fluid" alt="">
                                    </div>
                                    <div class="col-2 p-2">
                                        <img src="${pageContext.request.contextPath}/images/Mobiles/customer-review/redmi-review.png" class="img-fluid" alt="">
                                    </div>
                                </div>
                            </div>
                            <div class="row custom-box-border p-3 pt-4">
                                <div class="row d-flex">
                                    <div class="col-auto mx-0">
                                        <span class="bg-success text-white p-1  rounded">
                                            4.4 <i class="bi bi-star-fill"></i>
                                        </span>
                                    </div>
                                    <div class="col-auto mx-0 px-0 text-start">
                                        <p class="fw-bold px-0 mx-0">Nice product</p>
                                    </div>
                                </div>
                                <div class="row">
                                    <p>Nice mobile good experience with my new mobile</p>
                                </div>
                                <div class="row">
                                    <div class="col-2 px-4 d-flex">
                                        <img src="${pageContext.request.contextPath}/images/Mobiles/customer-review/redmi-review.png" class="img-fluid px-2" alt="">
                                        <img src="${pageContext.request.contextPath}/images/Mobiles/customer-review/redmi-review.png" class="img-fluid px-2" alt="">
                                        <img src="${pageContext.request.contextPath}/images/Mobiles/customer-review/redmi-review.png" class="img-fluid px-2" alt="">
                                    </div>
                                </div>
                            </div>
                            <div class="row custom-box-border p-3 pt-4">
                                <div class="row d-flex">
                                    <div class="col-auto mx-0">
                                        <span class="bg-success text-white p-1  rounded">
                                            4 <i class="bi bi-star-fill"></i>
                                        </span>
                                    </div>
                                    <div class="col-auto mx-0 px-0 text-start">
                                        <p class="fw-bold px-0 mx-0">Nice product</p>
                                    </div>
                                </div>
                                <div class="row">
                                    <p>Battery: Lasts all day, even with using Social Media and music. 67W charger is more than enough for daily use. I bought this phone mainly because it offered more battery capacity than the hypercharge version.I plug it in the morning after waking up and by the time in done with breakfast (approx 40mins), phone is full. <br> <br>

                                        Speakers: Dual stereo speakers, one on top and one on bottom. Symmetric sound. Impossibly loud and crisp. You can hear the phone from the other room also clearly at Max volume. <br> <br>
                                        
                                        Display: 120Hz refresh rate is available, though not necessary. You can add approx 2hrs of battery if you keep it at 60Hz. Very detailed display. Easily viewable even under strong direct sunlight. No issues. Phone is 6.67 inches diagonally, but with 20:9 ratio, it is comfortable to hold in one hand. Though, during regular use, i found it difficult to reach the top and bottom of the phone with one hand use. Netflix can be streamed at HD+ quality. <br> <br>
                                        
                                        Performance: I'm not a mobile gamer, so I can't speak for that, but all other apps will work smoothly, transition between apps is butter, even with most of the apps on my phone open( i have plenty) phone did not show any signs of slowing down. In fact, most of the time I have more than 2gb RAM left. For the 8gb version only, there's an optional 3gb virtual RAM setting, which I haven't had to use till now. I didn't find any heating issues. <br> <br>
                                        
                                        Camera: The only area that i found lacking. Despite the colossal 108MP camera, the images don't have as much clarity as you would expect. The inbuilt camera software tends to OVERSHARPEN images too much, which is okay for scenery photos, but selfies look little weird, every hair on your face will be more visible than necessary, etc. I hope Xiaomi will release an update for the software that'll better utilise the camera.</p>
                                </div>
                                <!-- <div class="row">
                                    <div class="col-2 px-4 d-flex">
                                        <img src="${pageContext.request.contextPath}/images/Mobiles/customer-review/redmi-review.png" class="img-fluid px-2" alt="">
                                        <img src="${pageContext.request.contextPath}/images/Mobiles/customer-review/redmi-review.png" class="img-fluid px-2" alt="">
                                        <img src="${pageContext.request.contextPath}/images/Mobiles/customer-review/redmi-review.png" class="img-fluid px-2" alt="">
                                    </div>
                                </div> -->
                            </div>
                            <div class="row custom-box-border-last p-3 pt-4">
                                <div class="row d-flex">
                                    <div class="col-auto mx-0">
                                        <span class="bg-success text-white p-1  rounded">
                                            4.4 <i class="bi bi-star-fill"></i>
                                        </span>
                                    </div>
                                    <div class="col-auto mx-0 px-0 text-start">
                                        <p class="fw-bold px-0 mx-0">Beast in Hand !!!!</p>
                                    </div>
                                </div>
                                <div class="row">
                                    <p>All Good !! 1st day of purchase ... will review more after some days of use</p>
                                </div>
                                <div class="row">
                                    <div class="col-2 px-4 d-flex">
                                        <img src="${pageContext.request.contextPath}/images/Mobiles/customer-review/redmi-review.png" class="img-fluid px-2" alt="">
                                        <!-- <img src="${pageContext.request.contextPath}/images/Mobiles/customer-review/redmi-review.png" class="img-fluid px-2" alt="">
                                        <img src="${pageContext.request.contextPath}/images/Mobiles/customer-review/redmi-review.png" class="img-fluid px-2" alt=""> -->
                                    </div>
                                </div>
                            </div>
                            
                        </div>
                       </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
    <div class="container-flex bg-white mt-3 mx-5 p-2 px-3 overflow-hidden">
        <div class="row d-flex justify-content-between mt-2 mb-3 fixed">
            <div class="col">
                <h5 class="">Similar Products</h5>
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

    <script>
    /*
 // Get the elements
    const imgBlock = document.querySelector('.img-block');
    const productOuters = document.querySelector('.product-outers');

    // Calculate the position where productOuters should become fixed
    const imgBlockBottom = imgBlock.offsetTop + imgBlock.offsetHeight;
    const productOutersHeight = productOuters.offsetHeight;

    // Add scroll event listener
    window.addEventListener('scroll', function() {
        // Calculate the current scroll position
        const scrollPosition = window.scrollY || window.pageYOffset;

        // Determine if productOuters should be fixed or relative
        if (scrollPosition >= imgBlockBottom-productOutersHeight-100) {
        	console.log("hitting");
            productOuters.style.position = 'absolute';
            productOuters.style.top = '0';
        } else {
            productOuters.style.position = 'fixed';
            productOuters.style.top = 'auto'; // Reset top position if needed
        }
    });*/
    
 // Get the elements
    const imgBlock = document.querySelector('.img-block');
    const productOuters = document.querySelector('.product-outers');
    const downBtns = document.querySelector('.down-btns');

    // Add scroll event listener
    window.addEventListener('scroll', function() {
        // Calculate the heights and positions
        const imgBlockTop = imgBlock.offsetTop;
        const imgBlockBottom = imgBlockTop + imgBlock.offsetHeight;
        const downBtnsHeight = downBtns.offsetHeight;
        const productOutersHeight = productOuters.offsetHeight;
        
        // Calculate the current scroll position
        const scrollPosition = window.scrollY || window.pageYOffset;

        // Determine if productOuters should be fixed or relative
        if (scrollPosition + downBtnsHeight >= (imgBlockBottom-productOutersHeight)) {
        	console.log((imgBlockBottom-productOutersHeight));
            productOuters.style.position = 'relative';
           
            productOuters.style.bottom = '0';
        } else if (scrollPosition >= imgBlockTop) {
            productOuters.style.position = 'fixed';
            
            productOuters.style.bottom = 'auto';
        } else {
            productOuters.style.position = 'adsolute';
            
            productOuters.style.bottom = 'auto';
        }
    });


        document.addEventListener("DOMContentLoaded", function() {
    const circles = document.querySelectorAll('.progress-circle');
    circles.forEach(circle => {
        const progress = circle.getAttribute('data-progress');
        circle.style.setProperty('--progress', (progress / 5) * 100);
    });
});
    
        document.querySelectorAll('.small-image').forEach(clicked => {
            clicked.addEventListener('mouseenter', function (event) {
                var source = this.querySelector('img').getAttribute('src');
                var big = document.getElementById('showBig');
                big.setAttribute('src', source);
            });
        });
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