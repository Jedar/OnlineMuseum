function showTip(message) {
    $(".tip-content").html(message);
    $("#tip").removeClass('invisible').fadeIn("fast",function () {
        $("#tip").fadeOut(2000,function () {
            $("#tip").addClass('invisible');
        });
    });
}

function showError(message) {
    $(".error-content").html(message);
    $("#error").removeClass('invisible').fadeIn("fast",function () {
        $("#error").fadeOut(2000,function () {
            $("#error").addClass('invisible');
        });
    });
}

$(function () {

});
