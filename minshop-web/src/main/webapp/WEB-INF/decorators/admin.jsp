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
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Admin MinShop</title>
    <link rel="shortcut icon" href="<c:url value="/resources/image/logo.jpg" />">
    <!-- Bootstrap Core CSS -->
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />">
    <!-- MetisMenu CSS -->
    <link href="<c:url value="/resources/css/metisMenu.min.css" />" rel='stylesheet' type='text/css' />

    <!-- Timeline CSS -->
    <link href="<c:url value="/resources/css/timeline.css" />" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="<c:url value="/resources/css/startmin.css" />" rel="stylesheet">
    <!-- Morris Charts CSS -->
    <link rel="stylesheet" href="<c:url value="/resources/css/morris.css" />" type="text/css"/>
    <!-- Custom Fonts -->
    <link rel="stylesheet" href="<c:url value="/resources/css/font-awesome.min.css" />" type='text/css' />

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]-->
    <!--<script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.2/respond.min.js"></script>-->
    <!--[endif]-->
    <dec:head />

</head>
<body id="wrapper">
    <!-- Navigation -->
    <%@ include file="../common/admin/header.jsp"%>

    <dec:body/>

    <!-- jQuery -->
    <script src="<c:url value="/resources/js/jquery-3.4.1.min.js" />"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    <!-- Metis Menu Plugin JavaScript -->
    <script src="<c:url value="/resources/js/metisMenu.min.js" />"></script>
    <!-- Morris Charts JavaScript -->
    <script src="<c:url value="/resources/js/raphael.min.js" />"></script>
    <script src="<c:url value="/resources/js/morris.min.js" />"></script>
    <script src="<c:url value="/resources/js/morris-data.js" />"></script>
    <!-- Custom Theme JavaScript -->
    <script src="<c:url value="/resources/js/startmin.js" />"></script>
</body>
</html>
