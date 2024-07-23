<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/asserts/css/ManagerStyle.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <title>Absentee Calendar</title>
    <style>
    body {
        font-family: Arial, sans-serif;
    }

    .calendar {
        width: 70%;
        max-width: 400px;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        table-layout: fixed;
    }

    th, td {
        border: 1px solid #ddd;
        padding: 10px;
        text-align: center;
        width: 150px;
        height: 100px;
    }

    th {
        background-color: #f2f2f2;
    }

    td {
        cursor: pointer;
    }

    .absentees {
        margin: 20px auto;
        width: 80%;
        max-width: 600px;
    }

    .absent {
        background-color: #ff69b4;
        color: #fff;
        font-weight: bold;
        width: 50px;
        height: 30px;
        border-radius: 5px;
    }

    .absentees p {
        font-style: italic;
        color: #888;
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
            <a class="nav-link" href="index.jsp">Dashboard</a>
            <a class="nav-link" href="${pageContext.request.contextPath}/mprofile">Profile</a>
            <a class="nav-link" href="${pageContext.request.contextPath}/requestLeave">Leave Management</a>
            <a class="nav-link" href="${pageContext.request.contextPath}/viewTeam">View Team</a>
            <a class="nav-link active" href="${pageContext.request.contextPath}/calender">Calendar</a>
            <a class="nav-link" href="${pageContext.request.contextPath}/Logout">Logout</a>
        </nav>
        <div class="col-md-10 content">
            <div>
                <h1>Calendar</h1>
            </div>
            <div>
                <nav aria-label="breadcrumb">
                  <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/mdashboard">Dashboard</a></li>
                    <li class="breadcrumb-item active" aria-current="page">Calender</li>
                  </ol>
                </nav>
            </div>
            <hr>
            <div class="calendar">
                <%
                    Calendar cal = Calendar.getInstance();
                    int month = cal.get(Calendar.MONTH);
                    int year = cal.get(Calendar.YEAR);
                    cal.set(Calendar.DAY_OF_MONTH, 1);

                    int firstDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
                    int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
                    String monthName = new SimpleDateFormat("MMMM").format(cal.getTime());

                    out.println("<h2>" + monthName + " " + year + "</h2>");
                %>
                <table>
                    <thead>
                        <tr>
                            <th>Sun</th>
                            <th>Mon</th>
                            <th>Tue</th>
                            <th>Wed</th>
                            <th>Thu</th>
                            <th>Fri</th>
                            <th>Sat</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <%
                                for (int i = 1; i < firstDayOfWeek; i++) {
                                    out.println("<td></td>");
                                }
                                for (int day = 1; day <= daysInMonth; day++) {
                                    if ((day + firstDayOfWeek - 2) % 7 == 0) {
                                        out.println("</tr><tr>");
                                    }
                                    out.println("<td>" + day + "</td>");
                                }
                                for (int i = (firstDayOfWeek + daysInMonth - 1) % 7; i < 7 && i != 0; i++) {
                                    out.println("<td></td>");
                                }
                            %>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <script src="../../asserts/javascript/ManagerScript.js"></script>
</body>
</html>
