<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/7
  Time: 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>选择</title>
    <link rel="stylesheet" type="text/css" href="../css/userchoice.css" />
    <script type="text/javascript" src="../js/common/jquery-1.11.2.js"></script>
</head>
<body>
<div class="userchoice">
    <div class="studio">四则混合运算</div>
    <form method="post" action="/operationAll">
        <div class="int">
            <label for="range">数值&nbsp;&nbsp;&nbsp;&nbsp;范围：</label>
            <input type="number" class="short" id="value1" name="value1s">
            <input type="number" class="short" id="value2" name="value2s">
        </div>
        <div class="int">
            <label for="topicalamount">题目&nbsp;&nbsp;&nbsp;&nbsp;数量：</label>
            <input type="text" class="required" name="amounts" id="amount" placeholder="题目数量"/>
        </div>
        <div class="int">
            <label for="range">运算符上限：</label>
            <input type="number" class="long" id="limit" name="limits">
        </div>
        <div class="int">
            <label>是否包含乘除法</label>
            <div class="switch-container">
                <input type="checkbox" id="user-switch"value="1" name="flag1s">
                <label for="user-switch"></label>
            </div>
        </div>
        <div class="int">
            <label>是否包含括号</label>
            <div class="switch-container1">
                <input type="checkbox" id="user-switch1" value="1" name="flag2s">
                <label for="user-switch1"></label>
            </div>
        </div>
        <div class="sub">
            <button type="submit" id="send">开始出题</button>
        </div>
    </form>
</div>
</body>
</html>
