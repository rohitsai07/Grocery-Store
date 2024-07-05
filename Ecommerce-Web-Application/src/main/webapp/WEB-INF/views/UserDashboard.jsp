<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style type="text/css">

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

button{
	height : 300px;
	width: 300px;
	font-size: 25px;
	margin: 30px;
}

button:hover{
	background-color : orange;
}

</style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Dashboard</title>
</head>
<body>
	<div align="center">
		<h1>
			User Dashboard
		</h1>
		<button type="button" onclick="window.location.href='http://localhost:8080/profile'">
			<img src="../../user-login.png" height=200px width=200px /> <br/>
			View My Profile
		</button>
		<button type="button" onclick="window.location.href='http://localhost:8080/Products'">
			<img src="../../cart.png" height=200px width=200px /> <br/>
			Shop Products
		</button>
		<button type="button" onclick="window.location.href='http://localhost:8080/orders'" >
			<img src="../../orders.png" height=200px width=200px /> <br/>
			View My Orders
		</button>
		<button type="button" onclick="window.location.href='http://localhost:8080/logout'" >
			<img src="../../logout.png" height=200px width=200px /> <br/>
			Logout
		</button>
	</div>
</body>
</html>