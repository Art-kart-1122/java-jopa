<%--
  Created by IntelliJ IDEA.
  User: artur
  Date: 13.03.21
  Time: 15:15
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
    <form action="register" method="get">
        <div class="input-wrap">
            <p>First name</p>
            <input type="text" name="register_first_name" placeholder="First name"/>
        </div>
        <div class="input-wrap">
            <p>Last name</p>
            <input type="text" name="register_last_name" placeholder="Last name">
        </div>
        <div class="input-wrap">
            <p>User name</p>
            <input type="text" name="register_email" placeholder="Username"/>
        </div>
        <div class="input-wrap">
            <p>Password</p>
            <input type="password" name="register_password" placeholder="Password"/>
        </div>
        <div class="input-wrap">
            <p>${errorRegisterMessage}</p>
        </div>
        <div class="submit-wrap">
            <button type="submit">REGISTER</button>
        </div>
    </form>
</div>
</body>
</html>
