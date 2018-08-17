var pay = {
    url: {
        deleteUrl: function (id) {
            return path + '/waiter/deleteOrder?o_id=' + id;
        },
        payUrl: function () {
            return path + '/waiter/payOrder';
        }
    },
    executeDelete: function (id) {
        $.ajax({
            type: 'delete',
            dataType: 'json',
            url: pay.url.deleteUrl(id),
            success: function (data) {
                alert(data.message);
                if (data.code == 1)
                    reload();
            }
        })
    },
    executePay: function (id,table_id) {
        console.log(table_id);
        $.ajax({
            type: 'put',
            dataType: 'json',
            url: pay.url.payUrl(),
            data: {
                o_id: id,
                table_id: table_id
            },
            success: function (data) {
                alert(data.message);
                if (data.code == 1)
                    reload();
            }
        })
    },
    init: function () {
        //侧边导航样式
        $('.waiter-nav-href').removeClass('active');
        $('.waiter-nav-href').eq(1).addClass('active');
    }
}

//查看信息
$('.info').click(function () {
    var order_id = $(this).parent().parent().parent().find("#order-id").text();
    var table_id = $(this).parent().parent().parent().find("#table-id").text();
    var waiter_id = $(this).parent().parent().parent().find("#waiter-id").text();
    var begin_time = $(this).parent().parent().parent().find("#begin-time").text();
    var end_time = $(this).parent().parent().parent().find("#end-time").val();
    var order_state = $(this).parent().parent().parent().find("#order-state").text();
    $('#pay-info-modal #order-id').text(order_id);
    $('#pay-info-modal #table-id').text(table_id);
    $('#pay-info-modal #waiter-id').text(waiter_id);
    $('#pay-info-modal #begin-time').text(begin_time);
    $('#pay-info-modal #end-time').text(end_time);
    $('#pay-info-modal #state').text(order_state);
    var total_price = 0.00;
    $('#dish-content').html('');
    $(this).parent().parent().parent().find('.dish-bar').each(function () {
        var name = $(this).find('.dish-name').val();
        var number = parseInt($(this).find('.dish-number').val());
        var price = parseFloat($(this).find('.dish-price').val());
        total_price += number * price;
        $('#dish-content').append(
            '<tr><td>' + name + '</td><td>' + number + '</td><td>' + price + '<td></tr>'
        )
    })
    $('#pay-info-modal #total-price').text(total_price);
})

//修改
$('.edit').click(function () {
    var order_id = $(this).parent().parent().parent().find("#order-id").text();
    $('#pay-edit-modal #order-id').text(order_id);
})

//删除
$('.delete').click(function () {
    var order_id = $(this).parent().parent().parent().find("#order-id").text();
    var time = 0;
    confirm('确认删除订单编号为' + order_id + '的订单吗?', function (result) {
        if (result && time == 0) {
            pay.executeDelete(order_id);
        }
        time++;
    })
})

//支付
$('.pay').click(function () {
    var state = $(this).parent().parent().parent().find('#order-state').text();
    var table_id = $(this).parent().parent().parent().find('#table-id').text();
    if (state == '已完成') {
        alert('该订单已完成!');
        return;
    }
    var order_id = $(this).parent().parent().parent().find("#order-id").text();
    var time = 0;
    confirm('确认买单订单编号为' + order_id + '的订单吗?', function (result) {
        if (result && time == 0) {
            pay.executePay(order_id,table_id);
        }
        time++;
    })
})