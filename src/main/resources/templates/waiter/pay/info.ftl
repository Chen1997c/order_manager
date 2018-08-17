<style>
    .info-body td {
        border: 0px !important;
    }
</style>
        <div class="am-modal am-modal-no-btn" tabindex="-1" id="pay-info-modal">
            <div class="am-modal-dialog" id="modal-dialog">
                <div class="am-modal-hd">
                    <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
                </div>
                <div class="am-modal-bd">
                    <div class="info-body">
                        <h2>订单信息(id:<span id="order-id"></span>)</h2>
                        <hr>
                        <table class="am-table">
                            <tr>
                                <td>餐桌号</td>
                                <td id="table-id"></td>
                            </tr>
                            <tr>
                                <td>下单时间</td>
                                <td id="begin-time"></td>
                            </tr>
                            <tr>
                                <td>完成时间</td>
                                <td id="end-time"></td>
                            </tr>
                            <tr>
                                <td>服务员</td>
                                <td id="waiter-id"></td>
                            </tr>
                            <tr>
                                <td>总价格</td>
                                <td id="total-price"></td>
                            </tr>
                            <tr>
                                <td>状态</td>
                                <td id="state"></td>
                            </tr>
                        </table>
                    </div>
                    <div class="am-fr am-margin">
                        <button class="see-dish-btn am-btn am-btn-warning am-btn-sm">→查看菜品</button>
                    </div>
                </div>
            </div>
        </div>

<div class="am-modal am-modal-no-btn" tabindex="-1" id="info-dish-modal">
    <div class="am-modal-dialog" id="modal-dialog">
        <div class="am-modal-hd">
            <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
        </div>
        <div class="am-modal-bd">
            <div class="info-body">
                <h2>订单菜品信息</h2>
                <hr>
                <table class="am-table">
                    <thead>
                    <tr>
                        <td>菜品名称</td>
                        <td>数量</td>
                        <td>单价</td>
                    </tr>
                    </thead>
                    <tbody id="dish-content">
                    </tbody>
                </table>
            </div>
            <div class="am-fr am-margin">
                <button class="back-btn am-btn am-btn-warning am-btn-sm">←返回</button>
            </div>
        </div>
    </div>
</div>

<script>
    $(function () {
        var $info_modal = $('#pay-info-modal');
        var $dish_modal = $('#info-dish-modal');
        $('.see-dish-btn').click(function () {
            $info_modal.modal('toggle');
            $dish_modal.modal('toggle');
        })

        $('.back-btn').click(function () {
            $info_modal.modal('toggle');
            $dish_modal.modal('toggle');
        })

    })
</script>