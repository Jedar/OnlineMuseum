$(function () {
    $("#bt-addToWish").on("click",function () {
        alert($("#id-num").html());
        $.post( "./addFavorite.us", {
            artwordID:$("#id-num").html()
        },function (result) {
            result = JSON.parse(result);
            if (result.success){
                showTip('收藏成功');
            }
            else{
                showError('收藏失败');
            }
        });
    })
});