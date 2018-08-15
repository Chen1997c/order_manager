//封装登录函数
var login = {
    url: {
        subUrl: function () {
            return path + '/subLogin';
        },
        cookerUrl: function () {
            return path + '/index.html';
        },
        adminUrl: function(){
            return path + '/admin/index.html';
        },
        waiterUrl:function(){
            return path + '/waiter/orderDish.html';
        },
        codeImgUrl: function () {
            return path + '/VCodeImg?' + Math.random();
        }
    },
    validateWidthDB: function (u_account, u_password, verifycode) {
        $.post({
            url: login.url.subUrl(),
            dataType: 'json',
            async:false,
            data: {
                u_account: u_account,
                u_password: u_password,
                verifyCode: verifycode
            },
            beforeSend: function () {
                $('login-btn').addClass('am-disabled');
            },
            success: function (data) {
                if (data.code == 1) {
                    if(data.data.u_position_id == 1) {
                        window.location = login.url.waiterUrl();
                    }else if(data.data.u_position_id == 2) {
                        window.location = login.url.cookerUrl();
                    }else {
                        window.location = login.url.adminUrl();
                    }
                } else {
                    $('.response-msg').html(data.message);
                    if (data.code == 0) {
                        $('#password').val('');
                        $('#password').parent().addClass('am-form-error');
                        $('#verifycode').val('');
                        $('#verifycode').parent().addClass('am-form-error');
                        $('#VCodeImg').attr('src',login.url.codeImgUrl());
                    } else {
                        $('#verifycode').val('');
                        $('#verifycode').parent().addClass('am-form-error');
                        $('#VCodeImg').attr('src',login.url.codeImgUrl());
                    }
                }
            },
            complete: function () {
                $('login-btn').removeClass('am-disabled');
            }
        })
        return false;
    },
    init: function () {
        $('.login-box').on('submit',function () {
            var u_account = $('#account').val();
            var u_password = $('#password').val();
            var verifyCode = $('#verifycode').val();
            login.validateWidthDB(u_account,u_password,verifyCode);
            return false;
        })
        $('#VCodeImg').click(function () {
            $(this).attr('src',  login.url.codeImgUrl());
        })
    }
}

