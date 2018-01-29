<%--
  Created by IntelliJ IDEA.
  User: Jiazefeng
  Date: 2017/10/19
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<nav class="cbp-spmenu cbp-spmenu-vertical cbp-spmenu-left">
    <ul class="nav" id="menu">
        <li>
            <a href="#">
                <i class="fa fa-star-o nav_icon"></i>系统管理<span class="fa arrow"></span>
            </a>
            <ul class="nav nav-second-level collapse">
                <li><a href="../menu/menuManage.html">菜单管理</a></li>
                <li><a href="../user/getUserInfo">用户管理</a></li>
                <li><a href="../authority/getRoleList">权限管理</a></li>
            </ul>
        </li>
        <li><a href="#"><i class="fa fa-star-o nav_icon"></i>大棚管理<span class="fa arrow"></span></a>
            <ul class="nav nav-second-level collapse">
                <li><a href="../greenhouse/getGreenhouseList">大棚管理</a></li>
                <li><a href="../production/getProductionList">产量管理</a></li>
            </ul>
        </li>
        <li>
            <a href="#"><i class="fa fa-star-o nav_icon"></i>设备管理<span class="fa arrow"></span></a>
            <ul class="nav nav-second-level collapse">
                <li><a href="../equipment/getEquipmentList">设备管理</a></li>
            </ul>
        </li>

        <li>
            <a href="#">
                <i class="fa fa-star-o nav_icon"></i>环境因子管理<span class="fa arrow"></span></a>
            <ul class="nav nav-second-level collapse">
                <li><a href="../environment/getEnvironmentList">环境因子管理</a></li>
                <%--<li><a href="../user/getUserInfo">用户管理</a></li>--%>
                <%--<li><a href="#">权限管理</a></li>--%>
            </ul>
        </li>
        <li>
            <a href="#"><i class="fa fa-star-o nav_icon"></i>数据分析<span class="fa arrow"></span>
            </a>
            <ul class="nav nav-second-level collapse">
                <li><a href="../dataAnalysis/getDataIndex">数据分析</a></li>
            </ul>
        </li>
        <li>
            <a href="#"><i class="fa fa-star-o nav_icon"></i>新闻管理<span class="fa arrow"></span>
            </a>
            <ul class="nav nav-second-level collapse">
                <li><a href="../news/getNewsList">新闻管理</a></li>
            </ul>
        </li>
    </ul>
</nav>
