<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asserts/css/adminstyles.css">
  <script src="https://d3js.org/d3.v4.min.js"></script>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/billboard.js/dist/billboard.min.js"></script>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/billboard.js/dist/billboard.min.css" />
  <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
  
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

  
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Dashboard</title>

</head>

<body>
<%
/*
response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
	if(request.getSession().getAttribute("admin")==null){
		response.sendRedirect("index.jsp");
	} */
%>

  <div class="container-fluid">
    <div class="row">
      <nav class="col-md-2 col-2  sidebar position-fixed pt-0 px-0" id="sidebar">
        <div class="pt-0 px-0">
          <div class="logo-divv">
            <a class="navbar-brand" href="#">
              <img class="img-fluid logo-img" src="${pageContext.request.contextPath}/asserts/images/logo.png" alt="MDB Logo" />
            </a>
          </div>
          <div class="user-pic d-flex flex-column  justify-content-center align-items-center">
            <div>
              <img src="${pageContext.request.contextPath}/asserts/images/avatar.png" class="img-fluid rounded-pill" width="60" height="50" alt="">
            <a data-toggle="collapse" data-bs-toggle="collapse" href="#profileMenu" role="button" aria-expanded="false" aria-controls="profileMenu">
              <span class="px-1">${sessionScope.admin.getUserName()}<i class="bi bi-caret-down-fill"></i></span></a>
            </div>
              <div class="collapse mt-2" id="profileMenu">
                <div class="card card-body" id="cards-bodyy">
                    <div class="row pt-2 pb-2 px-1 menuss">
                        <a href="AdminManagementController" class="dropdown-item">Profile</a>
                    </div>
                     <!--     <div class="row pt-2 pb-2 px-1 menuss">
                                <a href="#" class="dropdown-item">Settings</a>
                            </div>  -->
                    <div class="row pt-2 pb-2 px-1 menuss">
                        <a href="${pageContext.request.contextPath}/AdminLogoutController" class="dropdown-item">Logout</a>
                    </div>
                </div>
            </div>
          </div>
          <div class="nav flex-column d-flex justify-content-center" id="sidenavs">
          
            <li class="nav-item side-barnav">
              <a class="nav-link pt-4 active" href="AdminDashBoardController">Dashboard</a>
            </li>
            <li class="nav-item side-barnav">
              <a class="nav-link pt-4" href="CustomerManagementController">Customer Management</a>
            </li>
            <li class="nav-item side-barnav">
              <a class="nav-link  pt-4" href="SellerManagementController">Vendor Management</a>
            </li>
            <li class="nav-item side-barnav">
              <a class="nav-link pt-4" href="ProductManagementController">Product Management</a>
            </li>
            <li class="nav-item side-barnav">
              <a class="nav-link pt-4" href="CategoryManagementController">Category Management</a>
            </li>
            <li class="nav-item side-barnav">
              <a class="nav-link pt-4" href="SubCategoryManagementController">Sub-Category Management</a>
            </li>
            <li class="nav-item side-barnav">
              <a class="nav-link pt-4" href="AdminManagementController">Admin Management</a>
          </li>
          
        </div>
        </div>
      </nav>
      <div class="bg-light container-flex  col-10 main-content">
        <div class="container">
          <div class="row">
            <div class="col-md-6 col-auto" id="first-top-chart">
              <div class="row col-md-12 col-auto mx-0 px-0 ">
                <div class="col-6 bg-white shadow text-center p-5 rounded " id="visitor-box"> 
                  <div class="col">
                    <h3 class="text-secondary">Visitors</h3>
                    <h5 id="visitors-count">20000</h5>
                  </div>
                </div>
                <div class="col-6  bg-white shadow text-center p-5 rounded " id="orders-box"> 
                  <div class="col">
                    <h3 class="text-secondary">Orders</h3>
                    <h5>${ordercount}</h5>
                  </div>
                </div>
              </div>
              <div class="row col-12 mx-0 px-0 mt-5">
                <div class="col-6 bg-white shadow text-center p-5 rounded" id="sellers-box">
                  <div class="card-body">
                    <h3 class="text-secondary">Sellers</h3>
                    <h5>${sellercount}</h5>
                  </div>
                </div>
                <div class="col-6 bg-white shadow text-center rounded p-5" id="buyers-box">
                  <div class="card-body">
                    <h3 class="text-secondary">Buyers</h3>
                    <h5>${customercount}</h5>
                  </div>
                </div>
                
              </div>
            </div>
            <div class="col-md-5 col-auto text-center shadow bg-white rounded pt-3 mt-0" id="donutchart">
                <h4>Top 3 Selling Products</h4>
                <div id="donut-chart"></div>
            </div>
          </div>
          <div class="row  mt-4 pb-3 ">
            <div class="col-md-6 col-sm-12 mt-2 bg-white rounded shadow p-4" id="top-chaart">
              <h4 class="text-center">Order count based on cities</h4>
              <canvas id="myChartbar"></canvas>
            </div>
            <div class="col-md-5 col-sm-12 mt-2 bg-white rounded shadow p-5" id="top-category">
              <h4 class="text-center">Top 5 Selling Category</h4>
              <div class="">
                <h5 class="text-secondary">Category 1</h5>
              <div class="progress pg-1">
                <div class="progress-bar bg-success" role="progressbar" style="width: 25%" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
              </div>
              </div>
              <div class="mt-4">
                <h5 class="text-secondary">Category 2</h5>
              <div class="progress pg-2">
                <div class="progress-bar bg-danger" role="progressbar" style="width: 55%" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
              </div>
              </div>
              <div class="mt-4">
                <h5 class="text-secondary">Category 3</h5>
              <div class="progress pg-3">
                <div class="progress-bar bg-warning" role="progressbar" style="width: 65%" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
              </div>
              </div>
              <div class="mt-4">
                <h5 class="text-secondary">Category 4</h5>
              <div class="progress pg-4">
                <div class="progress-bar bg-notify" role="progressbar" style="width: 72%" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
              </div>
              </div>
              <div class="mt-4 mb-4">
                <h5 class="text-secondary">Category 5</h6>
              <div class="progress pg-5">
                <div class="progress-bar bg-secondary" role="progressbar" style="width: 86%" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
              </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      

    </div>
  </div>
  <script>
	var visitorsCount = document.getElementById('visitors-count');
	document.addEventListener('DOMContentLoaded',()=>{
		visitorsCount.textContent = getRandomNumber();
	})
	
	function getRandomNumber(){
		 return Math.floor(10000 + Math.random() * 9000);
	}
	
    var xValues = ["Salem", "Coimbatore", "Erode", "Bangalore", "Hydrerabad"];
    var yValues = [55, 49, 44, 24, 20];
    var barColors = ["red", "green","blue","orange","brown"];

new Chart("myChartbar", {
  type: "bar",
  data: {
    labels: xValues,
    datasets: [{
      backgroundColor: barColors,
      data: yValues
    }]
  },
  options: {
    legend: {display: false},
    title: {
      display: true,
      text: "Ecommerce management"
    }
  }
});

    let chart = bb.generate({
            data: {
                columns: [
                    ["Product 1", 6],
                    ["Product 2", 4],
                    ["Product 3", 3],
                ],
                type: "donut",
                onclick: function (d, i) {
                    console.log("onclick", d, i);
                },
                onover: function (d, i) {
                    console.log("onover", d, i);
                },
                onout: function (d, i) {
                    console.log("onout", d, i);
                },
            },
            donut: {
                title: "",
            },
            bindto: "#donut-chart",
        });
  </script>


</body>

</html>