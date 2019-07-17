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
<%--<h1><spring:message code="app.title"/></h1>--%>
<html>
<head>
    <style>
        table, th, td {
            border: 1px solid black;
        }
    </style>
    <title>hello home</title>
</head>
<body>

<table>

<th>INTSTRUCTORS/LESSONS</th>
<c:forEach items="${hours}" var="hour">
        <th style="width: 100px"><c:out value="${hour}"/></th>
</c:forEach>
<tc>
<c:forEach items="${users}" var="qual">
    <tr>
        <td>
            <c:out value="${qual.getId()}"/>
            <c:out value="${qual.getName()}"/>
        </td>
        <c:forEach items="${hours}" var="hour">
            <td style="width: 100px"><a href="/qual/add">dodaj lekcje</a></td>
        </c:forEach>
    </tr>
</c:forEach>
</tc>

</table>

</body>
</html>