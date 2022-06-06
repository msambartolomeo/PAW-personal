<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<html>
    <body>
        <h2><spring:message code="user.greeting" arguments="${user.username}" htmlEscape="true"/></h2>
        <h2><spring:message code="user.id" arguments="${user.userId}"/></h2>
        <h4>Issues reported:</h4>
        <ul>
            <c:forEach items="${user.reportedIssues}" var="issue">
                <li>
                    <c:out value="${issue.description}" escapeXml="true" /> - <strong><c:out value="${issue.priority}"/></strong>
                </li>
            </c:forEach>
        </ul>
        <h4>Issues assigned:</h4>
        <ul>
            <c:forEach items="${user.assignedIssues}" var="issue">
                <li>
                    <c:out value="${issue.description}" escapeXml="true" /> - <strong><c:out value="${issue.priority}"/></strong>
                </li>
            </c:forEach>
        </ul>
    </body>
</html>