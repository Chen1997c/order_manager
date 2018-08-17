//封装增加、删除、修改函数
var user_edit = {
    url: {
        updateUrl: function () {
            return path + '/admin/updateUser';
        },
        deleteUrl: function (id) {
            return path + '/admin/deleteUser?id=' + id;
        },
        insertUrl: function () {
            return path + '/admin/addUser';
        },
        resetPassUrl: function () {
            return path + '/admin/resetPass';
        },
        uploadImgUrl: function () {
            return path + '/admin/uploadAvatar/';
        }
    },
    executeUpdate: function () {
        var param = {};
        param.u_id = $('#user-id').text().trim();
        param.u_name = $('#edit-name').val().trim();
        param.u_phoneNo = $('#edit-phoneNo').val().trim();
        param.u_sex = $('#edit-sex').text().trim();
        param.u_address = $('#edit-address').val().trim();
        param.u_isLocked = $('#edit-lock').text().trim();
        if ($('#user-edit-modal #edit-position').text().trim() == 'waiter') {
            param.u_position_id = 1;
        } else if ($('#user-edit-modal #edit-position').text().trim() == 'cooker') {
            param.u_position_id = 2;
        } else {
            param.u_position_id = 3;
        }
        $.ajax({
            type: 'put',
            url: user_edit.url.updateUrl(),
            dataType: 'json',
            data: param,
            cache: false,
            beforeSend: function () {
                $('#edit-sub-btn').addClass('am-disabled');
            },
            success: function (data) {
                alert(data.message);
                if (data.code == 1) {
                    reload();
                }
            },
            complete: function () {
                $('#edit-sub-btn').removeClass('am-disabled');
            }
        })
    },
    executeDelete: function (id) {
        $.ajax({
            type: 'delete',
            dataType: 'json',
            url: user_edit.url.deleteUrl(id),
            cache: false,
            beforeSend: function () {
                $('.delete-user').addClass('am-disabled');
            },
            success: function (data) {
                alert(data.message);
                if (data.code = 1) {
                    reload();
                }
            },
            complete: function () {
                $('.delete-user').removeClass('am-disabled');
            }
        })
    },
    executeInsert: function () {
        var param = {};
        param.u_name = $('#add-name').val().trim();
        param.u_phoneNo = $('#add-phoneNo').val().trim();
        param.u_sex = $('#add-sex').text().trim();
        param.u_address = $('#add-address').val().trim();
        param.u_account = $('#add-account').val().trim();
        param.u_password = $('#add-password').val().trim();
        if ($('#add-position').text().trim() == 'waiter') {
            param.u_position_id = 1;
        } else if ($('#add-position').text().trim() == 'cooker') {
            param.u_position_id = 2;
        } else {

            param.u_position_id = 3;
        }
        $.post({
            dataType: 'json',
            url: user_edit.url.insertUrl(),
            data: param,
            cache: false,
            beforeSend: function () {
                $('#add-sub-btn').addClass('am-disabled');
            },
            success: function (data) {
                alert(data.message);
                if (data.code == 1) {
                    reload();
                }
            },
            complete: function () {
                $('#add-sub-btn').removeClass('am-disabled');
            }
        })
    },
    resetPass: function (id, password) {
        $.ajax({
            type: 'put',
            dataType: 'json',
            url: user_edit.url.resetPassUrl(),
            data: {
                u_id: id,
                u_password: password
            },
            beforeSend: function () {
                $('#reset-password-btn').addClass('am-disabled');
            },
            success: function (data) {
                alert(data.message);
            },
            complete: function () {
                $('#reset-password-btn').removeClass('am-disabled');
            }
        })
    },
    uploadImg: function (data) {
        $.post({
            dataType: 'json',
            processData: false,
            contentType: false,
            url: user_edit.url.uploadImgUrl(),
            data: data,
            beforeSend: function () {
                $('#upload-avatar-btn').addClass('am-disabled');
            },
            success: function (data) {
                alert(data.message);
            },
            complete: function () {
                $('#upload-avatar-btn').removeClass('am-disabled');
            }
        })
    }
};

$(function () {
    //侧边栏<a>标签调节
    $('.side-link').removeClass('sub-active');
    $('.side-link').eq(0).addClass('sub-active');
})

//查看信息
$('.see-eInfo').click(function () {
    var account = $(this).parent().parent().parent().find('#account').val();
    var position = $(this).parent().parent().parent().find('#position').val();
    var name = $(this).parent().parent().parent().find('#name').val();
    var sex = $(this).parent().parent().parent().find('#sex').val();
    var phoneNo = $(this).parent().parent().parent().find('#phoneNo').val();
    var address = $(this).parent().parent().parent().find('#address').val();
    var faceImg = $(this).parent().parent().parent().find('#faceImg').val().trim();
    $('.user-info-body #account').text(account);
    $('.user-info-body #position').text(position);
    $('.user-info-body #name').text(name);
    $('.user-info-body #sex').text(sex);
    $('.user-info-body #phoneNo').text(phoneNo);
    $('.user-info-body #address').text(address);
    if (faceImg != '') {
        $('#user-info-img').attr({
            src: path + faceImg + "?" + Math.random()
        })
    } else {
        $('#user-info-img').attr({
            src: path + '/images/user01.png'
        })
    }
})

