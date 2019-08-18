<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Đăng nhập</title>
<jsp:include page="taglib/header.jsp"/>
</head>
<body id="body-login">
	<div id="body-flex-login">
		<div id="container-login">
			<div id="container-login-left">
				<div id="header-left" class="header-login">
					<span id="text-logo" >Welcome</span><br/>
					<span id="hint-text-logo" style="font-size:12px;">Hãy tạo nên phong cách của bạn cùng MinShop!</span>
				</div>
				<div id="footer-left">
					<p><img alt="icon_oval" src="<c:url value="/resources/image/icon_oval.png" />"/><span>Luôn cập nhật xu hướng thời trang mới nhất</span></p>
					<p><img alt="icon_oval" src="<c:url value="/resources/image/icon_oval.png" />"/><span>Giảm hơn 50% tất cả các mặt hàng Giành cho khách VIP</span></p>
					<p><img alt="icon_oval" src="<c:url value="/resources/image/icon_oval.png" />"/><span>Tận tình tư vấn để tạo nên phong cách của bạn</span></p>
				</div>
			</div>
			<div id="container-login-right">
				<div id="header-right" class="header-login">
					<span class="actived">Đăng nhập</span> / <span>Đăng ký</span>
				</div>
				<div id="middle-right">
					<form>
						<input class="input-icon-email" type="text" placeholder="Email">
						<input class="input-icon-password" type="password" placeholder="Password">
						<input class="material-primary-button" type="submit" value="ĐĂNG NHẬP">
					</form>
				</div>
				<div id="footer-right">
					<img alt="icon_oval" src="<c:url value="/resources/image/icon_facebook.png" />"/>
					<img alt="icon_oval" src="<c:url value="/resources/image/icon_google.png" />"/>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="taglib/footer.jsp"/>
</body>
</html>