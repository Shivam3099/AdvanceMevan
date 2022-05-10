<%@page import="in.co.rays.been.StudentBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="bean0" scope="request"
		class="in.co.rays.been.StudentBean"></jsp:useBean>
	<form action="PaginationCtl" method="post">
		<%
			List<StudentBean> list = (List<StudentBean>) request.getAttribute("List");
			Iterator it = list.iterator();
		%>
		<input type="hidden">
		<table border="1" style"width=100%; border=groove;">
			<tr style="background-color: syan;">
				<th style="width: 5%;">Roll No:</th>
				<th style="width: 5%;">First Name:</th>
				<th style="width: 5%;">Last Name:</th>
				<th style="width: 5%;">Session:</th>
				<th style="width: 5%;">Edit:</th>
			</tr>
			<%
				while (it.hasNext()) {
					StudentBean bean = (StudentBean) it.next();
			%>
			<tr>
				<td><%=bean.getRollNo()%></td>
				<td><%=bean.getFirstName()%></td>
				<td><%=bean.getLastName()%></td>
				<td><%=bean.getSession()%></td>
				<td><a href="ModifyCtl?roll_no=<%=bean.getRollNo()%>">edit</a></td>
			</tr>
			<%
				}
			%>

		</table>
		<div align="right">
			<input type="button" value="next" name="operation">
		</div>
	</form>
</body>
</html>