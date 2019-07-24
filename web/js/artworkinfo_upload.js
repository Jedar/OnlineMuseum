$.validator.setDefaults({
    submitHandler: function(form) {
        // alert("提交事件!");
        form.submit();
    }
});

$().ready(function() {
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
            },
            image:{
                required: true
            },
            video:{
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