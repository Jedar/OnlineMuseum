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
    <script type="text/javascript" rel="script" src="../js/popper.min.js"></script>
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
            <a href="search_page.jsp" class="nav-link">搜索</a>
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
            <a href="profile.jsp" class="sign nav-link">个人中心</a>
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
            <img src="../img/${requestScope.heat0.imageFileName}" alt="Image">
            <div class="carousel-caption">
                <h3>${requestScope.heat0.title}</h3>
                <p>${requestScope.heat0.description}</p>
                <a href="./detail.jsp?id=${requestScope.heat0.artID}" type="button" class="btn btn-light btn-lg" >Learn More</a>
            </div>
        </div>
        <div class="carousel-item">
            <img src="../img/${requestScope.heat1.imageFileName}" alt="Image">
            <div class="carousel-caption">
                <h3>${requestScope.heat1.title}</h3>
                <p>${requestScope.heat1.description}</p>
                <a href="./detail.jsp?id=${requestScope.heat1.artID}" type="button" class="btn btn-light btn-lg" >Learn More</a>
            </div>
        </div>
        <div class="carousel-item">
            <img src="../img/${requestScope.heat2.imageFileName}" alt="Image">
            <div class="carousel-caption">
                <h3>${requestScope.heat2.title}</h3>
                <p>${requestScope.heat2.description}</p>
                <a href="./detail.jsp?id=${requestScope.heat2.artID}" type="button" class="btn btn-light btn-lg" >Learn More</a>
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
                ${requestScope.newest0.title}
            </h2>
            <p class="lead">
                ${requestScope.newest0.description}
            </p>
            <a href="./detail.jsp?id=${requestScope.newest0.artID}" type="button" class="btn btn-primary">View Details</a>
        </div>
        <div class="col-md-5">
            <img src="../img/${requestScope.newest0.imageFileName}" alt="">
        </div>
    </div>
    <hr>
    <div class="row featurette">
        <div class="col-md-7">
            <h2 class="featurete-heading">
                ${requestScope.newest1.title}
            </h2>
            <p class="lead">
                ${requestScope.newest1.description}
            </p>
            <a href="./detail.jsp?id=${requestScope.newest1.artID}" type="button" class="btn btn-primary">View Details</a>
        </div>
        <div class="col-md-5">
            <img src="../img/${requestScope.newest1.imageFileName}" alt="">
        </div>
    </div>
    <hr>
    <div class="row featurette">
        <div class="col-md-7">
            <h2 class="featurete-heading">
                ${requestScope.newest2.title}
            </h2>
            <p class="lead">
                ${requestScope.newest2.description}
            </p>
            <a href="./detail.jsp?id=${requestScope.newest2.artID}" type="button" class="btn btn-primary">View Details</a>
        </div>
        <div class="col-md-5">
            <img src="../img/${requestScope.newest2.imageFileName}" alt="">
        </div>
    </div>

</div>
    <hr>
</main>

<jsp:include page="../inc/footer.inc.jsp"/>
</body>
</html>
