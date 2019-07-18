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
<%--<a href="/usr/sample">!!!create sample instructors!!!</a></br>--%>
<a href="/les/view/1">see sample lesson, lesson nr1</a></br>

<table>


    <c:forEach items="${map}" var="entry">
        <tr>
            <td>
                <a href="/les/create/${entry.key.getId()}">
                Instructor = ${entry.key.getName()}</a>
            </td>
            <c:forEach items="${entry.value}" var="les">
                <td>
                    ${les.id} </br>
                    ${les.dayOfLesson}</br>
                    ${les.timeOfLesson}</br>
                </td>
            </c:forEach>

        </tr>
    </c:forEach>


</table>

</body>
</html>