<div class="edit-modal am-modal am-modal-no-btn" tabindex="-1" id="dish-edit-modal">
    <div class="am-modal-dialog" id="modal-dialog">
        <div class="am-modal-hd">修改信息</span>
            <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
        </div>
        <hr>
        <div class="am-modal-bd">
            <div class="user-info-body am-u-sm-12">
                <form id="dish-edit-form" class="am-form am-text-left am-animation-slide-top" onsubmit="return false">
                    <div class="dish-edit-img am-u-sm-5 am-text-center">
                        <img id="dish-img" src="${ctx}/images/ddr.jpg" class="am-round"
                             style="width:100px;height: 100px">
                        <div class="am-margin-top">
                            <div class="am-form-group am-form-file">
                                <button type="button" id="upload-dish-img-btn" class="am-btn am-btn-default am-btn-sm">
                                    <i class="am-icon-cloud-upload"></i> 选择图片
                                </button>
                                <input name="file" id="edit-dish-img" type="file" multiple>
                            </div>
                            <div id="file-list"></div>
                        </div>
                    </div>
                    <div class="am-form-group am-u-sm-7">
                        <fieldset disabled style="padding: 0;margin: 0;">
                            <label>菜品id</label>
                            <input type="text" id="edit-dish-id" class="am-form-field am-input-sm am-circle">
                        </fieldset>
                    </div>
                    <div class="am-form-group  am-u-sm-7">
                        <label>名称</label>
                        <input type="text" id="edit-dish-name" class="am-form-field am-input-sm am-circle"
                               pattern="^\S{1,20}$" required>
                    </div>
                    <div class="am-form-group am-u-sm-3">
                        <div class="am-dropdown am-margin-top" data-am-dropdown>
                            <label>推荐</label>&nbsp;&nbsp;&nbsp;&nbsp;
                            <button id="edit-dish-isGood-btn" class="dish-isGood-btn sex-btn am-btn am-btn-primary am-btn-lg am-dropdown-toggle"
                                    data-am-dropdown-toggle>
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
                    <div class="am-form-group am-u-sm-4">
                        <label>价格</label>
                        <input type="text" id="edit-dish-price" class="am-form-field am-input-sm am-circle" pattern="^(([1-9]\d{1,9})|(([0]\.\d{1,2}|[1-9]\d{1,9}\.\d{1,2})))$" required>
                    </div>
                    <div class="am-form-group am-text-left">
                        <label>简介</label>
                        <input type="text" id="edit-dish-description" class="am-form-field am-input-sm  am-circle"
                               pattern="^\S{0,20}$">
                    </div>
                    <div class="am-form-group am-text-left">
                        <label>详细</label>
                        <input type="text" id="edit-dish-txt" class="am-form-field am-input-sm  am-circle"
                               pattern="^\S{0,100}$">
                    </div>
                    <div class="am-form-group am-text-right">
                        <input type="submit" id="edit-dish-btn" class="am-btn am-btn-warning" value="提交">
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>