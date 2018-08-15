<div class="info-modal am-modal am-modal-no-btn" tabindex="-1" id="user-add-modal">
    <div class="am-modal-dialog" id="modal-dialog">
        <div class="am-modal-hd">添加员工
            <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
        </div>
        <hr>
        <div class="am-g am-g-collapse am-margin-bottom-lg">
            <div class="am-u-sm-6">
                <button class="am-btn add-type am-btn-primary" style="width:100%">个人信息</button>
            </div>
            <div class="am-u-sm-6">
                <button class="am-btn add-type" style="width:100%">管理信息</button>
            </div>
        </div>
        <div class="am-modal-bd">
            <div class="user-info-body am-u-sm-12">
                <form class="am-form am-text-left am-animation-slide-top" onsubmit="return false">
                    <div class="am-form-group">
                        <label>姓名</label>
                        <input type="text" id="add-name" class="am-form-field am-input-sm am-circle"
                               pattern="^\S{1,10}$" required>
                    </div>
                    <div class="am-form-group">
                        <label>手机</label>
                        <input type="text" id="add-phoneNo" class="am-form-field am-input-sm am-circle"
                               pattern="^\d{11}$" placeholder="11位数字" required>
                        <div class="am-dropdown am-margin-top" data-am-dropdown>
                            <label>性别 </label>&nbsp;&nbsp;&nbsp;&nbsp;
                            <button id="add-sex" class="sex-btn am-btn am-btn-primary am-btn-lg am-dropdown-toggle"
                                    data-am-dropdown-toggle>男
                                <span class="am-icon-caret-down"></span>
                            </button>
                            <ul class="am-dropdown-content">
                                <li id="man" class="choose-tag-sex">
                                    <a href="#">男</a>
                                </li>
                                <li id="woman" class="choose-tag-sex">
                                    <a href="#">女</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="info-form-important am-form-group am-text-left">
                        <label>住址</label>
                        <input type="text" id="add-address" class="am-form-field am-input-sm  am-circle"
                               pattern="^\S{0,100}$">
                    </div>
                    <div class="am-form-group am-text-right">
                        <input type="submit" id="next-btn" class="am-btn am-btn-warning" value="下一步">
                    </div>
                </form>
                <form class="am-form am-text-left am-animation-slide-top" onsubmit="return false"
                      style="display: none">
                    <label for="">帐号</label>
                    <div class="am-form-group">
                        <input type="text" id="add-account" class="am-form am-input-sm am-form-field" pattern="^\S{1,20}$" required>
                    </div>
                    <label>密码</label>
                    <div class="am-form-group am-margin-bottom">
                        <input type="text" id="add-password" class="am-input-sm am-form-field" pattern="^\w{1,20}$"
                               required>
                    </div>
                    <div class="am-form-group">
                        <div class="am-dropdown am-margin-top" data-am-dropdown>
                            <label>角色 </label>&nbsp;&nbsp;&nbsp;&nbsp;
                            <button id="add-position" class="position-btn am-btn am-btn-primary am-dropdown-toggle"
                                    data-am-dropdown-toggle>waiter
                                <span class="am-icon-caret-down"></span>
                            </button>
                            <ul class="am-dropdown-content">
                                <li id="waiter" class="choose-tag-position">
                                    <a href="#">waiter</a>
                                </li>
                                <li id="cooker" class="choose-tag-position">
                                    <a href="#">cooker</a>
                                </li>
                                <li id="admin" class="choose-tag-position">
                                    <a href="#">admin</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="am-form-group am-text-right am-margin-top-lg">
                        <input type="button" id="previous-btn" class="am-btn am-btn-warning" value="上一步">
                        <input type="submit" id="add-sub-btn" class="am-btn am-btn-primary" value="提交">
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>