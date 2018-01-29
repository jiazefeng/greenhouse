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
    <style>
        ul, li {
            margin: 0;
            padding: 0;
            list-style: none;
        }

        .item-img {
            position: relative;
            /*margin: 8px 0;*/
            /*margin-left: 200px;*/
            margin-bottom: 20px;
        }

        .item-img ul {
            font-size: 15px;
            position: absolute;
            top: 0;
            left: 0;
            color: #fff;
            text-shadow: 1px 1px 5px #000;
            border: 1px dotted rgba(255, 255, 255, 0.3);
            background: rgba(255, 255, 255, 0.3);
        }

        .item-img ul li {
            margin: 10px 15px;
        }

        .item-img img {
            max-width: 100%;
            box-shadow: 1px 1px 5px #ccc;
        }
    </style>

</head>

<body class="cbp-spmenu-push">
<div class="main-content">
    <div class='sidebar' role='navigation'>
        <div class='navbar-collapse'>
            <jsp:include page="../main/nav.jsp"></jsp:include>
            <jsp:include page="../main/header.jsp"></jsp:include>
            <!-- main content start-->
            <div id="page-wrapper" style="min-height: 453px;">
                <div class="main-page">
                    <div id="content">
                        <div class="forms">
                            <div class="widget-shadow " data-example-id="basic-forms">
                                <%--搜索条件开始--%>
                                <div class="form-body">
                                    <form class="form-horizontal" action="../news/getNewsList">
                                        <div class="form-group  col-lg-4">
                                            <label for="newsTitle" class="col-sm-3 control-label">新闻标题</label>
                                            <div class="col-sm-9">
                                                <input type="text" class="form-control" placeholder=""
                                                       id="newsTitle" name="newsTitle" value="${newsDto.newsTitle}">
                                            </div>
                                        </div>
                                        <button type="submit" class="btn btn-primary" for="propertySearch">搜索</button>
                                        <%--<button type="button" class="btn btn-primary" onclick="openAddModel()">添加新闻--%>
                                        <%--</button>--%>
                                        <a href="../news/toAddOrUpdate" class="btn btn-primary" style="color:#fff">发布新闻</a>
                                    </form>
                                </div>
                                <%--搜索条件结束--%>
                            </div>
                        </div>
                        <div class="table-responsive bs-example widget-shadow" style="border-top: 1px dashed #ccc;
    padding-top: 16px;">

                            <table width="100%" class="tableStyle" style="table-layout: fixed;">
                                <thead>
                                <tr>
                                    <th width="3%">序号</th>
                                    <th width="8%">新闻标题</th>
                                    <th width="8%">新闻来源</th>
                                    <th width="8%">新闻图片</th>
                                    <th width="7%">发布时间</th>
                                    <th width="7%">发布人</th>
                                    <th width="5%">操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${newsList}" var="news" varStatus="status">
                                    <tr>
                                        <td height="40px" style="text-align: center">
                                            <b>${(webPage.pageIndex-1)*20+status.index+1}</b>
                                        </td>
                                        <td height="40px" class="ellipsis message-title" title="${news.newsTitle}">
                                                ${news.newsTitle}
                                        </td>
                                        <td height="40px" class="ellipsis message-title"
                                            title="${news.newsSource}">
                                                ${news.newsSource}
                                        </td>
                                        <td height="40px" class="ellipsis message-title">
                                            <img style="width: 100%;" class="img-rounded" src="${news.newsImgUrl}">
                                        </td>
                                        <td height="40px" class="ellipsis message-title"
                                            title="${news.createBy}">
                                                ${news.createBy}
                                        </td>
                                        <td height="40px" class="ellipsis message-title"
                                            title="${news.createDate}">
                                                ${news.createDate}
                                        </td>
                                        <td height="40px">
                                            <a href="../news/toAddOrUpdate?newsId=${news.newsId}" class="a3"><span class="span1">编辑</span></a>
                                            <a href="../news/toDeleteNews?newsId=${news.newsId}" class="a3"><span class="span1">删除</span></a>
                                            <a href="javascript:void(0);" onclick="toTop('${news.newsId}','${news.slideShow}')" id="toTop"  class="a3">
                                                <c:if test="${news.slideShow eq '0'}">置顶</c:if>
                                                <c:if test="${news.slideShow eq '1'}">取消置顶</c:if>
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                            <m:pager pageIndex="${webPage.pageIndex}"
                                     pageSize="${webPage.pageSize}"
                                     recordCount="${webPage.recordCount}"
                                     submitUrl="${pageContext.request.contextPath }/news/getNewsList?pageIndex={0}"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="../static/js/bootstrap/bootstrap-datetimepicker.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="../static/js/bootstrap/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>

<script>
    $('.form_datetime').datetimepicker({
        language: 'zh-CN',
        weekStart: 1,
        todayBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        forceParse: 0,
        showMeridian: 1
    });
    $('.form_date').datetimepicker({
        language: 'zh-CN',
        weekStart: 1,
        todayBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0
    });
    $('.form_time').datetimepicker({
        language: 'zh-CN',
        weekStart: 1,
        todayBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 1,
        minView: 0,
        maxView: 1,
        forceParse: 0
    });
    //置顶
    function toTop(id, slideShow) {
        if (slideShow == '0') {
            if (confirm("最多只能置顶4条新闻，确定要置顶此条新闻么？")) {
                $.ajax({
                    type: "GET",
                    url: "../news/toTopNews?newsId=" + id + "&slideShow=" + slideShow,
                    cache: false,
                    async: false,
                    dataType: "json",
                    success: function (data) {
                        if (data.error == 0) {
                            alert("置顶成功！");
                        } else {
                            alert("置顶失败！最多只能置顶4条新闻");
                        }
                    }
                });
                window.location.href = "../news/getNewsList";
            } else {
                alert("已取消");
            }
        } else if (slideShow == '1') {
            if (confirm("确定要取消置顶此条新闻么？")) {
                $.ajax({
                    type: "GET",
                    url: "../news/toTopNews?newsId=" + id + "&slideShow=" + slideShow,
                    cache: false,
                    async: false,
                    dataType: "json",
                    success: function () {
                        alert("操作成功！");
                    }
                });
                window.location.href = "../news/getNewsList";
            }
        }
    }
</script>
<!-- main content end-->
<%@ include file="../main/foolter.jsp" %>

</body>
</html>