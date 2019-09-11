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

<div id="shopping-cart-detail" class="container">
    <div class="col-md-7 col-sm-12 well">
        <table class="table">
            <thead>
            <td><h5>Hình ảnh</h5></td>
            <td><h5>Sản phẩm</h5></td>
            <td><h5>Màu </h5></td>
            <td><h5>Size</h5></td>
            <td><h5>Số lượng</h5></td>
            <td><h5>Giá tiền</h5></td>
            </thead>
            <tbody>
            <c:forEach var="value" items="${shoppingCartList}">
                <tr class="product" data-product-id="${value.getProduct_id()}" data-product-details-id="${value.getProduct_details_id()}">
                    <td class="image line-product"
                        data-image="${value.getImage()}">
                        <img data-product-image="${product.getImage()}" style="width: 50px;" src="<c:url value="/resources/image/products/${value.getImage()}" />"/>
                    </td>
                    <td class="name line-product">${value.getProduct_name()}</td>

                    <td class="color line-product" data-color-id="${value.getProduct_color_id()}">${value.getColor_name()}</td>

                    <td class="size line-product" data-size-id="${value.getProduct_size_id()}">${value.getSize_name()}</td>

                    <td class="quantity line-product" data-quantity="${value.getQuantity()}">
                        <div><input type="number" min="1" class="quantity-shopping-cart" value="${value.getQuantity()}"/></div>
                    </td>
                    <td class="price line-product" data-price="${value.getPrice()}">
                        <fmt:formatNumber type="number" pattern="###,###" value="${value.getPrice()}"/> đ
                    </td>
                    <td class="line-product"><button class="btn-link remove-product">X</button></td>
                </tr>
            </c:forEach>
            </tbody>
            <tfoot>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td><h4>Thiệt hại:</h4></td>
                    <td><h4><span id="total-cost" class="price" type="font-family: cursive;"></span></h4></td>
                </tr>
            </tfoot>
        </table>
    </div>
    <div class="col-md-5 col-sm-12">
        <h3>Thông tin người mua/nhận hàng</h3>
        <form action="" method="post">
            <div class="form-group">
                <label for="customer_name">Tên</label>
                <input type="text" class="form-control" id="customer_name" name="customer_name" placeholder="Tên người nhận">
            </div>
            <div class="form-group">
                <label for="phone-number">Điện thoại liên lạc</label>
                <input type="number" class="form-control" id="phone-number" name="phone_number" placeholder="Số điện thoại">
            </div>
            <div class="radio">
                <label><input type="radio" name="form_of_delivery" checked value="Nhận hàng tại nhà/công ty/bưu điện">Nhận hàng tại nhà/công ty/bưu điện</label>
            </div>
            <div class="radio">
                <label><input type="radio" name="form_of_delivery" value="Nhận hàng tại cửa hàng MinShop">Nhận hàng tại cửa hàng MinShop</label>
            </div>
            <div class="form-group">
                <input id="delivery-address" type="text" class="form-control" name="delivery_address" placeholder="Địa chỉ nhận hàng"/>
            </div>
            <div class="form-group">
                <label for="comment">Ghi chú</label>
                <textarea class="form-control" rows="3" id="comment" name="comment"></textarea>
            </div>
            <input id="ordered" type="submit" class="btn btn-primary" value="ĐẶT HÀNG">
        </form>
    </div>
</div>

<div id="footer" class="container-fluid">
    <jsp:include page="common/footer.jsp"/>
</div>

<jsp:include page="taglib/footer.jsp"/>
</body>
</html>