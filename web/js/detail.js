$(function () {
    $("#bt-addToWish").on("click",function () {
        $.post( "./addFavorite.us", {
            artworkID:$("#id-num").html()
        },function (result) {
            result = JSON.parse(result);
            if (result.success){
                showTip('收藏成功');
            }else{
                showError(result.message);
            }
        });
    })
});