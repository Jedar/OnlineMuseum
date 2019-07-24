$(function () {
   $(".delete-artwork").on("click",function () {
      var btn = $(this);
      $.post("deleteArtwork.aws",{
          artID:btn.attr("data-target")
      },function (result) {
          result = JSON.parse(result);
          if (result.success) {
              btn.parents("li").slideUp("slow");
              showTip(result.message);
          }
          else {
              showError(result.message);
          }
      })
   });
});