<%@page import="in.co.rays.been.StudentBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
<body bgcolor="grey">
	<form action="DeletePageCtl" method="post">

		<jsp:useBean id="bean0" scope="request"
			class="in.co.rays.been.StudentBean"></jsp:useBean>
		<h1 align="center" style="color: black">Student Management Form</h1>
		<hr>
		<div align="center">

			<%
				StudentBean bean = (StudentBean) request.getAttribute("rollNo");
			%>
			<table align="center">
				<tr>
					<th>Roll No:</th>
					<td><input type="number" name="rollNo"
						value="<%=bean.getRollNo()%>"></td>
				</tr>
				<tr>
					<th>First Name:</th>
					<td><input type="text" name="fname"
						value="<%=bean.getFirstName()%>">
					<td>
				</tr>
				<tr>
					<th>Last Name:</th>
					<td><input type="text" name="lname"
						value="<%=bean.getLastName()%>"></td>
				</tr>
				<tr>
					<th>Session:</th>
					<td><input type="text" name="session"
						value="<%=bean.getSession()%>"></td>
				</tr>
				<tr>

					<th></th>
					<td><input type="submit" value="Delete"></td>
				</tr>

			</table>
		</div>
	</form>
</body>
</html>