<%@ page import="fudan.ossw.dao.ArtworkDao" %>
<%@ page import="fudan.ossw.dao.impl.ArtworkDaoImpl" %>
<%@ page import="fudan.ossw.entity.Artwork" %><%--
  Created by IntelliJ IDEA.
  User: 38403
  Date: 2019/7/13
  Time: 23:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detail</title>
    <meta charset="UTF-8"/>
    <link rel="stylesheet" href="../css/bootstrap.min.css"/>
    <link href="../font/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../css/util.css"/>
    <script type="text/javascript" rel="script" src="../js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" rel="script" src="../js/popper.min.js"></script>
    <script type="text/javascript" rel="script" src="../js/bootstrap.min.js"></script>
    <script type="text/javascript" rel="script" src="../js/util.js"></script>
    <script type="text/javascript" rel="script" src="../js/detail.js"></script>
</head>
<body>

<%--header--%>
<jsp:include page="../inc/header.inc.jsp"/>
<jsp:include page="../inc/search.inc.jsp"/>
<%--nav--%>
<jsp:include page="../inc/nav.inc.jsp"/>
<%--main--%>
<main class="container-fluid">
    <div class="row">
        <section class="detail-div offset-md-1 col-md-8">
            <div class="container">
                <h2 class="goods-name">${requestScope.collection.title}</h2>
            </div>
            <div class="row row-fix">
                <figure class="detail-fig col-md-5">
                    <div class="box" id="box">
                        <div id="smallBox" class="small">
                            <img src="../img/${requestScope.collection.imageFileName}" width="350" height="350" alt="" />
                            <div id="mask" class="mask"></div>
                        </div>
                    </div>
                </figure>
                <div class="col-md-7" id="details">
                    <table class="table table-striped">
                        <tr><th></th><th>藏品详情</th></tr>
                        <tr><td>名称:</td><td>${requestScope.collection.title}</td></tr>
                        <tr><td>年代:</td><td>${requestScope.collection.age}</td></tr>
                        <tr><td>尺寸:</td><td>${requestScope.collection.size}</td></tr>
                        <tr><td>描述:</td><td>${requestScope.collection.description}</td></tr>
                        <tr><td>出土年份:</td><td>${requestScope.collection.findTime}</td></tr>
                        <tr><td>馆藏地点:</td><td>${requestScope.collection.location}</td></tr>
                        <tr><td>热度:</td><td>${requestScope.collection.view}</td></tr>
                    </table>
                    <div>
                        <span class="invisible" id="id-num">${requestScope.collection.artID}</span>
                        <button id="bt-addToWish" class="btn btn-primary btn-sm"><i class="fa fa-star"></i> 加入收藏夹</button>
                        <button id="bt-video" class="btn btn-info btn-sm" data-toggle="modal" data-target="#videoModal"><i class="fa fa-file-video-o"></i> 观看藏品视频</button>
                        <a class="text-white btn btn-link btn-secondary  btn-sm ${requestScope.manageStr}" href="./artworkinfo.jsp?method=change&id=${requestScope.collection.artID}">
                            <i class="fa fa-cogs"></i>管理该藏品
                        </a>
                    </div>
                </div>
            </div>
        </section>
        <aside class="asideBar col-md-2 row-fix">
            <div class="list-group" id="artist-list">
                <span class="list-group-item list-group-item-info">推荐藏品</span>
                <a href="#" class="list-group-item list-group-item-action">青铜器</a>
                <a href="#" class="list-group-item list-group-item-action">青花瓷</a>
                <a href="#" class="list-group-item list-group-item-action">水墨画</a>
                <a href="#" class="list-group-item list-group-item-action">山水画</a>
                <a href="#" class="list-group-item list-group-item-action">梅花图</a>
                <a href="#" class="list-group-item list-group-item-action">菊花图</a>
                <a href="#" class="list-group-item list-group-item-action">天王石像</a>
            </div>
        </aside>
    </div>
    <br>
</main>

<div>
    <div class="modal fade" id="videoModal">
        <div class="modal-dialog">
            <div class="modal-content">

                <!-- 模态框头部 -->
                <div class="modal-header">
                    <h4 class="modal-title">藏品视频</h4>
                    <button type="button" class="close video-close" data-dismiss="modal">&times;</button>
                </div>

                <!-- 模态框主体 -->
                <div class="modal-body">
                    <video id="videoContent"  width="460" height="280" controls="controls">
                        <source src="../video/${requestScope.collection.videoFileName}" type="video/mp4" />
                        Your browser does not support HTML5 video.
                    </video>
                </div>

                <!-- 模态框底部 -->
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary video-close" data-dismiss="modal">关闭</button>
                </div>

            </div>
        </div>
    </div>
</div>

<jsp:include page="../inc/footer.inc.jsp"/>
</body>
</html>
