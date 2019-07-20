$(function () {
    $("#btn-login").on("click",function () {
        $.post( "./login.us", {
            username:$("#user-name").val(),
            password:$("#user-psw").val()
        },function (result) {
            result = JSON.parse(result);
            if(result.success){
                showTip("登陆成功");
            }
            else{
                showError(result.message);
            }
        });
    });
});