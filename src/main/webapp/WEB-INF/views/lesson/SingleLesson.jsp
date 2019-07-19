<%--
  Created by IntelliJ IDEA.
  User: piotr
  Date: 18.07.19
  Time: 10:01
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>id:</th>
        <td><c:out value="${lesson.id}"/></td>
    </tr>
    <tr>
        <th>istructor:</th>
        <td><c:out value="${lesson.instructor}"/></td>
    </tr>
    <tr>
        <th>istructor:</th>
        <td><c:out value="${lesson.customer}"/></td>
    </tr>
    <tr>
        <th>duration:</th>
        <td><c:out value="${lesson.durationHours} hour"/></td>
    </tr>
    <tr>
        <th>day:</th>
        <td><c:out value="${lesson.dayOfLesson}"/></td>
    </tr>
    <tr>
        <th>hour:</th>
        <td><c:out value="${lesson.timeOfLesson}"/></td>
    </tr>
    <tr>
        <th>status:</th>
        <td><c:out value="${lesson.status}"/></td>
        <td>
            <form:form method="post" action="/les/setState/${lesson.id}/2" >
                    <input type="submit" value="Mark as paid">
            </form:form>
            <form:form method="post" action="/les/setState/${lesson.id}/2" >
                <input type="submit" value="Mark as canceled">
            </form:form>
        </td>
    </tr>



    <tr>
        <th>location:</th>
        <td><c:out value="${lesson.location}"/></td>
    </tr>
    <tr>
        <th>additional info:</th>
        <td><c:out value="${lesson.additionalInfo}"/></td>
    </tr>
    <tr>
        <th>when scheduled:</th>
        <td><c:out value="${lesson.scheduled}"/></td>
    </tr>
    <tr>
        <th>total price:</th>
        <td><c:out value="${lesson.totalPrice}"/></td>
    </tr>
</table>
</body>
</html>