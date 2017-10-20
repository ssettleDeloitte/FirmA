<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="FirmProjectPackage.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
<link href="css/stylesheet.css" rel="stylesheet" type="text/css"/><link href="css/bootstrap.css" rel="stylesheet"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Databases</title>



</head>
<body>
<br>
<center>
<h1>Databases</h1>
</center>

<br>
<br>
<%
DatabaseDAO dao = new DatabaseDAO();


//controller
String action = request.getParameter("action");
String name = request.getParameter("name");
String location = request.getParameter("location");
String id = request.getParameter("id");
Database env = new Database();
String search = request.getParameter("search");





if("create".equals(action)){
	Database en = new Database(name, location);
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
	env = new Database(name, location);
	dao.update(idInt, env);
}


List<Database> db = dao.selectAll();
%>

<form action="databases.jsp">

<input type="hidden" name="id" value="<%= env.getId() %>"/>

<table class="table">
<tr>
<td>Name <input name="name" class="form-control" value=<%= env.getName() %>/></td>
<td>Location <input name="location" class ="form-control" value=<%= env.getLocation() %>/></td>
<td>
<button class="btn" name="action" value="create">
Add
</button>
<button class="btn" name="action" value="update">
update
</button>
</td>
</tr>
<% for(Database en: db){
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

<%
List<Database> allDbs = dao.selectAll();
%>
<center>
<a href="index.jsp">Go back to home</a>
</center>
<br><br><br><br><br>

------------------------------------------------------
<%for(Database d : db){ %>
<div id="treePane">
<ul>
<li><label class="node">Database 1</label>
<ul>
<li>Content 1</li>
<li>Content 2</li>
</ul></li>
<!-- <li><label class="node">Database 2</label>
<ul>
<li>Content 3</li></ul>
</li>
</ul> -->
</ul>
</div>

<%}%>

<script type="text/javascript">

(function() {
	
	$('#treePane').find(".node").next("ul").hide();
	
	$('#treePane').find('.node').on('click', function()
			{
		$(this).next('ul').toggle();
			});
	
})();	
</script>
</body>
</html>