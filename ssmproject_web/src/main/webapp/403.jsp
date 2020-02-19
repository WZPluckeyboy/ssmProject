<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
<head>
    <meta charset="UTF-8">
    <title>403</title>
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
            line-height: 600px;  /*文本垂直居中*/
        }
    </style>
</head>
<body>

<div class="box">
    <h1 style="display: inline">Sorry, this page is Authorised by </h1>
    <h1 style="display: inline"><a href="${pageContext.request.contextPath}/index.jsp">返回系统首页</a></h1>
    <h1 style="display: inline"> only.</h1>
</div>

</body>
</html>