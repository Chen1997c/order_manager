<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <#include "/public/common/head.ftl" >
    <title>『点餐系统』客户管理</title>
</head>

<body data-type="widgets">
<script src="${ctx}/js/theme.js"></script>

<div class="am-g tpl-g">
    <#include "/public/common/head-bar.ftl">
    <#include "/admin/common/side-bar.ftl">

    <!-- 内容区域 -->
    <div class="tpl-content-wrapper">
        <div class="container-fluid am-cf">
            <div class="row">
                <div class="am-u-sm-12">
                    <div class="page-header-heading">
                        订餐系统
                        <small>
                            <span class="am-icon-copyright page-header-heading-icon"></span>2018 SWPU order_system
                        </small>
                    </div>
                    <p class="page-header-description">Powered by Team Blank</p>
                    <p class="page-header-description">
                        <a href="https://github.com/Chen1997c/oreder_manager" target="_blank" style="color:#fff">
                            <i class="am-icon-github-square"></i> 访问github仓库
                        </a>
                    </p>
                </div>
            </div>
        </div>

        <div class="row-content am-cf">
            <div class="row am-cf">
                <div class="am-u-sm-12 am-u-md-6">
                    <div class="widget am-cf" style="height: 500px">
                        <div class="widget-head am-cf">
                            <div class="widget-title am-fl">通知消息(最多保留20条)</div>
                            <div class="widget-function am-fr">
                                <a href="javascript:;" class="am-icon-cog"></a>
                            </div>
                        </div>
                        <div class="widget-body-md widget-body am-fr">
                            <div id="notice-box" class="am-text-sm am-u-sm-12 am-margin-bottom"
                                 style="border:1px solid #777;overflow-y: scroll;height:300px;">
                            </div>
                            <div class="am-form-group">
                                <input id="message" class="am-form-field" type="text" placeholder="通知内容...">
                            </div>
                            <div class="am-form-group">
                                <button id="post-notice" class="am-btn am-btn-primary am-btn-sm">发送</button>
                            </div>
                        </div>
                    </div>
                </div>
                <script>
                    //发送通知
                    $('#post-notice').click(function () {
                        var message = $('#message').val();
                        var account = '${current_user.u_account}';
                        if (message == '') {
                            alert('内容不能为空');
                            return;
                        }
                        $.post({
                            url: '${ctx}/admin/postNotice',
                            data: {
                                message: message,
                                account: account
                            },
                            beforeSend: function () {
                                $('#post-notice').addClass('am-disabled');
                            },
                            complete: function () {
                                $('#message').val('');
                                getNotices();
                                $('#post-notice').removeClass('am-disabled');
                            }
                        })
                    })

                    //获取所有的
                    function getNotices() {
                        $.get({
                            url: '${ctx}/admin/getNotice',
                            dataType: 'json',
                            success: function (data) {
                                $('#notice-box').html('');
                                for(var i=0; i<data.length;i++) {
                                    $('#notice-box').append('<div>' + data[i] + '</div>');
                                }
                            }
                        })
                    }

                    $(function () {
                        getNotices();
                    })
                </script>

                <div class="am-u-sm-12 am-u-md-6">
                    <div class="widget am-cf" style="height: 500px">
                        <div class="widget-head am-cf">
                            <div class="widget-title am-fl">版本日志</div>
                            <div class="widget-function am-fr">
                                <a href="javascript:;" class="am-icon-cog"></a>
                            </div>
                        </div>
                        <div class="widget-body-md widget-body am-fr">
                            <div class="am-u-sm-12 am-margin-bottom am-text-sm"
                                 style="border:1px solid #777;height:300px;">
                                <div>#项目开始.环境搭建完毕后托管到github(v0.01)----2018.08.06</div>
                                <div>#项目完成.合并主干与分支(vBeta1.0.0)---2018.08.17</div>
                            </div>
                        </div>
                        <script>
                        </script>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<#include "/admin/custom/edit.ftl">
<#include "/admin/custom/add.ftl">
<script src="${ctx}/js/amazeui.min.js"></script>
<script src="${ctx}/js/app.js"></script>
<script>
    $('#index-bar').addClass('active');
</script>
</body>

</html>