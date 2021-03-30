<%--
  Created by IntelliJ IDEA.
  User: artur
  Date: 07.03.21
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User List</title>
</head>
<body>
<%=request.getAttribute("users")%>
<h2>
    List Users <br/>
</h2>
<table>
    <tr><th>Name</th><th>Surname</th></tr>
    <c:forEach var="i" items="${users}">
    <tr><td>${i.getId()}<c:out value="${i.getFirstName()}"/></td><td>${i.getLastName()}</td>
        </c:forEach>
</table>
</body>
</html>
