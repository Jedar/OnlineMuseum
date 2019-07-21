$(function () {

    $("#btn-login").on("click",function () {
        var pwd = md5($("#user-psw").val());
        $.post( "./login.us", {
            username:$("#user-name").val(),
            password:pwd
        },function (result) {
            result = JSON.parse(result);
            if(result.success){
                showTip("登陆成功");
                $('.card-body').html('<div class="alert alert-success">\n' +
                    '  登陆成功\n' +
                    '</div>');
                $('.card-footer').html("");
                window.location.href = result.link;
            }
            else{
                showError(result.message);
            }
        });
    });
});