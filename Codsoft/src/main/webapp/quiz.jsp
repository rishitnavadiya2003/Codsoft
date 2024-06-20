<%@page import="com.servlet.Question"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <meta charset="UTF-8">
    <title>Quiz</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .quiz-container {
            width: 50%;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }
        .question {
            font-size: 20px;
            margin-bottom: 20px;
        }
        .options {
            list-style-type: none;
            padding: 0;
        }
        .options li {
            margin-bottom: 10px;
        }
    </style>
    <script>
        let timeLeft = 15; // seconds
        let timerInterval = setInterval(function() {
            document.getElementById('timer').textContent = timeLeft;
            timeLeft--;
            if (timeLeft < 0) {
                clearInterval(timerInterval);
                document.getElementById('quizForm').submit();
                alert('Time is up! The quiz will now close.');
                window.close(); // Close the quiz window
            }
        }, 1000);
    </script>
</head>
<body>
    <div class="quiz-container">
        <form id="quizForm" action="quiz" method="post">
            <div class="question">
                <%= ((Question)request.getAttribute("question")).getQuestion() %>
            </div>
            <ul class="options">
                <% String[] options = ((Question)request.getAttribute("question")).getOptions(); %>
                <% for (int i = 0; i < options.length; i++) { %>
                    <li>
                        <input type="radio" id="option<%= i %>" name="answer" value="<%= i %>" required>
                        <label for="option<%= i %>"><%= options[i] %></label>
                    </li>
                <% } %>
            </ul>
            <div>
                Time left: <span id="timer">15</span> seconds
            </div>
            <button type="submit">Submit</button>
        </form>
    </div>
</body>
</html>
