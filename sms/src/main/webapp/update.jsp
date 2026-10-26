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

<h1>Update the student</h1>

<%
ResultSet r=(ResultSet)request.getAttribute("res");
%>
<form action="update">
<input type="text" name="id" value="<%=r.getInt(1) %>" readonly="readonly">
<input type="text" name="name" value="<%=r.getString(2) %>">
<input type="text" name="email" value="<%=r.getString(3) %>">
<input type="text" name="phoneno" value="<%=r.getLong(4) %>">
<button type="submit">Update</button>


</form>

</body>
</html>