
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User Info</title>
</head>
<body>
    <h1>User Info:</h1>
    <c:choose>
        <c:when test="${not empty us}">
            <p>Name:${us.getFio()}</p>
            <p>Email:${us.email}</p
        </c:when>
        <c:otherwise>
            <h2>${mes}</h2>
        </c:otherwise>
    </c:choose>
</body>
</html>
