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
    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/receive/test', function (document) {
            let data = JSON.parse(document.body).content
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
    console.log(content)
    stompClient.send("/topic/send/test", {}, content);
}


$(function () {
    connect();
    $("#test").on('change', function (e) {
        console.log("send")
        e.preventDefault();
        sendContent();

    });
});

$(window).on("beforeunload", function() {
    disconnect();
})