<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hall List</title>
    <link rel="icon" type="image/x-icon" href="../assert/image/LogoFavIcon.jpg">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/assert/css/CustomerHeaderFooter.css"/>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-multiselect/0.9.15/css/bootstrap-multiselect.css"
    rel="stylesheet">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <style>
        .card-container {
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .card {
            width: 300px;
            border-radius: 20px;
            overflow: hidden;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            transition: transform 0.3s ease, box-shadow 0.3s ease;
            background-color: #fff;
            margin-bottom: 20px;
        }

        .card:hover {
            transform: translateY(-10px);
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
        }

        .card img {
            width: 100%;
            border-radius: 20px 20px 0 0;
        }

        .card-content {
            padding: 20px;
        }

        .namestar {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .rating {
            display: flex;
            align-items: center;
        }

        .rating img {
            width: 20px;
            margin-right: 5px;
        }

        .location {
            display: flex;
            align-items: center;
        }
        .location p{
            align-items: center;
            margin-top: 20px;
        }

        .location img {
            width: 20px;
            margin-right: 10px;
            align-items: center;
        }

        .price, .capacity {
            font-size: 16px;
            font-weight: bold;
        }

        .amenties {
            display: flex;
            gap: 10px;
            flex-wrap: wrap;
        }

        .amenties p {
            background-color: #f0f0f0;
            border-radius: 10px;
            font-size: 14px;
            margin: 0;
        }
      .filter-bar {
        position: fixed;
          margin-top: 20px;
          top: 56px;
          left: 0;
          width: 100%;
          height: 100%;
          max-width: 270px;
          height: calc(100vh - 100px);
          background-color: #ffeed3;
          padding: 15px;
          overflow-y: auto;
      }
      #customNavbar h3 {
          margin-left: 7px;
      }

      .filter-by-events, .filter-by-amenities, .filter-by-events, .filter-by-location, .filter-by-Price {
          border: #2b15359a solid 1px;
          padding: 10px;
          margin-bottom: 15px;
      }

      .clear-button {
          margin-top: 10px;
      }

      @media (max-width: 767px) {
          .filter-bar {
              position: relative;
              top: auto;
              width: 100%;
              height: auto;
              margin-bottom: 15px;
          }

          #main-container {
              flex-direction: column;
              margin-left: 0;
          }

          .dropdown {
              margin-top: 15px;
          }
      }
  </style>
