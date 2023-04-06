<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@include file="menu.jsp"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>all Registration</title>
</head>
<body bgcolor="Orange">
<h2>All Registration</h2>
<table>
<tr>
<th>Name</th>
<th>City</th>
<th>Email</th>
<th>Mobile</th>
<th>Action</th>
</tr>
<%
ResultSet res=(ResultSet)request.getAttribute("result");
while(res.next()){
%>
<tr>
<td><%=res.getString(1) %></td>
<td><%=res.getString(2) %></td>
<td><%=res.getString(3) %></td>
<td><%=res.getString(4) %></td>

<td>
<a href="#" onclick="confirmDelete('<%=res.getString(3)%>');">delete</a>
<a href="updateReg?email=<%=res.getString(3)%>&mobile=<%=res.getString(4)%>">update</a>
</td>
</tr>
<%} %>

</table>

<script>
function confirmDelete(email) {
  var confirmation = confirm("Are you sure you want to delete the registration with email " + email + "?");
  if (confirmation) {
    window.location.href = "deleteReg?email=" + email;
  }
}
</script>

</body>
</html>
