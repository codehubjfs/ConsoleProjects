<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored = "false" %>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); 
    response.setHeader("Pragma", "no-cache"); 
    response.setDateHeader("Expires", 0); 
%>
<%
    // Check if a session already exists, if not, create one
    HttpSession existingSession = request.getSession(false);
    if (existingSession == null || existingSession.getAttribute("customer") == null) {
        response.sendRedirect(request.getContextPath() + "/view/Admin/Login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/AdminStyle.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.css">
    <script type="text/javascript" src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.js"></script>
    <script src="https://cdn.canvasjs.com/canvasjs.min.js"></script>
    <script src="../../script/Admin.js"></script>
  
    <script>
        window.onload = function () {
            var chart = new CanvasJS.Chart("chartContainer", {
                exportEnabled: true,
                animationEnabled: true,
                title: {
                    text: "Popularity of each city travel by district"
                },
                legend: {
                    cursor: "pointer",
                    itemclick: explodePie
                },
                data: [{
                    type: "pie",
                    showInLegend: true,
                    toolTipContent: "{name}: <strong>{y}%</strong>",
                    indexLabel: "{name} - {y}%",
                    dataPoints: [{
                            y: 26,
                            name: "Chennai",
                            exploded: true
                        },
                        {
                            y: 20,
                            name: "Coimbatore"
                        },
                        {
                            y: 5,
                            name: "Salem"
                        },
                        {
                            y: 29,
                            name: "Bangalore"
                        },
                        {
                            y: 7,
                            name: "Madurai"
                        },
                        {
                            y: 17,
                            name: "Vellore"
                        },
                        {
                            y: 22,
                            name: "Other"
                        }
                    ]
                }]
            });
            chart.render();
        }
        function explodePie(e) {
            if (typeof (e.dataSeries.dataPoints[e.dataPointIndex].exploded) === "undefined" || !e.dataSeries.dataPoints[
                    e.dataPointIndex].exploded) {
                e.dataSeries.dataPoints[e.dataPointIndex].exploded = true;
            } else {
                e.dataSeries.dataPoints[e.dataPointIndex].exploded = false;
            }
            e.chart.render();
        }
    </script>
<style>
/* Define the default and active styles for the links */
.sidebar a {
    text-decoration: none;
}

.sidebar a.active {
    color: #d7df3f;
    background-color: #102754;
    border-radius: 15px;
    padding-left: 10px;
}


</style>
</head>

<body>
    <header>
        <nav>
            <ul>
                <li><img src="${pageContext.request.contextPath}/Images/image1.png" alt="logo"></li>
                <li>Joy Rider</li>
                <li class="right-align"><img src="${pageContext.request.contextPath}/Images/profile.png" alt="image"></li>
                <li>${customer.firstName} ${customer.lastName}<div class="cent">Admin</div>
                </li>
            </ul>
        </nav>
    </header>
    <div class="container">
        <aside class="sidebar">
            <ul>
                <li class="sidebar-title" class="mt-5">ADMINISTRATOR</li>
                <li class="submenu">
                    <a href="http://localhost:8038/bookticket/view/Admin/AdminIndex.jsp" class="active" onclick="toggleSubmenu('dashboardSubmenu')">DASHBOARD</a>
                    <ul id="dashboardSubmenu" style="display: none;">
                        <li class="space"><a href="#">- Analytics</a></li>
                    </ul>
                </li>
                <li class="submenu">
                    <a href="${pageContext.request.contextPath}/ViewCustomerController" onclick="toggleSubmenu('userManagementSubmenu')">USER MANAGEMENT</a>
                    <ul id="userManagementSubmenu" style="display: none;">
                        <li class="space"><a href="http://127.0.0.1:5500/Admin/usermanament/customer.html">- Customer List</a></li>
                        <li class="spaceup"><a href="http://127.0.0.1:5500/Admin/usermanament/Busoperator.html">- Bus Operator List</a></li>
                    </ul>
                </li>
                <li class="submenu">
                    <a href="${pageContext.request.contextPath}/ViewRoutesController" onclick="toggleSubmenu('routeManagementSubmenu')">ROUTE MANAGEMENT</a>
                    <ul id="routeManagementSubmenu" style="display: none;">
                        <li class="space"><a href="http://127.0.0.1:5500/Admin/RouteManagement/Routes.html">- Route Details</a></li>
                    </ul>
                </li>
                <div class="downside">
                <li>
                <a href="${pageContext.request.contextPath}/view/Admin/AddAdmin.jsp">ADD NEW ADMIN</a></li>
                <li><a href="${pageContext.request.contextPath}/LogoutServlet" method="get">LOGOUT</form></a></li></div>
            </ul>
        </aside>
        <main class="content">
           <h1>Welcome,${customer.firstName} ${customer.lastName}</h1>
            <h2>Analytics</h2>
            <div class="analytics-cards">
                <div class="card">
                    <h3>BUSES</h3>
                    <p>Total Bus</p><br>
                    <h3>55</h3>
                </div>
                <div class="card">
                    <h3>ROUTES</h3>
                    <p>Total Routes</p><br>
          			<h3>
	                <%=
	                    request.getAttribute("Routes")
	                %>
           		    </h3>
                </div>
                <div class="card">
                    <h3>CUSTOMERS</h3>
                    <p>Total Customer</p>
                    <br>
                    <h3>
                    <%=
                    		 request.getAttribute("Customers")
                    %>
                    </h3>
                </div>
                <div class="card">
                    <h3>Booking</h3>
                    <p>Total Booking</p><br>
                    <h3>22</h3>
                </div>
           <!--        <div class="card">
                    <h3>Bus Operator</h3>
                    <p>Total Bus Operator</p><br>
                    <h3>1000</h3>
                </div> -->
                </div>
                <br>
                <div class="card">
                    <h3>People travel of each district</h3>
                    <div id="chartContainer" style="height: 370px; width: 100%;"></div>
                </div>
            <br>
            <br>
        </main>
    </div>
</body>
</html>

