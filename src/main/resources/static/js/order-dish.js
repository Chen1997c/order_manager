var dishRecords = new Vue({
    el: '#dishRecords',
    data: {
        path: path,
        records: '',
        limit: 1,
        total: '',
        tables: ''
    },
    methods: {
        addCount: function (e) {
            var $element = $(e.currentTarget);
            var count = parseInt($element.parent().next().val());
            if (count < 20)
                $element.parent().next().val(count + 1);
        },
        subCount: function (e) {
            var $element = $(e.currentTarget);
            var count = parseInt($element.parent().prev().val());
            if (count > 0)
                $elementparent().prev().val(count - 1);
        },
    }
})
var order = {
    url: {
        placeOrderUrl: function () {
            return path + "/waiter/placeOrder";
        },
        getDishesUrl: function () {
            return path + "/waiter/getDishRecords";
        },
        getTablesUrl: function () {
            return path + "/waiter/getTables";
        },
        checkTable: function () {
            return path + "/waiter/checkTable";
        }
    },
    placeOrder: function (totalData) {
        var data = JSON.stringify(totalData);
        console.log(data);
        $.post({
            url: order.url.placeOrderUrl(),
            dataType: 'json',
            contentType: "application/json;charset=UTF-8",
            data: data,
            beforeSend: function () {
                $('#placeOderBtn').addClass('am-disabled');
            },
            success: function (data) {
                alert(data.message);
                if (data.code == 1)
                    reload();
            },
            complete: function () {
                $('#placeOderBtn').removeClass('am-disabled');
            }
        })
    },
    searDish: function () {
        $('.count-input').val(0);
        var d_name = $('#search-input').val();
        if (d_name == '') {
            alert('请输入搜索内容~!');
            return;
        }
        order.getDishes(-1, d_name);
        return false;
    },
    getDishes: function (limit, d_name) {
        $.get({
            url: order.url.getDishesUrl(),
            dataType: 'json',
            async: false,
            data: {
                limit: limit,
                d_name: d_name
            },
            success: function (data) {
                dishRecords.$set(dishRecords, 'records', data.records);
                dishRecords.$set(dishRecords, 'limit', limit);
                dishRecords.$set(dishRecords, 'total', data.total);
            },
            complete: function () {
                var limit = dishRecords.$data.limit;
                var total = dishRecords.$data.total;
                if (limit * 3 > total || limit < 0) {
                    $('#showMore').hide();
                } else {
                    $('#showMore').show();
                }
            },
            error: function () {
                alert('从服务器获取数据失败!');
            }
        })
    },
    showMore: function () {
        var limit = dishRecords.$data.limit;
        order.getDishes(limit + 1);
    },
    getTables: function () {
        $.get({
            url: order.url.getTablesUrl(),
            dataType: 'json',
            async: false,
            success: function (data) {
                dishRecords.$set(dishRecords, 'tables', data);
            }
        })
    },
    checkTableIsUsed: function (table_id) {
        var result = false;
        $.get({
            url: 'checkTable',
            dataType: 'json',
            async: false,
            data: {
                dt_id: table_id
            },
            success: function (data) {
                if (data.code == 1)
                    result = true;
            }
        })
        return result;
    },
    init: function () {

        //侧边导航样式
        $('.waiter-nav-href').removeClass('active');
        $('.waiter-nav-href').eq(0).addClass('active');

        //获取菜品
        order.getDishes(1);

        //获取餐桌信息
        order.getTables();

        //下订单
        $('#placeOrderBtn').click(function () {
            var order_flag = false;
            var totalData = {};
            totalData.o_table_id = parseInt($('#tableNo').val().trim());
            totalData.o_waiter_id = parseInt($('#waiter_id').val());
            var sum = 0;
            var listing = [];
            $('#dish-content').html('');
            $('.count-input').each(function () {
                var count = parseInt($(this).val());
                if (count > 0) {
                    var name = $(this).parent().parent().parent().find("#name").text();
                    var price = parseFloat($(this).parent().parent().parent().find("#price").text());
                    sum += price * count;
                    var param = {};
                    param.oc_dish_id = parseInt($(this).attr('id'));
                    param.oc_dishNo = count;
                    listing.push(param)
                    order_flag = true;
                    $('#dish-content').append(
                        '<tr><td>' + name + '</td><td>' + count + '</td><td>' + price + '<td></tr>'
                    )
                }
            })
            if (!order_flag) {
                alert("啥都还没选呢！");
                return;
            }
            if (order.checkTableIsUsed(totalData.o_table_id)) {
                $('#buy-car-modal').modal('toggle');
                totalData.orderContents = listing;
                $('#toBuy').click(function () {
                    console.log(1);
                    var time = 0;
                    var msg = "所选菜品价格一共为" + sum + ",确认下单吗?";
                    confirm(msg, function (result) {
                        if (result && time == 0) {
                            order.placeOrder(totalData);
                        }
                        time++;
                    })
                })

            } else {
                alert('您所选的餐桌还有人正在用餐!');
            }
        })

    }
}



