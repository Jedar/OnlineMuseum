$(function () {
    $("#page-input").on('keypress',function(e) {
        //pressed enter
        if(e.which === 13) {
            $.post();
        }
    });
    $(".page-previous").on('click',function (e) {

    });

    function f(pageIndex) {
        $.post("searchArtwork.aws",
            {
                pageNumber:Index
            },function (result) {
                result = JSON.parse(result);
                if (result.success){

                }
                else{
                    showError("请求出错");
                }
            }

        )
    }
});