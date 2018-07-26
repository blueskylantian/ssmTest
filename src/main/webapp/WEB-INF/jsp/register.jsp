<%--
  Created by IntelliJ IDEA.
  User: 98117
  Date: 2018/7/24
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Title</title>
</head>

<script>
    function   check()   {
        var e=document.getElementById("email").value;
        var   myReg   =/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
        if(!myReg.test(e)){
            alert("对不起,E-mail的格式错误!");
            return false;
        }else {
            alert("邮件已发送，请注意查收并尽快激活 !");
            return true;
        }
    }

</script>
<body>

<div id="main" style="margin:0 auto;width:500px;">

    <form id="reg" action="/user/register.do" method="post">
        E-mail：<input type="text" class="input" name="email" id="email">
        <input type="submit" class="btn" value="提交注册" onclick="return check()" >
        <a href="${pageContext.request.contextPath}/user/tologin.do">已有账号</a>
    </form>

</div>
</body>
</html>
