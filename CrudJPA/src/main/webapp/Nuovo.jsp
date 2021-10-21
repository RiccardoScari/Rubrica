<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.model.User"%>
<!DOCTYPE html>
<%User utente= (User)request.getSession().getAttribute("user"); %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>NUOVO CONTATTO</title>
<h1>Inserisci nuovo contatto</h1>
</head>
<body>
	<form action="<%=request.getContextPath()%>/NewContact" method="get">
	<input type="hidden" name="username" value="<%= utente.getUsername() %>"/>
	<input type="hidden" name="password" value="<%= utente.getPassword() %>"/>
		<table>
			<tr>
				<td>Inserire il nome del contatto</td><td><input type="text" name="nomecontatto"/></td>
			</tr>
			<tr>
				<td>Inserire il numero di telefono</td><td><input type="text" name="numerocontatto"/></td>
			</tr>
		</table>
		<input type="submit" value="CONFERMA"/>
	</form>
</body>
</html>