<%--
  Created by IntelliJ IDEA.
  User: piotr
  Date: 17.07.19
  Time: 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
