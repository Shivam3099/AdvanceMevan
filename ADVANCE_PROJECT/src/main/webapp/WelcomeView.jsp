<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="Header.jsp"%>


	<%
		String user = (String) request.getAttribute("user");
		RequestDispatcher rd = request.getRequestDispatcher("Header.jsp");
		request.setAttribute("name", user);
		rd.forward(request, response);
	%>
</body>
</html>