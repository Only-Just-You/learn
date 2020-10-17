<%--
  Created by IntelliJ IDEA.
  User: 谢磊
  Date: 2020/9/9
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
用户注册
<form action="/MVC_learn_war_exploded/user/doregister.do">
    姓名：<input type="text" name="username"><br>
    密码：<input type="password" name="password"><br>
    国家：<input type="text" name="address.country"><br>
    城市：<input type="text" name="address.city"><br>
    <input type="submit" value="注册">
</form>
</body>
</html>
