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
    <title>Artwork Information</title>
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



<%--footer--%>
<jsp:include page="../inc/footer.inc.jsp"/>
</body>
</html>
