<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
table{
	padding: 30px;
	border: none;
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
<title>Seller Products</title>
</head>
<body>
<%@page import="java.util.List" %>
<%@page import="Entities.Product" %>
	<div align="center">
		<h1>
			Seller Products
		</h1>
		<table>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Price</th>
				<th>Description</th>
			</tr>
			
			<%
				List<Product> products = (List) request.getAttribute("products");
			%>
			
			<%
				for(Product p:products){
			%>
			
			<tr>
				<td><%=p.getID()%></td>
				<td><%=p.getName()%></td>
				<td><%=p.getPrice()%></td>
				<td><%=p.getDescription()%></td>
			</tr>
			
			<%
				}
			%>
		
		</table>
	</div>
</body>
</html>