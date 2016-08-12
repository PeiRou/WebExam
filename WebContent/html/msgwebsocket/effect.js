var _name = $("#name").val();
var _company = $("#company").val();

websocket.send(JSON.stringify({
    'username': _name,
    'company': _company,
}));