
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../taglib/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Min Shop</title>
	<link rel="shortcut icon" href="<c:url value="/resources/image/logo.jpg" />">
	<jsp:include page="../taglib/web/header.jsp" />
</head>
<body>
	<div id="header" class="container-fluid">
		<jsp:include page="../common/web/header.jsp" />
	</div>
	<div id="info" class="container">
		<jsp:include page="../common/web/info.jsp" />
	</div>
	<div id="title-product" class="container">
		<span>SẢN PHẨM HOT</span>
		<jsp:include page="../common/web/list-product.jsp"/>
	</div>
	<div id="footer" class="container-fluid">
		<jsp:include page="../common/web/footer.jsp"/>
	</div>

	<jsp:include page="../taglib/web/footer.jsp" />
</body>
</html>
