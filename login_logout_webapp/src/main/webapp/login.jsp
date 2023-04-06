<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="tomato">
<h1>Login here</h1>
<form action="login"method="post">
<table>
<tr>
<td>username</td>
<td><input type="text" name="email">
</tr>
<tr>
<td>password</td>
<td><input type="text" name="password">
</tr>
<tr>
<td><input type="submit" value="Login">
</tr>
</table>
</form>
<%
if(request.getAttribute("error")!=null){
	out.println(request.getAttribute("error"));
}
%>

</body>
</html>