<%@page import="in.pentagon.studentapp.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Dash board</title>
  <style>
    body {
      margin: 0;
      font-family: Arial, sans-serif;
      background: #fff;
    }
    /* Header */
    .header {
      display: flex;
      justify-content: space-between;
      align-items: center;
      background: #1f1f1f;
      color: white;
      padding: 12px 30px;
    }
    .header .left {
      font-size: 18px;
      font-weight: bold;
    }
    .header .right {
      display: flex;
      gap: 20px;
      align-items: center;
    }
    .header .right a {
      color: white;
      text-decoration: none;
      font-size: 14px;
    }
    .header .right .logout {
      background: red;
      padding: 6px 14px;
      border: none;
      color: white;
      cursor: pointer; 
      border-radius: 4px;
      font-size: 14px;
    }
    /* Dashboard Title */
    h2 {
      text-align: center;
      font-size: 28px;
      margin: 30px 0 20px;
    }
    /* Data Section */
    .section {
      width: 90%;
      max-width: 1200px;
      margin: auto;
    }
    .section h3 {
      font-size: 20px;
      margin-bottom: 10px;
    }
    /* Table */
    table {
      width: 100%;
      border-collapse: collapse;
      margin-bottom: 30px;
    }
    table, th, td {
      border: 1px solid #ddd;
    }
    th, td {
      padding: 12px;
      text-align: left;
      font-size: 16px;
    }
    th {
      background: #f9f9f9;
      font-weight: bold;
    }
    /* Search */
    .search-box {
      margin: 20px 0;
    }
    .search-box label {
      font-size: 16px;
    }
    .search-box input {
      padding: 6px;
      margin-left: 10px;
      border: 1px solid #ccc;
      border-radius: 4px;
      width: 250px;
    }
    .search-box button {
      padding: 7px 16px;
      background: #007bff;
      color: white;
      border: none;
      border-radius: 4px;
      cursor: pointer;
      margin-left: 5px;
    }
    .search-box button:hover {
      background: #0056b3;
    }
    .search-table td {
      text-align: center;
      color: #555;
    }
  </style>
</head>
<body>

<%if(session.getAttribute("student")!=null){ %>
<% Student s= (Student)session.getAttribute("student");%>


  <div class="header">
    <div class="left">Welcome <%= s.getName() %></div>
    <div class="right">
      <a href="#">View Users</a>
      <a href="#">Reset Password</a>
      <a href="update.jsp">Update Data</a>
      <button class="logout">Logout</button>
    </div>
  </div>

  <h2>Dashboard</h2>

  <div class="section">
    <h3>View Your Data</h3>
    <table>
      <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Phone</th>
        <th>Mail ID</th>
        <th>Branch</th>
        <th>Location</th>
      </tr>
      <tr>
         <td><%= s.getId() %></td>
        <td><%= s.getName()%></td>
        <td><%= s.getPhone()%></td>
        <td><%= s.getMail() %></td>
        <td><%= s.getBranch()%></td>
        <td><%= s.getLoc()%></td>
      </tr>
    </table>

    <h3>Search user</h3>
    <div class="search-box">
      <label>Enter the name of the student here:</label>
      <input type="text">
      <button>search</button>
    </div>

    <table class="search-table">
      <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Branch</th>
        <th>Location</th>
      </tr>
      <tr>
        <td colspan="4">Search for users!</td>
      </tr>
    </table>
  </div>
  
 <%
}
else{
	request.setAttribute("error","session expired");
	RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
	rd.forward(request, response);
}
%>
  
  

</body>
</html>

