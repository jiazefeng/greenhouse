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

    <%-- ueditor --%>
    <link href="/static/editer/themes/default/css/ueditor.css" rel="stylesheet" type="text/css" media="all">
    <script type="text/javascript" charset="utf-8" src=/static/editer/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="/static/editer/ueditor.all.min.js"></script>
    <script type="text/javascript" charset="utf-8" src="/static/editer/lang/zh-cn/zh-cn.js"></script>
</head>

<body class="cbp-spmenu-push">
<div class="main-content">
    <div class='sidebar' role='navigation'>
        <div class='navbar-collapse'>
            <jsp:include page="../main/nav.jsp"></jsp:include>
            <jsp:include page="../main/header.jsp"></jsp:include>
            <div id="page-wrapper" style="min-height: 453px;">
                <div class="main-page">
                    <div id="content">
                        <form class="form-horizontal" name="form" id="fromAdd"
                              action="../news/addOrUpdateNews"
                              enctype="multipart/form-data" method="post">
                            <input type="hidden" id="newsId" name="newsId" value="${newsDTO.newsId}">

                            <div class="modal-body">

                                <div class="form-group  col-lg-12">
                                    <label class="col-sm-2 control-label">新闻标题</label>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control" id="newTitle" name="newsTitle" value="${newsDTO.newsTitle}">
                                    </div>
                                </div>
                                <div class="form-group  col-lg-12">
                                    <label class="col-sm-2 control-label">新闻来源</label>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control" id="newsSource" name="newsSource" value="${newsDTO.newsSource}">
                                    </div>
                                </div>
                                <div class="form-group  col-lg-12">
                                    <label class="col-sm-2 control-label">新闻发布人</label>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control" id="createBy" name="createBy" value="${newsDTO.createBy}">
                                    </div>
                                </div>
                                <div class="form-group  col-lg-12">
                                    <label class="col-sm-2 control-label">首图</label>
                                    <div class="col-sm-6">
                                        <input class="uploadfile" type="file" capture="camera" name="gUrlFile"
                                               id="gUrlFile"
                                               style="display:inline"/>
                                    </div>
                                </div>
                                <div class="form-group  col-lg-12">
                                    <label class="col-sm-2 control-label"></label>
                                    <div class="col-sm-6">
                                        <ul id="report"></ul>
                                    </div>
                                </div>
                                <div class="form-group  col-lg-12">
                                    <label class="col-sm-2 control-label">新闻详情</label>
                                    <div class="col-sm-6">
                                        <script id="editor" type="text/plain"></script>
                                        <input type="hidden" id="newsContent" name="newsContent"/>
                                    </div>
                                </div>
                                <div class="text-center form-group  col-lg-12">
                                    <button type="button" class="btn btn-primary" onclick="toSave()">发布</button>
                                    <button type="button" class="btn btn-primary" onclick="javascript:history.go(-1);">
                                        取消
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="../static/js/bootstrap/bootstrap-datetimepicker.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="../static/js/bootstrap/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
<script src="../static/js/img/lrz.pc.min.js"></script>
<script src="../static/js/img/exif.js"></script>
<script src="../static/js/img/lrz.js"></script>
<script src="../static/js/img/index.js"></script>
<script type="text/javascript">
    //页面加载时执行
    $(function () {
        if(${newsDTO.newsImgUrl != null}){
            img_report(${newsDTO.newsImgUrl});
        }
    });
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
<script type="text/javascript">
    //实例化编辑器
    var newsContent = '${newsDTO.newsContent}';
    var ue = UE.getEditor('editor', {
        toolbars: [[
            'source', '|', , 'undo', 'redo', '|',
            'bold', 'forecolor', 'removeformat', 'autotypeset', 'pasteplain', '|', '|',
            'justifyleft', 'justifycenter', '|',
            'link', 'unlink', '|',
            'simpleupload', 'insertimage', '|',
            'wordimage', '|',
            'inserttable', 'insertrow', 'deleterow', 'insertcol', 'deletecol', 'mergecells', 'splittocells', '|', 'mybtn1', 'mydialog1', 'scrawl'
        ]],
        autoHeightEnabled: false,
        autoFloatEnabled: true,
        zIndex: 99,
        initialFrameWidth: 1000,
        initialFrameHeight: 500,
        initialContent: newsContent
    });
    function isFocus(e) {
        alert(UE.getEditor('editor').isFocus());
        UE.dom.domUtils.preventDefault(e)
    }
    function setblur(e) {
        UE.getEditor('editor').blur();
        UE.dom.domUtils.preventDefault(e)
    }
    function insertHtml() {
        var value = prompt('插入html代码', '');
        UE.getEditor('editor').execCommand('insertHtml', value)
    }
    function createEditor() {
        enableBtn();
        UE.getEditor('editor');
    }
    function getAllHtml() {
        alert(UE.getEditor('editor').getAllHtml())
    }
    function getPlainTxt() {
        var arr = [];
        arr.push("使用editor.getPlainTxt()方法可以获得编辑器的带格式的纯文本内容");
        arr.push("内容为：");
        arr.push(UE.getEditor('editor').getPlainTxt());
        alert(arr.join('\n'))
    }
    function setContent(isAppendTo) {
        var arr = [];
        <%--arr.push("${merDesc}123");--%>
        UE.getEditor('editor').setContent('${merDesc}', isAppendTo);
        alert(arr.join("\n"));
    }
    function setDisabled() {
        UE.getEditor('editor').setDisabled('fullscreen');
        disableBtn("enable");
    }
    function setEnabled() {
        UE.getEditor('editor').setEnabled();
        enableBtn();
    }
    function getText() {
        //当你点击按钮时编辑区域已经失去了焦点，如果直接用getText将不会得到内容，所以要在选回来，然后取得内容
        var range = UE.getEditor('editor').selection.getRange();
        range.select();
        var txt = UE.getEditor('editor').selection.getText();
        alert(txt)
    }
    function getContentTxt() {
        var arr = [];
        arr.push("使用editor.getContentTxt()方法可以获得编辑器的纯文本内容");
        arr.push("编辑器的纯文本内容为：");
        arr.push(UE.getEditor('editor').getContentTxt());
        alert(arr.join("\n"));
    }
    function hasContent() {
        var arr = [];
        arr.push("使用editor.hasContents()方法判断编辑器里是否有内容");
        arr.push("判断结果为：");
        arr.push(UE.getEditor('editor').hasContents());
        alert(arr.join("\n"));
    }
    function setFocus() {
        UE.getEditor('editor').focus();
    }
    function deleteEditor() {
        disableBtn();
        UE.getEditor('editor').destroy();
    }
    function getContent() {
        var arr = [];
        arr.push("使用editor.getContent()方法可以获得编辑器的内容");
        arr.push("内容为：");
        arr.push(UE.getEditor('editor').getContent());
        alert(arr.join("\n"));
    }
    function disableBtn(str) {
        var div = document.getElementById('btns');
        var btns = UE.dom.domUtils.getElementsByTagName(div, "button");
        for (var i = 0, btn; btn = btns[i++];) {
            if (btn.id == str) {
                UE.dom.domUtils.removeAttributes(btn, ["disabled"]);
            } else {
                btn.setAttribute("disabled", "true");
            }
        }
    }
    function enableBtn() {
        var div = document.getElementById('btns');
        var btns = UE.dom.domUtils.getElementsByTagName(div, "button");
        for (var i = 0, btn; btn = btns[i++];) {
            UE.dom.domUtils.removeAttributes(btn, ["disabled"]);
        }
    }
    function getLocalData() {
        alert(UE.getEditor('editor').execCommand("getlocaldata"));
    }
    function clearLocalData() {
        UE.getEditor('editor').execCommand("clearlocaldata");
        alert("已清空草稿箱")
    }
    UE.Editor.prototype._bkGetActionUrl = UE.Editor.prototype.getActionUrl;
    UE.Editor.prototype.getActionUrl = function (action) {
        if (action == 'uploadimage' || action == 'uploadscrawl' || action == 'uploadimage') {
            return '${baseUrl}../news/uploadImage.html?action=uploadimage';
        } else if (action == 'uploadvideo') {
            return '${baseUrl}../news/uploadImage.html?action=uploadimage';
        } else {
            return this._bkGetActionUrl.call(this, action);
        }
    }

    //发布
    function toSave() {
        if ($("#newTitle").val().replace(/(^s*)|(s*$)/g, "").length == 0) {
            alert("请输入新闻标题！");
            return;
        }
        var content = UE.getEditor('editor').getContent();
        $("#newsContent").val(content);
        $("#fromAdd").submit();
    }
</script>
<!-- main content end-->
<%@ include file="../main/foolter.jsp" %>
</body>
</html>