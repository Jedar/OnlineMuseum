<%--
  Created by IntelliJ IDEA.
  User: 38403
  Date: 2019/7/11
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css"/>
    <link href="../font/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../css/util.css"/>
    <script type="text/javascript" rel="script" src="../js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" rel="script" src="../js/popper.min.js"></script>
    <script type="text/javascript" rel="script" src="../js/bootstrap.min.js"></script>
    <script type="text/javascript" rel="script" src="../js/util.js"></script>
    <script src="http://cdn.bootcss.com/blueimp-md5/1.1.0/js/md5.js"></script>
    <script type="text/javascript" rel="script" src="../js/signup.js"></script>
</head>
<body>
<jsp:include page="../inc/header.inc.jsp"/>
<main class="register-img">
    <div class="row">
        <div class="col-md-4 offset-md-6">
            <div class="card">
                <div class="card-header">注册</div>
                <form class="card-body">
                    <div class="form-group">
                        <label>昵称：</label>
                        <input class="form-control" type="text" id="register-name" name="name" placeholder="请输入用户名">
                        <div class="conflictDiv invisible"><i class="fa fa-exclamation-circle fa-lg"></i> </div>
                    </div>
                    <div class="form-group">
                        <label>密码：</label>
                        <input class="form-control" type="password" id="register-psw" name="psw" placeholder="密码">
                        <div class="conflictDiv invisible"><i class="fa fa-exclamation-circle fa-lg"></i> </div>
                    </div>
                    <div class="form-group">
                        <label>确认密码：</label>
                        <input class="form-control" type="password" id="register-sure" name="psw-sure" placeholder="确认密码">
                        <div class="conflictDiv invisible"><i class="fa fa-exclamation-circle fa-lg"></i> </div>
                    </div>
                    <div class="form-group">
                        <label>邮箱：</label>
                        <input class="form-control" type="email" id="register-email" name="email" placeholder="邮箱">
                        <div class="conflictDiv invisible"><i class="fa fa-exclamation-circle fa-lg"></i> </div>
                    </div>
                    <div class="form-group">
                        <label>地址：</label>
                        <input class="form-control" type="text" id="register-address" name="address" placeholder="地址">
                        <div class="conflictDiv invisible"><i class="fa fa-exclamation-circle fa-lg"></i> </div>
                    </div>
                    <div class="form-group">
                        <label>电话：</label>
                        <input class="form-control" type="tel" id="register-phone" name="phone" placeholder="电话">
                        <div class="conflictDiv invisible"><i class="fa fa-exclamation-circle fa-lg"></i> </div>
                    </div>
                    <div class="form-group">
                        <label for="user-check">验证码：</label>
                        <input class="form-control" type="text" id="user-check" name="user-check">
                        <label class="alert alert-info check-number">1234</label>
                        <div class="conflictDiv invisible"><i class="fa fa-exclamation-circle fa-lg"></i> </div>
                    </div>
                </form>
                <div class="card-footer">
                    <button type="button" class="btn btn-primary float-right" id="btn-register">注册</button>
                </div>
            </div>

        </div>
    </div>
</main>
<jsp:include page="../inc/footer.inc.jsp"/>
</body>
</html>
