<!DOCTYPE html>
<html>
<head>
    <#assign ctx="${request.getContextPath()}" >
    <title>『点餐系统』错误界面</title>
</head>
<style>
    h1{
        width: 400px;
        margin-top:150px;
    }
</style>
<body>
<center>
    <h1>
        <div>你的权限不足！(error 401)</div>
        <small>
            <a href="${ctx}/login.html">点击返回首页</a>
        </small>
    </h1>
</center>
</body>
</html>