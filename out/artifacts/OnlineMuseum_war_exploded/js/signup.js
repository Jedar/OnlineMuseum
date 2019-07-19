$(function () {
    $("#btn-register").on("click",function () {
        $.post("./SignUp",{
            username:$("#register-name").val(),
            password:$("#register-psw").val(),
            address:$("#register-address").val(),
            phone:$("#register-phone").val(),
            email:$("#register-email").val()
        },function (result) {
            result = JSON.parse(result);
            if(result.success){
                showTip("注册成功");
            }
            else{
                showError("注册失败，请检查注册信息");
            }
        });
    });
});