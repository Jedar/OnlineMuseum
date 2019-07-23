var infoTitle = $("#info-title");
var infoDescription = $("#info-description");
var infoSize = $("#info-size");
var infoLocation = $("#info-location");
var infoAge = $("#info-age");
var infoFindTime = $("#info-find-time");
var infoImage = $("#info-image");
var infoVideo = $("#info-video");

var imageFile = true;
var videoFile = true;

function check() {
    var title = infoTitle.val();
    var description = infoDescription.val();
    var size = infoSize.val();
    var location = infoLocation.val();
    var age = infoAge.val();
    var findTime = infoFindTime.val();
    var image = infoImage.files[0];
    var video = infoVideo.files[0];

    if (title === ""){
        showError("名称为空");
        return false;
    }
    if (description === "") {
        showError("描述为空");
        return false;
    }
    if (size === ""){
        showError("尺寸为空");
        return false;
    }
    if (location === ""){
        showError("馆藏地点为空");
        return false;
    }
    if (age === "") {
        showError("年代为空");
        return false;
    }
    if (findTime === "") {
        showError("发现时间为空");
        return false;
    }
    if (!image){
        imageFile = false;
    }
    else {
        imageFile = true;
    }
    if (!video) {
        videoFile = false;
    }
    else {
        videoFile = true;
    }
}

$(function () {

   $(".upload_artwork").on("click",function () {
       return check();
   });

   $(".change_artwork").on("click",function () {
       return check();
   });

   $(".delete-artwork").on("click",function () {
       var btn = $(this);
       $.post("./deleteArtwork.aws",{
           artID:btn.attr("data-target")
       },function (result) {
           result = JSON.parse(result);
           if (result.success) {
               showTip("删除成功");
               btn.parents("li").slideUp("slow");
           }
           else {
               showError(result.message);
           }
       })
   });
});