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
                                    <form class="form-horizontal" action="../greenhouse/getGreenhouseList">
                                        <div class="form-group  col-lg-4">
                                            <label for="greenhoseName" class="col-sm-3 control-label">大棚名称</label>
                                            <div class="col-sm-9">
                                                <input type="text" class="form-control" placeholder=""
                                                       id="greenhoseName" name="gName" value="${greenhouse.gName}">
                                            </div>
                                        </div>
                                        <div class="form-group  col-lg-4">
                                            <label for="greenhoseNumber" class="col-sm-3 control-label">大棚编号</label>
                                            <div class="col-sm-9">
                                                <input type="text" class="form-control" placeholder=""
                                                       id="greenhoseNumber" name="gNumber"
                                                       value="${greenhouse.gNumber}">
                                            </div>
                                        </div>
                                        <button type="submit" class="btn btn-primary" for="propertySearch">搜索</button>
                                        <button type="button" class="btn btn-primary" onclick="openAddModel()">添加大棚
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
                                    <th width="8%">大棚编号</th>
                                    <th width="7%">大棚图片</th>
                                    <th width="7%">大棚种类</th>
                                    <th width="7%">占地面积</th>
                                    <th width="7%">种植种类</th>
                                    <th width="7%">大棚状态</th>
                                    <th width="7%">设备描述</th>
                                    <th width="7%">创建时间</th>
                                    <th width="5%">操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${greenhouseDtos}" var="greenhouseDto" varStatus="status">
                                    <tr>
                                        <td height="40px" style="text-align: center">
                                            <b>${(webPage.pageIndex-1)*20+status.index+1}</b>
                                        </td>
                                        <td height="40px" class="ellipsis message-title" title="${greenhouseDto.gName}">
                                                ${greenhouseDto.gName}
                                        </td>
                                        <td height="40px" class="ellipsis message-title"
                                            title="${greenhouseDto.gNumber}">
                                                ${greenhouseDto.gNumber}
                                        </td>
                                        <td height="40px" class="ellipsis message-title">
                                            <img style="width: 100%;" class="img-rounded" src="${greenhouseDto.gUrl}">
                                        </td>
                                        <td height="40px" class="ellipsis message-title"
                                            title="${greenhouseDto.gCategory}">
                                            <c:if test="${greenhouseDto.gCategory eq '1'}">普通大棚</c:if>
                                            <c:if test="${greenhouseDto.gCategory eq '2'}">温室大棚</c:if>
                                            <c:if test="${greenhouseDto.gCategory eq '3'}">智能大棚</c:if>
                                        </td>
                                        <td height="40px" class="ellipsis message-title"
                                            title="${greenhouseDto.areaCovered}">
                                                ${greenhouseDto.areaCovered}
                                        </td>
                                        <td height="40px" class="ellipsis message-title"
                                            title="${greenhouseDto.plantCategory}">
                                                ${greenhouseDto.plantCategory}
                                        </td>
                                        <td height="40px" class="ellipsis message-title" title="${greenhouseDto.state}">
                                            <c:if test="${greenhouseDto.state eq '1'}">正常</c:if>
                                            <c:if test="${greenhouseDto.state eq '2'}"></c:if>
                                            <c:if test="${greenhouseDto.state eq '3'}">闲置</c:if>
                                        </td>
                                        <td height="40px" class="ellipsis message-title"
                                            title="${greenhouseDto.gDescribe}">
                                                ${greenhouseDto.gDescribe}
                                        </td>
                                        <td height="40px" class="ellipsis message-title"
                                            title="${greenhouseDto.creatDate}">
                                                ${greenhouseDto.creatDate}
                                        </td>
                                        <td height="40px">
                                            <a href="javascript:openUpdateModal('${greenhouseDto.gId}')"
                                               class="a3"><span
                                                    class="span1">编辑</span></a>
                                            <a href="../greenhouse/deleteGreenhouseById?gId=${greenhouseDto.gId}"
                                               class="a3"><span
                                                    class="span1">删除</span></a>
                                            <a href="../greenhouse/getCheckDetailes?gId=${greenhouseDto.gId}"
                                               class="a3"><span
                                                    class="span1">查看</span></a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                            <m:pager pageIndex="${webPage.pageIndex}"
                                     pageSize="${webPage.pageSize}"
                                     recordCount="${webPage.recordCount}"
                                     submitUrl="${pageContext.request.contextPath }/greenhouse/getGreenhouseList?pageIndex={0}"/>
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
        <form class="modal-content" name="form" id="form" action="../greenhouse/addOrUpdateGreenhouse"
              enctype="multipart/form-data" method="post">
            <input type="hidden" name="gId" id="gId">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span
                        class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel2"></h4>
            </div>
            <div class="modal-body">

                <div class="form-group  col-lg-12">
                    <label class="col-sm-2 control-label">大棚名称</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="gName" name="gName">
                    </div>
                </div>
                <div class="form-group  col-lg-12">
                    <label class="col-sm-2 control-label">大棚编号</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="gNumber" name="gNumber">
                    </div>
                </div>
                <div class="form-group  col-lg-12">
                    <label class="col-sm-2 control-label">大棚种类</label>
                    <div class="col-sm-6">
                        <label class="btn btn-primary">
                            <input type="radio" name="gCategory" id="gCategory1" autocomplete="off" value="1">普通大棚
                        </label>
                        <label class="btn btn-primary">
                            <input type="radio" name="gCategory" id="gCategory2" autocomplete="off" value="2">温室大棚
                        </label>
                        <label class="btn btn-primary">
                            <input type="radio" name="gCategory" id="gCategory3" autocomplete="off" value="3">智能大棚
                        </label>
                    </div>
                </div>
                <div class="form-group  col-lg-12">
                    <label class="col-sm-2 control-label">种植种类</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="plantCategory" name="plantCategory">
                    </div>
                </div>
                <div class="form-group  col-lg-12">
                    <label class="col-sm-2 control-label">占地面积</label>
                    <div class="col-sm-4">
                        <input type="number" class="form-control" id="areaCovered" name="areaCovered">
                    </div>
                    <div class="col-sm-2">
                        <span style="font-size: 22px">㎡</span>
                    </div>
                </div>
                <div class="form-group  col-lg-12">
                    <label class="col-sm-2 control-label">上传大棚图片</label>
                    <div class="col-sm-6">
                        <input class="uploadfile" type="file" capture="camera" name="gUrlFile" id="gUrlFile"
                               style="display:inline"/>
                        <%--<input type="text" class="form-control" id="gUrl" name="gUrl">--%>
                    </div>
                </div>
                <div class="form-group  col-lg-12">
                    <label class="col-sm-2 control-label"></label>
                    <div class="col-sm-6">
                        <ul id="report"></ul>
                    </div>
                </div>
                <div class="form-group  col-lg-12">
                    <label class="col-sm-2 control-label">大棚描述</label>
                    <div class="col-sm-6">
                        <textarea type="text" class="form-control" id="gDescribe" name="gDescribe"></textarea>
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
<script src="../static/js/img/lrz.pc.min.js"></script>
<script src="../static/js/img/exif.js"></script>
<script src="../static/js/img/lrz.js"></script>
<script src="../static/js/img/index.js"></script>
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
</script>
<!-- main content end-->
<%@ include file="../main/foolter.jsp" %>
<script type="application/javascript">
    function addOrUpdateUser() {
        var gName = $("#gName").val();
        if (gName == null || gName == "" || gName == undefined) {
            alert("大棚名称为空");
            return false;
        }
        var gNumber = $("#gNumber").val();
        if (gNumber == null || gNumber == "" || gNumber == undefined) {
            alert("大棚编号为空");
            return false;
        }
        var plantCategory = $("#plantCategory").val();
        if (plantCategory == null || plantCategory == "" || plantCategory == undefined) {
            alert("种植种类为空");
            return false;
        }
        var areaCovered = $("#areaCovered").val();
        if (areaCovered == null || areaCovered == "" || areaCovered == undefined) {
            alert("占地面积为空");
            return false;
        }
        var gDescribe = $("#gDescribe").val();
        if (gDescribe == null || gDescribe == "" || gDescribe == undefined) {
            alert("大棚描述为空");
            return false;
        }
    }
    function init() {
        $("#gId").val();
        $("#gName").val();
        $("#gNumber").val();
        $("#plantCategory").val();
        $("#areaCovered").val();
        $("#gCategory1").attr("checked", "checked");
        $("#gDescribe").val();
        $("#gUrlFile").val();
    }
    function openAddModel() {
        init();
        $("#myModalLabel2").html("新增大棚信息");
        $("#myModal").modal({
            backdrop: false,
            show: true
        });
    }
    function openUpdateModal(gId) {
        $.ajax({
            url: "../greenhouse/getGreenhouseById?gId=" + gId,
            type: "get",
            async: false,
            dataType: "json",
            success: function (result) {
                console.log(result);
                <!-- 获取返回代码 -->
                if (result.data != null) {
                    var green = result.data;
                    $("#gId").val(green.gId);
                    $("#gName").val(green.gName);
                    $("#gNumber").val(green.gNumber);
                    $("#plantCategory").val(green.plantCategory);
                    $("#areaCovered").val(green.areaCovered);
                    $("#gDescribe").val(green.gDescribe);
                    if (green.gCategory == '1') {
                        $("#gCategory1").attr("checked", "checked");
                    } else if (green.gCategory == '2') {
                        $("#gCategory2").attr("checked", "checked");
                    } else {
                        $("#gCategory3").attr("checked", "checked");
                    }
                    img_report(green.gUrl);
                    $("#myModalLabel2").html("编辑大棚信息");
                    $("#myModal").modal({
                        backdrop: false,
                        show: true
                    });
                }
            }
        });
    }
    function img_report(src) {
        var img = new Image(),
            li = document.createElement('li');
        img.onload = function () {
            li.className = 'item-img';
            li.appendChild(img);
            document.getElementById("report").appendChild(li);
        };
        img.src = src;
    }
</script>
</body>
</html>