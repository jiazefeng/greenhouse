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
                                    <form class="form-horizontal" action="../production/getProductionList">
                                        <div class="form-group  col-lg-4">
                                            <label for="gId" class="col-sm-3 control-label">大棚</label>
                                            <div class="col-sm-9">
                                                <select class="form-control" placeholder="" id="gId"
                                                        name="greenhouseId">
                                                    <c:forEach items="${greenhouses}" var="item">
                                                        <option value="${item.key }"
                                                                <c:if test="${item.key eq productionDTO.greenhouseId}">selected</c:if>>${item.value }</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        <button type="submit" class="btn btn-primary" for="propertySearch">搜索</button>
                                        <button type="button" class="btn btn-primary" onclick="openAddModel()">添加
                                        </button>
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
                                    <th width="8%">大棚名称</th>
                                    <th width="8%">产量(kg)</th>
                                    <th width="7%">时间</th>
                                    <th width="5%">操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${productionList}" var="pro" varStatus="status">
                                    <tr>
                                        <td height="40px" style="text-align: center">
                                            <b>${(webPage.pageIndex-1)*20+status.index+1}</b>
                                        </td>
                                        <td height="40px" class="ellipsis message-title" title="${pro.greenhouseName}">
                                                ${pro.greenhouseName}
                                        </td>
                                        <td height="40px" class="ellipsis message-title"
                                            title="${pro.yield}">
                                                ${pro.yield}
                                        </td>
                                        <td height="40px" class="ellipsis message-title"
                                            title="${pro.createDate}">
                                                ${pro.createDate}
                                        </td>
                                        <td height="40px">
                                            <a href="javascript:void(0);" onclick="openUpdateModal('${pro.proId}')"
                                               class="a3"><span
                                                    class="span1">编辑</span></a>
                                            <a href="../production/delete?proId=${pro.proId}" class="a3"><span
                                                    class="span1">删除</span></a>
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


<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form class="modal-content" name="form" id="form" action="../production/addOrUpdate" method="post">
            <input type="hidden" name="proId" id="proId">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span
                        class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel2"></h4>
            </div>
            <div class="modal-body">
                <div class="form-group  col-lg-12">
                    <label for="greenhouseId" class="col-sm-2 control-label">大棚:</label>
                    <div class="col-sm-6">
                        <select class="form-control" placeholder="" id="greenhouseId"
                                name="greenhouseId">
                            <c:forEach items="${greenhouses}" var="item">
                                <option value="${item.key }">${item.value }</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group  col-lg-12">
                    <label class="col-sm-2 control-label">产量</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="yield" name="yield">
                    </div>
                </div>
                <div class="modal-footer" style="border: none">
                    <button type="submit" class="btn btn-primary" onclick="return addOrUpdateUser()">保存</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                </div>
            </div>
        </form>
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

    function openAddModel() {
        $("#myModalLabel2").html("新增");
        $("#myModal").modal({
            backdrop: false,
            show: true
        });
    }
    function openUpdateModal(proId) {
        $.ajax({
            url: "../production/toUpdate?proId=" + proId,
            type: "get",
            async: false,
            dataType: "json",
            success: function (result) {
                console.log(result);
                <!-- 获取返回代码 -->
                if (result.data != null) {
                    var pro = result.data;
                    $("#proId").val(pro.proId);
                    $("#yield").val(pro.yield);
                    if (pro.greenhouseId != "") {
                        var s = document.getElementById("greenhouseId"); //获取select对象
                        var ops = s.options;
                        for (var i = 0; i < ops.length; i++) {
                            var tempValue = ops[i].value;
                            if (tempValue == pro.greenhouseId) {
                                ops[i].selected = true;  //如果后台的值与下拉列表的某一个value相等，就设置此项为选中项
                                break;
                            }
                        }
                    }
                    $("#myModalLabel2").html("编辑设备信息");
                    $("#myModal").modal({
                        backdrop: false,
                        show: true
                    });
                }
            }
        });
    }
</script>
<!-- main content end-->
<%@ include file="../main/foolter.jsp" %>

</body>
</html>