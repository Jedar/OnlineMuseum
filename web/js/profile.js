$(function () {
    $("#settings-form").validate({
        rules:{
            "inputUsername":{
                rangelength:[4,15]
            },
            "inputEmail":{
                email:true
            },
            "inputPhone":{
                rangelength:[11,11]
            },
            "inputOldPassword":{
                required: true
            }
        },
        messages:{
            "inputUsername":{
                rangelength:"昵称长度应该介于4与15之间"
            },
            "inputEmail":{
                email:"邮箱不符合格式"
            },
            "inputPhone":{
                rangelength:"手机号码不符合格式"
            },
            "inputOldPassword":{
                required: "请输入验证密码"
            }
        }
    });

    $(".favorite-delete").on("click",function () {
        var target = $(this).attr("data-target");
        var node = $(this).parents(".list-group-item");
        $.post( "./deleteFavorite.us", {
            artworkID:target
        },function (result) {
            result = JSON.parse(result);
            if (result.success){
                showTip("删除成功");
                node.slideUp("slow");
                var favoriteNum = $("#favorite-tab").children("span").html();
                favoriteNum--;
                $("#favorite-tab").children("span").html(favoriteNum);
            }
            else{
                showError(result.message);
            }
        });
    });

    $(".friend-delete").on("click", function () {
        var target = $(this).attr("data-target");
        var node = $(this).parents(".list-group-item");
        $.post( "./deleteFriend.us", {
            friendID:target
        },function (result) {
            result = JSON.parse(result);
            if (result.success){
                showTip("删除成功");
                node.slideUp("slow");
                var friendNum = $("#friends-tab").children("span").html();
                friendNum--;
                $("#friends-tab").children("span").html(friendNum);
            }
            else{
                showError(result.message);
            }
        });
    });

    $("#changeInfo").on("click", function () {
        /* 检验格式是否合法 */
        if (! $("#settings-form").valid()) {
            return;
        }

        var username = $("#inputUsername").val();
        var password = md5($("#inputOldPassword").val());
        var email = $("#inputEmail").val();
        var address = $("#inputAddress").val();
        var phone = $("#inputPhone").val();
        var signature = $("#inputSignature").val();
        if(username !== "" || phone !== "" || email !== "" || address !== "" || signature !== "") {
            if(password === "") {
                $("#passwordHelp").html("<i class=\"fa fa-exclamation-circle fa-lg\"></i>Must input password");
            }else {
                $.post( "./changeInfo.us", {
                    username:username,
                    signature:signature,
                    password:password,
                    email:email,
                    address:address,
                    phone:phone
                },function (result) {
                    result = JSON.parse(result);
                    if (result.success){
                        showTip("更改成功");
                        $("#username").html(result.username);
                        $("#userEmail").html(result.email);
                        $("#userPhone").html(result.phone);
                        $("#userAddress").html(result.address);
                        $("#signature").html(result.signature);
                    }
                    else{
                        showError(result.message);
                    }
                });
            }
        }
    });
});