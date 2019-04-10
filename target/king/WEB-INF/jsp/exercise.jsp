<%--
  Created by IntelliJ IDEA.
  User: 浩
  Date: 2019/4/7
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>题目</title>
    <link rel="stylesheet" type="text/css" href="css/exercise.css" />
    <script type="text/javascript" src="js/common/jquery-1.11.2.js"></script>
</head>
<body onLoad="showStartTime();showRemainTime();" onkeydown="keydown()">
<div class="exercise">
    <div class="studio">四则混合运算</div>
    <div class="wrapper">
        <h1 id="mytime">00:00:00</h1>
        <button type="button" id="start" name="button" onclick="start()">开始答题</button>
    </div>
    <form method="post" action="/Result">
        <div class="examination">
            <ul>
                <c:forEach var="list" items="${c}">
                    <%--<c:forEach var="i" begin="1" end="${session.num}">--%>
                        <li>
                            <div id="subject"><label class="subject">${list.subject}</label></div>
                            <input type="text" name="result" readonly="readonly">
                            <div id="eventuate"><p class="eventuate" color="red"><span class="eventuate" color="black"></span></p></div>
                        </li>
                    <%--</c:forEach>--%>
                </c:forEach>
            </ul>
        </div>
        <div class="sub">
            <button  type="submit" value="提交" id="send" onclick="return checkNull()">提交</button>
        </div>
    </form>
</div>
</body>
</html>

<script type="text/javascript">
    var h=m=s=ms= 0;  //定义时，分，秒，毫秒并初始化为0；
    var time=0;

    function timer(){   //定义计时函数
        ms=ms+50;         //毫秒
        if(ms>=1000){
            ms=0;
            s=s+1;         //秒
        }
        if(s>=60){
            s=0;
            m=m+1;        //分钟
        }
        if(m>=60){
            m=0;
            h=h+1;        //小时
        }
        str =toDub(h)+":"+toDub(m)+":"+toDub(s);
        mytime = document.getElementById('mytime');
        mytime.innerHTML = str;
    }

    $("#start").one('click',function(){
        time=setInterval(timer,50);
        $('input').removeAttr("readonly");
        //去除input元素的readonly属性
    })


    function toDub(n){  //补0操作
        if(n<10){
            return "0"+n;
        }
        else {
            return ""+n;
        }
    }

    function toDubms(n){  //给毫秒补0操作
        if(n<10){
            return "00"+n;
        }
        else {
            return "0"+n;
        }

    }


    function checkNull(){
        var num=0;
        var str="";
        $("input[type$='text']").each(function(n){
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



