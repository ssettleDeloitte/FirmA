<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="FirmProjectPackage.*" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%

String action = request.getParameter("action");
String name = request.getParameter("name");
String location = request.getParameter("location");
String id = request.getParameter("id");
Database env = new Database();
String search = request.getParameter("search");
List<Database> s = new ArrayList<Database>();

DatabaseDAO dao = new DatabaseDAO();

if("search".equals(action))
{
	s = dao.search();
}




%>


<form action="searchDb.jsp">

<input type="hidden" name="id" value="<%= env.getId() %>"/>

<table class="table">
<tr>
<td>Name <input name="name" class="form-control" value=<%= env.getName() %>/></td>
<td>Location <input name="location" class ="form-control" value=<%= env.getLocation() %>/></td>
<td>
<button class="btn" name="action" value="search">
Search
</button>
</td>
</tr>
<% for(Database en: s){
	%>
	<tr>
	<td><%=en.getName() %></td>
	<td><a href="dbTables.jsp"><%=en.getLocation() %></a></td>
	<td>
	<a href="databases.jsp?action=remove&id=<%= en.getId() %>">
	Delete
	</a>
	
	<a href="databases.jsp?action=select&id=<%=en.getId() %>">
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