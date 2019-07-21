<%--
  Created by IntelliJ IDEA.
  User: 38403
  Date: 2019/7/15
  Time: 1:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>header.inc</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css"/>
    <link href="../font/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../css/util.css"/>
    <script type="text/javascript" rel="script" src="../js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" rel="script" src="../js/bootstrap.min.js"></script>
    <script type="text/javascript" rel="script" src="../js/popper.min.js"></script>
    <script type="text/javascript" rel="script" src="../js/util.js"></script>
</head>
<body>
<nav class="row-fix  bg-dark text-white container-fluid">
    <div class="row justify-content-center">
            <%
                boolean isLogin;
                isLogin = (session.getAttribute("user") != null);
            %>

            <% if(!isLogin){%>
            <div class="offset-1 col-md-4">
                <h5>Welcome to <span id="top-logo">Online Museum</span></h5>
                <small class="login-or-sign">
                    <a class="a-white" href="../jsp/login.jsp">登陆</a>
                    或
                    <a href="../jsp/signup.jsp" class="a-white">注册</a>
                </small>
            </div>
            <ul class="col-md-3 offset-md-3 nav nav-justified">
                <li class="nav-item"><a href="../jsp/search_page.jsp" class="a-white nav-link"><i class="fa fa-search"></i> Search</a></li>
                <li class="nav-item"><a href="../jsp/login.jsp" class="a-white nav-link"><i class="fa fa-user-circle"></i> Login</a></li>
            </ul>
            <%}
            else {
            %>
            <div class="offset-1 col-md-4">
                <h5>Online Museum</h5>
            </div>
            <ul class="col-md-3 offset-md-3 nav nav-justified">
                <li class="nav-item">
                    <a href="../jsp/search_page.jsp" class="a-white nav-link"><i class="fa fa-search"></i> Search</a>
                </li>
                <li class="nav-item">
                    <div class="dropdown">
                        <a class="dropdown-toggle btn" type="link" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fa fa-user-circle"></i> UserName
                        </a>
                        <div class="dropdown-menu bg-dark text-white" aria-labelledby="dropdownMenuButton">
                            <a href="../jsp/message.jsp" class="a-white dropdown-item"><i class="fa fa-mail-forward"></i> Message</a>
                            <a href="../jsp/favorite.jsp" class="a-white dropdown-item"><i class="fa fa-star"></i> Favorite <span>0</span></a>
                            <div class="dropdown-divider"></div>
                            <a href="#" class="a-white dropdown-item"><i class="fa fa-sign-out"></i> Logout</a>
                        </div>
                    </div>
                </li>
            </ul>
            <%
            }%>

        <div id="top-signin" class="invisible" data-sign="<%= isLogin?"1":"0" %>"></div>

    </div>
</nav>
</body>
</html>
