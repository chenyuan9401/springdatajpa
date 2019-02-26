<%--
  Created by IntelliJ IDEA.
  User: chenyuan
  Date: 2018/9/5
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/user/login" method="get">
        username: <input type="text" name="name"/> <br/>
        password: <input type="password" name="pwd">
        <input type="submit" value="login"/>
    </form>
</body>
</html>
