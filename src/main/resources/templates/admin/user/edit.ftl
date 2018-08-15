<div class="info-modal am-modal am-modal-no-btn" tabindex="-1" id="user-edit-modal">
    <div class="am-modal-dialog" id="modal-dialog">
        <div class="am-modal-hd">修改信息(id:<span id="user-id"></span>)
            <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
        </div>
        <hr>
        <div class="am-g am-g-collapse am-margin-bottom-lg">
            <div class="am-u-sm-6">
                <button class="am-btn edit-type am-btn-primary" style="width:100%">个人信息</button>
            </div>
            <div class="am-u-sm-6">
                <button class="am-btn edit-type" style="width:100%">管理信息</button>
            </div>
        </div>
        <div class="am-modal-bd">
            <div class="user-info-body am-u-sm-12">
                <form class="am-form am-text-left am-animation-slide-top" onsubmit="return false">
                    <div class="user-info-avatar am-u-sm-5 am-text-center">
                        <img id="avatar-img" src="${ctx}/images/user01.png" class="am-round" style="width:100px;height: 100px">
                        <div class="am-margin-top">
                            <div class="am-form-group am-form-file">
                                <button type="button" id="upload-avatar-btn" class="am-btn am-btn-default am-btn-sm">
                                    <i class="am-icon-cloud-upload"></i> 选择图片
                                </button>
                                <input name="file" id="edit-avatar-img" type="file" multiple>
                            </div>
                            <div id="file-list"></div>
                        </div>
                    </div>
                    <div class="am-form-group am-u-sm-7">
                        <label>姓名</label>
                        <input type="text" id="edit-name" class="am-form-field am-input-sm am-circle"
                               pattern="^\S{1,10}$" required>
                    </div>
                    <div class="am-form-group  am-u-sm-7">
                        <label>手机</label>
                        <input type="text" id="edit-phoneNo" class="am-form-field am-input-sm am-circle"
                               pattern="^\d{11}$" placeholder="11位数字" required>
                        <div class="am-dropdown am-margin-top" data-am-dropdown>
                            <label>性别 </label>&nbsp;&nbsp;&nbsp;&nbsp;
                            <button id="edit-sex" class="sex-btn am-btn am-btn-primary am-btn-lg am-dropdown-toggle"
                                    data-am-dropdown-toggle>
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
                    <div class="am-form-group am-text-left">
                        <label>住址</label>
                        <input type="text" id="edit-address" class="am-form-field am-input-sm  am-circle"
                               pattern="^\S{0,100}$">
                    </div>
                    <div class="am-form-group am-text-right">
                        <input type="submit" id="next-btn" class="am-btn am-btn-warning" value="下一步">
                    </div>
                </form>
                <form class="am-form am-text-left am-animation-slide-top" onsubmit="return false" style="display: none">
                    <label for="">帐号</label>
                    <div class="am-form-group">
                        <fieldset disabled style="padding:0;margin:0">
                            <input type="text" id="account" class="am-form am-input-sm am-form-field">
                        </fieldset>
                    </div>
                    <label>初始化密码</label>
                    <div class="am-input-group am-margin-bottom">
                        <input type="text" id="reset-password-value" class="am-input-sm am-form-field" value="123456">
                        <div class="am-input-group-btn">
                            <button id="reset-password-btn" type="button" class="am-btn am-btn-danger">重置</button>
                        </div>
                    </div>
                    <div class="am-form-group  am-u-sm-6">
                        <div class="am-dropdown am-margin-to" data-am-dropdown>
                            <label>职位 </label>&nbsp;&nbsp;&nbsp;&nbsp;
                            <button id="edit-position" class="position-btn am-btn am-btn-primary am-dropdown-toggle"
                                    data-am-dropdown-toggle>
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
                    <div class="am-form-group  am-u-sm-6 ">
                        <div class="am-dropdown am-margin-topam-margin-bottom-lg" data-am-dropdown>
                            <label>禁用</label>&nbsp;&nbsp;&nbsp;&nbsp;
                            <button id="edit-lock" class="lock-btn am-btn am-btn-primary am-dropdown-toggle"
                                    data-am-dropdown-toggle>
                                <span class="am-icon-caret-down"></span>
                            </button>
                            <ul class="am-dropdown-content">
                                <li id="locked-false" class="choose-tag-lock">
                                    <a href="#">f</a>
                                </li>
                                <li id="locked-true" class="choose-tag-lock">
                                    <a href="#">t</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="am-form-group am-text-right am-margin-top-lg">
                        <input type="button" id="previous-btn" class="am-btn am-btn-warning" value="上一步">
                        <input type="submit" id="edit-sub-btn" class="am-btn am-btn-primary" value="提交">
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>