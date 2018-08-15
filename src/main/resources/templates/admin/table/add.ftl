<div class="info-modal am-modal am-modal-no-btn" tabindex="-1" id="table-add-modal">
    <div class="am-modal-dialog" id="modal-dialog">
        <div class="am-modal-hd">
            <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
        </div>
        <div class="am-modal-bd">
            <div class="am-u-sm-12">
                <form id="table-add-form" class="am-form am-text-left am-animation-slide-top am-text-center" onsubmit="return false">
                    <label>请输入餐桌编号</label>
                    <div class="am-form-group">
                        <input type="text" id="add-table-number" class="am-form am-input-sm am-form-field"
                               pattern="^[1,9]\d|[1,9]$" required>
                    </div>
                    <div class="am-form-group am-text-right am-margin-top-lg">
                        <input type="submit" id="add-table-btn" class="am-btn am-btn-primary" value="提交">
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>