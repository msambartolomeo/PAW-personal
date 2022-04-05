<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1><spring:message code="helloworld.register.title"/></h1>
    <c:url value="/create" var="postPath"/>
    <form:form modelAttribute="registerForm" action="${postPath}" method="post">
        <div>
            <form:errors path="username" element="p" cssStyle="color: red"/>
            <form:label path="username">Username:</form:label>
            <form:input type="text" path="username"/>
        </div>
        <div>
            <form:errors path="password" element="p" cssStyle="color: red"/>
            <form:label path="password">Password:</form:label>
            <form:input type="password" path="password"/>
        </div>
        <div>
            <input type="submit" value="Register!">
        </div>
    </form:form>
</body>
</html>
