<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	background-color: lightblue;
	border: 1px solid black;
	border-radius: 10px;
	padding: 20px 40px;
	font-size: 20px;
}

.submit_button:hover{
	background-color: white;
}

.box{
	border: 4px solid white;
	width : 400px;
	margin-top: 150px;
	color : white;
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
  background-image: url("../../../darkgreen.webp");
  height: 100%; 
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
}

img{
	margin: 15px;
	margin-bottom: 40px;
}

</style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Login</title>
</head>
<body>
	<center>
	<div align="center">
		<div class = "box"> 
		
		<h1>User Login</h1>
		
		<form action="/UserLogin" method="post">
			<img src="../../user-login.png" height=200px width=200px />
			<table>
				<tr>
					<td>
						Email :
					</td>
					<td>
						<input type="text" name="email" />
					</td>
				</tr>
				
				<tr>
					<td>
						Password :
					</td>
					<td>
						<input type="text" name="password" />
					</td>
				</tr>
			</table>
			
			<input class="submit_button" type="submit" value="Login"/>
		</form>
	</div>
	</div>
	</center>
</body>
</html>