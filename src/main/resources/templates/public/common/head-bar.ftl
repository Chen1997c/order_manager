<#include "/public/common/customTags.ftl" >
<!-- 头部 -->
    <header>
        <!-- logo -->
        <div class="am-fl tpl-header-logo">
            <a href="javascript:;">
                <img src="${ctx}/images/logo.png">
            </a>
        </div>
        <!-- 右侧内容 -->
        <div class="tpl-header-fluid">
            <!-- 侧边切换 -->
            <div class="am-fl tpl-header-switch-button am-icon-list ">
            </div>
            <#if current_user.u_position_id != 3>
            <div class="tpl-header-search">
                <form class="tpl-header-search-form am-u-sm-6" action="javascript:;">
                    <div class=" am-form-group am-form-icon">
                        <div id="notice-bar" class="am-text-sm" style="color:#fff"></div>
                    </div>
                </form>
                <script>
                    setInterval(function () {
                        var notice = '${notice!}';
                        if (notice != '')
                            $('#notice-bar').text('通知:' + notice);
                    }, 1000)
                </script>
            </div>
            </#if>
            <!-- 其它功能-->
            <div class="am-fr tpl-header-navbar">
                <ul>
                    <!-- 欢迎语 -->
                    <li class="am-text-sm  tpl-header-navbar-welcome">
                        <a href="javascript:;">欢迎你,${current_user.u_name}
                        </a>
                    </li>

                    <!-- 退出 -->
                    <li class="am-text-sm ">
                        <a id="logout" href="javascript:;">
                            <span class="am-icon-sign-out"></span> 退出
                        </a>
                    </li>
                </ul>
            </div>
        </div>

    </header>
    <!-- 风格切换 -->
    <div class="tpl-skiner">
        <div class="tpl-skiner-toggle am-icon-cog">
        </div>
        <div class="tpl-skiner-content">
            <div class="tpl-skiner-content-title">
                选择主题
            </div>
            <div class="tpl-skiner-content-bar">
                <span class="skiner-color skiner-white" data-color="theme-white"></span>
                <span class="skiner-color skiner-black" data-color="theme-black"></span>
            </div>
        </div>
    </div>
<script>
    $('#logout').click(function () {
        $.get('${ctx}/logout', function (data) {
            if (data.code == 1)
                window.location.href = '${ctx}/login.html';
        })
    })
</script>