<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="Purple">
<h2>Update Registresion</h2>
<form action="updateReg" method="post">
<pre>
email<input type="text" name="email" value="<%=request.getAttribute("email")%>"/>
mobile<input type="text" name="mobile" value="<%=request.getAttribute("mobile")%>"/>
<input type="submit" value="update"/>
</pre>
</form>

</body>
</html>