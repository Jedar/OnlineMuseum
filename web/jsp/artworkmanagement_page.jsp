<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 38403
  Date: 2019/7/18
  Time: 22:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Artwork Management</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../css/bootstrap.min.css"/>
    <link href="../font/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../css/util.css"/>
    <script type="text/javascript" rel="script" src="../js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" rel="script" src="../js/popper.min.js"></script>
    <script type="text/javascript" rel="script" src="../js/bootstrap.min.js"></script>
    <script type="text/javascript" rel="script" src="../js/util.js"></script>
    <script type="text/javascript" rel="script" src="../js/artwork.js"></script>
</head>
<body>
<%--header--%>
<jsp:include page="../inc/header.inc.jsp"/>
<jsp:include page="../inc/search.inc.jsp"/>
<%--nav--%>
<jsp:include page="../inc/nav.inc.jsp"/>

<main>
    <div class="container row-fix">
        <div class="card">
            <div class="card-header">
                藏品列表
            </div>
            <ul class="list-group">
                <%
                    List list = (List)request.getAttribute("artworkList");
                    for (Object artwork:list){
                        request.setAttribute("artwork",artwork);
                %>
                <li class="list-group-item">
                    <div class="row">
                        <figure class="img-thumbnail col-2 offset-1">
                            <img src="../img/${requestScope.artwork.imageFileName}" width="150" height=150 alt="" />
                        </figure>
                        <div class="col-3 offset-1">
                            <table class="table">
                                <tr>
                                    <td>名称</td>
                                    <td>${requestScope.artwork.title}</td>
                                </tr>
                                <tr>
                                    <td>上传日期</td>
                                    <td>${requestScope.artwork.timeReleased}</td>
                                </tr>
                                <tr>
                                    <td>尺寸</td>
                                    <td>${requestScope.artwork.size}</td>
                                </tr>
                            </table>
                        </div>
                        <div class="col-2 offset-2 align-self-center">
                            <div class="btn-group-vertical justify-content-center">
                                <a href="./detail.jsp?id=${requestScope.artwork.artID} " class="btn btn-info"><i class="fa fa-info"></i> 查看详情</a>
                                <a href="./artworkinfo.jsp?id=${requestScope.artwork.artID}&method=change " class="btn btn-info"><i class="fa fa-cogs"></i> 修改信息</a>
                                <button class="btn btn-danger delete-artwork" data-target="${requestScope.artwork.artID} "><i class="fa fa-close"></i> 删除藏品</button>
                            </div>
                        </div>
                    </div>
                </li>

                <%
                    }
                %>
            </ul>
            <div class="card-footer">
                <div class="row">
                    <div class="offset-9 col-3">
                        <a href="./artworkinfo.jsp?method=upload" class="btn btn-primary"><i class="fa fa-plus"></i>添加藏品</a>
                    </div>
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
