<%@page import="java.sql.ResultSet" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Student details</h1>

<a href="index.jsp"> <button type="submit">add a student</button> </a>

<table border="2" rules="all" cellspacing="1px" cellpadding="1px">

<tr>
<th>ID</th>
<th>NAME</th>
<th>EMAIL</th>
<th>PHONE NO</th>

</tr>

<%
ResultSet r=(ResultSet)request.getAttribute("rs");

while(r.next()){

%>
<tr>
<td> <%=r.getInt(1) %></td>
<td> <%=r.getString(2) %></td>
<td> <%=r.getString(3) %></td>
<td> <%=r.getLong(4) %></td>
<td> <a href="delete?id=<%=r.getInt(1)%>"><button>delete</button></a>  </td>
<td> <a href="update_page?id=<%=r.getInt(1)%>"><button >update</button></a> </td>

</tr>
<%
}
%>
</table>

</body>
</html>