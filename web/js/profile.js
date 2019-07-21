$(function () {
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
            artworkID:target
        },function (result) {
            result = JSON.parse(result);
            if (result.success){
                showTip("删除成功");
                node.slideUp("slow");
            }
            else{
                showError(result.message);
            }
        });
    });

    $("#changeInfo").on("click", function () {
        var username = $("#inputUsername").val();
        var password = md5($("#inputOldPassword").val());
        var email = $("#inputEmail").val();
        var address = $("#inputAddress").val();
        var phone = $("#inputPhone").val();
        var signature = $("#inputSignature").val();
        alert(username);
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