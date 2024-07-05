<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<style>

table{
	padding: 30px;
}

td{
	padding: 30px;
	background-color: #DAE2B6;
}

th{
	padding: 20px;
	background-color: purple;
	color: white;
}

td:nth-child(even) {background-color: #9ED5C5;}

body, html {
  height: 100%;
  margin: 0;
}

body{
  background-image: url("../../../rainbow.webp");
  height: 100%; 
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Seller Orders</title>
</head>
<body>
<%@page import="java.util.List" %>
<%@page import="Entities.Order" %>
	<div>
		<div align="center">
		<h1>Seller Orders</h1>
			<table>
				<tr>
					<th>ID</th>
					<th>User ID</th>
					<th>User Email</th>
					<th>Product ID</th>
					<th>Product Name</th>
					<th>Product Price</th>
					<th>DOB</th>
				</tr>
				
			<%
				List<Order> orders = (List) request.getAttribute("orders");
			%>
			
			<%
				for(Order o:orders){
			%>
			
			<tr>
				<td><%=o.getID()%></td>
				<td><%=o.getUser_id()%></td>
				<td><%=o.getUser_email()%></td>
				<td><%=o.getProduct_id()%></td>
				<td><%=o.getProduct_name()%></td>
				<td><%=o.getProduct_price()%></td>
				<td><%=o.getDate()%></td>
			</tr>
			
			<%
				}
			%>
				
			</table>
		</div>
	</div>
</body>
</html>