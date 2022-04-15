<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" action="<c:url value="/login"/>">
        <div>
            <label for="username">Username:</label>
            <input type="text" name="username" id="username" />
        </div>
        <div>
            <label for="password">Password:</label>
            <input type="password" name="password" id="password" />
        </div>
        <div>
            <input type="checkbox" name="rememberme" id="rememberme" />
            <label for="rememberme">Remember me</label>
        </div>
        <div>
            <input type="submit" value="Login"/>
        </div>
    </form>

</body>
</html>
