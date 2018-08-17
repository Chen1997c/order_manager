<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <#assign ctx="${request.getContextPath()}" >
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="${ctx}/css/amazeui.min.css">
    <link rel="stylesheet" href="${ctx}/css/app.css">
    <script src="${ctx}/js/jquery-3.3.1.min.js"></script>
    <title>『点餐系统』登录</title>
    <style>
        body {
            background: url(${ctx}/images/login-bg.jpg);
            background-size: cover;
            background-position: center;
        }

        .login-box {
            left: 50%;
            width: 400px;
            height: 300px;
            margin: 150px auto;
            border-radius: 4px;
            background: rgba(255,255,255,0.1);
        }

        span {
            color: #bbb;
        }

        input::placeholder {
            color: #bbb!important;
        }

        .login-box input {
            background: rgba(0, 0, 0, 0.2) !important;
            color: #eee !important;
            border: 0;
        }

        .response-msg {
            color: red;
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
        <#if current_user??>
            //如果已经登录 跳转到相应的url
            login.toUrlByPosition(${current_user.u_position_id});
            <#else>
            login.init();
        </#if>
    })
</script>
</body>

</html>