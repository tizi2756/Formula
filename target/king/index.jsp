<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="css/login.css" />
    <script type="text/javascript" src="js/common/jquery-1.11.2.js"></script>
    <script type="text/javascript" src="js/login.js" ></script>
</head>
<body>
<div class="login">
    <div class="studio">四则混合运算</div>
    <form method="post" action="/Login">
        <div class="int">
            <label for="username">账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</label>
            <input type="text" id="username" class="required" name="username" />
        </div>
        <div class="int">
            <label for="pass">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
            <input type="password" class="required" name="password" id="pwd" placeholder="请输入密码"/>
        </div>
        <div class="sub">
            <button type="submit" id="send">登录</button>
        </div>
        <div class="sub">
            <button type="submit" id="gotoregister"><a href="registerPage.jsp">没有账号，去注册</a></button>
        </div>
    </form>
</div>
</body>
</html>
