var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    var socket = new SockJS('/block-ws');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        // /topic/receive/test에 구독 하고 있는 페이지들에 데이터 전송
        stompClient.subscribe('/sub/receive/test', function (document) {
            console.log(document)
            console.log(document.body)
            let data = JSON.parse(document.body)
            let content = JSON.parse(data).content
            $("#test").val(content)
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendContent() {
    let content = JSON.stringify({'content': $("#test").val()})
    // /topic/send 경로로 websocket 호출
    stompClient.send("/app/send/test", {}, content);
}


$(function () {
    connect();
    $("#test").on('change', function (e) {
        e.preventDefault();
        // text 박스에서 포커스 떼는 순간 sendContent function trigger
        sendContent();

    });
});

$(window).on("beforeunload", function() {
    disconnect();
})