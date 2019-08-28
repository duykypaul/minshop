
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<div class="row">
	<c:forEach var="product" items="${productList}">
		<div class="col-md-3 col-sm-6">
			<div class="product wow zoomIn">
				<img src="<c:url value="/resources/image/products/${product.getImage()}" />" /><br />
				<span>${product.getName()}</span><br />
				<span class="price">${product.getPrice()} VNĐ</span>
			</div>
		</div>
	</c:forEach>
</div>
<%--<fmt:formatNumber type = "number" pattern="###,###" value="${product.getPrice()}" /> VNĐ--%>
<%--<fmt:setLocale value = "vi_VN"/>
 <fmt:formatNumber value = "${product.getPrice()}" type = "currency"/>--%>