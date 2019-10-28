<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<html>
<head>
    <title>User List</title>
</head>
<body>

<h1 style="text-decoration: underline; font-style: italic">USER DETAILS</h1>

<h1 style="color: red">${message}</h1>

<p>ID: <c:out value="${userDetail.getId()}"/></p> <br>
<p>NAME: <c:out value="${userDetail.getName()}">USER NAME HERE</c:out></p> <br>
<p>EMAIL: <c:out value="${userDetail.getEmail()}">USER EMAIL HERE</c:out></p> <br>

<a href="${pageContext.request.contextPath}/edit/${userDetail.getEmail()}/"><input type="button" value="EDIT"></a>
<a href="${pageContext.request.contextPath}/delete/${userDetail.getEmail()}/"><input type="button" value="DELETE"></a>

</body>
</html>