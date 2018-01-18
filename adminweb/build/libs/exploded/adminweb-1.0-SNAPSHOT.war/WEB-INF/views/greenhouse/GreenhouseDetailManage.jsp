<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="m" uri="/morinda-tags" %>
<!DOCTYPE HTML>
<html>
<head>
    <title><spring:message code="sys.tital"/></title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <%-- 在IE运行最新的渲染模式 --%>
    <meta http-equiv=X-UA-Compatible content="IE=edge,chrome=1">
    <%-- 初始化移动浏览显示 --%>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="keywords" content=""/>
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);
    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
    <!-- Bootstrap Core CSS -->
    <link href="/static/css/bootstrap/bootstrap.css" rel='stylesheet' type='text/css'/>
    <!-- Custom CSS -->
    <link href="/static/css/custom/style.css" rel='stylesheet' type='text/css'/>
    <link href="../static/css/page/page.css" rel='stylesheet' type='text/css'/>
    <!-- font CSS -->
    <!-- font-awesome icons -->
    <link href="/static/css/font-awesome.css" rel="stylesheet">
    <!-- //font-awesome icons -->
    <link href="/static/css/animate.css" rel="stylesheet" type="text/css" media="all">
    <!-- js-->
    <script src="/static/js/jquery/jquery-1.11.1.min.js"></script>
    <script src="/static/js/modernizr.custom.js"></script>
    <script src="/static/js/wow.min.js"></script>
    <script>
        new WOW().init();
    </script>
    <script src="/static/js/metisMenu.min.js"></script>
    <script>
        $(function () {
            $('#menu').metisMenu();
        });
    </script>
    <script src="/static/js/custom.js"></script>
    <script src="/static/js/showRight.js"></script>
    <link rel="stylesheet" href="/static/css/detailsCss.css"/>
    <link href="/static/css/target.css" rel="stylesheet">
    <link rel="stylesheet" href="/static/css/zoom.css" media="all"/>
</head>

<body class="cbp-spmenu-push">
<div class="main-content">
    <div class='sidebar' role='navigation'>
        <div class='navbar-collapse'>
            <jsp:include page="../main/nav.jsp"></jsp:include>
            <jsp:include page="../main/header.jsp"></jsp:include>
            <!-- main content start-->
            <div id="page-wrapper" style="min-height: 453px;">
                <div class="main-page" style="padding-top: 45px">
                    <div id="content">
                        <div class="newDetail__" style="">
                            <div class="nav">
                                <div class="rightButton">
                                    <a class="btn btn-primary"  href="../greenhouse/getGreenhouseList">返回</a>
                                </div>
                            </div>
                            <div class="notice_inner" style="padding-bottom: 40px;width: auto;padding-left: 0;">
                                <h2 class="sideTitle">大棚名称：<span>${greenhouseDetail.gName}</span></h2>

                                <div class="container" style=" width: 100%;padding: 0;margin-top:8px">
                                    <ul class="gallery">
                                        <div class="col-lg-12"
                                             style="margin-bottom: 15px;border-top: 1px dashed #ccc;padding-top: 10px;padding-left: 0;">
                                            <div style="margin-left: -30px;">
                                                <c:forEach items="${greenhouseDetail.greenhouseDetailDTOList}"
                                                           var="item"
                                                           varStatus="status">
                                                    <div class="col-sm-4 annalDes">
                                                        <div class="team-member detail">
                                                            <h4 class="sideTime">${item.createDate}</h4>

                                                            <div class="col-sm-12 detailsList">
                                                                <div class="col-sm-2 targetImg">
                                                                    <c:choose>
                                                                        <c:when test="${item.imgUrl != null && item.imgUrl != ''}">
                                                                            <li>
                                                                                <a href="${item.imgUrl}">
                                                                                    <span class="imgSpan"
                                                                                          style="background:url(${item.imgUrl}) no-repeat center center;background-size:cover;"></span>
                                                                                </a>
                                                                            </li>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <span class="imgSpan"></span>
                                                                        </c:otherwise>
                                                                    </c:choose>
                                                                </div>
                                                                    <%--<c:if test="${item.description != null && item.description != ''}">--%>
                                                                    <%--<div class="col-sm-2  description">--%>
                                                                    <%--<p title="${item.description}">${fn:substring(item.description,0,40)}</p>--%>
                                                                    <%--</div>--%>
                                                                    <%--</c:if>--%>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </c:forEach>
                                            </div>
                                        </div>
                                    </ul>

                                </div>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="/static/js/zoom.min.js"></script>
<!-- Modal -->
<!-- main content end-->
<%@ include file="../main/foolter.jsp" %>
</body>
</html>