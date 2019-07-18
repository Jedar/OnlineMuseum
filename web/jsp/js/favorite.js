$(function () {
    $(".button-delete").on("click",function () {
       var target = $(this).attr("data-target");
       var node = $(this).parents(".list-group-item");
        $.post( "./favor", {
            action:"delete",
            index:target
        },function (result) {
            result = JSON.parse(result);
            if (result.success){
                showTip('删除成功');
                node.slideUp("slow");
            }
            else{
                showError('删除失败');
            }
        });

    });
});