<style>
    .user-info-body td {
        border: 0px !important;
    }
</style>
        <div class="am-modal am-modal-no-btn" tabindex="-1" id="user-info-modal">
            <div class="am-modal-dialog" id="modal-dialog">
                <div class="am-modal-hd">
                    <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
                </div>
                <div class="am-modal-bd">
                    <div class="user-info-avatar">
                        <img id="user-info-img" src="${ctx}/images/user01.png" class="am-round" style="width:100px;height: 100px">
                    </div>
                    <div class="user-info-body">
                        <h2>个人信息</h2>
                        <hr>
                        <table class="am-table">
                            <tr>
                                <td>帐号名</td>
                                <td id="account"></td>
                            </tr>
                            <tr>
                                <td>职位</td>
                                <td id="position"></td>
                            </tr>
                            <tr>
                                <td>姓名</td>
                                <td id="name"></td>
                            </tr>
                            <tr>
                                <td>性别</td>
                                <td id="sex"></td>
                            </tr>
                            <tr>
                                <td>手机号</td>
                                <td id="phoneNo"></td>
                            </tr>
                            <tr>
                                <td>住址</td>
                                <td id="address"></td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
        </div>