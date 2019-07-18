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

<a href="/les/add">add lesson</a></br>
<a href="/qual/add">add qualification</a></br>
<a href="/qual/all">all qualifications</a></br>
<a href="/usr/all">display all users</a></br>
<a href="/usr/sample">!!!create sample instructors!!!</a></br>
<a href="/les/view/1">see sample lesson, lesson nr1</a></br>

<table>

<th>INTSTRUCTORS/LESSONS</th>
<c:forEach items="${units}" var="unit">
        <th style="width: 100px"><c:out value="${unit}"/></th>
</c:forEach>
<tc>
<c:forEach items="${users}" var="user">
    <tr>
        <td>
            <c:out value="${user.getId()}"/>
            <c:out value="${user.getName()}"/>
        </td>
        <c:forEach items="${units}" var="unit">
            <c:choose>
                <c:when test="${false}">
                    <td style="width: 100px"><a href="/les/create/${user.getId()}/${unit}">dodaj lekcje</a></td>
                </c:when>

                <c:otherwise>
                    <td style="width: 100px"><a href="/les/create/${user.getId()}/${unit}">szczegóły</a></td>
                </c:otherwise>
            </c:choose>


        </c:forEach>
    </tr>
</c:forEach>
</tc>

</table>

</body>
</html>

