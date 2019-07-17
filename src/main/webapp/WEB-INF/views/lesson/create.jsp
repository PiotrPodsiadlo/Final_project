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
</head>
<body>
<form:form method="post" action="/les/add" modelAttribute="lessonDto">

    <div>time and date of lesson:</div><form:input path="dayAndHourOfLesson" type="datetime-local"/></br>
    <form:errors path="dayAndHourOfLesson" cssClass="error" />

    <div>hours:</div><form:input path="durationHours"/></br>
    <form:errors path="durationHours" cssClass="error" />

    <div>discount:</div><form:input path="discount" type="password"/></br>
    <form:errors path="discount" cssClass="error" />




    <div>instructor:</div> <form:select path="instructor" multiple="false" items="${instructors}"/></br>
    <form:errors path="instructor" cssClass="error"/>


    <div>customer:</div> <form:select path="customer" multiple="false" items="${customers}"/></br>
    <form:errors path="customer" cssClass="error"/>


    <div>price:</div> <form:select path="price" multiple="true" items="${prices}"/></br>
    <form:errors path="price" cssClass="error"/>

    <div>
        <input type="submit" value="Save">
    </div>
</form:form>

</body>
</html>