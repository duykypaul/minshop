<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Min Shop</title>
    <link rel="shortcut icon" href="<c:url value="/resources/image/logo.jpg" />">
    <jsp:include page="taglib/header.jsp"/>
</head>
<body>
<div id="header-details" class="container-fluid">
    <jsp:include page="common/nav.jsp"/>
</div>

<div id="title-product" class="container">
    <div class="row">
        <c:forEach var="product" items="${productList}">
            <div class="col-md-3 col-sm-6">
                <a href="<c:url value="/chi-tiet/${product.getProduct_id()}"/> ">
                    <div class="product wow zoomIn">
                        <img src="<c:url value="/resources/image/products/${product.getImage()}" />"/><br/>
                        <span>${product.getName()}</span><br/>
                        <span class="price"><fmt:formatNumber type="number" pattern="###,###"
                                                              value="${product.getPrice()}"/> đ</span>
                    </div>
                </a>
            </div>
        </c:forEach>
    </div>

</div>
</div>

<div id="footer" class="container-fluid">
    <jsp:include page="common/footer.jsp"/>
</div>

<jsp:include page="taglib/footer.jsp"/>
</body>
</html>