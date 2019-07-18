<%--
  Created by IntelliJ IDEA.
  User: piotr
  Date: 18.07.19
  Time: 16:26
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>--%>
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

<%--    <c:forEach items="${map}" var="map">--%>
<%--        <tr>--%>
<%--            <th style="width: 100px"><c:out value="${map.key.getName()}"/></th>--%>

<%--            <c:forEach items="${map.key}" var="mapkey">--%>

<%--                <td style="width: 100px"><c:out value="${mapkey.getValue()}"/></td>--%>

<%--            </c:forEach>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>

    <c:forEach items="${map}" var="entry">
        Instructor = ${entry.key.getName()}, <br>
        <c:forEach items="${entry.value}" var="les">


          !!!!LESSON =  ${les.id}
<%--            <c:forEach items="${les}" var="oneLesson">--%>
<%--                ${oneLesson.getId()}--%>
<%--            </c:forEach>--%>

        </c:forEach>
    </c:forEach>





</table>

</body>
</html>