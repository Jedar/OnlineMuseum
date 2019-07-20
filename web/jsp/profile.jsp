<%--
  Created by IntelliJ IDEA.
  User: Peng Deng
  Date: 2019/7/20
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../font/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="../css/util.css"/>
    <script type="text/javascript" rel="script" src="../js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" rel="script" src="../js/bootstrap.min.js"></script>
    <script type="text/javascript" rel="script" src="../js/profile.js"></script>
    <script type="text/javascript" rel="script" src="../js/util.js"></script>
</head>
<body>
<jsp:include page="../inc/header.inc.jsp"/>
<jsp:include page="../inc/search.inc.jsp"/>
<main class="container-fluid">
    <div class="row">
        <div class="offset-1 col-2">
            <figure class="img-thumbnail">
                <img class="figure-img rounded" width="212" height="212" src="../img/019070.jpg" alt="">
            </figure>
            <h3>${sessionScope.user.username}</h3>
            <p><i class="fa fa-phone-square" aria-hidden="true"></i> 电话：${sessionScope.user.phone}</p>
            <p><i class="fa fa-envelope-o" aria-hidden="true"></i> 邮箱：${sessionScope.user.email}</p>
            <p><i class="fa fa-map-marker" aria-hidden="true"></i> 地址：${sessionScope.user.address}</p>
        </div>
        <div class = "offset-1 col-8">
            <ul class="nav nav-tabs" id="myTab" role="tablist">
                <li class="nav-item">
                    <a class="nav-link active" id="favorite-tab" data-toggle="tab" href="#favorite" role="tab" aria-controls="favorite" aria-selected="true">收藏夹 <span class="badge badge-pill badge-secondary">4</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id="friends-tab" data-toggle="tab" href="#friends" role="tab" aria-controls="friends" aria-selected="false">好友 <span class="badge badge-pill badge-secondary">4</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id="settings-tab" data-toggle="tab" href="#settings" role="tab" aria-controls="settings" aria-selected="false">编辑</a>
                </li>
            </ul>
            <div class="tab-content">
                <%
                    //藏品信息
                %>
                <div class="tab-pane active" id="favorite" role="tabpanel" aria-labelledby="favorite-tab">
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">
                            <div class="row">
                                <figure class="col-3">
                                    <img src="../img/019070.jpg" class="figure-img rounded" width="170" height="170" alt="" />
                                </figure>
                                <div class="col-4 offset-1">
                                    <table class="table">
                                        <tr>
                                            <td>名称</td>
                                            <td>玉马</td>
                                        </tr>
                                        <tr>
                                            <td>类别</td>
                                            <td>玉石</td>
                                        </tr>
                                        <tr>
                                            <td>尺寸</td>
                                            <td>12cm*13cm</td>
                                        </tr>
                                    </table>
                                </div>
                                <div class="col-2 offset-2 align-self-center">
                                    <div class="justify-content-center">
                                        <a class="btn btn-info favorite-detail" href="./detail.jsp?id=<%=1%>">查看详情</a>
                                        <br><br>
                                        <button class="btn btn-danger favorite-delete" data-target="<%=1%>">删除藏品</button>
                                    </div>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>

                <div class="tab-pane" id="friends" role="tabpanel" aria-labelledby="friends-tab">
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">
                            <div class="row">
                                <figure class="col-2">
                                    <img src="../img/019070.jpg" class="figure-img rounded" width="100" height="100" alt="" />
                                </figure>
                                <div class="col-4 offset-1 align-self-center">
                                    <h4>Admin</h4>
                                    <p><i class="fa fa-map-marker" aria-hidden="true"></i>上海</p>
                                </div>
                                <div class="col-2 offset-2 align-self-center">
                                    <div class="justify-content-center">
                                        <a class="btn btn-info friend-homepage" href="./detail.jsp?id=<%=1%>">查看主页</a>
                                        <br><br>
                                        <button class="btn btn-danger friend-delete" data-target="<%=1%>">删除好友</button>
                                    </div>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>

                <div class="tab-pane" id="settings" role="tabpanel" aria-labelledby="settings-tab">
                    <form>
                        <div class="form-group">
                            <label for="inputUsername">Username</label>
                            <input type="text" class="form-control" id="inputUsername" aria-describedby="usernameHelp" placeholder="Username">
                            <small id="usernameHelp" class="form-text text-muted">Your name </small>
                        </div>
                        <div class="form-group">
                            <label for="inputOldPassword">Password</label>
                            <input type="password" class="form-control" id="inputOldPassword" placeholder="Old Password">
                        </div>
                        <div class="form-group">
                            <label for="inputNewPassword">Password</label>
                            <input type="password" class="form-control" id="inputNewPassword" placeholder="New Password">
                        </div>
                        <div class="form-group">
                            <label for="inputEmail1">Email address</label>
                            <input type="email" class="form-control" id="inputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
                            <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                        </div>
                        <div class="form-group">
                            <label for="inputAddress">Address</label>
                            <input type="text" class="form-control" id="inputAddress" placeholder="Address">
                        </div>
                        <button id="changeInfo" class="btn btn-primary">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</main>

<jsp:include page="../inc/footer.inc.jsp"/>
</body>
</html>