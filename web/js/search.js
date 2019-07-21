$(function () {
    $("#page-input").on('keypress',function(e) {
        //pressed enter
        if(e.which === 13) {
            
            var page = parseInt($("#page-input").val());
            if (isNaN(page)) {
                page = 1;
            }
            getPage(page);
        }
    });
    $(".page-previous").on('click',function (e) {
        var page = parseInt($("#page-input").val());
        if (isNaN(page)) {
            page = 1;
        }
        else {
            page -= 1;
        }
        if (page < 1) {
            page = 1;
        }
        getPage(page);
    });
    $(".page-next").on("click",function (e) {
        var input = $("#page-input");
        var page = parseInt(input.val());
        if (isNaN(page)) {
            page = 1;
        }
        else {
            page += 1;
        }
        var max = parseInt(input.attr("max"));
        if (page > max) {
            page = max;
        }
        getPage(page);
    })

    function getPage(pageIndex) {
        $.post("./searchArtwork.aws",
            {
                mark:pageIndex,
                title:$("#search-title").val(),
                description:$("#search-description").val(),
                location:$("#search-location").val(),
                sortWay:$("#search-sort").val(),
                pageSize:6
            },function (result) {
                result = JSON.parse(result);
                if (result.success){
                    setPage(result.index,result.artworkList);
                }
                else{
                    showError("请求出错");
                }
            }

        )
    }

    function setPage(idx,list){
        $("#page-input").val(idx);
        var i;
        var str = "";
        for(i in list){
            str += "<div class=\"item\">\n" +
                "                    <figure>\n" +
                "                        <a href=\"detail.jsp?id="+list[i].artwordID+"\">\n" +
                "                            <img src=\"../img/"+list[i].imageFileName+"\" alt=\"\">\n" +
                "                        </a>\n" +
                "                    </figure>\n" +
                "                    <div class=\"item-name\">\n" +
                "                        <h3>"+list[i].title+"</h3>\n" +
                "                        <p>"+list[i].age+"</p>\n" +
                "                    </div>\n" +
                "                    <p>"+list[i].description+"</p>\n" +
                "                    <div>\n" +
                "                        <a class=\"item-button\"  href=\"detail.jsp?id="+list[i].artwordID+" \">查看</a>\n" +
                "                        <a class=\"item-button\" href=\"#\">热度<span class=\"heat-number\">"+list[i].view+"</span> </a>\n" +
                "                    </div>\n" +
                "                </div>"

        }
        $(".item-box").html(str);
    }
});