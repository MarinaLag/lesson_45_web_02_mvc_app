<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String header = "Hello from jsp";
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2><%=header%></h2>
    <p> Today <%=new Date()%></p>
</body>
</html>
