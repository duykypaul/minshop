<%@page import="java.util.List"%>
<%@page import="com.duykypaul.entity.NhanVien"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<jsp:include page="header.jsp" />
</head>
<body>
	<div id="header" class="container-fluid">
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
					<a class="navbar-brand" href="#"><img src="<c:url value="/resources/image/minshop.png" />"/></a>
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
						<li ><a href="#">DỊCH VỤ</a></li>
						<li ><a href="#">LIÊN HỆ</a></li>
					</ul>
					
					<ul class="nav navbar-nav navbar-right">
						<li><a href="#">ĐĂNG KÝ</a></li>
						<li><a href="#">ĐĂNG NHẬP</a></li>
						<li><a href="#"><img src="<c:url value="/resources/image/cart-73-16.png" />"/></a></li>
					</ul>
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>
		<div class="event_header container">
			<span>Ngày 17/10 - 23/10/2019</span><br/>
			<span style="font-size: 50px;">MUA 1 TẶNG 1</span><br/>
			<button class="btn-info">XEM NGAY</button>
		</div>
	</div>
	<div id="info" class="container">
		<div class="row">
			<div class="col-12 col-sm-4 col-md-4 ">
				<img src="<c:url value="/resources/image/quality_1716012.png" />" /><br/>
				<span style="font-size: 32px; font-weight: 500;">CHẤT LƯỢNG</span><br/>
				<span>Chúng tôi cam kết sẽ đem lại cho bạn chất lượng sản phẩm tốt nhất</span>
			</div>
			<div class="col-12 col-sm-4 col-md-4 ">
				<img src="<c:url value="/resources/image/Saving_2738589.png" />" /><br/>
				<span style="font-size: 32px; font-weight: 500;">TIẾT KIỆM CHI PHÍ</span><br/>
				<span>Cam kết giá rẻ nhất Việt Nam giúp các bạn tiết kiệm hơn 20% cho từng sản phẩm</span>
			</div>
			<div class="col-12 col-sm-4 col-md-4">
				<img src="<c:url value="/resources/image/delivery-truck-in-movement.png" />" /><br/>
				<span style="font-size: 32px; font-weight: 500;">GIAO HÀNG</span><br/>
				<span>Cam kết giao hàng tận nơi trong ngày để mang sản phẩm đến cho khách hàng nhanh nhất</span>
			</div>
		</div>
	</div>
	<div></div>

	<jsp:include page="footer.jsp" />
</body>
</html>