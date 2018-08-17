<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <#include "/public/common/head.ftl" >
    <!--  -->
    <script src="${ctx}/js/vue.min.js"></script>
    <title>『点餐系统』点餐服务</title>
</head>

<body data-type="widgets">
<script src="${ctx}/js/theme.js"></script>

<div class="am-g tpl-g">
    <#include "/public/common/head-bar.ftl">
    <#include "/waiter/common/side-bar.ftl">

    <!-- 内容区域 -->
    <input id="waiter_id" type="hidden" value="${current_user.u_id?c}">
    <div class="tpl-content-wrapper">
        <div class="row-content am-cf">
            <div class="row">
                <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
                    <div class="widget am-cf">
                        <div class="widget-head am-cf">
                            <div class="widget-title  am-cf">
                                <ol class="am-breadcrumb breadcrumb-self">
                                    <li class="am-active">服务员</li>
                                    <li class="am-active">点餐服务</li>
                                </ol>
                            </div>
                        </div>
                        <div id="dishRecords" class="widget-body  am-fr">
                            <div class="am-u-sm-12 am-margin-bottom" style="color:#555">
                                <span style="color:#fff">桌号:</span>
                                <select id="tableNo"
                                        data-am-selected="{btnWidth: '10%', btnSize: 'sm', btnStyle: 'secondary'}">
                                    <template v-for="table in tables">
                                        <option :value="table.dt_id">{{table.dt_table_number}}
                                            <span v-if=" table.dt_isUsing == 0">(未使用)</span>
                                            <span v-else>(使用中)</span>
                                        </option>
                                    </template>
                                </select>
                            </div>
                            <div class="am-u-sm-12">
                                <form onsubmit="return order.searDish()">
                                    <div class="am-form-group am-form-icon am-u-sm-12 am-u-md-6 am-u-lg-3"
                                         style="padding-left: 0">
                                        <span class="am-icon-search"></span>
                                        <input type="text" id="search-input" class="am-form-field"
                                               placeholder="输入菜名搜索.."
                                               pattern="^\S{1,10}$">
                                    </div>
                                </form>
                            </div>
                            <div class="am-u-sm-6 am-u-md-4 am-u-lg-3" style="height:350px" v-for="dish in records">
                                <input type="hidden" :value="dish.d_id">
                                <div class="waiter-img am-u-sm-12">
                                    <span v-if=" dish.d_img === null ">
                                        <img src="${ctx}/images/ddr.jpg" style="width:100%;height:60%">
                                    </span>
                                    <span v-else>
                                        <img :src="path+dish.d_img" style="width:100%;height:60%">
                                    </span>
                                    <div class="am-text-center am-text-lg am-text-warning am-margin-top-xs">
                                        <strong id="name">{{dish.d_name}}</strong>
                                    </div>
                                    <div class="am-padding-left am-padding-right">{{dish.d_description}}</div>
                                    <div class="am-text-center am-text-xl am-text-warning">
                                        <strong>￥<span id="price">{{dish.d_price}}</span></strong>
                                    </div>
                                </div>
                                <div class="waiter-count am-margin-top am-u-sm-12">
                                    <div class="am-input-group">
                                        <div class="am-input-group-btn">
                                            <button @click="addCount($event)" class="am-btn add-count">+</button>
                                        </div>
                                        <input :id="dish.d_id" type="text" class="count-input am-form-field" value="0">
                                        <div class="am-input-group-btn">
                                            <button @click="subCount($event)" class="am-btn reduce-count">-</button>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="am-u-lg-12 am-cf am-text-center">
                                <div style="display:inline-block">
                                    <ul class="am-pagination tpl-pagination">
                                        <li class="page-tag">
                                            <a id="showMore" href="javascript:;" onclick="order.showMore()">显示更多...</a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <div class="am-u-lg-12 am-margin-bottom-xl">
                                <button id="placeOrderBtn" class="am-btn am-btn-danger am-u-sm-6 am-u-sm-offset-3">确认订单
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<#include "/waiter/order/buyCar.ftl">
<script src="${ctx}/js/amazeui.min.js"></script>
<script src="${ctx}/js/app.js"></script>
<script src="${ctx}/js/order-dish.js"></script>
<script>
    var path = '${ctx}';
    order.init();
</script>
</body>

</html>