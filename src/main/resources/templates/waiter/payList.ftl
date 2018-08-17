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
    <#include "/waiter/common/side-bar.ftl">

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
                                        服务员
                                    </li>
                                    <li class="am-active">结账服务</li>
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
                                        <th>订单id</th>
                                        <th>桌号</th>
                                        <th>服务员</th>
                                        <th>下单时间</th>
                                        <th>状态</th>
                                        <th>查看</th>
                                        <th>修改</th>
                                        <th>删除</th>
                                        <th>买单</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <#list ordersInfo as orderInfo>
                                    <tr class="gradeX">
                                        <#if orderInfo.orderContentDtos??>
                                            <#list orderInfo.orderContentDtos as orderContent>
                                        <td class="am-hide dish-bar">
                                            <input class="dish-price" value="${orderContent.d_price}">
                                            <input class="dish-name" value="${orderContent.d_name}">
                                            <input class="dish-number" value="${orderContent.oc_dishNo}">
                                        </td>
                                            </#list>
                                        </#if>

                                        <td id="order-id">${orderInfo.o_id?c}</td>
                                        <td id="table-id">${orderInfo.o_table_id?c}</td>
                                        <td id="waiter-id">${orderInfo.o_waiter_id?c}</td>
                                        <td id="begin-time">${orderInfo.o_beginTime?datetime}</td>
                                        <#if orderInfo.o_endTime??>
                                        <input type="hidden" id="end-time" value="${orderInfo.o_endTime?datetime}">
                                        <#else>
                                        <input type="hidden" id="end-time" value="">
                                        </#if>
                                        <#if orderInfo.o_state_id == 0>
                                            <td id="order-state">未完成</td>
                                        <#else >
                                            <td id="order-state">已完成</td>
                                        </#if>
                                        <td>
                                            <div class="tpl-table-black-operation">
                                                <a class="info" href="javascript:;"
                                                   data-am-modal="{target: '#pay-info-modal'}">
                                                    <i class="am-icon-search"></i> 查看
                                                </a>
                                            </div>
                                        </td>
                                        <td>
                                            <div class="tpl-table-black-operation">
                                                <a class="edit" href="javascript:;"
                                                   data-am-modal="{target: '#pay-edit-modal'}">
                                                    <i class="am-icon-edit"></i> 修改
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
                                        <td>
                                            <div class="tpl-table-black-operation">
                                                <a href="javascript:;"
                                                   class="pay tpl-table-black-operation-del">
                                                    <i class="am-icon-check"></i> 买单
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
<#include "/waiter/pay/info.ftl">
<#include "/waiter/pay/edit.ftl">
<script src="${ctx}/js/amazeui.min.js"></script>
<script src="${ctx}/js/app.js"></script>
<script src="${ctx}/js/pay.js"></script>
<script>
    var path = '${ctx}';
    $(function () {
        pay.init();
    })
</script>
</body>

</html>