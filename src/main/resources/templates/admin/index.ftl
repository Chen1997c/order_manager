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
                </div>
            </div>
        </div>

        <div class="row-content am-cf">
            <div class="row am-cf">
                <div class="am-u-sm-12 am-u-md-6">
                    <div class="widget am-cf" style="height: 500px">
                        <div class="widget-head am-cf">
                            <div class="widget-title am-fl">通知消息记录</div>
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
                <script src="${ctx}/js/websocket.js"></script>
                <script>
                    $(function () {
                        $('#post-notice').click(function () {
                            var message = $('#message').val().trim();
                            if (message != '') {
                                send(message);
                            } else {
                                alert("通知消息不能为空!");
                            }
                        })
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
                            <div class="am-u-sm-12 am-margin-bottom" style="border:1px solid #777;height:300px;">
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
<script src="${ctx}/js/custom-edit.js"></script>

</body>

</html>