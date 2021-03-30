<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: artur
  Date: 14.03.21
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style><%@include file="/WEB-INF/css/style.css"%></style>
</head>
<body>
<div class="form-wrap">
    <form action="/client/conference/create" method="get">
        <div class="input-wrap">
            <p>Title</p>
            <input type="text" name="conference_title" placeholder="Title"/>
        </div>
        <div class="input-wrap">
            <p>Date</p>
            <input type="datetime-local" name="conference_date" placeholder="Date">
        </div>
        <div class="input-wrap">
            <p>Place</p>
            <input type="text" name="conference_place" placeholder="Place"/>
        </div>
        <div class="input-wrap">
            <p>Visitors</p>
            <input type="number" name="conference_visitors" placeholder="Quantity visitors"/>
        </div>
        <div class="input-wrap">
            <p>Speaker</p>
            <select name="conference_speaker">
                <c:forEach var="i" items="${speakers}">
                    <option value="${i.getId()}"><c:out value="${i.getId()}"/></option>
                    </c:forEach>
            </select>
        </div>

        <div class="input-wrap">
            <p>${errorConferenceMessage}</p>
        </div>
        <div class="submit-wrap">
            <button type="submit">CREATE</button>
        </div>
        <div class="links-wrap">
            <a href="/client/conference">Go to Back</a>
        </div>
    </form>
</div>
</body>
</html>
