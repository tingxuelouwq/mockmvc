<%--
  Created by IntelliJ IDEA.
  User: kevin
  Date: 2019/2/18
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/taglib.jsp"%>
<html>
<head>
    <title>更新会员信息</title>
</head>
<body>
    <form action="${ctx}/model" method="post">
        <input type="hidden" name="id" value="1"/>
        &nbsp;name: <input type="text" name="name" value=""/>
        email: <input type="text" name="email" value=""/>
        &nbsp;&nbsp;age: <input type="text" name="age" value=""/>
        <input type="submit" value="submit"/>
    </form>
</body>
</html>
