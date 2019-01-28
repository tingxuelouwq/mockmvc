<%--
  Created by IntelliJ IDEA.
  User: kevin
  Date: 2019/1/25
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SessionAttributes</title>
</head>
<body>
    request.attr1: ${requestScope.attr1}<br/>
    session.attr1: ${sessionScope.attr1}<br/>
    request.attr2: ${requestScope.attr2}<br/>
    session.attr2: ${sessionScope.attr2}<br/>
    <a href="${requestScope.contextPath}/session/clear">清除SessionAttributes</a>
</body>
</html>
