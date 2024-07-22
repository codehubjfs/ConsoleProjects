<%@page import="com.lms.bean.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile</title>
   <!--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>-->    
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/asserts/css/EmployeeStyle.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <style>
          .card {
            font-size: 15px;
            margin: 30px;
            margin-left: 20%;
        }
        .profile-card {
            background-color: #f8f9fa;
            width: 40rem;
            border: none;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        .profile-img {
            width: 100px;
            height: 100px;
            border-radius: 50%;
            border: 3px solid #040430;
        }
        .form-control-plaintext {
            /* background-color: #e9ecef; */
            border: 1px solid #e9ecef;
            border-radius: .25rem;
            padding: .375rem .75rem;
        }
        .modal-content {
            border-radius: 10px;
        }
        .btn-primary {
            background-color: #007bff;
            border-color: #007bff;
        }
        .btn-secondary {
            background-color: #6c757d;
            border-color: #6c757d;
        }
        label{
            margin-left: 120px;
            text-align: left;
        }
        .form-group{
            padding: 2px;
        }
        p{
        	margin-bottom:10px;
        }
        h4{
        	padding-bottom:20px;
        }
    </style>
</head>
<body>
     <header class="header fixed-top">
        <div class="header-img"><img src="${pageContext.request.contextPath}/asserts/images/image1.png" alt="Logo"></div>
        <a href="${pageContext.request.contextPath}/Profile" style="color: white;text-decoration: none;">
	        <div id="header-profile">
	        <div id="header-content"><p style="padding-top:15px; padding-right:5px"><%=session.getAttribute("username") %></p></div>
	        <div id="icon"><img src="${pageContext.request.contextPath}/asserts/images/image2.svg" alt="Icon" style="margin-top:15px;justify-content:center;height:25px"></div>
	        </div>
        </a>
    </header>
       <div class="row">
        <nav class="col-sm-2 sidebar sidebar-sticky">
                <a class="nav-link" href="${pageContext.request.contextPath}/Dashboard">Dashboard</a>
                <a class="nav-link active" href="${pageContext.request.contextPath}/Profile">Profile</a>
                <a class="nav-link" href="${pageContext.request.contextPath}/Leave">Applied Leaves</a>
                <a class="nav-link" href="${pageContext.request.contextPath}/History">History</a>
                <a class="nav-link" href="index.jsp">Logout</a>
        </nav>
        <div class="col-md-10 content">
            <div>
                <h1>Profile...!</h1>
            </div>
            <div>
                <nav aria-label="breadcrumb">
                  <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/Dashboard">Dashboard</a></li>
                    <li class="breadcrumb-item active" aria-current="page">Profile</li>
                  </ol>
                </nav>
            </div>
            <hr>



            <div class="card profile-card" style="height: 40rem;">
                <div class="card-body">
                    <img src="${pageContext.request.contextPath}/asserts/images/image2.svg" alt="Profile Image" class="profile-img mb-3">
                    <h3 class="card-title" style="color: #040430; background-color:#f8f9fa;"><%= ((Employee)session.getAttribute("employee")).getFirstName() + " " + ((Employee)session.getAttribute("employee")).getLastName() %></h3>
                    <p class="text-muted" style="font-size: 13px;">
                        <%= ((Employee) session.getAttribute("employee")).getRole() %><br>
                        <%= ((Employee) session.getAttribute("employee")).getDept().getDeptName() %>
                    </p>
                    <h4>Profile Information <button type="button" class="btn btn-sm btn-primary" data-toggle="modal" data-target="#editCompanyModal" style="padding-bottom: 1px;">Edit</button></h4>
                    <div class="profile-info mt-12">
                        
                        <form>
                        	<div class="form-group row">
                                <label for="userName" class="col-sm-3 col-form-label">Employee Id</label>
                                <div class="col-sm-5">
                                    <input type="Number" readonly class="form-control-plaintext" id="userName" value=<%= ((Employee)session.getAttribute("employee")).getEmpId()%>>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="userName" class="col-sm-3 col-form-label">Username</label>
                                <div class="col-sm-5">
                                    <input type="text" readonly class="form-control-plaintext" id="userName" value=<%= ((Employee)session.getAttribute("employee")).getUserName()%>>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="inputEmail" class="col-sm-3 col-form-label">Email</label>
                                <div class="col-sm-5">
                                    <input type="email" readonly class="form-control-plaintext" id="inputEmail" value=<%= ((Employee)session.getAttribute("employee")).getEmail()%>>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="companyAddress" class="col-sm-3 col-form-label">Password</label>
                                <div class="col-sm-5">
                                    <input type="password" readonly class="form-control-plaintext" id="companyAddress" value=<%= ((Employee)session.getAttribute("employee")).getPassword()%> style="overflow-y: auto;">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="Phone NUmber" class="col-sm-3 col-form-label">Join Date</label>
                                <div class="col-sm-5">
                                    <input type="tel" readonly class="form-control-plaintext" id="Phone Number" value=<%= ((Employee)session.getAttribute("employee")).getJoinDate()%>>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            
        </div>
    </div>
    <script src="../../asserts/javascript/EmployeeScript.js"></script>
    
    
    <div class="modal fade" id="editCompanyModal" tabindex="-1" role="dialog" aria-labelledby="applyLeaveModalLabel" aria-hidden="true">
	    <div class="modal-dialog" role="document">
	        <div class="modal-content">
	            <div class="modal-header">
	                <h5 class="modal-title" id="editCompanyModalLabel">Change Password</h5>
	            </div>
	            <div class="modal-body">
	                <form id="leaveForm" action="${pageContext.request.contextPath}/Profile" method="post">
	                    <div class="form-group">
	                        <label for="companyAddress" style="margin-left:0px">Old Password</label> <br>                               
                            <input type="password" name = "oldPassword" id="companyAddress">       
	                    </div>
	                    <div class="form-group">
	                        <label for="companyAddress" style="margin-left:0px">New Password</label><br>
                            <input type="password" name = "newPassword" id="companyAddress">
	                    </div>
						<div class="form-group">
	                        <label for="companyAddress" style="margin-left:0px">Confirm Password</label><br>
                            <input type="password" name = "CfPassword" id="companyAddress">
	                    </div>
	                    <div class="modal-footer">
	                        <button type="button" class="btn btn-secondary btn-sm" data-dismiss="modal">Close</button>
	                        <button type="submit" class="btn btn-primary btn-sm">Save Changes</button>
	                    </div>
	                </form>
	            </div>
	        </div>
	    </div>
	</div>

</body>
</html>