<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="forget" method="post">
		<%
			String err = (String) request.getAttribute("err");
			if (err != null) {
		%><font color="red"><%=err%></font>
		<%
			}
		%>
		<table>
			<tr>
				<th>Login :</th>
				<td><input type="text" name="login"></td>
				<td>
					<%
						String err1 = (String) request.getAttribute("err1");
						if (err1 != null) {
					%><font color="red"><%=err1%></font> <%
 	}
 %>
				</td>
			</tr>
			<tr>
				<th></th>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>

</body>
</html>