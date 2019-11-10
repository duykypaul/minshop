<%--
  Created by IntelliJ IDEA.
  User: DuyKyPaul
  Date: 9/18/2019
  Time: 11:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../taglib/taglib.jsp"%>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta charset="utf-8" />
    <title>Admin MinShop</title>
    <link rel="shortcut icon" href="<c:url value="/resources/image/logo.jpg" />">

    <meta name="description" content="overview &amp; stats" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

    <!-- bootstrap & fontawesome -->
    <link rel="stylesheet" href="<c:url value='/resources/assets/css/bootstrap.min.css'/>" />

    <link rel="stylesheet" href="<c:url value='/resources/assets/font-awesome/4.5.0/css/font-awesome.min.css'/>" />

    <!-- page specific plugin styles -->

    <!-- text fonts -->
    <link rel="stylesheet" href="<c:url value='/resources/assets/css/fonts.googleapis.com.css'/>" />

    <!-- ace styles -->
    <link rel="stylesheet" href="<c:url value='/resources/assets/css/ace.min.css'/>" class="ace-main-stylesheet" id="main-ace-style" />

    <link rel="stylesheet" href="<c:url value='/resources/assets/css/ace-skins.min.css'/>" />
    <link rel="stylesheet" href="<c:url value='/resources/assets/css/ace-rtl.min.css'/>" />
    <!-- ace settings handler -->
    <script src="<c:url value='/resources/assets/js/ace-extra.min.js'/>"></script>
    <%--custom css--%>
    <%--<link rel="stylesheet" href="<c:url value="/resources/styles/styles.css" />">--%>
    <dec:head />

</head>
<body class="no-skin">
    <!-- header -->
    <%@ include file="../common/admin/header.jsp"%>
    <div class="main-container ace-save-state" id="main-container">
        <script type="text/javascript">
            try{ace.settings.loadState('main-container')}catch(e){}
        </script>
        <%-- menu --%>
        <%@ include file="../common/admin/menu.jsp"%>
        <div class="main-content">
            <div class="main-content-inner">
                <!-- breadcrumb -->
                <%@ include file="../common/admin/breadcrumb.jsp"%>
                <div class="page-content">
                    <%--setting--%>
                    <%@ include file="../common/admin/setting.jsp"%>
                    <dec:body/>
                </div>
            </div>
        </div>
        <!-- footer -->
        <%@ include file="../common/admin/footer.jsp"%>
        <%--scroll-top--%>
        <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
            <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
        </a>
    </div>
    <!-- page specific plugin scripts -->
</body>
</html>
