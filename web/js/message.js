$(function () {
    $("#addFriend").on("click", function () {
        var username = $("#requestName").val();
        var content = $("#requestContent").val();
        $.post( "./sendRequest.us", {
            username:username,
            content:content
        },function (result) {
            result = JSON.parse(result);
            if(result.success){
                showTip("发送成功");
            }else{
                showError(result.message);
            }
        });
    });
    $(".agreeRequest").on("click", function () {
        var btn = $(this);
        var senderID = $(this).attr("data-target");
        $.post( "./readRequest.us", {
            senderID:senderID,
            agree:true
        },function (result) {
            result = JSON.parse(result);
            if(result.success){
                showTip("添加成功");
                btn.parents(".wrapper").html("<button class=\"btn btn-info disabled\" type=\"button\">已同意</button>");
            }else{
                showError(result.message);
            }
        });
    });
    $(".refuseRequest").on("click", function () {
        var btn = $(this);
        var senderID = $(this).attr("data-target");
        $.post( "./readRequest.us", {
            senderID:senderID,
            agree:false
        },function (result) {
            result = JSON.parse(result);
            if(result.success){
                showTip("已拒绝");
                btn.parents(".wrapper").html("<button class=\"btn btn-info disabled\" type=\"button\">已拒绝</button>");
            }else{
                showError(result.message);
            }
        });
    });
});