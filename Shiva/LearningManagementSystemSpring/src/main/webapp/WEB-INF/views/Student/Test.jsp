<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Java OOP Quiz</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .timer {
            font-size: 20px;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <div class="card">
            <div class="card-header">
                Java Object Oriented Programming Quiz
                <span id="timer" class="float-right timer">Time Left: <span id="time">10:00</span></span>
            </div>
            <div class="card-body">
                <form id="quizForm" action="${pageContext.request.contextPath}/StudentMarkCalc">
                <%@page import="java.util.*,com.spring.model.TestBean" %>
                <% ArrayList <TestBean> testList=(ArrayList<TestBean>) request.getAttribute("questionsList");%>
                    <% for(TestBean t:testList) {%>
                    <div class="form-group">
                        <label><%=t.getQuestion() %></label>
                        <div>
                            <input type="radio" name="<%=t.getQuestionId() %>"  value="a"> a) <%=t.getOptionA() %><br>
                            <input type="radio" name="<%=t.getQuestionId() %>" value="b"> b) <%=t.getOptionB() %><br>
                            <input type="radio" name="<%=t.getQuestionId() %>" value="c"> c) <%=t.getOptionC() %><br>
                            <input type="radio" name="<%=t.getQuestionId() %>" value="d"> d) <%=t.getOptionD() %><br>
                        </div>
                    </div>
                    <%} %>
                    <!--  <div class="form-group">
                        <label>2. What is Inheritance in Java?</label>
                        <div>
                            <input type="radio" name="question2" value="a"> a) The ability of one class to inherit another class<br>
                            <input type="radio" name="question2" value="b"> b) The ability of one class to extend another class<br>
                            <input type="radio" name="question2" value="c"> c) Both a and b<br>
                            <input type="radio" name="question2" value="d"> d) None of the above<br>
                        </div>
                    </div>
                    <div class="form-group">
                        <label>3. What is polymorphism in Java?</label>
                        <div>
                            <input type="radio" name="question3" value="a"> a) The ability of a variable, function or object to take multiple forms<br>
                            <input type="radio" name="question3" value="b"> b) The ability of a class to have multiple subclasses<br>
                            <input type="radio" name="question3" value="c"> c) The ability of a function to have multiple implementations<br>
                            <input type="radio" name="question3" value="d"> d) None of the above<br>
                        </div>
                    </div>
                    <div class="form-group">
                        <label>4. What is encapsulation in Java?</label>
                        <div>
                            <input type="radio" name="question4" value="a"> a) The bundling of data and methods that operate on the data<br>
                            <input type="radio" name="question4" value="b"> b) The ability to hide internal implementation details<br>
                            <input type="radio" name="question4" value="c"> c) Both a and b<br>
                            <input type="radio" name="question4" value="d"> d) None of the above<br>
                        </div>
                    </div>
                    <div class="form-group">
                        <label>5. What is an abstract class in Java?</label>
                        <div>
                            <input type="radio" name="question5" value="a"> a) A class that cannot be instantiated<br>
                            <input type="radio" name="question5" value="b"> b) A class that can have abstract methods<br>
                            <input type="radio" name="question5" value="c"> c) Both a and b<br>
                            <input type="radio" name="question5" value="d"> d) None of the above<br>
                        </div>
                    </div>
                    <div class="form-group">
                        <label>6. What is an interface in Java?</label>
                        <div>
                            <input type="radio" name="question6" value="a"> a) A class that implements methods<br>
                            <input type="radio" name="question6" value="b"> b) A reference type in Java<br>
                            <input type="radio" name="question6" value="c"> c) A class that cannot be instantiated<br>
                            <input type="radio" name="question6" value="d"> d) None of the above<br>
                        </div>
                    </div>
                    <div class="form-group">
                        <label>7. What is method overloading in Java?</label>
                        <div>
                            <input type="radio" name="question7" value="a"> a) Defining multiple methods with the same name but different parameter lists<br>
                            <input type="radio" name="question7" value="b"> b) Defining multiple methods with the same name and same parameter lists<br>
                            <input type="radio" name="question7" value="c"> c) Defining a method in a subclass that already exists in the parent class<br>
                            <input type="radio" name="question7" value="d"> d) None of the above<br>
                        </div>
                    </div>
                    <div class="form-group">
                        <label>8. What is method overriding in Java?</label>
                        <div>
                            <input type="radio" name="question8" value="a"> a) Defining multiple methods with the same name but different parameter lists<br>
                            <input type="radio" name="question8" value="b"> b) Defining multiple methods with the same name and same parameter lists<br>
                            <input type="radio" name="question8" value="c"> c) Defining a method in a subclass that already exists in the parent class<br>
                            <input type="radio" name="question8" value="d"> d) None of the above<br>
                        </div>
                    </div>
                    <div class="form-group">
                        <label>9. What is a constructor in Java?</label>
                        <div>
                            <input type="radio" name="question9" value="a"> a) A special method that is called when an object is instantiated<br>
                            <input type="radio" name="question9" value="b"> b) A method that is called to destroy an object<br>
                            <input type="radio" name="question9" value="c"> c) A method that initializes the instance variables of a class<br>
                            <input type="radio" name="question9" value="d"> d) Both a and c<br>
                        </div>
                    </div>
                    <div class="form-group">
                        <label>10. What is the 'this' keyword in Java?</label>
                        <div>
                            <input type="radio" name="question10" value="a"> a) A reference to the current object<br>
                            <input type="radio" name="question10" value="b"> b) A reference to the parent object<br>
                            <input type="radio" name="question10" value="c"> c) A reference to the static object<br>
                            <input type="radio" name="question10" value="d"> d) None of the above<br>
                        </div>
                    </div>
                    <div class="form-group">
                        <label>11. What is the default access modifier in Java?</label>
                        <div>
                            <input type="radio" name="question11" value="a"> a) public<br>
                            <input type="radio" name="question11" value="b"> b) private<br>
                            <input type="radio" name="question11" value="c"> c) protected<br>
                            <input type="radio" name="question11" value="d"> d) package-private<br>
                        </div>
                    </div>
                    <div class="form-group">
                        <label>12. What is a static method in Java?</label>
                        <div>
                            <input type="radio" name="question12" value="a"> a) A method that can be called without creating an instance of the class<br>
                            <input type="radio" name="question12" value="b"> b) A method that can only be called with an instance of the class<br>
                            <input type="radio" name="question12" value="c"> c) A method that can access instance variables<br>
                            <input type="radio" name="question12" value="d"> d) None of the above<br>
                        </div>
                    </div>
                    <div class="form-group">
                        <label>13. What is a final class in Java?</label>
                        <div>
                            <input type="radio" name="question13" value="a"> a) A class that cannot be extended<br>
                            <input type="radio" name="question13" value="b"> b) A class that can be extended<br>
                            <input type="radio" name="question13" value="c"> c) A class that cannot be instantiated<br>
                            <input type="radio" name="question13" value="d"> d) None of the above<br>
                        </div>
                    </div>
                    <div class="form-group">
                        <label>14. What is a package in Java?</label>
                        <div>
                            <input type="radio" name="question14" value="a"> a) A collection of classes<br>
                            <input type="radio" name="question14" value="b"> b) A collection of related classes and interfaces<br>
                            <input type="radio" name="question14" value="c"> c) A namespace for organizing classes and interfaces<br>
                            <input type="radio" name="question14" value="d"> d) All of the above<br>
                        </div>
                    </div>
                    <div class="form-group">
                        <label>15. What is an inner class in Java?</label>
                        <div>
                            <input type="radio" name="question15" value="a"> a) A class defined inside another class<br>
                            <input type="radio" name="question15" value="b"> b) A class that can access the members of the outer class<br>
                            <input type="radio" name="question15" value="c"> c) Both a and b<br>
                            <input type="radio" name="question15" value="d"> d) None of the above<br>
                        </div>
                    </div>-->
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
                <div id="result" class="mt-3"></div>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script>
        // Timer
        let totalTime = 2 * 60; // 10 minutes
        let timerInterval = setInterval(function() {
            let minutes = Math.floor(totalTime / 60);
            let seconds = totalTime % 60;
            seconds = seconds < 10 ? '0' + seconds : seconds;
            document.getElementById('time').textContent = minutes + ":" + seconds;
            if (totalTime <= 0) {
                clearInterval(timerInterval);
                alert("Time's up! Submitting the test.");
                document.getElementById('quizForm').submit();
            }
            totalTime--;
        }, 1000);

        
    </script>
</body>
</html>
