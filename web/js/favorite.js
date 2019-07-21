$(function () {
    $(".button-delete").on("click",function () {
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
});