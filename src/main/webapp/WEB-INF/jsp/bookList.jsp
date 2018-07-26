<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 98117
  Date: 2018/7/23
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>list</title>
</head>
<body>
    <table border="1" align="center">
        <tr>
            <td>编号</td>
            <td>书名</td>
            <td>数量</td>
            <td>操作</td>
        </tr>

        <c:forEach items="${requestScope.list}" var="book" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${book.name}</td>
                <td>${book.count}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/user/borrow.do?bookid=${book.bookid}">借阅</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
