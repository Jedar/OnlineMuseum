$(function () {
    var receiverID;

    $("#send-friend-request").on("click", function () {
        var content = $("#message-text").val();
        $.post( "./sendRequest.us", {
            receiverID:receiverID,
            content:content
        },function (result) {
            result = JSON.parse(result);
            if(result.success){
                showTip("发送成功！");
                $("#message-text").val("");
            }else{
                showError(result.message);
            }
        });
    });


    $("#search-friend-button").on("click", function () {
        var username = $("#search-friend-input").val();
        $.post( "./searchUser.us", {
            username:username
        },function (result) {
            result = JSON.parse(result);
            if(result.success){
                showResult(result.unFriendList, result.friendList);
            }else{
                showError(result.message);
            }
        })
    });

    $("#search-result").on("click", ".add-friend-button", function () {
        receiverID = $(this).attr("data-whatever");
    });

    $(".recommend-friend-item").on("click",function () {
        receiverID = $(this).attr("data-whatever");
    });

    $(".agreeRequest").on("click", function () {
        var btn = $(this);
        var senderID = $(this).attr("data-target");
        $.post( "./readRequest.us", {
            requestID:senderID,
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
            requestID:senderID,
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

    function showResult(unFriendList, friendList) {
        var i;
        var j;
        var str = "";
        for(j in friendList) {
            str += "                        <li class=\"list-group-item\">\n" +
                "                                <div class=\"row\">\n" +
                "                                    <figure class=\"col-2\">\n" +
                "                                        <img src=\"../img/019070.jpg\" class=\"figure-img rounded\" width=\"100\" height=\"100\" alt=\"\" />\n" +
                "                                    </figure>\n" +
                "                                    <div class=\"col-4 offset-1 align-self-center\">\n" +
                "                                        <h4>" + friendList[j].username + "</h4>\n" +
                "                                        <p><i class=\"fa fa-map-marker\" aria-hidden=\"true\"></i>" + friendList[j].address + "</p>\n" +
                "                                    </div>\n" +
                "                                    <div class=\"col-2 offset-2 align-self-center\">\n" +
                "                                        <div class=\"justify-content-center\">\n" +
                "                                            <a class=\"btn btn-info friend-homepage\" href=\"friend.jsp?id="+ friendList[j].userID + "\">查看主页</a>\n" +
                "                                        </div>\n" +
                "                                    </div>\n" +
                "                                </div>\n" +
                "                            </li>"
        }
        for(i in unFriendList) {
            str += "                                <li class=\"list-group-item\">\n" +
                "                                    <div class=\"row\">\n" +
                "                                        <figure class=\"col-2\">\n" +
                "                                            <img src=\"../img/019070.jpg\" class=\"figure-img rounded\" width=\"100\" height=\"100\" alt=\"\" />\n" +
                "                                        </figure>\n" +
                "                                        <div class=\"col-4 offset-1 align-self-center\">\n" +
                "                                            <h4>" + unFriendList[i].username + "</h4>\n" +
                "                                            <p><i class=\"fa fa-map-marker\" aria-hidden=\"true\"></i>" + unFriendList[i].address + "</p>\n" +
                "                                        </div>\n" +
                "                                        <div class=\"col-2 offset-2 align-self-center\">\n" +
                "                                            <div class=\"justify-content-center\">\n" +
                "                                                <button type=\"button\" class=\"btn btn-primary add-friend-button\" data-toggle=\"modal\" data-target=\"#addFriendRequest\" data-whatever=\"" +unFriendList[i].userID+ "\">加为好友</button>\n" +
                "                                            </div>\n" +
                "                                        </div>\n" +
                "                                    </div>\n" +
                "                                </li>";
        }
        $("#search-result").html(str);
    }
});