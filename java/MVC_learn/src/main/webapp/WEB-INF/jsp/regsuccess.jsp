<%--
  Created by IntelliJ IDEA.
  User: 谢磊
  Date: 2020/9/9
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
用户注册信息
<form action="/MVC_learn_war_exploded/user/doregister.do">
用户名：${user.username}<br>
密码：${user.password}<br>
国家：${user.address.country}<br>
城市：${user.address.city}<br>
</form>
</body>
</html>
