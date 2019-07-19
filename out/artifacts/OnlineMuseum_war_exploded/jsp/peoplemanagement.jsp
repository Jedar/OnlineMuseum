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
    <title>People Management</title>
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
                <li class="nav-item"><a href="./favorite.jsp" class="a-black nav-link">个人界面</a> </li>
            </ul>
        </div>
    </nav>
</div>
<%--main--%>

<main class="container row-fix">
    <div class="card">
        <div class="card-header">
            人员信息
        </div>
        <div class="card-body">
            <ul class="list-group">
                <li class="list-group-item">
                    <div class="row">
                        <div class="col-3 offset-1">
                            <table class="table">
                                <tr>
                                    <td>用户ID</td>
                                    <td>10326</td>
                                </tr>
                                <tr>
                                    <td>用户名</td>
                                    <td>Mike</td>
                                </tr>
                                <tr>
                                    <td>邮箱</td>
                                    <td>you@163.com</td>
                                </tr>
                                <tr>
                                    <td>最近登陆</td>
                                    <td>2019-07-17</td>
                                </tr>
                                <tr>
                                    <td>是否管理员</td>
                                    <td>是</td>
                                </tr>
                            </table>
                        </div>
                        <div class="col-3 offset-1 align-self-center">
                            <h6>管理员权限管理</h6>
                            <hr>
                            <div class="btn-group-vertical">
                                <button class="btn btn-primary disabled"><i class="fa fa-arrow-up"></i> 提升为管理员</button>
                                <button class="btn btn-primary"><i class="fa fa-arrow-down"></i>降级为普通用户</button>
                            </div>
                            <hr>
                        </div>
                        <div class="col-3 offset-1 align-self-center">
                            <h6>用户信息管理</h6>
                            <hr>
                            <div class="btn-group-vertical">
                                <button class="btn btn-info">查看用户</button>
                                <button class="btn btn-info">更改用户信息</button>
                                <button class="btn btn-danger">删除用户</button>
                            </div>
                            <hr>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
        <div class="card-footer">
            <div class="row">
                <div class="offset-9 col-3">
                    <button class="btn btn-primary"><i class="fa fa-plus"></i>添加新用户</button>
                </div>
            </div>
        </div>
    </div>

</main>

<%--footer--%>
<jsp:include page="../inc/footer.inc.jsp"/>
</body>
</html>
