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
<title>Homepage</title>
</head>
<body>
	<div align="center" class="bg">
		<h1>HCU Grocery Market</h1>
		<button type="button" onclick="window.location.href='user/login'">
			<img src="../../user-login.png" height=200px width=200px /> <br/>
			User Login
		</button>
		<button type="button" onclick="window.location.href='user/register'">
			<img src="../../user-register.webp" height=200px width=200px /> <br/>
			User Register
		</button>
		<button type="button" onclick="window.location.href='seller/login'">
			<img src="../../seller-login.png" height=200px width=200px /> <br/>
			Seller Login
		</button>
		<button type="button" onclick="window.location.href='seller/register'">
			<img src="../../seller-regiser.webp" height=200px width=200px /> <br/>
			Seller Register
		</button>
	</div>
</body>
</html>