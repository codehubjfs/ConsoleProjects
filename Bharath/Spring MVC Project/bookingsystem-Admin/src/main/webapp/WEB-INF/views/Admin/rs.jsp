<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
    <title>Routes</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.6.0/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX" crossorigin="anonymous">
    <style>
        .table-container {
            max-width: 800px;
            margin: auto;
            margin-top: 20px;
        }
        .edit-icon {
            cursor: pointer;
        }
        .action-column {
            display: flex;
            justify-content: space-around;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="table-container">
            <h1>Routes</h1>
            <button type="button" class="btn btn-primary mb-3" onclick="location.href='addRoute.jsp'">Add Route</button>
            <table class="table table-bordered table-striped">
                <thead class="thead-dark">
                    <tr>
                        <th>Route ID</th>
                        <th>Start Location</th>
                        <th>End Location</th>
                        <th>Distance</th>
                        <th>Estimated Duration</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${routeList}" var="route">
                        <tr>
                            <td>${route.routeID}</td>
                            <td>${route.startLocation}</td>
                            <td>${route.endLocation}</td>
                            <td>${route.distance}</td>
                            <td>${route.estimatedDuration}</td>
                            <td class="action-column">
                                <div class="bi bi-pencil-square edit-icon" onclick="openEditModal('${route.routeID}', '${route.startLocation}', '${route.endLocation}', '${route.destination}', '${route.duration}')"></div>
                                <div class="bi bi-trash delete-icon" onclick="deleteRoute('${route.routeID}')"></div>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <!-- Edit Route Modal -->
    <div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="editModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="editModalLabel">Edit Route</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="closeEditRouteModal()">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form id="editForm" action="${pageContext.request.contextPath}/EditRoutesController" method="post">
                        <input type="hidden" id="editRouteID" name="routeID">
                        <div class="form-group">
                            <label for="editStartLocation">Start Location</label>
                            <input type="text" id="editStartLocation" name="startLocation" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="editEndLocation">End Location</label>
                            <input type="text" id="editEndLocation" name="endLocation" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="editDestination">Destination</label>
                            <input type="text" id="editDestination" name="destination" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="editDuration">Duration</label>
                            <input type="text" id="editDuration" name="duration" class="form-control">
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary" onclick="saveChanges()">Save changes</button>
                </div>
            </div>
        </div>
    </div>

    <!-- jQuery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha384-XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX" crossorigin="anonymous"></script>
    <!-- Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.6.0/js/bootstrap.min.js" integrity="sha384-XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX" crossorigin="anonymous"></script>

    <script>
        function openEditModal(routeID, startLocation, endLocation, destination, duration) {
            document.getElementById('editRouteID').value = routeID;
            document.getElementById('editStartLocation').value = startLocation;
            document.getElementById('editEndLocation').value = endLocation;
            document.getElementById('editDestination').value = destination;
            document.getElementById('editDuration').value = duration;
            $('#editModal').modal('show');
        }

        function closeEditRouteModal() {
            $('#editModal').modal('hide');
        }

        function saveChanges() {
            document.getElementById('editForm').submit();
        }

        function deleteRoute(routeID) {
            if(confirm("Are you sure you want to delete this route?")) {
                window.location.href = "${pageContext.request.contextPath}/DeleteRoutesController?routeID=" + routeID;
            }
        }
        <script>
        function editAvailability(element) {
            var modal = document.getElementById("editModal");
            modal.style.display = "block";
            
            var row = element.closest("tr");
            var data = {
                id: row.cells[0].innerText,
                from: row.cells[1].innerText,
                to: row.cells[2].innerText,
                distance: row.cells[3].innerText,
                duration: row.cells[4].innerText,
                availability: row.cells[5].innerText
            };
            
            document.getElementById("fromLocation").value = data.from;
            document.getElementById("toLocation").value = data.to;
            document.getElementById("distance").value = data.distance;
            document.getElementById("estimatedDuration").value = data.duration;
            document.getElementById("availability").value = data.availability;
        }

        function closeModal() {
            var modal = document.getElementById("editModal");
            modal.style.display = "none";
            
            // Clear previous error messages when closing the modal
            document.getElementById("fromLocationError").textContent = "";
            document.getElementById("toLocationError").textContent = "";
            document.getElementById("distanceError").textContent = "";
            document.getElementById("estimatedDurationError").textContent = "";
            document.getElementById("availabilityError").textContent = "";
        }

        function saveChanges() {
            // Validate form inputs
            var isValid = validateForm();
            
            if (isValid) {
                var fromLocation = document.getElementById("fromLocation").value;
                var toLocation = document.getElementById("toLocation").value;
                var distance = document.getElementById("distance").value;
                var estimatedDuration = document.getElementById("estimatedDuration").value;
                var availability = document.getElementById("availability").value;
                
                var table = document.querySelector("table");
                var row = table.rows[1];  // Assuming you are editing the first row
                
                row.cells[1].innerText = fromLocation;
                row.cells[2].innerText = toLocation;
                row.cells[3].innerText = distance;
                row.cells[4].innerText = estimatedDuration;
                row.cells[5].innerText = availability;
                
                closeModal();
            }
        }
    </script>
</body>
</html>
