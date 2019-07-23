$(function () {
    $("#search-friend-button").on("click", function () {
        var username = $("#search-friend-input").val();
        $.post( "./searchUser.us", {
            username:username
        },function (result) {
            result = JSON.parse(result);
            if(result.success){
                showResult(result.userList);
            }else{
                showError(result.message);
            }
        });
    });

    $("#search-result").on("click", ".add-friend-button", function () {
        var receiverID = $(this).attr("data-whatever");
        $("#send-friend-request").on("click", function () {
            var content = $("#message-text").val();
            $.post( "./sendRequest.us", {
                receiverID:receiverID,
                content:content
            },function (result) {
                result = JSON.parse(result);
                if(result.success){
                    showTip("发送成功！");
                }else{
                    showError(result.message);
                }
            });
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
    $(".sendMessage").on("click", function () {
        var friendID = $(this).attr("data-target");
        var content = $(this).parents(".card-body").find(".form-control").val();
        $.post( "./sendMessage.us", {
            friendID:friendID,
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

    $(".readMessage").on("click", function() {
        var messageID = $(this).attr("data-whatever");
        $.post( "./readMessage.us", {
            messageID:messageID
        },function (result) {
            result = JSON.parse(result);
            if(result.success){
                showTip("已阅读");
            }else{
                showError(result.message);
            }
        });
    });

    function showResult(list) {
        var i;
        var str = "";
        for(i in list) {
            str += "                                <li class=\"list-group-item\">\n" +
                "                                    <div class=\"row\">\n" +
                "                                        <figure class=\"col-2\">\n" +
                "                                            <img src=\"../img/019070.jpg\" class=\"figure-img rounded\" width=\"100\" height=\"100\" alt=\"\" />\n" +
                "                                        </figure>\n" +
                "                                        <div class=\"col-4 offset-1 align-self-center\">\n" +
                "                                            <h4>" + list[i].username + "</h4>\n" +
                "                                            <p><i class=\"fa fa-map-marker\" aria-hidden=\"true\"></i>" + list[i].address + "</p>\n" +
                "                                        </div>\n" +
                "                                        <div class=\"col-2 offset-2 align-self-center\">\n" +
                "                                            <div class=\"justify-content-center\">\n" +
                "                                                <button type=\"button\" class=\"btn btn-primary add-friend-button\" data-toggle=\"modal\" data-target=\"#addFriendRequest\" data-whatever=\"" +list[i].userID+ "\">加为好友</button>\n" +
                "                                            </div>\n" +
                "                                        </div>\n" +
                "                                    </div>\n" +
                "                                </li>";
        }
        $("#search-result").html(str);
    }
});