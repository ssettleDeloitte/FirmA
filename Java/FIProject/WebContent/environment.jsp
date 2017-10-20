<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="FirmProjectPackage.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/bootstrap.css" rel="stylesheet"/>
<link href="css/stylesheet.css" rel="stylesheet" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Environments</title>
</head>
<body>
<br>
<center>
<h1>Environments</h1>
<br>
<a href="index.jsp">Go back to home</a>
</center>

<br>
<br>
<%
ApplicationsDAO dao = new ApplicationsDAO();


//controller
//controller
//controller
String action = request.getParameter("action");
String name = request.getParameter("name");
String url = request.getParameter("url");
String id = request.getParameter("id");
Environment env = new Environment();


if("create".equals(action)){
	Environment en = new Environment(name, url);
	dao.create(en);
}else if("remove".equals(action)){
	int idInt = Integer.parseInt(id);
	dao.remove(idInt);
}else if("select".equals(action)){
	int idInt = Integer.parseInt(id);
	env = dao.selectOne(idInt);
}else if("update".equals(action))
{
	int idInt = Integer.parseInt(id);
	env = new Environment(name, url);
	dao.update(idInt, env);

}


List<Environment> environments = dao.selectAll();
%>

<form action="environment.jsp">

<input type="hidden" name="id" value="<%= env.getId() %>"/>

<table class="table">
<tr>
<td>Name <input name="name" class="form-control" value=<%= env.getName() %>/></td>
<td>URL <input name="url" class ="form-control" value=<%= env.getUrl() %>/></td>
<td>
<button class="btn" name="action" value="create">
Add
</button>
<button class="btn" name="action" value="update">
update
</button>
</td>
</tr>
<% for(Environment en: environments){
	%>
	<tr>
	<td><%=en.getName() %></td>
	<td><a href="<%=en.getUrl() %>"><%=en.getUrl() %></a></td>
	<td>
	<a href="environment.jsp?action=remove&id=<%= en.getId() %>">
	Delete
	</a>
	
	<a href="environment.jsp?action=select&id=<%=en.getId() %>">
	Select
	</a>
	</td>
	</tr>
	<%
}
	%>
</table>

</form>



</body>
</html>