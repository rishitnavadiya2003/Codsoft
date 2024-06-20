<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Marksheet</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: lightblue;
    }
    table {
        width: 80%;
        margin: 20px auto;
        border-collapse: collapse;
        border: 2px solid black;
    }
    th, td {
        border: 1px solid black;
        padding: 8px;
        text-align: center;
    }
    th {
        background-color: #f2f2f2;
    }
    input[type="text"] {
        width: calc(100% - 16px);
        padding: 6px;
        box-sizing: border-box;
    }
    
</style>
</head>
<body>
<table>
    <caption><b>${studentname} </b>Your Result Is <b> ${percentage}</b></caption>
    <tr>
        <th>Student Name</th>
        <td colspan="3"><b>${studentname}</b></td>
    </tr>
    <tr>
        <th>Roll Number</th>
        <td colspan="3">${rollnumber}</td>
    </tr>
    
    <tr>
        <th>Java</th>
        <td>${javaMarks}</td>
    </tr>
    
    <tr>   
        <th>Python</th>
        <td>${pythonMarks}</td>
    </tr> 
       
    <tr>   
        <th>ADBMS</th>
        <td>${adbmsMarks}</td>
   </tr> 
   
   <tr>   
        <th>HCI</th>
        <td>${hcimarks}</td>
   </tr>
   
   <tr>   
        <th>Total</th>
        <td>${totalmarks}</td>
   </tr>
   <tr>   
        <th>Percentage</th>
        <td>${percentage}</td>
   </tr>
   
   <tr>   
        <th>Grade</th>
        <td><b><i><u>${grade}</b></i></u></td>
   </tr>
 
</table>
</body>
</html>