<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="FirmProjectPackage.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Environments</title>
</head>


<body>
<h1>Hello World from JSP</h1>




	<ul>
<%
Hello hello = new Hello();

String message = hello.sayHello("Cody");

	for(int i = 0; i<10;i++)
	{
		%>
		<li><%=message%> Server Side Rendering Rocks <%=i %></li>
		<% 
	}
%>
</ul>
</body>
</html>