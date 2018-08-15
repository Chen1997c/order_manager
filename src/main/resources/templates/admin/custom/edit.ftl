<div class="edit-modal am-modal am-modal-no-btn" tabindex="-1" id="custom-edit-modal">
    <div class="am-modal-dialog" id="modal-dialog">
        <div class="am-modal-hd">修改信息</span>
            <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
        </div>
        <hr>
        <div class="am-modal-bd">
            <div class="user-info-body am-u-sm-12">
                <form id="custom-edit-form" class="am-form am-text-left am-animation-slide-top" onsubmit="return false">
                    <div class="am-form-group">
                        <fieldset disabled style="padding: 0;margin: 0;">
                            <label>客户id</label>
                            <input type="text" id="edit-custom-id" class="am-form-field am-input-sm am-circle">
                        </fieldset>
                    </div>
                    <div class="am-form-group">
                        <label>姓名</label>
                        <input type="text" id="edit-custom-name" class="am-form-field am-input-sm am-circle"
                               pattern="^\S{1,10}$" required>
                    </div>
                    <div class="am-form-group">
                        <div class=" am-dropdown am-margin-top" data-am-dropdown>
                            <label>性别</label>&nbsp;&nbsp;&nbsp;&nbsp;
                            <button id="edit-custom-sex"
                                    class="custom-sex-btn am-btn am-btn-primary am-btn-lg am-dropdown-toggle"
                                    data-am-dropdown-toggle>男
                                <span class="am-icon-caret-down"></span>
                            </button>
                            <ul class="am-dropdown-content">
                                <li id="no" class="choose-tag-sex">
                                    <a href="#">男</a>
                                </li>
                                <li id="yes" class="choose-tag-sex">
                                    <a href="#">女</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="am-form-group">
                        <label>电话</label>
                        <input type="text" id="edit-custom-phoneNo" class="am-form-field am-input-sm am-circle"
                               pattern="^\d{11}$" required>
                    </div>
                    <div class="am-form-group">
                        <label>用餐次数</label>
                        <input type="text" id="edit-custom-dinningTimes" class="am-form-field am-input-sm am-circle"
                               pattern="^0|[1-9]{1,11}$" required>
                    </div>
                    <div class="am-form-group">
                        <label>用餐总额</label>
                        <input type="text" id="edit-custom-dinningSum" class="am-form-field am-input-sm am-circle"
                               pattern="^(0|\d{1,10}|([0]\.\d{1,2}|\d{1,10}\.\d{1,2}))$" required>
                    </div>
                    <div class="am-form-group am-text-right">
                        <input type="submit" id="edit-custom-btn" class="am-btn am-btn-warning" value="提交">
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>