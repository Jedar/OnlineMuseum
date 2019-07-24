<%@ page import="fudan.ossw.entity.Message" %>
<%@ page import="java.util.List" %>
<%@ page import="fudan.ossw.entity.Request" %>
<%@ page import="fudan.ossw.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: Peng Deng
  Date: 2019/7/20
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Message</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../font/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="../css/util.css"/>
    <script type="text/javascript" rel="script" src="../js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" rel="script" src="../js/popper.min.js"></script>
    <script type="text/javascript" rel="script" src="../js/bootstrap.js"></script>
    <script type="text/javascript" rel="script" src="../js/util.js"></script>
    <script type="text/javascript" rel="script" src="../js/message.js"></script>
</head>
<body>
<jsp:include page="../inc/header.inc.jsp"/>
<jsp:include page="../inc/search.inc.jsp"/>
<jsp:useBean id="readMessages" type="java.util.List<fudan.ossw.entity.Message>" scope="request"/>
<jsp:useBean id="unreadMessages" type="java.util.List<fudan.ossw.entity.Message>" scope="request"/>
<jsp:useBean id="sendMessages" type="java.util.List<fudan.ossw.entity.Message>" scope="request"/>
<jsp:useBean id="requests" type="java.util.List<fudan.ossw.entity.Request>" scope="request"/>
<jsp:useBean id="senderOfReadMessages" type="java.util.List<fudan.ossw.entity.User>" scope="request"/>
<jsp:useBean id="senderOfUnreadMessages" type="java.util.List<fudan.ossw.entity.User>" scope="request"/>
<jsp:useBean id="receiverOfSendMessages" type="java.util.List<fudan.ossw.entity.User>" scope="request"/>
<jsp:useBean id="senderOfRequests" type="java.util.List<fudan.ossw.entity.User>" scope="request"/>
<jsp:useBean id="friends" type="java.util.List<fudan.ossw.entity.User>" scope="request"/>
<jsp:useBean id="recommendFriends" type="java.util.List<fudan.ossw.entity.User>" scope="request"/>
<main class="container">
    <div class="row">
        <div class="col-3">
            <ul class="nav flex-column nav-pills bg-light" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                <li>
                    <a class="nav-link active " id="v-pills-receivedMessage-tab" data-toggle="pill" href="#v-pills-receivedMessage" role="tab" aria-controls="v-pills-receivedMessage" aria-selected="true">收件箱 <span class="badge badge-pill badge-secondary">${readMessages.size() + unreadMessages.size()}</span></a>
                </li>
                <li class="mx-auto">
                    <a class="nav-link" id="v-pills-readMessage-tab" data-toggle="pill" href="#v-pills-readMessage" role="tab" aria-controls="v-pills-readMessage" aria-selected="false"><i class="fa fa-envelope-open-o" aria-hidden="true"></i> 已读 <span class="badge badge-pill badge-secondary">${readMessages.size()}</span></a>
                </li>
                <li class="mx-auto">
                    <a class="nav-link" id="v-pills-unreadMessage-tab" data-toggle="pill" href="#v-pills-unreadMessage" role="tab" aria-controls="v-pills-unreadMessage" aria-selected="false"><i class="fa fa-envelope-o" aria-hidden="true"></i> 未读 <span class="badge badge-pill badge-secondary">${unreadMessages.size()}</span></a>
                </li>
                <li>
                    <a class="nav-link" id="v-pills-sendMessage-tab" data-toggle="pill" href="#v-pills-sendMessage" role="tab" aria-controls="v-pills-sendMessage" aria-selected="false"><i class="fa fa-share-square-o" aria-hidden="true"></i> 发件箱 <span class="badge badge-pill badge-secondary">${sendMessages.size()}</span></a>
                </li>
                <li>
                    <a class="nav-link" id="v-pills-writeMessage-tab" data-toggle="pill" href="#v-pills-writeMessage" role="tab" aria-controls="v-pills-writeMessage" aria-selected="false"><i class="fa fa-pencil" aria-hidden="true"></i> 写信息</a>
                </li>
                <li>
                    <a class="nav-link" id="v-pills-addFriend-tab" data-toggle="pill" href="#v-pills-addFriend" role="tab" aria-controls="v-pills-addFriend" aria-selected="false"><i class="fa fa-address-book-o" aria-hidden="true"></i> 添加好友</a>
                </li>
                <li>
                    <a class="nav-link" id="v-pills-request-tab" data-toggle="pill" href="#v-pills-request" role="tab" aria-controls="v-pills-request" aria-selected="false"><i class="fa fa-hand-peace-o" aria-hidden="true"></i> 申请信息 <span class="badge badge-pill badge-secondary">${requests.size()}</span></a>
                </li>
            </ul>
        </div>
        <div class="col-9">
            <div class="tab-content" id="v-pills-tabContent">
                
                <div class="tab-pane fade show active" id="v-pills-readMessage" role="tabpanel" aria-labelledby="v-pills-home-tab">
                    <c:forEach var="readMessage" items="${readMessages}">
                        <c:set var="i" value="${readMessages.indexOf(readMessage)}"/>
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item">
                                <div class="card">
                                    <div class="card-header">
                                        From: ${senderOfReadMessages.get(i).username}
                                    </div>
                                    <div class="card-body">
                                        <blockquote class="blockquote mb-0">
                                            <p>${readMessages.get(i).content}</p>
                                                <%--<footer class="blockquote-footer">Someone famous in <cite title="Source Title">Source Title</cite></footer>--%>
                                        </blockquote>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </c:forEach>
                </div>

                <div class="tab-pane fade" id="v-pills-unreadMessage" role="tabpanel" aria-labelledby="v-pills-messages-tab">
                    <div class="unreadMessage" id="unreadMessage">
                        <c:forEach var="unreadMessage" items="${unreadMessages}">
                            <c:set var="i" value="${unreadMessages.indexOf(unreadMessage)}"/>
                            <div class="card">
                                <div class="card-header" id="heading${i}">
                                    <div class="row">
                                        <figure class="col-2">
                                            <img src="../img/019070.jpg" class="figure-img rounded" width="50" height="50" alt="img" />
                                        </figure>
                                        <div class="col-4 offset-1 align-self-center">
                                            <h4>From: ${senderOfUnreadMessages.get(i).username}</h4>
                                        </div>
                                        <div class="col-2 offset-2 align-self-center">
                                            <div class="justify-content-center">
                                                <button class="readMessage btn btn-info" type="button" data-toggle="collapse" data-target="#collapse${i}" aria-expanded="false" aria-controls="collapse${i}" data-whatever="${unreadMessage.messageID}">阅读</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div id="collapse${i}" class="collapse show" aria-labelledby="heading${i}" data-parent="#unreadMessage">
                                    <div class="card-body">
                                        <form>
                                            <div class="form-group">
                                                <label for="message">Content</label>
                                                <textarea class="form-control" readonly id="message" rows="3">${unreadMessages.get(i).content}</textarea>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
                
                <div class="tab-pane fade" id="v-pills-sendMessage" role="tabpanel" aria-labelledby="v-pills-sendMessage-tab">
                    <ul class="list-group list-group-flush">
                        <c:forEach var="sendMessage" items="${sendMessages}">
                            <c:set var="i" value="${sendMessages.indexOf(sendMessage)}"/>
                            <li class="list-group-item">
                                <div class="card">
                                    <div class="card-header">
                                        To: ${receiverOfSendMessages.get(i).username}
                                    </div>
                                    <div class="card-body">
                                        <blockquote class="blockquote mb-0">
                                            <p>${sendMessage.content}</p>
                                                <%--<footer class="blockquote-footer">Someone famous in <cite title="Source Title">Source Title</cite></footer>--%>
                                        </blockquote>
                                    </div>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
                
                <div class="tab-pane fade" id="v-pills-writeMessage" role="tabpanel" aria-labelledby="v-pills-writeMessage-tab">
                    <div class="accordion" id="accordionExample">
                        <c:forEach var="friend" items="${friends}">
                            <c:set var="i" value="${friends.indexOf(friend)}"/>
                            <div class="card">
                                <div class="card-header" id="friend${i}">
                                    <div class="row">
                                        <figure class="col-2">
                                            <img src="../img/201903.jpg" class="figure-img rounded" width="100" height="100" alt="" />
                                        </figure>
                                        <div class="col-4 offset-1 align-self-center">
                                            <h4>${friend.username}</h4>
                                            <p><i class="fa fa-map-marker" aria-hidden="true"></i>${friend.address}</p>
                                        </div>
                                        <div class="col-2 offset-2 align-self-center">
                                            <div class="justify-content-center">
                                                <button class="btn btn-info" type="button" data-toggle="collapse" data-target="#collapseFriend${friend.userID}" aria-expanded="false" aria-controls="collapseFriend${friend.userID}">发消息</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div id="collapseFriend${friend.userID}" class="collapse" aria-labelledby="friend${friend.userID}" data-parent="#accordionExample">
                                    <div class="card-body">
                                        <form>
                                            <div class="form-group">
                                                <label for="messageContent${friend.userID}">Content</label>
                                                <textarea class="form-control" id="messageContent${friend.userID}" rows="3"></textarea>
                                            </div>
                                        </form>
                                        <button class="sendMessage btn btn-primary" data-target="${friend.userID}">Send</button>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
                
                <div class="tab-pane fade" id="v-pills-addFriend" role="tabpanel" aria-labelledby="v-pills-addFriend-tab">
                    <div class="card">
                        <div class="card-header">
                            你可能认识：
                        </div>
                        <div class="card-body">
                            <ul class="list-group list-group-flush">
                                <c:forEach items="${recommendFriends}" var="friend">
                                    <li class="list-group-item">
                                        <div class="row">
                                            <figure class="col-2">
                                                <img src="../img/019070.jpg" class="figure-img rounded" width="100" height="100" alt="" />
                                            </figure>
                                            <div class="col-4 offset-1 align-self-center">
                                                <h4>${friend.username}</h4>
                                                <p><i class="fa fa-map-marker" aria-hidden="true"></i>${friend.address}</p>
                                            </div>
                                            <div class="col-2 offset-2 align-self-center">
                                                <div class="justify-content-center">
                                                    <button type="button" class="btn btn-primary add-friend-button recommend-friend-item" data-toggle="modal" data-target="#addFriendRequest" data-whatever="${friend.userID}">加为好友</button>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                    <div class="searchBar my-3">
                        <form class="form-inline" role="form">
                            <div class="input-group">
                                <input type="text" class="form-control" id="search-friend-input" placeholder="搜索">
                                <span class="input-group-btn">
                                    <button class="btn btn-primary" id="search-friend-button" type="button"><i class="fa fa-search"></i>Search</button>
                                </span>
                            </div><!-- /input-group -->
                        </form>
                    </div>
                    <div class="card">
                        <div class="card-header">
                            搜索结果：
                        </div>
                        <div class="card-body">
                            <ul id="search-result" class="list-group list-group-flush">

                            </ul>
                        </div>
                        <div class="modal fade" id="addFriendRequest" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">添加好友</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        <form>
                                            <div class="form-group">
                                                <label for="message-text" class="col-form-label">申请信息:</label>
                                                <textarea class="form-control" id="message-text"></textarea>
                                            </div>
                                        </form>
                                    </div>
                                    <div class="modal-footer">
                                        <button id="send-friend-request" type="button" class="btn btn-primary" data-dismiss="modal">Send message</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    </div>
                
                <div class="tab-pane fade" id="v-pills-request" role="tabpanel" aria-labelledby="v-pills-request-tab">
                    <ul class="list-group list-group-flush">
                        <c:forEach var="request" items="${requests}">
                            <c:set var="i" value="${requests.indexOf(request)}"/>
                            <li class="list-group-item">
                                <div class="row">
                                    <figure class="col-2">
                                        <img src="../img/201904.jpg" class="figure-img rounded" width="100" height="100" alt="" />
                                    </figure>
                                    <div class="col-4 offset-1 align-self-center">
                                        <h4>${senderOfRequests.get(i).username}</h4>
                                        <p>${request.content}</p>
                                    </div>
                                    <div class="col-2 offset-2 align-self-center">
                                        <c:if test="${requests.get(i).isRead}">
                                            <c:if test="${requests.get(i).agree}">
                                                <div class="justify-content-center">
                                                    <button class="btn btn-info disabled" type="button">已同意</button>
                                                </div>
                                            </c:if>
                                            <c:if test="${!requests.get(i).agree}">
                                                <div class="justify-content-center">
                                                    <button class="btn btn-info disabled" type="button">已拒绝</button>
                                                </div>
                                            </c:if>
                                        </c:if>
                                        <c:if test="${!requests.get(i).isRead}">
                                            <div class="justify-content-center wrapper">
                                                <button class="btn btn-info agreeRequest" type="button" data-target="${request.senderID}">同意</button>
                                                <br><br>
                                                <button class="btn btn-danger refuseRequest" type="button" data-target="${request.senderID}">拒绝</button>
                                            </div>
                                        </c:if>
                                    </div>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                </div>

            </div>
        </div>
    </div>
</main>

<jsp:include page="../inc/footer.inc.jsp"/>
</body>
</html>