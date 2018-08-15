<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <#assign ctx="${request.getContextPath()}" >
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="${ctx}/css/amazeui.min.css">
    <script src="${ctx}/js/jquery-3.3.1.min.js"></script>
    <title>『点餐系统』登录</title>
    <style>
        body {
            background:  url('${ctx}/images/login-bg.jpg')  no-repeat;
            background-size: cover;
        }
        .login-box {
            left: 50%;
            width: 400px;
            height: 300px;
            margin:150px auto;
            border-radius: 4px;
            background: rgba(0, 0, 0, 0.3);
        }
        .login-box input {
            background: rgba(0,0,0,0.2)!important;
            color: #eee!important;
        }

        .response-msg {
            color:red;
            font-weight: bold;
        }

    </style>
</head>

<body>
<script src="${ctx}/js/login.js"></script>
<form class="login-box am-form am-padding-xl">
    <div class="am-form-group am-form-icon ">
        <span class="am-icon-user"></span>
        <input type="text" id="account" class="am-form-field am-round" placeholder="帐号" required>
    </div>
    <div class="am-form-group am-form-icon">
        <span class="am-icon-lock"></span>
        <input type="password" id="password" class="am-form-field am-round" placeholder="密码" required>
    </div>
    <div class="am-form-group am-form-icon">
        <div class="am-g">
            <div class="am-u-sm-8" style="padding-left:0px">
                <span class="am-icon-photo"></span>
                <input type="text" id="verifycode" class="am-form-field am-round" placeholder="验证码" required>
            </div>
            <div class="am-u-sm-4">
                <img src="${ctx}/VCodeImg" id="VCodeImg" alt=" ">
            </div>
        </div>
    </div>
    <p class="response-msg am-margin-xs">&nbsp;</p>
    <div class="am-form-group">
        <input type="submit" class="am-form-field am-btn am-btn-primary" value="登录">
    </div>
</form>
<script>
    var path = '${ctx}';
    $(function () {
        login.init();
    })

</script>
</body>

</html>