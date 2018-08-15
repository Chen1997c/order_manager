<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <#include "/public/common/head.ftl" >
    <title>『点餐系统』餐桌管理</title>
</head>

<body data-type="widgets">
<script src="${ctx}/js/theme.js"></script>

<div class="am-g tpl-g">
    <#include "/public/common/head-bar.ftl">
    <#include "/admin/common/side-bar.ftl">

    <!-- 内容区域 -->
    <div class="tpl-content-wrapper">
        <div class="row-content am-cf">
            <div class="row">
                <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
                    <div class="widget am-cf">
                        <div class="widget-head am-cf">
                            <div class="widget-title  am-cf">
                                <ol class="am-breadcrumb breadcrumb-self">
                                    <li>
                                        <a href="#">首页</a>
                                    </li>
                                    <li class="am-active">员工管理</li>
                                </ol>
                            </div>


                        </div>
                        <div class="widget-body  am-fr">

                            <div class="am-margin-bottom-lg am-cf">
                                <div class="am-u-sm-12 am-u-md-6 am-u-lg-7">
                                    <span>餐桌列表</span>
                                </div>
                            </div>
                            <#list tables as table>
                            <div class="am-u-sm-6 am-u-md-4 am-u-lg-2 am-margin-bottom">
                                <div class="am-text-sm">${table.dt_table_number}号桌:
                                    <#if table.dt_isUsing == 0>
                                        (未使用)
                                    <#else >(使用中)
                                    </#if>
                                </div>
                                <img src="${ctx}/images/table.jpg" style="width: 100%;">
                                <button class="am-btn am-btn-secondary am-btn-xs am-u-sm-6">删除</button>
                                <button class="am-btn am-btn-primary am-btn-xs am-u-sm-6">修改状态</button>
                            </div>
                            </#list>
                            <div class="am-u-sm-6 am-u-md-4 am-u-lg-2 am-u-end am-padding-top am-text-center">
                                <img src="${ctx}/images/add-table.png" class="am-margin-top-xl" style="width: 40%;"
                                     data-am-popover="{content: '点击添加餐桌', trigger: 'hover focus'}"
                                     data-am-modal="{target: '#table-add-modal', closeViaDimmer: 0, width: 200}">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>

<#include "/admin/table/add.ftl" >
<script src="${ctx}/js/amazeui.min.js"></script>
<script src="${ctx}/js/app.js"></script>
<script>
    var path = '${ctx}';
</script>
<script src="${ctx}/js/table-edit.js"></script>
</body>

</html>