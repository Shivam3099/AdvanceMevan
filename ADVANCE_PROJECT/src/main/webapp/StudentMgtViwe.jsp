<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h2>Student Management</h2>
		<form action="StudentMgtCtl" method="post" align="center">
			<%
				String err1 = (String) request.getAttribute("err1");
				if (err1 != null) {
			%><font color="green"><%=err1%></font>
			<%
				}
			%>
			<%
				String updt = (String) request.getAttribute("updt");
				if (updt != null) {
			%><font color="green"><%=updt%></font>
			<%
				}
			%>
			<%
				String updt1 = (String) request.getAttribute("updt1");
				if (updt1 != null) {
			%><font color="Red"><%=updt1%></font>
			<%
				}
			%>


			<table align="center">

				<tr>
					<th>Roll No:</th>
					<td><input type="text" name="rollNo"></td>
				</tr>
				<tr>
					<th>First Name:</th>
					<td><input type="text" name="fname"></td>

				</tr>
				<tr>
					<th>Last Name:</th>
					<td><input type="text" name="lname"></td>
				</tr>
				<tr>
					<th>Session:</th>
					<td><input type="text" name="session"></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" value="Add" name="operation">
						<input type="submit" value="Delete" name="operation"> <input
						type="submit" value="Modify" name="operation"></td>
				</tr>
				<hr>

				<td><a href="PaginationCtl">Student list</a>
			</table>
		</form>
	</div>
</body>
</html>