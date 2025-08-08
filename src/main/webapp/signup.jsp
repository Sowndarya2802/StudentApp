<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <title>Application Form</title>
 <style>
    body {
        margin: 0;
        padding: 0;
        font-family: Arial, sans-serif;
        background-color: #ffffff;
    }
    h1 {
        text-align: center;
        color: #2b4eff; /* Pentagon Space Blue */
        margin-top: 50px;
        margin-bottom: 5px;
    }
    h2 {
        text-align: center;
        color: #5a8dee; /* lighter blue */
        font-size: 20px;
        margin-bottom: 40px;
    }
    form {
        width: 500px;
        margin: auto;
        font-size: 16px;
    }
    label {
        display: inline-block;
        width: 200px;
        text-align: left;
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
    .failure{
    color:red;
    }
    .btn {
        display: inline-block;
        width: 150px;
        height: 35px;
        background-color: #2b4eff;
        color: white;
        border: none;
        border-radius: 4px;
        font-size: 16px;
        margin-left: 50px;
        margin-top: 10px;
    }
    .btn:hover {
        background-color: #1e3fcc;
    }
    .login-link {
        margin-left: 10px;
        font-size: 14px;
    }
    .login-link a {
        color: #2b4eff;
        text-decoration: none;
    }
    .login-link a:hover {
        text-decoration: underline;
    }
 </style>
</head>
<body>

    <h1>Pentagon Space</h1>
    <h2>Application form</h2>
    <%if(request.getAttribute("error")!=null){%>
    <h3 class="failure"><%=request.getAttribute("error") %></h3>
    <%} %>

    <form action="signup" method="post">
    
        <div>
            <label>Enter your Name:</label>
            <input type="text" name="name">
        </div>
        <div>
            <label>Enter the Phone number:</label>
            <input type="text" name="phone">
        </div>
        <div>
            <label>Enter the Mail ID:</label>
            <input type="text" name="mail">
        </div>
       <div>
        <label>Enter the Branch:</label>
        <select name="branch">
            <option value="">-- Select Branch --</option>
            <option value="CSE">CSE</option>
            <option value="ECE">ECE</option>
            <option value="ME">Mech</option>
            <option value="CE">Civil</option>
            <option value="IS">ISE</option>
        </select>
        </div>

        <div>
            <label>Enter the Location:</label>
            <input type="text" name="loc">
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
            <button class="btn" type="submit">Create Account</button>
            <span class="login-link">already have an account? <a href="login.jsp">login</a></span>
        </div>
    </form>

</body>
</html>
    