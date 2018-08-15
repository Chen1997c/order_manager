//封装增加、删除、修改函数
var custom_edit = {
    url: {
        delUrl: function (id) {
            return path + "/admin/deleteCustom?id=" + id;
        },
        insertUrl: function () {
            return path + "/admin/addCustom";
        },
        updateUrl: function () {
            return path + "/admin/updateCustom";
        }
    },
    executeDelete: function (id) {
        $.ajax({
            type: 'delete',
            dataType: 'json',
            url: custom_edit.url.delUrl(id),
            beforeSend: function () {
                $('.delete-custom').addClass('am-disabled');
            },
            success: function (data) {
                alert(data.message);
                if (data.code = 1) {
                    reload();
                }
            },
            complete: function () {
                $('.delete-custom').removeClass('am-disabled');
            }
        })
    },
    executeInsert: function () {
        var param = {};
        param.c_name = $('#add-name').val();
        param.c_sex = $('#add-sex').text().trim();
        param.c_phoneNo = $('#add-phoneNo').val();
        $.post({
            dataType: 'json',
            url: custom_edit.url.insertUrl(),
            data: param,
            beforeSend: function () {
                $('#add-btn').addClass('am-disabled');
            },
            success: function (data) {
                alert(data.message);
                if (data.code == 1)
                    reload();
            },
            complete: function () {
                $('#add-btn').removeClass('am-disabled');

            }
        })
    },
    executeUpdate: function () {
        var param = {};
        param.c_id = $('#custom-edit-modal #edit-custom-id').val();
        param.c_name = $('#custom-edit-modal #edit-custom-name').val();
        param.c_sex = $('#custom-edit-modal #edit-custom-sex').text().trim();
        param.c_phoneNo = $('#custom-edit-modal #edit-custom-phoneNo').val();
        param.c_dinningTimes = $('#custom-edit-modal #edit-custom-dinningTimes').val();
        param.c_dinningSum = $('#custom-edit-modal #edit-custom-dinningSum').val();
        $.ajax({
            type: 'put',
            dataType: 'json',
            url: custom_edit.url.updateUrl(),
            data: param,
            beforeSend: function () {
                $('#edit-custom-btn').addClass('am-disabled');
            },
            success: function (data) {
                alert(data.message);
                if (data.code == 1)
                    reload();
            },
            complete: function () {
                $('#edit-custom-btn').removeClass('am-disabled');

            }
        })
    }

};

$(function () {
    //侧边栏<a>标签调节
    $('.side-link').removeClass('sub-active');
    $('.side-link').eq(4).addClass('sub-active');
})

//编辑信息
$('.edit-cInfo').click(function () {
    var id = $(this).parent().parent().parent().find('#id').text();
    var name = $(this).parent().parent().parent().find('#name').text();
    var sex = $(this).parent().parent().parent().find('#sex').text();
    var dinningTimes = $(this).parent().parent().parent().find('#dinningTimes').text();
    var dinningSum = $(this).parent().parent().parent().find('#dinningSum').text();
    var phoneNo = $(this).parent().parent().parent().find('#phoneNo').val();
    $('#custom-edit-modal #edit-custom-id').val(id);
    $('#custom-edit-modal #edit-custom-name').val(name);
    $('#custom-edit-modal #edit-custom-phoneNo').val(phoneNo);
    $('#custom-edit-modal #edit-custom-dinningTimes').val(dinningTimes);
    $('#custom-edit-modal #edit-custom-dinningSum').val(dinningSum);
    $('#custom-edit-modal #edit-custom-sex').text().trim();
})

//选择框
$('.edit-modal .choose-tag-sex').click(function () {
    if (!$(this).hasClass('am-active')) {
        $('.custom-sex-btn').text($(this).text());
        $('.edit-modal .choose-tag-sex').removeClass('am-active');
        $(this).addClass('am-active');
    }
})

//删除
$('.delete-custom').click(function () {
    var id = $(this).parent().parent().parent().find('#id').text().trim();
    var msg = '确定删除id为' + id + '的客户吗?';
    var time = 0;
    confirm(msg, function (result) {
        if (result && time == 0) {
            custom_edit.executeDelete(id);
        }
        time++;
    })
})


//添加客户
$('#add-custom-form').submit(function () {
    var time = 0;
    confirm('确认添加吗', function (result) {
        if (result && time == 0) {
            custom_edit.executeInsert();
        }
        time++;
    })
})

//编辑
$('#custom-edit-form').on('submit', function () {
    var time = 0;
    confirm('确认修改吗', function (result) {
        if (result && time == 0) {
            custom_edit.executeUpdate();
        }
        time++;
    })
})