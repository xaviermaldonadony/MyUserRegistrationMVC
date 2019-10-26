<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<style type="text/css">
.error{
	color: red;
	font-size: small;
}
</style>
</head>
<body>

	<form:form id="LoginForm" modelAttribute="loginForm"
		action="loginProcess" method="POST">
		<p>${message}</p>
		<table>
			<tr>
				<td><form:label path="email"></form:label>Username's Email</td>
				<td><form:input path="email" name="email" id="email" /></td>
				<td><form:errors path="email" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="password"></form:label>Password</td>
				<td><form:password path="password" name="password" id="password" /></td>
				<td><form:errors path="password" cssClass="error"></form:errors></td>
				
			</tr>
			<tr>
				<td></td>
				<td><form:button name="Login" id="Login" >Login</form:button></td>		
			</tr>
		</table>

	</form:form>

</body>
</html>