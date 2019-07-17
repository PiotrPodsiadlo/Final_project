<%--
  Created by IntelliJ IDEA.
  User: piotr
  Date: 16.07.19
  Time: 01:37
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

<form:form method="post" action="/usrA/add" modelAttribute="userDto">

    <div>NAME:</div><form:input path="name"/></br>
    <form:errors path="name" cssClass="error" />

    <div>email:</div><form:input path="email"/></br>
    <form:errors path="email" cssClass="error" />

    <div>password:</div><form:input path="password" type="password"/></br>
    <form:errors path="password" cssClass="error" />

    <div>salary:</div><form:input path="salary"/></br>
    <form:errors path="salary" cssClass="error" />


    <div>status:</div> <form:select path="status" multiple="false" items="${status}"/></br>
    <form:errors path="status" cssClass="error"/>


    <div>role:</div> <form:select path="roles" multiple="true" items="${roles}"/></br>
    <form:errors path="roles" cssClass="error"/>


    <div>qualifications:</div> <form:select path="qualifications" multiple="true" items="${qualifications}"/></br>
    <form:errors path="qualifications" cssClass="error"/>


<%--    this will be only for admin --%>
    <div>enabled:</div> <form:radiobutton path="enabled" value="1"/>
    <div>disabled:</div> <form:radiobutton path="enabled" value="0"/>
    <form:errors path="enabled" cssClass="error"/>


    <div>
        <input type="submit" value="Save">
    </div>
</form:form>





</body>
</html>