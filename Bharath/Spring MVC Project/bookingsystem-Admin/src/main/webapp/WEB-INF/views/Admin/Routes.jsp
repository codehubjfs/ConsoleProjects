<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored = "false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Routes</title>
     <link rel="stylesheet" href="${pageContext.request.contextPath}/style/AdminStyle.css"> 
    <script src="${pageContext.request.contextPath}/script/AdminJs.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.10.3/font/bootstrap-icons.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
  	<path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0z"/>
  	<path d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4zM2.5 3h11V2h-11z"/>
</svg>
<style>
   .sidebar a {
        text-decoration: none;
    }
    
    .sidebar a.active {
        color: #d7df3f;
        background-color: #102754;
        border-radius: 15px;
        padding-left: 10px;
    }
    .custom-modal {
            display: none; 
            position: fixed; 
            z-index: 1;
            left: 0;
            top: 0;
            width: 100%; 
            height: 100%; 
            overflow: auto;
            background-color: rgb(0,0,0); 
            background-color: rgba(0,0,0,0.4); 
        }

        .custom-modal-content {
            background-color: #fefefe;
            margin: 5% auto; 
            padding: 20px;
            border: 1px solid #888;
            width: 80%; 
            max-width: 600px;
            border-radius: 10px;
            height:auto; 
        }

   
        .custom-close {
            color: #aaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
        }

        .custom-close:hover,
        .custom-close:focus {
            color: black;
            text-decoration: none;
            cursor: pointer;
        }


        .custom-modal-header {
            font-size: 24px;
            font-weight: bold;
            text-align: center;
            margin-bottom: 20px;
        }


        .custom-input-container {
            margin-bottom: 20px;
        }

        .custom-input-container label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }

        .custom-input-container input {
            width: calc(100% - 22px);
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
        }

        .custom-icon {
            display: inline-block;
            width: 20px;
            height: 20px;
            margin-left: 5px;
        }

        .custom-error {
            color: red;
            font-size: 12px;
            display: block;
            margin-top: 5px;
        }


        .custom-btn, .custom-reset-btn {
            display: inline-block;
            padding: 10px 20px;
            margin-right: 10px;
            border: none;
            border-radius: 5px;
            background-color: #4CAF50;
            color: white;
            cursor: pointer;
            font-size: 16px;
        }

        .custom-reset-btn {
            background-color: #f44336;
        }

        .custom-btn:hover, .custom-reset-btn:hover {
            opacity: 0.8;
        }


       
        .action-icons {
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .edit-icon {
            font-size: 20px;
            cursor: pointer;
            color: #3d6da1fa;
            margin-right: 10px;
        }
        .save-icon {
            display: none;
            height: 32px;
            width: 30px;
        }
        .modal {
            display: none;
            position: fixed;
            z-index: 1;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            overflow: auto;
            background-color: rgba(0,0,0,0.4);
        }
        .modal-content {
            background-color: #fefefe;
            margin: 10% auto;
            padding: 20px;
            border: 1px solid #888;
            width: 30%;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
        }
        .close {
            color: #aaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
            cursor: pointer;
        }
        .close:hover,
        .close:focus {
            color: black;
            text-decoration: none;
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            font-weight: bold;
        }
        input[type="text"] {
            width: calc(100% - 10px);
            padding: 8px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        .btn-container {
            text-align: center;
            margin-top: 20px;
        }
        .btn {
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
            border: none;
            border-radius: 4px;
            color: #fff;
            background-color: #007bff;
            transition: background-color 0.3s ease;
        }
        .btn:hover {
            background-color: #0056b3;
        }
        .btn-secondary {
            background-color: #6c757d;
        }
        .btn-secondary:hover {
            background-color: #495057;
        }
        .error-message {
            color: red;
            font-size: 14px;
            margin-top: 5px;
        }
        .modal-backdrop{
        	display:none;
        }
       .modal-content {
       width: 100% !important;
       }
       .als{
       width:50%!important;
       }
       .del-btn-custom {
  	 	color: red; 
    	background-color: transparent;
    	border: none;
    	padding: 0; 
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
                <li>Charles Harris <div class="cent">Admin</div>
                </li>
            </ul>
        </nav>
    </header>
    <div class="container">
        <aside class="sidebar">
            <ul>
                <li class="sidebar-title" class="mt-5">ADMINISTRATOR</li>
                <li class="submenu">
                    <a href="card" onclick="toggleSubmenu('dashboardSubmenu')">DASHBOARD</a>
                    <ul id="dashboardSubmenu" style="display: none;">
                        <li class="space"><a href="http://127.0.0.1:5500/Admin/usermanament/customer.html">- Analytics</a></li>
                    </ul>
                </li>
                <li class="submenu">
                    <a href="customers" onclick="toggleSubmenu('userManagementSubmenu')">USER MANAGEMENT</a>
                    <ul id="userManagementSubmenu" style="display: none;">
                        <li class="space"><a href="http://127.0.0.1:5500/Admin/usermanament/customer.html">- Customer List</a></li>
                        <li class="spaceup"><a href="http://127.0.0.1:5500/Admin/usermanament/Busoperator.html">- Bus Operator List</a></li>
                    </ul>
                </li>
                <li class="submenu">
                    <a href="viewroutes" class="active" onclick="toggleSubmenu('routeManagementSubmenu')">ROUTE MANAGEMENT</a>
                    <ul id="routeManagementSubmenu" style="display: none;">
                        <li class="space"><a href="http://127.0.0.1:5500/Admin/RouteManagement/Routes.html">- Route Details</a></li>
                    </ul>
                </li>
                <!-- <li><a href="#">POPULAR ROUTES</a></li> -->
                <!-- <li class="menu-title">GENERAL</li> -->
                <div class="downside">
                <li>
                <a href="adminadd">ADD NEW ADMIN</a></li>
                <li><a href="logout">LOGOUT</a></li></div>
            </ul>
        </aside>
        <main class="content">
        <h3>Routes</h3><br>
                <div class="button-container" id="add-route-btn">
                    <button class="add-customer-btn">Add Route</button>
                </div>
                <table border="1" id="routeTable">
                    <thead>
                        <tr>
                            <th>ROUTE_ID</th>
                            <th>START LOCATION</th>
                            <th>END LOCATION</th>
                            <th>DISTANCE</th>
                            <th>ESTIMATED DURATION</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
            <c:forEach var="route" items="${routes}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td class="routeId" style="display:none">${route.route_id}</td>
                    <td class="source">${route.startLocation}</td>
                    <td class="destination">${route.endLocation}</td>
                    <td class="distance">${route.distance}</td>
                    <td class="duration">${route.estimatedDuration}</td>
                    <td class="action-column d-flex">
                    <div class="edit-btn"><div class="bi bi-pencil-square edit-icon" ></div></div>
					<button class="del-btn border border-0 del-btn-custom"><i class="bi bi-trash fs-5"></i></button>  
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
      </main>
    <div id="addRouteModal" class="custom-modal">
    <div class="custom-modal-content">
        <span class="custom-close" onclick="closeAddRouteModal()">&times;</span>
        <div class="custom-modal-header">Add Route</div><br>
        <form id="addRouteForm" action="addRoute" onsubmit="return validateForm()">
            <div class="custom-input-container">
                <label>Enter Start Location:</label>
                <input type="text" id="startLocation" name="source" placeholder="Start Location">
                <span class="custom-icon" id="startLocationIcon"></span><br>
                <span class="custom-error" id="startLocationError"></span>
            </div>
            <div class="custom-input-container">
                <label>Enter End Location:</label>
                <input type="text" id="endLocation" name="end" placeholder="End Location">
                <span class="custom-icon" id="endLocationIcon"></span><br>
                <span class="custom-error" id="endLocationError"></span>
            </div>
            <div class="custom-input-container">
                <label>Enter Distance:</label>
                <input type="number" id="Distance" name="dis" placeholder="Distance">
                <span class="custom-icon" id="DistanceIcon"></span><br>
                <span class="custom-error" id="DistanceError"></span>
            </div>
            <div class="custom-input-container">
                <label>Enter Estimated Duration:</label>
                <input type="number" id="estimatedDuration" name="time" placeholder="Estimated Duration">
                <span class="custom-icon" id="estimatedDurationIcon"></span><br>
                <span class="custom-error" id="estimatedDurationError"></span>
            </div>
           <!--  <div class="custom-input-container">
                <label>Enter Availability:</label>
                <input type="text" id="availability" name="avail" placeholder="Availability">
                <span class="custom-icon" id="availabilityIcon"></span><br>
                <span class="custom-error" id="availabilityError"></span>
            </div>-->
            <button type="reset" class="custom-reset-btn">Reset</button>
            <button type="submit" class="custom-btn">Add</button>
        </form>
    </div>
</div>
<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="editModalLabel" aria-hidden="true">
<form id="editForm" action="updateRoute">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="editModalLabel">Edit Route</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true" onclick="closeEditRouteModal()">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                
<!--                 	<input class="edit-id" name="editId" id="editId" style="display:none"/>-->
                    <div class="form-group">
                        <!-- <label for="editRouteID">Route ID</label>-->
                        <input type="text" id="editRouteID" name="editRouteID" class="form-control" style="display:none"/>
                    </div>
                    <div class="form-group">
                        <label for="editStartLocation">Start Location</label>
                        <input type="text" id="editStartLocation" name="editStartLocation" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="editEndLocation">End Location</label>
                        <input type="text" id="editEndLocation" name="editEndLocation" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="editDestination">Distance</label>
                        <input type="text" id="editDestination" name="editDestination" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="editDuration">Duration</label>
                        <input type="text" id="editDuration" name="editDuration" class="form-control">
                    </div>
               
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="submit" class="btn btn-primary">Save changes</button>
            </div>
            
        </div>
    </div>
    </form>
</div>
            
<!-- Modal -->
<div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="deleteModalLabel" aria-hidden="true">
            <form action="wayDelete">
			    <div class="modal-dialog modal-dialog-centered">
			        <div class="modal-content">
			            <div class="modal-header">
			            	<input id="routesId" name="routesId" style="display:none"></input>
			                <h5 class="modal-title" id="deleteModalLabel">Confirm Delete</h5>
			                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			            </div>
			            <div class="modal-body">
			                <p>Are you sure you want to delete the route: <strong id="deleteRouteModel"></strong>?</p>
			            </div>
			            <div class="modal-footer">
			                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
			                <button type="submit" class="btn btn-danger" id="confirmDeleteBtn">Delete</button>
			            </div>
			        </div>
			    </div>
		    </form>
		</div>

           
            </table>
            <script>
            document.getElementById("add-route-btn").addEventListener("click", function(){
            	var addmodal= new bootstrap.Modal(document.querySelector('#addRouteModal'));
            	addmodal.show();
            });
            function validateForm() {
                var isValid = true;

                // Validate Start Location
                var startLocation = document.getElementById('startLocation').value.trim();
                if (startLocation === '') {
                    document.getElementById('startLocationError').innerText = 'Start Location is required';
                    isValid = false;
                } else if (!isNaN(startLocation)) { // Check if startLocation is not a number
                    document.getElementById('startLocationError').innerText = 'Start Location must be a valid string';
                    isValid = false;
                } else {
                    document.getElementById('startLocationError').innerText = '';
                }

                // Validate End Location
                var endLocation = document.getElementById('endLocation').value.trim();
                if (endLocation === '') {
                    document.getElementById('endLocationError').innerText = 'End Location is required';
                    isValid = false;
                } else if (!isNaN(endLocation)) { // Check if endLocation is not a number
                    document.getElementById('endLocationError').innerText = 'End Location must be a valid string';
                    isValid = false;
                } else {
                    document.getElementById('endLocationError').innerText = '';
                }

                // Validate Distance
                var distance = document.getElementById('Distance').value.trim();
                if (distance === '') {
                    document.getElementById('DistanceError').innerText = 'Distance is required';
                    isValid = false;
                } else {
                    document.getElementById('DistanceError').innerText = '';
                }

                // Validate Estimated Duration
                var estimatedDuration = document.getElementById('estimatedDuration').value.trim();
                if (estimatedDuration === '') {
                    document.getElementById('estimatedDurationError').innerText = 'Estimated Duration is required';
                    isValid = false;
                } else {
                    document.getElementById('estimatedDurationError').innerText = '';
                }

                // Additional validation logic for each field (e.g., numeric validation) can be added here

                return isValid;
            }

 
            
            function closeAddRouteModal() {
                var modal = document.getElementById('addRouteModal');
                modal.style.display = 'none';
            }
            function closeEditRouteModal() {
                var modal = document.getElementById('editModal');
                modal.style.display = 'none';
            }
            document.querySelectorAll('.del-btn').forEach(button => {
                button.addEventListener('click', function () {
                    var row = this.closest('tr');
                    let id = row.querySelector('.routeId').textContent;

                    document.getElementById('routesId').value = id;
              		
                    var deleteModal = new bootstrap.Modal(document.getElementById('deleteModal'));
                    deleteModal.show();
                });
            });

            document.querySelectorAll('.edit-btn').forEach(function(button){
            button.addEventListener('click',function(){
            	var row=button.closest('tr');
            	var routeId=row.querySelector('.routeId').textContent;
            	var source=row.querySelector('.source').textContent;
            	var end=row.querySelector('.destination').textContent;
            	var distance=row.querySelector('.distance').textContent;
            	var duration=row.querySelector('.duration').textContent;
            	document.getElementById('editRouteID').value=routeId;
            	document.getElementById('editStartLocation').value=source;
            	document.getElementById('editEndLocation').value=end;
            	document.getElementById('editDestination').value=distance;
            	document.getElementById('editDuration').value=duration;
            	var editModel=new bootstrap.Modal(document.getElementById('editModal'));
            	editModel.show();
            });
            });
            </script>
</body>
</html>