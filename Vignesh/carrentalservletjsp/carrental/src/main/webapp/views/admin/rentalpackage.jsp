<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Rental Package Dashboard</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="../../css/adminRental.css">
</head>
<body>
    <div class="sidebar">
        <img src="../../images/logo2.png" alt="Logo"> <span style="text-align: center; padding: 10px;">
            <span style="color: orange;">GO</span> TRIP </span> 
         <a id="dashboardLink" href="${pageContext.request.contextPath}/AdminDashboardServlet">Dashboard</a>
        <a href="${pageContext.request.contextPath}/AdminListCarServlet">Cars</a>
        <a href="${pageContext.request.contextPath}/BookingServlet">Bookings</a>
        <a href="${pageContext.request.contextPath}/UserControllerServlet">Customer</a>
        <a href="rentalpackage.jsp">Rental Package</a>
        
    </div>
    <div class="content">
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
              <li class="breadcrumb-item"><a href="main.html">Dashboard</a></li>
             
              <li class="breadcrumb-item active" aria-current="page">Rental Package</li>
            </ol>
          </nav>
        <div class="header row">
            <div class="name col mx-0">
                <!-- <h6>Rose</h6> -->   
            </div>
            <div class="profile col">
                <a class="d-block" data-bs-toggle="collapse" href="#profileMenu" role="button" aria-expanded="false" aria-controls="profileMenu">
                    <img class="rounded-pill align-self-center" src="../../images/profile.jpg" height="50" width="60" alt="">
                </a>
                <div class="collapse mt-2" id="profileMenu">
                    <div class="card card-body">
                        <div class="row pt-2 pb-2 menuss">
                            <a href="#" class="dropdown-item">Profile</a>
                        </div>
                        <div class="row pt-2 pb-2 menuss">
                            <a href="#" class="dropdown-item">Settings</a>
                        </div>
                        <div class="row pt-2 pb-2 menuss">
                            <a href="loginadmin.html" class="dropdown-item">Logout</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-md-6">
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="Search by package name">
                    <button class="btn btn-primary">Search</button>
                </div>
            </div>
            <div class="col-3">
                <!-- <button class="btn btn-secondary" type="button" id="dropdownMenuButton">
                    Add Package
                </button> -->
            </div>
            <div class="col-md-3">
                <div class="dropdown">
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-bs-toggle="dropdown" aria-expanded="false">
                        Package Type
                    </button>
                    <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                        <li><a class="dropdown-item" href="#">Daily</a></li>
                        <li><a class="dropdown-item" href="#">Weekly</a></li>
                        <li><a class="dropdown-item" href="#">Monthly</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="container mt-5">
            <div class="row">
                
                <div class="col-md-4" id="card-1">
                    <div class="card">
                        <img src="car1.jpg" alt="Package Image">
                        <div class="card-body">
                            <h5 class="card-title">One Week</h5>
                            <h6 class="card-subtitle mb-2 text-muted">3 Days / 2 Nights</h6>
                            <div class="features" >
                                <span class="rate" style="padding-right: 10px;"><i class="fas fa-rupee-sign"></i>500</span>
                                <span class="type" style="padding-right: 10px;"><i class="fas fa-car-side"></i> Luxury</span>
                                <span class="duration"><i class="fas fa-clock"></i>
                                    3 Days</span>
                                <span class="availability"> Available</span>
                            </div>
                            <button class="btn btn-rent mt-3" style="margin-right: 30px; ">Add</button>
                            <button class="btn btn-rent mt-3" onclick="openEditModal('1')"  style="margin-right: 30px;">Edit</button>
                            <button class="btn btn-rent mt-3 bg-danger" onclick="openDeleteModal('1')">Delete</button>
                        </div>
                    </div>
                    
                </div>
                <div class="col-md-4" id="card-1">
                    <div class="card" style="height: 96%;">
                        <img src="car2.jpg" alt="Package Image">
                        <br>
                        <div class="card-body">
                            <h5 class="card-title">One Week</h5>
                            <h6 class="card-subtitle mb-2 text-muted">3 Days / 2 Nights</h6>
                            <div class="features" >
                                <span class="rate" style="padding-right: 10px;"><i class="fas fa-rupee-sign"></i>500</span>
                                <span class="type" style="padding-right: 10px;"><i class="fas fa-car-side"></i> Luxury</span>
                                <span class="duration"><i class="fas fa-clock"></i>
                                    3 Days</span>
                                <span class="availability"> Available</span>
                            </div>
                            
                            <button class="btn btn-rent mt-3" style="margin-right: 30px; ">Add</button>
                            <button class="btn btn-rent mt-3" onclick="openEditModal('1')"  style="margin-right: 30px; ">Edit</button>
                            <button class="btn btn-rent mt-3 bg-danger" onclick="openDeleteModal('2')">Delete</button>
                        </div>
                    </div>
                    
                </div>
                <div class="col-md-4" id="card-1">
                    <div class="card" style="height: 95%;">
                        <img src="car3.jpg" alt="Package Image">
                        <br>
                        <div class="card-body">
                            <h5 class="card-title">One Week</h5>
                            <h6 class="card-subtitle mb-2 text-muted">3 Days / 2 Nights</h6>
                            <div class="features" >
                                <span class="rate" style="padding-right: 10px;"><i class="fas fa-rupee-sign"></i>500</span>
                                <span class="type" style="padding-right: 10px;"><i class="fas fa-car-side"></i> Luxury</span>
                                <span class="duration"><i class="fas fa-clock"></i>
                                    3 Days</span>
                                <span class="availability"> Available</span>
                            </div>
                            <button class="btn btn-rent mt-3" style="margin-right: 30px; ">Add</button>
                            <button class="btn btn-rent mt-3" onclick="openEditModal('1')"  style="margin-right: 30px; ">Edit</button>
                            <button class="btn btn-rent mt-3 bg-danger" onclick="openDeleteModal('3')">Delete</button>
                        </div>
                    </div>
                    
                </div>
                
            </div>
        </div>
    </div>

    
    <div class="modal fade" id="editModal" style="color: black;" tabindex="-1" aria-labelledby="editModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="editModalLabel">Edit Package Details</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form>
                        <div class="mb-3">
                            <label for="editRate" class="form-label">Rate</label>
                            <input type="text" class="form-control" id="editRate">
                        </div>
                        <div class="mb-3">
                            <label for="editType" class="form-label">Type</label>
                            <input type="text" class="form-control" id="editType">
                        </div>
                        <div class="mb-3">
                            <label for="editDuration" class="form-label">Duration</label>
                            <input type="text" class="form-control" id="editDuration">
                        </div>
                        <div class="mb-3">
                            <label for="editAvailability" class="form-label">Availability</label>
                            <input type="text" class="form-control" id="editAvailability">
                        </div>
                        <button type="button" class="btn btn-primary" onclick="saveChanges()">Save changes</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    
    <div class="modal fade" id="deleteModal"style="color: black;" tabindex="-1" aria-labelledby="deleteModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="deleteModalLabel">Delete Package</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <p>Are you sure you want to delete this package?</p>
                    <form>
                        <div class="mb-3">
                            <label for="deletePackageId" class="form-label">Package ID</label>
                            <input type="text" class="form-control" id="deletePackageId" >
                        </div>
                        <button type="button" class="btn btn-danger" onclick="deleteCard()" data-bs-dismiss="modal">Delete</button>
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <script src="../../javascript/adminRental.js">
       
    </script>
</body>
</html>
