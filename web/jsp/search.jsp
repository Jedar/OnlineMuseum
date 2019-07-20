<%--
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
</head>
<body>
<jsp:include page="../inc/header.inc.jsp"/>

<jsp:include page="../inc/search.inc.jsp"/>

<main>
    <h2 class="page-title">搜索结果:</h2>
    <div class="sortbar">
        <form method="get" action="" name="sort">
            <p>排序方式 &nbsp;
                价格:<input type="radio" name="sort" value="price">
                热度:<input type="radio" name="sort" value="heat">
                标题:<input type="radio" name="sort" value="title"></p>
        </form>
    </div>
    <div class="item-box">
        <div class="item">
            <figure>
                <a href="detail.html?path=005050.jpg"><img src="images/works/medium/005050.jpg"></a>
            </figure>
            <div class="item-name">
                <h3>A Man With...</h3>
                <p>Jitian</p>
            </div>
            <p>This portrait was eloquently described by Giorgio.</p>
            <div>
                <a class="item-button" href="detail.html?path=005050.jpg">查看</a>
                <a class="item-button" href="#">热度<span class="heat-number">10</span> </a>
            </div>
        </div>
        <div class="item">
            <figure>
                <a href="detail.html?path=001130.jpg"><img src="images/works/medium/001130.jpg"></a>
            </figure>
            <div class="item-name">
                <h3>A Sunday</h3>
                <p>Ado min</p>
            </div>
            <p>It was proposed that Abstract speed.</p>
            <div>
                <a class="item-button" href="detail.html?path=001130.jpg">查看</a>
                <a class="item-button" href="#">热度<span class="heat-number">8</span> </a>
            </div>
        </div>
        <div class="item">
            <figure>
                <a href="detail.html?path=136010.jpg"><img src="images/works/medium/136010.jpg"></a>
            </figure>
            <div class="item-name">
                <h3>Abstract alt</h3>
                <p>Miro kindle</p>
            </div>
            <p>There is no instruction to this art.</p>
            <div>
                <a class="item-button" href="detail.html?path=136010.jpg">查看</a>
                <a class="item-button" href="#">热度<span class="heat-number">9</span> </a>
            </div>
        </div>
        <div class="item">
            <figure>
                <a href="detail.html?path=018030.jpg"><img src="images/works/medium/018030.jpg"></a>
            </figure>
            <div class="item-name">
                <h3>Pod Frat</h3>
                <p>Stave pole</p>
            </div>
            <p>Pod Frat was painted in oil canvas.</p>
            <div>
                <a class="item-button" href="detail.html?path=018030.jpg">查看</a>
                <a class="item-button" href="#">热度<span class="heat-number">6</span> </a>
            </div>
        </div>
        <div class="item">
            <figure>
                <a href="detail.html?path=019010.jpg"><img src="images/works/medium/019010.jpg"></a>
            </figure>
            <div class="item-name">
                <h3>Adoration</h3>
                <p>Lippi</p>
            </div>
            <p>Adoration in the forest is painted in...</p>
            <div>
                <a class="item-button" href="detail.html?path=019010.jpg">查看</a>
                <a class="item-button" href="#">热度<span class="heat-number">4</span> </a>
            </div>
        </div>
        <div class="item">
            <figure>
                <a href="detail.html?path=017050.jpg"><img src="images/works/medium/017050.jpg"></a>
            </figure>
            <div class="item-name">
                <h3>Acrobat a..</h3>
                <p>Poblo</p>
            </div>
            <p>There is no instruction to this art.</p>
            <div>
                <a class="item-button" href="detail.html?path=017050.jpg">查看</a>
                <a class="item-button" href="#">热度<span class="heat-number">6</span> </a>
            </div>
        </div>
        <div class="item">
            <figure>
                <a href="detail.html?path=045020.jpg"><img src="images/works/medium/045020.jpg"></a>
            </figure>
            <div class="item-name">
                <h3>Age Of Inn...</h3>
                <p>John</p>
            </div>
            <p>Age of Inn is an oil on canvas.</p>
            <div>
                <a class="item-button" href="detail.html?path=045020.jpg">查看</a>
                <a class="item-button" href="#">热度<span class="heat-number">7</span> </a>
            </div>
        </div>
        <div class="item">
            <figure>
                <a href="detail.html?path=103030.jpg"><img src="images/works/medium/103030.jpg"></a>
            </figure>
            <div class="item-name">
                <h3>Alba Madonna</h3>
                <p>Rapheal</p>
            </div>
            <p>Alba Madonna was painted 400 years ago.</p>
            <div>
                <a class="item-button" href="detail.html?path=103030.jpg">查看</a>
                <a class="item-button" href="#">热度<span class="heat-number">4</span> </a>
            </div>
        </div>
        <div class="item">
            <figure>
                <a href="detail.html?path=019050.jpg"><img src="images/works/medium/019050.jpg"></a>
            </figure>
            <div class="item-name">
                <h3>Reap leap</h3>
                <p>Lop Naz</p>
            </div>
            <p>Reap leap is a famous painting 100 years ago.</p>
            <div>
                <a class="item-button" href="detail.html?path=019050.jpg">查看</a>
                <a class="item-button" href="#">热度<span class="heat-number">8</span> </a>
            </div>
        </div>
    </div>
    <div class="paging-div">
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
</main>

<jsp:include page="../inc/footer.inc.jsp"/>

</body>
</html>
