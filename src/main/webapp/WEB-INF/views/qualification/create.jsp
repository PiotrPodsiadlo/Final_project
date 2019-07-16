<%--
  Created by IntelliJ IDEA.
  User: piotr
  Date: 15.07.19
  Time: 20:04
  To change this template use File | Settings | File Templates.
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
<form:form method="post" action="/qual/add" modelAttribute="qual">

    <div>NAME:</div><form:input path="name"/></br>
    <form:errors path="name" cssClass="error" />

    <div>SALARY:</div><form:input path="hourlySalary"/></br>
    <form:errors path="hourlySalary" cssClass="error" />

    <div>FUNCTION:</div> <form:select path="function" multiple="true" items="${functions}"/></br>
    <form:errors path="function" cssClass="error" />

    <div>
        <input type="submit" value="Save">
    </div>
</form:form>
</body>
</html>
