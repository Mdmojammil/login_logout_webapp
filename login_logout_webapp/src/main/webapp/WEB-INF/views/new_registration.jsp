<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="blue">
<h1>New Registration</h1>
<form action="SaveRegistration" method="post">
<table>
<tr>
<td>name</td>
<td><input type="text" name="name">
</tr>
<tr>
<td>city</td>
<td><input type="text" name="city">
</tr>
<tr>
<td>email</td>
<td><input type="text" name="email">
</tr>
<tr>
<td>mobile</td>
<td><input type="text" name="mobile">
</tr>
<tr>
<td><input type="submit" value="Register">
</tr>
</table>
</form>
<%
if(request.getAttribute("msg")!=null){
	out.println(request.getAttribute("msg"));
}
%>

</body>
</html>