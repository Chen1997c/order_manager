//封装增加、删除、修改函数
var dish_edit = {
    url: {
        delUrl: function (id) {
            return path + "/admin/deleteDish?id=" + id;
        },
        updateUrl: function () {
            return path + "/admin/updateDish";
        },
        uploadUrl: function () {
            return path + "/admin/uploadDishImg";
        },
        insertUrl: function () {
            return path + "/admin/addDish";
        },
        exportUrl : function () {
            return path + "/admin/exportDishes";
        }
    },
    executeDelete: function (id) {
        $.ajax({
            type: 'delete',
            dataType: 'json',
            url: dish_edit.url.delUrl(id),
            beforeSend: function () {
                $('.delete-dish').addClass('am-disabled');
            },
            success: function (data) {
                alert(data.message);
                if (data.code = 1) {
                    reload();
                }
            },
            complete: function () {
                $('.delete-dish').removeClass('am-disabled');
            }
        })
    },
    executeUpdate: function () {
        var param = {};
        param.d_id = $('#dish-edit-modal #edit-dish-id').val();
        param.d_name = $('#dish-edit-modal #edit-dish-name').val();
        param.d_price = $('#dish-edit-modal #edit-dish-price').val();
        param.d_isGood = $('#dish-edit-modal #edit-dish-isGood-btn').text().trim();
        param.d_description = $('#dish-edit-modal #edit-dish-description').val();
        param.d_txt = $('#dish-edit-modal #edit-dish-txt').val();
        $.ajax({
            type: 'put',
            url: dish_edit.url.updateUrl(),
            dataType: 'json',
            data: param,
            beforeSend: function () {
                $('#edit-dish-btn').addClass('am-disabled');
            },
            success: function (data) {
                alert(data.message);
                if (data.code = 1) {
                    reload();
                }
            },
            complete: function () {
                $('#edit-dish-btn').removeClass('am-disabled');
            }
        })
    },
    uploadDishImg: function (data) {
        $.post({
            dataType: 'json',
            processData: false,
            contentType: false,
            url: dish_edit.url.uploadUrl(),
            data: data,
            beforeSend: function () {
                $('#upload-dish-img-btn').addClass('am-disabled');
            },
            success: function (data) {
                alert(data.message);
            },
            complete: function () {
                $('#upload-dish-img-btn').removeClass('am-disabled');
            }
        })
    },
    executeInsert: function () {
        var param = {};
        param.d_name = $('#add-name').val();
        param.d_price = $('#add-price').val();
        param.d_isGood = $('#add-isGood').text().trim();
        param.d_description = $('#add-description').val();
        param.d_txt = $('#add-txt').val();
        $.post({
            dataType: 'json',
            url: dish_edit.url.insertUrl(),
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
    exportImg: function () {
        $.post({
            url: dish_edit.url.exportUrl(),
            dataType:'json',
            beforeSend:function () {
                $('#export').addClass('am-disabled');
            },
            success:function (data) {
                alert(data.message);
            },
            complete:function () {
                $('#export').removeClass('am-disabled');
            }
        })
    }

};

$(function () {
    //侧边栏<a>标签调节
    $('.side-link').removeClass('sub-active');
    $('.side-link').eq(3).addClass('sub-active');
})

//删除
$('.delete-dish').click(function () {
    var id = $(this).parent().parent().parent().find('#id').text().trim();
    var msg = '确定删除id为' + id + '的菜品吗?';
    var time = 0;
    confirm(msg, function (result) {
        if (result && time == 0) {
            dish_edit.executeDelete(id);
        }
        time++;
    })
})

//查看信息
$('.see-dInfo').click(function () {
    var name = $(this).parent().parent().parent().find('#name').val();
    var price = $(this).parent().parent().parent().find('#price').val();
    var isGood = $(this).parent().parent().parent().find('#isGood').val();
    var description = $(this).parent().parent().parent().find('#description').val();
    var txt = $(this).parent().parent().parent().find('#txt').val();
    var img = $(this).parent().parent().parent().find('#img').val().trim();
    $('#dish-info-modal #name').text(name);
    $('#dish-info-modal #price').text(price);
    $('#dish-info-modal #isGood').text(isGood);
    $('#dish-info-modal #description').text(description);
    $('#dish-info-modal #txt').text(txt);
    if (img != '') {
        $('#info-img').attr({
            src: path + img + "?" + Math.random()
        })
    } else {
        $('#info-img').attr({
            src: path + '/images/ddr.jpg'
        })
    }

})

//编辑信息
$('.edit-dInfo').click(function () {
    var id = $(this).parent().parent().parent().find('#id').text();
    var name = $(this).parent().parent().parent().find('#name').val();
    var price = $(this).parent().parent().parent().find('#price').val();
    var isGood = $(this).parent().parent().parent().find('#isGood').val();
    var description = $(this).parent().parent().parent().find('#description').val();
    var txt = $(this).parent().parent().parent().find('#txt').val().trim();
    var img = $(this).parent().parent().parent().find('#img').val().trim();
    $('#dish-edit-modal #edit-dish-id').val(id);
    $('#dish-edit-modal #edit-dish-name').val(name);
    $('#dish-edit-modal #edit-dish-price').val(price);
    $('#dish-edit-modal #edit-dish-isGood-btn').text(isGood);
    $('#dish-edit-modal #edit-dish-description').val(description);
    $('#dish-edit-modal #edit-dish-txt').val(txt);
    if (img != '') {
        $('#dish-img').attr({
            src: path + img + "?" + Math.random()
        })
    } else {
        $('#dish-img').attr({
            src: path + '/images/ddr.jpg'
        })
    }
})

//选择框
$('.edit-modal .choose-tag-good').click(function () {
    if (!$(this).hasClass('am-active')) {
        $('.dish-isGood-btn').text($(this).text());
        $('.edit-modal .choose-tag-good').removeClass('am-active');
        $(this).addClass('am-active');
    }
})

//修改
$('#dish-edit-form').on('submit', function () {
    var time = 0;
    confirm('确认修改吗', function (result) {
        if (result && time == 0) {
            dish_edit.executeUpdate();
        }
        time++;
    })
})

//上传图片
$('#edit-dish-img').on('change', function () {
    var filePath = $(this).val();
    var fileFormat = filePath.substring(filePath.lastIndexOf('.')).toLowerCase();
    var src = window.URL.createObjectURL(this.files[0]);
    if (!fileFormat.match(/.png|.jpeg|.jpg/)) {
        alert('上传错误,文件格式必须为：png/jpg/jpeg');
        return;
    }
    $('#dish-img').attr('src', src);
    var fileNames = '';
    $.each(this.files, function () {
        fileNames += '<span class="am-badge">' + this.name + '</span> ';
    });
    $('#file-list').html(fileNames);
    var time = 0;
    confirm('上传成功,是否保存?', function (result) {
        if (result && time == 0) {
            var formData = new FormData();
            formData.append('file', document.getElementById('edit-dish-img').files[0]);
            formData.append('id', $('#dish-edit-modal #edit-dish-id').val().trim());
            dish_edit.uploadDishImg(formData);
        }
        time++;
    })
});


//添加菜品
$('#add-dish-form').submit(function () {
    var time = 0;
    confirm('确认添加吗', function (result) {
        if (result && time == 0) {
            dish_edit.executeInsert();
        }
        time++;
    })
})

//导出excel
$('#export').click(function () {
    var time = 0;
    confirm('确认导出吗?', function (result) {
        if (result && time == 0) {
            dish_edit.exportImg();
        }
        time++;
    })
})