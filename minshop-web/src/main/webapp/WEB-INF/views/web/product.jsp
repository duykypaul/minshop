<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="../../taglib/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Min Shop</title>
    <link rel="shortcut icon" href="<c:url value="/resources/image/logo.jpg" />">
    <jsp:include page="../../taglib/web/header.jsp"/>
</head>
<body>
<div id="header-details" class="container-fluid">
    <jsp:include page="../../common/web/nav.jsp"/>
</div>
<div id="title-product" class="container">
    <c:if test="${productList.size() > 0}">
        <span>${productList.get(0).getProductLine().getName()}</span>
        <jsp:include page="../../common/web/list-product.jsp"/>
    </c:if>
    <c:if test="${productList.size() == 0}">
        <div style="margin-bottom: 115px;">Không có sản phẩm nào</div>
    </c:if>
</div>
</div>

<div id="footer" class="container-fluid">
    <jsp:include page="../../common/web/footer.jsp"/>
</div>

<jsp:include page="../../taglib/web/footer.jsp"/>
</body>
</html>
