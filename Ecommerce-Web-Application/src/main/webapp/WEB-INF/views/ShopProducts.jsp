<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE htmL>
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

body, html {
  height: 100%;
  margin: 0;
}

body{
  background-image: url("../../../rainbow.webp");
  height: 100%; 
  background-position: center;
  background-size: cover;
}

input{
	padding: 10px 30px;
	border-radius : 10px;
	border : 1px solid black;
	color : white;
	background-color: indigo;
}

input:hover{
	background-color: blue;
}

td:nth-child(even) {background-color: #9ED5C5;}

.buy{
	background-color: purple;
}

</style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Shop Products</title>
</head>
<body>
<%@page import="java.util.List" %>
<%@page import="Entities.Product" %>
	<div align="center">
		<h1>
			Shop Products
		</h1>
		
		<table>
			<%
				List<Product> products = (List) request.getAttribute("products");
			%>
			
			<tr>
				<th>ID</th>
				<th>Image</th>
				<th>Name</th>
				<th>Price</th>
				<th>Description</th>
				<th>Seller ID</th>
				<th>Seller Email</th>
				<th>Click To Buy</th>
			</tr>
			
			<%
				for(Product p:products){
			%>
			
			<tr>
				<td><%=p.getID()%></td>
				<td><img src="../../../rohit images/<%=p.getName()%>" height=200px width=200px /> </td>
				<td><%=p.getName()%></td>
				<td><%=p.getPrice()%></td>
				<td><%=p.getDescription()%></td>
				<td><%=p.getSeller_id()%></td>
				<td><%=p.getSeller_email()%></td>
				<td class="buy"><input type="button" onclick="window.location.href='http://localhost:8080/checkout?product_id=<%=p.getID()%>'" value="Buy Now"/></td>
			</tr>
			
			<%
				}
			%>
		
		</table>
	</div>
</body>
</html>