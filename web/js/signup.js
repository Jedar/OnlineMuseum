$(function () {
    var registerArr = [false,false,false,false,false,false,false];
    var rgstName = $("#register-name");
    var rgstPsw = $("#register-psw");
    var rgstSure = $("#register-sure");
    var rgstEmail = $("#register-email");
    var rgstPhone = $("#register-phone");
    var rgstAddress = $("#register-address");
    var userCheck = $("#user-check");
    rgstName.on('change',checkName);
    rgstPsw.change(checkPsw);
    rgstSure.change(checkPswSure);
    rgstEmail.change(checkEmail);
    rgstPhone.change(checkPhone);
    rgstAddress.change(checkAddress);
    userCheck.change(check);

    $("#img-check-code").on("click",function () {
        var img = $(this);
        var address = img.attr("src");
        address += "?msg=" + Math.random();
        img.attr("src",address);
    });

    function setCheckNum() {
        checkNumber = Math.floor(Math.random()*9000+1000);
        $(".check-number").text(checkNumber);
    }

    $("#btn-register").on("click",function () {
        checkName();
        checkPsw();
        checkPswSure();
        checkEmail();
        checkPhone();
        checkAddress();
        check();
        alert("sign up");
        if (registerArr[0]&&registerArr[1]&&registerArr[2]&&registerArr[3]&&registerArr[4]&&registerArr[5]&&registerArr[6]){
            var pwd = md5($("#register-psw").val());
            $.post("./signup.us",{
                username:$("#register-name").val(),
                password:pwd,
                address:$("#register-address").val(),
                phone:$("#register-phone").val(),
                email:$("#register-email").val(),
                checkCode:userCheck.val()
            },function (result) {
                result = JSON.parse(result);
                if(result.success){
                    showTip("注册成功");
                    $('.card-body').html('<div class="alert alert-success">\n' +
                        '  注册成功\n' +
                        '</div>');
                    $('.card-footer').html("");
                    window.location.href = result.link;
                }
                else{
                    showError(result.message);
                }
            });
        }
        $.post("./signup.us",{

        },function (result) {

        });
    });

    function checkName() {
        registerArr[0]=false;
        if (rgstName.val()===""){
            rgstName.next().html(getInfo("昵称不能为空"));
            rgstName.next().removeClass("invisible");
        }
        else if(rgstName.val().length < 4){
            rgstName.next().html(getInfo("昵称长度不能小于4"));
            rgstName.next().removeClass("invisible");
        }
        else if(rgstName.val().length > 15){
            rgstName.next().html(getInfo("昵称长度不能大于15"));
            rgstName.next().removeClass("invisible");
        }
        else {
            rgstName.next().addClass("invisible");
            registerArr[0]=true;
        }
    }

    function checkPsw() {
        registerArr[1]=false;
        var  objRegExp= /^(?:(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])).{8,20}$/;
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
        else if(!objRegExp.test(rgstPsw.val())){
            rgstPsw.next().html(getInfo("密码必须包含数字和大小写字母"));
            rgstPsw.next().removeClass("invisible");
        }
        else {
            if (registerArr[2]&&(rgstSure.val()!==rgstPsw.val())){
                rgstSure.val("");
                registerArr[2] = false;
            }
            rgstPsw.next().addClass("invisible");
            registerArr[1]=true;
        }
    }

    function checkPswSure() {
        registerArr[2]=false;
        if (rgstSure.val()===""){
            rgstSure.next().html(getInfo("请确认密码"));
            rgstSure.next().removeClass("invisible");
        }
        else if (rgstSure.val()!==rgstPsw.val()){
            rgstSure.next().html(getInfo("确认密码错误"));
            rgstSure.next().removeClass("invisible");
        }
        else {
            rgstSure.next().addClass("invisible");
            registerArr[2]=true;
        }
    }

    function checkEmail() {
        registerArr[3]=false;
        if (rgstEmail.val()===""){
            rgstEmail.next().html(getInfo("邮箱为空"));
            rgstEmail.next().removeClass("invisible");
        }
        else if (!rgstEmail.val().match("^(\\w)+(\\.\\w+)*@(\\w)+((\\.\\w{2,3}){1,3})$")){
            rgstEmail.next().html(getInfo("邮箱格式错误"));
            rgstEmail.next().removeClass("invisible");
        }
        else {
            rgstEmail.next().addClass("invisible");
            registerArr[3]=true;
        }
    }

    function checkPhone() {
        registerArr[4]=false;
        if (rgstPhone.val()===""){
            rgstPhone.next().html(getInfo("电话为空")).removeClass("invisible");
        }
        else if (!rgstPhone.val().match("[0-9]{11}$")){
            rgstPhone.next().html(getInfo("电话格式错误")).removeClass("invisible");
        }
        else {
            rgstPhone.next().addClass("invisible");
            registerArr[4]=true;
        }
    }

    function checkAddress() {
        registerArr[5]=false;
        if (rgstAddress.val()===""){
            rgstAddress.next().html(getInfo("地址为空")).removeClass("invisible");
        }
        else {
            rgstAddress.next().addClass("invisible");
            registerArr[5]=true;
        }
    }

    function check() {
        if (!userCheck.val()){
            userCheck.siblings("div").html(getInfo("请输入验证码"));
            userCheck.siblings("div").removeClass("invisible");
            registerArr[6]=false;
        }
        else {
            userCheck.siblings("div").addClass("invisible");
            registerArr[6]=true;
        }
    }

    function checkIsSign() {
        var isSign = $("#top-signin").attr('data-sign');
        if (isSign === '1'){
            $('.card-body').html('<div class="alert alert-success">\n' +
                '  注册成功，用户已登陆\n' +
                '</div>');
            $('.card-footer').html("");
        }
    }

    function getInfo(message) {
        return "<i class=\"fa fa-exclamation-circle fa-lg\"></i> "+message;
    }
});