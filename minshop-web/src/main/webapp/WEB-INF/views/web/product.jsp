<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="../taglib/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Min Shop</title>
    <link rel="shortcut icon" href="<c:url value="/resources/image/logo.jpg" />">
    <jsp:include page="../taglib/web/header.jsp"/>
</head>
<body>
<div id="header-details" class="container-fluid">
    <jsp:include page="../common/web/nav.jsp"/>
</div>
<div id="title-product" class="container">
    <span>${productList.get(0).getProductLine().getName()}</span>
    <jsp:include page="../common/web/list-product.jsp"/>
</div>
</div>

<div id="footer" class="container-fluid">
    <jsp:include page="../common/web/footer.jsp"/>
</div>

<jsp:include page="../taglib/web/footer.jsp"/>
</body>
</html>