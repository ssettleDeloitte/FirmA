<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/bootstrap.css" rel="stylesheet"/>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<br>
<h1>Login</h1>
<br><br>
<form action="Login" method="post">

<table class="table">
<!-- <tr>
<td>First Name: <input class="form-control" type="text" name="fname"></td>
</tr>
<tr>
<td>Last Name: <input class="form-control" type="text" name="lname"></td>
</tr> -->
<tr>
<td>User name: <input class="form-control" type="text" name="username"></td>
</tr>
<!-- <tr>
<td>Email: <input class="form-control" type="email" name="email"></td>
</tr> -->
<tr>
<td>Password: <input class="form-control" type="password" name="password"></td>
</tr>

</table>
<center>
<input type="submit" value="LOGIN">
</center>
</form>