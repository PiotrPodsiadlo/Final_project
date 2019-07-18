<%--
  Created by IntelliJ IDEA.
  User: piotr
  Date: 16.07.19
  Time: 01:58
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        table, th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<form:form method="post" action="/les/add" modelAttribute="lessonDto">
<table>
    <td>
        <div>date of lesson:</div><form:input path="dayOfLesson" type="date" /></br>
        <form:errors path="dayOfLesson" cssClass="error" />

        <div>time of lesson:</div><form:input path="timeOfLesson" type="time" /></br>
        <form:errors path="timeOfLesson" cssClass="error" />
    </td>
    <td>
        <div>hours:</div><form:input path="durationHours" type="number"/></br>
        <form:errors path="durationHours" cssClass="error" />
    </td>
    <td>
        <div>additional info:</div><form:textarea path="additionalInfo"/></br>
        <form:errors path="additionalInfo" cssClass="error" />
    </td>
    <td>
    <div>discount:</div><form:input path="discount" type="text"/></br>
    <form:errors path="discount" cssClass="error" />
    </td>
    <td>
    <div>instructor:</div> <form:select path="instructor" multiple="false" items="${instructors}"/></br>
    <form:errors path="instructor" cssClass="error"/>
    </td>
    <td>
    <div>customer:</div> <form:select path="customer" multiple="false" items="${customers}"/></br>
    <form:errors path="customer" cssClass="error"/>
    </td>
    <td>
    <div>price:</div> <form:select path="price" multiple="false" items="${prices}"/></br>
    <form:errors path="price" cssClass="error"/>
    </td>
    <td>
        <div>location:</div> <form:select path="location" multiple="false" items="${location}"/></br>
        <form:errors path="location" cssClass="error"/>
    </td>
    <td>
    <div>
        <input type="submit" value="Save">
    </div>
    </td>
</table>
</form:form>

</body>
</html>