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

<div id="product-details" class="container">
    <div class="row">
        <div class="col-sm-2 col-md-2 well container-menu">
            <h3>Danh mục</h3>
            <ul class="my-menu">
                <c:forEach var="productLine" items="${productLineList}">
                    <li><a href="<c:url value="/san-pham/${productLine.getProduct_line_id()}"/>">${productLine.getName()} </a></li>
                </c:forEach>
            </ul>
        </div>

        <div class="col-sm-9 col-md-9">
            <div class="row well" style="margin-top: 20px;">
                <div class="col-sm-4 col-md-4">
                    <img id="image" data-product-image="${product.getImage()}" src="<c:url value="/resources/image/products/${product.getImage()}" />"/><br/>
                </div>
                <div class="col-sm-8 col-md-8">
                    <h3 id="product_name" data-product-name="${product.getName()}">${product.getName()}</h3>
                    <h4 class="price" id="product_price" data-product-price="${product.getPrice()}">
                        <fmt:formatNumber type="number" pattern="###,###" value="${product.getPrice()}"/> đ
                    </h4>
                    <table class="table">
                        <thead>
                        <td><h5>Màu sản phẩm</h5></td>
                        <td><h5>Size</h5></td>
                        <td><h5>Số lượng</h5></td>
                        </thead>
                        <tbody>
                        <c:forEach var="productDetails" items="${product.getProductDetailsList()}">
                            <tr class="product" data-product-id="${product.getProduct_id()}">
                                <td class="color"
                                    data-color-id="${productDetails.getProductColor().getProduct_color_id()}">${productDetails.getProductColor().getName()}</td>
                                <td class="size"
                                    data-size-id="${productDetails.getProductSize().getProduct_size_id()}">${productDetails.getProductSize().getSize()}</td>
                                <td class="quantity"
                                    data-quantity="${productDetails.getQuantity()}">${productDetails.getQuantity()}</td>
                                <td>
                                    <buton data-product-details-id="${productDetails.getProduct_details_id()}" class="btn btn-success btn-shopping-cart">Thêm vào giỏ</buton>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <%--<div class="col-sm-2 col-md-2">
            <h3>Đặc điểm sản phẩm</h3>
            <span>${product.getDescriptions()}</span>
        </div>--%>
    </div>
</div>

<div id="footer" class="container-fluid">
    <jsp:include page="../../common/web/footer.jsp"/>
</div>

<jsp:include page="../../taglib/web/footer.jsp"/>
</body>
</html>
