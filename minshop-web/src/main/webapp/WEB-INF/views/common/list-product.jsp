
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@include file="../taglib/taglib.jsp"%>
<div class="row">
	<c:forEach var="product" items="${productList}">
		<div class="col-md-3 col-sm-6">
			<a href="<c:url value="/chi-tiet/${product.getProduct_id()}"/> ">
				<div class="product wow zoomIn">
					<img src="<c:url value="/resources/image/products/${product.getImage()}" />" /><br />
					<span>${product.getName()}</span><br />
					<span class="price"><fmt:formatNumber type = "number" pattern="###,###" value="${product.getPrice()}" /> đ</span>
				</div>
			</a>
		</div>
	</c:forEach>
</div>

