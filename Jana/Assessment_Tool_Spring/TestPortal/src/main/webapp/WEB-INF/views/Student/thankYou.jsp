<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%  HttpSession session1 = request.getSession(); 
    if (session == null || session.getAttribute("email") == null) {
        response.sendRedirect(request.getContextPath() + "/loginPage");
        return;
    } %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thank You</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container text-center mt-5">
        <h1>Thank You for Taking the Assessment</h1>
        <p>Your responses have been recorded.</p>
        <button class="btn btn-primary" onclick="redirectToHome()">Go to Home</button>
    </div>
    <script>
        function redirectToHome() {
            window.location.href = "/TestPortal/student/home";
        }

        // Prevent back navigation
        (function (global) {
            if (typeof (global) === "undefined") {
                throw new Error("window is undefined");
            }

            var _hash = "!";
            var noBackPlease = function () {
                global.location.href += "#";

                // Making sure we have the fruit available for juice (^__^)
                global.setTimeout(function () {
                    global.location.href += "!";
                }, 50);
            };

            global.onhashchange = function () {
                if (global.location.hash !== _hash) {
                    global.location.hash = _hash;
                }
            };

            global.onload = function () {
                noBackPlease();

                // Disables backspace on page except on input fields and text areas
                document.body.onkeydown = function (e) {
                    var elm = e.target.nodeName.toLowerCase();
                    if (e.which === 8 && (elm !== 'input' && elm !== 'textarea')) {
                        e.preventDefault();
                    }
                    // Stopping the event bubble up to window
                    e.stopPropagation();
                };
            };
        })(window);
    </script>
</body>
</html>
