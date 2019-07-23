$.validator.setDefaults({
    debug:true,
    submitHandler: function(form) {
        alert("提交事件!");
        form.submit();
    }
});

$(function () {
    var rgstPsw = $("#info-password");

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
        if (! $("#insert-user-form").valid()) {
            return;
        }
        if (!checkPsw()) {
            return;
        }
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

    $("#insert-user-form").validate({
        rules:{
            "info-name":{
                required: true,
                rangelength:[4,15]
            },
            "info-password":{
                required: true,
                rangelength:[6,10]
            },
            "info-address":{
                required: true
            },
            "info-phone":{
                required: true,
                rangelength:[11,11]
            },
            "info-email":{
                required: true,
                email:true
            }
        },
        messages:{
            "info-name":{
                required: "昵称不能为空",
                rangelength:"昵称长度应该介于4与15之间"
            },
            "info-password":{
                required: "密码不能为空",
                rangelength:"昵称长度应该介于6与10之间"
            },
            "info-address":{
                required: "地址不能为空"
            },
            "info-phone":{
                required: "手机号码不能为空",
                rangelength:"手机号码不符合格式"
            },
            "info-email":{
                required: "邮箱不能为空",
                email:"邮箱不符合格式"
            }
        }
    });

    function checkPsw() {
        var numObj = /[0-9]+/;
        var upperObj = /[A-Z]+/;
        var lowerObj = /[a-z]+/;
        if (rgstPsw.val()===""){
            rgstPsw.next().html(getInfo("密码不能为空"));
            rgstPsw.next().removeClass("invisible");
        }
        else if(rgstPsw.val().length < 6){
            rgstPsw.next().html(getInfo("密码长度不能小于6"));
            rgstPsw.next().removeClass("invisible");
        }
        else if(rgstPsw.val().length >10){
            rgstPsw.next().html(getInfo("密码长度不能大于10"));
            rgstPsw.next().removeClass("invisible");
        }
        else if(!(numObj.test(rgstPsw.val())&&upperObj.test(rgstPsw.val())&&lowerObj.test(rgstPsw.val()))){
            rgstPsw.next().html(getInfo("密码必须包含数字和大小写字母"));
            rgstPsw.next().removeClass("invisible");
        }
        else {
            rgstPsw.next().addClass("invisible");
            return true;
        }
        return false;
    }

    function getInfo(message) {
        return "<i class=\"fa fa-exclamation-circle fa-lg\"></i> "+message;
    }
});