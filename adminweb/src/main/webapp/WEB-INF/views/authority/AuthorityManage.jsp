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
                                    <form class="form-horizontal" action="../authority/getRoleList">
                                        <div class="form-group  col-lg-4">
                                            <label for="rName" class="col-sm-3 control-label">角色名称</label>
                                            <div class="col-sm-9">
                                                <input type="text" class="form-control" placeholder=""
                                                       id="rName" name="roleName">
                                            </div>
                                        </div>
                                        <button type="submit" class="btn btn-primary" for="propertySearch">搜索</button>
                                        <button type="button" class="btn btn-primary" onclick="openAddModel()">添加角色
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
                                    <th width="8%">角色名称</th>
                                    <th width="8%">创建时间</th>
                                    <th width="5%">操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${roleList}" var="role" varStatus="status">
                                    <tr>
                                        <td height="40px" style="text-align: center">
                                            <b>${(webPage.pageIndex-1)*20+status.index+1}</b>
                                        </td>
                                        <td height="40px" class="ellipsis message-title"
                                            title="${role.roleName}">
                                                ${role.roleName}
                                        </td>
                                        <td height="40px" class="ellipsis message-title"
                                            title="${role.createDate}">
                                                ${role.createDate}
                                        </td>

                                        <td height="40px">
                                            <a href="../authority/gotoSetRole?roleId=${role.roleId}" class="a3"><span
                                                    class="span1">设置</span></a>
                                            <a href="../equipment/deleteEquipment?eId=${role.roleId}"
                                               class="a3"><span
                                                    class="span1">删除</span></a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                            <m:pager pageIndex="${webPage.pageIndex}"
                                     pageSize="${webPage.pageSize}"
                                     recordCount="${webPage.recordCount}"
                                     submitUrl="${pageContext.request.contextPath }/equipment/getEquipmentList?pageIndex={0}"/>
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
        <form class="modal-content" name="form" id="form" action="../authority/addRoleInfo">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span
                        class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel2"></h4>
            </div>
            <div class="modal-body">

                <div class="form-group  col-lg-12">
                    <label class="col-sm-2 control-label">设备名称</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="roleName" name="roleName">
                    </div>
                </div>
                <div class="form-group  col-lg-12">
                    <label class="col-sm-2 control-label">设备描述</label>
                    <div class="col-sm-6">
                        <textarea type="text" class="form-control" id="roleDes" name="roleDes"></textarea>
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
</script>
<!-- main content end-->
<%@ include file="../main/foolter.jsp" %>
<script type="application/javascript">
    function addOrUpdateUser() {
        var roleName = $("#roleName").val();
        if (roleName == null || roleName == "" || roleName == undefined) {
            alert("角色名称为空");
            return false;
        }
    }

    function openAddModel() {
        $("#myModalLabel2").html("新增角色信息");
        $("#myModal").modal({
            backdrop: false,
            show: true
        });
    }
    function openUpdateModal(eId) {
        $.ajax({
            url: "../equipment/getEquipmentById?eId=" + eId,
            type: "get",
            async: false,
            dataType: "json",
            success: function (result) {
                console.log(result);
                <!-- 获取返回代码 -->
                if (result.data != null) {
                    var equipment = result.data;
                    $("#eId").val(equipment.eId);
                    $("#eName").val(equipment.eName);
                    $("#eNumber").val(equipment.eNumber);
                    $("#eLocation").val(equipment.eLocation);
                    $("#eTimeBuying").val(equipment.eTimeBuying);
                    $("#eDescribe").val(equipment.eDescribe);
                    if (equipment.eState == '1') {
                        $("#eState1").attr("checked", "checked");
                    } else if (equipment.eState == '2') {
                        $("#eState2").attr("checked", "checked");
                    } else {
                        $("#eState3").attr("checked", "checked");
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
</body>
</html>