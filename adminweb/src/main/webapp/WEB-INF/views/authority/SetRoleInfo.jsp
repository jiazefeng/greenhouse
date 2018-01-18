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
        .role_new_submit {
            border-bottom: 1px solid #999999;
        }

        .newRoleSubmit {
            float: right;
            margin-bottom: 20px;
        }

        .userStaffManage .save {
            height: 34px;
            margin-bottom: 0px;
        }

        .role_table_title {
            margin-left: 40%;
        }

        .role_table_roleName {
            width: 20%;
            text-align: center;
            font-size: 1.0rem;
            padding-bottom: 8px;
        }

        .role_table_fillCont {
            padding-bottom: 8px;
        }

        .roleNameText {
            border: none;
            width: 20rem;
            padding-bottom: 8px;
            padding-left: .5rem;
            /*border-bottom: 1px solid #666;*/
        }

        .role_form span {
            font-size: 1.35rem;
            line-height: 1rem;
        }

        .role_table_info td {
            background: #F2F2F2;
        }

        .role_table_info td:nth-child(1) {
            width: 25%;
            border-right: hidden;
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
                        <div class="container1 userStaffManage">
                            <form class="form-horizontal" name="addAppRoleSet" id="addAppRoleSet"
                                  action="../authority/addAuthority">
                                <div class="row">
                                    <div class="col-md-10 role_new_submit">
                                        <div class="newRoleSubmit">
                                            <button type="submit" class="btn btn-primary">保存</button>
                                            <a href="../authority/getRoleList" class="btn btn-primary">关闭</a>
                                        </div>
                                    </div>
                                </div>
                                <input type="hidden" name="roleId" value="${roleInfo.roleId}">

                                <div class="row">
                                    <div class="col-md-10 role_new_submit2">
                                        <table class="table table-bordered">
                                            <caption class="role_table_title">角色设置</caption>
                                            <tbody>
                                            <tr>
                                                <td class="role_table_roleName">角色名称</td>
                                                <td class="role_table_fillCont">
                                                    <input type="text" class="roleNameText" id="appRoleSetName"
                                                           name="roleName"
                                                           value="${roleInfo.roleName}">
                                                </td>
                                            </tr>


                                            <tr style="background-color: #F2F2F2">
                                                <td colspan="2">功能模块相关信息</td>
                                            </tr>
                                            <tr>
                                                <td class="role_table_roleName">设置权限</td>
                                                <td style="width: 100%">
                                                    <c:forEach var="item" items="${menuInfoList}">
                                                        <input type="checkbox"
                                                               value="${item.menuId}"
                                                               name="menuIds"
                                                                <c:forEach var="compar" items="${menuInfos}">
                                                                    <c:if test="${compar.menuId eq item.menuId}">checked="checked" </c:if>
                                                                </c:forEach> />
                                                        ${item.menuName}&nbsp;
                                                    </c:forEach>
                                                </td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </form>
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
</script>
<!-- main content end-->
<%@ include file="../main/foolter.jsp" %>

</body>
</html>