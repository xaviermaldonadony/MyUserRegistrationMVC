<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<html>
<head>
    <title>User List</title>
</head>
<body>

<h1>List of Users: </h1>
<table>
    <tr>
        <td>Id</td>
        <td>Name</td>
    </tr>

    <c:forEach items="${userListBean}" var="loginEntry">
        <tr>
            <td><a href="${pageContext.request.contextPath}/users/${loginEntry.value.email}/">${loginEntry.value.id}</a>
            </td>
            <td>${loginEntry.value.name}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>