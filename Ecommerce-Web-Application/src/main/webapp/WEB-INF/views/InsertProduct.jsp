<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<style>

body, html {
  height: 100%;
  margin: 0;
}

.submit_button{
	margin: 30px;
	padding: 10px 25px;
}
.box{
	border: 4px solid black;
	width : 400px;
	box-shadow: 7px 5px 30px 5px #aaaaaa;
	margin-top: 280px;
	color : black;
	padding: 40px
}
input{
	padding: 10px; 
	border: 1px solid black
}

table{
	font-size:20px;
}

body{
  background-image: url("../../../rainbow.webp");
  height: 100%; 
  background-position: center;
  background-size: cover;
}

.submit_button:hover{
	background-color:#F47C7C;
}

</style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert Product</title>
</head>
<body>
	<div align="center">
		<div class="box">
		<h1>Insert Product</h1>
		<form action="/Products" method="post">
	
			<table>
			
				<tr>
					<td>Name : </td>
					<td><input type="text" name="name"/></td>
				</tr>
				
				<tr>
					<td>price : </td>
					<td><input type="text" name="price"/></td>
				</tr>
				
				<tr>
					<td>description : </td>
					<td><input type="text" name="description"/></td>
				</tr>
				
			</table> <br/>
			
			<input class="submit_button" type="submit" value="Add Product" /> 
	
		</form>
		</div>
	</div>
</body>
</html>