<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Register</h1>
    <form action="<c:url value="/create"/>" method="post">
        <div>
            <label for="user">Username:</label>
            <input type="text" name="user" id="user"/>
        </div>
        <div>
            <label for="pass">Password:</label>
            <input type="password" name="pass" id="pass"/>
        </div>
        <div>
            <input type="submit" value="Register!">
        </div>
    </form>
</body>
</html>
