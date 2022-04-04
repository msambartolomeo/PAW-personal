<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Register</h1>
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
