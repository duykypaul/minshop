<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="../taglib/taglib.jsp"%>
<c:url var="loginUrl" value="/dang-nhap/"/>
<c:url var="shoppingCartUrl" value="/gio-hang/"/>
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
            <a class="navbar-brand brand" href="/minshop"><img
                    src="<c:url value="/resources/image/minshop.png" />"/></a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse"
             id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav nav-center">
                <li class="active"><a href="/minshop">TRANG CHỦ</a></li>
                <li class="dropdown"><a href="#" class="dropdown-toggle"
                                        data-toggle="dropdown" role="button" aria-haspopup="true"
                                        aria-expanded="false">SẢN PHẨM <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <c:forEach var="productLine" items="${productLineList}">
                            <li ><a href="<c:url value="/san-pham/${productLine.getProduct_line_id()}"/>"
                                    style="color: #333 !important; font-weight: 700;">
                                    ${productLine.getName()} </a>
                            </li>
                            <li role="separator" class="divider"></li>
                        </c:forEach>
                    </ul>
                </li>
                <li><a href="#">DỊCH VỤ</a></li>
                <li><a href="#">LIÊN HỆ</a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <c:choose>
                    <c:when test="${email != null}">
                        <li><a href="#" class="circle-avatar"><span>${email.substring(0, 1).toUpperCase()}</span></a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="${loginUrl}">ĐĂNG NHẬP</a></li>
                    </c:otherwise>
                </c:choose>

                <li><a href="${shoppingCartUrl}">
                    <img src="<c:url value="/resources/image/cart-73-16.png" />"/>
                    <div id="cart"
                            <c:if test="${shoppingCartList.size() > 0}">
                                class="cart"
                            </c:if>>
                        <span><c:if test="${shoppingCartList.size() > 0}">
                            ${shoppingCartList.size()}
                        </c:if>
                        </span>
                    </div></a>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container-fluid -->
</nav>
<div class="event_header container wow rubberBand">
    <span>Ngày 17/10 - 23/10/2019</span><br/> <span
        style="font-size: 50px;">MUA 1 TẶNG 1</span><br/>
    <button class="btn-info">XEM NGAY</button>
</div>
