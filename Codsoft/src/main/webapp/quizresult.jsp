<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.servlet.Question" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quiz Result</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .result-container {
            width: 50%;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }
        .question {
            font-size: 18px;
            margin-bottom: 10px;
        }
        .options {
            list-style-type: none;
            padding: 0;
            margin-bottom: 20px;
        }
        .options li {
            margin-bottom: 5px;
        }
        .correct {
            color: green;
        }
        .incorrect {
            color: red;
        }
    </style>
</head>
<body>
    <div class="result-container">
        <h1>Quiz Result</h1>
        <% 
            Integer score = (Integer) request.getAttribute("score");
            List<Question> questions = (List<Question>) request.getAttribute("questions");
            if (score != null && questions != null) {
        %>
            <p>Your Score: <%= score %> / <%= questions.size() %></p>
            <%
                for (int i = 0; i < questions.size(); i++) {
                    Question question = questions.get(i);
                    String[] options = question.getOptions();
                    int correctAnswerIndex = question.getCorrectAnswerIndex();
            %>
                <div class="question">
                    <%= "Question " + (i + 1) + ": " + question.getQuestion() %>
                </div>
                <ul class="options">
                    <% for (int j = 0; j < options.length; j++) { %>
                        <li class="<%= j == correctAnswerIndex ? "correct" : "" %>">
                            <%= options[j] %>
                        </li>
                    <% } %>
                </ul>
            <% 
                }
            } else {
            %>
            <p>No quiz results found.</p>
        <% } %>
    </div>
</body>
</html>
