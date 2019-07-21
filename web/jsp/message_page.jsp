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
<%
    @SuppressWarnings("unchecked")
    List<Message> readMessages = (List<Message>)request.getAttribute("readMessages");
    List<Message> unreadMessages = (List<Message>)request.getAttribute("unreadMessages");
    List<Message> sendMessages = (List<Message>)request.getAttribute("sendMessages");
    List<Request> requests = (List<Request>)request.getAttribute("requests");
    List<User> senderOfReadMessages = (List<User>)request.getAttribute("senderOfReadMessages");
    List<User> senderOfUnreadMessages = (List<User>)request.getAttribute("senderOfUnreadMessages");
    List<User> receiverOfSendMessages = (List<User>)request.getAttribute("receiverOfSendMessages");
    List<User> senderOfRequests = (List<User>)request.getAttribute("senderOfRequests");
    List<User> friends = (List<User>)request.getAttribute("friends");
%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Message</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../font/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="../css/util.css"/>
    <script type="text/javascript" rel="script" src="../js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" rel="script" src="../js/popper.min.js"></script>
    <script type="text/javascript" rel="script" src="../js/bootstrap.min.js"></script>
    <script type="text/javascript" rel="script" src="../js/util.js"></script>
    <script type="text/javascript" rel="script" src="../js/message.js"></script>
