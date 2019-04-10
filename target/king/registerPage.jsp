<%--
  Created by IntelliJ IDEA.
  User: 浩
  Date: 2019/4/10
  Time: 12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="../css/register.css" />
    <script type="text/javascript" src="../js/common/jquery-1.11.2.js"></script>
    <script type="text/javascript" src="../js/register.js" ></script>
</head>
<body>
<div class="register">
    <div class="studio">四则混合运算</div>
    <form method="post" action="/studentAdd">
        <div class="int">
            <label for="username">账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</label>
            <input type="text" id="username" class="required" name="username"/>
        </div>
        <div class="int">
            <label for="tel">电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话：</label>
            <input type="text" id="tel" class="required" name="phone"/>
        </div>
        <div class="int">
            <label for="pass">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
            <input type="password" class="required" name="password" id="pwd" placeholder="请输入密码"/>
        </div>
        <div class="int">
            <label for="pass">确认密码：</label>
            <input type="password" class="required" name="pwd" id="pwd1" placeholder="重复以上密码" onkeyup="validate()"/>
        </div>
        <div class="judge"><span id="tishi"></span></div>
        <div class="sub">
            <button type="submit" id="send" onclick="return checkNull()">注册</button>
        </div>
    </form>
</div>
</body>
</html>
<script type="text/javascript">
    function checkNull(){
        var num=0;
        var str="";
        $("input").each(function(n){
            if($(this).val()=="")
            {
                num++;
                str+="?"+$(this).attr("msg")+"不能为空！\r\n";
            }
        });
        if(num>0)
        {
            alert(str);
            return false;
        }
        else
        {
            return true;
        }
    }

</script>
