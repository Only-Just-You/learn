<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<%--    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">--%>
    <script src="https://ajax.aspnetcdn.com/ajax/jquery/jquery-3.5.1.min.js"></script>
    <script type="text/javascript">
    $(document).ready(function () {
        $("#btn1").click(function () {
            $.ajax({
                url: "user/doajax.do",
                data: {
                    username: "张三",
                    password: "123"
                },
                success:function (data) {
                    var jsonobject = JSON.parse(data);
                    alert("用户名："+jsonobject.username+"密码："+jsonobject.password);
                }
            });
        });
        $("#btn2").click(function () {
            $.ajax({
                url: "user/doajax2.do",
                success:function (data) {
                    alert(data);
                }
            });
        });
        $("#btn3").click(function () {
            $.ajax({
                url: "user/doajax3.do",
                success:function (data) {
                    alert(data);
                }
            });
        });
        $("#btn4").click(function () {
            $.ajax({
                url: "user/doajax4.do",
                success:function (data) {
                    alert("用户名："+data.username+"密码："+data.password);
                }
            });
        });
        $("#btn5").click(function () {
            $.ajax({
                url: "user/doajax5.do",
                success:function (data) {
                    alert("用户名："+data.user1.username+"密码："+data.user1.password);
                    alert("用户名："+data.user2.username+"密码："+data.user2.password);
                }
            });
        });
        $("#btn6").click(function () {
            $.ajax({
                url: "user/doajax6.do",
                success:function (data) {
                    $(data).each(function (index) {
                        alert("用户名："+data[index].username+"密码："+data[index].password);
                    })
                }
            });
        });
        $("#btn7").click(function () {
            $.ajax({
                url: "user/doajax7.do",
                data: {
                    username: "张三",
                    password: "132"
                },
                success:function (data) {
                    var jsonObject = JSON.parse(data);
                    alert("用户名："+jsonObject.username+"密码："+jsonObject.password);
                }
            });
        });
        $("#btn8").click(function () {
            $.ajax({
                url: "user/doajax8.do",
                data:{
                    username: "张三",
                    password: "123"
                },
                success:function (data) {
                    alert("用户名："+data.username+"密码："+data.password);
                }
            });
        });
        $("#btn10").click(function () {
            var jsonObj = {username:"张三", password:"123"};
            var jsonStr = JSON.stringify(jsonObj);
            $.ajax({
                url: "user/doajax10.do",
                data: jsonStr,
                type: "post",
                contentType: "application/json;charset=UTF-8",
                success:function (data) {
                    alert("用户名："+data.username+"密码："+data.password);
                }
            });
        });
    });
    </script>
</head>
<body>
<input id="btn1" type="button" value="点我">
<input id="btn2" type="button" value="返回数值">
<input id="btn3" type="button" value="返回字符">
<input id="btn4" type="button" value="返回对象">
<input id="btn5" type="button" value="返回Map">
<input id="btn6" type="button" value="返回List">
<input id="btn7" type="button" value="Ajax 发送 JSON，服务端接受 Bean 返回 JSON 字符串"><br>
<input id="btn8" type="button" value="Ajax 发送 JSON，服务端接受 Bean 返回 JSON 字符串"><br>

<input id="btn10" type="button" value="Ajax 发送 JSON，服务端接受 Bean 返回 JSON 字符串">
</body>
</html>
