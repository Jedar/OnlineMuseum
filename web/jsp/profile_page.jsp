<%@ page import="fudan.ossw.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="fudan.ossw.entity.Favorite" %>
<%@ page import="fudan.ossw.entity.Artwork" %><%--
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
    <script src="http://cdn.bootcss.com/blueimp-md5/1.1.0/js/md5.js"></script>
</head>
<body>
<jsp:include page="../inc/header.inc.jsp"/>
<jsp:include page="../inc/search.inc.jsp"/>
<%
    List<User> friends = (List<User>)request.getAttribute("friends");
    List<Artwork> favorite = (List<Artwork>)request.getAttribute("favorite");
%>
<main class="container-fluid">
    <div class="row">
        <div class="offset-1 col-2">
            <figure class="img-thumbnail">
                <img class="figure-img rounded" width="212" height="212" src="../img/019070.jpg" alt="">
            </figure>
            <h3 id="username">${sessionScope.user.username}</h3>
            <h5 id="signature">${sessionScope.user.signature}</h5>
            <p><i class="fa fa-phone-square" aria-hidden="true"></i> 电话：<span id = "userPhone">${sessionScope.user.phone}</span></p>
            <p><i class="fa fa-envelope-o" aria-hidden="true"></i> 邮箱：<span id="userEmail">${sessionScope.user.email}</span></p>
            <p><i class="fa fa-map-marker" aria-hidden="true"></i> 地址：<span id="userAddress">${sessionScope.user.address}</span></p>
        </div>
        <div class = "offset-1 col-8">
            <ul class="nav nav-tabs" id="myTab" role="tablist">
                <li class="nav-item">
                    <a class="nav-link active" id="favorite-tab" data-toggle="tab" href="#favorite" role="tab" aria-controls="favorite" aria-selected="true">收藏夹 <span class="badge badge-pill badge-secondary"><%=favorite.size()%></span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id="friends-tab" data-toggle="tab" href="#friends" role="tab" aria-controls="friends" aria-selected="false">好友 <span class="badge badge-pill badge-secondary"><%=friends.size()%></span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id="settings-tab" data-toggle="tab" href="#settings" role="tab" aria-controls="settings" aria-selected="false">编辑</a>
                </li>
            </ul>
            <div class="tab-content">
                <div class="tab-pane active" id="favorite" role="tabpanel" aria-labelledby="favorite-tab">
                    <%
                        for(Artwork artwork : favorite) {
                    %>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">
                            <div class="row">
                                <figure class="col-3">
                                    <img src="../img/<%=artwork.getImageFileName()%>" class="figure-img rounded" width="170" height="170" alt="img" />
                                </figure>
                                <div class="col-4 offset-1">
                                    <table class="table">
                                        <tr>
                                            <td>名称</td>
                                            <td><%=artwork.getTitle()%></td>
                                        </tr>
                                        <tr>
                                            <td>年代</td>
                                            <td><%=artwork.getAge()%></td>
                                        </tr>
                                        <tr>
                                            <td>尺寸</td>
                                            <td><%=artwork.getSize()%></td>
                                        </tr>
                                    </table>
                                </div>
                                <div class="col-2 offset-2 align-self-center">
                                    <div class="justify-content-center">
                                        <a class="btn btn-info favorite-detail" href="detail_page.jsp?id=<%=artwork.getArtID()%>">查看详情</a>
                                        <br><br>
                                        <button class="btn btn-danger favorite-delete" data-target="<%=artwork.getArtID()%>">删除藏品</button>
                                    </div>
                                </div>
                            </div>
                        </li>
                    </ul>
                    <% } %>
                </div>

                <div class="tab-pane" id="friends" role="tabpanel" aria-labelledby="friends-tab">
                    <%
                        for(User friend : friends) {
                    %>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">
                            <div class="row">
                                <figure class="col-2">
                                    <img src="../img/019070.jpg" class="figure-img rounded" width="100" height="100" alt="" />
                                </figure>
                                <div class="col-4 offset-1 align-self-center">
                                    <h4><%=friend.getUsername()%></h4>
                                    <p><i class="fa fa-map-marker" aria-hidden="true"></i><%=friend.getAddress()%></p>
                                </div>
                                <div class="col-2 offset-2 align-self-center">
                                    <div class="justify-content-center">
                                        <a class="btn btn-info friend-homepage" href="friend.jsp?id=<%=friend.getUserID()%>">查看主页</a>
                                        <br><br>
                                        <button class="btn btn-danger friend-delete" data-target="<%=friend.getUserID()%>">删除好友</button>
                                    </div>
                                </div>
                            </div>
                        </li>
                    </ul>
                    <% } %>
                </div>

                <div class="tab-pane" id="settings" role="tabpanel" aria-labelledby="settings-tab">
                    <form>
                        <div class="form-group">
                            <label for="inputUsername">Username</label>
                            <input type="text" class="form-control" id="inputUsername" aria-describedby="usernameHelp" placeholder="Username">
                            <small id="usernameHelp" class="form-text text-muted">Your new username </small>
                        </div>
                        <div class="form-group">
                            <label for="inputSignature">Address</label>
                            <input type="text" class="form-control" id="inputSignature" aria-describedby="signatureHelp" placeholder="Signature">
                            <small id="signatureHelp" class="form-text text-muted">Your new signature</small>
                        </div>
                        <div class="form-group">
                            <label for="inputOldPassword">Password</label>
                            <input type="password" class="form-control" id="inputOldPassword" aria-describedby="passwordHelp" placeholder="Password">
                            <small id="passwordHelp" class="form-text text-muted">Your password, must input</small>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail">Email address</label>
                            <input type="email" class="form-control" id="inputEmail" aria-describedby="emailHelp" placeholder="Enter email">
                            <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                        </div>
                        <div class="form-group">
                            <label for="inputAddress">Address</label>
                            <input type="text" class="form-control" id="inputAddress" aria-describedby="addressHelp" placeholder="Address">
                            <small id="addressHelp" class="form-text text-muted">Your new address</small>
                        </div>
                        <div class="form-group">
                            <label for="inputPhone">Address</label>
                            <input type="text" class="form-control" id="inputPhone" aria-describedby="phoneHelp" placeholder="Address">
                            <small id="phoneHelp" class="form-text text-muted">Your new phone</small>
                        </div>
                    </form>
                    <div>
                        <button type="button" class="btn btn-primary" id="changeInfo">提交</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>

<jsp:include page="../inc/footer.inc.jsp"/>
</body>
</html>