</head>
<body>

    <header>
        <nav class="navbar navbar-expand-lg navbar-light bg-light" id="customNavbar">
            <a class="navbar-brand" href="#"><img src="${pageContext.request.contextPath}/assert/image/Logo.1.1.png" id="company-logo" alt="Company Logo"></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent" style="margin-left:40% ">
              <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                  <a class="nav-link" href= '<%= request.getContextPath() %>/index.jsp'>Home</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href='<%= request.getContextPath() %>/view/blogs.jsp'>Blogs</a>
                </li>
                <li class="nav-item dropdown">
                  <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Hall Events
                  </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown" id="Events-DropDown">
                    <a class="dropdown-item" href='<%= request.getContextPath() %>/HallsServlet'>Wedding</a>
                    <a class="dropdown-item" href='<%= request.getContextPath() %>/view/hall.jsp'>Corporate Party</a>
                    <a class="dropdown-item" href='<%= request.getContextPath() %>/view/hall.jsp'>Conference</a>
                    <a class="dropdown-item" href='<%= request.getContextPath() %>/view/hall.jsp'>Concert</a>
                    <a class="dropdown-item" href='<%= request.getContextPath() %>/view/hall.jsp'>Exhibition</a>
                    <a class="dropdown-item" href='<%= request.getContextPath() %>/view/hall.jsp'>Product Launch</a>
                    <a class="dropdown-item" href='<%= request.getContextPath() %>/view/hall.jsp'>Training Session</a>
                  </div>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href='<%= request.getContextPath() %>/view/facilities.jsp'>Facilities</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href='<%= request.getContextPath() %>/view/contact.jsp'>Contact</a>
                </li>
                <% if(session.getAttribute("customer")==null){%>
                <li class="nav-item">
                  <a class="nav-link" href='<%= request.getContextPath() %>/view/login.jsp' id="login">Login</a>
                </li>
                <%}
                else{ %>
                <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="userMenu" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor" class="bi bi-person" viewBox="0 0 16 16">
                                <path d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6m2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0m4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4m-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10s-3.516.68-4.168 1.332c-.678.678-.83 1.418-.832 1.664z"/>
                            </svg>
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="userMenu">
                            <li><a class="dropdown-item ms-0" href="#" id="logout">Logout</a></li>
                            <li><a class="dropdown-item ms-0" href="<%= request.getContextPath() %>/PaymentServlet">My Bookings</a></li>
                             <li><a class="dropdown-item ms-0" href="<%= request.getContextPath() %>/MyRequestsServlet">Booking Request</a></li>
                      	</ul>
                </li>
                <%} %>
              </ul>
            </div>
          </nav>
    </header>
    <!--Logout modal-->
		<div class="modal" id="logoutModal" tabindex="-1" aria-labelledby="logoutModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="logoutModalLabel">Confirm Logout</h5>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		        <p>Are you sure you want to logout?</p>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
		        <button type="button" class="btn btn-outline-danger" id="confirmLogoutButton">Logout</button>
		      </div>
		    </div>
		  </div>
		</div> 
    <div class="container-fluid">
      <div class="row">
        <div class="col-md-3 col-sm-12 filter-bar">
            <div class="filter-by"><h3>Filter By</h3></div>
            <ul class="nav flex-column">
                <li class="nav-item filter-by-events">
                    <div class="filter-by"><h4>Events</h4></div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" id="checkboxWedding">
                        <label class="form-check-label" for="checkboxWedding">Wedding</label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" id="checkboxCorporateParty">
                        <label class="form-check-label" for="checkboxCorporateParty">Corporate Party</label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" id="checkboxConference">
                        <label class="form-check-label" for="checkboxConference">Conference</label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" id="checkboxConcert1">
                        <label class="form-check-label" for="checkboxConcert1">Concert</label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" id="checkboxExhibition">
                        <label class="form-check-label" for="checkboxExhibition">Exhibition</label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" id="checkboxProductLaunch">
                        <label class="form-check-label" for="checkboxProductLaunch">Product Launch</label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" id="checkboxTrainingSession">
                        <label class="form-check-label" for="checkboxTrainingSession">Training Session</label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" id="checkboxConcert2">
                        <label class="form-check-label" for="checkboxConcert2">Concert</label>
                    </div>
                    <button class="btn btn-secondary btn-sm clear-button" onclick="clearCheckboxesByEvents()">Clear</button>
                </li>
                
                <script>
                    function clearCheckboxesByEvents() {
                        const checkboxes = document.querySelectorAll('.filter-by-events .form-check-input');
                        checkboxes.forEach(checkbox => {
                            checkbox.checked = false;
                        });
                    }
                </script>
                
                <li class="nav-item filter-by-amenities">
                    <div class="filter-by"><h4>Amenities</h4></div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" id="amenityParking">
                        <label class="form-check-label" for="amenityParking">Parking</label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" id="amenityWifi">
                        <label class="form-check-label" for="amenityWifi">Wi-Fi</label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" id="amenityCatering">
                        <label class="form-check-label" for="amenityCatering">Catering</label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" id="amenityAudioVisual">
                        <label class="form-check-label" for="amenityAudioVisual">Audio Visual Equipment</label>
                    </div>
                    <button class="btn btn-secondary btn-sm clear-button" onclick="clearCheckboxesByAmenities()">Clear</button>
                </li>
                <script>
                    function clearCheckboxesByAmenities() {
                        const checkboxes = document.querySelectorAll('.filter-by-amenities .form-check-input');
                        checkboxes.forEach(checkbox => {
                            checkbox.checked = false;
                        });
                    }
                </script>
                
                <li class="nav-item filter-by-location">
                    <h4>Location</h4>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" id="checkboxLocation1">
                        <label class="form-check-label" for="checkboxLocation1">Location 1</label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" id="checkboxLocation2">
                        <label class="form-check-label" for="checkboxLocation2">Location 2</label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" id="checkboxLocation3">
                        <label class="form-check-label" for="checkboxLocation3">Location 3</label>
                    </div>
                    <button class="btn btn-secondary btn-sm clear-button" onclick="clearCheckboxesByLocation()">Clear</button>
                </li> 
                <script>
                    function clearCheckboxesByLocation() {
                        const checkboxes = document.querySelectorAll('.filter-by-location .form-check-input');
                        checkboxes.forEach(checkbox => {
                            checkbox.checked = false;
                        });
                    }
                </script>
                <li class="nav-item filter-by-Price mb-6">
                    <h4>Price</h4>
                    <div class="form-group">
                        <label for="minPrice">Minimum Price:</label>
                        <input type="number" class="form-control" id="minPrice" placeholder="Enter minimum price">
                    </div>
                    <div class="form-group pb-2">
                        <label for="maxPrice">Maximum Price:</label>
                        <input type="number" class="form-control" id="maxPrice" placeholder="Enter maximum price">
                    </div>
                </li>
                <li style="justify-content: center; align-items: center;" ><button type="button" class="btn btn-light"> Apply </button></li>
              </ul>
        </div>
        <div class="col-md-9 col-sm-12 " id ="main-container" style="margin-left: 350px; margin-top: 7%; " >
            <div class="row">
                <div class="col-12 d-flex justify-content-between align-items-center">
                    <div class="halls-cards">
                        <h4>Best Wedding Venues</h4>
                    </div>
                    <div class="dropdown">
                        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                        Sort by
                        </button>
                        <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                        <li><a class="dropdown-item" href="#">Popularity</a></li>
                        <li><a class="dropdown-item" href="#">Price: Low to High</a></li>
                        <li><a class="dropdown-item" href="#">Price: High to Low</a></li>
                        </ul>
                    </div>
            </div>
            <div class="row mt-3">
                <div class="col-sm"> 
                    <div class="card-container">
                        <div class="card">
                            <img src="../assert/image/card-1.jpg" style="border-radius:20px;" >
                            <div class="card-content">
                                <div class="namestar d-flex mt-2">
                                    <h4>Green hall</h4>
                                        <div class="rating d-inline">
                                            <img src="../assert/image/star_148841.png" style="width:20px;">
                                            <p class="d-inline" style="margin-right: 20px;">4.5</p>
                                        </div>
                                </div>
                                <div class="location d-flex d-block">
                                    <img src="../assert/image/placeholder_186250.png">
                                    <p>Chennai</p>
                                </div>
                                        <div class="price ms-2">
                                            <p><strong>&#8377;5000</strong>Per Day</p>
                                        </div>
                                        <div class="capacity ms-2">
                                            <p><strong>700-800</strong>aprox</p>
                                        </div >
                                        <div class="amenties d-flex ms-2">
                                            <p>Ac</p><p>Parking</p><p>DJ Hall</p><p class="more">+2 more</p>
                                    </div>
                            </div>
                        </div >
                    </div>
                </div> 
                <div class="col-sm"> 
                    <div class="card-container">
                        <div class="card">
                            <img src="../assert/image/card-3.jpg" style="border-radius:20px;">
                            <div class="card-content">
                                <div class="namestar d-flex mt-2">
                                    <h4>Royal Ballroom</h4>
                                        <div class="rating d-inline">
                                            <img src="../assert/image/star_148841.png" style="width:20px;">
                                            <p class="d-inline" style="margin-right: 20px;">4.5</p>
                                        </div>
                                </div> <div class="location d-flex d-block">
                                    <img src="../assert/image/placeholder_186250.png">
                                    <p>Coimbatore</p>
                                </div>
                                        <div class="price ms-2">
                                            <p><strong>&#8377;5000</strong>Per Day</p>
                                        </div>
                                        <div class="capacity ms-2">
                                            <p><strong>700-800</strong>aprox</p>
                                        </div >
                                        <div class="amenties d-flex ms-2">
                                            <p>Ac</p><p>Parking</p><p>DJ Hall</p><p class="more">+2 more</p>
                                    </div>
                            </div>
                        </div >
                    </div>
                </div>
                <div class="col-sm"> 
                    <div class="card-container">
                        <div class="card">
                            <img src="../assert/image/card-2.jpg" style="border-radius:20px;">
                            <div class="card-content">
                                <div class="namestar d-flex mt-2">
                                    <h4>Crystal Palace</h4>
                                        <div class="rating d-inline">
                                            <img src="../assert/image/star_148841.png" style="width:20px;">
                                            <p class="d-inline" style="margin-right: 20px;">4.5</p>
                                        </div>
                                </div>
                                <div class="location d-flex d-block">
                                    <img src="../assert/image/placeholder_186250.png">
                                    <p>Chennai</p>
                                </div>
                                        <div class="price ms-2">
                                            <p><strong>&#8377;5000</strong>Per Day</p>
                                        </div>
                                        <div class="capacity ms-2">
                                            <p><strong>700-800</strong>aprox</p>
                                        </div >
                                        <div class="amenties d-flex ms-2">
                                            <p>Ac</p><p>Parking</p><p>DJ Hall</p><p class="more">+2 more</p>
                                    </div>
                            </div>
                        </div >
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm">
                    <div class="card-container">
                        <div class="card">
                            <img src="../assert/image/hallcard-1.jpg">
                            <div class="card-content">
                                <div class="namestar d-flex mt-2">
                                    <h4>Silver Springs</h4>
                                    <div class="rating d-inline">
                                        <img src="../assert/image/star_148841.png">
                                        <p class="d-inline" style="margin-right: 20px;">4.5</p>
                                    </div>
                                </div>
                                <div class="location d-flex d-block">
                                    <img src="../assert/image/placeholder_186250.png">
                                    <p>Coimbatore</p>
                                </div>
                                <div class="price ms-2">
                                    <p><strong>&#8377;5000</strong> Per Day</p>
                                </div>
                                <div class="capacity ms-2">
                                    <p><strong>700-800</strong> approx</p>
                                </div>
                                <div class="amenties d-flex ms-2">
                                    <p>Ac</p>
                                    <p>Parking</p>
                                    <p>DJ Hall</p>
                                    <p class="more">+2 more</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-sm"> 
                    <div class="card-container">
                        <div class="card">
                            <img src="../assert/image/hallcard-2.jpg" style="border-radius:20px;">
                            <div class="card-content">
                                <div class="namestar d-flex mt-2">
                                    <h4>Avigna Hall</h4>
                                        <div class="rating d-inline">
                                            <img src="../assert/image/star_148841.png" style="width:20px;">
                                            <p class="d-inline" style="margin-right: 20px;">4.5</p>
                                        </div>
                                </div>
                                <div class="location d-flex d-block">
                                    <img src="../assert/image/placeholder_186250.png">
                                    <p>Chennai</p>
                                </div>
                                        <div class="price ms-2">
                                            <p><strong>&#8377;5000</strong>Per Day</p>
                                        </div>
                                        <div class="capacity ms-2">
                                            <p><strong>700-800</strong>aprox</p>
                                        </div >
                                        <div class="amenties d-flex ms-2">
                                            <p>Ac</p><p>Parking</p><p>DJ Hall</p><p class="more">+2 more</p>
                                    </div>
                            </div>
                        </div >
                    </div>
                </div>
                <div class="col-sm"> 
                    <div class="card-container">
                        <div class="card">
                            <img src="../assert/image/hallcard-3 (1).jpg" style="border-radius:20px;">
                            <div class="card-content">
                                <div class="namestar d-flex mt-2">
                                    <h4>Emerald Gardens</h4>
                                        <div class="rating d-inline">
                                            <img src="../assert/image/star_148841.png" style="width:20px;">
                                            <p class="d-inline" style="margin-right: 20px;">4.5</p>
                                        </div>
                                </div>
                                <div class="location d-flex d-block">
                                    <img src="../assert/image/placeholder_186250.png">
                                    <p>Thirichy</p>
                                </div>
                                        <div class="price ms-2">
                                            <p><strong>&#8377;5000</strong>Per Day</p>
                                        </div>
                                        <div class="capacity ms-2">
                                            <p><strong>700-800</strong>aprox</p>
                                        </div >
                                        <div class="amenties d-flex ms-2">
                                            <p>Ac</p><p>Parking</p><p>DJ Hall</p><p class="more">+2 more</p>
                                    </div>
                            </div>
                        </div >
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm">
                    <div class="card-container">
                        <div class="card">
                            <img src="../assert/image/hallcard-3.jpg" style="border-radius:20px;" >
                            <div class="card-content">
                                <div class="namestar d-flex mt-2">
                                    <h4>Sapphire Hall</h4>
                                        <div class="rating d-inline">
                                            <img src="../assert/image/star_148841.png" style="width:20px;">
                                            <p class="d-inline" style="margin-right: 20px;">4.5</p>
                                        </div>
                                </div>
                                <div class="location d-flex d-block">
                                    <img src="../assert/image/placeholder_186250.png">
                                    <p>Salem</p>
                                </div>
                                        <div class="price ms-2">
                                            <p><strong>&#8377;5000</strong>Per Day</p>
                                        </div>
                                        <div class="capacity ms-2">
                                            <p><strong>700-800</strong>aprox</p>
                                        </div >
                                        <div class="amenties d-flex ms-2">
                                            <p>Ac</p><p>Parking</p><p>DJ Hall</p><p class="more">+2 more</p>
                                    </div>
                            </div>
                        </div >
                    </div>
                </div> 
                <div class="col-sm"> 
                    <div class="card-container">
                        <div class="card">
                            <img src="../assert/image/hallcard-4.jpg" style="border-radius:20px;">
                            <div class="card-content">
                                <div class="namestar d-flex mt-2">
                                    <h4>Diamond Lounge</h4>
                                        <div class="rating d-inline">
                                            <img src="../assert/image/star_148841.png" style="width:20px;">
                                            <p class="d-inline" style="margin-right: 20px;">4.5</p>
                                        </div>
                                </div>
                                <div class="location d-flex d-block">
                                    <img src="../assert/image/placeholder_186250.png">
                                    <p>Erode</p>
                                </div>
                                        <div class="price ms-2">
                                            <p><strong>&#8377;5000</strong>Per Day</p>
                                        </div>
                                        <div class="capacity ms-2">
                                            <p><strong>700-800</strong>aprox</p>
                                        </div >
                                        <div class="amenties d-flex ms-2">
                                            <p>Ac</p><p>Parking</p><p>DJ Hall</p><p class="more">+2 more</p>
                                    </div>
                            </div>
                        </div >
                    </div>
                </div>
                <div class="col-sm"> 
                    <div class="card-container">
                        <div class="card">
                            <img src="../assert/image/hallcard-5.jpg" style="border-radius:20px;">
                            <div class="card-content">
                                <div class="namestar d-flex mt-2">
                                    <h4>Platinum Plaza</h4>
                                        <div class="rating d-inline">
                                            <img src="../assert/image/star_148841.png" style="width:20px;">
                                            <p class="d-inline" style="margin-right: 20px;">4.5</p>
                                        </div>
                                </div>
                                <div class="location d-flex d-block">
                                    <img src="../assert/image/placeholder_186250.png">
                                    <p>Madurai</p>
                                </div>
                                        <div class="price ms-2">
                                            <p><strong>&#8377;5000</strong>Per Day</p>
                                        </div>
                                        <div class="capacity ms-2">
                                            <p><strong>700-800</strong>aprox</p>
                                        </div >
                                        <div class="amenties d-flex ms-2">
                                            <p>Ac</p><p>Parking</p><p>DJ Hall</p><p class="more">+2 more</p>
                                    </div>
                            </div>
                        </div >
                    </div>
                </div>
            </div>
            <div class="row ">
              <div class="col mt-4 mb-4">
                  <ul class="pagination" style="justify-content: center;">
                  <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                  <li class="page-item"><a class="page-link" href="#">1</a></li>
                  <li class="page-item"><a class="page-link" href="#">2</a></li>
                  <li class="page-item"><a class="page-link" href="#">3</a></li>
                  <li class="page-item"><a class="page-link" href="#">Next</a></li>
              </ul>
          </div>
            <div class="row">
                <div class="col d-flex flex-column justify-content-center align-items-center">
                    <h2 class="text-center mt-3">Best Wedding Venues in Coimbatore</h2>
                    <p class="text-center mt-2" style="line-height: 25px; letter-spacing: 2px;">
                        Known for its beauty over the globe, offers a great variety of wedding venues.
                        The best wedding venues are mentioned below along with their pictures and reviews.
                        The available venues are of all types including banquet halls to farmhouses. Both pocket-friendly & 
                        grand wedding venues are available for booking, contact your favourite wedding venue vendor or request a
                        call back from us. We will take care of the rest
                    </p>
                </div>
            </div>  
            </div>
            
            </div>
        </div>
      </div>
  
  <footer class="text-center text-lg-start bg-body-tertiary text-muted">

    <section class="d-flex justify-content-center justify-content-lg-between p-4 border-bottom">

      <div class="me-5 d-none d-lg-block">
        <span>Get connected with us on social networks:</span>
      </div>
      <div>
        <a href="" class="me-4 text-reset social-media">
          <img src="../assert/image/social_12942327.png">
        </a>
        <a href="" class="me-4 text-reset social-media">
          <img src="../assert/image/twitter-alt_12107622.png">
        </a>
        <a href="" class="me-4 text-reset social-media">
          <img src="../assert/image/instagram_2111463.png" alt="">
        </a>
        <a href="" class="me-4 text-reset social-media">
          <img src="../assert/image/youtube_1384060.png" alt="">
        </a>
      </div>
    </section>
    <section class="">
      <div class="container text-center text-md-start mt-5">

        <div class="row mt-3">

          <div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">
            <h6 class="text-uppercase fw-bold mb-4">
              <i class="fas fa-gem me-3"></i>Royal Halls
            </h6>
            <p>
              Manage all your event details,
              sales and billings and enhance the
              client experience with 20+ online
              booking, event planning.
            </p>
          </div>
          <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">
            <h6 class="text-uppercase fw-bold mb-4">Search Planning</h6>
            <p>
              <a href="Hall.html" class="text-reset">Search by Events</a>
            </p>
            <p>
              <a href="Hall.html" class="text-reset">Search by Seating Arrangements</a>
            </p>
            <p>
              <a href="Hall.html" class="text-reset">Search by Price</a>
            </p>
            <p>
              <a href="Hall.html" class="text-reset">Search by Hall</a>
            </p>
          </div>
          <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">
            <h6 class="text-uppercase fw-bold mb-4">Useful links :</h6>
            <p>
              <a href="Home1.0.html" class="text-reset">Home</a>
            </p>
            <p>
              <a href="Hall.html" class="text-reset">Venues</a>
            </p>
            <p>
              <a href="facilities.html" class="text-reset">Facilities</a>
            </p>
            <p>
              <a href="contact.html" class="text-reset">Contact</a>
            </p>
          </div>
          <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">
            <h6 class="text-uppercase fw-bold mb-4">Contact</h6>
            <p><i class="fas fa-home me-3"></i> Singa, Coimbatore</p>
            <p>
              <i class="fas fa-envelope me-3"></i>
              info@example.com
            </p>
            <p><i class="fas fa-phone me-3"></i> + 01 234 567 88</p>
            <p><i class="fas fa-print me-3"></i> + 01 234 567 89</p>
          </div>
        </div>
      </div>
    </section>
    <div class="text-center p-4 copyright">
      © 2021 Copyright:
      <a class="text-reset fw-bold" href="https://RoyalHalls.com/">RoyalHalls.com</a>
    </div>
  </footer>
  <script>
  document.getElementById('confirmLogoutButton').addEventListener('click', function() {
	    // Add your logout logic here
	    window.location.href = '<%= request.getContextPath() %>/LogoutServlet'; // Replace 'logoutURL' with the actual URL to log out
	  });

	  // Show the modal when the logout dropdown item is clicked
	  document.getElementById('logout').addEventListener('click', function(event) {
	    event.preventDefault();
	    var logoutModal = new bootstrap.Modal(document.getElementById('logoutModal'));
	    logoutModal.show();
	  });
    window.onscroll = function() {checkPosition()};
        function checkPosition() {
            var fixedDiv = document.getElementById("filter-bar");
            var containerEnter = document.getElementById("foot");
            var containerEnterRect = containerEnter.getBoundingClientRect();
            var fixedDivRect = fixedDiv.getBoundingClientRect();

            if (containerEnterRect.top <= fixedDivRect.bottom) {
                fixedDiv.style.position = "absolute";
                fixedDiv.style.top = (window.pageYOffset + containerEnterRect.top - fixedDivRect.height) + "px";
            } else {
                fixedDiv.style.position = "fixed";
                fixedDiv.style.top = "20px";
            }
        }

        document.querySelector('.dropdown-toggle').addEventListener('click', function() {
        document.querySelector('.dropdown-menu').classList.toggle('show');
        });
  </script>
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"
  integrity="sha384-KyZXEAg3QhqLMpG8r+Knujsl5+5hb7ie1LQQa9U52EXv7aQZL2RHB5SEc5HB5nh9" crossorigin="anonymous">
  </script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
  integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+7HAuoD6z7VVvNK15MWEhPJwW/7mo" crossorigin="anonymous">
  </script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
  </body>
</html>
