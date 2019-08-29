<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <nav class="navbar navbar-default none-nav">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed"
                        data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
                        aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span> <span
                        class="icon-bar"></span> <span class="icon-bar"></span> <span
                        class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#"><img
                        src="<c:url value="/resources/image/minshop.png" />"/></a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse"
                 id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav nav-center">
                    <li class="active"><a href="#">TRANG CHỦ</a></li>
                    <li class="dropdown"><a href="#" class="dropdown-toggle"
                                            data-toggle="dropdown" role="button" aria-haspopup="true"
                                            aria-expanded="false">SẢN PHẨM <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Action</a></li>
                            <li><a href="#">Another action</a></li>
                            <li><a href="#">Something else here</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#">Separated link</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#">One more separated link</a></li>
                        </ul>
                    </li>
                    <li><a href="#">DỊCH VỤ</a></li>
                    <li><a href="#">LIÊN HỆ</a></li>
                </ul>

                <ul class="nav navbar-nav navbar-right">
                    <c:choose>
                        <c:when test="${email != null}">
                            <li><a href="#"
                                   class="circle-avatar"><span>${email.substring(0, 1).toUpperCase()}</span></a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="dangnhap/">ĐĂNG NHẬP</a></li>
                        </c:otherwise>
                    </c:choose>

                    <li><a href="#"><img
                            src="<c:url value="/resources/image/cart-73-16.png" />"/></a></li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>
</div>

<div class="container">
	<div class="row">
		<div class="col-sm-2 col-md-2">
			<h3>Danh mục sản phẩm</h3>
			<ul>
				<li>Áo Thun</li>
				<li>Áo Khoác</li>
				<li>Áo Sơ-mi</li>
				<li>Quần Dài</li>
				<li>Quần Short</li>
				<li>Giày</li>
				<li>Sandal-Dép</li>
				<li>Balo</li>
			</ul>
		</div>

		<div class="col-sm-8 col-md-8">
			<div class="row">
				<div class="col-sm-3 col-md-3">
					<img src="<c:url value="/resources/image/products/${product.getImage()}" />" /><br />
				</div>
				<div class="col-sm-9 col-md-9">
					<h3>${product.getName()}</h3>
					<h4>${product.getPrice()}</h4>
					<table>
						<tbody>
							<c:forEach var="productDetails" items="${product.getProductDetailsList()}">
								<tr>
									<td>${productDetails.getProductColor().getName()}</td>
									<td>${productDetails.getProductSize().getSize()}</td>
									<td>${productDetails.getQuantity()}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>

		<div class="col-sm-2 col-md-2">
			<h3>Đặc điểm sản phẩm</h3>
			<span>${product.getDescriptions()}</span>
		</div>
	</div>
</div>

<div id="footer" class="container-fluid">
    <jsp:include page="common/footer.jsp"/>
</div>

<jsp:include page="taglib/footer.jsp"/>
</body>
</html>