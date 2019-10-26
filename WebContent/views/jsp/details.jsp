<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Details</title>
</head>
<body>
  <table>
    <tr>
	    <th>Email</th>
	    <th>Full Name</th> 
	    <th>id</th>
	  </tr>
	    <tr>
    <td>${userBean.email}</td>
    <td>${userBean.name}</td>
    <td>${userBean.id}</td>
  </tr>
  
 </table>
  <a href="${pageContext.request.contextPath}/editUserCredential/${userBean.email}/">Edit</a>
    <a href="${pageContext.request.contextPath}/deleteUserCredential/${userBean.email}/">Delete</a>
</body>
</html>