<%@ page import="java.util.List" %>
<%@ page import="fudan.ossw.entity.User" %><%--
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
    <%--下面的库用域验证表单信息--%>
    <script src="https://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
    <script src="https://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>

    <script type="text/javascript" rel="script" src="../js/peoplepage.js"></script>
</head>
<body>
<%--header--%>
<jsp:include page="../inc/header.inc.jsp"/>
<jsp:include page="../inc/search.inc.jsp"/>
<%--nav--%>
<jsp:include page="../inc/nav.inc.jsp"/>
<%--main--%>

<main class="container row-fix">
    <div class="card">
        <div class="card-header">
            人员信息
        </div>
        <div class="card-body">
            <ul class="list-group">

                <%
                    List users = (List) request.getAttribute("users");
                    User user = (User) request.getAttribute("user");
                    for (Object u:users){
                        if(((User)u).getUserID() == user.getUserID()){
                            continue;
                        }
                        request.setAttribute("cur",u);
                        String btnUp = ((User)u).getIsManager()?"disabled":"";
                        String btnDown = ((User)u).getIsManager()?"":"disabled";
                %>
                <li class="list-group-item">
                    <div class="row">
                        <div class="col-3 offset-1">
                            <table class="table">
                                <tr>
                                    <td>用户ID</td>
                                    <td>${requestScope.cur.userID}</td>
                                </tr>
                                <tr>
                                    <td>用户名</td>
                                    <td>${requestScope.cur.username}</td>
                                </tr>
                                <tr>
                                    <td>邮箱</td>
                                    <td>${requestScope.cur.email}</td>
                                </tr>
                                <tr>
                                    <td>最近登陆</td>
                                    <td>${requestScope.cur.lastLogin}</td>
                                </tr>
                                <tr>
                                    <td>是否管理员</td>
                                    <td>${requestScope.cur.isManager}</td>
                                </tr>
                            </table>
                        </div>
                        <div class="col-3 offset-1 align-self-center">
                            <h6>管理员权限管理</h6>
                            <hr>
                            <div class="btn-group-vertical">
                                <button data-target="${requestScope.cur.userID}" class="change-type btn btn-primary <%=btnUp%>"><i class="fa fa-arrow-up"></i> 提升为管理员</button>
                                <button data-target="${requestScope.cur.userID}" class="change-type btn btn-primary <%=btnDown%>"><i class="fa fa-arrow-down"></i>降级为普通用户</button>
                            </div>
                            <hr>
                        </div>
                        <div class="col-3 offset-1 align-self-center">
                            <h6>用户信息管理</h6>
                            <hr>
                            <div class="btn-group-vertical">
                                <a class="btn btn-info" href="./friend.jsp?id=${requestScope.cur.userID}">查看用户</a>
                                <button data-target="${requestScope.cur.userID}" class="delete-user btn btn-danger">删除用户</button>
                            </div>
                            <hr>
                        </div>
                    </div>
                </li>
                <%
                    }
                %>

            </ul>
        </div>
        <div class="card-footer">
            <div class="row">
                <div class="offset-9 col-3">
                    <a href="peopleinfo_page.jsp" class="btn btn-primary"><i class="fa fa-plus"></i>添加新用户</a>
                </div>
            </div>
        </div>
    </div>
    <br><br>

</main>

<%--footer--%>
<jsp:include page="../inc/footer.inc.jsp"/>
</body>
</html>
