<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
<head>
    <meta charset="UTF-8">
    <title>404</title>
    <style>
        html, body {
            padding: 0;
            margin: 0;
            height: 100%;
        }
        .box {
            width: 100%;
            height: 100%;
            background-color: wheat;
            text-align: center;  /*文本水平居中*/
            padding-top: 15%;
        }
    </style>
</head>
<body>

<div class="box">
    <h1>404 您进入了无人区...</h1>
    <span id="counter"></span>秒后 <a href="${pageContext.request.contextPath}/index.jsp">返回系统首页</a>
</div>

<script>
    var $counter = document.getElementById('counter');
    function countDown(secs)
    {
        $counter.innerText=secs;
        if(--secs>0)
        {
            setTimeout("countDown("+secs+")",1000);
        }
        if(secs==0)
        {
            location.href = 'http://stat.hcdn.qiyi.domain';
        }
    }
    countDown(5);
</script>

</body>
</html>