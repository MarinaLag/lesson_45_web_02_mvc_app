<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User</title>
</head>
<body>
<c:choose>
    <c:when test="${not empty users}">
        <c:forEach var="user" items="${users}">
            <p>User id: ${user.id} , user fio: ${user.fio} , user email: ${user.email}</p>
        </c:forEach>
    </c:when>
    <c:otherwise>
        <h2>${message}</h2>
    </c:otherwise>
</c:choose>
</body>
</html>
