<%--
  Created by IntelliJ IDEA.
  User: Peng Deng
  Date: 2019/7/21
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Friend</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css"/>
    <link href="../font/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../css/friend.css">
    <script type="text/javascript" rel="script" src="../js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" rel="script" src="../js/popper.min.js"></script>
    <script type="text/javascript" rel="script" src="../js/bootstrap.min.js"></script>
</head>
<body>
<section class="profile">
    <header class="header">
        <div class="details">
            <img src="../img/019070.jpg" alt="John Doe" class="profile-pic">
            <h1 class="heading">Username</h1>
            <div class="signature">
                <p>Signature</p>
            </div>
            <div class="stats">
                <div class="col-4">
                    <h6>Email</h6>
                    <p>17302010026@fudan.edu.cn</p>
                </div>
                <div class="col-4">
                    <h6>Phone</h6>
                    <p>15216628236</p>
                </div>
                <div class="col-4">
                    <h6>Address</h6>
                    <p>上海市杨浦区政通路220号</p>
                </div>
            </div>
        </div>
    </header>
</section>
<section class="container">
    <div class="my-3">
        <h3>最近收藏:</h3>
    </div>
    <div class="row">
        <div class="item col-2">
            <figure class="figure">
                <img src="../img/201902.jpg" class="figure-img img-fluid rounded" width="200" alt="...">
                <figcaption class="figure-caption">A caption for the above image lalalalal.</figcaption>
            </figure>
            <div class="mx-auto">
                <a class="item-button" href="detail.html?path=001130.jpg">查看</a>
            </div>
        </div>
        <div class="item col-2">
            <figure class="figure">
                <img src="../img/201902.jpg" class="figure-img img-fluid rounded" width="200" alt="...">
                <figcaption class="figure-caption">A caption for the above image lalalalal.</figcaption>
            </figure>
            <div class="mx-auto">
                <a class="item-button" href="detail.html?path=001130.jpg">查看</a>
            </div>
        </div>
        <div class="item col-2">
            <figure class="figure">
                <img src="../img/201902.jpg" class="figure-img img-fluid rounded" width="200" alt="...">
                <figcaption class="figure-caption">A caption for the above image lalalalal.</figcaption>
            </figure>
            <div class="mx-auto">
                <a class="item-button" href="detail.html?path=001130.jpg">查看</a>
            </div>
        </div>
        <div class="item col-2">
            <figure class="figure">
                <img src="../img/201902.jpg" class="figure-img img-fluid rounded" width="200" alt="...">
                <figcaption class="figure-caption">A caption for the above image lalalalal.</figcaption>
            </figure>
            <div class="mx-auto">
                <a class="item-button" href="detail.html?path=001130.jpg">查看</a>
            </div>
        </div>
        <div class="item col-2">
            <figure class="figure">
                <img src="../img/201902.jpg" class="figure-img img-fluid rounded" width="200" alt="...">
                <figcaption class="figure-caption">A caption for the above image lalalalal.</figcaption>
            </figure>
            <div class="mx-auto">
                <a class="" href="detail.jsp?id=?" role="button">查看</a>
            </div>
        </div>
    </div>
    <div class="my-3">
        <a class="btn btn-primary" href="profile_page.jsp" role="button">返回</a>
    </div>
</section>
</body>
</html>
