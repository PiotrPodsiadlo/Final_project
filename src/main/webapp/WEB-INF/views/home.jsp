<%--
  Created by IntelliJ IDEA.
  User: piotr
  Date: 15.07.19
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>hello home</title>
</head>
<body>
<%--<h1><spring:message code="app.title"/></h1>--%>
<c:forEach items="${users}" var="qual">
    <tr>
        <td><c:out value="${qual.getId()}"/></td>
        <td><c:out value="${qual.getName()}"/></td>
        <td><c:out value="${qual.getEmail()}"/></td>
            <%--        <td><a href="/qual/delete/${qual.getId()}">delete</a></td>--%>
            <%--        <td><a href="/qual/edit/${qual.getId()}">edit</a></td>--%>
        </br>
    </tr>
</c:forEach>

</body>
</html>