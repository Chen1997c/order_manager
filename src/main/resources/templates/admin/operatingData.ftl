<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <#include "/public/common/head.ftl" >
    <script src="${ctx}/js/echarts.min.js"></script>
    <title>『点餐系统』经营数据</title>
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
                <div class="am-u-sm-12 am-u-md-12 am-u-lg-9">
                    <div class="page-header-heading">
                        <span class="am-icon-home page-header-heading-icon"></span> 经营数据
                    </div>
                    <p class="page-header-description">Powered by
                        <a href="http://echarts.baidu.com">百度图表echarts</a>
                    </p>
                </div>
            </div>

        </div>
        <div class="row-content am-cf">
            <div class="am-u-md-6 am-u-sm-12">
                <div class="widget am-cf">
                    <div class="widget-head am-cf">
                        <div class="widget-title am-fl">最近一周的销售金额</div>
                        <div class="widget-function am-fr">
                            <a href="javascript:;" class="am-icon-cog"></a>
                        </div>
                    </div>
                    <div class="widget-body am-fr">
                        <div style="height: 400px" class="" id="tpl-echarts-A">
                        </div>
                        <script type="text/javascript">

                            var dayOfWeek = new Date().getDay();
                            var day = new Date().getDate();
                            var year = new Date().getFullYear();
                            var month = new Date().getMonth();
                            var start = new Date(year, month, day);
                            var sumDate = [];
                            for (var i = 0; i < 7; i++) {
                                sumDate.push(new Date(year, month, day - 6 + i).getDate());
                            }
                            var lineData = [];
                            $.get({
                                url: '${ctx}/admin/getTotalSales',
                                dataType: 'json',
                                async: false,
                                success: function (data) {
                                    lineData = data;
                                }
                            })
                            // 基于准备好的dom，初始化echarts实例
                            var lineChart = echarts.init(document.getElementById('tpl-echarts-A'));
                            // line
                            optionA = {
                                xAxis: {
                                    type: 'category',
                                    data: sumDate
                                },
                                yAxis: {
                                    type: 'value'
                                },
                                textStyle: {
                                    color: '#fff'
                                },
                                series: [{
                                    data: lineData,
                                    type: 'line',
                                    itemStyle: {
                                        normal: {
                                            color: '#00FF00',
                                            lineStyle: {
                                                color: '#00FF00'
                                            }
                                        }
                                    },
                                }]

                            };
                            // 使用刚指定的配置项和数据显示图表。
                            lineChart.setOption(optionA);
                        </script>
                    </div>
                </div>
            </div>

            <div class=" am-u-md-6 am-u-sm-12">
                <div class="widget am-cf">
                    <div class="widget-head am-cf">
                        <div class="widget-title am-fl">最近一周的最受欢迎的菜</div>
                        <div class="widget-function am-fr">
                            <a href="javascript:;" class="am-icon-cog"></a>
                        </div>
                    </div>
                    <div class="widget-body am-fr">
                        <div style="height: 400px" class="" id="tpl-echarts-B">
                        </div>
                        <script type="text/javascript">
                            var hot_dish_array = [];
                            $.get({
                                url: '${ctx}/admin/getHotDishes',
                                dataType: 'json',
                                async: 'false',
                                success: function (data) {
                                    if (data != null && data.length > 0) {
                                        for (var i = 0; i < data.length; i++) {
                                            var param = {};
                                            param.value = parseInt(data[i].sumCount);
                                            param.name = data[i].d_name;
                                            hot_dish_array.push(param);
                                        }
                                    }
                                }
                            })
                            console.log(hot_dish_array);
                            // 基于准备好的dom，初始化echarts实例
                            var pieChart = echarts.init(document.getElementById('tpl-echarts-B'));

                            //这里的hot_dish_array放进去显示不出来 就写死了
                            var a = [{value: 5, name: "水煮肉片"},
                                {value: 3, name: '法式guiche'},
                                {value: 1, name: '西南石油'},
                            ];
                            console.log(a);
                            //pie
                            optionB = {
                                textStyle: {
                                    color: '#fff'
                                },
                                series: [
                                    {
                                        type: 'pie',
                                        radius: '65%',
                                        center: ['50%', '50%'],
                                        selectedMode: 'single',
                                        data: a,
                                        itemStyle: {
                                            emphasis: {
                                                shadowBlur: 10,
                                                shadowOffsetX: 0,
                                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                                            }
                                        }
                                    }
                                ]
                            };

                            // 显示图表。
                            pieChart.setOption(optionB);
                        </script>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
</div>
<script src="${ctx}/js/amazeui.min.js"></script>
<script src="${ctx}/js/app.js"></script>
<script>
    $(function () {
        //侧边栏<a>标签调节
        $('.side-link').removeClass('sub-active');
        $('.side-link').eq(4).addClass('sub-active');
    })
</script>
</body>

</html>