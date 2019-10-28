<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>User Credential Form</title>
</head>
<body>
<p>${msg}</p>
<form:form id="userCredentialForm" modelAttribute="userCredentialFormObj"
           action="${pageContext.request.contextPath}/processUserCredential" method="POST">
    <table>
        <tr>
            <td><form:label path="name"/>Name:</td>
            <td><form:input path="name" name="name" id="name" placeholder="Enter name"/></td>
            <td><form:errors path="name" cssClass="error"/></td>
        </tr>
        <tr>
            <td><form:label path="dateOfBirth"/>Date of Birth:</td>
            <td><form:input type="date" path="dateOfBirth" name="dateOfBirth" id="dateOfBirth"
                            placeholder="Date Of Birth"/></td>
            <td><form:errors path="dateOfBirth" cssClass="error"/></td>
        </tr>
        <tr>
            <td><form:label path="email"/>Email:</td>
            <c:if test="${'action' == 'update'}"> <%-- update user, not register --%>
                <td><form:input path="email" readonly="true" name="email" id="email" placeholder="Enter email"/></td>
            </c:if>
            <c:if test="${'action' != 'update'}">
                <td><form:input path="email" name="email" id="email" placeholder="Enter email"/></td>
            </c:if>
            <td><form:errors path="email" cssClass="error"/></td>
        </tr>
        <tr>
            <td><form:label path="password"/>Password:</td>
            <td><form:password path="password" name="password" id="password" placeholder="Enter password"/></td>
            <td><form:errors path="password" cssClass="error"/></td>
        </tr>
        <tr>
            <td><label>Confirm Password:</label></td>
            <td><input type="password" name="confirmPassword" id="confirmPassword" placeholder="Confirm password"/></td>
        </tr>
        <tr>
            <td></td>
            <td><form:button name="Confirm" id="Confirm">Save Changes</form:button></td>
        </tr>
    </table>

</form:form>
</body>
</html>
