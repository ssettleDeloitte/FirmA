<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="bootstrap.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
<center>
<h1>Home Page</h1>
<br>
</center>
<center>
<form action=environments.jsp>
<div class="form-group">
<button type="submit" class="btn btn-lg btn-primary">Environments</button>
</div>
</form>

<form action="servers.jsp">
<div class="form-group">
<button type="submit" class="btn btn-primary btn-lg">Servers</button>
</div>
</form>
<form action="logs.jsp">
<div class="form-group">
<button type="submit" class="btn btn-primary btn-lg">Logs</button>
</div>
</form>
</center>

</body>
</html>