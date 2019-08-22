
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Min Shop</title>
	<jsp:include page="taglib/header.jsp" />
</head>
<body>
	<div id="header" class="container-fluid">
		<jsp:include page="home/header.jsp" />
	</div>
	<div id="info" class="container">
		<jsp:include page="home/info.jsp" />
	</div>
	<div id="title-product" class="container">
		<span>SẢN PHẨM HOT</span>
		<jsp:include page="home/list-product.jsp"/>
	</div>
	<div id="footer" class="container-fluid">
		<jsp:include page="home/footer.jsp"/>
	</div>

	<jsp:include page="taglib/footer.jsp" />
</body>
</html>