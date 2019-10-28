<%--
  Created by IntelliJ IDEA.
  User: moezb
  Date: 10/22/2019
  Time: 4:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration Confirmation</title>
</head>
<body>
<h1>Account Successfully Created For ${userCredential.getName()} !</h1>
<div>

    <p>Your id: ${userCredential.getId()}</p><br/>
    <p>Your email: ${userCredential.getEmail()}</p><br/>

    <a href="login"><input type="button" value="Go To Login"/></a>
</div>


</body>
</html>
