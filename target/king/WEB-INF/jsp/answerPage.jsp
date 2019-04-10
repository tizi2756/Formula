<%--
  Created by IntelliJ IDEA.
  User: 浩
  Date: 2019/4/8
  Time: 22:41
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
    <script type="text/javascript" src="../js/common/jquery-1.11.2.js"></script>
</head>
<body>
<div class="exercise">
    <div class="studio">你的分数是${score} 你用了${mi}分${se}秒</div>
    <form method="post" action="">
        <div class="examination">
            <ul>
                <c:forEach var="list" items="${a}">
                    <%--<c:forEach var="i" begin="1" end="${session.num}">--%>
                    <li>
                        <div id="subject"><label class="subject">${list.subject}</label></div>
                        <input type="text" name="result" readonly="readonly" value="${list.result}">
                        <div id="eventuate"><p class="eventuate" color="red">${list.judge}<span color="black">答案为</span>${list.answer}</p></div>
                    </li>
                    <%--</c:forEach>--%>
                </c:forEach>
            </ul>
        </div>
        <div class="sub">
            <button type="submit" id="send">提交</button>
        </div>
    </form>
</div>
</body>
</html>
