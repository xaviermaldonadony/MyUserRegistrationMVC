<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirmation</title>
</head>
<body>
<p>Congratulations! Registration successful for ${userCredential.name}${userCredential.email}</p>
  <table>
      <tr>
        <td></td>
          <a href="login">login</a>
          <br>
          <a href="users">userList</a>        
      </tr>
  </table>
</body>
</html>