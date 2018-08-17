var table_edit = {
    url: {
        insertUrl: function () {
            return path + "/admin/addTable";
        },
        deleteUrl: function (id) {
            return path + "/admin/deleteTable?table_id=" + id;
        },
        updateUrl: function () {
            return path + "/admin/updateSate";
        }
    },
    executeInsert: function () {
        var table_number = $('#add-table-number').val();
        console.log(table_edit.url.insertUrl());
        $.post({
            url: table_edit.url.insertUrl(),
            dataType: 'json',
            data: {
                table_number: table_number
            },
            beforeSend: function () {
                $('#add-table-btn').addClass('am-disabled');
            },
            success: function (data) {
                alert(data.message);
                if (data.code == 1)
                    reload();
            },
            complete: function () {
                $('#add-table-btn').removeClass('am-disabled');
            }
        })
    },
    executeDelete: function (id) {
        $.ajax({
            type: 'delete',
            url: table_edit.url.deleteUrl(id),
            dataType: 'json',
            success: function (data) {
                alert(data.message);
                if (data.code == 1)
                    reload();
            }
        })
    },
    executeUpdate: function (id,is_used) {
        $.ajax({
            type: 'put',
            url: table_edit.url.updateUrl(),
            dataType: 'json',
            data: {
                dt_id: id,
                is_used: is_used
            },
            success: function (data) {
                alert(data.message);
                if (data.code == 1)
                    reload();
            }
        })
    }
}

$(function () {
    //侧边栏<a>标签调节
    $('.side-link').removeClass('sub-active');
    $('.side-link').eq(3).addClass('sub-active');
})

$('#table-add-form').submit(function () {
    var time = 0;
    confirm('确定添加吗?', function (result) {
        if (result && time == 0) {
            table_edit.executeInsert();
        }
        time++;
    })
})

$('.del-btn').click(function () {
    var id = $(this).parent().find('.table-id').attr('id');
    var number = $(this).parent().find('.table-number').text();
    var time = 0;
    confirm('确定要删除第' + number + '号餐桌吗?', function (result) {
        if (result && time == 0) {
            table_edit.executeDelete(id);
        }
        time++;
    })
})

$('.edit-btn').click(function () {
    var id = $(this).parent().find('.table-id').attr('id');
    var number = $(this).parent().find('.table-number').text();
    var isUsed = $(this).next().val();
    var time = 0;
    confirm('确定修改第' + number + '号餐桌的状态吗?', function (result) {
        if (result && time == 0) {
            table_edit.executeUpdate(id,isUsed);
        }
        time++;
    })
})