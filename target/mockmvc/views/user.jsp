<%--
  Created by IntelliJ IDEA.
  User: king
  Date: 2017/12/23
  Time: 12:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/taglib.jsp"%>
<html>
<head>
    <title>添加用户</title>
    <link href="${ctx}/static/css/flash.css" type="text/css" rel="stylesheet">
</head>
<body>
    <div>
        <div class="content">
            <form action="${ctx}/flash" method="post">
                <div>
                    <input name="id" type="text" placeholder="请输入用户id"/>
                </div>
                <div>
                    <input name="name" type="text" placeholder="请输入用户名"/>
                </div>
                <div>
                    <input type="submit" value="添加" />
                </div>
            </form>
        </div>
    </div>
</body>
</html>
