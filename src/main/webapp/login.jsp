<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <title>Login</title>
 <style>
    body {
        margin: 0;
        padding: 0;
        font-family: Arial, sans-serif;
        background-color: #ffffff;
        text-align: center;
    }
    h1 {
        color: #2b4eff; 
        margin-top: 80px;
    }
    h2 {
        color: #555;
        font-size: 20px;
        margin-bottom: 30px;
    }
    input[type="email"], input[type="password"] {
        height: 35px;
        width: 300px;
        padding: 5px;
        margin: 10px 0;
        border: 1px solid #ccc;
        border-radius: 4px;
        font-size: 16px;
    }
    button {
        height: 35px;
        width: 310px;
        border: none;
        border-radius: 4px;
        background-color: #28a745; /* Green button */
        color: white;
        font-size: 16px;
        cursor: pointer;
        margin-top: 15px;
    }
    .success{
    color:green;
    }
    
    .failure{
    color:red;
    }
    
    
    button:hover {
        background-color: #218838;
    }
    p {
        font-size: 14px;
        margin-top: 15px;
    }
    a {
        color: #2b4eff;
        text-decoration: none;
    }
    a:hover {
        text-decoration: underline;
    }
 </style>
</head>
<body>


    <h1>Pentagon Space</h1>
    <h2>Login</h2>
    
    <%if(request.getAttribute("success")!=null){%>
    <h3 class="success"><%=request.getAttribute("success") %></h3>
    <%} %>
    
    
    <%if(request.getAttribute("successpass")!=null){ %>
    <h3 class="success"><%=request.getAttribute("successpass") %></h3>
    <%} %>
    
    <%if(request.getAttribute("error")!=null){ %>
    <h3 class="failure"><%=request.getAttribute("error") %></h3>
    <%} %>
    
    
    <form action="login" method="post">
    
    
    
        <label>Email</label><br>
        <input type="email" name="mail" placeholder="Enter your email id"><br>
        <label>Password</label><br>
        <input type="password" name="password" placeholder="Enter your password"><br>
        <button>Login</button>
    </form>
    <p><a href="password.jsp">Forgot Password?</a></p>
    <p>Don't have an account? <a href="signup.jsp">Sign up here</a></p>

</body>
</html>
    