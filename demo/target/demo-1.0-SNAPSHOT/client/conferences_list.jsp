<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: artur
  Date: 14.03.21
  Time: 12:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style><%@include file="/WEB-INF/css/conference.css"%></style>
</head>
<body>
<table>
    <tr>
        <th>Title</th>
        <th>Date</th>
        <th>Place</th>
        <th>Speaker</th>
    </tr>
    <c:forEach var="i" items="${conferences}">
    <tr>
        <td><c:out value="${i.getTitle()}"/></td>
        <td>${i.getDate()}</td>
        <td>${i.getPlace()}</td>
        <td>${i.getSpeakerId()}</td>
        <td><a href="/client/conference/delete/?id=${i.getId()}">DELETE</a></td>
    </tr>
        </c:forEach>
</table>
<div class="input-wrap">
    <p>${errorConferenceMessage}</p>
</div>
<a href="/client/conference/create">
    <button>
        CREATE
    </button>
</a>
</body>
</html>
