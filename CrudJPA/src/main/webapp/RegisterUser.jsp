<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrazione</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/controller/Register" method="get">
		<table>
			<tr>
				<td>Inserire il nome utente</td>
				<td><input type="text" name="nomeutente" /></td>
			</tr>
			<tr>
				<td>Inserire password</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td>Inserire nome e cognome</td>
				<td><input type="text" name="fullname" /></td>
			</tr>
			<tr>
				<td>Inserire email</td>
				<td><input type="text" name="email" /></td>
			</tr>
		</table>
		<input type="submit" value="CONFERMA" />
	</form>
</body>
</html>