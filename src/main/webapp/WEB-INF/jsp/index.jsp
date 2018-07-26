<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 98117
  Date: 2018/7/24
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<script type="text/javascript">
    function borrow(id) {
        if (id!=null) {
            var xmlHttp = null;
            //表示当前浏览器不是ie,如ns,firefox
            if (window.XMLHttpRequest) {
                xmlHttp = new XMLHttpRequest();
            } else if (window.ActiveXObject) {
                xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
            }
            var url = "${pageContext.request.contextPath}/user/borrow.do?bookid="+id;

            //设置请求方式为GET，设置请求的URL，设置为异步提交
            xmlHttp.open("GET", url, true);

            //将方法地址复制给onreadystatechange属性
            //类似于电话号码
            xmlHttp.onreadystatechange = function () {
                //Ajax引擎状态为成功
                if (xmlHttp.readyState == 4) {
                    //HTTP协议状态为成功
                    if (xmlHttp.status == 200) {
                        alert("借阅成功");
                        //刷新页面
                        window.location.reload();
                    } else {
                        alert("请求失败，错误码=" + xmlHttp.status);
                    }
                }
             };
                //将设置信息发送到Ajax引擎
                xmlHttp.send(null);
        }else{
            alert("请求错误！id为空")
        }
    }
</script>


welcome ${sessionScope.username} <a href="/user/logout.do">退出</a>
<a href="/borrow/myBorrow.do"><font color="blue">我的借阅</font></a>
<div style="text-align: center">
    <form action="/book/likeSearch.do" method="post">
        <label>
            <input type="text" name="key" value="${requestScope.key}">
        </label>
        <input type="submit" value="检索">
    </form>

    <c:if test="${requestScope.pageBean.list!=null}">
        <table border="1" align="center">
            <tr>
                <td>编号</td>
                <td>书名</td>
                <td>剩余</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${requestScope.pageBean.list}" var="book" varStatus="status">
                <tr>
                    <td>${(requestScope.pageBean.page-1)*8+status.count}</td>
                    <td>${book.name}</td>
                    <td id="bookCount">${book.count}</td>
                    <td>
                        <a onclick="borrow(${book.bookid})" style="cursor: pointer"><font color="aqua">借阅</font></a>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <c:if test="${requestScope.key!=null}">
            <tr align="center">
                <td class="ta_01" align="center" bgColor="#E5E5E5">
                    <c:if test="${requestScope.pageBean.page!=1}">
                        <a href="/book/likeSearch.do?page=1&key=${requestScope.key}">首页</a>
                        <a href="/book/likeSearch.do?page=${requestScope.pageBean.page-1}&key=${requestScope.key}">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
                    </c:if>
                    第${requestScope.pageBean.page}/${requestScope.pageBean.totalPage}页&nbsp;&nbsp;&nbsp;&nbsp;
                    <c:if test="${requestScope.pageBean.page!=requestScope.pageBean.totalPage}">
                        <a href="/book/likeSearch.do?page=${requestScope.pageBean.page+1}&key=${requestScope.key}"/> 下一页></a>
                        <a href="/book/likeSearch.do?page=${requestScope.pageBean.totalPage}&key=${requestScope.key}"/>尾页</a>
                    </c:if>
                </td>
            </tr>
        </c:if>

        <c:if test="${requestScope.key==null}">
            <tr align="center">
                <td class="ta_01" align="center" bgColor="#E5E5E5">
                    <c:if test="${requestScope.pageBean.page!=1}">
                        <a href="/book/likeSearch.do?page=1">首页</a>
                        <a href="/book/likeSearch.do?page=${requestScope.pageBean.page-1}">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
                    </c:if>
                    第${requestScope.pageBean.page}/${requestScope.pageBean.totalPage}页&nbsp;&nbsp;&nbsp;&nbsp;
                    <c:if test="${requestScope.pageBean.page!=requestScope.pageBean.totalPage}">
                        <a href="/book/likeSearch.do?page=${requestScope.pageBean.page+1}"/> 下一页></a>
                        <a href="/book/likeSearch.do?page=${requestScope.pageBean.totalPage}"/>尾页</a>
                    </c:if>
                </td>
            </tr>
        </c:if>


    </c:if>


</div>



</body>
</html>
