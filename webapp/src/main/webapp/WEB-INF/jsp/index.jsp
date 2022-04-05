<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<html>
    <body>
        <h2><spring:message code="user.greeting" arguments="${user.username}" htmlEscape="true"/></h2>
        <h2><spring:message code="user.id" arguments="${user.id}"/></h2>
    </body>
</html>