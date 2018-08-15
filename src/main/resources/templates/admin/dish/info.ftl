<style>
    .user-info-body td {
        border: 0px !important;
    }
</style>
        <div class="am-modal am-modal-no-btn" tabindex="-1" id="dish-info-modal">
            <div class="am-modal-dialog" id="modal-dialog">
                <div class="am-modal-hd">
                    <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
                </div>
                <div class="am-modal-bd">
                    <div class="dish-info-img">
                        <img id="info-img" src="${ctx}/images/ddr.jpg" class="am-round" style="width:100px;height: 100px;">
                    </div>
                    <div class="user-info-body">
                        <h2>菜品信息</h2>
                        <hr>
                        <table class="am-table">
                            <tr>
                                <td>菜名</td>
                                <td id="name"></td>
                            </tr>
                            <tr>
                                <td>价格</td>
                                <td id="price"></td>
                            </tr>
                            <tr>
                                <td>是否推荐</td>
                                <td id="isGood"></td>
                            </tr>
                            <tr>
                                <td>简介</td>
                                <td id="description"></td>
                            </tr>
                            <tr>
                                <td>详细介绍</td>
                                <td id="txt"></td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
        </div>