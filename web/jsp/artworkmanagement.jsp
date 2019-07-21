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
    <title>Artwork Management</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../css/bootstrap.min.css"/>
    <link href="../font/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../css/util.css"/>
    <script type="text/javascript" rel="script" src="../js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" rel="script" src="../js/popper.min.js"></script>
    <script type="text/javascript" rel="script" src="../js/bootstrap.min.js"></script>
    <script type="text/javascript" rel="script" src="../js/util.js"></script>
</head>
<body>
<%--header--%>
<jsp:include page="../inc/header.inc.jsp"/>
<jsp:include page="../inc/search.inc.jsp"/>
<%--nav--%>
<div class="container-fluid">
    <nav class="row bg-light" id="header-nav">
        <div class="col-md-5 offset-md-1">
            <ul class="nav nav-tabs nav-justified">
                <li class="nav-item"><a href="#" class="a-black nav-link">首页</a></li>
                <li class="nav-item"><a href="#" class="a-black nav-link">搜索</a></li>
                <li class="nav-item"><a href="./detail.jsp" class="a-black nav-link">详情</a></li>
                <li class="nav-item"><a href="favorite_page.jsp" class="a-black nav-link">个人界面</a> </li>
            </ul>
        </div>
    </nav>
</div>

<main>
    <div class="container row-fix">
        <div class="card">
            <div class="card-header">
                藏品列表
            </div>
            <ul class="list-group">
                <li class="list-group-item">
                    <div class="row">
                        <figure class="img-thumbnail col-2 offset-1">
                            <img src="../img/Test.jpg" width="150" height=150 alt="" />
                        </figure>
                        <div class="col-3 offset-1">
                            <table class="table">
                                <tr>
                                    <td>名称</td>
                                    <td>玉马</td>
                                </tr>
                                <tr>
                                    <td>上传日期</td>
                                    <td>2019-07-19</td>
                                </tr>
                                <tr>
                                    <td>尺寸</td>
                                    <td>12cm*13cm</td>
                                </tr>
                            </table>
                        </div>
                        <div class="col-2 offset-2 align-self-center">
                            <div class="btn-group-vertical justify-content-center">
                                <button class="btn btn-info"><i class="fa fa-info"></i> 查看详情</button>
                                <button class="btn btn-info"><i class="fa fa-cogs"></i> 修改信息</button>
                                <button class="btn btn-danger"><i class="fa fa-close"></i> 删除藏品</button>
                            </div>
                        </div>
                    </div>
                </li>
            </ul>
            <div class="card-footer">
                <div class="row">
                    <div class="offset-9 col-3">
                        <button class="btn btn-primary"><i class="fa fa-plus"></i>添加藏品</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>

<%--footer--%>
<jsp:include page="../inc/footer.inc.jsp"/>

</body>
</html>
