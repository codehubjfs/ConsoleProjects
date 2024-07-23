<!DOCTYPE html>
<%@page import="java.util.stream.Collectors"%>
<%@page import="java.util.stream.Collector"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Instructors Table</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
    <style>
        .vh-100 { height: 100vh; }
        .vertical-nav { width: 200px; height: 100%; position: fixed; top: 56px; left: 0; padding-top: 20px; }
        .main-content { margin-left: 220px; padding-top: 20px; }
        @media (max-width: 767.98px) {
            .vertical-nav { width: 4%; height: 100%; position: relative; top: 0; left: 0; }
            .main-content { margin-left: 0; width: 100%; }
        }
    </style>
    <script>
        $(document).ready(function() {
            $('#example').DataTable();
        });
    </script>
</head>
<body>
<%@page import="java.util.*,com.spring.model.Student"%> 

<!-- Top Horizontal Navbar -->
<nav class="navbar navbar-expand-lg navbar-light fixed-top" style="background-color: #0092CA;">
    <a class="navbar-brand" href="#">
        <img src="asserts/images/site-logo.png" height="60px" width="70px" alt="Logo">
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="languageDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Language
                </a>
                <div class="dropdown-menu" aria-labelledby="languageDropdown">
                    <a class="dropdown-item" href="#">English</a>
                    <a class="dropdown-item" href="#">Spanish</a>
                    <a class="dropdown-item" href="#">French</a>
                </div>
            </li>
            <li class="nav-item pt-1 pl-3">
                <div class="dropdown d-flex">
                    <a href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <img src="asserts/images/person.svg" class="rounded-circle pr-1" alt="Profile Image">
                    </a>
                    <h6 class="pt-1">SHIVASANKARAN R L</h6>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                        <a class="dropdown-item" href="SLogOut">LogOut</a>
                    </div>
                </div>
            </li>
        </ul>
    </div>
</nav>

<!-- Vertical Navigation Bar -->
<div class="bg-dark text-light vh-100 vertical-nav mt-3">
    <div class="nav flex-column">
       <a href="DashBoard" class="nav-item nav-link text-light pb-2 pt-5">Dashboard</a>
            <a href="courses" class="nav-item nav-link text-light pb-2 pt-4">Course Management</a>  
            <a href="Profile" class="nav-item nav-link text-light pb-2 pt-4">Profile</a>
             <a href="Results" class="nav-item nav-link text-light pb-2 pt-4">Results</a>
            <a href="Chatting" class="nav-item nav-link text-light pb-2 pt-4">Messages</a>
    </div>
</div>

<!-- Main Content -->
<div class="main-content">
    <div class="container">
        <h2 class="mt-4">Instructors Table</h2>
        <table id="example" class="display table table-striped table-bordered" style="width:100%">
            <thead>
                <tr>
                    <th>S.no</th>
                    <th>Assessment Name</th>
                    <th>Marks</th>
                </tr>
            </thead>
            <tbody>
                <!-- Example data, replace with your data -->
                <%@page import="com.spring.model.Marks,java.util.*,com.spring.model.AssessmentBean" %>
                <% ArrayList <Marks> marksList=(ArrayList<Marks>) request.getAttribute("marksList");%>
				<% ArrayList <AssessmentBean> AssessmentList=(ArrayList<AssessmentBean>) request.getAttribute("assessmentList");%>         
				<% int i=0; %>
                    <% for(Marks c:marksList) {%>
                <tr>
                <td><%=++i %></td>
                    <td><%=AssessmentList.stream().filter((x)->x.getAssessmentId()==c.getAssessmentid()).collect(Collectors.toList()).get(0).getAssessmentName() %></td>
                    <td><%= c.getMarks() %></td>
                </tr>
                <%} %>
                <!-- Add more rows as needed -->
            </tbody>
            
        </table>
    </div>
</div>

</body>
</html>
