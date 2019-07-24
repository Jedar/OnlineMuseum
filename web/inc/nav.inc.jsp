<%--
  Created by IntelliJ IDEA.
  User: 38403
  Date: 2019/7/22
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container-fluid">
    <nav class="row bg-light" id="header-nav">
        <div class="col-md-5 offset-md-1">
            <ul class="nav nav-tabs nav-justified">
                <li class="nav-item"><a href="./home.jsp" class="a-black nav-link ${requestScope.navItemHome}">首页</a></li>
                <li class="nav-item"><a href="./search.jsp" class="a-black nav-link ${requestScope.navItemSearch}">搜索</a></li>
                <li class="nav-item"><a href="./detail.jsp" class="a-black nav-link ${requestScope.navItemDetail}">详情</a></li>
                <li class="nav-item"><a href="./profile.jsp" class="a-black nav-link ${requestScope.navItemPerson}">个人界面</a> </li>
            </ul>
        </div>
    </nav>
</div>
