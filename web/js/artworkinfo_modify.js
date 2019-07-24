$.validator.setDefaults({
    submitHandler: function(form) {
        // alert("提交事件!");
        form.submit();
    }
});

$().ready(function() {
    $("#info-image").on("change",function () {
        var file = this.files[0];
        var img = $("#img-preview");
        if (!file){
            img.addClass('invisible');
            return;
        }
        if (!(/^image\/png$|jpeg$/.test(file.type))){
            img.addClass('invisible');
            return;
        }
        img.removeClass('invisible');
        var oburl = window.URL.createObjectURL(file);
        img.attr("src", oburl) ;
    });

    $("#artwork-info-form").validate({
        rules:{
            title:{
                required: true
            },
            description:{
                required: true
            },
            size:{
                required: true
            },
            location:{
                required: true
            },
            age:{
                required: true
            },
            time:{
                required: true
            }
        },
        messages:{
            title:"请输入名称",
            description:"请输入描述",
            size:"请输入尺寸信息",
            location:"请输入馆藏地点",
            age:"请输入年代",
            time:"请输入发现时间"
        }
    });
});