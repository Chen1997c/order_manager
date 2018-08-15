var table_edit = {
    url:{
        insertUrl:function () {
            return path + "/admin/addTable";
        }
    },
    executeInsert: function () {
        var table_number = $('#add-table-number').val();
        console.log(table_edit.url.insertUrl());
        $.post({
            url: table_edit.url.insertUrl(),
            dataType:'json',
            data: {
                table_number: table_number
            },
            beforeSend: function () {
                $('#add-table-btn').addClass('am-disabled');
            },
            success: function (data) {
                alert(data.message);
                if(data.code == 1)
                    reload();
            },
            complete: function () {
                $('#add-table-btn').removeClass('am-disabled');
            }
        })
    }
}

$('#table-add-form').submit(function () {
    var time = 0;
    confirm('确定添加吗?',function (result) {
        if(result && time == 0) {
            table_edit.executeInsert();
        }
        time++;
    })
})