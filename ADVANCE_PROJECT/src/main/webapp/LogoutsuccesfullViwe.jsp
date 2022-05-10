<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body >
<div align ="center">
          <% String log	= (String)request.getAttribute("log");
			  if(log != null){
		    %><font  size="20px" coloar=" dark green" ><%=log %></font>
		    <%
			  }		    
		    %> 
		    <hr>
		    <a href="LoginView.jsp">login your account</a> 
</div>
</body>
</html>