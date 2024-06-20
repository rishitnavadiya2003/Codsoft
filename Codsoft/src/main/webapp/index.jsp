<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quiz Application</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            padding: 50px;
        }
        h1 {
            margin-bottom: 20px;
        }
        .button {
            display: inline-block;
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            font-size: 16px;
            margin-top: 20px;
            cursor: pointer;
            border-radius: 5px;
        }
        .button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h1>Welcome to the Quiz Application</h1>
    <p>This is a quiz to test your knowledge. Are you ready?</p>
    <a href="quiz" class="button">Start Quiz</a>
</body>
</html>
