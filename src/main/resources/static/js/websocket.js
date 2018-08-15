$(function () {
    var websocket = null;

    var noticeMsg = '';
//判断浏览器是否支持websocket
    if ('WebSocket' in window) {
        websocket = new WebSocket("ws://127.0.0.1:8080/noticeServer");
    } else {
        alert('当前浏览器不支持websocket');
    }

//连接发生错误的回调方法
    websocket.onerror = function () {
        alert("websocket连接发生错误");
    }

//连接成功的回调方法
    websocket.onopen = function () {
        console.log("websocket连接成功");
    }

//连接关闭的回调方法
    websocket.onclose = function () {
        console.log("websocket连接关闭");
    }

//监听窗口关闭事件
    websocket.onbeforeunload = function () {
        websocket.close();
    }

    //接受到消息时的回调方法
    websocket.onmessage = function (event) {
        showMsg(data.message);
    }

    //显示消息
    function showMsg(message) {
        $('#notice-bar').val(message);
    }

    //发送消息
    function send(message) {
        websocket.send(message);
    }
})