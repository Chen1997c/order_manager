<div class="edit-modal am-modal am-modal-no-btn" tabindex="-1" id="custom-add-modal">
    <div class="am-modal-dialog" id="modal-dialog">
        <div class="am-modal-hd">添加客户
            <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
        </div>
        <hr>
        <div class="am-modal-bd">
            <div class="user-info-body am-u-sm-12">
                <form id="add-custom-form" class="am-form am-text-left am-animation-slide-top" onsubmit="return false">
                    <div class="am-form-group">
                        <label>姓名</label>
                        <input type="text" id="add-name" class="am-form-field am-input-sm am-circle"
                               pattern="^\S{1,10}$" required>
                    </div>
                    <div class="am-form-group">
                        <div class=" am-dropdown am-margin-top" data-am-dropdown>
                            <label>性别</label>&nbsp;&nbsp;&nbsp;&nbsp;
                            <button id="add-sex"
                                    class="custom-sex-btn sex-btn am-btn am-btn-primary am-btn-lg am-dropdown-toggle"
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
                        <input type="text" id="add-phoneNo" class="am-form-field am-input-sm am-circle"
                               pattern="^\d{11}$" required>
                    </div>
                    <div class="am-form-group am-text-right">
                        <input type="submit" id="add-btn" class="am-btn am-btn-warning" value="提交">
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>