//修改信息
$('.edit-eInfo').click(function () {
    var id = $(this).parent().parent().parent().find('#id').text();
    var name = $(this).parent().parent().parent().find('#name').val();
    var sex = $(this).parent().parent().parent().find('#sex').val();
    var phoneNo = $(this).parent().parent().parent().find('#phoneNo').val();
    var address = $(this).parent().parent().parent().find('#address').val();
    var account = $(this).parent().parent().parent().find('#account').val();
    var position = $(this).parent().parent().parent().find('#position').val();
    var isLocked = $(this).parent().parent().parent().find('#isLocked').val();
    var faceImg = $(this).parent().parent().parent().find('#faceImg').val().trim();
    $('#user-edit-modal #edit-name').val(name);
    $('#user-edit-modal #edit-sex').text(sex);
    $('#user-edit-modal #edit-phoneNo').val(phoneNo);
    $('#user-edit-modal #edit-address').val(address);
    $('#user-edit-modal #account').val(account);
    $('#user-edit-modal #user-id').text(id);
    $('#user-edit-modal #edit-position').text(position);
    $('#user-edit-modal #edit-lock').text(isLocked);
    if (faceImg != '') {
        $('#avatar-img').attr({
            src: path + faceImg + "?" + Math.random()
        })
    } else {
        $('#avatar-img').attr({
            src: path + '/images/user01.png'
        })
    }
})

$('.info-modal .choose-tag-sex').click(function () {
    if (!$(this).hasClass('am-active')) {
        $('.sex-btn').text($(this).text());
        $('.info-modal .choose-tag-sex').removeClass('am-active');
        $(this).addClass('am-active');
    }
})

$('.info-modal .choose-tag-position').click(function () {
    if (!$(this).hasClass('am-active')) {
        $('.position-btn').text($(this).text());
        $('.info-modal .choose-tag-position').removeClass('am-active');
        $(this).addClass('am-active');
    }
})

$('.info-modal .choose-tag-lock').click(function () {
    if (!$(this).hasClass('am-active')) {
        $('.lock-btn').text($(this).text());
        $('.info-modal .choose-tag-lock').removeClass('am-active');
        $(this).addClass('am-active');
    }
})

var count = 0;
//删除
$('.delete-user').click(function () {
    var id = $(this).parent().parent().parent().find('#id').text().trim();
    var msg = '确定删除id为' + id + '的员工信息吗?';
    var time = 0;//解决第n次点击执行n次confirm函数的bug
    confirm(msg, function (result) {
        if (result && time == 0) {
            user_edit.executeDelete(id);
        }
        time++;
    })
})

$('#user-edit-modal form').eq(0).submit(function () {
    $('.edit-type').eq(0).removeClass('am-btn-primary');
    $('.edit-type').eq(1).addClass('am-btn-primary');
    $(this).hide();
    $('#user-edit-modal form').eq(1).show();
    return false;
})

$('#user-edit-modal #previous-btn').click(function () {
    $('.edit-type').eq(1).removeClass('am-btn-primary');
    $('.edit-type').eq(0).addClass('am-btn-primary');
    $('#user-edit-modal form').eq(1).hide();
    $('#user-edit-modal form').eq(0).show();
})

$('#user-add-modal form').eq(0).submit(function () {
    $('.add-type').eq(0).removeClass('am-btn-primary');
    $('.add-type').eq(1).addClass('am-btn-primary');
    $(this).hide();
    $('#user-add-modal form').eq(1).show();
    return false;
})

$('#user-add-modal #previous-btn').click(function () {
    $('.add-type').eq(1).removeClass('am-btn-primary');
    $('.add-type').eq(0).addClass('am-btn-primary');
    $('#user-add-modal form').eq(1).hide();
    $('#user-add-modal form').eq(0).show();
})

//修改
$('#user-edit-modal form').eq(1).submit(function () {
    var time = 0;
    confirm('确认修改吗', function (result) {
        if (result && time == 0) {
            user_edit.executeUpdate();
        }
        time++;
    })
})

//添加
$('#user-add-modal form').eq(1).submit(function () {
    var time = 0;
    confirm('确认添加吗', function (result) {
        if (result && time==0) {
            user_edit.executeInsert();
        }
        time++;
    })
})

//重置密码
$('#reset-password-btn').click(function () {
    var id = $('.info-modal #user-id').text().trim();
    var password = $('#reset-password-value').val().trim();
    var regex = /^\S{6,15}$/;
    if (regex.test(password)) {
        var time = 0;
        confirm('确定重置密码为:' + password, function (result) {
            if (result && time == 0) {
                user_edit.resetPass(id, password);
            }
            time++;
        })
    } else {
        alert('内容不合规范!');
    }

})

//上传头像
$('#edit-avatar-img').on('change', function () {
    var filePath = $(this).val();
    var fileFormat = filePath.substring(filePath.lastIndexOf('.')).toLowerCase();
    var src = window.URL.createObjectURL(this.files[0]);
    if (!fileFormat.match(/.png|.jpeg|.jpg/)) {
        alert('上传错误,文件格式必须为：png/jpg/jpeg');
        return;
    }
    $('#avatar-img').attr('src', src);
    var fileNames = '';
    $.each(this.files, function () {
        fileNames += '<span class="am-badge">' + this.name + '</span> ';
    });
    $('#file-list').html(fileNames);
    var time = 0;
    confirm('上传成功,是否保存?', function (result) {
        if (result && time == 0) {
            var formData = new FormData();
            formData.append('file', document.getElementById('edit-avatar-img').files[0]);
            formData.append('id', $('.info-modal #user-id').text().trim());
            user_edit.uploadImg(formData);
        }
        time ++;
    })
});
