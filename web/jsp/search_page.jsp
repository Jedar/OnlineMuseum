<%@ page import="fudan.ossw.entity.Artwork" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 38403
  Date: 2019/7/19
  Time: 22:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Online Museum</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css"/>
    <link href="../font/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../css/util.css"/>
    <link rel="stylesheet" href="../css/search.css"/>
    <script type="text/javascript" rel="script" src="../js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" rel="script" src="../js/bootstrap.min.js"></script>
    <script type="text/javascript" rel="script" src="../js/search.js"></script>
</head>
<body>
<jsp:include page="../inc/header.inc.jsp"/>

<main class="container">
    <div class="row-fix">
        <form action="./search.jsp" class="row">
            <div class="form-group col-7">
                <label for="search-title">藏品名</label>
                <input type="text" class="form-control" name="title" id="search-title" placeholder="藏品名" value="${requestScope.value.title}">
            </div>
            <div class="form-group col-7">
                <label for="search-description">藏品描述</label>
                <input type="text" class="form-control" name="description" id="search-description" placeholder="藏品描述" value="${requestScope.value.description}">
            </div>
            <div class="form-group col-7">
                <label for="search-location">馆藏地点</label>
                <input type="text" class="form-control" name="location" id="search-location" placeholder="馆藏地点" value="${requestScope.value.location}">
            </div>
            <div class="form-group col-7">
                <label for="search-sort">排序方式</label>
                <select class="form-control" name="sort" id="search-sort">
                    <option value="view" ${requestScope.option1}>热度</option>
                    <option value="timeReleased" ${requestScope.option2}>发布时间</option>
                </select>
            </div>
            <div class="form-group col-6">
                <input  type="submit" class="btn btn-primary">
            </div>
        </form>
    </div>
    <div class="card">
        <div class="card-header">
            <h2 class="page-title">搜索结果:</h2>
        </div>
        <div class="card-body">
            <div class="item-box">

                <%
                    List artworks = (List)request.getAttribute("artworkList");

                    if (artworks == null){
                        artworks = new ArrayList();
                    }

                    if(artworks.size() == 0){
                %>
                        <div class="alert alert-info">抱歉，未找到相关结果</div>
                <%
                    }
                    for (int i = 0; i < artworks.size(); i++){
                        request.setAttribute("artwork",artworks.get(i));
                %>
                <div class="item">
                    <figure>
                        <a href="detail.jsp?id=${requestScope.artwork.artID}">
                            <img src="../img/${requestScope.artwork.imageFileName}" alt="">
                        </a>
                    </figure>
                    <div class="item-name">
                        <h3>${requestScope.artwork.title}</h3>
                        <p>${requestScope.artwork.age}</p>
                    </div>
                    <p>${requestScope.artwork.description}</p>
                    <div>
                        <a class="item-button"  href="detail.jsp?id=${requestScope.artwork.artID}">查看</a>
                        <a class="item-button" href="#">热度<span class="heat-number">${requestScope.artwork.view}</span> </a>
                    </div>
                </div>
                <%
                    }
                %>

            </div>
        </div>
        <div class="card-footer">
            <div class="paging-div">
                <div class="container align-content-center">
                    <ul class="pagination justify-content-center">
                        <li class="page-item">
                            <a class="page-link page-previous ${requestScope.previousOption}" href="#">Previous</a>
                        </li>

                        <li class="page-item">
                            <label>
                                <input id="page-input" value="1" class="form-control" type="number" min="1" max="${requestScope.totalNumber}">
                            </label>
                        </li>

                        <li class="page-item"><h4>/${requestScope.totalNumber}</h4></li>
                        <li class="page-item">
                            <a class="page-link page-next ${requestScope.previousOption}" href="#">Next</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>

    </div>
    <br><br>
</main>

<jsp:include page="../inc/footer.inc.jsp"/>

</body>
</html>
