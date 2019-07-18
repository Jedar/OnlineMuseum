<%--
  Created by IntelliJ IDEA.
  User: 38403
  Date: 2019/7/10
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css"/>
    <link href="../font/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../css/util.css"/>
    <script type="text/javascript" rel="script" src="../js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" rel="script" src="../js/bootstrap.min.js"></script>
    <script type="text/javascript" rel="script" src="../js/util.js"></script>
    <script type="text/javascript" rel="script" src="../js/login.js"></script>
</head>
<body>
<jsp:include page="../inc/header.inc.jsp"/>
<main class="login-img container-fluid">
    <div class="row">
        <div class="col-md-4 offset-md-6">
            <div class="card">
                <div class="card-header">登陆</div>
                <form class="card-body" id="form-login">
                    <div class="form-group">
                        <label for="user-name">用户名：</label>
                        <input class="form-control" type="text" name="user-name" id="user-name" placeholder="请输入用户名">
                        <div class="conflictDiv hidden"></div>
                    </div>
                    <div class="form-group">
                        <label for="user-psw">密码：</label>
                        <input class="form-control" type="password" id="user-psw" name="user-psw">
                        <div class="conflictDiv invisible"><i class="fa fa-exclamation-circle fa-lg"></i> </div>
                    </div>
                    <%--<div class="form-group">--%>
                    <%--<label for="user-check">验证码：</label>--%>
                    <%--<input class="form-control" type="text" id="user-check" name="user-check">--%>
                    <%--<label class="check-number">1234</label>--%>
                    <%--<div class="conflictDiv hidden"><i class="fa fa-exclamation-circle fa-lg"></i> </div>--%>
                    <%--</div>--%>
                </form>
                <div class="card-footer">
                    <button type="button" class="btn btn-primary float-right" id="btn-login">登陆</button>
                </div>
            </div>
        </div>
    </div>

</main>
<jsp:include page="../inc/footer.inc.jsp"/>
</body>
</html>
