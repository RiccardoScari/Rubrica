<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.model.*"%>
<!DOCTYPE html>
<%
User utente = (User)request.getSession().getAttribute("user");
if (utente.getUsername() == null || utente.getPassword() == null) {
	utente.setPassword(request.getParameter("password"));
	utente.setUsername(request.getParameter("username"));
}
%>
<html>
<head>

<meta charset="ISO-8859-1">
<title>RUBRICA</title>
<h1>RUBRICA</h1>
</head>
<body>
	<form action="<%=request.getContextPath()%>/Nuovo.jsp" method="get">
		<input type="submit" value="NUOVO CONTATTO"
			style="background-color: green;" />
	</form>
	<table border="1">
		<%
		for (Contatto c : utente.getContatti()) {
		%>
		<tr>
			<td><%=c.getNomecontatto()%></td>
			<td><%=c.getNumerotelefono()%></td>
			<td><form action="<%=request.getContextPath()%>/EraseContact" method="get">
					<input type="hidden" name="numtelefono" value="<%=c.getNumerotelefono()%>" /> 
					<input type="hidden" name="username" value="<%=utente.getUsername()%>" /> 
					<input type="hidden" name="password" value="<%=utente.getPassword()%>" />
					<input type="submit" style="background-color: red;" value="ELIMINA" />
				</form></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>