<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Favorite</title>
    <meta charset="UTF-8"/>
    <link rel="stylesheet" href="../css/bootstrap.min.css"/>
    <link href="../font/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../css/util.css"/>
    <script type="text/javascript" rel="script" src="../js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" rel="script" src="../js/popper.min.js"></script>
    <script type="text/javascript" rel="script" src="../js/bootstrap.min.js"></script>
    <script type="text/javascript" rel="script" src="../js/util.js"></script>
    <script type="text/javascript" rel="script" src="../js/favorite.js"></script>
</head>
<body>
<jsp:include page="../inc/header.inc.jsp"/>

<jsp:include page="../inc/nav.inc.jsp"/>

<jsp:useBean id="favoriteVisibilityMap" type="java.util.Map<fudan.ossw.entity.Artwork,fudan.ossw.entity.Favorite>" scope="request"/>
<main>
    <div class="container row-fix">
        <div class="card">
            <div class="card-header">
                收藏夹
            </div>
            <ul class="list-group">
                <c:forEach items="${favoriteVisibilityMap}" var="entry">
                    <li class="list-group-item">
                        <div class="row">
                            <figure class="img-thumbnail col-2 offset-1">
                                <img src="../img/${entry.key.imageFileName}" width="150" height=150 alt="" />
                            </figure>
                            <div class="col-4 offset-1">
                                <table class="table">
                                    <tr>
                                        <td>名称</td>
                                        <td>${entry.key.title}</td>
                                    </tr>
                                    <tr>
                                        <td>馆藏地点</td>
                                        <td>${entry.key.location}</td>
                                    </tr>
                                    <tr>
                                        <td>热度</td>
                                        <td>${entry.key.view}</td>
                                    </tr>
                                    <tr>
                                        <td>收藏时间</td>
                                        <td>${entry.value.addTime}</td>
                                    </tr>
                                </table>
                            </div>
                            <div class="col-3 offset-1 align-self-center">
                                <div class="btn-group justify-content-center my-3">
                                    <a class="btn btn-info button-detail" href="./detail.jsp?id=${entry.key.artID}">查看详情</a>
                                    <button class="btn btn-danger button-delete" data-target="${entry.key.artID}">删除藏品</button>
                                </div>
                                <div class="custom-control custom-switch">
                                    <input type="checkbox" class="custom-control-input" <c:if test="${entry.value.visible}">checked</c:if> data-target="${entry.key.artID}" id="customSwitch${entry.key.artID}">
                                    <label class="custom-control-label" for="customSwitch${entry.key.artID}">公开该藏品</label>
                                </div>
                            </div>
                        </div>
                    </li>
                </c:forEach>
            </ul>
            <div class="card-footer">
                <div class="container align-content-center">
                    <ul class="pagination justify-content-center">
                        <li class="page-item disabled">
                            <a class="page-link" href="#" tabindex="-1" aria-disabled="true">Previous</a>
                        </li>
                        <li class="page-item"><a class="page-link" href="#">1</a></li>
                        <li class="page-item"><a class="page-link" href="#">2</a></li>
                        <li class="page-item"><a class="page-link" href="#">3</a></li>
                        <li class="page-item">
                            <a class="page-link" href="#">Next</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</main>

<jsp:include page="../inc/footer.inc.jsp"/>
</body>
</html>
