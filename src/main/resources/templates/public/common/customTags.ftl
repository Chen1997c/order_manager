<style>
    #loading {
        position: fixed;
        top: 0;
        left: 0;
        width: 0;
        height: 2px;
        background: deepskyblue;
        z-index: 9999999999999999999;
    }

    #custom-bg {
        position: fixed;
        display: none;
        height: 100%;
        width: 100%;
        background: rgba(0, 0, 0, 0.5);
        z-index: 9999999999;
    }
    #confirm {
        position: fixed;
        display: none;
        left: 50%;
        top: 200px;
        height: 130px;
        width: 540px;
        margin-left: -270px;
        background: #fff;
        z-index: 99999999999999;
    }

    #alert {
        position: fixed;
        display: none;
        left: 50%;
        top: 200px;
        height: 130px;
        width: 350px;
        margin-left: -175px;
        background: #fff;
        z-index: 99999999999999;
    }
</style>
    <div id="loading"></div>
    <div id="custom-bg">
    </div>
    <div id="confirm">
        <div class="confirm-title am-padding-sm">
            <div class="am-text-lg am-text-center">确认信息</div>
        </div>
        <div class="confirm-content am-text-center am-text-md am-margin-bottom">

        </div>
        <button id="cancle-btn" class="am-btn am-u-sm-6">取消</button>
        <button id="confirm-btn" class="am-btn am-btn-primary am-u-sm-6">确认</button>
    </div>
    <div id="alert">
        <div class="alert-title am-padding-sm">
            <div class="am-text-lg am-text-center">提示信息</div>
        </div>
        <div class="alert-content am-text-center am-text-md am-margin-bottom">

        </div>
        <button id="alert-btn" class="am-btn am-btn-primary am-u-sm-12">确认</button>
    </div>
    <script>
        //确认
        function confirm(e, Func) {
            $('#custom-bg').show();
            $('#confirm').fadeIn(666);
            $('.confirm-content').text(e);
            $('#confirm #cancle-btn').click(function () {
                Func(false);
                $('#confirm').hide();
                $('#custom-bg').hide();
            })
            $('#confirm #confirm-btn').click(function () {
                Func(true);
                $('#confirm').hide();
                $('#custom-bg').hide();
            })
        }

        //弹出
        function alert(e) {
            $('#custom-bg').show();
            $('#alert').fadeIn(666);
            $('.alert-content').text(e);
            $('#alert-btn').click(function () {
                $('#alert').hide();
                $('#custom-bg').hide();
            })
        }


        function reload() {
            $('#alert-btn').click(function () {
                window.location.reload();
            })
        }

        $('#loading').animate({
            width:'50%'
        },1000)

        var path = '${ctx}';//项目根目录
    </script>