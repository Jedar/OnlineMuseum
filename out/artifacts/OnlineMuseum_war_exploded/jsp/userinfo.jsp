<%--
  Created by IntelliJ IDEA.
  User: 38403
  Date: 2019/7/18
  Time: 22:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Information</title>
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
                <li class="nav-item"><a href="./detail.jsp" class="a-black nav-link active">详情</a></li>
                <li class="nav-item"><a href="./favorite.jsp" class="a-black nav-link disabled">个人界面</a> </li>
            </ul>
        </div>
    </nav>
</div>
<%--main--%>

<main class="container row-fix">
    <div class="card">
        <div class="card-header">
            新建用户信息
        </div>
        <div class="card-body">
            <form class="form row">
                <div class="form-group col-12">
                    <label for="info-name">
                        名称
                    </label>
                    <input class="form-control" type="text" name="info-name" id="info-name" placeholder="username" aria-describedby="helpBlock-name">
                    <small class="form-text text-muted invisible" id="helpBlock-name">用户名至少大于6个字符</small>
                </div>
                <div class="form-group col-12">
                    <label for="info-password">
                        密码
                    </label>
                    <input class="form-control" type="password" name="info-name" id="info-password" placeholder="password">
                    <small class="form-text text-muted invisible">密码至少大于6个字符</small>
                </div>
                <div class="form-group col-12">
                    <label for="info-address">
                        地址
                    </label>
                    <input class="form-control" type="text" name="info-name" id="info-address" placeholder="address">
                    <small class="form-text text-muted invisible">地址不能为空</small>
                </div>
                <div class="form-group col-12">
                    <label for="info-phone">
                        手机号码
                    </label>
                    <input class="form-control" type="text" name="info-name" id="info-phone" placeholder="phone">
                    <small class="form-text text-muted invisible">手机号码不能为空</small>
                </div>
                <div class="form-group col-12">
                    <label for="info-email">
                        邮箱地址
                    </label>
                    <input class="form-control has-error" type="text" name="info-name" id="info-email" placeholder="email">
                    <small class="form-text text-muted invisible">邮箱不能为空</small>
                </div>
                <div class="form-group col-6">
                    <label for="info-right">用户类型</label>
                    <select class="form-control" name="info-right" id="info-right">
                        <option>普通用户</option>
                        <option>管理员用户</option>
                    </select>
                </div>
            </form>
        </div>
        <div class="card-footer">
            <div class="row">
                <div class="offset-9 col-3">
                    <button class="btn btn-primary"><i class="fa fa-plus"></i>添加新用户</button>
                </div>
            </div>
        </div>
    </div>
    <br>

</main>

<%--footer--%>
<jsp:include page="../inc/footer.inc.jsp"/>
</body>
</html>
