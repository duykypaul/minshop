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
				<div id="header-right" class="header-login-signup">
					<span id="header-login" class="actived">Đăng nhập</span> / <span id="header-signup">Đăng ký</span>
				</div>
				<div id="middle-right">
					<div id="middle-right" class="form-login">
						<input id="email" class="input-icon-email" type="text" placeholder="Email" name="email">
						<input id="password" class="input-icon-password" type="password" placeholder="Password" name="matkhau">
						<input id="login" class="material-primary-button" type="submit" value="ĐĂNG NHẬP" > <br />
					</div>
					<div id="middle-right" class="form-signup">
						<form action="" method="post">
							<input id="email" class="input-icon-email" type="text" placeholder="Email" name="email">
							<input id="password" class="input-icon-password" type="password" placeholder="Password" name="matkhau">
							<input id="confirm-password" class="input-icon-password" type="password" placeholder="Confirm password" name="confirmPassword">
							<input id="btn-signup" class="material-primary-button" type="submit" value="ĐĂNG KÝ" > <br />
						</form>
					</div>
					<span id="status_login">${status_login}</span>
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