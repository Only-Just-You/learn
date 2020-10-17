<%--
  Created by IntelliJ IDEA.
  User: 谢磊
  Date: 2020/9/9
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
用户登录
<%--这里用了IDEA的调试器，所以加了一个路径--%>
<form action="/MVC_learn_war_exploded/user/dologin.do">
    姓名：<input type="text" name="username"><br>
    密码：<input type="password" name="password"><br><br>
    <input type="submit" value="登录">
</form>
</body>
</html>
