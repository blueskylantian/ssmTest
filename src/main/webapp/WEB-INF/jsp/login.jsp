<%--
  Created by IntelliJ IDEA.
  User: 98117
  Date: 2018/7/23
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>

<form action="/user/login.do" method="post" style="text-align: center">
    <a><font size="13" color="#7fffd4">欢迎来到在线微图书管</font></a><br>
    登录：<input type="text" name="username">
    <input type="submit" value="登录">
    <a href="${pageContext.request.contextPath}/user/sign.do" >注册</a><br>
</form>

</body>
</html>
