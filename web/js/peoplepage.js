$(function () {
    $(".change-type").on("click",function () {
        var btn = $(this);
        if (btn.hasClass("disabled")) {
            return;
        }
        $.post("./changeType.us",{
            userID:$(this).attr("data-target")
        },function (result) {
            result = JSON.parse(result);
            if (result.success) {
                btn.addClass("disabled");
                btn.siblings(".change-type").removeClass("disabled");
                showTip(result.message);
            }
            else {
                showError(result.message);
            }
        });
    });

    $(".delete-user").on("click",function () {
        var btn = $(this);
        $.post("./delete.us",{
            userID:$(this).attr("data-target")
        },function (result) {
            result = JSON.parse(result);
            if (result.success) {
                btn.parents("li").slideUp("slow");
                showTip(result.message);
            }
            else {
                showError(result.message);
            }
        });
    });

    $(".btn-insert-user").on("click",function () {
        var pwd = md5($("#info-password").val());
        $.post("./insertUser.us",{
            username:$("#info-name").val(),
            password:pwd,
            address:$("#info-address").val(),
            phone:$("#info-phone").val(),
            email:$("#info-email").val(),
            manage:$("#info-right").val()
        },function (result) {
            result = JSON.parse(result);
            if(result.success){
                showTip("注册成功");
                window.location.href = result.link;
            }
            else{
                showError("注册失败，请检查注册信息");
            }
        });
    });
});