</head>
<body>
<jsp:include page="../inc/header.inc.jsp"/>
<jsp:include page="../inc/search.inc.jsp"/>
<main class="container">
    <div class="row">
        <div class="col-3">
            <ul class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                <li>
                    <a class="nav-link active " id="v-pills-receivedMessage-tab" data-toggle="pill" href="#v-pills-receivedMessage" role="tab" aria-controls="v-pills-receivedMessage" aria-selected="true">收件箱 <span class="badge badge-pill badge-secondary"><%=readMessages.size() + unreadMessages.size()%></span></a>
                </li>
                <li class="mx-auto">
                    <a class="nav-link" id="v-pills-readMessage-tab" data-toggle="pill" href="#v-pills-readMessage" role="tab" aria-controls="v-pills-readMessage" aria-selected="false">已读 <span class="badge badge-pill badge-secondary"><%=readMessages.size()%></span></a>
                </li>
                <li class="mx-auto">
                    <a class="nav-link" id="v-pills-unreadMessage-tab" data-toggle="pill" href="#v-pills-unreadMessage" role="tab" aria-controls="v-pills-unreadMessage" aria-selected="false">未读 <span class="badge badge-pill badge-secondary"><%=unreadMessages.size()%></span></a>
                </li>
                <li>
                    <a class="nav-link" id="v-pills-sendMessage-tab" data-toggle="pill" href="#v-pills-sendMessage" role="tab" aria-controls="v-pills-sendMessage" aria-selected="false">发件箱 <span class="badge badge-pill badge-secondary"><%=sendMessages.size()%></span></a>
                </li>
                <li>
                    <a class="nav-link" id="v-pills-writeMessage-tab" data-toggle="pill" href="#v-pills-writeMessage" role="tab" aria-controls="v-pills-writeMessage" aria-selected="false">写信息</a>
                </li>
                <li>
                    <a class="nav-link" id="v-pills-addFriend-tab" data-toggle="pill" href="#v-pills-addFriend" role="tab" aria-controls="v-pills-addFriend" aria-selected="false">添加好友</a>
                </li>
                <li>
                    <a class="nav-link" id="v-pills-request-tab" data-toggle="pill" href="#v-pills-request" role="tab" aria-controls="v-pills-request" aria-selected="false">申请信息 <span class="badge badge-pill badge-secondary"><%=requests.size()%></span></a>
                </li>
            </ul>
        </div>
        <div class="col-9">
            <div class="tab-content" id="v-pills-tabContent">
                <div class="tab-pane fade show active" id="v-pills-readMessage" role="tabpanel" aria-labelledby="v-pills-home-tab">
                    <%
                        for(int i = 0; i < readMessages.size(); i++) {
                    %>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">
                            <div class="card">
                                <div class="card-header">
                                    From: <%=senderOfReadMessages.get(i).getUsername()%>
                                </div>
                                <div class="card-body">
                                    <blockquote class="blockquote mb-0">
                                        <p><%=readMessages.get(i).getContent()%></p>
                                        <%--<footer class="blockquote-footer">Someone famous in <cite title="Source Title">Source Title</cite></footer>--%>
                                    </blockquote>
                                </div>
                            </div>
                        </li>
                    </ul>
                    <%
                        }
                    %>
                </div>
                <div class="tab-pane fade" id="v-pills-unreadMessage" role="tabpanel" aria-labelledby="v-pills-messages-tab">
                    <div class="unreadMessage" id="unreadMessage">
                        <%
                            for(int i = 0; i < unreadMessages.size(); i++) {
                        %>
                        <div class="card">
                            <div class="card-header" id="heading<%=i%>">
                                <div class="row">
                                    <figure class="col-2">
                                        <img src="../img/019070.jpg" class="figure-img rounded" width="50" height="50" alt="img" />
                                    </figure>
                                    <div class="col-4 offset-1 align-self-center">
                                        <h4>From: <%=senderOfUnreadMessages.get(i).getUsername()%></h4>
                                    </div>
                                    <div class="col-2 offset-2 align-self-center">
                                        <div class="justify-content-center">
                                            <button class="readMessage btn btn-info" type="button" data-toggle="collapse" data-target="#collapse<%=i%>" aria-expanded="false" aria-controls="collapse<%=i%>">阅读</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div id="collapse<%=i%>" class="collapse show" aria-labelledby="heading<%=i%>" data-parent="#unreadMessage">
                                <div class="card-body">
                                    <form>
                                        <div class="form-group">
                                            <label for="message">Content</label>
                                            <textarea class="form-control" readonly id="message" rows="3"><%=unreadMessages.get(i).getContent()%></textarea>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <%
                            }
                        %>
                    </div>
                </div>
                <div class="tab-pane fade" id="v-pills-sendMessage" role="tabpanel" aria-labelledby="v-pills-sendMessage-tab">
                    <ul class="list-group list-group-flush">
                        <%
                            for(int i = 0; i < sendMessages.size(); i++) {
                        %>
                        <li class="list-group-item">
                            <div class="card">
                                <div class="card-header">
                                    To: <%=receiverOfSendMessages.get(i).getUsername()%>
                                </div>
                                <div class="card-body">
                                    <blockquote class="blockquote mb-0">
                                        <p><%=sendMessages.get(i).getContent()%></p>
                                        <footer class="blockquote-footer">Someone famous in <cite title="Source Title">Source Title</cite></footer>
                                    </blockquote>
                                </div>
                            </div>
                        </li>
                        <%
                            }
                        %>
                    </ul>
                </div>
                <div class="tab-pane fade" id="v-pills-writeMessage" role="tabpanel" aria-labelledby="v-pills-writeMessage-tab">
                    <div class="accordion" id="accordionExample">
                        <%
                            for(int i = 0; i < friends.size(); i++) {
                        %>
                        <div class="card">
                            <div class="card-header" id="friend<%=i%>">
                                <div class="row">
                                    <figure class="col-2">
                                        <img src="../img/201903.jpg" class="figure-img rounded" width="100" height="100" alt="" />
                                    </figure>
                                    <div class="col-4 offset-1 align-self-center">
                                        <h4><%=friends.get(i).getUsername()%></h4>
                                        <p><i class="fa fa-map-marker" aria-hidden="true"></i><%=friends.get(i).getAddress()%></p>
                                    </div>
                                    <div class="col-2 offset-2 align-self-center">
                                        <div class="justify-content-center">
                                            <button class="btn btn-info" type="button" data-toggle="collapse" data-target="#collapseFriend<%=friends.get(i).getUserID()%>" aria-expanded="false" aria-controls="collapseFriend<%=friends.get(i).getUserID()%>">发消息</button>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div id="collapseFriend<%=friends.get(i).getUserID()%>" class="collapse show" aria-labelledby="friend<%=friends.get(i).getUserID()%>" data-parent="#accordionExample">
                                <div class="card-body">
                                    <form>
                                        <div class="form-group">
                                            <label for="messageContent<%=friends.get(i).getUserID()%>">Content</label>
                                            <textarea class="form-control" id="messageContent<%=friends.get(i).getUserID()%>" rows="3"></textarea>
                                        </div>
                                    </form>
                                    <button class="sendMessage btn btn-primary" data-target="<%=friends.get(i).getUserID()%>">Send</button>
                                </div>
                            </div>
                        </div>
                        <%
                            }
                        %>
                    </div>
                </div>
                <div class="tab-pane fade" id="v-pills-addFriend" role="tabpanel" aria-labelledby="v-pills-addFriend-tab">
                    <form>
                        <div class="form-group">
                            <label for="requestName">Name</label>
                            <input type="text" class="form-control" id="requestName" placeholder="username">
                        </div>
                        <div class="form-group">
                            <label for="requestContent">Content</label>
                            <textarea class="form-control" id="requestContent" rows="3"></textarea>
                        </div>
                    </form>
                    <button class="btn btn-primary" id="addFriend">Send</button>
                </div>
                <div class="tab-pane fade" id="v-pills-request" role="tabpanel" aria-labelledby="v-pills-request-tab">
                    <ul class="list-group list-group-flush">
                        <%
                            for(int i = 0; i < requests.size(); i++) {
                        %>
                        <li class="list-group-item">
                            <div class="row">
                                <figure class="col-2">
                                    <img src="../img/201904.jpg" class="figure-img rounded" width="100" height="100" alt="" />
                                </figure>
                                <div class="col-4 offset-1 align-self-center">
                                    <h4><%=senderOfRequests.get(i).getUsername()%></h4>
                                    <p><%=requests.get(i).getContent()%></p>
                                </div>
                                <div class="col-2 offset-2 align-self-center">
                                    <%
                                        if(requests.get(i).getIsRead()) {
                                            if(requests.get(i).getAgree()) {
                                    %>
                                    <div class="justify-content-center">
                                        <button class="btn btn-info disabled" type="button">已同意</button>
                                    </div>
                                    <%
                                            }else {
                                    %>
                                    <div class="justify-content-center">
                                        <button class="btn btn-info disabled" type="button">已拒绝</button>
                                    </div>
                                    <%
                                            }
                                        } else{
                                    %>
                                    <div class="justify-content-center wrapper">
                                        <button class="btn btn-info agreeRequest" type="button" data-target="<%=requests.get(i).getSenderID()%>">同意</button>
                                        <br><br>
                                        <button class="btn btn-info refuseRequest" type="button" data-target="<%=requests.get(i).getSenderID()%>">拒绝</button>
                                    </div>
                                    <%
                                        }
                                    %>
                                </div>
                            </div>
                        </li>
                        <%
                            }
                        %>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</main>

<jsp:include page="../inc/footer.inc.jsp"/>
</body>
</html>