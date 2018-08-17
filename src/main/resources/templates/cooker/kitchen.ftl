<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <#include "/public/common/head.ftl" >
    <title>『点餐系统』备菜服务</title>
</head>

<body data-type="widgets">
<script src="${ctx}/js/theme.js"></script>

<div class="am-g tpl-g">
    <#include "/public/common/head-bar.ftl">
    <#include "/cooker/side-bar.ftl">

    <!-- 内容区域 -->
    <div class="tpl-content-wrapper">
        <div class="row-content am-cf">
            <div class="row">
                <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
                    <div class="widget am-cf">
                        <div class="widget-head am-cf">
                            <div class="widget-title  am-cf">
                                <ol class="am-breadcrumb breadcrumb-self">
                                    <li class="am-active">
                                        后厨
                                    </li>
                                    <li class="am-active">备菜服务</li>
                                </ol>
                            </div>
                        </div>
                        <div class="widget-body  am-fr">

                            <div class="am-margin-bottom-lg am-cf">
                                <div class="am-u-sm-12 am-u-md-6 am-u-lg-7">
                                    <span>顾客点餐列表</span>
                                </div>
                            </div>

                            <div class="am-u-sm-12">
                                <table width="100%" class="am-table am-table-compact am-table-striped tpl-table-black "
                                       id="example-r">
                                    <thead>
                                    <tr>
                                        <th>桌号</th>
                                        <th>单号</th>
                                        <th>菜名</th>
                                        <th>数量</th>
                                        <th>状态</th>
                                        <th>烹饪</th>
                                        <th>传菜</th>
                                        <th>删除</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <#list unCookOrders as order>
                                    <tr class="gradeX">
                                        <input id="oc-id" type="hidden" value="${order.oc_id}">
                                        <td>${order.o_table_id}</td>
                                        <td id="order-id">${order.oc_order_id}</td>
                                        <td>${order.d_name}</td>
                                        <td>${order.oc_dishNo}</td>
                                        <td>
                                            <#if order.oc_state_id == 0>
                                                待烹饪
                                            <#else>
                                                待传菜
                                            </#if>
                                        </td>
                                        <td>
                                            <div class="tpl-table-black-operation">
                                                <a class="cook" href="javascript:;"
                                                   data-am-modal="{target: '#user-info-modal', closeViaDimmer: 0, width: 400, height: 500}">
                                                    <i class="am-icon-tag"></i> 烹饪
                                                </a>
                                            </div>
                                        </td>
                                        <td>
                                            <div class="tpl-table-black-operation">
                                                <a class="publish" href="javascript:;">
                                                    <i class="am-icon-bell"></i> 传菜
                                                </a>
                                            </div>
                                        </td>
                                        <td>
                                            <div class="tpl-table-black-operation">
                                                <a href="javascript:;"
                                                   class="delete tpl-table-black-operation-del">
                                                    <i class="am-icon-trash"></i> 删除
                                                </a>
                                            </div>
                                        </td>
                                    </tr>
                                    </#list>
                                    </tbody>
                                </table>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>

<script src="${ctx}/js/amazeui.min.js"></script>
<script src="${ctx}/js/app.js"></script>
<script src="${ctx}/js/cook.js"></script>
<script>
    $(function () {
        var path = '${ctx}';
    })
</script>
</body>

</html>