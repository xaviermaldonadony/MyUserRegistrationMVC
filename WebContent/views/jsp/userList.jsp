<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
  <tr>
    <td>ID</td>
    <td>Name</td>
  </tr>
  <c:forEach var="loginEntry" items="${userListBean}"> 
    <tr>
       <td><a href="<c:url value="users/${loginEntry.value.email}/"/>"/>${loginEntry.value.id} </td>
       <td>${loginEntry.value.name}</td>
       <td>${loginEntry.value.email}</td>
       
    </tr>
  </c:forEach>
</table>
</body>
</html>