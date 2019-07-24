<%--
  Created by IntelliJ IDEA.
  User: 38403
  Date: 2019/7/18
  Time: 22:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Artwork Information</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css"/>
    <link href="../font/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../css/util.css"/>
    <script src="https://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
    <script type="text/javascript" rel="script" src="../js/popper.min.js"></script>
    <script type="text/javascript" rel="script" src="../js/bootstrap.min.js"></script>
    <script type="text/javascript" rel="script" src="../js/util.js"></script>
    <%--下面的库用域验证表单信息--%>
    <script src="https://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
    <script src="https://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
    <script type="text/javascript" rel="script" src="${requestScope.validateJS}"></script>
</head>
<body>
<%--header--%>
<jsp:include page="../inc/header.inc.jsp"/>
<jsp:include page="../inc/search.inc.jsp"/>
<%--nav--%>
<%--nav--%>
<jsp:include page="../inc/nav.inc.jsp"/>

<main class="container row-fix">
    <form id="artwork-info-form" class="form" action="${requestScope.action}" enctype="multipart/form-data" method="post">
        <div class="card">
            <div class="card-header">
                藏品信息
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="form-group col-12">
                        <input class="form-control" type="hidden" name="artID" value="${requestScope.artID}">
                    </div>
                    <div class="form-group col-12">
                        <label for="info-title">
                            藏品名称
                        </label>
                        <input class="form-control" type="text" name="title" id="info-title" placeholder="Title" value="${requestScope.artwork.title}">
                        <small class="form-text text-muted invisible" id="helpBlock-name">名称不能为空</small>
                    </div>
                    <div class="form-group col-12">
                        <label for="info-description">藏品描述:</label>
                        <textarea class="form-control" rows="5" id="info-description" name="description" placeholder="Enter description">${requestScope.artwork.description}</textarea>
                        <small class="form-text text-muted invisible">不能为空</small>
                    </div>
                    <div class="col-5">
                        <div class="form-group">
                            <label for="info-size">
                                尺寸
                            </label>
                            <input class="form-control" type="text" name="size" id="info-size" placeholder="address" value="${requestScope.artwork.size}">
                            <small class="form-text text-muted invisible">不能为空</small>
                        </div>
                        <div class="form-group">
                            <label for="info-location">
                                馆藏地点
                            </label>
                            <input class="form-control" type="text" name="location" id="info-location" placeholder="address" value="${requestScope.artwork.location}">
                            <small class="form-text text-muted invisible">不能为空</small>
                        </div>
                    </div>
                    <div class="col-5 offset-1 border border-primary rounded">
                        <div class="form-group">
                            <label for="info-age">
                                年代
                            </label>
                            <input class="form-control" type="text" name="age" id="info-age" placeholder="address" value="${requestScope.artwork.age}">
                            <small class="form-text text-muted invisible">不能为空</small>
                        </div>
                        <div class="form-group">
                            <label for="info-find-time">
                                出土时间
                            </label>
                            <input class="form-control" type="text" name="time" id="info-find-time" placeholder="address" value="${requestScope.artwork.findTime}">
                            <small class="form-text text-muted invisible">不能为空</small>
                        </div>
                    </div>
                    <hr class="col-11">
                    <div class="col-3">
                        <div class="form-group">
                            <label for="info-image">
                                上传图片
                            </label>
                            <input accept="image/png,image/jpeg" type="file" class="form-control" name="image" id="info-image" value="${requestScope.artwork.imageFileName}">
                            <small class="form-text text-muted invisible">不能为空</small>
                        </div>
                        <div class="form-group">
                            <label for="info-video">
                                上传介绍视频
                            </label>
                            <input accept="video/mp4" type="file" class="form-control" name="video" id="info-video" value="${requestScope.artwork.title}">
                            <small class="form-text text-muted invisible">不能为空</small>
                        </div>
                    </div>
                    <div class="col-5 offset-3">
                        <div class="card">
                            <div class="card-header">
                                图片预览
                            </div>
                            <div class="card-body">
                                <div class="img-thumbnail">
                                    <img alt="" id="img-preview" class="card-img" src="${requestScope.imageFileName}" width="250" height="250">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="card-footer">
                <div class="row">
                    <div class="offset-9 col-3">
                        <input type="submit" class="btn btn-primary ${requestScope.whatToDo}" value="${requestScope.btnName}">
                    </div>
                </div>
            </div>
        </div>
    </form>

    <br>

</main>

<%--footer--%>
<jsp:include page="../inc/footer.inc.jsp"/>
</body>
</html>
