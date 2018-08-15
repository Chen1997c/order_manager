<div class="edit-modal am-modal am-modal-no-btn" tabindex="-1" id="dish-add-modal">
    <div class="am-modal-dialog" id="modal-dialog">
        <div class="am-modal-hd">添加菜品
            <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
        </div>
        <hr>
        <div class="am-modal-bd">
            <div class="user-info-body am-u-sm-12">
                <form id="add-dish-form" class="am-form am-text-left am-animation-slide-top" onsubmit="return false">
                    <div class="am-form-group">
                        <label>名称</label>
                        <input type="text" id="add-name" class="am-form-field am-input-sm am-circle"
                               pattern="^\S{1,20}$" required>
                    </div>
                    <div class="am-form-group">
                        <label>价格</label>
                        <input type="text" id="add-price" class="am-form-field am-input-sm am-circle"
                               pattern="^(([1-9]\d{1,9})|(([0]\.\d{1,2}|[1-9]\d{1,9}\.\d{1,2})))$" required>
                    </div>
                    <div class="am-form-group">
                        <div class=" am-dropdown am-margin-top" data-am-dropdown>
                            <label>推荐</label>&nbsp;&nbsp;&nbsp;&nbsp;
                            <button id="add-isGood"
                                    class="dish-isGood-btn sex-btn am-btn am-btn-primary am-btn-lg am-dropdown-toggle"
                                    data-am-dropdown-toggle>N
                                <span class="am-icon-caret-down"></span>
                            </button>
                            <ul class="am-dropdown-content">
                                <li id="no" class="choose-tag-good">
                                    <a href="#">N</a>
                                </li>
                                <li id="yes" class="choose-tag-good">
                                    <a href="#">Y</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="am-form-group">
                        <label>简介</label>
                        <input type="text" id="add-description" class="am-form-field am-input-sm am-circle"
                               pattern="^\S{0,100}$">
                    </div>
                    <div class="am-form-group am-text-left">
                        <label>描述</label>
                        <input type="text" id="add-txt" class="am-form-field am-input-sm  am-circle"
                               pattern="^\S{0,255}$">
                    </div>
                    <div class="am-form-group am-text-right">
                        <input type="submit" id="add-btn" class="am-btn am-btn-warning" value="提交">
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>