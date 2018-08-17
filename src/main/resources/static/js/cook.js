var cook = {
    url: {
        cookUrl: function () {
            return path + '/cooker/cook';
        },
        publishUrl: function () {
            return path + '/cooker/publish';
        },
        deleteUrl: function (id) {
            return path + '/cooker/delete?oc_id=' + id;
        }
    },
    executeCook: function (id) {
        $.ajax({
            type: 'put',
            url: cook.url.cookUrl(),
            dataType: 'json',
            data: {
                oc_id: id
            },
            success: function (data) {
                alert(data.message);
                if (data.code == 1)
                    reload();
            }
        })
    },
    excutePulish: function (id) {
        $.ajax({
            type: 'put',
            url: cook.url.publishUrl(),
            dataType: 'json',
            data: {
                oc_id: id
            },
            success: function (data) {
                alert(data.message);
                if (data.code == 1)
                    reload();
            }
        })
    },
    exceteDelete: function (id) {
        $.ajax({
            type: 'delete',
            url: cook.url.deleteUrl(id),
            dataType: 'json',
            success: function (data) {
                alert(data.message);
                if (data.code == 1)
                    reload();
            }
        })
    }
}

//烹饪
$('.cook').click(function () {
    var order_content_id = $(this).parent().parent().parent().find('#oc-id').val();
    var time = 0;
    confirm('确定烹饪吗?', function (result) {
        if (result && time == 0) {
            cook.executeCook(order_content_id);
        }
        time++;
    })
})

//传菜
$('.publish').click(function () {
    var order_content_id = $(this).parent().parent().parent().find('#oc-id').val();
    var time = 0;
    confirm('确定传菜吗?', function (result) {
        if (result && time == 0) {
            cook.excutePulish(order_content_id);
        }
        time++;
    })
})

//删除
$('.delete').click(function () {
    var order_content_id = $(this).parent().parent().parent().find('#oc-id').val();
    var time = 0;
    confirm('确定传菜吗?', function (result) {
        if (result && time == 0) {
            cook.exceteDelete(order_content_id);
        }
        time++;
    })
})