<%@page import="in.co.rays.been.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<img src="img/download.png" height ="150px" width="150px">
</center>
<br>
</br>
<%
//String name = (String) request.getAttribute("name");
  String name = (String) session.getAttribute("user");

if(name != null)

	  
	
	%><%
{
%>

<!-- <a href="Home.jsp">Home</a> -->
Hiii, 

  <%=name%> 


<a href="">My Profile</a>
<a href="AboutUs.jsp">About Us</a>
<a href="ContactUs.jsp">Contact Us</a>
<a href="list">Marksheet</a>
<a href="LogoutView.jsp">Logout</a>
<%}
else{
%>
Hi, Guest
<%
}%>
<hr>
</body>
</html>