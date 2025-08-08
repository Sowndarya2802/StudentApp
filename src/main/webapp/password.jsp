<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <title>Reset Password</title>
 <style>
    body {
        margin: 0;
        padding: 0;
        font-family: Arial, sans-serif;
        background-color: #ffffff;
    }
    h1 {
        text-align: center;
        color: #2b4eff;
        margin-top: 50px;
        margin-bottom: 5px;
    }
    h2 {
        text-align: center;
        color: #5a8dee;
        font-size: 20px;
        margin-bottom: 40px;
    }
    .failure{
    color:red;
    }
    form {
        width: 500px;
        margin: auto;
        font-size: 16px;
    }
    label {
        display: inline-block;
        width: 200px;
        text-align: right;
        margin-right: 10px;
        margin-bottom: 15px;
    }
    input[type="text"], input[type="password"] {
        width: 250px;
        height: 28px;
        padding: 5px;
        border: 1px solid #ccc;
        border-radius: 4px;
        margin-bottom: 15px;
    }
    .btn-green {
        display: inline-block;
        width: 150px;
        height: 35px;
        background-color: #28a745;
        color: white;
        border: none;
        border-radius: 4px;
        font-size: 16px;
        cursor: pointer;
        margin-left: 210px;
        margin-top: 10px;
    }

    .btn-blue {
        display: inline-block;
        width: 80px;
        height: 35px;
        background-color: #2b4eff;
        color: white;
        border: none;
        border-radius: 4px;
        font-size: 16px;
        cursor: pointer;
        margin-left: 10px;
    }
    
 </style>
</head>
<body>

    <h1>Pentagon Space</h1>
    <h2>Reset your password here</h2>
    
    <%if(request.getAttribute("error")!=null){%>
    <h3 class="failure"><%=request.getAttribute("error") %></h3>
    <%} %>
    

    <form action="password" method="post">
        <div>
            <label>Enter the Phone number:</label>
            <input type="text" name="phone">
        </div>
        <div>
            <label>Enter the Mail ID:</label>
            <input type="text" name="mail">
        </div>
        <div>
            <label>Enter the password:</label>
            <input type="password" name="password">
        </div>
        <div>
            <label>Confirm the password:</label>
            <input type="password" name="confirm">
        </div>
        <div>
            <button class="btn-green" type="submit" ><a href="login.jsp">Reset Password</a></button>
           
        </div>
    </form>

</body>
</html>













    