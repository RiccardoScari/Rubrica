<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<h1>LOGIN</h1>
<meta charset="ISO-8859-1">
</head>
<body>
	<%
	if (request.getAttribute("errore") != null && request.getAttribute("errore").equals("true")) {
	%>
	<p style="color: red;">password/username errati</p>
	<%
	}
	%>

	<form action="<%=request.getContextPath()%>/Checker" method="get">
		<table>
			<tr>
				<td><label>Inserisci Username</label></td>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td><label>Inserisci Password</label></td>
				<td><input type="password" name="password" /></td>
			</tr>
		</table>

		<input type="submit" value="ACCEDI" />
	</form>
	<form action="<%=request.getContextPath()%>/RegisterUser.jsp"
		method="get">
		<input type="submit" value="REGISTRATI" />
	</form>
</body>
</html>