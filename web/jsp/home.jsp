<%--
  Created by IntelliJ IDEA.
  User: 38403
  Date: 2019/7/19
  Time: 22:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Online Museum</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css"/>
    <link href="../font/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../css/util.css"/>
    <script type="text/javascript" rel="script" src="../js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" rel="script" src="../js/bootstrap.min.js"></script>
</head>
<body>

<div id="homeCarousel" class="carousel slide" data-ride="carousel">
    <!--首页导航栏-->
    <nav class="row justify-content-center home-nav">
        <div class="col-md-5 offset-md-1">
            <span class="home-logo">Online Museum</span>
            <span class="logoBehind">Where you find GENIUS and EXTROORDINARY</span>
        </div>
        <div class="nav col-md-4 offset-md-2">
            <a href="#" class="nav-link">首页</a>
            <a href="./search.jsp" class="nav-link">搜索</a>
            <a href="./detail.jsp" class="nav-link">详情</a>
            <%
                if (session.getAttribute("user") == null){
            %>
            <a href="./login.jsp" class="sign nav-link">登陆</a>
            <a href="./signup.jsp" class="register nav-link">注册</a>
            <%
                }
                else{
            %>
            <a href="./profile.jsp" class="sign nav-link">个人中心</a>
            <%
                }
            %>

        </div>
    </nav>
    <!-- 指示符 -->
    <ul class="carousel-indicators">
        <li data-target="#homeCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#homeCarousel" data-slide-to="1"></li>
        <li data-target="#homeCarousel" data-slide-to="2"></li>
    </ul>
    <!-- 轮播图片 -->
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="../img/201902.jpg" alt="Image">
            <div class="carousel-caption">
                <h3>Caption</h3>
                <p>Deeply influenced the art of the twentieth Century.</p>
                <button type="button" class="btn btn-light btn-lg" >Learn More</button>
            </div>
        </div>
        <div class="carousel-item">
            <img src="../img/201903.jpg" alt="Image">
            <div class="carousel-caption">
                <h3>Caption</h3>
                <p>Deeply influenced the art of the twentieth Century.</p>
                <button type="button" class="btn btn-light btn-lg" >Learn More</button>
            </div>
        </div>
        <div class="carousel-item">
            <img src="../img/201904.jpg" alt="Image">
            <div class="carousel-caption">
                <h3>Caption</h3>
                <p>Deeply influenced the art of the twentieth Century.</p>
                <button type="button" class="btn btn-light btn-lg" >Learn More</button>
            </div>
        </div>
    </div>
    <!-- 左右切换按钮 -->
    <a class="carousel-control-prev" href="#homeCarousel" data-slide="prev">
        <span class="carousel-control-prev-icon"></span>
    </a>
    <a class="carousel-control-next" href="#homeCarousel" data-slide="next">
        <span class="carousel-control-next-icon"></span>
    </a>
</div>
<main class="container" id="home-hot-part">
    <div class="card">
        <h1 class="card-body">New Art Works</h1>
    </div>
    <hr>
    <div class="row featurette">
        <div class="col-md-7">
            <h2 class="featurete-heading">
                Portrait of Elenor Toloks
            </h2>
            <p class="lead">
                Her books is organized into sections by epochs and ruling governments;at times,
                the compression of such a long history into this short space make it hard to digest,
                but Lancaster stops often to recount captivating legends and anecdotes. She seems to
                have a quote from every writer or thinker who ever visited Naples or its surroundings.
            </p>
            <button type="button" class="btn btn-primary">View Details</button>
        </div>
        <div class="col-md-5">
            <img src="../img/201902.jpg">
        </div>
    </div>
    <hr>
    <div class="row featurette">
        <div class="col-md-7 order-2">
            <h2 class="featurete-heading">
                Portrait of Elenor Toloks
            </h2>
            <p class="lead">
                Her books is organized into sections by epochs and ruling governments;at times,
                the compression of such a long history into this short space make it hard to digest,
                but Lancaster stops often to recount captivating legends and anecdotes. She seems to
                have a quote from every writer or thinker who ever visited Naples or its surroundings.
            </p>
            <button type="button" class="btn btn-primary">View Details</button>
        </div>
        <div class="col-md-5 order-1">
            <img src="../img/201903.jpg">
        </div>
    </div>
    <hr>
    <div class="row featurette">
        <div class="col-md-7">
            <h2 class="featurete-heading">
                Portrait of Elenor Toloks
            </h2>
            <p class="lead">
                Her books is organized into sections by epochs and ruling governments;at times,
                the compression of such a long history into this short space make it hard to digest,
                but Lancaster stops often to recount captivating legends and anecdotes. She seems to
                have a quote from every writer or thinker who ever visited Naples or its surroundings.
            </p>
            <button type="button" class="btn btn-primary">View Details</button>
        </div>
        <div class="col-md-5">
            <img src="../img/201904.jpg">
        </div>
    </div>
</main>

<jsp:include page="../inc/footer.inc.jsp"/>
</body>
</html>
