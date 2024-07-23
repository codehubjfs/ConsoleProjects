
<%@page import="com.leavemanagement.model.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manager</title>
   <!--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>-->    
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>    
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <script src="https://unpkg.com/ionicons@5.5.2/dist/ionicons.js"></script>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/asserts/css/ManagerStyle.css">
  <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    
    <style>
    	body{
    		overflow-x: hidden;
    	}
	    .special-card:hover {
	    	transform: none; /* or transform: initial; */
	    }
        .more{
            text-align: right; 
            padding: 10px;
        }
        .more a{
            color: blue; 
            font-style: italic;
        }
        .more a:hover{
            text-decoration: underline;
            color: rgb(85, 85, 252);
        }
    </style>
</head>
<body>
    <header class="header fixed-top">
        <div class="header-img"><img src="${pageContext.request.contextPath}/asserts/images/image1.png"></div>
        <div id="header-content"><p><%= session.getAttribute("username") %></p></div>
        <div id="icon"><img src="${pageContext.request.contextPath}/asserts/images/image2.svg"></div>
    </header>
    <div class="row">
        <nav class="col-md-2 sidebar sidebar-sticky">
            <a class="nav-link active" href="${pageContext.request.contextPath}/manager/mdashboard">Dashboard</a>
            <a class="nav-link" href="${pageContext.request.contextPath}/manager/mprofile">Profile</a>
            <a class="nav-link" href="${pageContext.request.contextPath}/manager/mLeaveManagement">Leave Management</a>
            <a class="nav-link" href="${pageContext.request.contextPath}/manager/mviewTeams">View Teams</a>
            <a class="nav-link" href="${pageContext.request.contextPath}/manager/mCalender">Calendar</a>
            <a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout</a>
        </nav>
        <div class="col-md-10 content">
            <div>
                <h1>Welcome <%= ((Employee)request.getSession().getAttribute("employee")).getFirstName() %>...!</h1>
            </div>
            <div>
                <nav aria-label="breadcrumb">
                  <ol class="breadcrumb">
                    <li class="breadcrumb-item active" aria-current="page">Dashboard</li>
                  </ol>
                </nav>
          </div>
          <hr>
          <div class="activity">
            <a href="">
                <div class="card " style="width: 17rem;">
                    <div class="card-body">
                      <h6 class="card-title">Team Members</h6>
                      <p class="card-text">${teamCount}</p>
                    </div>
                </div>
            </a>
            <a href="mdashboard" data-toggle="modal" data-target="#leaveDetails">
                <div class="card" style="width: 17rem;">
                    <div class="card-body">
                      <h6 class="card-title">Today's Leave</h6>
                      <p class="card-text">${absentCount}</p>
                    </div>
                </div>
            </a>
            <a href="${pageContext.request.contextPath}/manager/mLeaveManagement">
                <div class="card" style="width: 17rem;">
                    <div class="card-body">
                      <h6 class="card-title">Pending Approvals</h6>
                      <p class="card-text">${leaveRequestCount}</p>
                    </div>
                </div>
            </a>
            
          </div>
          
          <div class="row">
          	<div class="col-md-6 d-flex">
			    <div class="activity" id="tables">
			        <div class="card special-card" style="width: 30rem; height: auto; transform:0s;">
			            <div class="card-body">
			                <h6 class="card-title">View Team Details</h6>
			                
			                <table class="table table-striped">
			                    <thead>
			                        <tr>
			                            <th scope="col">S.No</th>
			                            <th scope="col">EmpId</th>
			                            <th scope="col">UserName</th>
			                            <th scope="col">View</th>
			                        </tr>
			                    </thead>
			                    <tbody>
			                        <!-- Iterate over the list of employees -->
			                        <c:forEach items="${teams}" var="employee" varStatus="loop">
			                            <tr>
			                                <th scope="row">${loop.index + 1}</th>
			                                <td>${employee.empID}</td>
			                                <td>${employee.username}</td>
			                                <td>
			                                    <!-- Link to open modal -->
			                                    <a href="#" style="color: #040430;" data-toggle="modal" data-target="#myModal${loop.index + 1}">
			                                        <ion-icon name="eye-outline"></ion-icon>
			                                    </a>
			                                </td>
			                            </tr>
			                            <!-- Modal for each employee -->
			                            <div class="modal fade" id="myModal${loop.index + 1}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
			                                <div class="modal-dialog" style="width: 25rem;">
			                                    <div class="modal-content" style="text-align: center; align-items: center; justify-content: center;">
			                                        <div class="modal-header">
			                                            <h5 class="modal-title" id="exampleModalLabel">Employee Details</h5>
			                                        </div>
			                                        <div class="modal-body">
			                                            <div class="card-container" style="background-color: #040430; border-radius: 5px; box-shadow: 0px 10px 20px -10px rgba(0,0,0,0.75); color: #B3B8CD; padding-top: 30px; padding-bottom: 20px; position: relative; width: 300px; max-width: 100%; text-align: center;">
			                                                <img class="round" src="${pageContext.request.contextPath}/asserts/images/image3.png" alt="user" style="border: 1px solid #03BFCB; border-radius: 50%; height: 50%; width: 50%; padding: 7px;"/>
			                                                <h3 style="margin: 10px 0;">${employee.firstName} ${employee.lastName}</h3>
			                                                <h6 style="margin: 5px 0;">${employee.role}</h6>
			                                                <h6 style="font-size: 12px; line-height: 21px;">${employee.department.deptName}</h6>
			                                                <p style="font-size: 14px; line-height: 21px;">Employee Id: ${employee.empID}</p>
			                                                <p style="font-size: 14px; line-height: 21px;">Email: ${employee.email}</p>
			                                            </div>
			                                        </div>
			                                        <div class="modal-footer">
			                                            <button type="button" class="btn btn-sm btn-secondary" data-dismiss="modal">Close</button>
			                                        </div>
			                                    </div>
			                                </div>
			                            </div>
			                        </c:forEach>
			                    </tbody>
			                </table>
			                <div class="more">
			                    <a href="${pageContext.request.contextPath}/manager/mviewTeams">View More</a>
			                </div>
			            </div>
			        </div>
			    </div>
			</div>

                <div class="col-md-6">
                    <div class="activity">
                        <div class="card" style="width: 25rem; height: 268px;" id="graph">
                            <div class="card-body">
                                <div>
                                    <h3>Leave Analysis</h3>
                                </div>
                                <div>
                                    <canvas id="analysisChart" style="width:100%;max-width:600px;"></canvas>
                                </div> 
                            </div>
                        </div> 
                    </div>
                </div>
            </div>
        </div>
    </div>
    
   <script src="${pageContext.request.contextPath}/asserts/javascript/ManagerScript.js"></script>
   
    <!-- Modal Structure -->
    

    <!-- Display absentees -->
    <div class="modal fade" id="leaveDetails" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" style="width: 26rem;align-items: center; ">
        <div class="modal-content" style="align-items: center; justify-content: center;">
            <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Absentees List</h5>
            </div>
            <div class="modal-body">
            		<c:forEach var="detail" items="${absent}">
                        <div class="card" style="background-color: #040430; height: 5rem; width: 20rem; margin-bottom: 20px; margin-left: 20px;">
                            <div class="card-title">
                                <div class="content-container">
                                    <div class="thumb-sm member-thumb ml-2">
                                        <img src="${pageContext.request.contextPath}/asserts/images/image3.png" class="rounded-circle img-thumbnail" alt="profile-image">
                                    </div>
                                    <div>
                                        <h4>${detail.emp.firstName}</h4>
                                        <p class="text">${detail.emp.department.deptName}<p>
                                        <p class="text">${detail.emp.role}</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
            	</div>
            <div class="modal-footer">
            	<button type="button" class="btn btn-sm btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
        </div>
    </div>
    <script>
    $(document).ready(function() {
        $('a[data-target="#leaveDetails"]').on('click', function(e) {
            e.preventDefault();
            $('#modalBody').load($(this).attr('href') + ' #modalBody > *', function() {
                $('#leaveDetails').modal('show');
            });
        });
    });
    </script>
</body>
</html>