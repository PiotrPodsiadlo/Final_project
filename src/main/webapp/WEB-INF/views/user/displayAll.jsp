<%--
  Created by IntelliJ IDEA.
  User: piotr
  Date: 15.07.19
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- above tags to use jstl, forms and spring language settings--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1><spring:message code="usr.list"/></h1>

<c:forEach items="${users}" var="user">
    <tr>
        <td><c:out value="${user.getId()}"/></td>
        <td><c:out value="${user.getName()}"/></td>
        <td><c:out value="${user.getEmail()}"/></td>
<%--        <td><a href="/qual/delete/${qual.getId()}">delete</a></td>--%>
<%--        <td><a href="/qual/edit/${qual.getId()}">edit</a></td>--%>
        </br>
    </tr>
</c:forEach>
</body>
</html>
