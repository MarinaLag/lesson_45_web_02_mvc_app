
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:set var="number" value="25" scope="page"/>

    <p> Result: ${number + 15} </p>

    <c:remove var = "number"/>

    <p> Result: ${number + 15} </p>

    <c:if test="${number == null}">
        <h2>Number is absent</h2>
    </c:if>

    <c:choose>
        <c:when test="${number == 15}">
            <p> Equals 15 </p>
        </c:when>
        <c:when test="${number == 20}">
            <p> Equals 20 </p>
        </c:when>
        <c:otherwise>
            <p> Equals 25 </p>
        </c:otherwise>
    </c:choose>

       <c:url var="linkUrl" value="http://google.com"/>
        This is a <a href="${linkUrl}"> Link to google </a> on our page.

    <br>
        <c:url var="linkUrl" value="http://google.com/search" scope="page">
            <c:param name="q" value="I want home"/>
        </c:url>
    This is a <a href="${linkUrl}"> Link to google </a> on our page.

    <br>
    <c:forEach var="cook" items="${cookie}">
        <li>
            <p><c:out value="${cook.key}"/></p>
            <p><c:out value="${cook.value.value}"/></p>
        </li>
    </c:forEach>

</body>
</html>
