<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: 98117
  Date: 2018/7/23
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<script type="text/javascript">
    function returnBook(id) {
        if (id!=null) {
            var xmlHttp = null;
            //表示当前浏览器不是ie,如ns,firefox
            if (window.XMLHttpRequest) {
                xmlHttp = new XMLHttpRequest();
            } else if (window.ActiveXObject) {
                xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
            }
            var url = "${pageContext.request.contextPath}/borrow/return.do?borrowid="+id;

            //设置请求方式为GET，设置请求的URL，设置为异步提交
            xmlHttp.open("GET", url, true);

            //将方法地址复制给onreadystatechange属性
            //类似于电话号码
            xmlHttp.onreadystatechange = function () {
                //Ajax引擎状态为成功
                if (xmlHttp.readyState == 4) {
                    //HTTP协议状态为成功
                    if (xmlHttp.status == 200) {
                        alert("还书成功");
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
<body>

welcome ${sessionScope.username} <a href="/user/logout.do">退出</a>
<a href="/user/index.do">返回</a>

<c:if test="${requestScope.pageBean.list==null}">
    <div style="text-align: center">
        你还没有借阅任何书籍哦<a href="/borrow/index.do">点我借阅</a>
    </div>
</c:if>

<div style="text-align: center">
    <c:if test="${requestScope.pageBean.list!=null}">
        <table border="1" align="center">

            <tr>
                <td>序号</td>
                <td>书名</td>
                <td>借阅时间</td>
                <td>操作</td>
            </tr>

            <c:forEach items="${requestScope.pageBean.list}" var="borrow" varStatus="status">
                <tr>
                    <td>${(requestScope.pageBean.page-1)*8+status.count}</td>
                    <td>${borrow.book.name}</td>
                    <td><fmt:formatDate type="both" value="${borrow.time}"/></td>
                    <td>
                        <a style="cursor: pointer" onclick="returnBook(${borrow.borrowid})"><font color="green">还书</font></a>
                    </td>
                </tr>
            </c:forEach>
        </table>


        <tr align="center">
            <td class="ta_01" align="center" bgColor="#E5E5E5">
                <c:if test="${requestScope.pageBean.page!=1}">
                    <a href="/borrow/myBorrow.do?page=1">首页</a>
                    <a href="/borrow/myBorrow.do?page=${requestScope.pageBean.page-1}">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
                </c:if>
                第${requestScope.pageBean.page}/${requestScope.pageBean.totalPage}页&nbsp;&nbsp;&nbsp;&nbsp;
                <c:if test="${requestScope.pageBean.page!=requestScope.pageBean.totalPage}">
                    <a href="/borrow/myBorrow.do?page=${requestScope.pageBean.page+1}"/> 下一页</a>
                    <a href="/borrow/myBorrow.do?page=${requestScope.pageBean.totalPage}"/>尾页</a>
                </c:if>
            </td>
        </tr>
    </c:if>
</div>



</body>
</html>
