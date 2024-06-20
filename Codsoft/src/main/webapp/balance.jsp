<%@page import="com.servlet.BankAccount"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<%
    HttpSession s = request.getSession();
    BankAccount account = (BankAccount) s.getAttribute("account");
    if (account == null) {
        account = new BankAccount(1000); // Initial balance of INR 1000
        s.setAttribute("account", account);
    }

    double balance = account.getBalance();
%>
<!DOCTYPE html>
<html>
<head>
    <title>Balance</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
            text-align: center;
        }
        h1 {
            color: #333;
        }
        p {
            font-size: 18px;
            color: #555;
        }
        a {
            display: inline-block;
            margin-top: 20px;
            text-decoration: none;
            color: #4CAF50;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Your Balance</h1>
        <p>Current Balance: INR <%= balance %></p>
        <a href="ATM.html">Back to ATM Menu</a>
    </div>
</body>
</html>
