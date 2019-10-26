<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <p>${message}
    ${pageContext.request.contextPath}
 <!--   action="processUserCredential"-->
<form:form id="userCredentialForm" modelAttribute="userCredentialFormObj"
action ="${pageContext.request.contextPath}/saveUserCredential" method="POST">
    <table>
      <tr>
        <td><form:label path="name"></form:label>Username</td>
        <td><form:input path="name" name="name" id="name" placeholder="Full Name"/></td>
        <td><form:errors path="name" cssClass="error"></form:errors></td>
      </tr>
      
      <tr>
        <td><form:label path="email"></form:label>Email</td>
        <c:if test="${action == update }" >
        <td><form:input input reaadonly = true path="email" name="email" id="email" placeholder="Email"/></td>
        </c:if>
        <c:if test="${action != update }" >
        
        <td><form:input path="email" name="email" id="email" placeholder="Email"/></td>
        </c:if>
        <td><form:errors path="email" cssClass="error"></form:errors></td>
        
      </tr>

       <tr>
        <td><form:label path="password"></form:label>Password</td>
        <td><form:password path="password" name="password" id="password" placeholder="Password" /></td>
        <td><form:errors path="password" cssClass="error"></form:errors></td>
        
      </tr>
       </tr>
       
       <tr>
        <td><label>Repeat Password</label></td>
        <td><input type="password" name="confPassword" id="password" placeholder="Confirm Password" /></td>
        
      </tr>
      <tr>
        <td></td>
        <td><form:button name="Login" id="Login" >Login</form:button></td>
      </tr>
    </table>

  </form:form>
</body>
</html>