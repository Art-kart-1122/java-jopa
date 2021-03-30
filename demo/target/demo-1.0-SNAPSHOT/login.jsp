
<%--
  Created by IntelliJ IDEA.
  User: artur
  Date: 13.03.21
  Time: 13:54
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
        <form action="login" method="get">
            <div class="input-wrap">
                <p>User name</p>
                <input type="text" name="login_email" placeholder="Username"/>
            </div>
            <div class="input-wrap">
                <p>Password</p>
                <input type="password" name="login_password" placeholder="Password"/>
            </div>

            <div class="input-wrap">
                <p>${errorLoginPassMessage}</p>
            </div>
            <div class="submit-wrap">
                <button type="submit">LOGIN</button>
            </div>
            <div class="links-wrap">
                <a href="register">Register</a>
                <a href="/redirect:/">Back to Menu</a>
            </div>
        </form>
    </div>
</body>
</html>
